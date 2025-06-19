package mc.sky3n3t.hexfuncs

import mc.sky3n3t.hexfuncs.config.HexfuncsConfig
import mc.sky3n3t.hexfuncs.config.HexfuncsConfig.GlobalConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object HexfuncsClient {
    fun init() {
        HexfuncsConfig.initClient()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(GlobalConfig::class.java, parent).get()
    }
}
