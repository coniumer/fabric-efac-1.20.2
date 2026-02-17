package net.steiner.efac.entity.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;

public class ModEffects {
    //get new UUIDs at https://www.uuidtools.com/minecraft
    public static StatusEffect FREEZE;

    public static StatusEffect TOOTH_SPEED;
    public static StatusEffect TOOTH_STRENGTH;
    public static StatusEffect TOOTH_RESISTANCE;
    public static StatusEffect TOOTH_REGEN;
    public static StatusEffect TOOTH_SLOWNESS;
    public static StatusEffect FATIGUE;
    public static StatusEffect HASTE;
    public static StatusEffect BEAMS;
    public static StatusEffect VENOM;

    public static StatusEffect registerFreezeEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(EFAC.MOD_ID, name),
                new FreezeEffect(StatusEffectCategory.HARMFUL, 3124687));
    }

    public static StatusEffect registerToothSpeedEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(EFAC.MOD_ID, name),
                new ToothEffect(StatusEffectCategory.BENEFICIAL, 3124687).addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "3342afb7-7d33-4c86-8fed-fd12708a9064", 0.01F, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
    }
    public static StatusEffect registerToothStrengthEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(EFAC.MOD_ID, name),
                new ToothEffect(StatusEffectCategory.BENEFICIAL, 3124687).addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "fc6b6860-ceb0-43de-abf0-d784f6e1fcc1", 0.5F, EntityAttributeModifier.Operation.ADDITION));
    }
    public static StatusEffect registerToothResistanceEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(EFAC.MOD_ID, name),
                new ToothEffect(StatusEffectCategory.BENEFICIAL, 3124687).addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, "32244586-ca59-4330-8698-04c2dd34d462", 0.5F, EntityAttributeModifier.Operation.ADDITION));
    }
    public static StatusEffect registerToothRegenEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(EFAC.MOD_ID, name),
                new ToothEffect(StatusEffectCategory.BENEFICIAL, 3124687));
    }
    public static StatusEffect registerToothSlownessEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(EFAC.MOD_ID, name),
                new ToothEffect(StatusEffectCategory.HARMFUL, 3124687).addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "38d389c7-7eb4-40a9-9d90-17f853d8cdd6", -0.2F, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
    }

    public static StatusEffect registerToothFatigueEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(EFAC.MOD_ID, name),
                new ToothEffect(StatusEffectCategory.HARMFUL, 3124687).addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "969d9a51-d075-4a4a-8c0c-3584ac1f3193", -0.2F, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
    }
    public static StatusEffect registerToothHasteEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(EFAC.MOD_ID, name),
                new ToothEffect(StatusEffectCategory.BENEFICIAL, 3124687).addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "b5fc7b2d-20dd-42e5-913a-e42f7a73f2f5", 0.1F, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
    }

    public static StatusEffect registerBeamsEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(EFAC.MOD_ID, name),
                new ToothEffect(StatusEffectCategory.BENEFICIAL, 3124687));
    }
    public static StatusEffect registerVenomEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(EFAC.MOD_ID, name),
                new ToothEffect(StatusEffectCategory.BENEFICIAL, 3124687));
    }

    public static void registerModEffects() {
        FREEZE = registerFreezeEffect("freeze");

        TOOTH_SPEED = registerToothSpeedEffect("tooth_speed");
        TOOTH_STRENGTH = registerToothStrengthEffect("tooth_strength");
        TOOTH_RESISTANCE = registerToothResistanceEffect("tooth_resistance");
        TOOTH_REGEN = registerToothRegenEffect("tooth_regen");
        TOOTH_SLOWNESS = registerToothSlownessEffect("tooth_slowness");
        FATIGUE = registerToothFatigueEffect("tooth_fatigue");
        HASTE = registerToothHasteEffect("tooth_haste");
        BEAMS = registerBeamsEffect("beams");
        VENOM = registerVenomEffect("venom");

        EFAC.LOGGER.info("Registering Mod Effects for " + EFAC.MOD_ID);
    }
}
