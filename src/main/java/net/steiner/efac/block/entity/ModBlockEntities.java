package net.steiner.efac.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;
import net.steiner.efac.block.ModBlocks;

public class ModBlockEntities {
    public static final BlockEntityType<ClumbHarvesterBlockEntity> CLUMB_HARVESTER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(EFAC.MOD_ID, "clumb_harvester_be"),
                    FabricBlockEntityTypeBuilder.create(ClumbHarvesterBlockEntity::new,
                            ModBlocks.CLUMB_HARVESTER).build());

    public static void registerBlockEntities() { EFAC.LOGGER.info("Registering Block Entities for " + EFAC.MOD_ID); }
}
