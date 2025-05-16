package net.steiner.efac.util;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.steiner.efac.networking.ModMessages;

public class ClumbData {

    public static int addClumbCharges(EntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int clumbCharges = nbt.getInt("clumbCharges");
        // TODO: variable max amount
        if(clumbCharges + amount >= 10) {
            clumbCharges = 10;
        } else {
            clumbCharges += amount;
        }
        nbt.putInt("clumbCharges", clumbCharges);

        syncClumbCharges(clumbCharges, (ServerPlayerEntity)player);
        return clumbCharges;
    }

    public static int removeClumbCharges(EntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int clumbCharges = nbt.getInt("clumbCharges");
        // TODO: variable max amount
        if(clumbCharges - amount < 0) {
            clumbCharges = 0;
        } else {
            clumbCharges -= amount;
        }
        nbt.putInt("clumbCharges", clumbCharges);

        syncClumbCharges(clumbCharges, (ServerPlayerEntity)player);
        return clumbCharges;
    }

    public static void syncClumbCharges(int clumbCharges, ServerPlayerEntity player) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeInt(clumbCharges);
        ServerPlayNetworking.send(player, ModMessages.CLUMB_SYNC_ID, buffer);
    }

}
