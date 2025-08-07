package net.steiner.efac.util;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.steiner.efac.networking.ModMessages;

public class CooldownData {
    public static final String COOLDOWN_PROGRESS_KEY = "cooldownProgress";
    public static final int COOLDOWN_MAX = 3;

    public static void setCooldownProgress(EntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int newCooldownProgress = MathHelper.clamp(amount, 0, COOLDOWN_MAX);
        nbt.putInt(COOLDOWN_PROGRESS_KEY, newCooldownProgress);

        syncCooldownProgress(newCooldownProgress, (ServerPlayerEntity)player);
    }

    public static void syncCooldownProgress(int cooldownProgress, ServerPlayerEntity player) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeInt(cooldownProgress);
        ServerPlayNetworking.send(player, ModMessages.COOLDOWN_PROGRESS_SYNC_ID, buffer);
    }
}
