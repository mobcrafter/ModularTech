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
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
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
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEEL_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.STEEL_INGOT.get())
                .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL_INGOT.get(), 9)
                .requires(ModBlocks.STEEL_BLOCK)
                .unlockedBy("has_steel_block", has(ModBlocks.STEEL_BLOCK)).save(recipeOutput);
    }

    protected static void Smelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void Blasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void Cooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, ModularTech.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
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
}
