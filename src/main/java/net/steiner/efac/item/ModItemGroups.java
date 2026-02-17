package net.steiner.efac.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;
import net.steiner.efac.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup TOOTH_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(EFAC.MOD_ID, "tooth"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.efac.tooth"))
                    .icon(() -> new ItemStack(ModItems.TOOTH)).entries((displayContext, entries) -> {
                        entries.add(ModItems.TOOTH);
                        entries.add(ModItems.SNIPERS_TOOTH);
                        entries.add(ModItems.LUXURY_TOOTH);
                        entries.add(ModItems.HUNTERS_TOOTH);
                        entries.add(ModItems.BLUE_TOOTH);
                        entries.add(ModItems.MUMMY_TOOTH);
                        entries.add(ModItems.ADVENTURERS_TOOTH);
                        entries.add(ModItems.ARCHITECTS_TOOTH);
                        entries.add(ModItems.EXCAVATORS_TOOTH);
                        entries.add(ModItems.HEAVY_TOOTH);
                        entries.add(ModItems.FORCE_TOOTH);
                        entries.add(ModItems.RADIANT_TOOTH);
                        entries.add(ModItems.SPINE_TOOTH);
                        entries.add(ModItems.MIDAS_TOOTH);
                        entries.add(ModItems.SOUL_TOOTH);
                        entries.add(ModItems.OBSERVANT_TOOTH);
                        entries.add(ModItems.CARDBOARD_TOOTH);
                        entries.add(ModItems.GOLD_TOOTH);
                        entries.add(ModItems.PHILOSOPHERS_TOOTH);
                    }).build());

    public static final ItemGroup SLIPULON_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(EFAC.MOD_ID, "slipulon_ingot"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.efac.slipulon_ingot"))
                    .icon(() -> new ItemStack(ModBlocks.CLUMB_HARVESTER)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.CLUMB_HARVESTER);
                        // Items
                            //valuables
                        entries.add(ModItems.RAW_SLIPULON);
                        entries.add(ModItems.SLIPULON_INGOT);
                        entries.add(ModItems.ALB_GEM);
                        entries.add(ModItems.CIT_GEM);
                        entries.add(ModItems.RUB_GEM);
                        entries.add(ModItems.PHILOSOPHERS_STONE);
                        entries.add(ModItems.RANDOM_SAUCE);
                        entries.add(ModItems.YUMMY_SAUCE);
                        entries.add(ModItems.AWESOME_SAUCE);
                        entries.add(ModItems.EPIC_SAUCE);
                        entries.add(ModItems.GEUMB_SHARD);
                        entries.add(ModItems.CLUMBY_GEUMB_SHARD);
                        entries.add(ModItems.ALBY_GEUMB_SHARD);
                        entries.add(ModItems.CITRY_GEUMB_SHARD);
                        entries.add(ModItems.RUBIED_GEUMB_SHARD);
                        entries.add(ModItems.GELWOOD_ORB);
                            //foods
                        entries.add(ModItems.CLUMB_MATERIA);
                        entries.add(ModItems.ALB_CLUMB_MATERIA);
                        entries.add(ModItems.CIT_CLUMB_MATERIA);
                        entries.add(ModItems.RUB_CLUMB_MATERIA);
                        entries.add(ModItems.BUTTER_STICK);
                        entries.add(ModItems.BURNED_CHICKEN);
                        entries.add(ModItems.CLUMBELON);
                        entries.add(ModItems.CLUMBKIE);
                        entries.add(ModItems.BLUMB);
                        entries.add(ModItems.CLUMBROT);
                        entries.add(ModItems.GOLD_CLUMBROT);
                        entries.add(ModItems.CLUMBLE);
                        entries.add(ModItems.GOLD_CLUMBLE);
                        entries.add(ModItems.CLUMBURGER);
                            //custom
                                //wands
                        entries.add(ModItems.WOOD_CLUMB_WAND);
                        entries.add(ModItems.ALB_CLUMB_WAND);
                        entries.add(ModItems.CIT_CLUMB_WAND);
                        entries.add(ModItems.RUB_CLUMB_WAND);
                        entries.add(ModItems.PHILOSOPHERS_WAND);
                                //swords
                        entries.add(ModItems.CLUMBY_SWORD);
                        entries.add(ModItems.ALBY_SWORD);
                        entries.add(ModItems.CITRY_SWORD);
                        entries.add(ModItems.RUBIED_SWORD);
                        entries.add(ModItems.PHILOSOPHERS_SWORD);
                                //philosophers tools
                        entries.add(ModItems.PHILOSOPHERS_SHOVEL);
                        entries.add(ModItems.PHILOSOPHERS_PICKAXE);
                        entries.add(ModItems.PHILOSOPHERS_AXE);
                        entries.add(ModItems.PHILOSOPHERS_HOE);
                                //philosophers armor
                        entries.add(ModItems.PHILOSOPHERS_HELMET);
                        entries.add(ModItems.PHILOSOPHERS_CHESTPLATE);
                        entries.add(ModItems.PHILOSOPHERS_LEGGINGS);
                        entries.add(ModItems.PHILOSOPHERS_BOOTS);
                                //smithing
                        entries.add(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE);
                                //bucket
                        entries.add(ModItems.DRAGON_BLOOD_BUCKET);
                                //charms
                        entries.add(ModItems.BLINK_CHARM);
                        entries.add(ModItems.LIGHTNING_CHARM);
                        entries.add(ModItems.FIREBALL_CHARM);
                        entries.add(ModItems.BOMB_CHARM);
                        entries.add(ModItems.HEALTH_CHARM);
                        entries.add(ModItems.STORAGE_CHARM);
                        entries.add(ModItems.PHILOSOPHER_CHARM);
                        // Blocks
                        entries.add(ModBlocks.SLIPULON_ORE);
                        entries.add(ModBlocks.SLIPULON_BLOCK);
                        entries.add(ModBlocks.ALB_GEM_ORE);
                        entries.add(ModBlocks.CIT_GEM_ORE);
                        entries.add(ModBlocks.RUB_GEM_ORE);
                        entries.add(ModBlocks.GEUMB_BLOCK);
                        entries.add(ModBlocks.BUDDING_GEUMB);
                        entries.add(ModBlocks.GEUMB_CLUSTER);
                        entries.add(ModBlocks.GELWOOD_ORE);
                        entries.add(ModBlocks.GELWOOD_PLANKS);
                        entries.add(ModBlocks.GELWOOD_STAIRS);
                        entries.add(ModBlocks.GELWOOD_SLAB);
                        entries.add(ModBlocks.GELWOOD_FENCE);
                        entries.add(ModBlocks.GELWOOD_FENCE_GATE);
                        entries.add(ModBlocks.GELWOOD_DOOR);
                        entries.add(ModBlocks.GELWOOD_TRAPDOOR);
                        entries.add(ModBlocks.GELWOOD_BUTTON);
                        entries.add(ModBlocks.GELWOOD_PRESSURE_PLATE);
                        entries.add(ModBlocks.PRIMA_LOG);
                        entries.add(ModBlocks.STRIPPED_PRIMA_LOG);
                        entries.add(ModBlocks.PRIMA_WOOD);
                        entries.add(ModBlocks.STRIPPED_PRIMA_WOOD);
                        entries.add(ModBlocks.PRIMA_PLANKS);
                        entries.add(ModBlocks.PRIMA_STAIRS);
                        entries.add(ModBlocks.PRIMA_SLAB);
                        entries.add(ModBlocks.PRIMA_FENCE);
                        entries.add(ModBlocks.PRIMA_FENCE_GATE);
                        entries.add(ModBlocks.PRIMA_DOOR);
                        entries.add(ModBlocks.PRIMA_TRAPDOOR);
                        entries.add(ModBlocks.PRIMA_BUTTON);
                        entries.add(ModBlocks.PRIMA_PRESSURE_PLATE);
                        entries.add(ModBlocks.PRIMA_LEAVES);
                        entries.add(ModBlocks.PRIMA_SAPLING);
                        entries.add(ModItems.PRIMA_SIGN);
                        entries.add(ModItems.PRIMA_HANGING_SIGN);
                        entries.add(ModItems.PRIMA_BOAT);
                        entries.add(ModItems.PRIMA_CHEST_BOAT);
                        entries.add(ModBlocks.POLISHED_BLONE);
                        entries.add(ModBlocks.POLISHED_BLONE_STAIRS);
                        entries.add(ModBlocks.POLISHED_BLONE_SLAB);
                        entries.add(ModBlocks.POLISHED_BLONE_WALL);
                        entries.add(ModBlocks.BLONE_BRICKS);
                        entries.add(ModBlocks.BLONE_BRICK_STAIRS);
                        entries.add(ModBlocks.BLONE_BRICK_SLAB);
                        entries.add(ModBlocks.BLONE_BRICK_WALL);
                        entries.add(ModBlocks.POLISHED_PLONE);
                        entries.add(ModBlocks.POLISHED_PLONE_STAIRS);
                        entries.add(ModBlocks.POLISHED_PLONE_SLAB);
                        entries.add(ModBlocks.POLISHED_PLONE_WALL);
                        entries.add(ModBlocks.PLONE_BRICKS);
                        entries.add(ModBlocks.PLONE_BRICK_STAIRS);
                        entries.add(ModBlocks.PLONE_BRICK_SLAB);
                        entries.add(ModBlocks.PLONE_BRICK_WALL);
                        entries.add(ModBlocks.POLISHED_RONE);
                        entries.add(ModBlocks.POLISHED_RONE_STAIRS);
                        entries.add(ModBlocks.POLISHED_RONE_SLAB);
                        entries.add(ModBlocks.POLISHED_RONE_WALL);
                        entries.add(ModBlocks.RONE_BRICKS);
                        entries.add(ModBlocks.RONE_BRICK_STAIRS);
                        entries.add(ModBlocks.RONE_BRICK_SLAB);
                        entries.add(ModBlocks.RONE_BRICK_WALL);
                        entries.add(ModBlocks.COMPACT_DOM);
                        entries.add(ModBlocks.BUTTER);
                        entries.add(ModBlocks.YES);
                        entries.add(ModBlocks.ETHER);
                        entries.add(ModBlocks.CLUMB_BLOCK);
                        entries.add(ModBlocks.FISH_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        EFAC.LOGGER.info("Registering Item Groups for " + EFAC.MOD_ID);
    }
}
