package mc.sky3n3t.hexfuncs.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import mc.sky3n3t.hexfuncs.config.HexfuncsConfig
import mc.sky3n3t.hexfuncs.networking.msg.*

fun HexfuncsMessageS2C.applyOnClient(ctx: PacketContext) = ctx.queue {
    when (this) {
        is MsgSyncConfigS2C -> {
            HexfuncsConfig.onSyncConfig(serverConfig)
        }

        // add more client-side message handlers here
    }
}
