package net.steiner.efac.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
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
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SLIPULON_INGOT,
                RecipeCategory.DECORATIONS, ModBlocks.SLIPULON_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Blocks.DIRT,
                RecipeCategory.MISC, ModBlocks.COMPACT_DOM);

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

        //shapeless
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WOOD_CLUMB_WAND, 1)
                .pattern("C")
                .pattern("S")
                .input('C', ModItems.CLUMB_MATERIA)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.CLUMB_MATERIA), conditionsFromItem(ModItems.CLUMB_MATERIA))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.WOOD_CLUMB_WAND)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ALB_CLUMB_WAND, 1)
                .pattern("C")
                .pattern("S")
                .input('C', ModItems.ALB_CLUMB_MATERIA)
                .input('S', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.ALB_CLUMB_MATERIA), conditionsFromItem(ModItems.ALB_CLUMB_MATERIA))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ALB_CLUMB_WAND)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CIT_CLUMB_WAND, 1)
                .pattern("C")
                .pattern("S")
                .input('C', ModItems.CIT_CLUMB_MATERIA)
                .input('S', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(ModItems.CIT_CLUMB_MATERIA), conditionsFromItem(ModItems.CIT_CLUMB_MATERIA))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CIT_CLUMB_WAND)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUB_CLUMB_WAND, 1)
                .pattern("C")
                .pattern("S")
                .input('C', ModItems.RUB_CLUMB_MATERIA)
                .input('S', Items.DIAMOND)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.RUB_CLUMB_MATERIA), conditionsFromItem(ModItems.RUB_CLUMB_MATERIA))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUB_CLUMB_WAND)));
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

        //misc
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CLUMBVESTIGATOR, 1)
                .pattern(" C ")
                .pattern("CGC")
                .pattern(" C ")
                .input('C', ModItems.CLUMB_MATERIA)
                .input('G', Blocks.GLASS)
                .criterion(hasItem(ModItems.CLUMB_MATERIA), conditionsFromItem(ModItems.CLUMB_MATERIA))
                .criterion(hasItem(Items.GLASS), conditionsFromItem(Items.GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CLUMBVESTIGATOR)));
    }
}
