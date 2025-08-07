package net.steiner.efac.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.steiner.efac.util.CooldownData;
import net.steiner.efac.util.EntityDataSaver;

public class SetCooldownProgressC2SPacket {

    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        CooldownData.setCooldownProgress(((EntityDataSaver) player), buf.readInt());
        CooldownData.syncCooldownProgress(((EntityDataSaver) player).getPersistentData().getInt(CooldownData.COOLDOWN_PROGRESS_KEY), player);
    }
}
