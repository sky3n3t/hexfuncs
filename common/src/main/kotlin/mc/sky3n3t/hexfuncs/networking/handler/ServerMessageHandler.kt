package mc.sky3n3t.hexfuncs.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import mc.sky3n3t.hexfuncs.networking.msg.*

fun HexfuncsMessageC2S.applyOnServer(ctx: PacketContext) = ctx.queue {
    // NOTE: this is commented out because otherwise it fails to compile if there's nothing inside of the when expression
    /*
    when (this) {
        // add server-side message handlers here
    }
    */
}
