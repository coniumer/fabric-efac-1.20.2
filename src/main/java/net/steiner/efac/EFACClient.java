package net.steiner.efac;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.steiner.efac.client.ClumbHudOverlay;
import net.steiner.efac.entity.ModBoats;
import net.steiner.efac.entity.ModEntities;
import net.steiner.efac.event.KeyInputHandler;
import net.steiner.efac.networking.ModMessages;
import net.steiner.efac.screen.ClumbHarvesterScreen;
import net.steiner.efac.screen.ModScreenHandlers;
import net.steiner.efac.util.ModClientRendering;

public class EFACClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModClientRendering.registerCutouts();

        EntityRendererRegistry.register(ModEntities.CLUMB_PROJECTILE, FlyingItemEntityRenderer::new);

        TerraformBoatClientHelper.registerModelLayers(ModBoats.PRIMA_BOAT_ID, false);

        HandledScreens.register(ModScreenHandlers.CLUMB_HARVESTER_SCREEN_HANDLER, ClumbHarvesterScreen::new);

        KeyInputHandler.registerKeys();

        ModMessages.regsiterS2CPackets();
        HudRenderCallback.EVENT.register(new ClumbHudOverlay());
    }
}
