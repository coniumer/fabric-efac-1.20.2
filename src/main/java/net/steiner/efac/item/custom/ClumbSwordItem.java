package net.steiner.efac.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.steiner.efac.sound.ModSounds;

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
        if (!world.isClient) {
            chargeMode = !chargeMode;
        }

        user.getItemCooldownManager().set(this, modMaterial.getCooldown());
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

        return TypedActionResult.success(itemStack, world.isClient());
    }

}
