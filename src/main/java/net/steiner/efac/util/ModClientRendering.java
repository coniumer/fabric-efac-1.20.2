package net.steiner.efac.util;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.fluid.ModFluids;

public class ModClientRendering {
    public static void registerRenderLayers() {
        //cutouts
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CLUMBROT_CROP, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GELWOOD_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GELWOOD_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRIMA_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRIMA_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CLUMB_BLOCK, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRIMA_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRIMA_SAPLING, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GEUMB_CLUSTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_GEUMB_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_GEUMB_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_GEUMB_BUD, RenderLayer.getCutout());

        //liquid
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.DRAGON_BLOOD_STILL, ModFluids.DRAGON_BLOOD_FLOWING, new SimpleFluidRenderHandler(
                new Identifier("efac:block/dragon_blood_still"),
                new Identifier("efac:block/dragon_blood_flow")
        ));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.DRAGON_BLOOD_STILL, ModFluids.DRAGON_BLOOD_FLOWING);
    }
}
