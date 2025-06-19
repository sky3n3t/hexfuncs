package mc.sky3n3t.hexfuncs

import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import mc.sky3n3t.hexfuncs.config.HexfuncsConfig
import mc.sky3n3t.hexfuncs.networking.HexfuncsNetworking
import mc.sky3n3t.hexfuncs.registry.HexfuncsActions

object Hexfuncs {
    const val MODID = "hexfuncs"

    @JvmField
    val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic
    fun id(path: String) = ResourceLocation(MODID, path)

    fun init() {
        HexfuncsConfig.init()
        initRegistries(
            HexfuncsActions,
        )
        HexfuncsNetworking.init()
    }
}
