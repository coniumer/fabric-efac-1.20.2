package net.steiner.efac.mixin;


import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.world.World;
import net.steiner.efac.entity.effect.ModEffects;
import net.steiner.efac.item.ModItems;
import net.steiner.efac.networking.ModMessages;
import net.steiner.efac.util.BeamHelper;
import net.steiner.efac.util.EntityDataSaver;
import net.steiner.efac.util.MouthData;
import net.steiner.efac.util.RegenData;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(PlayerEntity.class)
public abstract class PlayerTickMixin extends LivingEntity implements BeamHelper {
    @Shadow @Final private PlayerAbilities abilities;
    @Unique private static final TrackedData<Integer> BEAM_TARGET_ID = DataTracker.registerData(PlayerTickMixin.class, TrackedDataHandlerRegistry.INTEGER);
    @Unique @Nullable private LivingEntity beamTarget;
    @Unique @Nullable private LivingEntity cachedBeamTarget;
    @Unique private int beamTicks;
    @Unique private final int WARMUP_TIME = 80;

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
        updateRegen();

        //beams
        if (this.isAlive() && this.getWorld().isClient && this.hasStatusEffect(ModEffects.BEAMS)) {
            //TODO: finish beams
            StatusEffectInstance beams = this.getStatusEffect(ModEffects.BEAMS);

            assert beams != null;
            int mod = beams.getAmplifier();

            //System.out.println("target = " + beamTarget); //DEBUG, REMOVE
            updateBeams(mod);
        }
    }

    @Unique
    private void updateBeams(int mod) {
        if (beamTarget != null) {
            if (!this.canSee(beamTarget)) {
                setBeamTarget(null);
            } else {
                this.beamTicks++;
                if (this.beamTicks <= 0) {
                    if (!this.isSilent()) {
                        this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_GUARDIAN_ATTACK_SOUND);
                    }
                } else if (this.beamTicks >= WARMUP_TIME) {
                    int amount = (2 * mod) + 1;
                    PacketByteBuf buf = PacketByteBufs.create();
                    buf.writeInt(amount);
                    ClientPlayNetworking.send(ModMessages.BEAM_PAYLOAD_ID, buf);
                    resetBeamTicks();
                }
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
    private void resetRegenProgress() {
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
    @Unique
    private void updateRegen() {
        if (this.hasStatusEffect(ModEffects.TOOTH_REGEN)) {
            EntityDataSaver sPlayer = (EntityDataSaver)this;
            StatusEffectInstance regen = this.getStatusEffect(ModEffects.TOOTH_REGEN);

            assert regen != null;
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
                resetRegenProgress();
            }
        }
    }

    @Inject(method = "attack", at = @At("TAIL"))
    protected void injectAttack(Entity target, CallbackInfo info) {
        if (target instanceof LivingEntity) {
            setBeamTarget((LivingEntity) target);
            if (hasVenom()) {
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200,
                        Objects.requireNonNull(this.getStatusEffect(ModEffects.VENOM)).getAmplifier(), true, true));
            }
        }
    }
    @Override
    public void setBeamTarget(@Nullable LivingEntity beamTarget) {
        this.beamTarget = beamTarget;
    }
    @Override
    public @Nullable LivingEntity getBeamTarget() {
        return beamTarget;
    }
    @Override
    public void resetBeamTicks() {
        this.beamTicks = 0;
    }

    @Unique
    private boolean  hasVenom() {
        return this.hasStatusEffect(ModEffects.VENOM);
    }
}
