package com.mobcrafter.modulartech.datagen;

import com.mobcrafter.modulartech.ModularTech;
import com.mobcrafter.modulartech.block.ModBlocks;
import com.mobcrafter.modulartech.item.ModItems;
import com.mobcrafter.modulartech.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        CompactingTagged(recipeOutput, ModTags.Items.STORAGE_BLOCKS_STEEL, ModBlocks.STEEL_BLOCK.get(), ModTags.Items.INGOTS_STEEL, ModItems.STEEL_INGOT.get());

        CompactingTagged(recipeOutput, ModTags.Items.INGOTS_STEEL, ModItems.STEEL_INGOT.get(), ModTags.Items.NUGGETS_STEEL, ModItems.STEEL_NUGGET.get());
        CompactingTagged(recipeOutput, ModTags.Items.DUSTS_STEEL, ModItems.STEEL_DUST.get(), ModTags.Items.TINY_DUSTS_STEEL, ModItems.STEEL_TINY_DUST.get());

        SmeltingTagged(recipeOutput, ModItems.STEEL_DUST, ModTags.Items.DUSTS_STEEL, RecipeCategory.MISC, ModItems.STEEL_INGOT, 0.0f, 200, "steel");
        SmeltingTagged(recipeOutput, ModItems.STEEL_TINY_DUST, ModTags.Items.TINY_DUSTS_STEEL, RecipeCategory.MISC, ModItems.STEEL_NUGGET, 0.0f, 200, "steel");
        BlastingTagged(recipeOutput, ModItems.STEEL_DUST, ModTags.Items.DUSTS_STEEL, RecipeCategory.MISC, ModItems.STEEL_INGOT, 0.0f, 200, "steel");
        BlastingTagged(recipeOutput, ModItems.STEEL_TINY_DUST, ModTags.Items.TINY_DUSTS_STEEL, RecipeCategory.MISC, ModItems.STEEL_NUGGET, 0.0f, 200, "steel");

        SmeltingTagged(recipeOutput, Items.IRON_INGOT, Tags.Items.INGOTS_IRON, RecipeCategory.MISC, ModItems.STEEL_INGOT, 0.0f, 200, "steel");
    }

    protected static <T extends AbstractCookingRecipe> void Smelting(RecipeOutput recipeOutput, ItemLike pIngredientItem, TagKey<Item> pIngredientTag,
                                                                     RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        Cooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new,
                pIngredientItem, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static <T extends AbstractCookingRecipe> void SmeltingTagged(RecipeOutput recipeOutput, ItemLike pIngredientItem, TagKey<Item> pIngredientTag,
                                                                           RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        CookingTagged(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new,
                pIngredientItem, pIngredientTag, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static <T extends AbstractCookingRecipe> void Blasting(RecipeOutput recipeOutput, ItemLike pIngredientItem, TagKey<Item> pIngredientTag,
                                                                     RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        Cooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new,
                pIngredientItem, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void BlastingTagged(RecipeOutput recipeOutput, ItemLike pIngredientItem, TagKey<Item> pIngredientTag,
                                                                           RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        CookingTagged(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new,
                pIngredientItem, pIngredientTag, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void Cooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                    ItemLike pIngredientItem, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(pIngredientItem), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(pIngredientItem), has(pIngredientItem))
                .save(recipeOutput, ModularTech.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(pIngredientItem));
    }

    protected static <T extends AbstractCookingRecipe> void CookingTagged(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                          ItemLike pIngredientItem, TagKey<Item> pIngredientTag, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(pIngredientTag), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(pIngredientItem), has(pIngredientItem))
                    .save(recipeOutput, ModularTech.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(pIngredientItem));
    }

    protected static void Compacting(RecipeOutput recipeOutput, ItemLike big_item, ItemLike small_item) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, big_item)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', small_item)
                .unlockedBy(getHasName(small_item), has(small_item))
                .save(recipeOutput, ModularTech.MODID + ":" + getItemName(big_item) + "_from_" + getItemName(small_item));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, small_item, 9)
                .requires(big_item)
                .unlockedBy(getHasName(big_item), has(big_item))
                .save(recipeOutput, ModularTech.MODID + ":" + getItemName(small_item) + "_from_" + getItemName(big_item));
    }

    protected static void CompactingTagged(RecipeOutput recipeOutput, TagKey<Item> big_tag, ItemLike big_item, TagKey<Item> small_tag, ItemLike small_item) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, big_item)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', small_tag)
                .unlockedBy(getHasName(small_item), has(small_tag))
                .save(recipeOutput, ModularTech.MODID + ":" + getItemName(big_item) + "_from_" + getItemName(small_item));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, small_item, 9)
                .requires(big_tag)
                .unlockedBy(getHasName(big_item), has(big_tag))
                .save(recipeOutput, ModularTech.MODID + ":" + getItemName(small_item) + "_from_" + getItemName(big_item));
    }
}
