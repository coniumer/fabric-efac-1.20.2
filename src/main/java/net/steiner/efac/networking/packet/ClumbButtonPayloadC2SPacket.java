package net.steiner.efac.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.steiner.efac.sound.ModSounds;

public class ClumbButtonPayloadC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        World world = player.getWorld();

        switch (buf.readInt()) {
            case 0:
                fail(world, player);
                break;
            case 1:
                dash(world, player);
                break;
            case 2:
                summonLightning(world, player);
                break;
            case 3:
                blink(world, player);
                break;
            case 4:
                fireball(world, player);
                break;
            case 5:
                bomb(world, player);
                break;
            case 6:
                health(player);
                break;
            default:
                System.out.println("How did you get here");
        }
    }

    public static void fail(World world, PlayerEntity player) {
        world.playSound(
                null,
                player.getX(),
                player.getY(),
                player.getZ(),
                ModSounds.WAND_FAIL,
                SoundCategory.PLAYERS,
                0.5F,
                0.85F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
        );
    }

    public static void dash(World world, PlayerEntity player) {
        world.playSound(
                null,
                player.getX(),
                player.getY(),
                player.getZ(),
                ModSounds.CLUMB_DASH,
                SoundCategory.PLAYERS,
                1F,
                0.95F / (world.getRandom().nextFloat() * 0.4F + 1F)
        );
    }

    public static void summonLightning(World world, PlayerEntity player) {
        HitResult target = player.raycast(20, 0, false);
        BlockHitResult bhr = (BlockHitResult) target;
        EntityType.LIGHTNING_BOLT.spawn((ServerWorld) world, bhr.getBlockPos(), SpawnReason.TRIGGERED);
    }

    public static void blink(World world, PlayerEntity player) {
        HitResult target = player.raycast(20, 0, false);

        if (player.hasVehicle()) {
            player.requestTeleportAndDismount(target.getPos().x, target.getPos().y, target.getPos().z);
        } else {
            player.requestTeleport(target.getPos().x, target.getPos().y, target.getPos().z);
        }

        player.onLanding();

        world.playSound(
                null,
                player.getX(),
                player.getY(),
                player.getZ(),
                SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT,
                SoundCategory.PLAYERS,
                1F,
                1.3F / (world.getRandom().nextFloat() * 0.4F + 1F)
        );
    }

    public static void fireball(World world, PlayerEntity player) {
        Vec3d playerLook = player.getRotationVec(1.0f);
        SmallFireballEntity smallFireballEntity = new SmallFireballEntity(
                world, player, playerLook.x, playerLook.y, playerLook.z
        );
        smallFireballEntity.setPosition(smallFireballEntity.getX(), player.getBodyY(0.5) + 0.5, smallFireballEntity.getZ());
        world.spawnEntity(smallFireballEntity);

        world.playSound(
                null,
                player.getX(),
                player.getY(),
                player.getZ(),
                SoundEvents.ENTITY_BLAZE_SHOOT,
                SoundCategory.PLAYERS,
                1F,
                1.3F / (world.getRandom().nextFloat() * 0.4F + 1F)
        );
    }

    public static void bomb(World world, PlayerEntity player) {
        TntEntity tntEntity = new TntEntity(world, player.getPos().getX() + 0.5, player.getPos().getY(), player.getPos().getZ() + 0.5, player);
        world.spawnEntity(tntEntity);
        world.playSound(null, tntEntity.getX(), tntEntity.getY(), tntEntity.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
        world.emitGameEvent(player, GameEvent.PRIME_FUSE, player.getPos());
    }

    public static void health(PlayerEntity player) {
        player.heal(5);
        player.hurtTime = player.maxHurtTime;

        player.getWorld().playSound(
                null,
                player.getX(),
                player.getY(),
                player.getZ(),
                SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE,
                SoundCategory.PLAYERS,
                1f,
                1f
        );
    }
}
