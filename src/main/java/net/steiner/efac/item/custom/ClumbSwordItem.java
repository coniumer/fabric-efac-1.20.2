package net.steiner.efac.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

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
        System.out.println("Mode = " + mode(chargeMode));
        return TypedActionResult.success(itemStack, world.isClient());
    }

    private String mode(boolean chargeMode) {
        if (chargeMode) { return "Charge Mode"; }
        else { return "Attack Mode"; }
    }
}
