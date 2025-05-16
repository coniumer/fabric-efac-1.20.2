package net.steiner.efac.mixin;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.steiner.efac.networking.ModMessages;
import net.steiner.efac.util.ModTags;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Debug(export = true)
@Mixin(PlayerEntity.class)
public abstract class PlayerEatMixin {
    @Inject(method = "eatFood", at = @At("TAIL"))
    protected void injectOnEat(World world, ItemStack stack, CallbackInfoReturnable<ItemStack> info) {
        if (stack.isIn(ModTags.Items.IS_CLUMB_FOOD)) {
            ClientPlayNetworking.send(ModMessages.CLUMB_RECHARGE_ID, PacketByteBufs.create());
        }
    }
}
