package net.steiner.efac.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.steiner.efac.util.DashData;
import net.steiner.efac.util.EntityDataSaver;

public class SetDashUsesC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        DashData.addDashUses(((EntityDataSaver) player), buf.readInt());
        DashData.syncDashUses(((EntityDataSaver) player).getPersistentData().getInt(DashData.DASH_USES_KEY), player);
    }
}
