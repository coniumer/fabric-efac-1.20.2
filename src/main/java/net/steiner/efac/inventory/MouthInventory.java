package net.steiner.efac.inventory;

import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;

public class MouthInventory extends SimpleInventory {

    public MouthInventory() { super(32); }

    @Override
    public void readNbtList(NbtList nbtList) {
        for (int i = 0; i < this.size(); i++) {
            this.setStack(i, ItemStack.EMPTY);
        }

        for (int i = 0; i < nbtList.size(); i++) {
            NbtCompound nbtCompound = nbtList.getCompound(i);
            int j = nbtCompound.getByte("Slot") & 255;
            if (j >= 0 && j < this.size()) {
                this.setStack(j, ItemStack.fromNbt(nbtCompound));
            }
        }
    }

    @Override
    public NbtList toNbtList() {
        NbtList nbtList = new NbtList();

        for (int i = 0; i < this.size(); i++) {
            ItemStack itemStack = this.getStack(i);
            if (!itemStack.isEmpty()) {
                NbtCompound nbtCompound = new NbtCompound();
                nbtCompound.putByte("Slot", (byte)i);
                itemStack.writeNbt(nbtCompound);
                nbtList.add(nbtCompound);
            }
        }

        return nbtList;
    }
}
