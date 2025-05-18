package net.steiner.efac.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.item.ModItemGroups;
import net.steiner.efac.item.ModItems;
import net.steiner.efac.networking.ModMessages;
import net.steiner.efac.sound.ModSounds;

public class ModRegistries {
    public static void registerModRegistries() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModSounds.registerSounds();
        ModMessages.regsiterC2SPackets();

        registerStrippables();
        registerFlammables();
    }

    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.PRIMA_LOG, ModBlocks.STRIPPED_PRIMA_LOG);
        StrippableBlockRegistry.register(ModBlocks.PRIMA_WOOD, ModBlocks.STRIPPED_PRIMA_WOOD);
    }

    public static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PRIMA_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PRIMA_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PRIMA_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PRIMA_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PRIMA_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PRIMA_LOG, 30, 60);
    }

}
