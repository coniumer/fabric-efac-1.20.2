package net.steiner.efac.block;

import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;
import net.steiner.efac.block.custom.ClumbrotCropBlock;
import net.steiner.efac.block.custom.YesBlock;
import net.steiner.efac.sound.ModSounds;

public class ModBlocks {

    //ore
    //slipulon
    public static final Block SLIPULON_ORE = registerBlock("slipulon_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block SLIPULON_BLOCK = registerBlock("slipulon_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    //gems
    public static final Block ALB_GEM_ORE = registerBlock("alb_gem_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block CIT_GEM_ORE = registerBlock("cit_gem_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block RUB_GEM_ORE = registerBlock("rub_gem_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));

    //gelwood
    public static final Block GELWOOD_ORE = registerBlock("gelwood_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.COAL_ORE)));
    public static final Block GELWOOD_PLANKS = registerBlock("gelwood_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

    //wood products
    public static final Block GELWOOD_STAIRS = registerBlock("gelwood_stairs",
            new StairsBlock(ModBlocks.GELWOOD_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block GELWOOD_SLAB = registerBlock("gelwood_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

    public static final Block GELWOOD_BUTTON = registerBlock("gelwood_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), BlockSetType.OAK, 10, true));
    public static final Block GELWOOD_PRESSURE_PLATE = registerBlock("gelwood_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), BlockSetType.OAK));

    public static final Block GELWOOD_FENCE = registerBlock("gelwood_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block GELWOOD_FENCE_GATE = registerBlock("gelwood_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), WoodType.OAK));

    public static final Block GELWOOD_DOOR = registerBlock("gelwood_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), BlockSetType.IRON));
    public static final Block GELWOOD_TRAPDOOR = registerBlock("gelwood_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), BlockSetType.IRON));

    // Prima Wood
    public static final Block PRIMA_LOG = registerBlock("prima_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4f)));
    public static final Block STRIPPED_PRIMA_LOG = registerBlock("stripped_prima_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(4f)));
    public static final Block PRIMA_WOOD = registerBlock("prima_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_PRIMA_WOOD = registerBlock("stripped_prima_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4f)));
    public static final Block PRIMA_PLANKS = registerBlock("prima_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)));
    public static final Block PRIMA_LEAVES = registerBlock("prima_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(4f).nonOpaque()));

    public static final Block PRIMA_STAIRS = registerBlock("prima_stairs",
            new StairsBlock(ModBlocks.PRIMA_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block PRIMA_SLAB = registerBlock("prima_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

    public static final Block PRIMA_BUTTON = registerBlock("prima_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), BlockSetType.OAK, 10, true));
    public static final Block PRIMA_PRESSURE_PLATE = registerBlock("prima_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), BlockSetType.OAK));

    public static final Block PRIMA_FENCE = registerBlock("prima_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block PRIMA_FENCE_GATE = registerBlock("prima_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), WoodType.OAK));

    public static final Block PRIMA_DOOR = registerBlock("prima_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), BlockSetType.OAK));
    public static final Block PRIMA_TRAPDOOR = registerBlock("prima_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), BlockSetType.OAK));

    public static final Identifier PRIMA_SIGN_TEXTURE = new Identifier(EFAC.MOD_ID, "entity/signs/prima");
    public static final Identifier PRIMA_HANGING_SIGN_TEXTURE = new Identifier(EFAC.MOD_ID, "entity/signs/prima/hanging");
    public static final Identifier PRIMA_HANGING_SIGN_GUI_TEXTURE = new Identifier(EFAC.MOD_ID, "textures/gui/hanging_signs/prima");

    public static final Block PRIMA_SIGN = Registry.register(Registries.BLOCK, new Identifier(EFAC.MOD_ID, "prima_sign"),
            new TerraformSignBlock(PRIMA_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
    public static final Block PRIMA_WALL_SIGN = Registry.register(Registries.BLOCK, new Identifier(EFAC.MOD_ID, "prima_wall_sign"),
            new TerraformWallSignBlock(PRIMA_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)));
    public static final Block PRIMA_HANGING_SIGN = Registry.register(Registries.BLOCK, new Identifier(EFAC.MOD_ID, "prima_hanging_sign"),
            new TerraformHangingSignBlock(PRIMA_HANGING_SIGN_TEXTURE, PRIMA_HANGING_SIGN_GUI_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));
    public static final Block PRIMA_WALL_HANGING_SIGN = Registry.register(Registries.BLOCK, new Identifier(EFAC.MOD_ID, "prima_wall_hanging_sign"),
            new TerraformHangingSignBlock(PRIMA_HANGING_SIGN_TEXTURE, PRIMA_HANGING_SIGN_GUI_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN)));

    public static final BlockFamily PRIMA_FAMILY = BlockFamilies.register(ModBlocks.PRIMA_PLANKS)
            .sign(ModBlocks.PRIMA_SIGN, ModBlocks.PRIMA_WALL_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

    //crops
    public static final Block CLUMBROT_CROP = Registry.register(Registries.BLOCK, new Identifier(EFAC.MOD_ID,
            "clumbrot_crop"), new ClumbrotCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    //misc
    public static final Block COMPACT_DOM = registerBlock("compact_dom",
            new Block(FabricBlockSettings.copyOf(Blocks.DIRT)));
    public static final Block BUTTER = registerBlock("butter",
            new Block(FabricBlockSettings.copyOf(Blocks.SAND).sounds(BlockSoundGroup.SLIME)));
    public static final Block YES = registerBlock("yes",
            new YesBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(ModSounds.YES_SOUNDS)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(EFAC.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(EFAC.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        EFAC.LOGGER.info("Registering ModBlocks for " + EFAC.MOD_ID);
    }
}
