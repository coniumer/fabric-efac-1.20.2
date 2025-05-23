package net.steiner.efac.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.item.custom.*;

public class ModItems {

    //valuables
    public static final Item SLIPULON_INGOT = registerItem("slipulon_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_SLIPULON = registerItem("raw_slipulon", new Item(new FabricItemSettings()));
    public static final Item ALB_GEM = registerItem("alb_gem", new Item(new FabricItemSettings()));
    public static final Item CIT_GEM = registerItem("cit_gem", new Item(new FabricItemSettings()));
    public static final Item RUB_GEM = registerItem("rub_gem", new Item(new FabricItemSettings()));
    public static final Item RANDOM_SAUCE = registerItem("random_sauce", new Item(new FabricItemSettings()));
    public static final Item YUMMY_SAUCE = registerItem("yummy_sauce", new Item(new FabricItemSettings()));
    public static final Item AWESOME_SAUCE = registerItem("awesome_sauce", new Item(new FabricItemSettings()));
    public static final Item EPIC_SAUCE = registerItem("epic_sauce", new Item(new FabricItemSettings()));
    public static final Item GEUMB_SHARD = registerItem("geumb_shard", new Item(new FabricItemSettings()));
    public static final Item CLUMBY_GEUMB_SHARD = registerItem("clumby_geumb_shard", new GeumbItem(new FabricItemSettings()));
    public static final Item ALBY_GEUMB_SHARD = registerItem("alby_geumb_shard", new GeumbItem(new FabricItemSettings()));
    public static final Item CITRY_GEUMB_SHARD = registerItem("citry_geumb_shard", new GeumbItem(new FabricItemSettings()));
    public static final Item RUBIED_GEUMB_SHARD = registerItem("rubied_geumb_shard", new GeumbItem(new FabricItemSettings()));
    public static final Item GELWOOD_ORB = registerItem("gelwood_orb", new Item(new FabricItemSettings()));
    //foods + crops
    public static final Item CLUMB_MATERIA = registerItem("clumb_materia", new Item(new FabricItemSettings().food(ModFoodComponents.CLUMB_MATERIA)));
    public static final Item ALB_CLUMB_MATERIA = registerItem("alb_clumb_materia", new Item(new FabricItemSettings().food(ModFoodComponents.CLUMB_MATERIA)));
    public static final Item CIT_CLUMB_MATERIA = registerItem("cit_clumb_materia", new Item(new FabricItemSettings().food(ModFoodComponents.CLUMB_MATERIA)));
    public static final Item RUB_CLUMB_MATERIA = registerItem("rub_clumb_materia", new Item(new FabricItemSettings().food(ModFoodComponents.CLUMB_MATERIA)));
    public static final Item BUTTER_STICK = registerItem("butter_stick", new Item(new FabricItemSettings().food(ModFoodComponents.BUTTER_STICK)));
    public static final Item CLUMBELON = registerItem("clumbelon", new Item(new FabricItemSettings().food(ModFoodComponents.CLUMBELON)));
    public static final Item CLUMBKIE = registerItem("clumbkie", new Item(new FabricItemSettings().food(ModFoodComponents.CLUMBKIE)));
    public static final Item BLUMB = registerItem("blumb", new Item(new FabricItemSettings().food(ModFoodComponents.BLUMB)));
    public static final Item CLUMBROT = registerItem("clumbrot", new AliasedBlockItem(ModBlocks.CLUMBROT_CROP, new FabricItemSettings().food(ModFoodComponents.CLUMBROT)));
    public static final Item GOLD_CLUMBROT = registerItem("gold_clumbrot", new Item(new FabricItemSettings().food(ModFoodComponents.GOLD_CLUMBROT)));
    public static final Item CLUMBLE = registerItem("clumble", new Item(new FabricItemSettings().food(ModFoodComponents.CLUMBLE)));
    public static final Item GOLD_CLUMBLE = registerItem("gold_clumble", new Item(new FabricItemSettings().food(ModFoodComponents.GOLD_CLUMBLE)));
    public static final Item CLUMBURGER = registerItem("clumburger", new Item(new FabricItemSettings().food(ModFoodComponents.CLUMBURGER)));
    //wands
    public static final Item WOOD_CLUMB_WAND = registerItem("wood_clumb_wand",
            new WandItem(ModToolMaterial.CLUMB_MATERIA, ModToolMaterial.CLUMB_MATERIA, new FabricItemSettings().maxCount(1)));
    public static final Item ALB_CLUMB_WAND = registerItem("alb_clumb_wand",
            new WandItem(ModToolMaterial.ALEBEDIZED, ModToolMaterial.ALEBEDIZED, new FabricItemSettings().maxCount(1)));
    public static final Item CIT_CLUMB_WAND = registerItem("cit_clumb_wand",
            new WandItem(ModToolMaterial.CITRINIZED, ModToolMaterial.CITRINIZED, new FabricItemSettings().maxCount(1)));
    public static final Item RUB_CLUMB_WAND = registerItem("rub_clumb_wand",
            new WandItem(ModToolMaterial.RUBEDIZED, ModToolMaterial.RUBEDIZED, new FabricItemSettings().maxCount(1)));
    //misc
    public static final Item CLUMBVESTIGATOR = registerItem("clumbvestigator",
            new ClumbvestigatorItem(new FabricItemSettings().maxCount(1)));
    //signs
    public static final Item PRIMA_SIGN = registerItem("prima_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.PRIMA_SIGN, ModBlocks.PRIMA_WALL_SIGN));
    public static final Item PRIMA_HANGING_SIGN = registerItem("prima_hanging_sign",
            new HangingSignItem(ModBlocks.PRIMA_HANGING_SIGN, ModBlocks.PRIMA_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(EFAC.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EFAC.LOGGER.info("Registering Mod Items for " + EFAC.MOD_ID);
    }
}
