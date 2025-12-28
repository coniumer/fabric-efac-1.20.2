package net.steiner.efac.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.steiner.efac.entity.custom.ToothItemEntity;
import org.jetbrains.annotations.Nullable;

public class ToothItem extends Item {
    private final float attackDamage;
    @Nullable
    private final StatusEffectInstance statusEffectInstance;

    public ToothItem(float attackDamage, @Nullable StatusEffectInstance statusEffectInstance, Settings settings) {
        super(settings);
        this.attackDamage = attackDamage;
        this.statusEffectInstance = statusEffectInstance;
    }

    public ToothItem(float attackDamage, Settings settings) {
        super(settings);
        this.attackDamage = attackDamage;
        statusEffectInstance = null;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(
                null,
                user.getX(),
                user.getY(),
                user.getZ(),
                SoundEvents.ENTITY_SNOWBALL_THROW,
                SoundCategory.NEUTRAL,
                0.3F,
                2F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
        );
        if (!world.isClient) {
            ToothItemEntity toothItemEntity = createToothItemEntity(user, world);
            toothItemEntity.setItem(itemStack);
            toothItemEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(toothItemEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    private ToothItemEntity createToothItemEntity(PlayerEntity user, World world) {
        return new ToothItemEntity(user, world, attackDamage, statusEffectInstance);
    }
}
