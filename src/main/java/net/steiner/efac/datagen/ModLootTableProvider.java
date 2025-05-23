package net.steiner.efac.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.tag.ItemTags;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.block.custom.ClumbrotCropBlock;
import net.steiner.efac.item.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //regular
        addDrop(ModBlocks.SLIPULON_BLOCK);
        addDrop(ModBlocks.COMPACT_DOM);
        addDrop(ModBlocks.GELWOOD_PLANKS);
        addDrop(ModBlocks.GELWOOD_STAIRS);
        addDrop(ModBlocks.GELWOOD_TRAPDOOR);
        addDrop(ModBlocks.GELWOOD_BUTTON);
        addDrop(ModBlocks.GELWOOD_PRESSURE_PLATE);
        addDrop(ModBlocks.GELWOOD_FENCE);
        addDrop(ModBlocks.GELWOOD_FENCE_GATE);
        addDrop(ModBlocks.YES);

        addDrop(ModBlocks.GELWOOD_DOOR, doorDrops(ModBlocks.GELWOOD_DOOR));
        addDrop(ModBlocks.GELWOOD_SLAB, slabDrops(ModBlocks.GELWOOD_SLAB));

        addDrop(ModBlocks.PRIMA_LOG);
        addDrop(ModBlocks.STRIPPED_PRIMA_LOG);
        addDrop(ModBlocks.PRIMA_WOOD);
        addDrop(ModBlocks.STRIPPED_PRIMA_WOOD);
        addDrop(ModBlocks.PRIMA_PLANKS);
        addDrop(ModBlocks.PRIMA_STAIRS);
        addDrop(ModBlocks.PRIMA_TRAPDOOR);
        addDrop(ModBlocks.PRIMA_BUTTON);
        addDrop(ModBlocks.PRIMA_PRESSURE_PLATE);
        addDrop(ModBlocks.PRIMA_FENCE);
        addDrop(ModBlocks.PRIMA_FENCE_GATE);
        addDrop(ModBlocks.PRIMA_LEAVES, leavesDrops(ModBlocks.PRIMA_LEAVES, ModBlocks.BUTTER, 0.005f)); // TODO sapling

        addDrop(ModBlocks.PRIMA_DOOR, doorDrops(ModBlocks.PRIMA_DOOR));
        addDrop(ModBlocks.PRIMA_SLAB, slabDrops(ModBlocks.PRIMA_SLAB));

        //ore
        addDrop(ModBlocks.SLIPULON_ORE, multiOreDrops(ModBlocks.SLIPULON_ORE, ModItems.RAW_SLIPULON, 2.0f, 5.0f));
        addDrop(ModBlocks.ALB_GEM_ORE, multiOreDrops(ModBlocks.ALB_GEM_ORE, ModItems.ALB_GEM, 1.0f, 4.0f));
        addDrop(ModBlocks.CIT_GEM_ORE, multiOreDrops(ModBlocks.CIT_GEM_ORE, ModItems.CIT_GEM, 1.0f, 4.0f));
        addDrop(ModBlocks.RUB_GEM_ORE, multiOreDrops(ModBlocks.RUB_GEM_ORE, ModItems.RUB_GEM, 1.0f, 4.0f));
        addDrop(ModBlocks.BUTTER, multiOreDrops(ModBlocks.BUTTER, ModItems.BUTTER_STICK, 3.0f, 7.0f));
        addDrop(ModBlocks.GELWOOD_ORE, multiOreDrops(ModBlocks.GELWOOD_ORE, ModItems.GELWOOD_ORB, 3.0f, 5.0f));

        //geumbs
        addDrop(ModBlocks.GEUMB_BLOCK);
        addDropWithSilkTouch(ModBlocks.LARGE_GEUMB_BUD);
        addDropWithSilkTouch(ModBlocks.MEDIUM_GEUMB_BUD);
        addDropWithSilkTouch(ModBlocks.SMALL_GEUMB_BUD);
        addDropWithSilkTouch(ModBlocks.BUDDING_GEUMB);
        addDrop(
                ModBlocks.GEUMB_CLUSTER,
                block -> dropsWithSilkTouch(
                        block,
                        ItemEntry.builder(ModItems.GEUMB_SHARD)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                                .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ItemTags.CLUSTER_MAX_HARVESTABLES)))
                                .alternatively(
                                        this.applyExplosionDecay(
                                                block, ItemEntry.builder(Items.AMETHYST_SHARD).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2.0F)))
                                        )
                                )
                )
        );

        //crop
        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.CLUMBROT_CROP)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(ClumbrotCropBlock.AGE, 5));
        addDrop(ModBlocks.CLUMBROT_CROP, cropDrops(ModBlocks.CLUMBROT_CROP, ModItems.CLUMBROT, ModItems.CLUMBROT, builder));
    }

    public LootTable.Builder multiOreDrops(Block drop, Item item, Float min, Float max) {
        return dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }
}
