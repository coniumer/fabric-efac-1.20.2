package net.steiner.efac.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.steiner.efac.util.ClumbCharge;
import net.steiner.efac.util.EntityDataSaver;
import net.steiner.efac.util.ModTags;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// TODO: ability to increase max clumb charge amount

@Debug(export = true)
@Mixin(PlayerEntity.class)
public abstract class PlayerClumbMixin implements ClumbCharge {
    @Unique
    private int clumbCharges = 5;
    @Unique
    private int currentMaxClumbCharges = 5;
    @Unique
    private final int maxClumbCharges = 40;
    @Unique
    EntityDataSaver sPlayer = (EntityDataSaver)this;



    @Inject(method = "eatFood", at = @At("TAIL"))
    protected void injectOnEat(World world, ItemStack stack, CallbackInfoReturnable<ItemStack> info) {

        if (stack.isIn(ModTags.Items.IS_CLUMB_FOOD)) {
            int clumbCharges = this.getClumbCharges();
            clumbCharges++;
            setClumbCharges(clumbCharges);
        }
    }

    @Override
    public int getClumbCharges() {
        this.clumbCharges = sPlayer.getPersistentData().getInt("charges");
        return clumbCharges;
    }

    @Override
    public void setClumbCharges(int clumbCharges) {
        this.clumbCharges = MathHelper.clamp(clumbCharges, 0, currentMaxClumbCharges);
        sPlayer.getPersistentData().putInt("charges", this.clumbCharges);
    }

    @Override
    public boolean canClumb() {
        if (this.getClumbCharges() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
