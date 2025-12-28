package net.steiner.efac.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.item.ModItems;
import net.steiner.efac.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.GELWOOD_PLANKS.asItem())
                .add(ModBlocks.PRIMA_PLANKS.asItem())
        ;

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.PRIMA_LOG.asItem())
                .add(ModBlocks.PRIMA_WOOD.asItem())
                .add(ModBlocks.STRIPPED_PRIMA_LOG.asItem())
                .add(ModBlocks.STRIPPED_PRIMA_WOOD.asItem())
        ;

        getOrCreateTagBuilder(ModTags.Items.IS_CLUMB_FOOD)
                .add(ModItems.CLUMB_MATERIA)
                .add(ModItems.ALB_CLUMB_MATERIA)
                .add(ModItems.CIT_CLUMB_MATERIA)
                .add(ModItems.RUB_CLUMB_MATERIA)
                .add(ModItems.CLUMBELON)
                .add(ModItems.CLUMBKIE)
                .add(ModItems.BLUMB)
                .add(ModItems.CLUMBROT)
                .add(ModItems.GOLD_CLUMBROT)
                .add(ModItems.CLUMBLE)
                .add(ModItems.GOLD_CLUMBLE)
                .add(ModItems.CLUMBURGER)
        ;

        getOrCreateTagBuilder(ModTags.Items.IS_TOOTH)
                .add(ModItems.TOOTH)
                .add(ModItems.SNIPERS_TOOTH)
                .add(ModItems.LUXURY_TOOTH)
                .add(ModItems.HUNTERS_TOOTH)
                .add(ModItems.BLUE_TOOTH)
                .add(ModItems.MUMMY_TOOTH)
                .add(ModItems.ADVENTURERS_TOOTH)
                .add(ModItems.ARCHITECTS_TOOTH)
                .add(ModItems.EXCAVATORS_TOOTH)
                .add(ModItems.HEAVY_TOOTH)
                .add(ModItems.FORCE_TOOTH)
                .add(ModItems.RADIANT_TOOTH)
                .add(ModItems.SPINE_TOOTH)
                .add(ModItems.MIDAS_TOOTH)
                .add(ModItems.SOUL_TOOTH)
                .add(ModItems.OBSERVANT_TOOTH)
                .add(ModItems.CARDBOARD_TOOTH)
                .add(ModItems.GOLD_TOOTH)
                .add(ModItems.PHILOSOPHERS_TOOTH)
        ;

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.PHILOSOPHERS_HELMET, ModItems.PHILOSOPHERS_CHESTPLATE, ModItems.PHILOSOPHERS_LEGGINGS, ModItems.PHILOSOPHERS_BOOTS)
        ;
    }
}
