package net.steiner.efac.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.steiner.efac.recipe.ClumbHarvestingRecipe;
import net.steiner.efac.screen.ClumbHarvesterScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

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

        for (int i = 1; i <= 3; i++) {
            if (outputIsEmptyOrReceivable(i)) {
                if (this.hasRecipe(i)) {
                    progress++;
                    markDirty(world, pos, state);

                    if (progress >= maxProgress) {
                        this.craftItem(i);
                        this.resetProgress();
                    }
                } else {
                    this.resetProgress();
                }
            } else {
                this.resetProgress();
                markDirty(world, pos, state);
            }
        }
    }

    private void craftItem(int slot) {
        Optional<RecipeEntry<ClumbHarvestingRecipe>> recipe = getCurrentRecipe();
        this.removeStack(INPUT_SLOT, 1);

        this.setStack(slot, new ItemStack(recipe.get().value().getResult(null).getItem(),
                getStack(slot).getCount() + recipe.get().value().getResult(null).getCount()));
    }

    private boolean hasRecipe(int slot) {
        Optional<RecipeEntry<ClumbHarvestingRecipe>> recipe = getCurrentRecipe();
        return recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().value().getResult(null), slot)
                && canInsertItemIntoOutputSlot(recipe.get().value().getResult(null).getItem(), slot);
    }

    private Optional<RecipeEntry<ClumbHarvestingRecipe>> getCurrentRecipe() {
        SimpleInventory inv = new SimpleInventory(this.size());
        for (int i = 0; i < this.size(); i++) {
            inv.setStack(i, this.getStack(i));
        }

        return getWorld().getRecipeManager().getFirstMatch(ClumbHarvestingRecipe.Type.INSTANCE, inv, getWorld());
    }

    private boolean canInsertItemIntoOutputSlot(Item item, int slot) {
        return this.getStack(slot).getItem() == item || this.getStack(slot).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result, int slot) {
        return this.getStack(slot).getCount() + result.getCount() <= getStack(slot).getMaxCount();
    }

    private boolean outputIsEmptyOrReceivable(int slot) {
        return this.getStack(slot).isEmpty() || this.getStack(slot).getCount() < this.getStack(slot).getMaxCount();
    }

    private void resetProgress() {
        this.progress = 0;
    }
}

