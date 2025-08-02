package net.steiner.efac.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;

public class ModScreenHandlers {
    public static final ScreenHandlerType<ClumbHarvesterScreenHandler> CLUMB_HARVESTER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(EFAC.MOD_ID, "clumb_harvesting"),
                    new ExtendedScreenHandlerType<>(ClumbHarvesterScreenHandler::new));

    public static void registerScreenHandlers() { EFAC.LOGGER.info("Registering Screen Handlers for " + EFAC.MOD_ID);}
}
