package net.steiner.efac.item.custom;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.steiner.efac.networking.ModMessages;
import net.steiner.efac.sound.ModSounds;
import net.steiner.efac.util.EntityDataSaver;

public class GeumbItem extends Item {
    public GeumbItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        EntityDataSaver sPlayer = (EntityDataSaver)user;
        ItemStack itemStack = user.getStackInHand(hand);
        PacketByteBuf buffer = PacketByteBufs.create();

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

        if (!world.isClient) {
            ClientPlayNetworking.send(ModMessages.SET_MAX_CLUMB_ID, buffer);
            /*
            System.out.println("Max clumb charges equals: " +
                    sPlayer.getPersistentData().getInt("maxClumbCharges"));
             */
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
