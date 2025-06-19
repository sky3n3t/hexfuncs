package mc.sky3n3t.hexfuncs.fabric

import mc.sky3n3t.hexfuncs.HexfuncsClient
import net.fabricmc.api.ClientModInitializer

object FabricHexfuncsClient : ClientModInitializer {
    override fun onInitializeClient() {
        HexfuncsClient.init()
    }
}
