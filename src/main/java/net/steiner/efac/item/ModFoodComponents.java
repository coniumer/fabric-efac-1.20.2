package net.steiner.efac.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {
    public static final FoodComponent CLUMB_MATERIA = new FoodComponent.Builder().hunger(0).saturationModifier(0)
            .snack().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 500), 1f).build();
    public static final FoodComponent BUTTER_STICK = new FoodComponent.Builder().hunger(2).saturationModifier(1.2f)
            .build();
    public static final FoodComponent CLUMBELON = new FoodComponent.Builder().hunger(2).saturationModifier(0.4f)
            .snack().alwaysEdible().build();
    public static final FoodComponent CLUMBKIE = new FoodComponent.Builder().hunger(2).saturationModifier(0.2f)
            .snack().alwaysEdible().build();
    public static final FoodComponent BLUMB = new FoodComponent.Builder().hunger(5).saturationModifier(0.7f)
            .snack().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100), 0.2f).build();
    public static final FoodComponent CLUMBROT = new FoodComponent.Builder().hunger(3).saturationModifier(0.8f)
            .alwaysEdible().build();
    public static final FoodComponent GOLD_CLUMBROT = new FoodComponent.Builder().hunger(6).saturationModifier(1.7f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 0), 1.0F)
            .build();
    public static final FoodComponent CLUMBLE = new FoodComponent.Builder().hunger(4).saturationModifier(0.4f)
            .alwaysEdible().build();
    public static final FoodComponent GOLD_CLUMBLE = new FoodComponent.Builder().hunger(4).saturationModifier(1.3f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0), 1.0F)
            .build();
    public static final FoodComponent CLUMBURGER = new FoodComponent.Builder().hunger(8).saturationModifier(0.9f)
            .meat().alwaysEdible().build();
}
