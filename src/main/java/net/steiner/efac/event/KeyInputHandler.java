package net.steiner.efac.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.steiner.efac.item.ModItems;
import net.steiner.efac.networking.ModMessages;
import net.steiner.efac.util.ClumbButtonFunctions;
import net.steiner.efac.util.EntityDataSaver;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_EFAC = "key.category.efac.evankeys";
    public static final String KEY_CLUMB = "key.efac.clumb";
    public static final String KEY_MOUTH = "key.efac.mouth";

    public static KeyBinding clumbKey;
    public static KeyBinding mouthKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (mouthKey.wasPressed()) {
                ClientPlayNetworking.send(ModMessages.OPEN_MOUTH_ID, PacketByteBufs.create());
            }
            if (clumbKey.wasPressed()) {

                MinecraftClient mc = MinecraftClient.getInstance();
                if (mc.player == null)
                    return;
                PlayerEntity player = mc.player;
                EntityDataSaver sPlayer = (EntityDataSaver)player;

                if (sPlayer.canClumb(sPlayer.getPersistentData().getInt("clumbCharges"), sPlayer) || player.getAbilities().creativeMode) {
                    if (performClumbAction(player)) {
                        ClientPlayNetworking.send(ModMessages.CLUMB_DISCHARGE_ID, PacketByteBufs.create());

                        PacketByteBuf buf = PacketByteBufs.create();
                        buf.writeInt(0);
                        ClientPlayNetworking.send(ModMessages.SET_COOLDOWN_PROGRESS_ID, buf);
                    }
                } else {
                    sendPayload(ClumbButtonFunctions.FAIL);
                }
            }
        });
    }

    public static boolean performClumbAction(PlayerEntity player) {
        EntityDataSaver sPlayer = (EntityDataSaver) player;

        if (player.getStackInHand(Hand.OFF_HAND).getItem() == ModItems.LIGHTNING_CHARM) {
            sendPayload(ClumbButtonFunctions.LIGHTNING);
            return true;
        } else if (sPlayer.getPersistentData().getInt("dashUses") < 2 && player.getStackInHand(Hand.OFF_HAND).getItem() == ModItems.BLINK_CHARM) {
            blink(player, ClumbButtonFunctions.BLINK);
            return true;
        } else if (player.getStackInHand(Hand.OFF_HAND).getItem() == ModItems.FIREBALL_CHARM) {
            sendPayload(ClumbButtonFunctions.FIREBALL);
            return true;
        } else if (player.getStackInHand(Hand.OFF_HAND).getItem() == ModItems.BOMB_CHARM) {
            sendPayload(ClumbButtonFunctions.BOMB);
            return true;
        } else if (player.getStackInHand(Hand.OFF_HAND).getItem() == ModItems.HEALTH_CHARM) {
            sendPayload(ClumbButtonFunctions.HEALTH);
            return true;
        } else if (player.getStackInHand(Hand.OFF_HAND).getItem() == ModItems.STORAGE_CHARM) {
            sendPayload(ClumbButtonFunctions.STORAGE);
            return true;
        } else if (sPlayer.getPersistentData().getInt("dashUses") < 2) {
            clumbDash(player, ClumbButtonFunctions.DASH);
            return true;
        } else {
            sendPayload(ClumbButtonFunctions.FAIL);
        }
        return false;
    }

    public static void sendPayload(ClumbButtonFunctions func) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeInt(func.getFunction());
        ClientPlayNetworking.send(ModMessages.CLUMB_BUTTON_PAYLOAD_ID, buf);
    }

    public static void blink(PlayerEntity player, ClumbButtonFunctions func) {
        EntityDataSaver sPlayer = (EntityDataSaver)player;

        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeInt(sPlayer.getPersistentData().getInt("dashUses") + 1);
        ClientPlayNetworking.send(ModMessages.SET_DASH_USES_ID, buf);

        sendPayload(func);

        for (int i = 0; i < 32; i++) {
            player.getWorld().addParticle(
                    ParticleTypes.PORTAL, player.getX(), player.getY(), player.getZ(), player.getWorld().random.nextGaussian(), 0.0, player.getWorld().random.nextGaussian()
            );
        }
    }

    public static void clumbDash(PlayerEntity player, ClumbButtonFunctions func) {
        Vec3d playerLook = player.getRotationVec(1.0f);
        Vec3d dashVec = new Vec3d(
                playerLook.x * 0.7f,
                (player.getVelocity().y * 0.3f) + playerLook.y * 0.7f,
                playerLook.z * 0.7f);
        player.addVelocity(dashVec);

        EntityDataSaver sPlayer = (EntityDataSaver)player;

        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeInt(sPlayer.getPersistentData().getInt("dashUses") + 1);
        ClientPlayNetworking.send(ModMessages.SET_DASH_USES_ID, buf);

        sendPayload(func);
    }

    public static void registerKeys() {
        clumbKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_CLUMB, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_LEFT_CONTROL, KEY_CATEGORY_EFAC
        ));
        mouthKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_MOUTH, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_M, KEY_CATEGORY_EFAC
        ));

        registerKeyInputs();
    }
}
