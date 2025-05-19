package net.steiner.efac.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.steiner.efac.util.ClumbData;
import net.steiner.efac.util.EntityDataSaver;

public class ModPlayerEventCopyFrom implements ServerPlayerEvents.CopyFrom {
    @Override
    public void copyFromPlayer(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
        EntityDataSaver original = ((EntityDataSaver)oldPlayer);
        EntityDataSaver player = ((EntityDataSaver)newPlayer);

        ClumbData.setMaxClumbCharges(player, original.getPersistentData().getInt("maxClumbCharges"));
        if (alive) {
            ClumbData.setClumbCharges(player,
                    original.getPersistentData().getInt("clumbCharges"),
                    original.getPersistentData().getInt("maxClumbCharges"));
        }
    }
}
