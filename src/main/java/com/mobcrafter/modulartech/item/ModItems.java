package com.mobcrafter.modulartech.item;

import com.mobcrafter.modulartech.ModularTech;
import com.mobcrafter.modulartech.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ModularTech.MODID);

    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));;
    public static final DeferredItem<Item> STEEL_NUGGET = ITEMS.register("steel_nugget",
            () -> new Item(new Item.Properties()));;

    public static final DeferredItem<Item> GRANOLA_BAR = ITEMS.register("granola_bar",
            () -> new Item(new Item.Properties().food(ModFoodProperties.GRANOLA_BAR)));

    public static final DeferredItem<Item> STEEL_DUST = ITEMS.register("steel_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STEEL_TINY_DUST = ITEMS.register("steel_tiny_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COAL_DUST = ITEMS.register("coal_dust",
            () -> new FuelItem(new Item.Properties(), 1000));
    public static final DeferredItem<Item> COAL_TINY_DUST = ITEMS.register("coal_tiny_dust",
            () -> new FuelItem(new Item.Properties(), 100));
    public static final DeferredItem<Item> CHARCOAL_DUST = ITEMS.register("charcoal_dust",
            () -> new FuelItem(new Item.Properties(), 1000));
    public static final DeferredItem<Item> CHARCOAL_TINY_DUST = ITEMS.register("charcoal_tiny_dust",
            () -> new FuelItem(new Item.Properties(), 100));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
