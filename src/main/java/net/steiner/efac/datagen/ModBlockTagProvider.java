package net.steiner.efac.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        //mod stuff
        getOrCreateTagBuilder(ModTags.Blocks.PROVIDES_CHARGE_ALWAYS)
                .add(ModBlocks.CLUMB_BLOCK)
                .add(ModBlocks.YES)
                .add(ModBlocks.SMALL_GEUMB_BUD)
                .add(ModBlocks.MEDIUM_GEUMB_BUD)
                .add(ModBlocks.LARGE_GEUMB_BUD)
                .add(ModBlocks.GEUMB_CLUSTER);

        getOrCreateTagBuilder(ModTags.Blocks.PROVIDES_CHARGE_COMMON)
                .add(ModBlocks.COMPACT_DOM)
                .add(ModBlocks.BUTTER)
                .add(ModBlocks.GEUMB_BLOCK)
                .add(ModBlocks.BUDDING_GEUMB)
                .add(ModBlocks.ETHER);

        getOrCreateTagBuilder(ModTags.Blocks.PROVIDES_CHARGE_RARE)
                .add(Blocks.DIRT)
                .add(ModBlocks.PRIMA_LEAVES)
                .add(Blocks.GRASS_BLOCK)
                .add(Blocks.STONE)
                .add(Blocks.DIORITE)
                .add(Blocks.ANDESITE)
                .add(Blocks.GRANITE)
                .add(Blocks.TUFF)
                .add(Blocks.NETHERRACK)
                .add(Blocks.SAND)
                .add(Blocks.RED_SAND)
                .add(Blocks.GRAVEL);

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
                .add(ModBlocks.CLUMB_HARVESTER)
                .add(ModBlocks.YES)
                .add(ModBlocks.BLONE_BRICKS)
                .add(ModBlocks.BLONE_BRICK_STAIRS)
                .add(ModBlocks.BLONE_BRICK_SLAB)
                .add(ModBlocks.BLONE_BRICK_WALL)
                .add(ModBlocks.POLISHED_BLONE)
                .add(ModBlocks.POLISHED_BLONE_STAIRS)
                .add(ModBlocks.POLISHED_BLONE_SLAB)
                .add(ModBlocks.POLISHED_BLONE_WALL)
                .add(ModBlocks.PLONE_BRICKS)
                .add(ModBlocks.PLONE_BRICK_STAIRS)
                .add(ModBlocks.PLONE_BRICK_SLAB)
                .add(ModBlocks.PLONE_BRICK_WALL)
                .add(ModBlocks.POLISHED_PLONE)
                .add(ModBlocks.POLISHED_PLONE_STAIRS)
                .add(ModBlocks.POLISHED_PLONE_SLAB)
                .add(ModBlocks.POLISHED_PLONE_WALL)
                .add(ModBlocks.RONE_BRICKS)
                .add(ModBlocks.RONE_BRICK_STAIRS)
                .add(ModBlocks.RONE_BRICK_SLAB)
                .add(ModBlocks.RONE_BRICK_WALL)
                .add(ModBlocks.POLISHED_RONE)
                .add(ModBlocks.POLISHED_RONE_STAIRS)
                .add(ModBlocks.POLISHED_RONE_SLAB)
                .add(ModBlocks.POLISHED_RONE_WALL);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.COMPACT_DOM)
                .add(ModBlocks.ETHER)
                .add(ModBlocks.CLUMB_BLOCK)
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
                .add(ModBlocks.YES)
                .add(ModBlocks.CLUMB_HARVESTER);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CIT_GEM_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RUB_GEM_ORE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.BLONE_BRICK_WALL)
                .add(ModBlocks.POLISHED_BLONE_WALL)
                .add(ModBlocks.PLONE_BRICK_WALL)
                .add(ModBlocks.POLISHED_PLONE_WALL)
                .add(ModBlocks.RONE_BRICK_WALL)
                .add(ModBlocks.POLISHED_RONE_WALL);

        //wood stuff
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.GELWOOD_FENCE)
                .add(ModBlocks.PRIMA_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.GELWOOD_FENCE_GATE)
                .add(ModBlocks.PRIMA_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.PRIMA_LOG);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.PRIMA_LOG)
                .add(ModBlocks.PRIMA_WOOD)
                .add(ModBlocks.STRIPPED_PRIMA_LOG)
                .add(ModBlocks.STRIPPED_PRIMA_WOOD);
    }
}
