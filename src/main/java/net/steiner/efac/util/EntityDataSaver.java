package net.steiner.efac.util;

import net.minecraft.nbt.NbtCompound;

public interface EntityDataSaver {
    NbtCompound getPersistentData();
    boolean canClumb(int clumbCharges, EntityDataSaver player);
}
