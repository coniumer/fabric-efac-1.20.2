package net.steiner.efac.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.dimension.DimensionType;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.item.ModItems;

public class DragonBloodFluid extends ModFluid {
    @Override
    public Fluid getStill() {
        return ModFluids.DRAGON_BLOOD_STILL;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.DRAGON_BLOOD_FLOWING;
    }

    @Override
    public Item getBucketItem() {
        return ModItems.DRAGON_BLOOD_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return ModBlocks.DRAGON_BLOOD.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    @Override
    protected int getFlowSpeed(WorldView world) {
        return world.getDimension().hasCeiling() ? 2 : 8;
    }

    @Override
    protected void flow(WorldAccess world, BlockPos pos, BlockState state, Direction direction, FluidState fluidState) {
        if (direction == Direction.DOWN) {
            FluidState target = world.getFluidState(pos);
            if (target.isIn(FluidTags.WATER)) {
                if (state.getBlock() instanceof FluidBlock) {
                    world.setBlockState(pos, Blocks.END_STONE.getDefaultState(), Block.NOTIFY_ALL);
                }

                return;
            }
            if (target.isIn(FluidTags.LAVA)) {
                if (state.getBlock() instanceof FluidBlock) {
                    world.setBlockState(pos, ModBlocks.ETHER.getDefaultState(), Block.NOTIFY_ALL);
                }

                return;
            }
        }

        super.flow(world, pos, state, direction, fluidState);
    }

    public static class Flowing extends DragonBloodFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);

        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still extends DragonBloodFluid {
        @Override
        public int getLevel(FluidState state) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }
    }
}
