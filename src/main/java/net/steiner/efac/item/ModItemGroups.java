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

    public static final ItemGroup SLIPULON_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(EFAC.MOD_ID, "slipulon_ingot"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.slipulon_ingot"))
                    .icon(() -> new ItemStack(ModItems.SLIPULON_INGOT)).entries((displayContext, entries) -> {
                        // Items
                            //valuables
                        entries.add(ModItems.RAW_SLIPULON);
                        entries.add(ModItems.SLIPULON_INGOT);
                        entries.add(ModItems.ALB_GEM);
                        entries.add(ModItems.CIT_GEM);
                        entries.add(ModItems.RUB_GEM);
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
                                //misc
                        entries.add(ModItems.CLUMBVESTIGATOR);

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
                        entries.add(ModItems.PRIMA_SIGN);
                        entries.add(ModItems.PRIMA_HANGING_SIGN);
                        entries.add(ModBlocks.COMPACT_DOM);
                        entries.add(ModBlocks.BUTTER);
                        entries.add(ModBlocks.YES);
                    }).build());

    public static void registerItemGroups() {
        EFAC.LOGGER.info("Registering Item Groups for " + EFAC.MOD_ID);
    }
}
