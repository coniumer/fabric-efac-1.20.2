package net.steiner.efac.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.block.custom.ClumbrotCropBlock;
import net.steiner.efac.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SLIPULON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SLIPULON_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALB_GEM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CIT_GEM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUB_GEM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GELWOOD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COMPACT_DOM);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUTTER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.YES);

        blockStateModelGenerator.registerLog(ModBlocks.PRIMA_LOG).log(ModBlocks.PRIMA_LOG).wood(ModBlocks.PRIMA_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_PRIMA_LOG).log(ModBlocks.STRIPPED_PRIMA_LOG).wood(ModBlocks.STRIPPED_PRIMA_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRIMA_LEAVES);

        BlockStateModelGenerator.BlockTexturePool prima_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PRIMA_PLANKS);
        prima_pool.family(ModBlocks.PRIMA_FAMILY);

        BlockStateModelGenerator.BlockTexturePool gelwoodPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GELWOOD_PLANKS);
        gelwoodPool.stairs(ModBlocks.GELWOOD_STAIRS);
        gelwoodPool.slab(ModBlocks.GELWOOD_SLAB);
        gelwoodPool.button(ModBlocks.GELWOOD_BUTTON);
        gelwoodPool.pressurePlate(ModBlocks.GELWOOD_PRESSURE_PLATE);
        gelwoodPool.fence(ModBlocks.GELWOOD_FENCE);
        gelwoodPool.fenceGate(ModBlocks.GELWOOD_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.GELWOOD_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.GELWOOD_TRAPDOOR);

        blockStateModelGenerator.registerCrop(ModBlocks.CLUMBROT_CROP, ClumbrotCropBlock.AGE, 0,1,2,3,4,5);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //valuables
        itemModelGenerator.register(ModItems.RAW_SLIPULON, Models.GENERATED);
        itemModelGenerator.register(ModItems.SLIPULON_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ALB_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CIT_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUB_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ALB_CLUMB_MATERIA, Models.GENERATED);
        itemModelGenerator.register(ModItems.CIT_CLUMB_MATERIA, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUB_CLUMB_MATERIA, Models.GENERATED);
        itemModelGenerator.register(ModItems.GELWOOD_ORB, Models.GENERATED);
        //foods
        itemModelGenerator.register(ModItems.CLUMB_MATERIA, Models.GENERATED);
        itemModelGenerator.register(ModItems.BUTTER_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLUMBELON, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLUMBKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUMB, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_CLUMBROT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLUMBLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_CLUMBLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLUMBURGER, Models.GENERATED);
        //custom
        itemModelGenerator.register(ModItems.WOOD_CLUMB_WAND, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ALB_CLUMB_WAND, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CIT_CLUMB_WAND, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUB_CLUMB_WAND, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CLUMBVESTIGATOR, Models.HANDHELD);

        itemModelGenerator.register(ModItems.PRIMA_HANGING_SIGN, Models.GENERATED);
    }
}
