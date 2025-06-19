package mc.sky3n3t.hexfuncs.fabric

import mc.sky3n3t.hexfuncs.Hexfuncs
import net.fabricmc.api.ModInitializer

object FabricHexfuncs : ModInitializer {
    override fun onInitialize() {
        Hexfuncs.init()
    }
}
