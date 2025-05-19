package net.steiner.efac.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.steiner.efac.util.EntityDataSaver;

public class ClumbSyncS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        client.execute(() -> {
            if (((EntityDataSaver)client.player).getPersistentData() != null) {
                ((EntityDataSaver) client.player).getPersistentData().putInt("clumbCharges", buf.readInt());
            }
        });
    }
}
