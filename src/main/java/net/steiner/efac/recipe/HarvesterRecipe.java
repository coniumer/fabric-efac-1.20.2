package net.steiner.efac.recipe;

import com.google.common.collect.Lists;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.item.ModItems;

import java.util.List;

public class HarvesterRecipe {
    private static final List<Recipe> RECIPES = Lists.newArrayList();

    public static boolean hasRecipe(ItemStack input) {
        Item item = input.getItem();
        for (Recipe recipe : RECIPES) {
            if (recipe.input == item) {
                return true;
            }
        }
        return false;
    }

    public static List<Item> craft(ItemStack input, float[] rolls) {
        if (!input.isEmpty()) {
            List<Item> outputs = Lists.newArrayList();
            Item item = input.getItem();

            for (Recipe recipe : RECIPES) {
                if (recipe.input == item) {
                    for (int i = 0; i < rolls.length; i++) {
                        if (rolls[i] < recipe.chances[i]) {
                            outputs.add(recipe.outputs.get(i));
                        }
                    }
                }
            }

            return outputs;
        }

        return null;
    }

    public static void registerClumbHarvesterRecipes() {
        registerClumbHarvesterRecipe(ModBlocks.COMPACT_DOM.asItem(), ModItems.CLUMB_MATERIA, Blocks.DIRT.asItem(), ModItems.TOOTH,
                new float[] {1f, 0.4f, 0.1f});
        registerClumbHarvesterRecipe(ModBlocks.ETHER.asItem(), ModItems.GEUMB_SHARD, ModItems.YUMMY_SAUCE, ModItems.AWESOME_SAUCE,
                new float[] {1f, 0.9f, 0.5f});
        registerClumbHarvesterRecipe(ModBlocks.YES.asItem(), Items.IRON_INGOT, Items.DIAMOND, Items.NETHERITE_SCRAP,
                new float[] {0.7f, 0.4f, 0.1f});
        registerClumbHarvesterRecipe(ModBlocks.PRIMA_LEAVES.asItem(), ModBlocks.PRIMA_SAPLING.asItem(), ModItems.CLUMB_MATERIA, ModItems.CLUMBLE,
                new float[] {1f, 0.3f, 0.3f});
        registerClumbHarvesterRecipe(Blocks.GRAVEL.asItem(), Items.FLINT, ModItems.TOOTH, ModItems.CLUMB_MATERIA,
                new float[] {1f, 0.5f, 0.3f});
        registerClumbHarvesterRecipe(Blocks.SAND.asItem(), Items.FLINT, ModItems.TOOTH, ModItems.CLUMB_MATERIA,
                new float[] {1f, 0.5f, 0.3f});
        registerClumbHarvesterRecipe(Blocks.RED_SAND.asItem(), Items.FLINT, ModItems.TOOTH, ModItems.CLUMB_MATERIA,
                new float[] {1f, 0.5f, 0.3f});
    }

    public static void registerClumbHarvesterRecipe(Item input, Item mainOutput,
                                                    Item secondOutput, Item thirdOutput, float[] chances) {
        List<Item> outputs = Lists.newArrayList();
        outputs.add(mainOutput);
        outputs.add(secondOutput);
        outputs.add(thirdOutput);
        RECIPES.add(new Recipe(input, chances, outputs));
    }

    static class Recipe {
        final Item input;
        final float[] chances;
        final List<Item> outputs;

        public Recipe(Item input, float[] chances, List<Item> outputs) {
            this.input = input;
            this.chances = chances;
            this.outputs = outputs;
        }
    }
}
