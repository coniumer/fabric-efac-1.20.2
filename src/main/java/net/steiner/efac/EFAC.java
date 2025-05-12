package net.steiner.efac;

import net.fabricmc.api.ModInitializer;

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