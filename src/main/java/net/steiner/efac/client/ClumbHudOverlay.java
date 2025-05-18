package net.steiner.efac.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;
import net.steiner.efac.util.EntityDataSaver;

import java.util.Random;

public class ClumbHudOverlay implements HudRenderCallback {
    public static final Identifier EMPTY_CLUMB = new Identifier(EFAC.MOD_ID,
            "textures/gui/clumb/clumb_empty.png");
    public static final Identifier FILLABLE_CLUMB = new Identifier(EFAC.MOD_ID,
            "textures/gui/clumb/clumb_fillable.png");
    public static final Identifier FULL_CLUMB = new Identifier(EFAC.MOD_ID,
            "textures/gui/clumb/clumb_full.png");
    public static final Identifier ALB_CLUMB = new Identifier(EFAC.MOD_ID,
            "textures/gui/clumb/clumb_alb.png");
    public static final Identifier CIT_CLUMB = new Identifier(EFAC.MOD_ID,
            "textures/gui/clumb/clumb_cit.png");
    public static final Identifier RUB_CLUMB = new Identifier(EFAC.MOD_ID,
            "textures/gui/clumb/clumb_rub.png");

    long seed = System.currentTimeMillis();
    Random random = new Random(seed);
    int[] mults = setMults(random, 20);

    // TODO: Make it look better
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
            int j = i + 10;
            drawContext.drawTexture(EMPTY_CLUMB, x + 192 - (i * mults[i]), y - 16 - (i * mults[j]), 0, 0,
                    10, 10, 10, 10);
        }

        for(int i = 0; i < 10; i++) {
            int j = i + 10;
            if(((EntityDataSaver)MinecraftClient.getInstance().player).getPersistentData().getInt("maxClumbCharges") > i) {
                drawContext.drawTexture(FILLABLE_CLUMB, x + 192 - (i * mults[i]), y - 16 - (i * mults[j]), 0, 0,
                        10, 10, 10, 10);
            } else {
                break;
            }
        }

        for(int i = 0; i < 10; i++) {
            int j = i + 10;
            if(((EntityDataSaver)MinecraftClient.getInstance().player).getPersistentData().getInt("clumbCharges") > i) {
                drawContext.drawTexture(FULL_CLUMB, x + 192 - (i * mults[i]), y - 16 - (i * mults[j]), 0, 0,
                        10, 10, 10, 10);
            } else {
                break;
            }
        }

        for(int i = 0; i < 10; i++) {
            int j = i + 10;
            if(((EntityDataSaver)MinecraftClient.getInstance().player).getPersistentData().getInt("clumbCharges") > i + 10) {
                drawContext.drawTexture(ALB_CLUMB, x + 192 - (i * mults[i]), y - 16 - (i * mults[j]), 0, 0,
                        10, 10, 10, 10);
            } else {
                break;
            }
        }

        for(int i = 0; i < 10; i++) {
            int j = i + 10;
            if(((EntityDataSaver)MinecraftClient.getInstance().player).getPersistentData().getInt("clumbCharges") > i + 20) {
                drawContext.drawTexture(CIT_CLUMB, x + 192 - (i * mults[i]), y - 16 - (i * mults[j]), 0, 0,
                        10, 10, 10, 10);
            } else {
                break;
            }
        }

        for(int i = 0; i < 10; i++) {
            int j = i + 10;
            if(((EntityDataSaver)MinecraftClient.getInstance().player).getPersistentData().getInt("clumbCharges") > i + 30) {
                drawContext.drawTexture(RUB_CLUMB, x + 192 - (i * mults[i]), y - 16 - (i * mults[j]), 0, 0,
                        10, 10, 10, 10);
            } else {
                break;
            }
        }
    }

    private int[] setMults(Random random, int length) {
        int[] mult = new int[length];
        for (int i = 0; i < length; i++) {
            int randomNumber = (Math.abs(random.nextInt() % 10) + 1);
            mult[i] = randomNumber;
            System.out.println("Mult " + i + " = " + mult[i]);
        }
        return mult;
    }

}
