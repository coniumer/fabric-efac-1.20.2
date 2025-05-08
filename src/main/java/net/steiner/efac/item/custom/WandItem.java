package net.steiner.efac.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.steiner.efac.entity.custom.ClumbProjectileEntity;

public class WandItem extends Item {
    private final ToolMaterial material;
    private final ModToolMaterial modMaterial;

    // constructor from idk where probably some tool
    public WandItem(ToolMaterial material, ModToolMaterial modMaterial, Item.Settings settings) {
        super(settings.maxDamageIfAbsent(material.getDurability()));
        this.material = material;
        this.modMaterial = modMaterial;
    }

    // idk what i'm doing
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        // you have the wand in your hand and now my code knows it
        ItemStack itemStack = user.getStackInHand(hand);
        // TODO original sound for clumbing
        world.playSound(
                null,
                user.getX(),
                user.getY(),
                user.getZ(),
                SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE,
                SoundCategory.NEUTRAL,
                0.7F,
                1.25F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
        );

        if (!world.isClient) {
            // spawns clumb projectile???
            ClumbProjectileEntity clumbProjectileEntity = new ClumbProjectileEntity(user, world, modMaterial);
            clumbProjectileEntity.setItem(itemStack);
            clumbProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.2F, 0.5F);
            world.spawnEntity(clumbProjectileEntity);
        }

        // cooldown so it's not OP
        user.getItemCooldownManager().set(this, modMaterial.getCooldown());
        // Usage stats
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        // Damage item
        if (!user.getAbilities().creativeMode) {
            itemStack.damage(1, user, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }
        // play use animation
        return TypedActionResult.success(itemStack, world.isClient());
    }

}