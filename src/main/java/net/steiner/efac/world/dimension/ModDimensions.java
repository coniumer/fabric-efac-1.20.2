package net.steiner.efac.world.dimension;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.steiner.efac.EFAC;

import java.util.OptionalLong;

public class ModDimensions {
    // Scary Dimension Registries
    public static final RegistryKey<DimensionOptions> SCARY_DIM_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(EFAC.MOD_ID, "scarydim"));
    public static final RegistryKey<World> SCARY_DIM_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(EFAC.MOD_ID, "scarydim"));
    public static final RegistryKey<DimensionType> SCARY_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(EFAC.MOD_ID, "scarydim_type"));

    // Tunnel of Time Dimension Registries
    public static final RegistryKey<DimensionOptions> TUNNEL_DIM_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(EFAC.MOD_ID, "tunneldim"));
    public static final RegistryKey<World> TUNNEL_DIM_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(EFAC.MOD_ID, "tunneldim"));
    public static final RegistryKey<DimensionType> TUNNEL_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(EFAC.MOD_ID, "tunneldim_type"));

    // scary settings
    public static void scaryBootstrapType(Registerable<DimensionType> context) {
        context.register(SCARY_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), //fixedTime
                false, // hasSkyLight
                true, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                false, // bedWorks
                false, // respawnAnchorWorks
                0, // minY
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                DimensionTypes.OVERWORLD_ID, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false,false, UniformIntProvider.create(0, 0), 0)));
    }

    // tunnel settings
    public static void tunnelBootstrapType(Registerable<DimensionType> context) {
        context.register(TUNNEL_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), //fixedTime
                false, // hasSkyLight
                true, // hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                false, // bedWorks
                false, // respawnAnchorWorks
                -64, // minY
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                DimensionTypes.OVERWORLD_ID, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false,false, UniformIntProvider.create(0, 0), 0)));
    }

}
