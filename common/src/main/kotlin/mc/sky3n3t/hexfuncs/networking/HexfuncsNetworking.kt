package mc.sky3n3t.hexfuncs.networking

import dev.architectury.networking.NetworkChannel
import mc.sky3n3t.hexfuncs.Hexfuncs
import mc.sky3n3t.hexfuncs.networking.msg.HexfuncsMessageCompanion

object HexfuncsNetworking {
    val CHANNEL: NetworkChannel = NetworkChannel.create(Hexfuncs.id("networking_channel"))

    fun init() {
        for (subclass in HexfuncsMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
