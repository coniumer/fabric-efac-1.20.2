package net.steiner.efac.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.steiner.efac.entity.custom.ClumbProjectileEntity;

public class FishBlock extends Block {
    public FishBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        if (projectile instanceof ClumbProjectileEntity && !world.isClient) {
            spawnFish(world, hit.getBlockPos());
        }
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        spawnFish(world, pos);
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    private void spawnFish(World world, BlockPos pos) {
        int fish = MathHelper.clamp(Math.abs((world.random.nextInt() % 10) / 2), 1, 5);
        System.out.println("fish = " + fish);
        for (int i = 0; i < fish; i++) {
            BlockPos summonPos = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
            EntityType.TROPICAL_FISH.spawn((ServerWorld) world, summonPos, SpawnReason.TRIGGERED);
        }
    }
}
