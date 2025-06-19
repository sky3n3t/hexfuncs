@file:JvmName("HexfuncsAbstractions")

package mc.sky3n3t.hexfuncs

import dev.architectury.injectables.annotations.ExpectPlatform
import mc.sky3n3t.hexfuncs.registry.HexfuncsRegistrar

fun initRegistries(vararg registries: HexfuncsRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: HexfuncsRegistrar<T>) {
    throw AssertionError()
}
