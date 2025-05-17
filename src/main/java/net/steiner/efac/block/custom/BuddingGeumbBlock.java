package net.steiner.efac.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.steiner.efac.block.ModBlocks;

public class BuddingGeumbBlock extends GeumbBlock{
    private static final Direction[] DIRECTIONS = Direction.values();

    public BuddingGeumbBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
            BlockPos blockPos = pos.offset(direction);
            BlockState blockState = world.getBlockState(blockPos);
            Block block = null;
            if (canGrowIn(blockState)) {
                block = ModBlocks.SMALL_GEUMB_BUD;
            } else if (blockState.isOf(ModBlocks.SMALL_GEUMB_BUD) && blockState.get(GeumbClusterBlock.FACING) == direction) {
                block = ModBlocks.MEDIUM_GEUMB_BUD;
            } else if (blockState.isOf(ModBlocks.MEDIUM_GEUMB_BUD) && blockState.get(GeumbClusterBlock.FACING) == direction) {
                block = ModBlocks.LARGE_GEUMB_BUD;
            } else if (blockState.isOf(ModBlocks.LARGE_GEUMB_BUD) && blockState.get(GeumbClusterBlock.FACING) == direction) {
                block = ModBlocks.GEUMB_CLUSTER;
            }

            if (block != null) {
                BlockState blockState2 = block.getDefaultState()
                        .with(GeumbClusterBlock.FACING, direction)
                        .with(GeumbClusterBlock.WATERLOGGED, Boolean.valueOf(blockState.getFluidState().getFluid() == Fluids.WATER));
                world.setBlockState(blockPos, blockState2);
            }
        }
    }

    public static boolean canGrowIn(BlockState state) {
        return state.isAir() || state.isOf(Blocks.WATER) && state.getFluidState().getLevel() == 8;
    }
}