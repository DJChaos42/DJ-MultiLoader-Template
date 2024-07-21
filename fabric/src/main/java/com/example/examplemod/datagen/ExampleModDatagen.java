package com.example.examplemod.datagen;

import com.example.examplemod.registry.RegistryObject;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ExampleModDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        // CLIENT
        pack.addProvider(ExampleModLangProvider::new);
        pack.addProvider(ExampleModModelProvider::new);
        pack.addProvider(ExampleModBlockLootProvider::new);
        FabricTagProvider.BlockTagProvider blockTags = pack.addProvider(ExampleModBlockTagProvider::new);
    }

    // CLIENT
    public static class ExampleModLangProvider extends FabricLanguageProvider {
        protected ExampleModLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
            super(dataOutput, registryLookup);
        }

        @Override
        public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
            
        }
    }
    public static class ExampleModModelProvider extends FabricModelProvider {
        private static final ModelTemplate CUSTOM_SPAWN_EGG = new ModelTemplate(Optional.of(ResourceLocation.withDefaultNamespace("item/template_spawn_egg")), Optional.empty());

        public ExampleModModelProvider(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
            
        }

        @Override
        public void generateItemModels(ItemModelGenerators itemModelGenerator) {
            
        }
    }

    // SERVER

    // LOOT
    public static class ExampleModBlockLootProvider extends FabricBlockLootTableProvider {
        protected ExampleModBlockLootProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
            super(dataOutput, registryLookup);
        }

        @Override
        public void generate() {
            
        }
    }

    // TAGS
    public static class ExampleModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
        FabricTagProvider<Block>.FabricTagBuilder AXE = getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE);
        FabricTagProvider<Block>.FabricTagBuilder HOE = getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_HOE);
        FabricTagProvider<Block>.FabricTagBuilder PICKAXE = getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE);
        FabricTagProvider<Block>.FabricTagBuilder SHOVEL = getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_SHOVEL);
      
        public ExampleModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider wrapperLookup) {
            
            
        }
    }
}
