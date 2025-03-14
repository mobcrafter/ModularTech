package com.mobcrafter.modulartech.util;

import com.mobcrafter.modulartech.ModularTech;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createModTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ModularTech.MODID, name));
        }
        private static TagKey<Block> createConventionalTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> DUSTS = createConventionalTag("dusts");

        private static TagKey<Item> createModTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ModularTech.MODID, name));
        }
        private static TagKey<Item> createConventionalTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }
}
