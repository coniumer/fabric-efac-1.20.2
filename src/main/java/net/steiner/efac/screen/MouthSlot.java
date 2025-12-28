package net.steiner.efac.screen;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class MouthSlot extends Slot {
    private final MouthScreenHandler handler;

    public MouthSlot(MouthScreenHandler handler, Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        this.handler = handler;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return this.handler.isTooth(stack);
    }

    @Override
    public int getMaxItemCount() {
        return 1;
    }
}
