package net.steiner.efac.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.steiner.efac.util.ModTags;
import net.steiner.efac.util.MouthData;

public class MouthScreenHandler extends ScreenHandler {

    //client constructor
    public MouthScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ((MouthData)playerInventory.player).getMouthInventory());
    }

    //server constructor
    public MouthScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ModScreenHandlers.MOUTH_SCREEN_HANDLER, syncId);
        checkSize(inventory, 32);
        inventory.onOpen(playerInventory.player);

        int m;
        int l;
        for (m = 0; m < 2; ++m) {
            for (l = 0; l < 16; ++l) {
                this.addSlot(new MouthSlot(this, inventory, l + m * 16, -46 + l * 18, 16 + m * 18));
            }
        }

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        return ItemStack.EMPTY;
    }

    protected boolean isTooth(ItemStack itemStack) {
        return itemStack.isIn(ModTags.Items.IS_TOOTH);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

}
