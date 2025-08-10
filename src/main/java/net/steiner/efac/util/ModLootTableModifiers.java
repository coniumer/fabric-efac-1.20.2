package net.steiner.efac.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.condition.RandomChanceWithLootingLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.steiner.efac.item.ModItems;

public class ModLootTableModifiers {
    // entities
    private static final Identifier ZOMBIE_ID = new Identifier(
            "minecraft", "entities/zombie");
    private static final Identifier SKELETON_ID = new Identifier(
            "minecraft", "entities/skeleton");
    private static final Identifier CREEPER_ID = new Identifier(
            "minecraft", "entities/creeper");
    private static final Identifier SPIDER_ID = new Identifier(
            "minecraft", "entities/spider");

    // dungeon chests
    private static final Identifier PILLAGER_OUTPOST_ID = new Identifier(
            "minecraft", "chests/pillager_outpost");
    private static final Identifier WOODLAND_MANSION_ID = new Identifier(
            "minecraft", "chests/woodland_mansion");
    private static final Identifier SIMPLE_DUNGEON_ID = new Identifier(
            "minecraft", "chests/simple_dungeon");
    private static final Identifier VILLAGE_ARMORER_ID = new Identifier(
            "minecraft", "chests/village/village_armorer");
    private static final Identifier VILLAGE_MASON_ID = new Identifier(
            "minecraft", "chests/village/village_mason");
    private static final Identifier VILLAGE_PLAINS_HOUSE_ID = new Identifier(
            "minecraft", "chests/village/village_plains_house");
    private static final Identifier VILLAGE_SNOWY_HOUSE_ID = new Identifier(
            "minecraft", "chests/village/village_snowy_house");
    private static final Identifier VILLAGE_DESERT_HOUSE_ID = new Identifier(
            "minecraft", "chests/village/village_desert_house");
    private static final Identifier VILLAGE_SAVANNA_HOUSE_ID = new Identifier(
            "minecraft", "chests/village/village_savanna_house");
    private static final Identifier VILLAGE_TAIGA_HOUSE_ID = new Identifier(
            "minecraft", "chests/village/village_taiga_house");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            // entities
            if (ZOMBIE_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.1f, 3f))
                        .with(ItemEntry.builder(ModItems.CLUMB_MATERIA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f))
                        .build());
                tableBuilder.pool(builder.build());
            }

            if (SKELETON_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.3f, 3f))
                        .with(ItemEntry.builder(ModItems.CLUMB_MATERIA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f))
                        .build());
                tableBuilder.pool(builder.build());
            }

            if (SPIDER_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.15f, 3f))
                        .with(ItemEntry.builder(ModItems.RANDOM_SAUCE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f))
                        .build());
                tableBuilder.pool(builder.build());
            }

            if (CREEPER_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.3f, 3f))
                        .with(ItemEntry.builder(ModItems.RANDOM_SAUCE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f))
                        .build());
                tableBuilder.pool(builder.build());
            }

            // dungeon chests
            if (PILLAGER_OUTPOST_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(4))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModItems.YUMMY_SAUCE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f))
                        .build());
                tableBuilder.pool(builder.build());
            }

            if (WOODLAND_MANSION_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(12))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModItems.YUMMY_SAUCE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f))
                        .build());
                tableBuilder.pool(builder.build());
            }

            if (SIMPLE_DUNGEON_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModItems.CLUMB_MATERIA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 6.0f))
                        .build());
                tableBuilder.pool(builder.build());
            }

            if (VILLAGE_ARMORER_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(0.4f))
                        .with(ItemEntry.builder(ModItems.ALB_GEM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f))
                        .build());
                tableBuilder.pool(builder.build());
            }

            if (VILLAGE_MASON_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(4))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(ModItems.GELWOOD_ORB))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 8.0f))
                        .build());
                tableBuilder.pool(builder.build());
            }

            if (VILLAGE_PLAINS_HOUSE_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModItems.CLUMB_MATERIA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 6.0f))
                                .build());
                tableBuilder.pool(builder.build());
            }

            if (VILLAGE_SAVANNA_HOUSE_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModItems.CLUMB_MATERIA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 6.0f))
                                .build());
                tableBuilder.pool(builder.build());
            }

            if (VILLAGE_SNOWY_HOUSE_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModItems.CLUMB_MATERIA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 6.0f))
                                .build());
                tableBuilder.pool(builder.build());
            }

            if (VILLAGE_TAIGA_HOUSE_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModItems.CLUMB_MATERIA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 6.0f))
                                .build());
                tableBuilder.pool(builder.build());
            }

            if (VILLAGE_DESERT_HOUSE_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModItems.CLUMB_MATERIA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 6.0f))
                                .build());
                tableBuilder.pool(builder.build());
            }
        }));
    }

}
