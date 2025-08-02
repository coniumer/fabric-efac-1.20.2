package net.steiner.efac.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(EFAC.MOD_ID, ClumbHarvestingRecipe.Serializer.ID),
                ClumbHarvestingRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(EFAC.MOD_ID, ClumbHarvestingRecipe.Type.ID),
                ClumbHarvestingRecipe.Type.INSTANCE);
    }
}
