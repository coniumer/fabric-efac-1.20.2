package net.steiner.efac.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class OpenEnderChestC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        player.openHandledScreen(
                new SimpleNamedScreenHandlerFactory(
                        (syncId, inventory, playerx) -> GenericContainerScreenHandler.createGeneric9x3(syncId, player.getInventory(), player.getEnderChestInventory()), Text.translatable("container.efac.enderchest")
                )
        );
    }
}
