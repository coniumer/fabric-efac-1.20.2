package net.steiner.efac.util;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.block.entity.ModBlockEntities;
import net.steiner.efac.entity.ModBoats;
import net.steiner.efac.entity.ModEntities;
import net.steiner.efac.event.ModEntityEventOnLoad;
import net.steiner.efac.event.ModPlayerEventCopyFrom;
import net.steiner.efac.item.ModItemGroups;
import net.steiner.efac.item.ModItems;
import net.steiner.efac.networking.ModMessages;
import net.steiner.efac.recipe.ModRecipes;
import net.steiner.efac.screen.ModScreenHandlers;
import net.steiner.efac.sound.ModSounds;

public class ModRegistries {
    public static void registerModRegistries() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModEntities.registerModEntities();
        ModBlockEntities.registerBlockEntities();
        ModBoats.registerBoats();
        ModDamage.registerModDamage();
        ModSounds.registerSounds();
        ModRecipes.registerRecipes();
        ModMessages.regsiterC2SPackets();
        ModScreenHandlers.registerScreenHandlers();

        ModLootTableModifiers.modifyLootTables();

        registerStrippables();
        registerFlammables();
        registerEvents();
    }

    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.PRIMA_LOG, ModBlocks.STRIPPED_PRIMA_LOG);
        StrippableBlockRegistry.register(ModBlocks.PRIMA_WOOD, ModBlocks.STRIPPED_PRIMA_WOOD);
    }

    private static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PRIMA_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PRIMA_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PRIMA_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PRIMA_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PRIMA_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PRIMA_LOG, 30, 60);
    }

    private static void registerEvents() {
        ServerPlayerEvents.COPY_FROM.register(new ModPlayerEventCopyFrom());
        ServerEntityEvents.ENTITY_LOAD.register(new ModEntityEventOnLoad());
    }

}
