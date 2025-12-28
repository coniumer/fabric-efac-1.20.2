package net.steiner.efac.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.steiner.efac.screen.MouthScreenHandler;
import net.steiner.efac.util.MouthData;

public class OpenMouthC2SPacket{
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        String MOUTH_KEY = "container.efac.mouth";
        MouthData mPlayer = (MouthData) player;
        player.openHandledScreen(
                new SimpleNamedScreenHandlerFactory(
                        ((syncId, playerInventory, player1) -> new MouthScreenHandler(syncId, playerInventory, mPlayer.getMouthInventory())),
                        Text.translatable(MOUTH_KEY)
                )
        );
    }

}
