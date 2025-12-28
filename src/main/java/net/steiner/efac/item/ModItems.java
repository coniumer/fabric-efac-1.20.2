package net.steiner.efac.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.steiner.efac.EFAC;
import net.steiner.efac.block.ModBlocks;
import net.steiner.efac.entity.ModBoats;
import net.steiner.efac.fluid.ModFluids;
import net.steiner.efac.item.custom.*;
import net.steiner.efac.item.custom.GeumbEnum;

import java.util.List;

public class ModItems {

    //valuables
    public static final Item SLIPULON_INGOT = registerItem("slipulon_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_SLIPULON = registerItem("raw_slipulon", new Item(new FabricItemSettings()));
    public static final Item ALB_GEM = registerItem("alb_gem", new Item(new FabricItemSettings()));
    public static final Item CIT_GEM = registerItem("cit_gem", new Item(new FabricItemSettings()));
    public static final Item RUB_GEM = registerItem("rub_gem", new Item(new FabricItemSettings()));
    public static final Item PHILOSOPHERS_STONE = registerItem("philosophers_stone", new Item(new FabricItemSettings()));
    public static final Item RANDOM_SAUCE = registerItem("random_sauce", new Item(new FabricItemSettings()));
    public static final Item YUMMY_SAUCE = registerItem("yummy_sauce", new Item(new FabricItemSettings()));
    public static final Item AWESOME_SAUCE = registerItem("awesome_sauce", new Item(new FabricItemSettings()));
    public static final Item EPIC_SAUCE = registerItem("epic_sauce", new Item(new FabricItemSettings()));
    public static final Item GEUMB_SHARD = registerItem("geumb_shard", new Item(new FabricItemSettings()));
    public static final Item CLUMBY_GEUMB_SHARD = registerItem("clumby_geumb_shard", new GeumbItem(GeumbEnum.CLUMBY, new FabricItemSettings()));
    public static final Item ALBY_GEUMB_SHARD = registerItem("alby_geumb_shard", new GeumbItem(GeumbEnum.ALBY, new FabricItemSettings()));
    public static final Item CITRY_GEUMB_SHARD = registerItem("citry_geumb_shard", new GeumbItem(GeumbEnum.CITRY, new FabricItemSettings()));
    public static final Item RUBIED_GEUMB_SHARD = registerItem("rubied_geumb_shard", new GeumbItem(GeumbEnum.RUBIED, new FabricItemSettings()));
    public static final Item GELWOOD_ORB = registerItem("gelwood_orb", new Item(new FabricItemSettings()));
    //foods + crops
    public static final Item CLUMB_MATERIA = registerItem("clumb_materia", new Item(new FabricItemSettings().food(ModFoodComponents.CLUMB_MATERIA)));
    public static final Item ALB_CLUMB_MATERIA = registerItem("alb_clumb_materia", new Item(new FabricItemSettings().food(ModFoodComponents.CLUMB_MATERIA)));
    public static final Item CIT_CLUMB_MATERIA = registerItem("cit_clumb_materia", new Item(new FabricItemSettings().food(ModFoodComponents.CLUMB_MATERIA)));
    public static final Item RUB_CLUMB_MATERIA = registerItem("rub_clumb_materia", new Item(new FabricItemSettings().food(ModFoodComponents.CLUMB_MATERIA)));
    public static final Item BUTTER_STICK = registerItem("butter_stick", new Item(new FabricItemSettings().food(ModFoodComponents.BUTTER_STICK)));
    public static final Item CLUMBELON = registerItem("clumbelon", new Item(new FabricItemSettings().food(ModFoodComponents.CLUMBELON)));
    public static final Item CLUMBKIE = registerItem("clumbkie", new Item(new FabricItemSettings().food(ModFoodComponents.CLUMBKIE)));
    public static final Item BLUMB = registerItem("blumb", new Item(new FabricItemSettings().food(ModFoodComponents.BLUMB)));
    public static final Item CLUMBROT = registerItem("clumbrot", new AliasedBlockItem(ModBlocks.CLUMBROT_CROP, new FabricItemSettings().food(ModFoodComponents.CLUMBROT)));
    public static final Item GOLD_CLUMBROT = registerItem("gold_clumbrot", new Item(new FabricItemSettings().food(ModFoodComponents.GOLD_CLUMBROT)));
    public static final Item CLUMBLE = registerItem("clumble", new Item(new FabricItemSettings().food(ModFoodComponents.CLUMBLE)));
    public static final Item GOLD_CLUMBLE = registerItem("gold_clumble", new Item(new FabricItemSettings().food(ModFoodComponents.GOLD_CLUMBLE)));
    public static final Item CLUMBURGER = registerItem("clumburger", new Item(new FabricItemSettings().food(ModFoodComponents.CLUMBURGER)));
    //teeth
    public static final Item TOOTH = registerItem("tooth",
            new ToothItem(1f, new FabricItemSettings()));
    public static final Item SNIPERS_TOOTH = registerItem("snipers_tooth",
            new ToothItem(1.5f, new FabricItemSettings()));
    public static final Item LUXURY_TOOTH = registerItem("luxury_tooth",
            new ToothItem(2f, new StatusEffectInstance(StatusEffects.LUCK, 800, 2), new FabricItemSettings()));
    public static final Item HUNTERS_TOOTH = registerItem("hunters_tooth",
            new ToothItem(2f, new StatusEffectInstance(StatusEffects.POISON, 400, 1), new FabricItemSettings()));
    public static final Item BLUE_TOOTH = registerItem("blue_tooth",
            new ToothItem(1.5f, new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 400, 0), new FabricItemSettings()));
    public static final Item MUMMY_TOOTH = registerItem("mummy_tooth",
            new ToothItem(1.5f, new StatusEffectInstance(StatusEffects.HUNGER, 400, 1), new FabricItemSettings()));
    public static final Item ADVENTURERS_TOOTH = registerItem("adventurers_tooth",
            new ToothItem(1.5f, new FabricItemSettings()));
    public static final Item ARCHITECTS_TOOTH = registerItem("architects_tooth",
            new ToothItem(1.5f, new FabricItemSettings()));
    public static final Item EXCAVATORS_TOOTH = registerItem("excavators_tooth",
            new ToothItem(1.5f, new FabricItemSettings()));
    public static final Item HEAVY_TOOTH = registerItem("heavy_tooth",
            new ToothItem(3f, new FabricItemSettings()));
    public static final Item FORCE_TOOTH = registerItem("force_tooth",
            new ToothItem(2f, new FabricItemSettings()));
    public static final Item RADIANT_TOOTH = registerItem("radiant_tooth",
            new ToothItem(3.5f, new FabricItemSettings()));
    public static final Item SPINE_TOOTH = registerItem("spine_tooth",
            new ToothItem(4f, new FabricItemSettings()));
    public static final Item MIDAS_TOOTH = registerItem("midas_tooth",
            new ToothItem(2.5f, new FabricItemSettings()));
    public static final Item SOUL_TOOTH = registerItem("soul_tooth",
            new ToothItem(2f, new FabricItemSettings()));
    public static final Item OBSERVANT_TOOTH = registerItem("observant_tooth",
            new ToothItem(1.5f, new StatusEffectInstance(StatusEffects.GLOWING, 400, 0), new FabricItemSettings()));
    public static final Item CARDBOARD_TOOTH = registerItem("cardboard_tooth",
            new ToothItem(3.5f, new FabricItemSettings()));
    public static final Item GOLD_TOOTH = registerItem("gold_tooth",
            new ToothItem(5f, new FabricItemSettings()));
    public static final Item PHILOSOPHERS_TOOTH = registerItem("philosophers_tooth",
            new ToothItem(10f, new FabricItemSettings()));
    //wands
    public static final Item WOOD_CLUMB_WAND = registerItem("wood_clumb_wand",
            new WandItem(ModToolMaterial.CLUMB_MATERIA, ModToolMaterial.CLUMB_MATERIA, new FabricItemSettings().maxCount(1)));
    public static final Item ALB_CLUMB_WAND = registerItem("alb_clumb_wand",
            new WandItem(ModToolMaterial.ALEBEDIZED, ModToolMaterial.ALEBEDIZED, new FabricItemSettings().maxCount(1)));
    public static final Item CIT_CLUMB_WAND = registerItem("cit_clumb_wand",
            new WandItem(ModToolMaterial.CITRINIZED, ModToolMaterial.CITRINIZED, new FabricItemSettings().maxCount(1)));
    public static final Item RUB_CLUMB_WAND = registerItem("rub_clumb_wand",
            new WandItem(ModToolMaterial.RUBEDIZED, ModToolMaterial.RUBEDIZED, new FabricItemSettings().maxCount(1)));
    public static final Item PHILOSOPHERS_WAND = registerItem("philosophers_wand",
            new WandItem(ModToolMaterial.PHILOSOPERS, ModToolMaterial.PHILOSOPERS, new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));
    //clumb swords
    public static final Item CLUMBY_SWORD = registerItem("clumby_sword",
            new ClumbSwordItem(ModToolMaterial.CLUMB_MATERIA, ModToolMaterial.CLUMB_MATERIA, 3, -2.2f, new FabricItemSettings()));
    public static final Item ALBY_SWORD = registerItem("alby_sword",
            new ClumbSwordItem(ModToolMaterial.ALEBEDIZED, ModToolMaterial.ALEBEDIZED, 3, -2.2f, new FabricItemSettings()));
    public static final Item CITRY_SWORD = registerItem("citry_sword",
            new ClumbSwordItem(ModToolMaterial.CITRINIZED, ModToolMaterial.CITRINIZED, 3, -2.2f, new FabricItemSettings()));
    public static final Item RUBIED_SWORD = registerItem("rubied_sword",
            new ClumbSwordItem(ModToolMaterial.RUBEDIZED, ModToolMaterial.RUBEDIZED, 3, -2.2f, new FabricItemSettings()));
    public static final Item PHILOSOPHERS_SWORD = registerItem("philosophers_sword",
            new ClumbSwordItem(ModToolMaterial.PHILOSOPERS, ModToolMaterial.PHILOSOPERS, 3, -2.2f, new FabricItemSettings().rarity(Rarity.EPIC)));
    //philosopher tools
    public static final Item PHILOSOPHERS_SHOVEL = registerItem("philosophers_shovel",
            new ShovelItem(ModToolMaterial.PHILOSOPERS, 1.5f, -3.0f, new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item PHILOSOPHERS_PICKAXE = registerItem("philosophers_pickaxe",
            new PickaxeItem(ModToolMaterial.PHILOSOPERS, 1, -2.8f, new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item PHILOSOPHERS_AXE = registerItem("philosophers_axe",
            new AxeItem(ModToolMaterial.PHILOSOPERS, 6.0F, -3.0f, new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item PHILOSOPHERS_HOE = registerItem("philosophers_hoe",
            new HoeItem(ModToolMaterial.PHILOSOPERS, -4, 0.0f, new FabricItemSettings().rarity(Rarity.EPIC)));
    //philosopher armor
    public static final Item PHILOSOPHERS_HELMET = registerItem("philosophers_helmet",
            new ModArmorItem(ModArmorMaterials.PHILOSOPHERS, ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item PHILOSOPHERS_CHESTPLATE = registerItem("philosophers_chestplate",
            new ModArmorItem(ModArmorMaterials.PHILOSOPHERS, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item PHILOSOPHERS_LEGGINGS = registerItem("philosophers_leggings",
            new ModArmorItem(ModArmorMaterials.PHILOSOPHERS, ArmorItem.Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item PHILOSOPHERS_BOOTS = registerItem("philosophers_boots",
            new ModArmorItem(ModArmorMaterials.PHILOSOPHERS, ArmorItem.Type.BOOTS, new FabricItemSettings().rarity(Rarity.EPIC)));
    //smithing templates
    private static final Text PHILOSOPHERS_UPGRADE_APPLIES_TO_TEXT = Text.translatable("smithing_template.efac.philosophers_upgrade.applies_to");
    private static final Text PHILOSOPHERS_UPGRADE_INGREDIENTS_TEXT = Text.translatable("smithing_template.efac.philosophers_upgrade.ingredients");
    private static final Text PHILOSOPHERS_UPGRADE_TEXT = Text.translatable("upgrade.efac.philosophers_upgrade");
    private static final Text PHILOSOPHERS_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable("smithing_template.efac.philosophers_upgrade.base_slot_description");
    private static final Text PHILOSOPHERS_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable("smithing_template.efac.philosophers_upgrade.additions_slot_description");

    private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE = new Identifier("item/empty_armor_slot_helmet");
    private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = new Identifier("item/empty_armor_slot_chestplate");
    private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = new Identifier("item/empty_armor_slot_leggings");
    private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = new Identifier("item/empty_armor_slot_boots");
    private static final Identifier EMPTY_SLOT_HOE_TEXTURE = new Identifier("item/empty_slot_hoe");
    private static final Identifier EMPTY_SLOT_AXE_TEXTURE = new Identifier("item/empty_slot_axe");
    private static final Identifier EMPTY_SLOT_SWORD_TEXTURE = new Identifier("item/empty_slot_sword");
    private static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE = new Identifier("item/empty_slot_shovel");
    private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE = new Identifier("item/empty_slot_pickaxe");

    private static final Identifier EMPTY_SLOT_INGOT_TEXTURE = new Identifier("item/empty_slot_ingot");
    private static final Identifier EMPTY_SLOT_REDSTONE_DUST_TEXTURE = new Identifier("item/empty_slot_redstone_dust");
    private static final Identifier EMPTY_SLOT_QUARTZ_TEXTURE = new Identifier("item/empty_slot_quartz");
    private static final Identifier EMPTY_SLOT_EMERALD_TEXTURE = new Identifier("item/empty_slot_emerald");
    private static final Identifier EMPTY_SLOT_DIAMOND_TEXTURE = new Identifier("item/empty_slot_diamond");
    private static final Identifier EMPTY_SLOT_LAPIS_LAZULI_TEXTURE = new Identifier("item/empty_slot_lapis_lazuli");
    private static final Identifier EMPTY_SLOT_AMETHYST_SHARD_TEXTURE = new Identifier("item/empty_slot_amethyst_shard");

    private static List<Identifier> getArmorTrimEmptyBaseSlotTextures() {
        return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_ARMOR_SLOT_BOOTS_TEXTURE);
    }
    private static List<Identifier> getUpgradeEmptyBaseSlotTextures() {
        return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_ARMOR_SLOT_BOOTS_TEXTURE,
                EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE);
    }
    private static List<Identifier> getArmorTrimEmptyAdditionsSlotTextures() {
        return List.of(
                EMPTY_SLOT_INGOT_TEXTURE,
                EMPTY_SLOT_REDSTONE_DUST_TEXTURE,
                EMPTY_SLOT_LAPIS_LAZULI_TEXTURE,
                EMPTY_SLOT_QUARTZ_TEXTURE,
                EMPTY_SLOT_DIAMOND_TEXTURE,
                EMPTY_SLOT_EMERALD_TEXTURE,
                EMPTY_SLOT_AMETHYST_SHARD_TEXTURE
        );
    }
    private static List<Identifier> getUpgradeEmptyAdditionsSlotTextures() {
        return List.of(
                EMPTY_SLOT_INGOT_TEXTURE
        );
    }

    public static final Item PHILOSOPHERS_UPGRADE_SMITHING_TEMPLATE = registerItem("philosophers_upgrade_smithing_template",
            new SmithingTemplateItem(PHILOSOPHERS_UPGRADE_APPLIES_TO_TEXT,
                    PHILOSOPHERS_UPGRADE_INGREDIENTS_TEXT,
                    PHILOSOPHERS_UPGRADE_TEXT,
                    PHILOSOPHERS_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
                    PHILOSOPHERS_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
                    getUpgradeEmptyBaseSlotTextures(),
                    getUpgradeEmptyAdditionsSlotTextures()));
    //charms
    public static final Item BLINK_CHARM = registerItem("blink_charm",
            new CharmItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item LIGHTNING_CHARM = registerItem("lightning_charm",
            new CharmItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FIREBALL_CHARM = registerItem("fireball_charm",
            new CharmItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item BOMB_CHARM = registerItem("bomb_charm",
            new CharmItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item HEALTH_CHARM = registerItem("health_charm",
            new CharmItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item STORAGE_CHARM = registerItem("storage_charm",
            new CharmItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item PHILOSOPHER_CHARM = registerItem("philosopher_charm",
            new CharmItem(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));
    //signs
    public static final Item PRIMA_SIGN = registerItem("prima_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.PRIMA_SIGN, ModBlocks.PRIMA_WALL_SIGN));
    public static final Item PRIMA_HANGING_SIGN = registerItem("prima_hanging_sign",
            new HangingSignItem(ModBlocks.PRIMA_HANGING_SIGN, ModBlocks.PRIMA_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));
    //boats
    public static final Item PRIMA_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.PRIMA_BOAT_ID, ModBoats.PRIMA_BOAT_KEY, false);
    public static final Item PRIMA_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.PRIMA_CHEST_BOAT_ID, ModBoats.PRIMA_BOAT_KEY, true);
    //bucket
    public static final Item DRAGON_BLOOD_BUCKET = Registry.register(Registries.ITEM, new Identifier(EFAC.MOD_ID, "dragon_blood_bucket"),
            new BucketItem(ModFluids.DRAGON_BLOOD_STILL, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(EFAC.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EFAC.LOGGER.info("Registering Mod Items for " + EFAC.MOD_ID);
    }
}
