package mc.sky3n3t.hexfuncs.forge

import mc.sky3n3t.hexfuncs.HexfuncsClient
import net.minecraftforge.client.ConfigScreenHandler.ConfigScreenFactory
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import thedarkcolour.kotlinforforge.forge.LOADING_CONTEXT

object ForgeHexfuncsClient {
    fun init(event: FMLClientSetupEvent) {
        HexfuncsClient.init()
        LOADING_CONTEXT.registerExtensionPoint(ConfigScreenFactory::class.java) {
            ConfigScreenFactory { _, parent -> HexfuncsClient.getConfigScreen(parent) }
        }
    }
}
