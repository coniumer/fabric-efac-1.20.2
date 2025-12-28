package net.steiner.efac.mixin;


import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.world.World;
import net.steiner.efac.entity.effect.ModEffects;
import net.steiner.efac.item.ModItems;
import net.steiner.efac.networking.ModMessages;
import net.steiner.efac.util.EntityDataSaver;
import net.steiner.efac.util.MouthData;
import net.steiner.efac.util.RegenData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerTickMixin extends LivingEntity {
    @Shadow @Final private PlayerAbilities abilities;

    protected PlayerTickMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At("TAIL"))
    protected void injectTick(CallbackInfo info) {
        //enable flight
        updateFlight();

        //dash uses
        if (isOnGround() && MinecraftClient.getInstance().getNetworkHandler() != null) {
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeInt(0);
            ClientPlayNetworking.send(ModMessages.SET_DASH_USES_ID, buf);
        }

        //mouth inventory
        MouthData mPlayer = (MouthData) this;
        mPlayer.updateMouth();

        //tooth regen
        if (this.hasStatusEffect(ModEffects.TOOTH_REGEN)) {
            EntityDataSaver sPlayer = (EntityDataSaver)this;
            StatusEffectInstance regen = this.getStatusEffect(ModEffects.TOOTH_REGEN);

            int maxProgress = RegenData.TRUE_MAX_KEY / regen.getAmplifier();
            PacketByteBuf maxBuf = PacketByteBufs.create();
            maxBuf.writeInt(maxProgress);
            ClientPlayNetworking.send(ModMessages.SET_MAX_REGEN_PROGRESS_ID, maxBuf);

            int progress = sPlayer.getPersistentData().getInt(RegenData.REGEN_PROGRESS_KEY);
            progress++;
            PacketByteBuf progBuf = PacketByteBufs.create();
            progBuf.writeInt(progress);
            ClientPlayNetworking.send(ModMessages.SET_REGEN_PROGRESS_ID, progBuf);

            if (sPlayer.getPersistentData().getInt(RegenData.REGEN_PROGRESS_KEY) >= sPlayer.getPersistentData().getInt(RegenData.MAX_REGEN_PROGRESS_KEY)) {
                regenerate();
                resetProgress();
            }
        }
    }

    @Unique
    private void updateFlight() {
        ItemStack boots = this.getEquippedStack(EquipmentSlot.FEET);
        if (boots.isOf(ModItems.PHILOSOPHERS_BOOTS)) {
            this.abilities.allowFlying = true;
        }
    }

    @Unique
    private void resetProgress() {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeInt(0);
        ClientPlayNetworking.send(ModMessages.SET_REGEN_PROGRESS_ID, buf);
    }

    @Unique
    private void regenerate() {
        if (this.getHealth() < this.getMaxHealth()) {
            this.heal(1.0F);
        }
    }

}
