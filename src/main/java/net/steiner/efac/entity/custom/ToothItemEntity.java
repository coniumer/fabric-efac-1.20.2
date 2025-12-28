package net.steiner.efac.entity.custom;

import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.steiner.efac.entity.ModEntities;
import net.steiner.efac.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class ToothItemEntity extends ThrownItemEntity {
    private float attackDamage;
    @Nullable
    private StatusEffectInstance statusEffectInstance;
    public ToothItemEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ToothItemEntity(LivingEntity livingEntity, World world, float attackDamage, @Nullable StatusEffectInstance statusEffectInstance) {
        super(ModEntities.TOOTH_ITEM_ENTITY, livingEntity, world);
        this.attackDamage = attackDamage;
        this.statusEffectInstance = statusEffectInstance;
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.TOOTH;
    }

    private ParticleEffect getParticleParameters() {
        ItemStack itemStack = this.getItem();
        return (ParticleEffect)(itemStack.isEmpty() ? ParticleTypes.ITEM : new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack));
    }

    @Override
    public void handleStatus(byte status) {
        if (status == EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES) {
            ParticleEffect particleEffect = this.getParticleParameters();

            for (int i = 0; i < 8; i++) {
                this.getWorld().addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            }
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (this.getOwner() instanceof LivingEntity livingEntity) {
            entityHitResult.getEntity().damage(this.getDamageSources().mobProjectile(this, livingEntity), attackDamage);
        }
        if (statusEffectInstance != null && entityHitResult.getEntity() instanceof LivingEntity livingEntity) {
            livingEntity.addStatusEffect(statusEffectInstance);
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.discard();
        }
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }
}
