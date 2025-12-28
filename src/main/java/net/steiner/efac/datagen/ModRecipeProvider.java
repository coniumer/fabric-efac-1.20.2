package net.steiner.efac.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.item.ModItems;
import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    private static final List<ItemConvertible> SLIPULON_SMELTABLES = List.of(ModItems.RAW_SLIPULON,
            ModBlocks.SLIPULON_ORE);
    private static final List<ItemConvertible> CLUMB_MATERIA_SMELTABLES = List.of(ModBlocks.COMPACT_DOM);

    @Override
    public void generate(RecipeExporter exporter) {
        //cooking
        offerSmelting(exporter, SLIPULON_SMELTABLES, RecipeCategory.MISC, ModItems.SLIPULON_INGOT,
                0.7f, 200, "slipulon_ingot");
        offerBlasting(exporter, SLIPULON_SMELTABLES, RecipeCategory.MISC, ModItems.SLIPULON_INGOT,
                0.7f, 200, "slipulon_ingot");
        offerSmelting(exporter, CLUMB_MATERIA_SMELTABLES, RecipeCategory.MISC, ModItems.CLUMB_MATERIA,
                0.7f, 200, "clumb_materia");
        offerBlasting(exporter, CLUMB_MATERIA_SMELTABLES, RecipeCategory.MISC, ModItems.CLUMB_MATERIA,
                0.7f, 200, "clumb_materia");

        //compacting
        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GELWOOD_PLANKS,
                ModItems.GELWOOD_ORB);
        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, ModBlocks.COMPACT_DOM, Blocks.DIRT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SLIPULON_INGOT,
                RecipeCategory.DECORATIONS, ModBlocks.SLIPULON_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.GEUMB_SHARD,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.GEUMB_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.CLUMB_MATERIA,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.CLUMB_BLOCK);

        //gelwood
        createDoorRecipe(ModBlocks.GELWOOD_DOOR, Ingredient.ofItems(ModBlocks.GELWOOD_PLANKS))
                .criterion(hasItem(ModBlocks.GELWOOD_PLANKS), conditionsFromItem(ModBlocks.GELWOOD_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GELWOOD_DOOR)));
        createFenceRecipe(ModBlocks.GELWOOD_FENCE, Ingredient.ofItems(ModBlocks.GELWOOD_PLANKS))
                .criterion(hasItem(ModBlocks.GELWOOD_PLANKS), conditionsFromItem(ModBlocks.GELWOOD_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GELWOOD_FENCE)));
        createFenceGateRecipe(ModBlocks.GELWOOD_FENCE_GATE, Ingredient.ofItems(ModBlocks.GELWOOD_PLANKS))
                .criterion(hasItem(ModBlocks.GELWOOD_PLANKS), conditionsFromItem(ModBlocks.GELWOOD_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GELWOOD_FENCE_GATE)));
        offerPressurePlateRecipe(exporter, ModBlocks.GELWOOD_PRESSURE_PLATE, ModBlocks.GELWOOD_PLANKS);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GELWOOD_SLAB, ModBlocks.GELWOOD_PLANKS);
        createStairsRecipe(ModBlocks.GELWOOD_STAIRS, Ingredient.ofItems(ModBlocks.GELWOOD_PLANKS))
                .criterion(hasItem(ModBlocks.GELWOOD_PLANKS), conditionsFromItem(ModBlocks.GELWOOD_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GELWOOD_STAIRS)));
        createTrapdoorRecipe(ModBlocks.GELWOOD_TRAPDOOR, Ingredient.ofItems(ModBlocks.GELWOOD_PLANKS))
                .criterion(hasItem(ModBlocks.GELWOOD_PLANKS), conditionsFromItem(ModBlocks.GELWOOD_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GELWOOD_TRAPDOOR)));

        //prima
        createDoorRecipe(ModBlocks.PRIMA_DOOR, Ingredient.ofItems(ModBlocks.PRIMA_PLANKS))
                .criterion(hasItem(ModBlocks.PRIMA_PLANKS), conditionsFromItem(ModBlocks.PRIMA_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PRIMA_DOOR)));
        createFenceRecipe(ModBlocks.PRIMA_FENCE, Ingredient.ofItems(ModBlocks.PRIMA_PLANKS))
                .criterion(hasItem(ModBlocks.PRIMA_PLANKS), conditionsFromItem(ModBlocks.PRIMA_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PRIMA_FENCE)));
        createFenceGateRecipe(ModBlocks.PRIMA_FENCE_GATE, Ingredient.ofItems(ModBlocks.PRIMA_PLANKS))
                .criterion(hasItem(ModBlocks.PRIMA_PLANKS), conditionsFromItem(ModBlocks.PRIMA_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PRIMA_FENCE_GATE)));
        offerPressurePlateRecipe(exporter, ModBlocks.PRIMA_PRESSURE_PLATE, ModBlocks.PRIMA_PLANKS);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIMA_SLAB, ModBlocks.PRIMA_PLANKS);
        createStairsRecipe(ModBlocks.PRIMA_STAIRS, Ingredient.ofItems(ModBlocks.PRIMA_PLANKS))
                .criterion(hasItem(ModBlocks.PRIMA_PLANKS), conditionsFromItem(ModBlocks.PRIMA_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PRIMA_STAIRS)));
        createTrapdoorRecipe(ModBlocks.PRIMA_TRAPDOOR, Ingredient.ofItems(ModBlocks.PRIMA_PLANKS))
                .criterion(hasItem(ModBlocks.PRIMA_PLANKS), conditionsFromItem(ModBlocks.PRIMA_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PRIMA_TRAPDOOR)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIMA_PLANKS, 4)
                .input(ModBlocks.PRIMA_LOG)
                .criterion(hasItem(ModBlocks.PRIMA_LOG.asItem()), conditionsFromItem(ModBlocks.PRIMA_LOG.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PRIMA_PLANKS)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIMA_PLANKS, 4)
                .input(ModBlocks.STRIPPED_PRIMA_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_PRIMA_LOG.asItem()), conditionsFromItem(ModBlocks.STRIPPED_PRIMA_LOG.asItem()))
                .offerTo(exporter, new Identifier("prima_planks_from_stripped"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIMA_PLANKS, 4)
                .input(ModBlocks.PRIMA_WOOD)
                .criterion(hasItem(ModBlocks.PRIMA_WOOD.asItem()), conditionsFromItem(ModBlocks.PRIMA_WOOD.asItem()))
                .offerTo(exporter, new Identifier("prima_planks_from_wood"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIMA_PLANKS, 4)
                .input(ModBlocks.STRIPPED_PRIMA_WOOD)
                .criterion(hasItem(ModBlocks.STRIPPED_PRIMA_WOOD.asItem()), conditionsFromItem(ModBlocks.STRIPPED_PRIMA_WOOD.asItem()))
                .offerTo(exporter, new Identifier("prima_planks_from_stripped_wood"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRIMA_WOOD, 3)
                .pattern("LL")
                .pattern("LL")
                .input('L', ModBlocks.PRIMA_LOG)
                .criterion(hasItem(ModBlocks.PRIMA_LOG.asItem()), conditionsFromItem(ModBlocks.PRIMA_LOG.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PRIMA_WOOD)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_PRIMA_WOOD, 3)
                .pattern("LL")
                .pattern("LL")
                .input('L', ModBlocks.STRIPPED_PRIMA_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_PRIMA_LOG.asItem()), conditionsFromItem(ModBlocks.STRIPPED_PRIMA_LOG.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.STRIPPED_PRIMA_WOOD)));

        //clumb foods
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CLUMBELON, 1)
                .input(ModItems.CLUMB_MATERIA)
                .input(Items.MELON_SLICE)
                .input(ModItems.BUTTER_STICK)
                .criterion(hasItem(ModItems.CLUMB_MATERIA), conditionsFromItem(ModItems.CLUMB_MATERIA))
                .criterion(hasItem(ModItems.BUTTER_STICK), conditionsFromItem(ModItems.BUTTER_STICK))
                .criterion(hasItem(Items.MELON_SLICE), conditionsFromItem(Items.MELON_SLICE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CLUMBELON)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CLUMBKIE, 1)
                .input(ModItems.CLUMB_MATERIA)
                .input(Items.COOKIE)
                .input(ModItems.BUTTER_STICK)
                .criterion(hasItem(ModItems.CLUMB_MATERIA), conditionsFromItem(ModItems.CLUMB_MATERIA))
                .criterion(hasItem(ModItems.BUTTER_STICK), conditionsFromItem(ModItems.BUTTER_STICK))
                .criterion(hasItem(Items.COOKIE), conditionsFromItem(Items.COOKIE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CLUMBKIE)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BLUMB, 1)
                .input(ModItems.CLUMB_MATERIA)
                .input(Items.BREAD)
                .input(ModItems.BUTTER_STICK)
                .criterion(hasItem(ModItems.CLUMB_MATERIA), conditionsFromItem(ModItems.CLUMB_MATERIA))
                .criterion(hasItem(ModItems.BUTTER_STICK), conditionsFromItem(ModItems.BUTTER_STICK))
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLUMB)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CLUMBROT, 1)
                .input(ModItems.CLUMB_MATERIA)
                .input(Items.CARROT)
                .input(ModItems.BUTTER_STICK)
                .criterion(hasItem(ModItems.CLUMB_MATERIA), conditionsFromItem(ModItems.CLUMB_MATERIA))
                .criterion(hasItem(ModItems.BUTTER_STICK), conditionsFromItem(ModItems.BUTTER_STICK))
                .criterion(hasItem(Items.CARROT), conditionsFromItem(Items.CARROT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CLUMBROT)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GOLD_CLUMBROT, 1)
                .input(ModItems.CLUMB_MATERIA)
                .input(Items.CARROT)
                .input(ModItems.BUTTER_STICK)
                .input(Items.GOLD_INGOT)
                .criterion(hasItem(ModItems.CLUMB_MATERIA), conditionsFromItem(ModItems.CLUMB_MATERIA))
                .criterion(hasItem(ModItems.BUTTER_STICK), conditionsFromItem(ModItems.BUTTER_STICK))
                .criterion(hasItem(Items.CARROT), conditionsFromItem(Items.CARROT))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GOLD_CLUMBROT)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CLUMBLE, 1)
                .input(ModItems.CLUMB_MATERIA)
                .input(Items.APPLE)
                .input(ModItems.BUTTER_STICK)
                .criterion(hasItem(ModItems.CLUMB_MATERIA), conditionsFromItem(ModItems.CLUMB_MATERIA))
                .criterion(hasItem(ModItems.BUTTER_STICK), conditionsFromItem(ModItems.BUTTER_STICK))
                .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CLUMBLE)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GOLD_CLUMBLE, 1)
                .input(ModItems.CLUMB_MATERIA)
                .input(Items.APPLE)
                .input(ModItems.BUTTER_STICK)
                .input(Items.GOLD_INGOT)
                .criterion(hasItem(ModItems.CLUMB_MATERIA), conditionsFromItem(ModItems.CLUMB_MATERIA))
                .criterion(hasItem(ModItems.BUTTER_STICK), conditionsFromItem(ModItems.BUTTER_STICK))
                .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GOLD_CLUMBLE)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CLUMBURGER, 1)
                .input(ModItems.CLUMB_MATERIA)
                .input(Items.COOKED_BEEF)
                .input(ModItems.BUTTER_STICK)
                .criterion(hasItem(ModItems.CLUMB_MATERIA), conditionsFromItem(ModItems.CLUMB_MATERIA))
                .criterion(hasItem(ModItems.BUTTER_STICK), conditionsFromItem(ModItems.BUTTER_STICK))
                .criterion(hasItem(Items.COOKED_BEEF), conditionsFromItem(Items.COOKED_BEEF))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CLUMBURGER)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModItems.GELWOOD_ORB, 4)
                .input(Items.SLIME_BALL)
                .input(ItemTags.PLANKS)
                .criterion(hasItem(ModItems.GELWOOD_ORB), conditionsFromItem(ModItems.GELWOOD_ORB))
                .criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GELWOOD_ORB)));

        //shaped
        //wands
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.WOOD_CLUMB_WAND, 1)
                .pattern("C")
                .pattern("S")
                .input('C', ModItems.CLUMB_MATERIA)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.CLUMB_MATERIA), conditionsFromItem(ModItems.CLUMB_MATERIA))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.WOOD_CLUMB_WAND)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ALB_CLUMB_WAND, 1)
                .pattern("C")
                .pattern("S")
                .input('C', ModItems.ALB_CLUMB_MATERIA)
                .input('S', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.ALB_CLUMB_MATERIA), conditionsFromItem(ModItems.ALB_CLUMB_MATERIA))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ALB_CLUMB_WAND)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CIT_CLUMB_WAND, 1)
                .pattern("C")
                .pattern("S")
                .input('C', ModItems.CIT_CLUMB_MATERIA)
                .input('S', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(ModItems.CIT_CLUMB_MATERIA), conditionsFromItem(ModItems.CIT_CLUMB_MATERIA))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CIT_CLUMB_WAND)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUB_CLUMB_WAND, 1)
                .pattern("C")
                .pattern("S")
                .input('C', ModItems.RUB_CLUMB_MATERIA)
                .input('S', Items.DIAMOND)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.RUB_CLUMB_MATERIA), conditionsFromItem(ModItems.RUB_CLUMB_MATERIA))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUB_CLUMB_WAND)));

        //clumb swords
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CLUMBY_SWORD, 1)
                .pattern("C")
                .pattern("C")
                .pattern("S")
                .input('C', ModItems.CLUMBY_GEUMB_SHARD)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.CLUMBY_GEUMB_SHARD), conditionsFromItem(ModItems.CLUMBY_GEUMB_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CLUMBY_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ALBY_SWORD, 1)
                .pattern("C")
                .pattern("C")
                .pattern("S")
                .input('C', ModItems.ALBY_GEUMB_SHARD)
                .input('S', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.ALBY_GEUMB_SHARD), conditionsFromItem(ModItems.ALBY_GEUMB_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ALBY_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CITRY_SWORD, 1)
                .pattern("C")
                .pattern("C")
                .pattern("S")
                .input('C', ModItems.CITRY_GEUMB_SHARD)
                .input('S', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(ModItems.CITRY_GEUMB_SHARD), conditionsFromItem(ModItems.CITRY_GEUMB_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CITRY_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBIED_SWORD, 1)
                .pattern("C")
                .pattern("C")
                .pattern("S")
                .input('C', ModItems.RUBIED_GEUMB_SHARD)
                .input('S', Items.DIAMOND)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.RUBIED_GEUMB_SHARD), conditionsFromItem(ModItems.RUBIED_GEUMB_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBIED_SWORD)));

        //philosopher upgrades
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.RUB_CLUMB_WAND),
                        Ingredient.ofItems(ModItems.PHILOSOPHERS_STONE), RecipeCategory.TOOLS, ModItems.PHILOSOPHERS_WAND)
                .criterion(hasItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.RUB_CLUMB_WAND), conditionsFromItem(ModItems.RUB_CLUMB_WAND))
                .criterion(hasItem(ModItems.PHILOSOPHERS_STONE), conditionsFromItem(ModItems.PHILOSOPHERS_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PHILOSOPHERS_WAND)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(Items.NETHERITE_SWORD),
                        Ingredient.ofItems(ModItems.PHILOSOPHERS_STONE), RecipeCategory.TOOLS, ModItems.PHILOSOPHERS_SWORD)
                .criterion(hasItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(Items.NETHERITE_SWORD), conditionsFromItem(Items.NETHERITE_SWORD))
                .criterion(hasItem(ModItems.PHILOSOPHERS_STONE), conditionsFromItem(ModItems.PHILOSOPHERS_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PHILOSOPHERS_SWORD)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(Items.NETHERITE_PICKAXE),
                        Ingredient.ofItems(ModItems.PHILOSOPHERS_STONE), RecipeCategory.TOOLS, ModItems.PHILOSOPHERS_PICKAXE)
                .criterion(hasItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(Items.NETHERITE_PICKAXE), conditionsFromItem(Items.NETHERITE_PICKAXE))
                .criterion(hasItem(ModItems.PHILOSOPHERS_STONE), conditionsFromItem(ModItems.PHILOSOPHERS_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PHILOSOPHERS_PICKAXE)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(Items.NETHERITE_AXE),
                        Ingredient.ofItems(ModItems.PHILOSOPHERS_STONE), RecipeCategory.TOOLS, ModItems.PHILOSOPHERS_AXE)
                .criterion(hasItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(Items.NETHERITE_AXE), conditionsFromItem(Items.NETHERITE_AXE))
                .criterion(hasItem(ModItems.PHILOSOPHERS_STONE), conditionsFromItem(ModItems.PHILOSOPHERS_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PHILOSOPHERS_AXE)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(Items.NETHERITE_HOE),
                        Ingredient.ofItems(ModItems.PHILOSOPHERS_STONE), RecipeCategory.TOOLS, ModItems.PHILOSOPHERS_HOE)
                .criterion(hasItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(Items.NETHERITE_HOE), conditionsFromItem(Items.NETHERITE_HOE))
                .criterion(hasItem(ModItems.PHILOSOPHERS_STONE), conditionsFromItem(ModItems.PHILOSOPHERS_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PHILOSOPHERS_HOE)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(Items.NETHERITE_SHOVEL),
                        Ingredient.ofItems(ModItems.PHILOSOPHERS_STONE), RecipeCategory.TOOLS, ModItems.PHILOSOPHERS_SHOVEL)
                .criterion(hasItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(Items.NETHERITE_SHOVEL), conditionsFromItem(Items.NETHERITE_SHOVEL))
                .criterion(hasItem(ModItems.PHILOSOPHERS_STONE), conditionsFromItem(ModItems.PHILOSOPHERS_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PHILOSOPHERS_SHOVEL)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(Items.NETHERITE_HELMET),
                        Ingredient.ofItems(ModItems.PHILOSOPHERS_STONE), RecipeCategory.TOOLS, ModItems.PHILOSOPHERS_HELMET)
                .criterion(hasItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(Items.NETHERITE_HELMET), conditionsFromItem(Items.NETHERITE_HELMET))
                .criterion(hasItem(ModItems.PHILOSOPHERS_STONE), conditionsFromItem(ModItems.PHILOSOPHERS_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PHILOSOPHERS_HELMET)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(Items.NETHERITE_CHESTPLATE),
                        Ingredient.ofItems(ModItems.PHILOSOPHERS_STONE), RecipeCategory.TOOLS, ModItems.PHILOSOPHERS_CHESTPLATE)
                .criterion(hasItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(Items.NETHERITE_CHESTPLATE), conditionsFromItem(Items.NETHERITE_CHESTPLATE))
                .criterion(hasItem(ModItems.PHILOSOPHERS_STONE), conditionsFromItem(ModItems.PHILOSOPHERS_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PHILOSOPHERS_CHESTPLATE)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(Items.NETHERITE_LEGGINGS),
                        Ingredient.ofItems(ModItems.PHILOSOPHERS_STONE), RecipeCategory.TOOLS, ModItems.PHILOSOPHERS_LEGGINGS)
                .criterion(hasItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(Items.NETHERITE_LEGGINGS), conditionsFromItem(Items.NETHERITE_LEGGINGS))
                .criterion(hasItem(ModItems.PHILOSOPHERS_STONE), conditionsFromItem(ModItems.PHILOSOPHERS_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PHILOSOPHERS_LEGGINGS)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(Items.NETHERITE_BOOTS),
                        Ingredient.ofItems(ModItems.PHILOSOPHERS_STONE), RecipeCategory.TOOLS, ModItems.PHILOSOPHERS_BOOTS)
                .criterion(hasItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(Items.NETHERITE_BOOTS), conditionsFromItem(Items.NETHERITE_BOOTS))
                .criterion(hasItem(ModItems.PHILOSOPHERS_STONE), conditionsFromItem(ModItems.PHILOSOPHERS_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PHILOSOPHERS_BOOTS)));

        //pickaxe, axe, shovel, hoe, helmet, chestplate, leggings, boots

        //gem clumbs
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ALB_CLUMB_MATERIA, 2)
                .pattern(" G ")
                .pattern("GCG")
                .pattern(" G ")
                .input('C', ModItems.CLUMB_MATERIA)
                .input('G', ModItems.ALB_GEM)
                .criterion(hasItem(ModItems.CLUMB_MATERIA), conditionsFromItem(ModItems.CLUMB_MATERIA))
                .criterion(hasItem(ModItems.ALB_GEM), conditionsFromItem(ModItems.ALB_GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ALB_CLUMB_MATERIA)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CIT_CLUMB_MATERIA, 2)
                .pattern(" G ")
                .pattern("GCG")
                .pattern(" G ")
                .input('C', ModItems.CLUMB_MATERIA)
                .input('G', ModItems.CIT_GEM)
                .criterion(hasItem(ModItems.CLUMB_MATERIA), conditionsFromItem(ModItems.CLUMB_MATERIA))
                .criterion(hasItem(ModItems.CIT_GEM), conditionsFromItem(ModItems.CIT_GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CIT_CLUMB_MATERIA)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RUB_CLUMB_MATERIA, 2)
                .pattern(" G ")
                .pattern("GCG")
                .pattern(" G ")
                .input('C', ModItems.CLUMB_MATERIA)
                .input('G', ModItems.RUB_GEM)
                .criterion(hasItem(ModItems.CLUMB_MATERIA), conditionsFromItem(ModItems.CLUMB_MATERIA))
                .criterion(hasItem(ModItems.RUB_GEM), conditionsFromItem(ModItems.RUB_GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUB_CLUMB_MATERIA)));

        //geumb variants
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CLUMBY_GEUMB_SHARD, 1)
                .pattern("SMS")
                .pattern("MGM")
                .pattern("SMS")
                .input('S', ModItems.RANDOM_SAUCE)
                .input('M', ModItems.CLUMB_MATERIA)
                .input('G', ModItems.GEUMB_SHARD)
                .criterion(hasItem(ModItems.GEUMB_SHARD), conditionsFromItem(ModItems.GEUMB_SHARD))
                .criterion(hasItem(ModItems.CLUMB_MATERIA), conditionsFromItem(ModItems.CLUMB_MATERIA))
                .criterion(hasItem(ModItems.RANDOM_SAUCE), conditionsFromItem(ModItems.RANDOM_SAUCE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CLUMBY_GEUMB_SHARD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ALBY_GEUMB_SHARD, 1)
                .pattern("SMS")
                .pattern("MGM")
                .pattern("SMS")
                .input('S', ModItems.YUMMY_SAUCE)
                .input('M', ModItems.ALB_CLUMB_MATERIA)
                .input('G', ModItems.GEUMB_SHARD)
                .criterion(hasItem(ModItems.GEUMB_SHARD), conditionsFromItem(ModItems.GEUMB_SHARD))
                .criterion(hasItem(ModItems.ALB_CLUMB_MATERIA), conditionsFromItem(ModItems.ALB_CLUMB_MATERIA))
                .criterion(hasItem(ModItems.YUMMY_SAUCE), conditionsFromItem(ModItems.YUMMY_SAUCE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ALBY_GEUMB_SHARD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CITRY_GEUMB_SHARD, 1)
                .pattern("SMS")
                .pattern("MGM")
                .pattern("SMS")
                .input('S', ModItems.AWESOME_SAUCE)
                .input('M', ModItems.CIT_CLUMB_MATERIA)
                .input('G', ModItems.GEUMB_SHARD)
                .criterion(hasItem(ModItems.GEUMB_SHARD), conditionsFromItem(ModItems.GEUMB_SHARD))
                .criterion(hasItem(ModItems.CIT_CLUMB_MATERIA), conditionsFromItem(ModItems.CIT_CLUMB_MATERIA))
                .criterion(hasItem(ModItems.AWESOME_SAUCE), conditionsFromItem(ModItems.AWESOME_SAUCE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CITRY_GEUMB_SHARD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBIED_GEUMB_SHARD, 1)
                .pattern("SMS")
                .pattern("MGM")
                .pattern("SMS")
                .input('S', ModItems.EPIC_SAUCE)
                .input('M', ModItems.RUB_CLUMB_MATERIA)
                .input('G', ModItems.GEUMB_SHARD)
                .criterion(hasItem(ModItems.GEUMB_SHARD), conditionsFromItem(ModItems.GEUMB_SHARD))
                .criterion(hasItem(ModItems.RUB_CLUMB_MATERIA), conditionsFromItem(ModItems.RUB_CLUMB_MATERIA))
                .criterion(hasItem(ModItems.EPIC_SAUCE), conditionsFromItem(ModItems.EPIC_SAUCE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBIED_GEUMB_SHARD)));

        //teeth
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOTH, 1)
                .input(Items.BONE_MEAL)
                .input(Items.BONE_MEAL)
                .input(ModItems.RANDOM_SAUCE)
                .criterion(hasItem(Items.BONE_MEAL), conditionsFromItem(Items.BONE_MEAL))
                .criterion(hasItem(ModItems.RANDOM_SAUCE), conditionsFromItem(ModItems.RANDOM_SAUCE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOTH)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.TOOTH),
                        Ingredient.ofItems(Items.FLINT), RecipeCategory.TOOLS, ModItems.SNIPERS_TOOTH)
                .criterion(hasItem(Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE), conditionsFromItem(Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.TOOTH), conditionsFromItem(ModItems.TOOTH))
                .criterion(hasItem(Items.FLINT), conditionsFromItem(Items.FLINT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SNIPERS_TOOTH)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.TOOTH),
                        Ingredient.ofItems(Items.EMERALD), RecipeCategory.TOOLS, ModItems.LUXURY_TOOTH)
                .criterion(hasItem(Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE), conditionsFromItem(Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.TOOTH), conditionsFromItem(ModItems.TOOTH))
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LUXURY_TOOTH)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.TOOTH),
                        Ingredient.ofItems(Items.SPIDER_EYE), RecipeCategory.TOOLS, ModItems.HUNTERS_TOOTH)
                .criterion(hasItem(Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE), conditionsFromItem(Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.TOOTH), conditionsFromItem(ModItems.TOOTH))
                .criterion(hasItem(Items.SPIDER_EYE), conditionsFromItem(Items.SPIDER_EYE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HUNTERS_TOOTH)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.TOOTH),
                        Ingredient.ofItems(Items.LAPIS_LAZULI), RecipeCategory.TOOLS, ModItems.BLUE_TOOTH)
                .criterion(hasItem(Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE), conditionsFromItem(Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.TOOTH), conditionsFromItem(ModItems.TOOTH))
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLUE_TOOTH)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.TOOTH),
                        Ingredient.ofItems(Items.SAND), RecipeCategory.TOOLS, ModItems.MUMMY_TOOTH)
                .criterion(hasItem(Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE), conditionsFromItem(Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.TOOTH), conditionsFromItem(ModItems.TOOTH))
                .criterion(hasItem(Blocks.SAND.asItem()), conditionsFromItem(Blocks.SAND.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MUMMY_TOOTH)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.TOOTH),
                        Ingredient.ofItems(Blocks.MUD.asItem()), RecipeCategory.TOOLS, ModItems.ADVENTURERS_TOOTH)
                .criterion(hasItem(Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE), conditionsFromItem(Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.TOOTH), conditionsFromItem(ModItems.TOOTH))
                .criterion(hasItem(Blocks.SAND.asItem()), conditionsFromItem(Blocks.SAND.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADVENTURERS_TOOTH)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.TOOTH),
                        Ingredient.ofItems(Blocks.BRICKS.asItem()), RecipeCategory.TOOLS, ModItems.ARCHITECTS_TOOTH)
                .criterion(hasItem(Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE), conditionsFromItem(Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.TOOTH), conditionsFromItem(ModItems.TOOTH))
                .criterion(hasItem(Blocks.BRICKS.asItem()), conditionsFromItem(Blocks.BRICKS.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ARCHITECTS_TOOTH)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.TOOTH),
                        Ingredient.ofItems(Blocks.COBBLESTONE.asItem()), RecipeCategory.TOOLS, ModItems.EXCAVATORS_TOOTH)
                .criterion(hasItem(Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE), conditionsFromItem(Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.TOOTH), conditionsFromItem(ModItems.TOOTH))
                .criterion(hasItem(Blocks.COBBLESTONE.asItem()), conditionsFromItem(Blocks.COBBLESTONE.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.EXCAVATORS_TOOTH)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.TOOTH),
                        Ingredient.ofItems(Blocks.IRON_BLOCK.asItem()), RecipeCategory.TOOLS, ModItems.HEAVY_TOOTH)
                .criterion(hasItem(Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE), conditionsFromItem(Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.TOOTH), conditionsFromItem(ModItems.TOOTH))
                .criterion(hasItem(Blocks.IRON_BLOCK.asItem()), conditionsFromItem(Blocks.IRON_BLOCK.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HEAVY_TOOTH)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.TOOTH),
                        Ingredient.ofItems(Items.ECHO_SHARD), RecipeCategory.TOOLS, ModItems.FORCE_TOOTH)
                .criterion(hasItem(Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE), conditionsFromItem(Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.TOOTH), conditionsFromItem(ModItems.TOOTH))
                .criterion(hasItem(Items.ECHO_SHARD), conditionsFromItem(Items.ECHO_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FORCE_TOOTH)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.TOOTH),
                        Ingredient.ofItems(Items.ECHO_SHARD), RecipeCategory.TOOLS, ModItems.RADIANT_TOOTH) //TODO: Warden drop for recipe
                .criterion(hasItem(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE), conditionsFromItem(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.TOOTH), conditionsFromItem(ModItems.TOOTH))
                .criterion(hasItem(Items.ECHO_SHARD), conditionsFromItem(Items.ECHO_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RADIANT_TOOTH)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.TOOTH),
                        Ingredient.ofItems(Items.PRISMARINE_SHARD), RecipeCategory.TOOLS, ModItems.SPINE_TOOTH)
                .criterion(hasItem(Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE), conditionsFromItem(Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.TOOTH), conditionsFromItem(ModItems.TOOTH))
                .criterion(hasItem(Items.PRISMARINE_SHARD), conditionsFromItem(Items.PRISMARINE_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SPINE_TOOTH)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.TOOTH),
                        Ingredient.ofItems(Blocks.GOLD_BLOCK.asItem()), RecipeCategory.TOOLS, ModItems.MIDAS_TOOTH)
                .criterion(hasItem(Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE), conditionsFromItem(Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.TOOTH), conditionsFromItem(ModItems.TOOTH))
                .criterion(hasItem(Blocks.GOLD_BLOCK.asItem()), conditionsFromItem(Blocks.GOLD_BLOCK.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MIDAS_TOOTH)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.TOOTH),
                        Ingredient.ofItems(Items.NETHER_BRICK), RecipeCategory.TOOLS, ModItems.SOUL_TOOTH)
                .criterion(hasItem(Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE), conditionsFromItem(Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.TOOTH), conditionsFromItem(ModItems.TOOTH))
                .criterion(hasItem(Items.NETHER_BRICK), conditionsFromItem(Items.NETHER_BRICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOUL_TOOTH)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.TOOTH),
                        Ingredient.ofItems(Items.ENDER_PEARL), RecipeCategory.TOOLS, ModItems.OBSERVANT_TOOTH)
                .criterion(hasItem(Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE), conditionsFromItem(Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.TOOTH), conditionsFromItem(ModItems.TOOTH))
                .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.OBSERVANT_TOOTH)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.TOOTH),
                        Ingredient.ofItems(Items.SHULKER_SHELL), RecipeCategory.TOOLS, ModItems.CARDBOARD_TOOTH)
                .criterion(hasItem(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE), conditionsFromItem(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.TOOTH), conditionsFromItem(ModItems.TOOTH))
                .criterion(hasItem(Items.SHULKER_SHELL), conditionsFromItem(Items.SHULKER_SHELL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CARDBOARD_TOOTH)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.TOOTH),
                        Ingredient.ofItems(Items.GOLD_INGOT), RecipeCategory.TOOLS, ModItems.GOLD_TOOTH)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.TOOTH), conditionsFromItem(ModItems.TOOTH))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GOLD_TOOTH)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(ModItems.TOOTH),
                        Ingredient.ofItems(ModItems.PHILOSOPHERS_STONE), RecipeCategory.TOOLS, ModItems.PHILOSOPHERS_TOOTH)
                .criterion(hasItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.TOOTH), conditionsFromItem(ModItems.TOOTH))
                .criterion(hasItem(ModItems.PHILOSOPHERS_STONE), conditionsFromItem(ModItems.PHILOSOPHERS_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PHILOSOPHERS_TOOTH)));

        //charms
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLINK_CHARM, 1)
                .pattern("EME")
                .pattern("ESE")
                .pattern("EEE")
                .input('E', Items.ENDER_PEARL)
                .input('M', ModItems.CLUMB_MATERIA)
                .input('S', ModItems.CLUMBY_GEUMB_SHARD)
                .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                .criterion(hasItem(ModItems.CLUMB_MATERIA), conditionsFromItem(ModItems.CLUMB_MATERIA))
                .criterion(hasItem(ModItems.CLUMBY_GEUMB_SHARD), conditionsFromItem(ModItems.CLUMBY_GEUMB_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLINK_CHARM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STORAGE_CHARM, 1)
                .pattern("EME")
                .pattern("ESE")
                .pattern("EEE")
                .input('E', Blocks.OBSIDIAN)
                .input('M', ModItems.CLUMB_MATERIA)
                .input('S', ModItems.CLUMBY_GEUMB_SHARD)
                .criterion(hasItem(Blocks.OBSIDIAN), conditionsFromItem(Blocks.OBSIDIAN))
                .criterion(hasItem(ModItems.CLUMB_MATERIA), conditionsFromItem(ModItems.CLUMB_MATERIA))
                .criterion(hasItem(ModItems.CLUMBY_GEUMB_SHARD), conditionsFromItem(ModItems.CLUMBY_GEUMB_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STORAGE_CHARM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LIGHTNING_CHARM, 1)
                .pattern("CMC")
                .pattern("CSC")
                .pattern("CCC")
                .input('C', Items.COPPER_INGOT)
                .input('M', ModItems.CIT_CLUMB_MATERIA)
                .input('S', ModItems.CITRY_GEUMB_SHARD)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(ModItems.CIT_CLUMB_MATERIA), conditionsFromItem(ModItems.CIT_CLUMB_MATERIA))
                .criterion(hasItem(ModItems.CITRY_GEUMB_SHARD), conditionsFromItem(ModItems.CITRY_GEUMB_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LIGHTNING_CHARM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FIREBALL_CHARM, 1)
                .pattern("BMB")
                .pattern("BSB")
                .pattern("BBB")
                .input('B', Items.BLAZE_POWDER)
                .input('M', ModItems.ALB_CLUMB_MATERIA)
                .input('S', ModItems.ALBY_GEUMB_SHARD)
                .criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
                .criterion(hasItem(ModItems.ALB_CLUMB_MATERIA), conditionsFromItem(ModItems.ALB_CLUMB_MATERIA))
                .criterion(hasItem(ModItems.ALBY_GEUMB_SHARD), conditionsFromItem(ModItems.ALBY_GEUMB_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FIREBALL_CHARM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BOMB_CHARM, 1)
                .pattern("BMB")
                .pattern("BSB")
                .pattern("BBB")
                .input('B', Blocks.TNT)
                .input('M', ModItems.RUB_CLUMB_MATERIA)
                .input('S', ModItems.RUBIED_GEUMB_SHARD)
                .criterion(hasItem(Blocks.TNT), conditionsFromItem(Blocks.TNT))
                .criterion(hasItem(ModItems.RUB_CLUMB_MATERIA), conditionsFromItem(ModItems.RUB_CLUMB_MATERIA))
                .criterion(hasItem(ModItems.RUBIED_GEUMB_SHARD), conditionsFromItem(ModItems.RUBIED_GEUMB_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BOMB_CHARM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HEALTH_CHARM, 1)
                .pattern("GMG")
                .pattern("GSG")
                .pattern("GGG")
                .input('G', Items.GLISTERING_MELON_SLICE)
                .input('M', ModItems.ALB_CLUMB_MATERIA)
                .input('S', ModItems.ALBY_GEUMB_SHARD)
                .criterion(hasItem(Items.GLISTERING_MELON_SLICE), conditionsFromItem(Items.GLISTERING_MELON_SLICE))
                .criterion(hasItem(ModItems.ALB_CLUMB_MATERIA), conditionsFromItem(ModItems.ALB_CLUMB_MATERIA))
                .criterion(hasItem(ModItems.ALBY_GEUMB_SHARD), conditionsFromItem(ModItems.ALBY_GEUMB_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HEALTH_CHARM)));

        //misc
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CLUMB_HARVESTER, 1)
                .pattern("MMM")
                .pattern("SSS")
                .pattern("SSS")
                .input('M', ModItems.CLUMB_MATERIA)
                .input('S', ModItems.SLIPULON_INGOT)
                .criterion(hasItem(ModItems.CLUMB_MATERIA), conditionsFromItem(ModItems.CLUMB_MATERIA))
                .criterion(hasItem(ModItems.SLIPULON_INGOT), conditionsFromItem(ModItems.SLIPULON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CLUMB_HARVESTER)));
    }
}
