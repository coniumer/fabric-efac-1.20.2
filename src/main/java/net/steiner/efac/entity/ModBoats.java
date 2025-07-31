package net.steiner.efac.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.steiner.efac.EFAC;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.item.ModItems;

public class ModBoats {
    public static final Identifier PRIMA_BOAT_ID = new Identifier(EFAC.MOD_ID, "prima_boat");
    public static final Identifier PRIMA_CHEST_BOAT_ID = new Identifier(EFAC.MOD_ID, "prima_chest_boat");

    public static final RegistryKey<TerraformBoatType> PRIMA_BOAT_KEY = TerraformBoatTypeRegistry.createKey(PRIMA_BOAT_ID);

    public static void registerBoats() {
        TerraformBoatType primaBoat = new TerraformBoatType.Builder()
                .item(ModItems.PRIMA_BOAT)
                .chestItem(ModItems.PRIMA_CHEST_BOAT)
                .planks(ModBlocks.PRIMA_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, PRIMA_BOAT_KEY, primaBoat);
    }
}
