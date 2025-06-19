package mc.sky3n3t.hexfuncs.casting.iotas
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.iota.IotaType
import at.petrak.hexcasting.api.casting.mishaps.MishapInvalidIota
import at.petrak.hexcasting.api.casting.mishaps.MishapNotEnoughArgs
import net.minecraft.nbt.CompoundTag
import net.minecraft.nbt.Tag
import net.minecraft.server.level.ServerLevel

class FunctionIota() : Iota<TYPE,function>{
    companion object {
        @JvmField
        val TYPE: IotaType<FunctionIota> = object : IotaType<FunctionIota>() {
            override fun deserialize(nbt: Tag, world: ServerLevel) = null
            override fun display(nbt: Tag) = null
            override fun color() = -0x591c5f
        }
    }
}