package net.steiner.efac.mixin;

import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.steiner.efac.sound.ModSounds;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

//@Debug(export = true)
@Mixin(BedBlock.class)
public abstract class ReadyForBedMixin {

    @Inject(method = "onUse", at = @At("TAIL"))
    protected void injectOnUse(BlockState state, @NotNull World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> info) {
        if (player.isSleeping()) {
            player.sendMessage(Text.literal("Ready for Bed!"));
            world.playSound(null, pos, ModSounds.READY_FOR_BED, SoundCategory.BLOCKS, 1f, 1f);
        }
    }

}