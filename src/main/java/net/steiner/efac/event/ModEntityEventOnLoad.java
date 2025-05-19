package net.steiner.efac.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.steiner.efac.util.ClumbData;
import net.steiner.efac.util.EntityDataSaver;

public class ModEntityEventOnLoad implements ServerEntityEvents.Load {
    @Override
    public void onLoad(Entity entity, ServerWorld world) {
        if (entity instanceof ServerPlayerEntity player) {
            EntityDataSaver sPlayer = ((EntityDataSaver) entity);

            ClumbData.syncMaxClumbCharges(sPlayer.getPersistentData().getInt("maxClumbCharges"), player);
            ClumbData.syncClumbCharges(sPlayer.getPersistentData().getInt("clumbCharges"), player);
        }
    }
}
