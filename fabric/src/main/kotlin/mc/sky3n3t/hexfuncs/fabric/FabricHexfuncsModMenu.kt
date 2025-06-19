package mc.sky3n3t.hexfuncs.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import mc.sky3n3t.hexfuncs.HexfuncsClient

object FabricHexfuncsModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(HexfuncsClient::getConfigScreen)
}
