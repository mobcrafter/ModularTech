package com.mobcrafter.modulartech.datagen;

import com.mobcrafter.modulartech.ModularTech;
import com.mobcrafter.modulartech.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ModularTech.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SOUL_STEEL_INGOT);
        simpleItem(ModItems.SOUL_STEEL_NUGGET);

        simpleItem(ModItems.POWDERED_ANCIENT_DEBRIS);

        simpleItem(ModItems.COAL_DUST);
        simpleItem(ModItems.CHARCOAL_DUST);
        simpleItem(ModItems.IRON_DUST);
        simpleItem(ModItems.COPPER_DUST);
        simpleItem(ModItems.GOLD_DUST);
        simpleItem(ModItems.NETHERITE_DUST);
        simpleItem(ModItems.EMERALD_DUST);
        simpleItem(ModItems.LAPIS_DUST);
        simpleItem(ModItems.DIAMOND_DUST);
        simpleItem(ModItems.SOUL_STEEL_DUST);

        simpleItem(ModItems.REDSTONE_PIECE);
        simpleItem(ModItems.GLOWSTONE_DUST_PIECE);

        simpleItem(ModItems.COAL_DUST_PIECE);
        simpleItem(ModItems.CHARCOAL_DUST_PIECE);
        simpleItem(ModItems.IRON_DUST_PIECE);
        simpleItem(ModItems.COPPER_DUST_PIECE);
        simpleItem(ModItems.GOLD_DUST_PIECE);
        simpleItem(ModItems.NETHERITE_DUST_PIECE);
        simpleItem(ModItems.EMERALD_DUST_PIECE);
        simpleItem(ModItems.LAPIS_DUST_PIECE);
        simpleItem(ModItems.DIAMOND_DUST_PIECE);
        simpleItem(ModItems.SOUL_STEEL_DUST_PIECE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ModularTech.MODID,"item/" + item.getId().getPath()));
    }
}
