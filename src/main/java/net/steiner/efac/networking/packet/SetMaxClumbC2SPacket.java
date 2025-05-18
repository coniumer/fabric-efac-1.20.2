package net.steiner.efac.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.steiner.efac.util.ClumbData;
import net.steiner.efac.util.EntityDataSaver;

public class SetMaxClumbC2SPacket {

    // TODO: use this somewhere and test it
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        ClumbData.setMaxClumbCharges(((EntityDataSaver)player), buf.readInt());
        ClumbData.syncMaxClumbCharges(((EntityDataSaver)player).getPersistentData().getInt("maxClumbCharges"), player);
    }
}
