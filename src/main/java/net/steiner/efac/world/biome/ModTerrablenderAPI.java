package net.steiner.efac.world.biome;

import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(new Identifier(EFAC.MOD_ID, "overworld"), 4));
    }
}
