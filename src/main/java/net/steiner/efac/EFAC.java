package net.steiner.efac;

import net.fabricmc.api.ModInitializer;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.util.ModRegistries;
import net.steiner.efac.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EFAC implements ModInitializer {
	public static final String MOD_ID = "efac";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Guggy world!");

		ModWorldGeneration.generateModWorldGen();
		ModRegistries.registerModRegistries();

		CustomPortalBuilder.beginPortal() // scary portal
				.destDimID(new Identifier(EFAC.MOD_ID, "scarydim"))
				.setPortalSearchYRange(10, 110)
				.frameBlock(Blocks.BONE_BLOCK)
				.lightWithItem(Items.BONE)
				.tintColor(0xc76efa)
				.registerPortal();
		CustomPortalBuilder.beginPortal() // tunnel portal
				.destDimID(new Identifier(EFAC.MOD_ID, "tunneldim"))
				.setPortalSearchYRange(-50, 110)
				.frameBlock(ModBlocks.SLIPULON_BLOCK)
				.lightWithWater()
				.tintColor(0x9baaa2)
				.registerPortal();

		//ServerPlayConnectionEvents.JOIN.register(((handler, sender, server) -> {
		//	ServerPlayerEntity player = handler.player;
		//	EntityDataSaver sPlayer = (EntityDataSaver)handler.player;
		//	ClumbData.setMaxClumbCharges(sPlayer, sPlayer.getPersistentData().getInt("maxClumbCharges"));
		//	ClumbData.syncMaxClumbCharges((sPlayer.getPersistentData().getInt("maxClumbCharges")), player);
		//	ClumbData.syncClumbCharges((sPlayer.getPersistentData().getInt("clumbCharges")), player);
		//}));

	}
}