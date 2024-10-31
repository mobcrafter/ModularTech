package com.mobcrafter.modulartech.item;

import com.mobcrafter.modulartech.ModularTech;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ModularTech.MODID);

    public static final RegistryObject<Item> SOUL_STEEL_INGOT = ITEMS.register("soul_steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SOUL_STEEL_NUGGET = ITEMS.register("soul_steel_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> POWDERED_ANCIENT_DEBRIS = ITEMS.register("powdered_ancient_debris",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COAL_DUST = ITEMS.register("coal_dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHARCOAL_DUST = ITEMS.register("charcoal_dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLD_DUST = ITEMS.register("gold_dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_DUST = ITEMS.register("netherite_dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_DUST = ITEMS.register("emerald_dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_DUST = ITEMS.register("lapis_dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_DUST = ITEMS.register("diamond_dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SOUL_STEEL_DUST = ITEMS.register("soul_steel_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REDSTONE_PIECE = ITEMS.register("redstone_piece",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GLOWSTONE_DUST_PIECE = ITEMS.register("glowstone_dust_piece",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COAL_DUST_PIECE = ITEMS.register("coal_dust_piece",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHARCOAL_DUST_PIECE = ITEMS.register("charcoal_dust_piece",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_DUST_PIECE = ITEMS.register("iron_dust_piece",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_DUST_PIECE = ITEMS.register("copper_dust_piece",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLD_DUST_PIECE = ITEMS.register("gold_dust_piece",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_DUST_PIECE = ITEMS.register("netherite_dust_piece",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_DUST_PIECE = ITEMS.register("emerald_dust_piece",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_DUST_PIECE = ITEMS.register("lapis_dust_piece",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_DUST_PIECE = ITEMS.register("diamond_dust_piece",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SOUL_STEEL_DUST_PIECE = ITEMS.register("soul_steel_dust_piece",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
