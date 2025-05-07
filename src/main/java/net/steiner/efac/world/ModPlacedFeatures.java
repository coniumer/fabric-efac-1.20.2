package net.steiner.efac.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.steiner.efac.EFAC;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> SLIPULON_ORE_PLACED_KEY = registerKey("slipulon_ore_placed");
    public static final RegistryKey<PlacedFeature> BUTTER_PLACED_KEY = registerKey("butter_placed");
    public static final RegistryKey<PlacedFeature> GELWOOD_ORE_PLACED_KEY = registerKey("gelwood_ore_placed");
    public static final RegistryKey<PlacedFeature> ALB_GEM_ORE_PLACED_KEY = registerKey("alb_gem_ore_placed");
    public static final RegistryKey<PlacedFeature> CIT_GEM_ORE_PLACED_KEY = registerKey("cit_gem_ore_placed");
    public static final RegistryKey<PlacedFeature> RUB_GEM_ORE_PLACED_KEY = registerKey("rub_gem_ore_placed");
    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(EFAC.MOD_ID, name));
    }

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, SLIPULON_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SLIPULON_ORE_KEY),
                ModOrePlacement.modifiersWithCount(12, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
        register(context, BUTTER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BUTTER_KEY),
                ModOrePlacement.modifiersWithCount(18, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
        register(context, GELWOOD_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GELWOOD_ORE_KEY),
                ModOrePlacement.modifiersWithCount(19, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
        register(context, ALB_GEM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ALB_GEM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(16, // Veins per Chunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80))));
        register(context, CIT_GEM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CIT_GEM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(8, // Veins per Chunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(40))));
        register(context, RUB_GEM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RUB_GEM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(4, // Veins per Chunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(20))));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
