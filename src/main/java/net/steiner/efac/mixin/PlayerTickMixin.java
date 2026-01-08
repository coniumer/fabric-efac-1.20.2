package net.steiner.efac.mixin;


import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import net.steiner.efac.entity.effect.ModEffects;
import net.steiner.efac.item.ModItems;
import net.steiner.efac.networking.ModMessages;
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

@Mixin(PlayerEntity.class)
public abstract class PlayerTickMixin extends LivingEntity {
    @Shadow @Final private PlayerAbilities abilities;
    @Unique private static final TrackedData<Integer> BEAM_TARGET_ID = DataTracker.registerData(PlayerTickMixin.class, TrackedDataHandlerRegistry.INTEGER);
    @Nullable private LivingEntity target;
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

    @Unique
    void setBeamTarget(int entityId) {
        this.dataTracker.set(BEAM_TARGET_ID, entityId);
    }

    @Unique
    public boolean hasBeamTarget() {
        return this.dataTracker.get(BEAM_TARGET_ID) != 0;
    }

    @Unique @Nullable
    public LivingEntity getBeamTarget() {
        if (!this.hasBeamTarget()) {
            return null;
        } else if (this.getWorld().isClient) {
            if (this.cachedBeamTarget != null) {
                return this.cachedBeamTarget;
            } else {
                Entity entity = this.getWorld().getEntityById(this.dataTracker.get(BEAM_TARGET_ID));
                if (entity instanceof LivingEntity) {
                    this.cachedBeamTarget = (LivingEntity)entity;
                    return this.cachedBeamTarget;
                } else {
                    return null;
                }
            }
        } else {
            return this.target;
        }
    }

    @Override
    public void onTrackedDataSet(TrackedData<?> data) {
        super.onTrackedDataSet(data);
        if (BEAM_TARGET_ID.equals(data)) {
            this.beamTicks = 0;
            this.cachedBeamTarget = null;
        }
    }

    @Unique
    public float getBeamProgress(float tickDelta) {
        return ((float)this.beamTicks + tickDelta) / (float) WARMUP_TIME;
    }

    @Unique
    public void handleBeam() {
        if (this.hasBeamTarget()) {
            if (this.beamTicks < WARMUP_TIME) {
                this.beamTicks++;
            }

            LivingEntity livingEntity = this.getBeamTarget();
            if (livingEntity != null) {
                double d = (double)this.getBeamProgress(0.0F);
                double e = livingEntity.getX() - this.getX();
                double f = livingEntity.getBodyY(0.5) - this.getEyeY();
                double g = livingEntity.getZ() - this.getZ();
                double h = Math.sqrt(e * e + f * f + g * g);
                e /= h;
                f /= h;
                g /= h;
                double j = this.random.nextDouble();

                while (j < h) {
                    j += 1.8 - d + this.random.nextDouble() * (1.7 - d);
                    this.getWorld().addParticle(ParticleTypes.BUBBLE, this.getX() + e * j, this.getEyeY() + f * j, this.getZ() + g * j, 0.0, 0.0, 0.0);
                }
            }
        }
    }

    @Unique
    public void start() {
        this.beamTicks = -10;
    }

    @Unique
    public void stop() {
        this.setBeamTarget(0);
    }

}
