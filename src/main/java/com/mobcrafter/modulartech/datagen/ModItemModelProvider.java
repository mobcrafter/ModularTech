package com.mobcrafter.modulartech.datagen;

import com.mobcrafter.modulartech.ModularTech;
import com.mobcrafter.modulartech.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ModularTech.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.STEEL_INGOT.get());

        basicItem(ModItems.GRANOLA_BAR.get());

        basicItem(ModItems.COAL_DUST.get());
        basicItem(ModItems.COAL_DUST_TINY.get());
        basicItem(ModItems.CHARCOAL_DUST.get());
        basicItem(ModItems.CHARCOAL_DUST_TINY.get());
    }
}
