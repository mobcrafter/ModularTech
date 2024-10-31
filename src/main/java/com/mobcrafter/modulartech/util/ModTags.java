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

        public static final TagKey<Block> STORAGE_BLOCKS_SOUL_STEEL = forgeTag("storage_blocks/soul_steel");

        private static TagKey<Block> modTag(String name) {
            return BlockTags.create(new ResourceLocation(ModularTech.MODID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {

        public static final TagKey<Item> STORAGE_BLOCKS_SOUL_STEEL = forgeTag("storage_blocks/soul_steel");
        public static final TagKey<Item> INGOTS_SOUL_STEEL = forgeTag("ingots/soul_steel");
        public static final TagKey<Item> NUGGETS_SOUL_STEEL = forgeTag("nuggets/soul_steel");

        public static final TagKey<Item> DUSTS_COAL = forgeTag("dusts/coal");
        public static final TagKey<Item> DUSTS_CHARCOAL = forgeTag("dusts/charcoal");
        public static final TagKey<Item> DUSTS_IRON = forgeTag("dusts/iron");
        public static final TagKey<Item> DUSTS_COPPER = forgeTag("dusts/copper");
        public static final TagKey<Item> DUSTS_GOLD = forgeTag("dusts/gold");
        public static final TagKey<Item> DUSTS_NETHERITE = forgeTag("dusts/netherite");
        public static final TagKey<Item> DUSTS_EMERALD = forgeTag("dusts/emerald");
        public static final TagKey<Item> DUSTS_LAPIS = forgeTag("dusts/lapis");
        public static final TagKey<Item> DUSTS_DIAMOND = forgeTag("dusts/diamond");
        public static final TagKey<Item> DUSTS_SOUL_STEEL = forgeTag("dusts/soul_steel");

        private static TagKey<Item> modTag(String name) {
            return ItemTags.create(new ResourceLocation(ModularTech.MODID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}