package net.steiner.efac.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
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
    private static final Identifier DROWNED_ID = new Identifier(
            "minecraft", "entities/drowned");
    private static final Identifier HUSK_ID = new Identifier(
            "minecraft", "entities/husk");
    private static final Identifier SKELETON_ID = new Identifier(
            "minecraft", "entities/skeleton");
    private static final Identifier WITHER_SKELETON_ID = new Identifier(
            "minecraft", "entities/wither_skeleton");
    private static final Identifier STRAY_ID = new Identifier(
            "minecraft", "entities/stray");
    private static final Identifier CREEPER_ID = new Identifier(
            "minecraft", "entities/creeper");
    private static final Identifier SPIDER_ID = new Identifier(
            "minecraft", "entities/spider");
    private static final Identifier CAVE_SPIDER_ID = new Identifier(
            "minecraft", "entities/cave_spider");

    //bosses
    private static final Identifier WARDEN_ID = new Identifier(
            "minecraft", "entities/warden");
    private static final Identifier WITHER_ID = new Identifier(
            "minecraft", "entities/wither");
    private static final Identifier ENDER_DRAGON_ID = new Identifier(
            "minecraft", "entities/ender_dragon");

    //blocks
    private static final Identifier DIRT_ID = new Identifier(
            "minecraft", "blocks/dirt");
    private static final Identifier STONE_ID = new Identifier(
            "minecraft", "blocks/stone");
    private static final Identifier NETHERRACK_ID = new Identifier(
            "minecraft", "blocks/netherrack");
    private static final Identifier BLACKSTONE_ID = new Identifier(
            "minecraft", "blocks/blackstone");

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
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f))
                        .build());
                LootPool.Builder builder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.2f, 3f))
                        .with(ItemEntry.builder(Items.COAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f))
                        .build());
                tableBuilder.pool(builder.build());
                tableBuilder.pool(builder2.build());
            }
            if (DROWNED_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.3f, 3f))
                        .with(ItemEntry.builder(ModItems.CLUMB_MATERIA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f))
                        .build());
                LootPool.Builder builder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.2f, 3f))
                        .with(ItemEntry.builder(Items.COAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f))
                        .build());
                tableBuilder.pool(builder.build());
                tableBuilder.pool(builder2.build());
            }
            if (HUSK_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.4f, 3f))
                        .with(ItemEntry.builder(ModItems.CLUMB_MATERIA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f))
                        .build());
                LootPool.Builder builder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.2f, 3f))
                        .with(ItemEntry.builder(Items.COAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f))
                        .build());
                tableBuilder.pool(builder.build());
                tableBuilder.pool(builder2.build());
            }

            if (SKELETON_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.3f, 3f))
                        .with(ItemEntry.builder(ModItems.CLUMB_MATERIA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f))
                        .build());
                LootPool.Builder builder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.35f, 3f))
                        .with(ItemEntry.builder(Items.IRON_NUGGET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f))
                        .build());
                tableBuilder.pool(builder.build());
                tableBuilder.pool(builder2.build());
            }
            if (STRAY_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.35f, 3f))
                        .with(ItemEntry.builder(ModItems.CLUMB_MATERIA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f))
                        .build());
                LootPool.Builder builder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.35f, 3f))
                        .with(ItemEntry.builder(Items.IRON_NUGGET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f))
                        .build());
                tableBuilder.pool(builder.build());
                tableBuilder.pool(builder2.build());
            }
            if (WITHER_SKELETON_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.35f, 3f))
                        .with(ItemEntry.builder(ModItems.ALB_CLUMB_MATERIA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f))
                        .build());
                LootPool.Builder builder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.35f, 3f))
                        .with(ItemEntry.builder(ModItems.AWESOME_SAUCE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f))
                        .build());
                tableBuilder.pool(builder.build());
                tableBuilder.pool(builder2.build());
            }

            if (SPIDER_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.15f, 3f))
                        .with(ItemEntry.builder(ModItems.RANDOM_SAUCE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f))
                        .build());
                LootPool.Builder builder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.25f, 3f))
                        .with(ItemEntry.builder(Items.COAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f))
                        .build());
                tableBuilder.pool(builder.build());
                tableBuilder.pool(builder2.build());
            }
            if (CAVE_SPIDER_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.35f, 3f))
                        .with(ItemEntry.builder(ModItems.RANDOM_SAUCE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f))
                        .build());
                LootPool.Builder builder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.15f, 3f))
                        .with(ItemEntry.builder(Items.COAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f))
                        .build());
                tableBuilder.pool(builder.build());
                tableBuilder.pool(builder2.build());
            }

            if (CREEPER_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.3f, 3f))
                        .with(ItemEntry.builder(ModItems.RANDOM_SAUCE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f))
                        .build());
                LootPool.Builder builder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.25f, 3f))
                        .with(ItemEntry.builder(Items.IRON_NUGGET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f))
                        .build());
                tableBuilder.pool(builder.build());
                tableBuilder.pool(builder2.build());
            }

            //bosses
            if (WARDEN_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 3))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.5f, 3f))
                        .with(ItemEntry.builder(ModItems.AWESOME_SAUCE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f))
                        .build());
                tableBuilder.pool(builder.build());
            }
            if (WITHER_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 3))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.5f, 3f))
                        .with(ItemEntry.builder(ModItems.EPIC_SAUCE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f))
                        .build());
                tableBuilder.pool(builder.build());
            }
            if (ENDER_DRAGON_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(3, 9))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(1f, 3f))
                        .with(ItemEntry.builder(ModItems.EPIC_SAUCE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f))
                        .build());
                tableBuilder.pool(builder.build());
            }

            //blocks
            if (DIRT_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.05f, 3f))
                        .with(ItemEntry.builder(ModItems.TOOTH))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f))
                                .build());
                tableBuilder.pool(builder.build());
            }

            if (STONE_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.07f, 3f))
                        .with(ItemEntry.builder(Items.IRON_NUGGET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f))
                                .build());
                tableBuilder.pool(builder.build());
            }

            if (NETHERRACK_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.08f, 3f))
                        .with(ItemEntry.builder(Items.GOLD_NUGGET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f))
                                .build());
                tableBuilder.pool(builder.build());
            }

            if (BLACKSTONE_ID.equals(id) && source.isBuiltin()) {
                LootPool.Builder builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.02f, 3f))
                        .with(ItemEntry.builder(Items.DIAMOND))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f))
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
