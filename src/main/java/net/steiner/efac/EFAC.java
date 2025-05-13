package net.steiner.efac;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.item.ModItemGroups;
import net.steiner.efac.item.ModItems;
import net.steiner.efac.sound.ModSounds;
import net.steiner.efac.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EFAC implements ModInitializer {
	public static final String MOD_ID = "efac";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Guggy world!");
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModSounds.registerSounds();

		ModWorldGeneration.generateModWorldGen();

		StrippableBlockRegistry.register(ModBlocks.PRIMA_LOG, ModBlocks.STRIPPED_PRIMA_LOG);
		StrippableBlockRegistry.register(ModBlocks.PRIMA_WOOD, ModBlocks.STRIPPED_PRIMA_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PRIMA_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PRIMA_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PRIMA_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PRIMA_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PRIMA_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PRIMA_LOG, 30, 60);

		CustomPortalBuilder.beginPortal() // scary portal
				.destDimID(new Identifier(EFAC.MOD_ID, "scarydim"))
				.frameBlock(Blocks.BONE_BLOCK)
				.lightWithItem(Items.BONE)
				.tintColor(0xc76efa)
				.registerPortal();
		CustomPortalBuilder.beginPortal() // tunnel portal
				.destDimID(new Identifier(EFAC.MOD_ID, "tunneldim"))
				.frameBlock(ModBlocks.SLIPULON_BLOCK)
				.lightWithWater()
				.tintColor(0x9baaa2)
				.registerPortal();
	}
}