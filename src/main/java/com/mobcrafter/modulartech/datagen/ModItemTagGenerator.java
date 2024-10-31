package com.mobcrafter.modulartech.datagen;

import com.mobcrafter.modulartech.ModularTech;
import com.mobcrafter.modulartech.block.ModBlocks;
import com.mobcrafter.modulartech.item.ModItems;
import com.mobcrafter.modulartech.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, ModularTech.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(Tags.Items.STORAGE_BLOCKS)
                .add(ModBlocks.SOUL_STEEL_BLOCK.get().asItem());
        this.tag(ModTags.Items.STORAGE_BLOCKS_SOUL_STEEL)
                .add(ModBlocks.SOUL_STEEL_BLOCK.get().asItem());
        this.tag(Tags.Items.INGOTS)
                .add(ModItems.SOUL_STEEL_INGOT.get());
        this.tag(ModTags.Items.INGOTS_SOUL_STEEL)
                .add(ModItems.SOUL_STEEL_INGOT.get());
        this.tag(Tags.Items.NUGGETS)
                .add(ModItems.SOUL_STEEL_NUGGET.get());
        this.tag(ModTags.Items.NUGGETS_SOUL_STEEL)
                .add(ModItems.SOUL_STEEL_NUGGET.get());

        this.tag(Tags.Items.DUSTS)
                .add(ModItems.COAL_DUST.get())
                .add(ModItems.CHARCOAL_DUST.get())
                .add(ModItems.IRON_DUST.get())
                .add(ModItems.COPPER_DUST.get())
                .add(ModItems.GOLD_DUST.get())
                .add(ModItems.NETHERITE_DUST.get())
                .add(ModItems.EMERALD_DUST.get())
                .add(ModItems.LAPIS_DUST.get())
                .add(ModItems.DIAMOND_DUST.get())
                .add(ModItems.SOUL_STEEL_DUST.get());

        this.tag(ModTags.Items.DUSTS_COAL)
                .add(ModItems.COAL_DUST.get());
        this.tag(ModTags.Items.DUSTS_CHARCOAL)
                .add(ModItems.CHARCOAL_DUST.get());
        this.tag(ModTags.Items.DUSTS_IRON)
                .add(ModItems.IRON_DUST.get());
        this.tag(ModTags.Items.DUSTS_COPPER)
                .add(ModItems.COPPER_DUST.get());
        this.tag(ModTags.Items.DUSTS_GOLD)
                .add(ModItems.GOLD_DUST.get());
        this.tag(ModTags.Items.DUSTS_NETHERITE)
                .add(ModItems.NETHERITE_DUST.get());
        this.tag(ModTags.Items.DUSTS_EMERALD)
                .add(ModItems.EMERALD_DUST.get());
        this.tag(ModTags.Items.DUSTS_LAPIS)
                .add(ModItems.LAPIS_DUST.get());
        this.tag(ModTags.Items.DUSTS_DIAMOND)
                .add(ModItems.DIAMOND_DUST.get());
        this.tag(ModTags.Items.DUSTS_SOUL_STEEL)
                .add(ModItems.SOUL_STEEL_DUST.get());
    }
}
