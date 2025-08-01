package net.steiner.efac.world.biome;

import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;
import net.steiner.efac.world.biome.surface.ModMaterialRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegionScary(new Identifier(EFAC.MOD_ID, "overworld"), 4));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, EFAC.MOD_ID, ModMaterialRules.makeRules());
    }
}
