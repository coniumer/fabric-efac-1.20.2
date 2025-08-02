package net.steiner.efac.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;

public class ClumbHarvesterScreen extends HandledScreen<ClumbHarvesterScreenHandler> {
    private static final Identifier TEX = new Identifier(EFAC.MOD_ID, "textures/gui/clumb_harvester.png");
    public ClumbHarvesterScreen(ClumbHarvesterScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f,1f, 1f);
        RenderSystem.setShaderTexture(0, TEX);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(TEX, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    private void renderProgress(DrawContext context, int x, int y) {
        if (handler.isCrafting()) {
            context.drawTexture(TEX, x + 85, y + 30, 176, 0, 8, handler.getScaledProgress());
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
