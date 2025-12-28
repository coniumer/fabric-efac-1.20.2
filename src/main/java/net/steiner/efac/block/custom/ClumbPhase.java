package net.steiner.efac.block.custom;

import net.minecraft.util.StringIdentifiable;

public enum ClumbPhase implements StringIdentifiable {
    SOLID("solid", true),
    PASSABLE("passable", false);

    private final String name;
    private final boolean stable;

    private ClumbPhase(String name, boolean stable) {
        this.name = name;
        this.stable = stable;
    }

    @Override
    public String asString() {return this.name;}

    public boolean isStable() {return this.stable;}
}
