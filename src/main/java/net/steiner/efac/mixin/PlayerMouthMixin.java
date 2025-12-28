package net.steiner.efac.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.world.World;
import net.steiner.efac.entity.effect.ModEffects;
import net.steiner.efac.inventory.MouthInventory;
import net.steiner.efac.item.ModItems;
import net.steiner.efac.util.MouthData;
import net.steiner.efac.util.Tooth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;

@Mixin(PlayerEntity.class)
public abstract class PlayerMouthMixin extends LivingEntity implements MouthData {
    @Unique
    protected MouthInventory mouthInventory = new MouthInventory();

    protected PlayerMouthMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    protected void injectReadCustomNBT(NbtCompound nbt, CallbackInfo info) {
        if (nbt.contains("MouthItems", NbtElement.LIST_TYPE)) {
            this.mouthInventory.readNbtList(nbt.getList("MouthItems", NbtElement.COMPOUND_TYPE));
        }
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    protected void injectWriteCustomNBT(NbtCompound nbt, CallbackInfo info) {
        nbt.put("MouthItems", this.mouthInventory.toNbtList());
    }

    @Override
    public MouthInventory getMouthInventory() {
        return mouthInventory;
    }

    @Override
    public void updateMouth() {
        MouthInventory mouthInventory = this.mouthInventory;
        ArrayList<Tooth> teeth;
        teeth = checkTeeth(mouthInventory);
        int slowness = -1;
        int speed = -1;
        int strength = -1;
        int resistance = -1;
        int regen = 0;

        int fatigue = -1;
        int haste = -1;
        int falling = -1;
        int jump_boost = -1;

        if (!teeth.isEmpty()) {
            for (Tooth tooth : teeth) {
                if (tooth.getTooth() == ModItems.TOOTH) {
                    if (tooth.getType() == Tooth.Type.WISDOM) {
                        slowness++;
                    } else if (tooth.getType() == Tooth.Type.CANINE) {
                        strength++;
                    } else if (tooth.getType() == Tooth.Type.PREMOLAR) {
                        resistance++;
                    } else if (tooth.getType() == Tooth.Type.MOLAR) {
                        regen++;
                    }
                } else if (tooth.getTooth() == ModItems.GOLD_TOOTH) {
                    if (tooth.getType() == Tooth.Type.WISDOM) {
                        slowness += 2;
                    } else if (tooth.getType() == Tooth.Type.INCISOR) {
                        speed += 2;
                    } else if (tooth.getType() == Tooth.Type.CANINE) {
                        strength += 2;
                    } else if (tooth.getType() == Tooth.Type.PREMOLAR) {
                        resistance += 2;
                    } else if (tooth.getType() == Tooth.Type.MOLAR) {
                        regen += 2;
                    }
                } else if (tooth.getTooth() == ModItems.PHILOSOPHERS_TOOTH) {
                    if (tooth.getType() == Tooth.Type.WISDOM) {
                        slowness += 8;
                    } else if (tooth.getType() == Tooth.Type.INCISOR) {
                        speed += 8;
                    } else if (tooth.getType() == Tooth.Type.CANINE) {
                        strength += 8;
                    } else if (tooth.getType() == Tooth.Type.PREMOLAR) {
                        resistance += 8;
                    } else if (tooth.getType() == Tooth.Type.MOLAR) {
                        regen += 8;
                    }
                } else if (tooth.getTooth() == ModItems.BLUE_TOOTH) {
                    if (tooth.getType() == Tooth.Type.WISDOM) {
                        fatigue++;
                    } else if (tooth.getType() == Tooth.Type.INCISOR) {
                        haste++;
                    } else if (tooth.getType() == Tooth.Type.CANINE) {
                        strength++;
                    } else if (tooth.getType() == Tooth.Type.PREMOLAR) {
                        falling++;
                    } else if (tooth.getType() == Tooth.Type.MOLAR) {
                        jump_boost++;
                    }
                } else {
                    speed++;
                }
            }
            applyToothEffects(speed, strength, slowness, resistance, regen, fatigue, haste, falling, jump_boost);
        }
        teeth.clear();
    }

    @Unique
    private void applyToothEffects(int speed, int strength, int slowness, int resistance, int regen, int fatigue, int haste, int falling, int jump_boost) {
        if (speed > -1) { this.addStatusEffect(new StatusEffectInstance(ModEffects.TOOTH_SPEED, 200, speed, false, false, false)); }
        if (strength > -1) { this.addStatusEffect(new StatusEffectInstance(ModEffects.TOOTH_STRENGTH, 200, strength, false, false, false)); }
        if (resistance > -1) { this.addStatusEffect(new StatusEffectInstance(ModEffects.TOOTH_RESISTANCE, 200, resistance, false, false, false)); }
        if (regen > 0) { this.addStatusEffect(new StatusEffectInstance(ModEffects.TOOTH_REGEN, 200, regen, false, false, false)); }
        if (slowness > -1) { this.addStatusEffect(new StatusEffectInstance(ModEffects.TOOTH_SLOWNESS, 200, strength, false, false, false)); }

        if (fatigue > -1) { this.addStatusEffect(new StatusEffectInstance(ModEffects.FATIGUE, 200, fatigue, false, false, false)); }
        if (haste > -1) { this.addStatusEffect(new StatusEffectInstance(ModEffects.HASTE, 200, haste, false, false, false)); }
        if (falling > -1) { this.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 200, falling, false, false, false)); }
        if (jump_boost > -1) { this.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 200, jump_boost, false, false, false)); }
    }

    @Unique
    public ArrayList<Tooth> checkTeeth(MouthInventory mouthInventory) {
        ArrayList<Tooth> teeth = new ArrayList<>();
        for (int i = 0; i < mouthInventory.size(); i++) {
            ItemStack stack = mouthInventory.getStack(i);
            if (stack != ItemStack.EMPTY) {
                Tooth tooth = new Tooth(stack.getItem(), i);
                teeth.add(tooth);
            }
        }
        return teeth;
    }
}
