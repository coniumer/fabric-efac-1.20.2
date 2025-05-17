package net.steiner.efac.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.steiner.efac.util.EntityDataSaver;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Debug(export = true)
@Mixin(Entity.class)
public abstract class EntityDataSaverMixin implements EntityDataSaver {
    @Unique
    private NbtCompound persistentData;

    @Override
    public NbtCompound getPersistentData() {
        if(this.persistentData == null) {
            this.persistentData = new NbtCompound();
        }
        return persistentData;
    }

    @Inject(method = "writeNbt", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;getVelocity()Lnet/minecraft/util/math/Vec3d;"))
    protected void injectWriteNbt(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> info) {
        if (persistentData != null) {
            nbt.put("SteinerData", persistentData);
            // System.out.println("EFAC wrote NBT data");
        }
    }

    @Inject(method = "readNbt", at = @At(value = "INVOKE", target = "Lnet/minecraft/nbt/NbtCompound;getList(Ljava/lang/String;I)Lnet/minecraft/nbt/NbtList;", ordinal = 0))
    protected void injectReadNbt(NbtCompound nbt, CallbackInfo info) {
        if (nbt.contains("SteinerData", 10)) {
            persistentData = nbt.getCompound("SteinerData");
            // System.out.println("EFAC read NBT data");
        }
    }

    @Override
    public boolean canClumb(int clumbCharges, EntityDataSaver player) {
        return player.getPersistentData().getInt("clumbCharges") > 0;
    }

}
