package com.mobcrafter.modulartech.block.entity;

import com.mobcrafter.modulartech.ModularTech;
import com.mobcrafter.modulartech.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ModularTech.MODID);

    public static final Supplier<BlockEntityType<CompactGeneratorBlockEntity>> COMPACT_GENERATOR_BE =
            BLOCK_ENTITIES.register("compact_generator_be", () -> BlockEntityType.Builder.of(
                    CompactGeneratorBlockEntity::new, ModBlocks.COMPACT_GENERATOR.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
