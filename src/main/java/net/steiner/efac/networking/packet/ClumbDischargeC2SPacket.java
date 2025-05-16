package net.steiner.efac.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.steiner.efac.util.ClumbData;
import net.steiner.efac.util.EntityDataSaver;

public class ClumbDischargeC2SPacket {

    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        ClumbData.removeClumbCharges((EntityDataSaver)player, 1);
        ClumbData.syncClumbCharges(((EntityDataSaver)player).getPersistentData().getInt("clumbCharges"), player);
    }
}
