package net.steiner.efac.item.custom;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.steiner.efac.networking.ModMessages;
import net.steiner.efac.sound.ModSounds;
import net.steiner.efac.util.EntityDataSaver;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GeumbItem extends Item {
    private final GeumbEnum geumbEnum;
    public static boolean canUse(int maxCharges, int minToUse, int maxToUse) {
        return maxCharges >= minToUse && maxCharges <= maxToUse;
    }

    public GeumbItem(GeumbEnum geumbEnum, Settings settings) {
        super(settings);
        this.geumbEnum = geumbEnum;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        EntityDataSaver sPlayer = (EntityDataSaver)user;
        ItemStack itemStack = user.getStackInHand(hand);
        PacketByteBuf buffer = PacketByteBufs.create();

        if (canUse(sPlayer.getPersistentData().getInt("maxClumbCharges"), geumbEnum.getMinToUse(), geumbEnum.getMaxToUse())) {
            addMaxCharges(world, user, sPlayer, buffer);
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            if (!user.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
        } else {
            world.playSound(
                    null,
                    user.getX(),
                    user.getY(),
                    user.getZ(),
                    ModSounds.WAND_FAIL,
                    SoundCategory.PLAYERS,
                    0.7F,
                    0.65F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
            );
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    public void addMaxCharges (World world, PlayerEntity user, EntityDataSaver sPlayer, PacketByteBuf buffer) {
        world.playSound(
                null,
                user.getX(),
                user.getY(),
                user.getZ(),
                ModSounds.WAND_USE,
                SoundCategory.PLAYERS,
                0.7F,
                0.65F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
        );

        buffer.writeInt(
                (MathHelper.clamp(sPlayer.getPersistentData().getInt("maxClumbCharges"), 5, 40) + 1)
        );

        if (world.isClient) {
            ClientPlayNetworking.send(ModMessages.SET_MAX_CLUMB_ID, buffer);
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.efac.geumb_item"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
