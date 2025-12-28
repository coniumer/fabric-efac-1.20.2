package net.steiner.efac.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.steiner.efac.sound.ModSounds;
import net.steiner.efac.util.ClumbData;
import net.steiner.efac.util.EntityDataSaver;
import net.steiner.efac.util.ModTags;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MiningToolItem.class)
public class PostMineMixin {

    @Inject(method = "postMine", at = @At("TAIL"))
    protected void injectPostMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner, CallbackInfoReturnable<Boolean> info) {
        EntityDataSaver sPlayer = (EntityDataSaver)miner;
        int chance;

        if (state.isIn(ModTags.Blocks.PROVIDES_CHARGE_RARE)) {
            chance = 1;
        } else if (state.isIn(ModTags.Blocks.PROVIDES_CHARGE_COMMON)) {
            chance = 5;
        } else if (state.isIn(ModTags.Blocks.PROVIDES_CHARGE_ALWAYS)) {
            chance = 10;
        } else {
            chance = 0;
        }

        if (tryCharge(world, chance)) {
            ClumbData.addClumbCharges(sPlayer, 1, sPlayer.getPersistentData().getInt(ClumbData.MAX_CLUMB_CHARGE_KEY));
            world.playSound(
                    null,
                    miner.getX(),
                    miner.getY(),
                    miner.getZ(),
                    ModSounds.SWORD_CHARGE,
                    SoundCategory.PLAYERS,
                    0.7F,
                    2.5F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
            );
        }
    }

    @Unique
    private boolean tryCharge(World world, int chance) {
        return (Math.abs(world.getRandom().nextInt()) % 10) < chance;
    }
}
