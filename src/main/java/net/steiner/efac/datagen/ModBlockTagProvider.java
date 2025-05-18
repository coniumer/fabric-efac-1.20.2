package net.steiner.efac.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        // tool stuff
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SLIPULON_BLOCK)
                .add(ModBlocks.SLIPULON_ORE)
                .add(ModBlocks.ALB_GEM_ORE)
                .add(ModBlocks.CIT_GEM_ORE)
                .add(ModBlocks.RUB_GEM_ORE)
                .add(ModBlocks.GELWOOD_ORE)
                .add(ModBlocks.GEUMB_BLOCK)
                .add(ModBlocks.GEUMB_CLUSTER)
                .add(ModBlocks.LARGE_GEUMB_BUD)
                .add(ModBlocks.MEDIUM_GEUMB_BUD)
                .add(ModBlocks.SMALL_GEUMB_BUD)
                .add(ModBlocks.BUDDING_GEUMB)
                .add(ModBlocks.YES);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.COMPACT_DOM)
                .add(ModBlocks.BUTTER);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SLIPULON_BLOCK)
                .add(ModBlocks.SLIPULON_ORE)
                .add(ModBlocks.ALB_GEM_ORE)
                .add(ModBlocks.GELWOOD_ORE)
                .add(ModBlocks.GEUMB_BLOCK)
                .add(ModBlocks.GEUMB_CLUSTER)
                .add(ModBlocks.LARGE_GEUMB_BUD)
                .add(ModBlocks.MEDIUM_GEUMB_BUD)
                .add(ModBlocks.SMALL_GEUMB_BUD)
                .add(ModBlocks.BUDDING_GEUMB)
                .add(ModBlocks.YES);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CIT_GEM_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RUB_GEM_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.CLUMBVESTIGATABLE)
                .add(ModBlocks.SLIPULON_ORE)
                .add(ModBlocks.SLIPULON_BLOCK)
                .add(ModBlocks.BUTTER)
                .forceAddTag(BlockTags.GOLD_ORES)
                .add(Blocks.GOLD_BLOCK)
                .add(Blocks.RAW_GOLD_BLOCK)
                .forceAddTag(BlockTags.COPPER_ORES)
                .add(Blocks.COPPER_BLOCK)
                .add(Blocks.RAW_COPPER_BLOCK)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .add(Blocks.DIAMOND_BLOCK);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.GELWOOD_FENCE)
                .add(ModBlocks.PRIMA_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.GELWOOD_FENCE_GATE)
                .add(ModBlocks.PRIMA_FENCE_GATE);
    }
}
