package net.steiner.efac.util;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.steiner.efac.networking.ModMessages;

public class DashData {
    public static final String DASH_USES_KEY = "dashUses";

    public static void addDashUses(EntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int dashUses = MathHelper.clamp(amount, 0, 2);
        nbt.putInt(DASH_USES_KEY, dashUses);

        syncDashUses(dashUses, (ServerPlayerEntity)player);
    }

    public static void syncDashUses(int dashUses, ServerPlayerEntity player) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeInt(dashUses);
        ServerPlayNetworking.send(player, ModMessages.DASH_SYNC_ID, buffer);
    }
}
