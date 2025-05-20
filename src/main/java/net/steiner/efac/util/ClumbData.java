package net.steiner.efac.util;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.steiner.efac.networking.ModMessages;

public class ClumbData {

    public static void addClumbCharges(EntityDataSaver player, int amount, int max) {
        NbtCompound nbt = player.getPersistentData();
        int clumbCharges = nbt.getInt("clumbCharges");
        clumbCharges = MathHelper.clamp(clumbCharges + amount, 0, max);
        nbt.putInt("clumbCharges", clumbCharges);

        syncClumbCharges(clumbCharges, (ServerPlayerEntity)player);
        syncMaxClumbCharges(max, (ServerPlayerEntity)player);

        /*
        System.out.println("Clumb charges equals: " +
                player.getPersistentData().getInt("clumbCharges"));
         */
    }

    public static void removeClumbCharges(EntityDataSaver player, int amount, int max) {
        NbtCompound nbt = player.getPersistentData();
        int clumbCharges = nbt.getInt("clumbCharges");
        clumbCharges = MathHelper.clamp(clumbCharges - amount, 0, max);
        nbt.putInt("clumbCharges", clumbCharges);

        syncClumbCharges(clumbCharges, (ServerPlayerEntity)player);
        syncMaxClumbCharges(max, (ServerPlayerEntity)player);

        /*
        System.out.println("Clumb charges equals: " +
                player.getPersistentData().getInt("clumbCharges"));
         */
    }

    public static void setClumbCharges(EntityDataSaver player, int amount, int max) {
        NbtCompound nbt = player.getPersistentData();
        int newClumbCharges = MathHelper.clamp(amount, 0, max);
        nbt.putInt("clumbCharges", newClumbCharges);

        syncClumbCharges(newClumbCharges, (ServerPlayerEntity)player);
        syncMaxClumbCharges(max, (ServerPlayerEntity)player);
    }

    public static void setMaxClumbCharges(EntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int newMaxClumbCharges = MathHelper.clamp(amount, 5, 40);
        nbt.putInt("maxClumbCharges", newMaxClumbCharges);

        syncMaxClumbCharges(newMaxClumbCharges, (ServerPlayerEntity)player);
    }

    public static void syncClumbCharges(int clumbCharges, ServerPlayerEntity player) {
            PacketByteBuf buffer = PacketByteBufs.create();
            buffer.writeInt(clumbCharges);
            ServerPlayNetworking.send(player, ModMessages.CLUMB_SYNC_ID, buffer);
    }

    public static void syncMaxClumbCharges(int maxClumbCharges, ServerPlayerEntity player) {
            PacketByteBuf buffer = PacketByteBufs.create();
            buffer.writeInt(maxClumbCharges);
            ServerPlayNetworking.send(player, ModMessages.MAX_CLUMB_SYNC_ID, buffer);
    }

}
