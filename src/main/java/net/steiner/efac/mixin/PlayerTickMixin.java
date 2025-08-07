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
import net.steiner.efac.util.CooldownData;
import net.steiner.efac.util.EntityDataSaver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerTickMixin extends LivingEntity {
    protected PlayerTickMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    private EntityDataSaver sPlayer = (EntityDataSaver) this;
    @Inject(method = "tick", at = @At("TAIL"))
    protected void injectTick(CallbackInfo info) {
        if (isOnGround() && MinecraftClient.getInstance().getNetworkHandler() != null) {
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeInt(0);
            ClientPlayNetworking.send(ModMessages.SET_DASH_USES_ID, buf);
        }
        if (sPlayer.getPersistentData().getInt(CooldownData.COOLDOWN_PROGRESS_KEY) <= CooldownData.COOLDOWN_MAX && MinecraftClient.getInstance().getNetworkHandler() != null && this.getWorld().isClient) {
            PacketByteBuf cooldownBuf = PacketByteBufs.create();
            cooldownBuf.writeInt(sPlayer.getPersistentData().getInt(CooldownData.COOLDOWN_PROGRESS_KEY) + 1);
            ClientPlayNetworking.send(ModMessages.SET_COOLDOWN_PROGRESS_ID, cooldownBuf);
        }
    }
}
