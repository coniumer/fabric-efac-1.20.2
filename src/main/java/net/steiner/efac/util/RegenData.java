package net.steiner.efac.util;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.steiner.efac.networking.ModMessages;

public class RegenData {
    public static final String REGEN_PROGRESS_KEY = "regen_progress";
    public static final String MAX_REGEN_PROGRESS_KEY = "max_regen_progress";
    public static final int TRUE_MAX_KEY = 512;

    public static void setProgress(EntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int progress = MathHelper.clamp(amount, 0, player.getPersistentData().getInt(MAX_REGEN_PROGRESS_KEY));
        nbt.putInt(REGEN_PROGRESS_KEY, progress);

        syncProgress(progress, (ServerPlayerEntity)player);
    }

    public static void syncProgress(int progress, ServerPlayerEntity player) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeInt(progress);
        ServerPlayNetworking.send(player, ModMessages.REGEN_SYNC_ID, buffer);
    }

    public static void setMaxProgress(EntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int newMax = MathHelper.clamp(amount, 0, TRUE_MAX_KEY);
        nbt.putInt(MAX_REGEN_PROGRESS_KEY, newMax);

        syncMaxProgress(newMax, (ServerPlayerEntity)player);
    }

    public static void syncMaxProgress(int maxProgress, ServerPlayerEntity player) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeInt(maxProgress);
        ServerPlayNetworking.send(player, ModMessages.MAX_REGEN_SYNC_ID, buffer);
    }
}
