package net.steiner.efac.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PHILOSOPHERS_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PHILOSOPHERS_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALB_GEM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CIT_GEM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUB_GEM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GELWOOD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COMPACT_DOM);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUTTER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.YES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ETHER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FISH_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRONE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GEUMB_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUDDING_GEUMB);
        blockStateModelGenerator.registerAmethyst(ModBlocks.GEUMB_CLUSTER);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_GEUMB_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_GEUMB_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_GEUMB_BUD);

        blockStateModelGenerator.registerLog(ModBlocks.PRIMA_LOG).log(ModBlocks.PRIMA_LOG).wood(ModBlocks.PRIMA_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_PRIMA_LOG).log(ModBlocks.STRIPPED_PRIMA_LOG).wood(ModBlocks.STRIPPED_PRIMA_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRIMA_LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.PRIMA_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        BlockStateModelGenerator.BlockTexturePool prima_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PRIMA_PLANKS);
        prima_pool.stairs(ModBlocks.PRIMA_STAIRS);
        prima_pool.slab(ModBlocks.PRIMA_SLAB);
        prima_pool.button(ModBlocks.PRIMA_BUTTON);
        prima_pool.pressurePlate(ModBlocks.PRIMA_PRESSURE_PLATE);
        prima_pool.fence(ModBlocks.PRIMA_FENCE);
        prima_pool.fenceGate(ModBlocks.PRIMA_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.PRIMA_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PRIMA_TRAPDOOR);
        prima_pool.family(ModBlocks.PRIMA_FAMILY);

        BlockStateModelGenerator.BlockTexturePool gelwood_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GELWOOD_PLANKS);
        gelwood_pool.stairs(ModBlocks.GELWOOD_STAIRS);
        gelwood_pool.slab(ModBlocks.GELWOOD_SLAB);
        gelwood_pool.button(ModBlocks.GELWOOD_BUTTON);
        gelwood_pool.pressurePlate(ModBlocks.GELWOOD_PRESSURE_PLATE);
        gelwood_pool.fence(ModBlocks.GELWOOD_FENCE);
        gelwood_pool.fenceGate(ModBlocks.GELWOOD_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.GELWOOD_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.GELWOOD_TRAPDOOR);

        BlockStateModelGenerator.BlockTexturePool blone_brick_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BLONE_BRICKS);
        blone_brick_pool.stairs(ModBlocks.BLONE_BRICK_STAIRS);
        blone_brick_pool.slab(ModBlocks.BLONE_BRICK_SLAB);
        blone_brick_pool.wall(ModBlocks.BLONE_BRICK_WALL);

        BlockStateModelGenerator.BlockTexturePool polished_blone_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_BLONE);
        polished_blone_pool.stairs(ModBlocks.POLISHED_BLONE_STAIRS);
        polished_blone_pool.slab(ModBlocks.POLISHED_BLONE_SLAB);
        polished_blone_pool.wall(ModBlocks.POLISHED_BLONE_WALL);

        BlockStateModelGenerator.BlockTexturePool plone_brick_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PLONE_BRICKS);
        plone_brick_pool.stairs(ModBlocks.PLONE_BRICK_STAIRS);
        plone_brick_pool.slab(ModBlocks.PLONE_BRICK_SLAB);
        plone_brick_pool.wall(ModBlocks.PLONE_BRICK_WALL);

        BlockStateModelGenerator.BlockTexturePool polished_plone_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_PLONE);
        polished_plone_pool.stairs(ModBlocks.POLISHED_PLONE_STAIRS);
        polished_plone_pool.slab(ModBlocks.POLISHED_PLONE_SLAB);
        polished_plone_pool.wall(ModBlocks.POLISHED_PLONE_WALL);

        BlockStateModelGenerator.BlockTexturePool rone_brick_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RONE_BRICKS);
        rone_brick_pool.stairs(ModBlocks.RONE_BRICK_STAIRS);
        rone_brick_pool.slab(ModBlocks.RONE_BRICK_SLAB);
        rone_brick_pool.wall(ModBlocks.RONE_BRICK_WALL);

        BlockStateModelGenerator.BlockTexturePool polished_rone_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_RONE);
        polished_rone_pool.stairs(ModBlocks.POLISHED_RONE_STAIRS);
        polished_rone_pool.slab(ModBlocks.POLISHED_RONE_SLAB);
        polished_rone_pool.wall(ModBlocks.POLISHED_RONE_WALL);

        BlockStateModelGenerator.BlockTexturePool grone_brick_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GRONE_BRICKS);
        grone_brick_pool.stairs(ModBlocks.GRONE_BRICK_STAIRS);
        grone_brick_pool.slab(ModBlocks.GRONE_BRICK_SLAB);
        grone_brick_pool.wall(ModBlocks.GRONE_BRICK_WALL);

        BlockStateModelGenerator.BlockTexturePool polished_grone_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_GRONE);
        polished_grone_pool.stairs(ModBlocks.POLISHED_GRONE_STAIRS);
        polished_grone_pool.slab(ModBlocks.POLISHED_GRONE_SLAB);
        polished_grone_pool.wall(ModBlocks.POLISHED_GRONE_WALL);

        blockStateModelGenerator.registerCrop(ModBlocks.CLUMBROT_CROP, ClumbrotCropBlock.AGE, 0,1,2,3,4,5);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //valuables
            //ores
        itemModelGenerator.register(ModItems.RAW_SLIPULON, Models.GENERATED);
        itemModelGenerator.register(ModItems.SLIPULON_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ALB_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CIT_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUB_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PHILOSOPHERS_STONE, Models.GENERATED);
            //sauce
        itemModelGenerator.register(ModItems.RANDOM_SAUCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.YUMMY_SAUCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AWESOME_SAUCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.EPIC_SAUCE, Models.GENERATED);
            //geumb
        itemModelGenerator.register(ModItems.GEUMB_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLUMBY_GEUMB_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.ALBY_GEUMB_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CITRY_GEUMB_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBIED_GEUMB_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.GEUMB_CLUSTER.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.LARGE_GEUMB_BUD.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.MEDIUM_GEUMB_BUD.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.SMALL_GEUMB_BUD.asItem(), Models.GENERATED);
            //materia
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
        itemModelGenerator.register(ModItems.BURNED_CHICKEN, Models.GENERATED);
            //teeth
        itemModelGenerator.register(ModItems.TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNIPERS_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.LUXURY_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.HUNTERS_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUMMY_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADVENTURERS_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARCHITECTS_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.EXCAVATORS_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAVY_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.FORCE_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.RADIANT_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPINE_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.MIDAS_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.OBSERVANT_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARDBOARD_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_TOOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.PHILOSOPHERS_TOOTH, Models.GENERATED);
        //tools
        itemModelGenerator.register(ModItems.DRAGON_BLOOD_BUCKET, Models.GENERATED);
            //charms
        itemModelGenerator.register(ModItems.BLINK_CHARM, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIGHTNING_CHARM, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIREBALL_CHARM, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOMB_CHARM, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEALTH_CHARM, Models.GENERATED);
        itemModelGenerator.register(ModItems.STORAGE_CHARM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PHILOSOPHER_CHARM, Models.GENERATED);
            //wands
        itemModelGenerator.register(ModItems.WOOD_CLUMB_WAND, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ALB_CLUMB_WAND, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CIT_CLUMB_WAND, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUB_CLUMB_WAND, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PHILOSOPHERS_WAND, Models.HANDHELD);
            //philosophers gear
        itemModelGenerator.register(ModItems.PHILOSOPHERS_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PHILOSOPHERS_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PHILOSOPHERS_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PHILOSOPHERS_HOE, Models.HANDHELD);
            //philosophers armor
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PHILOSOPHERS_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PHILOSOPHERS_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PHILOSOPHERS_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PHILOSOPHERS_BOOTS);
        //smithing
        itemModelGenerator.register(ModItems.PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        //wood items
        itemModelGenerator.register(ModItems.PRIMA_HANGING_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIMA_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIMA_CHEST_BOAT, Models.GENERATED);
    }
}
