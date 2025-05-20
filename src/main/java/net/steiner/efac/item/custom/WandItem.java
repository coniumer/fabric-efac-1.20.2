package net.steiner.efac.item.custom;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.steiner.efac.entity.ModEntities;
import net.steiner.efac.entity.custom.ClumbProjectileEntity;
import net.steiner.efac.networking.ModMessages;
import net.steiner.efac.sound.ModSounds;
import net.steiner.efac.util.EntityDataSaver;

public class WandItem extends Item {
    private final ToolMaterial material;
    private final ModToolMaterial modMaterial;

    // constructor from idk where probably some tool
    public WandItem(ToolMaterial material, ModToolMaterial modMaterial, Item.Settings settings) {
        super(settings.maxDamageIfAbsent(material.getDurability()));
        this.material = material;
        this.modMaterial = modMaterial;
    }

    // idk what i'm doing
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        EntityDataSaver sPlayer = (EntityDataSaver)user;
        ItemStack itemStack = user.getStackInHand(hand);

        if (sPlayer.canClumb(sPlayer.getPersistentData().getInt("clumbCharges"), sPlayer) ||
                user.getAbilities().creativeMode) {
            if (!world.isClient) {
                clumbCast(world, user, itemStack);
            }
            if (!user.getAbilities().creativeMode && world.isClient) {
                ClientPlayNetworking.send(ModMessages.CLUMB_DISCHARGE_ID, PacketByteBufs.create());
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
                    0.85F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
            );
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    public void clumbCast(World world, PlayerEntity user, ItemStack itemStack) {
        world.playSound(
                null,
                user.getX(),
                user.getY(),
                user.getZ(),
                ModSounds.WAND_USE,
                SoundCategory.PLAYERS,
                0.7F,
                0.95F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
        );

            ClumbProjectileEntity clumbProjectileEntity = new ClumbProjectileEntity(ModEntities.CLUMB_PROJECTILE, user, world, modMaterial);
            clumbProjectileEntity.setItem(itemStack);
            clumbProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.2F, 0.5F);
            world.spawnEntity(clumbProjectileEntity);

        user.getItemCooldownManager().set(this, modMaterial.getCooldown());
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.damage(1, user, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }

    }

}