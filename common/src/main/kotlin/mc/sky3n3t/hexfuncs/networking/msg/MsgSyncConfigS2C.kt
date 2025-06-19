package mc.sky3n3t.hexfuncs.networking.msg

import mc.sky3n3t.hexfuncs.config.HexfuncsConfig
import net.minecraft.network.FriendlyByteBuf

data class MsgSyncConfigS2C(val serverConfig: HexfuncsConfig.ServerConfig) : HexfuncsMessageS2C {
    companion object : HexfuncsMessageCompanion<MsgSyncConfigS2C> {
        override val type = MsgSyncConfigS2C::class.java

        override fun decode(buf: FriendlyByteBuf) = MsgSyncConfigS2C(
            serverConfig = HexfuncsConfig.ServerConfig.decode(buf),
        )

        override fun MsgSyncConfigS2C.encode(buf: FriendlyByteBuf) {
            serverConfig.encode(buf)
        }
    }
}
