package net.steiner.efac.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.steiner.efac.networking.ModMessages;
import net.steiner.efac.networking.packet.ClumbDischargeC2SPacket;
import net.steiner.efac.util.EntityDataSaver;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_EFAC = "key.category.efac.evankeys";
    public static final String KEY_CLUMB = "key.efac.clumb";

    public static KeyBinding clumbKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(clumbKey.wasPressed()) {
                MinecraftClient mc = MinecraftClient.getInstance();

                if (mc.player == null)
                    return;

                PlayerEntity player = mc.player;
                EntityDataSaver sPlayer = (EntityDataSaver)player;

                if (sPlayer.canClumb(sPlayer.getPersistentData().getInt("clumbCharges"), sPlayer) || player.getAbilities().creativeMode) {
                    // build state machine that switches effects based on item equipped
                    clumbDash(player);
                    ClientPlayNetworking.send(ModMessages.CLUMB_DISCHARGE_ID, PacketByteBufs.create());
                }

            }
        });
    }

    public static void clumbDash(PlayerEntity player) {

        Vec3d playerLook = player.getRotationVec(1.0f);
        Vec3d dashVec = new Vec3d(playerLook.x, player.getVelocity().y + playerLook.y, playerLook.z);
        player.addVelocity(dashVec);
    }

    public static void registerKeys() {
        clumbKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_CLUMB, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_C, KEY_CATEGORY_EFAC
        ));

        registerKeyInputs();
    }
}
