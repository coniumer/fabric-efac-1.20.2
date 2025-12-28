package net.steiner.efac.block.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.steiner.efac.entity.custom.ClumbProjectileEntity;
import net.steiner.efac.state.ModProperties;

import java.util.Map;

public class ClumbBlock extends Block {
    private static EnumProperty<ClumbPhase> CLUMB_PHASE = ModProperties.CLUMB_PHASE;
    private static final Map<ClumbPhase, VoxelShape> SHAPES_FOR_PHASE = ImmutableMap.of(
            ClumbPhase.SOLID,
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0),
            ClumbPhase.PASSABLE,
            VoxelShapes.empty()
    );
    private final Map<BlockState, VoxelShape> shapes;

    public ClumbBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(CLUMB_PHASE, ClumbPhase.SOLID));
        this.shapes = this.getShapesForStates(ClumbBlock::getShapeForState);
    }

    private static VoxelShape getShapeForState(BlockState state) {
        return SHAPES_FOR_PHASE.get(state.get(CLUMB_PHASE));
    }

    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        if (projectile instanceof ClumbProjectileEntity) {
            makePassable(state, world, hit.getBlockPos());
            if (!world.isClient) {
                BlockPos blockPos = hit.getBlockPos();
                world.playSound(null, blockPos, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1.0F, 0.5F + world.random.nextFloat() * 1.2F);
            }
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        ClumbPhase phase = state.get(CLUMB_PHASE);
        if (phase == ClumbPhase.PASSABLE) {
            makeSolid(state, world, pos);
        }
    }

    private void makePassable(BlockState state, World world, BlockPos pos) {
        changePhase(state, world, pos, ClumbPhase.PASSABLE);
        world.scheduleBlockTick(pos, this, 100);
    }

    private static void makeSolid(BlockState state, World world, BlockPos pos) {
        changePhase(state, world, pos, ClumbPhase.SOLID);
    }

    private static void changePhase(BlockState state, World world, BlockPos pos, ClumbPhase phase) {
        ClumbPhase phase2 = state.get(CLUMB_PHASE);
        world.setBlockState(pos, state.with(CLUMB_PHASE, phase), Block.NOTIFY_LISTENERS);
        if (phase.isStable() && phase != phase2) {
            world.emitGameEvent(null, GameEvent.BLOCK_CHANGE, pos);
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPES_FOR_PHASE.get(state.get(CLUMB_PHASE));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return this.shapes.get(state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CLUMB_PHASE);
    }
}
