@file:JvmName("HexfuncsAbstractionsImpl")

package mc.sky3n3t.hexfuncs.fabric

import mc.sky3n3t.hexfuncs.registry.HexfuncsRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: HexfuncsRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
