package net.steiner.efac.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.steiner.efac.util.EntityDataSaver;
import net.steiner.efac.util.RegenData;

public class MaxRegenSyncS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        client.execute(() -> {
            ((EntityDataSaver) client.player).getPersistentData().putInt(RegenData.MAX_REGEN_PROGRESS_KEY, buf.readInt());
        });
    }
}
