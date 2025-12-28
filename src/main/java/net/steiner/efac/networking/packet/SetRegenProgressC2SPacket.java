package net.steiner.efac.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.steiner.efac.util.EntityDataSaver;
import net.steiner.efac.util.RegenData;

public class SetRegenProgressC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        RegenData.setProgress(((EntityDataSaver) player), buf.readInt());
        RegenData.syncProgress(((EntityDataSaver) player).getPersistentData().getInt(RegenData.REGEN_PROGRESS_KEY), player);
    }
}
