package net.steiner.efac;

import net.fabricmc.api.ModInitializer;

import net.steiner.efac.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EFAC implements ModInitializer {
	public static final String MOD_ID = "efac";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Guggy world!");
		ModItems.registerModItems();
	}
}