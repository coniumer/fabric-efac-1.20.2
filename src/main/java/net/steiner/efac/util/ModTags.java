package net.steiner.efac.util;

import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_PHILOSOHPERS_TOOL =
                createTag("needs_philosophers_tool");

        public static final TagKey<Block> PROVIDES_CHARGE_RARE =
                createTag("provides_charge_rare");

        public static final TagKey<Block> PROVIDES_CHARGE_COMMON =
                createTag("provides_charge_common");

        public static final TagKey<Block> PROVIDES_CHARGE_ALWAYS =
                createTag("provides_charge_always");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(EFAC.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> IS_CLUMB_FOOD =
                createTag("is_clumb_food");

        public static final TagKey<Item> IS_TOOTH =
                createTag("is_tooth");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(EFAC.MOD_ID, name));
        }
    }

    public static class Fluids {
        public static final TagKey<Fluid> DRAGON_BLOOD = createTag("dragon_blood");

        private static TagKey<Fluid> createTag(String id) {
            return TagKey.of(RegistryKeys.FLUID, new Identifier(EFAC.MOD_ID, id));
        }
    }
}
