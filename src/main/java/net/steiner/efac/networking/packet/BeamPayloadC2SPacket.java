package net.steiner.efac.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;
import net.steiner.efac.sound.ModSounds;
import net.steiner.efac.util.BeamHelper;

public class BeamPayloadC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        BeamHelper bPlayer = (BeamHelper) player;
        World world = player.getWorld();

        if (bPlayer.getBeamTarget() != null) {
            if (bPlayer.getBeamTarget().isAlive()) {
                bPlayer.getBeamTarget().damage(player.getDamageSources().generic(), buf.readInt());

                world.playSound(
                        null,
                        player.getX(),
                        player.getY(),
                        player.getZ(),
                        ModSounds.SWORD_PULSE,
                        SoundCategory.PLAYERS,
                        1F,
                        0.75F / (world.getRandom().nextFloat() * 0.4F + 1F)
                );
            } else {
                bPlayer.setBeamTarget(null);
                bPlayer.resetBeamTicks();
            }
        }
    }
}
