package net.steiner.efac.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;

public class ModSounds {

    // readyforbed
    public static final SoundEvent READY_FOR_BED = registerSoundEvent("ready_for_bed");
    // yes block
    public static final SoundEvent YES_BREAK = registerSoundEvent("yes_break");
    public static final SoundEvent YES_STEP = registerSoundEvent("yes_step");
    public static final SoundEvent YES_PLACE = registerSoundEvent("yes_place");
    public static final SoundEvent YES_HIT = registerSoundEvent("yes_hit");
    public static final SoundEvent YES_FALL = registerSoundEvent("yes_fall");
    public static final BlockSoundGroup YES_SOUNDS = new BlockSoundGroup(1f, 1f,
            ModSounds.YES_BREAK, ModSounds.YES_STEP, ModSounds.YES_PLACE, ModSounds.YES_HIT, ModSounds.YES_FALL);

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(EFAC.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        EFAC.LOGGER.info("Registering Sounds for " + EFAC.MOD_ID);
    }
}
