package net.steiner.efac.world.tree;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.steiner.efac.world.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class PrimaSaplingGenerator extends SaplingGenerator {
    @Override
    protected @Nullable RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ModConfiguredFeatures.PRIMA_KEY;
    }
}
