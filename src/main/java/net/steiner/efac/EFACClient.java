package net.steiner.efac;

import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.entity.ModEntities;

public class EFACClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CLUMBROT_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GELWOOD_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GELWOOD_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRIMA_LEAVES, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.CLUMB_PROJECTILE, FlyingItemEntityRenderer::new);
    }
}
