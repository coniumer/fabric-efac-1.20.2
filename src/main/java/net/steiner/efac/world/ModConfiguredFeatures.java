package net.steiner.efac.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.steiner.efac.EFAC;
import net.steiner.efac.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> SLIPULON_ORE_KEY = registerKey("slipulon_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GELWOOD_ORE_KEY = registerKey("gelwood_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BUTTER_KEY = registerKey("butter");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ALB_GEM_ORE_KEY = registerKey("alb_gem_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CIT_GEM_ORE_KEY = registerKey("cit_gem_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RUB_GEM_ORE_KEY = registerKey("rub_gem_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GEUMB_BLOCK_KEY = registerKey("geumb_block_key");

    public static final RegistryKey<ConfiguredFeature<?, ?>> PRIMA_KEY = registerKey("prima");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldSlipulonOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.SLIPULON_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.SLIPULON_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldButterOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.BUTTER.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.BUTTER.getDefaultState()));

        List<OreFeatureConfig.Target> overworldGelwoodOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.GELWOOD_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.GELWOOD_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldAlbGemOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.ALB_GEM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.ALB_GEM_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldCitGemOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.CIT_GEM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.CIT_GEM_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldRubGemOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.RUB_GEM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.RUB_GEM_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldGeumbBlocks =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.GEUMB_BLOCK.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.BUDDING_GEUMB.getDefaultState()));

        register(context, SLIPULON_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldSlipulonOres, 11));
        register(context, BUTTER_KEY, Feature.ORE, new OreFeatureConfig(overworldButterOres, 12));
        register(context, GELWOOD_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldGelwoodOres, 15));
        register(context, ALB_GEM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldAlbGemOres, 4));
        register(context, CIT_GEM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldCitGemOres, 4));
        register(context, RUB_GEM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldRubGemOres, 4));
        register(context, GEUMB_BLOCK_KEY, Feature.ORE, new OreFeatureConfig(overworldGeumbBlocks, 8));

        register(context, PRIMA_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PRIMA_LOG),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.of(ModBlocks.PRIMA_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build()
        );
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(EFAC.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void
    register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
