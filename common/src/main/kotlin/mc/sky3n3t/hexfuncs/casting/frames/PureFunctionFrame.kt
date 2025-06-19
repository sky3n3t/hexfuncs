package mc.sky3n3t.hexfuncs.casting.frames


import at.petrak.hexcasting.api.casting.SpellList
import at.petrak.hexcasting.api.casting.eval.CastResult
import at.petrak.hexcasting.api.casting.eval.ResolvedPatternType
import at.petrak.hexcasting.api.casting.eval.vm.CastingVM
import at.petrak.hexcasting.api.casting.eval.vm.ContinuationFrame
import at.petrak.hexcasting.api.casting.eval.vm.SpellContinuation
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.iota.ListIota
import at.petrak.hexcasting.api.utils.NBTBuilder
import at.petrak.hexcasting.api.utils.getList
import at.petrak.hexcasting.api.utils.serializeToNBT
import at.petrak.hexcasting.common.lib.hex.HexEvalSounds
import at.petrak.hexcasting.common.lib.hex.HexIotaTypes
import mc.sky3n3t.hexfuncs.casting.iotas.FunctionIota
import net.minecraft.nbt.CompoundTag
import net.minecraft.nbt.Tag
import net.minecraft.server.level.ServerLevel

data class PureFunctionFrame(val func: FunctionIota,val args:List<Iota>?) : ContinuationFrame{
    override val type: ContinuationFrame.Type<*>
        get() = TODO("Not yet implemented")

    override fun breakDownwards(stack: List<Iota>): Pair<Boolean, List<Iota>> {
        TODO("Not yet implemented")
    }

    override fun evaluate(
        continuation: SpellContinuation,
        level: ServerLevel,
        harness: CastingVM
    ): CastResult {
        TODO("Not yet implemented")
    }

    override fun serializeToNBT(): CompoundTag {
        TODO("Not yet implemented")
    }

    override fun size(): Int {
        TODO("Not yet implemented")
    }

}