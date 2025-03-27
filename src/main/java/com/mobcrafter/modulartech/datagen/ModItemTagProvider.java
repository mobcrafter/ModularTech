package com.mobcrafter.modulartech.datagen;

import com.mobcrafter.modulartech.ModularTech;
import com.mobcrafter.modulartech.block.ModBlocks;
import com.mobcrafter.modulartech.item.ModItems;
import com.mobcrafter.modulartech.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
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
        tag(Tags.Items.STORAGE_BLOCKS)
                .add(ModBlocks.STEEL_BLOCK.get().asItem());

        tag(Tags.Items.INGOTS)
                .add(ModItems.STEEL_INGOT.get());

        tag(Tags.Items.NUGGETS)
                .add(ModItems.STEEL_NUGGET.get());

        tag(Tags.Items.DUSTS)
                .add(ModItems.STEEL_DUST.get())
                .add(ModItems.STEEL_TINY_DUST.get())
                .add(ModItems.COAL_DUST.get())
                .add(ModItems.COAL_TINY_DUST.get())
                .add(ModItems.CHARCOAL_DUST.get())
                .add(ModItems.CHARCOAL_TINY_DUST.get());

        tag(ModTags.Items.STORAGE_BLOCKS_STEEL)
                .add(ModBlocks.STEEL_BLOCK.get().asItem());
        tag(ModTags.Items.INGOTS_STEEL)
                .add(ModItems.STEEL_INGOT.get());
        tag(ModTags.Items.NUGGETS_STEEL)
                .add(ModItems.STEEL_NUGGET.get());
        tag(ModTags.Items.DUSTS_STEEL)
                .add(ModItems.STEEL_DUST.get());
        tag(ModTags.Items.TINY_DUSTS_STEEL)
                .add(ModItems.STEEL_TINY_DUST.get());

    }
}
