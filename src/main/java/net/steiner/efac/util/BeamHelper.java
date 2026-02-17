package net.steiner.efac.util;

import net.minecraft.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public interface BeamHelper {
    @Nullable LivingEntity beamTarget = null;

    LivingEntity getBeamTarget();
    void setBeamTarget(LivingEntity beamTarget);
    void resetBeamTicks();
}
