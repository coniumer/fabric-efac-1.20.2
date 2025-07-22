package net.steiner.efac.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;
import net.steiner.efac.networking.packet.*;

public class ModMessages {
    //C2S
    public static final Identifier CLUMB_DISCHARGE_ID = new Identifier(EFAC.MOD_ID, "clumb_discharge");
    public static final Identifier CLUMB_RECHARGE_ID = new Identifier(EFAC.MOD_ID, "clumb_recharge");
    public static final Identifier SET_CLUMB_ID = new Identifier(EFAC.MOD_ID, "set_clumb");
    public static final Identifier SET_MAX_CLUMB_ID = new Identifier(EFAC.MOD_ID, "set_max_clumb");

    public static final Identifier CLUMB_BUTTON_PAYLOAD_ID = new Identifier(EFAC.MOD_ID, "clumb_button_payload");

    public static final Identifier SET_DASH_USES_ID = new Identifier(EFAC.MOD_ID, "set_dash_uses");

    //S2C
    public static final Identifier CLUMB_SYNC_ID = new Identifier(EFAC.MOD_ID, "clumb_sync");
    public static final Identifier MAX_CLUMB_SYNC_ID = new Identifier(EFAC.MOD_ID, "max_clumb_sync");

    public static final Identifier DASH_SYNC_ID = new Identifier(EFAC.MOD_ID, "dash_sync");

    public static void regsiterC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(CLUMB_DISCHARGE_ID, ClumbDischargeC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(CLUMB_RECHARGE_ID, ClumbRechargeC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(SET_CLUMB_ID, SetClumbC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(SET_MAX_CLUMB_ID, SetMaxClumbC2SPacket::receive);

        ServerPlayNetworking.registerGlobalReceiver(CLUMB_BUTTON_PAYLOAD_ID, ClumbButtonPayloadC2SPacket::receive);

        ServerPlayNetworking.registerGlobalReceiver(SET_DASH_USES_ID, SetDashUsesC2SPacket::receive);
    }

    public static void regsiterS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(CLUMB_SYNC_ID, ClumbSyncS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(MAX_CLUMB_SYNC_ID, MaxClumbSyncS2CPacket::receive);

        ClientPlayNetworking.registerGlobalReceiver(DASH_SYNC_ID, DashSyncS2CPacket::receive);
    }

}
