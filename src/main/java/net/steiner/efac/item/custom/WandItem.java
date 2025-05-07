package net.steiner.efac.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class WandItem extends Item {
    private final ToolMaterial material;
    private final ModToolMaterial modMaterial;

    public WandItem(ToolMaterial material, ModToolMaterial modMaterial, Item.Settings settings) {
        super(settings.maxDamageIfAbsent(material.getDurability()));
        this.material = material;
        this.modMaterial = modMaterial;
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
                0.5F,
                0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
        );
        if (!world.isClient) {
            SnowballEntity snowballEntity = new SnowballEntity(world, user);
            snowballEntity.setItem(itemStack);
            snowballEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(snowballEntity);
        }
        user.getItemCooldownManager().set(this, modMaterial.getCooldown());
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.damage(1, user, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

}