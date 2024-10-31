package com.mobcrafter.modulartech.item;

import com.mobcrafter.modulartech.ModularTech;
import com.mobcrafter.modulartech.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModularTech.MODID);

    public static final RegistryObject<CreativeModeTab> MODULARTECH_TAB = CREATIVE_MODE_TABS.register("modulartech_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SOUL_STEEL_INGOT.get()))
                    .title(Component.translatable("creativetab.modulartech_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.SOUL_STEEL_BLOCK.get());

                        pOutput.accept(ModItems.SOUL_STEEL_INGOT.get());
                        pOutput.accept(ModItems.SOUL_STEEL_NUGGET.get());

                        pOutput.accept(ModItems.POWDERED_ANCIENT_DEBRIS.get());

                        pOutput.accept(ModItems.COAL_DUST.get());
                        pOutput.accept(ModItems.CHARCOAL_DUST.get());
                        pOutput.accept(ModItems.IRON_DUST.get());
                        pOutput.accept(ModItems.COPPER_DUST.get());
                        pOutput.accept(ModItems.GOLD_DUST.get());
                        pOutput.accept(ModItems.NETHERITE_DUST.get());
                        pOutput.accept(ModItems.EMERALD_DUST.get());
                        pOutput.accept(ModItems.LAPIS_DUST.get());
                        pOutput.accept(ModItems.DIAMOND_DUST.get());
                        pOutput.accept(ModItems.SOUL_STEEL_DUST.get());

                        pOutput.accept(ModItems.REDSTONE_PIECE.get());
                        pOutput.accept(ModItems.GLOWSTONE_DUST_PIECE.get());

                        pOutput.accept(ModItems.COAL_DUST_PIECE.get());
                        pOutput.accept(ModItems.CHARCOAL_DUST_PIECE.get());
                        pOutput.accept(ModItems.IRON_DUST_PIECE.get());
                        pOutput.accept(ModItems.COPPER_DUST_PIECE.get());
                        pOutput.accept(ModItems.GOLD_DUST_PIECE.get());
                        pOutput.accept(ModItems.NETHERITE_DUST_PIECE.get());
                        pOutput.accept(ModItems.EMERALD_DUST_PIECE.get());
                        pOutput.accept(ModItems.LAPIS_DUST_PIECE.get());
                        pOutput.accept(ModItems.DIAMOND_DUST_PIECE.get());
                        pOutput.accept(ModItems.SOUL_STEEL_DUST_PIECE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
