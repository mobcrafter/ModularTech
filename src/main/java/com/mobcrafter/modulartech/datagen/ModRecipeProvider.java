package com.mobcrafter.modulartech.datagen;

import com.mobcrafter.modulartech.ModularTech;
import com.mobcrafter.modulartech.block.ModBlocks;
import com.mobcrafter.modulartech.item.ModItems;
import com.mobcrafter.modulartech.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        Compacting(pWriter, ModTags.Items.STORAGE_BLOCKS_SOUL_STEEL, ModBlocks.SOUL_STEEL_BLOCK.get(), ModTags.Items.INGOTS_SOUL_STEEL, ModItems.SOUL_STEEL_INGOT.get());
        Compacting(pWriter, ModTags.Items.INGOTS_SOUL_STEEL, ModItems.SOUL_STEEL_INGOT.get(), ModTags.Items.NUGGETS_SOUL_STEEL, ModItems.SOUL_STEEL_NUGGET.get());

        DustPieces(pWriter, Tags.Items.DUSTS_REDSTONE, Items.REDSTONE, ModItems.REDSTONE_PIECE.get());
        DustPieces(pWriter, Tags.Items.DUSTS_GLOWSTONE, Items.GLOWSTONE_DUST, ModItems.GLOWSTONE_DUST_PIECE.get());

        DustPieces(pWriter, ModTags.Items.DUSTS_COAL, ModItems.COAL_DUST.get(), ModItems.COAL_DUST_PIECE.get());
        DustPieces(pWriter, ModTags.Items.DUSTS_CHARCOAL, ModItems.CHARCOAL_DUST.get(), ModItems.CHARCOAL_DUST_PIECE.get());
        DustPieces(pWriter, ModTags.Items.DUSTS_IRON, ModItems.IRON_DUST.get(), ModItems.IRON_DUST_PIECE.get());
        DustPieces(pWriter, ModTags.Items.DUSTS_COPPER, ModItems.COPPER_DUST.get(), ModItems.COPPER_DUST_PIECE.get());
        DustPieces(pWriter, ModTags.Items.DUSTS_GOLD, ModItems.GOLD_DUST.get(), ModItems.GOLD_DUST_PIECE.get());
        DustPieces(pWriter, ModTags.Items.DUSTS_NETHERITE, ModItems.NETHERITE_DUST.get(), ModItems.NETHERITE_DUST_PIECE.get());
        DustPieces(pWriter, ModTags.Items.DUSTS_EMERALD, ModItems.EMERALD_DUST.get(), ModItems.EMERALD_DUST_PIECE.get());
        DustPieces(pWriter, ModTags.Items.DUSTS_LAPIS, ModItems.LAPIS_DUST.get(), ModItems.LAPIS_DUST_PIECE.get());
        DustPieces(pWriter, ModTags.Items.DUSTS_DIAMOND, ModItems.DIAMOND_DUST.get(), ModItems.DIAMOND_DUST_PIECE.get());
        DustPieces(pWriter, ModTags.Items.DUSTS_SOUL_STEEL, ModItems.SOUL_STEEL_DUST.get(), ModItems.SOUL_STEEL_DUST_PIECE.get());

        SmeltingAndBlasting(pWriter, List.of(ModItems.POWDERED_ANCIENT_DEBRIS.get()), RecipeCategory.MISC, Items.NETHERITE_SCRAP, 0.0f, 200, "netherite_scrap");
        SmeltingAndBlasting(pWriter, List.of(ModItems.IRON_DUST.get()), RecipeCategory.MISC, Items.IRON_INGOT, 0.0f, 200, "iron_ingot");
        SmeltingAndBlasting(pWriter, List.of(ModItems.COPPER_DUST.get()), RecipeCategory.MISC, Items.COPPER_INGOT, 0.0f, 200, "copper_ingot");
        SmeltingAndBlasting(pWriter, List.of(ModItems.GOLD_DUST.get()), RecipeCategory.MISC, Items.GOLD_INGOT, 0.0f, 200, "gold_ingot");
        SmeltingAndBlasting(pWriter, List.of(ModItems.NETHERITE_DUST.get()), RecipeCategory.MISC, Items.NETHERITE_INGOT, 0.0f, 200, "netherite_ingot");
        SmeltingAndBlasting(pWriter, List.of(ModItems.SOUL_STEEL_DUST.get()), RecipeCategory.MISC, ModItems.SOUL_STEEL_INGOT.get(), 0.0f, 200, "soul_steel_ingot");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NETHERITE_DUST.get(), 1)
                .requires(ModItems.POWDERED_ANCIENT_DEBRIS.get())
                .requires(ModItems.POWDERED_ANCIENT_DEBRIS.get())
                .requires(ModItems.POWDERED_ANCIENT_DEBRIS.get())
                .requires(ModItems.POWDERED_ANCIENT_DEBRIS.get())
                .requires(ModItems.GOLD_DUST.get())
                .requires(ModItems.GOLD_DUST.get())
                .requires(ModItems.GOLD_DUST.get())
                .requires(ModItems.GOLD_DUST.get())
                .unlockedBy(getHasName(ModItems.POWDERED_ANCIENT_DEBRIS.get()), has(ModItems.POWDERED_ANCIENT_DEBRIS.get()))
                .save(pWriter);

    }

    protected static void Smelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        Cooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void Blasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        Cooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void SmeltingAndBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        Cooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
        Cooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime / 2, pGroup, "_from_blasting");
    }

    protected static void Cooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  ModularTech.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

    protected static void Compacting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, TagKey<Item> big_tag, ItemLike big_item, TagKey<Item> small_tag, ItemLike small_item) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, big_item)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', small_tag)
                .unlockedBy(getHasName(small_item), has(small_tag))
                .save(pFinishedRecipeConsumer, ModularTech.MODID + ":" + getItemName(big_item) + "_from_" + getItemName(small_item));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, small_item, 9)
                .requires(big_tag)
                .unlockedBy(getHasName(big_item), has(big_tag))
                .save(pFinishedRecipeConsumer, ModularTech.MODID + ":" + getItemName(small_item) + "_from_" + getItemName(big_item));
    }

    protected static void DustPieces(Consumer<FinishedRecipe> pFinishedRecipeConsumer, TagKey<Item> dust_tag, ItemLike dust, ItemLike dust_piece) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, dust)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', dust_piece)
                .unlockedBy(getHasName(dust_piece), has(dust_piece))
                .save(pFinishedRecipeConsumer, ModularTech.MODID + ":" + getItemName(dust) + "_from_" + getItemName(dust_piece));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, dust_piece, 9)
                .requires(dust_tag)
                .unlockedBy(getHasName(dust), has(dust_tag))
                .save(pFinishedRecipeConsumer, ModularTech.MODID + ":" + getItemName(dust_piece) + "_from_" + getItemName(dust));
    }
}
