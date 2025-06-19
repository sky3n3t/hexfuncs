@file:JvmName("HexfuncsAbstractionsImpl")

package mc.sky3n3t.hexfuncs.forge

import mc.sky3n3t.hexfuncs.registry.HexfuncsRegistrar
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

fun <T : Any> initRegistry(registrar: HexfuncsRegistrar<T>) {
    MOD_BUS.addListener { event: RegisterEvent ->
        event.register(registrar.registryKey) { helper ->
            registrar.init(helper::register)
        }
    }
}
