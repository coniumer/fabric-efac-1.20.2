package net.steiner.efac.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;
import net.steiner.efac.networking.packet.ClumbDischargeC2SPacket;
import net.steiner.efac.networking.packet.ClumbSyncS2CPacket;
import net.steiner.efac.networking.packet.ClumbRechargeC2SPacket;

public class ModMessages {
    public static final Identifier CLUMB_DISCHARGE_ID = new Identifier(EFAC.MOD_ID, "clumb_discharge");
    public static final Identifier CLUMB_RECHARGE_ID = new Identifier(EFAC.MOD_ID, "clumb_recharge");
    public static final Identifier CLUMB_SYNC_ID = new Identifier(EFAC.MOD_ID, "clumb_sync");

    public static void regsiterC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(CLUMB_DISCHARGE_ID, ClumbDischargeC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(CLUMB_RECHARGE_ID, ClumbRechargeC2SPacket::receive);
    }

    public static void regsiterS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(CLUMB_SYNC_ID, ClumbSyncS2CPacket::receive);
    }

}
