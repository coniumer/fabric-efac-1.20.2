package net.steiner.efac.util;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;

public class ModDamage {
    public static final RegistryKey<DamageType> CLUMB_PULSE_DAMAGE =
            RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(EFAC.MOD_ID, "clumb_pulse"));

    public static void registerModDamage() {
        EFAC.LOGGER.info("Registering damage types for " + EFAC.MOD_ID);
    }
}
