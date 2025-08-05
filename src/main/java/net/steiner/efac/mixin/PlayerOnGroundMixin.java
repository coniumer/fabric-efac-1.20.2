package net.steiner.efac.mixin;


import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.world.World;
import net.steiner.efac.networking.ModMessages;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Debug(export = true)
@Mixin(PlayerEntity.class)
public abstract class PlayerOnGroundMixin extends LivingEntity {
    protected PlayerOnGroundMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At("TAIL"))
    protected void injectTick(CallbackInfo info) {
        if (isOnGround() && MinecraftClient.getInstance().getNetworkHandler() != null) {
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeInt(0);
            ClientPlayNetworking.send(ModMessages.SET_DASH_USES_ID, buf);
        }
    }
}
