package com.mobcrafter.modulartech.datagen;

import com.mobcrafter.modulartech.ModularTech;
import com.mobcrafter.modulartech.item.ModItems;
import com.mobcrafter.modulartech.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, ModularTech.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.DUSTS)
                .add(ModItems.COAL_DUST.get())
                .add(ModItems.COAL_DUST_TINY.get())
                .add(ModItems.CHARCOAL_DUST.get())
                .add(ModItems.CHARCOAL_DUST_TINY.get());

    }
}
