package net.steiner.efac.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.steiner.efac.EFAC;
import net.steiner.efac.block.ModBlocks;

public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> CLUMB_POI_KEY = poiKey("clumb_poi");
    public static final PointOfInterestType CLUMB_POI = registerPoi("clumb_poi", ModBlocks.CLUMB_HARVESTER);

    public static final VillagerProfession CLUMBIST = registerProfession("clumbist", CLUMB_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(EFAC.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_MASON));
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(EFAC.MOD_ID, name), 1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(EFAC.MOD_ID, name));
    }

    public static void registerVillagers() {
        EFAC.LOGGER.info("Registering Villagers for " + EFAC.MOD_ID);
    }
}
