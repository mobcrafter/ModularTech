package com.mobcrafter.modulartech.datagen;

import com.mobcrafter.modulartech.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.COAL_DUST.getId(), new FurnaceFuel(1000), false)
                .add(ModItems.COAL_TINY_DUST.getId(), new FurnaceFuel(100), false)
                .add(ModItems.CHARCOAL_DUST.getId(), new FurnaceFuel(1000), false)
                .add(ModItems.CHARCOAL_TINY_DUST.getId(), new FurnaceFuel(100), false);
    }
}
