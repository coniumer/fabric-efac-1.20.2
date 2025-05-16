package net.steiner.efac.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;
import net.steiner.efac.util.EntityDataSaver;

public class ClumbHudOverlay implements HudRenderCallback {
    // TODO: better textures
    public static final Identifier EMPTY_CLUMB = new Identifier(EFAC.MOD_ID,
            "textures/gui/clumb/clumb_empty.png");
    public static final Identifier FULL_CLUMB = new Identifier(EFAC.MOD_ID,
            "textures/gui/clumb/clumb_full.png");

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        int x = 0;
        int y = 0;
        MinecraftClient client = MinecraftClient.getInstance();
        if(client != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            x = width / 2;
            y = height;
        }

        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        drawContext.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        for(int i = 0; i < 10; i++) {
            drawContext.drawTexture(EMPTY_CLUMB, x - 94 + (i * 9), y - 54, 0, 0,
                    12, 12, 12, 12);
        }

        for(int i = 0; i < 10; i++) {
            if(((EntityDataSaver)MinecraftClient.getInstance().player).getPersistentData().getInt("clumbCharges") > i) {
                drawContext.drawTexture(FULL_CLUMB, x - 94 + (i * 9), y - 54, 0, 0,
                        12, 12, 12, 12);
            } else {
                break;
            }
        }
    }
}
