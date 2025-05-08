package net.steiner.efac.item.custom;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.steiner.efac.item.ModItems;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    CLUMB_MATERIA(59, 2.0f, 0.0f, MiningLevels.WOOD, 0,
            () -> Ingredient.ofItems(ModItems.CLUMB_MATERIA), 35, 5),
    ALEBEDIZED(250, 6.5f, 2.5f, MiningLevels.IRON, 0,
            () -> Ingredient.ofItems(ModItems.ALB_GEM), 25, 15),
    CITRINIZED(1561, 8.5f, 3.5f, MiningLevels.DIAMOND, 0,
            () -> Ingredient.ofItems(ModItems.ALB_GEM), 15, 25),
    RUBEDIZED(2031, 9.5f, 4.5f, MiningLevels.NETHERITE, 0,
            () -> Ingredient.ofItems(ModItems.ALB_GEM), 5, 35);

    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int miningLevel;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;
    private final int cooldown;
    private final int decay;

    ModToolMaterial(int itemDurability, float miningSpeed, float attackDamage, int miningLevel, int enchantability, Supplier<Ingredient> repairIngredient, int cooldown, int decay) {
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.miningLevel = miningLevel;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
        this.cooldown = cooldown;
        this.decay = decay;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public int getCooldown() {
        return this.cooldown;
    }

    // mfw unused stat
    public int getDecay() {
        return this.decay;
    }
}
