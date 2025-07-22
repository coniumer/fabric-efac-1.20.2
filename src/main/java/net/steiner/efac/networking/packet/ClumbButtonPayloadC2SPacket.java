package net.steiner.efac.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;
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
        EntityType.LIGHTNING_BOLT.spawn((ServerWorld) world, player.getBlockPos(), SpawnReason.TRIGGERED);
    }
}
