package net.holdenthedoor.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.holdenthedoor.tutorialmod.TutorialMod;
import net.holdenthedoor.tutorialmod.block.ModBlocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));

    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)));
    public static final Item EMERALD_APPLE = registerItem("emerald_apple", new Item(new Item.Settings().food(ModFoodComponents.EMERALD_APPLE)));

    public static final Item NETHER_STAR_DUST = registerItem("nether_star_dust", new Item(new Item.Settings()));

    public static final Item CAULIFLOWER_SEEDS = registerItem("cauliflower_seeds", new AliasedBlockItem(ModBlocks.CAULIFLOWER_CROP, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
            entries.addAfter(Items.NETHER_STAR, NETHER_STAR_DUST);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.addAfter(Items.BEETROOT_SEEDS, CAULIFLOWER_SEEDS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.CARROT, CAULIFLOWER);
            entries.addAfter(Items.GOLDEN_APPLE, EMERALD_APPLE);
        });


    }
}
