package net.steiner.efac.util;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.block.entity.ModBlockEntities;
import net.steiner.efac.entity.ModBoats;
import net.steiner.efac.entity.ModEntities;
import net.steiner.efac.entity.effect.ModEffects;
import net.steiner.efac.event.ModEntityEventOnLoad;
import net.steiner.efac.event.ModPlayerEventCopyFrom;
import net.steiner.efac.fluid.ModFluids;
import net.steiner.efac.item.ModItemGroups;
import net.steiner.efac.item.ModItems;
import net.steiner.efac.networking.ModMessages;
import net.steiner.efac.recipe.HarvesterRecipe;
import net.steiner.efac.screen.ModScreenHandlers;
import net.steiner.efac.sound.ModSounds;
import net.steiner.efac.villager.ModVillagers;

public class ModRegistries {
    public static void registerModRegistries() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModEntities.registerModEntities();
        ModBlockEntities.registerBlockEntities();
        ModFluids.registerModFluids();
        HarvesterRecipe.registerClumbHarvesterRecipes();
        ModBoats.registerBoats();
        ModDamage.registerModDamage();
        ModSounds.registerSounds();
        ModMessages.regsiterC2SPackets();
        ModScreenHandlers.registerScreenHandlers();
        ModVillagers.registerVillagers();
        ModEffects.registerModEffects();

        ModLootTableModifiers.modifyLootTables();

        registerStrippables();
        registerFlammables();
        registerEvents();
        registerCustomTrades();
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
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PRIMA_LEAVES, 30, 60);
    }

    private static void registerEvents() {
        ServerPlayerEvents.COPY_FROM.register(new ModPlayerEventCopyFrom());
        ServerEntityEvents.ENTITY_LOAD.register(new ModEntityEventOnLoad());
    }

    private static void registerCustomTrades() {
        // Weaponsmith
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 1,
                factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.CLUMB_MATERIA, 8),
                    6, 5, 0.05f
            )));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 3,
                factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 10),
                    new ItemStack(ModItems.CIT_CLUMB_WAND, 1),
                    4, 15, 0.15f
            )));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 3,
                factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ModItems.CITRY_SWORD, 1),
                    4, 15, 0.2f
            )));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 5,
                factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 15),
                    new ItemStack(ModItems.RUB_CLUMB_WAND, 1),
                    3, 25, 0.15f
            )));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 5,
                factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 17),
                    new ItemStack(ModItems.RUBIED_SWORD, 1),
                    2, 30, 0.2f
            )));
                });

        //Clumbist
            //lv1
        TradeOfferHelper.registerVillagerOffers(ModVillagers.CLUMBIST, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(ModItems.CLUMB_MATERIA, 6),
                            8, 4, 0.05f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.CLUMBIST, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.GEUMB_SHARD, 4),
                            new ItemStack(Items.EMERALD, 3),
                            10, 4, 0.05f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.CLUMBIST, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(ModItems.CLUMBELON, 10),
                            8, 6, 0.05f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.CLUMBIST, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(ModItems.WOOD_CLUMB_WAND, 1),
                            5, 12, 0.1f
                    )));
                });

            //lv2
        TradeOfferHelper.registerVillagerOffers(ModVillagers.CLUMBIST, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(ModItems.RANDOM_SAUCE, 2),
                            6, 7, 0.15f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.CLUMBIST, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.ALB_GEM, 4),
                            new ItemStack(Items.EMERALD, 3),
                            10, 6, 0.05f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.CLUMBIST, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(ModItems.TOOTH, 12),
                            5, 6, 0.05f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.CLUMBIST, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 10),
                            new ItemStack(ModItems.BLINK_CHARM, 1),
                            4, 12, 0.1f
                    )));
                });

            //lv3
        TradeOfferHelper.registerVillagerOffers(ModVillagers.CLUMBIST, 3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 3),
                            new ItemStack(ModItems.YUMMY_SAUCE, 2),
                            6, 10, 0.2f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.CLUMBIST, 3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.CIT_GEM, 4),
                            new ItemStack(Items.EMERALD, 5),
                            9, 8, 0.05f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.CLUMBIST, 3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SLIPULON_INGOT, 4),
                            new ItemStack(Items.EMERALD, 3),
                            6, 8, 0.15f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.CLUMBIST, 3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 12),
                            new ItemStack(ModItems.HEALTH_CHARM, 1),
                            3, 16, 0.15f
                    )));
                });

            //lv4
        TradeOfferHelper.registerVillagerOffers(ModVillagers.CLUMBIST, 4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 5),
                            new ItemStack(ModItems.AWESOME_SAUCE, 2),
                            6, 16, 0.25f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.CLUMBIST, 4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RUB_GEM, 4),
                            new ItemStack(Items.EMERALD, 5),
                            9, 8, 0.05f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.CLUMBIST, 4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 14),
                            new ItemStack(ModItems.RUB_CLUMB_WAND, 1),
                            3, 25, 0.15f
                    )));
                });

            //lv5
        TradeOfferHelper.registerVillagerOffers(ModVillagers.CLUMBIST, 5,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 7),
                            new ItemStack(ModItems.EPIC_SAUCE, 2),
                            4, 18, 0.3f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.CLUMBIST, 5,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 21),
                            new ItemStack(ModItems.FIREBALL_CHARM, 1),
                            2, 30, 0.25f
                    )));
                });
    }
}
