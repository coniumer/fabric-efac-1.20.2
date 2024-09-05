package net.steiner.efac.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;

public class ModItems {

    public static final Item SLIPULON_INGOT = registerItem("slipulon_ingot", new Item(new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(SLIPULON_INGOT);
    }

    private static Item registerItem(String name ,Item item) {
        return Registry.register(Registries.ITEM, new Identifier(EFAC.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EFAC.LOGGER.info("Registering Mod Items for " + EFAC.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
