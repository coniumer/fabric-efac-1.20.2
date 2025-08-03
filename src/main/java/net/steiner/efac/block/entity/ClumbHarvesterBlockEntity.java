package net.steiner.efac.block.entity;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.steiner.efac.recipe.HarvesterRecipe;
import net.steiner.efac.screen.ClumbHarvesterScreenHandler;
import net.steiner.efac.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ClumbHarvesterBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int[] OUTPUT = {1, 2, 3};
    public static final String PROGRESS_KEY = "clumb_harvester.progress";

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public ClumbHarvesterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CLUMB_HARVESTER_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> ClumbHarvesterBlockEntity.this.progress;
                    case 1 -> ClumbHarvesterBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> ClumbHarvesterBlockEntity.this.progress = value;
                    case 1 -> ClumbHarvesterBlockEntity.this.maxProgress = value;
                };
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Clumb Harvester");
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt(PROGRESS_KEY, progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt(PROGRESS_KEY);
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ClumbHarvesterScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient) { return; }
        boolean crafted = false;
        List<Item> outputs = Lists.newArrayList();

        if (HarvesterRecipe.hasRecipe(this.getStack(INPUT_SLOT))) {
            if (outputsAreAvailable()) {
                progress++;
                markDirty(world, pos, state);
                if (progress >= maxProgress) {
                    outputs.addAll(this.getOutputs(world, this.getStack(INPUT_SLOT)));
                    putOutputsInSlots(outputs);
                    world.playSound(null, pos, ModSounds.HARVESTER_HARVEST, SoundCategory.BLOCKS, 1f, 1f);
                    crafted = true;
                    this.resetProgress();
                }
            }else {
                this.resetProgress();
            }
        } else {
            this.resetProgress();
            markDirty(world, pos, state);
        }

        if (crafted) {
            this.removeStack(INPUT_SLOT, 1);
        }
    }

    private void putOutputsInSlots(List<Item> outputs) {
        for (int i = 0; i < outputs.size(); i++) {
            if (canInsertAmountIntoOutputSlot(outputs.get(i).getDefaultStack(), OUTPUT[i]) && canInsertItemIntoOutputSlot(outputs.get(i), OUTPUT[i])) {
                this.setStack(OUTPUT[i], new ItemStack(outputs.get(i), getStack(OUTPUT[i]).getCount() + 1));
            }
        }
    }

    private List<Item> getOutputs(World world, ItemStack input) {
        float[] rolls = new float[OUTPUT.length];
        for (int i = 0; i < OUTPUT.length; i++) {
            rolls[i] = ((float) (Math.abs(world.getRandom().nextInt()) % 10) / 10f);
        }
        return HarvesterRecipe.craft(input, rolls);
    }

    private boolean canInsertItemIntoOutputSlot(Item item, int slot) {
        return this.getStack(slot).getItem() == item || this.getStack(slot).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result, int slot) {
        return this.getStack(slot).getCount() + result.getCount() <= getStack(slot).getMaxCount();
    }

    private boolean outputsAreAvailable() {
        for (int j : OUTPUT) {
            return this.getStack(j).isEmpty() || this.getStack(j).getCount() < this.getStack(j).getMaxCount();
        }
        return false;
    }

    private void resetProgress() {
        this.progress = 0;
    }
}

