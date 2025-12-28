package net.steiner.efac.state;

import net.minecraft.block.enums.Tilt;
import net.minecraft.state.property.EnumProperty;
import net.steiner.efac.block.custom.ClumbPhase;

public class ModProperties {
    public static final EnumProperty<ClumbPhase> CLUMB_PHASE = EnumProperty.of("clumb_phase", ClumbPhase.class);
}
