package mc.sky3n3t.hexfuncs.forge

import dev.architectury.platform.forge.EventBuses
import mc.sky3n3t.hexfuncs.Hexfuncs
import net.minecraft.data.DataProvider
import net.minecraft.data.DataProvider.Factory
import net.minecraft.data.PackOutput
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(Hexfuncs.MODID)
class HexfuncsForge {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(Hexfuncs.MODID, this)
            addListener(ForgeHexfuncsClient::init)
            addListener(::gatherData)
        }
        Hexfuncs.init()
    }

    private fun gatherData(event: GatherDataEvent) {
        event.apply {
            // TODO: add datagen providers here
        }
    }
}

fun <T : DataProvider> GatherDataEvent.addProvider(run: Boolean, factory: (PackOutput) -> T) =
    generator.addProvider(run, Factory { factory(it) })
