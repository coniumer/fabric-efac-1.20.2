package net.steiner.efac.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.steiner.efac.sound.ModSounds;
import net.steiner.efac.util.ClumbData;
import net.steiner.efac.util.EntityDataSaver;
import net.steiner.efac.util.ModDamage;

public class ClumbSwordItem extends SwordItem {
    private final ModToolMaterial modMaterial;
    private boolean chargeMode;

    public ClumbSwordItem(ToolMaterial toolMaterial, ModToolMaterial modMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.modMaterial = modMaterial;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.getItemCooldownManager().set(this, modMaterial.getCooldown());
        if (world.isClient) {
            chargeMode ^= true;
        }
        if (chargeMode) {
            world.playSound(
                    null,
                    user.getX(),
                    user.getY(),
                    user.getZ(),
                    ModSounds.SWORD_CHARGE,
                    SoundCategory.PLAYERS,
                    0.7F,
                    0.95F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
            );
        } else {
            world.playSound(
                    null,
                    user.getX(),
                    user.getY(),
                    user.getZ(),
                    ModSounds.SWORD_PULSE,
                    SoundCategory.PLAYERS,
                    0.7F,
                    0.95F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
            );
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getWorld();
        EntityDataSaver sPlayer = (EntityDataSaver)attacker;
        PlayerEntity player = (PlayerEntity)attacker;

        DamageSource source = new DamageSource(
                world.getRegistryManager()
                        .get(RegistryKeys.DAMAGE_TYPE)
                        .entryOf(ModDamage.CLUMB_PULSE_DAMAGE)
        );

        if (chargeMode && tryCharge(world)) {
            ClumbData.addClumbCharges(sPlayer, 1, sPlayer.getPersistentData().getInt("maxClumbCharges"));
            world.playSound(
                    null,
                    attacker.getX(),
                    attacker.getY(),
                    attacker.getZ(),
                    ModSounds.SWORD_CHARGE,
                    SoundCategory.PLAYERS,
                    1F,
                    2.5F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
            );
        } else if ((sPlayer.canClumb(sPlayer.getPersistentData().getInt("clumbCharges"), sPlayer) || player.getAbilities().creativeMode) && !chargeMode) {
            target.damage(source, modMaterial.getAttackDamage());
            if (!player.getAbilities().creativeMode) {
                ClumbData.removeClumbCharges(sPlayer, 1, sPlayer.getPersistentData().getInt("maxClumbCharges"));
            }
            world.playSound(
                    null,
                    attacker.getX(),
                    attacker.getY(),
                    attacker.getZ(),
                    ModSounds.SWORD_PULSE,
                    SoundCategory.PLAYERS,
                    1F,
                    2.5F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
            );
        }
        return super.postHit(stack, target, attacker);
    }

    public boolean tryCharge(World world) {
        return (Math.abs(world.getRandom().nextInt()) % 10) > 7;
    }
}
