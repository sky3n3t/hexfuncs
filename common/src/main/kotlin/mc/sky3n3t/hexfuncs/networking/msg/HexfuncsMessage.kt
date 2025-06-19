package mc.sky3n3t.hexfuncs.networking.msg

import dev.architectury.networking.NetworkChannel
import dev.architectury.networking.NetworkManager.PacketContext
import mc.sky3n3t.hexfuncs.Hexfuncs
import mc.sky3n3t.hexfuncs.networking.HexfuncsNetworking
import mc.sky3n3t.hexfuncs.networking.handler.applyOnClient
import mc.sky3n3t.hexfuncs.networking.handler.applyOnServer
import net.fabricmc.api.EnvType
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer
import java.util.function.Supplier

sealed interface HexfuncsMessage

sealed interface HexfuncsMessageC2S : HexfuncsMessage {
    fun sendToServer() {
        HexfuncsNetworking.CHANNEL.sendToServer(this)
    }
}

sealed interface HexfuncsMessageS2C : HexfuncsMessage {
    fun sendToPlayer(player: ServerPlayer) {
        HexfuncsNetworking.CHANNEL.sendToPlayer(player, this)
    }

    fun sendToPlayers(players: Iterable<ServerPlayer>) {
        HexfuncsNetworking.CHANNEL.sendToPlayers(players, this)
    }
}

sealed interface HexfuncsMessageCompanion<T : HexfuncsMessage> {
    val type: Class<T>

    fun decode(buf: FriendlyByteBuf): T

    fun T.encode(buf: FriendlyByteBuf)

    fun apply(msg: T, supplier: Supplier<PacketContext>) {
        val ctx = supplier.get()
        when (ctx.env) {
            EnvType.SERVER, null -> {
                Hexfuncs.LOGGER.debug("Server received packet from {}: {}", ctx.player.name.string, this)
                when (msg) {
                    is HexfuncsMessageC2S -> msg.applyOnServer(ctx)
                    else -> Hexfuncs.LOGGER.warn("Message not handled on server: {}", msg::class)
                }
            }
            EnvType.CLIENT -> {
                Hexfuncs.LOGGER.debug("Client received packet: {}", this)
                when (msg) {
                    is HexfuncsMessageS2C -> msg.applyOnClient(ctx)
                    else -> Hexfuncs.LOGGER.warn("Message not handled on client: {}", msg::class)
                }
            }
        }
    }

    fun register(channel: NetworkChannel) {
        channel.register(type, { msg, buf -> msg.encode(buf) }, ::decode, ::apply)
    }
}
