package net.steiner.efac.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;
import net.steiner.efac.entity.custom.ClumbProjectileEntity;
import net.steiner.efac.entity.custom.ToothItemEntity;

public class ModEntities {
    public static final EntityType<ClumbProjectileEntity> CLUMB_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(EFAC.MOD_ID, "clumb_projectile"),
            FabricEntityTypeBuilder.<ClumbProjectileEntity>create(SpawnGroup.MISC, ClumbProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    public static final EntityType<ToothItemEntity> TOOTH_ITEM_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(EFAC.MOD_ID, "tooth_item_entity"),
            FabricEntityTypeBuilder.<ToothItemEntity>create(SpawnGroup.MISC, ToothItemEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    public static void registerModEntities() {
        EFAC.LOGGER.info("Registering Mod Entities for " + EFAC.MOD_ID);
    }
}
