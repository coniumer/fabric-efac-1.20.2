package net.steiner.efac.fluid;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;

public class ModFluids {
    public static final FlowableFluid DRAGON_BLOOD_STILL = Registry.register(Registries.FLUID, new Identifier(EFAC.MOD_ID, "dragon_blood_still"),
            new DragonBloodFluid.Still());
    public static final FlowableFluid DRAGON_BLOOD_FLOWING = Registry.register(Registries.FLUID, new Identifier(EFAC.MOD_ID, "dragon_blood_flowing"),
            new DragonBloodFluid.Flowing());

    public static void registerModFluids() { EFAC.LOGGER.info("Registering Mod Fluids for " + EFAC.MOD_ID); }
}
