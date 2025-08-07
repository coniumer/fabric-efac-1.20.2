package net.steiner.efac.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.steiner.efac.util.CooldownData;
import net.steiner.efac.util.EntityDataSaver;

public class CooldownProgressSyncS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        client.execute(() -> {
            ((EntityDataSaver) client.player).getPersistentData().putInt(CooldownData.COOLDOWN_PROGRESS_KEY, buf.readInt());
        });
    }
}
