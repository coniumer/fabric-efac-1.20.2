package net.steiner.efac.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> CLUMBVESTIGATABLE =
                createTag("clumbvestigatable");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(EFAC.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> IS_CLUMB_FOOD =
                createTag("is_clumb_food");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(EFAC.MOD_ID, name));
        }
    }
}
