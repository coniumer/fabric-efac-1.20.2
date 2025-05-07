package net.steiner.efac.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.util.ModTags;

public class ClumbvestigatorItem extends Item {
    public ClumbvestigatorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            BlockState state = context.getWorld().getBlockState(positionClicked);
            if(isClumbable(state)) {
                outputClumbable(player, state.getBlock());
                foundBlock = true;
            }

            if(!foundBlock) {
                player.sendMessage(Text.literal("Not clumbable! Better luck next time!"), false);
            }
        }

        return ActionResult.SUCCESS;
    }

    private void outputClumbable(PlayerEntity player, Block block) {
        player.sendMessage(Text.literal(block.asItem().getName().getString() +
                " is sooo clumbable."), false);
    }

    private boolean isClumbable(BlockState state) {
        return state.isIn(ModTags.Blocks.CLUMBVESTIGATABLE);
    }
}
