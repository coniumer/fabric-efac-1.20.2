package net.steiner.efac;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.fluid.ModFluids;
import net.steiner.efac.item.ModItems;
import net.steiner.efac.util.ClumbData;
import net.steiner.efac.util.EntityDataSaver;
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
				.lightWithFluid(ModFluids.DRAGON_BLOOD_STILL)
				.tintColor(0x888888)
				.registerPortal();
		CustomPortalBuilder.beginPortal() // tunnel portal
				.destDimID(new Identifier(EFAC.MOD_ID, "tunneldim"))
				.setPortalSearchYRange(-50, 110)
				.frameBlock(ModBlocks.SLIPULON_BLOCK)
				.lightWithItem(ModItems.BUTTER_STICK)
				.tintColor(0x999999)
				.registerPortal();
		CustomPortalBuilder.beginPortal() // yes portal
				.destDimID(new Identifier(EFAC.MOD_ID, "yesdim"))
				.setPortalSearchYRange(-50, 110)
				.frameBlock(ModBlocks.YES)
				.lightWithItem(ModItems.BUTTER_STICK)
				.tintColor(0xaaaaaa)
				.flatPortal()
				.registerPortal();
		CustomPortalBuilder.beginPortal() // evan portal
				.destDimID(new Identifier(EFAC.MOD_ID, "evandim"))
				.setPortalSearchYRange(-50, 110)
				.frameBlock(ModBlocks.ETHER)
				.lightWithItem(ModItems.BUTTER_STICK)
				.tintColor(0xbbbbbb)
				.flatPortal()
				.registerPortal();
		CustomPortalBuilder.beginPortal() // think environment portal
				.destDimID(new Identifier(EFAC.MOD_ID, "thinkdim"))
				.setPortalSearchYRange(-50, 110)
				.frameBlock(ModBlocks.CLUMB_BLOCK)
				.lightWithItem(ModItems.BUTTER_STICK)
				.tintColor(0xcccccc)
				.flatPortal()
				.registerPortal();

		ServerPlayConnectionEvents.JOIN.register(((handler, sender, server) -> {
			ServerPlayerEntity player = handler.player;
			EntityDataSaver sPlayer = (EntityDataSaver)handler.player;
			if(sPlayer.getPersistentData() == null) {
				ClumbData.setMaxClumbCharges(sPlayer, 5);
				ClumbData.setClumbCharges(sPlayer, 0, sPlayer.getPersistentData().getInt(ClumbData.MAX_CLUMB_CHARGE_KEY));
			}
			ClumbData.setMaxClumbCharges(sPlayer, sPlayer.getPersistentData().getInt(ClumbData.MAX_CLUMB_CHARGE_KEY));
			ClumbData.syncMaxClumbCharges((sPlayer.getPersistentData().getInt(ClumbData.MAX_CLUMB_CHARGE_KEY)), player);
			ClumbData.syncClumbCharges((sPlayer.getPersistentData().getInt(ClumbData.CLUMB_CHARGE_KEY)), player);
		}));

	}
}