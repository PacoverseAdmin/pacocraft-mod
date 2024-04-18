package net.davebalda.pacocraft.datagen;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.block.custom.ChechenArtichokeCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PacoCraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ETNITE_BLOCK);
        blockWithItem(ModBlocks.ORLEGNO_PLANKS);
        blockWithItem(ModBlocks.ETNITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ETNITE_ORE);
        blockWithItem(ModBlocks.TEST_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.ORLEGNO_STAIRS.get()), blockTexture(ModBlocks.ORLEGNO_PLANKS.get()));

        slabBlock(((SlabBlock) ModBlocks.ORLEGNO_SLAB.get()),
                blockTexture(ModBlocks.ORLEGNO_PLANKS.get()),
                blockTexture(ModBlocks.ORLEGNO_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.ORLEGNO_BUTTON.get()), blockTexture(ModBlocks.ORLEGNO_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.ORLEGNO_PRESSURE_PLATE.get()), blockTexture(ModBlocks.ORLEGNO_PLANKS.get()));

        fenceBlock(((FenceBlock) ModBlocks.ORLEGNO_FENCE.get()), blockTexture(ModBlocks.ORLEGNO_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.ORLEGNO_FENCE_GATE.get()), blockTexture(ModBlocks.ORLEGNO_PLANKS.get()));

        doorBlockWithRenderType((DoorBlock) ModBlocks.ORLEGNO_DOOR.get(),
                modLoc("block/orlegno_door_bottom"), modLoc("block/orlegno_door_top"), "cutout");

        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.ORLEGNO_TRAPDOOR.get(),
                modLoc("block/orlegno_trapdoor"), true, "cutout");

        makeChechenArtichokeCrop((CropBlock) ModBlocks.CHECHEN_ARTICHOKE_CROP.get(),
                "chechen_artichoke_stage", "chechen_artichoke_stage");
    }

    public void makeChechenArtichokeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> chechenArtichokeStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] chechenArtichokeStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((ChechenArtichokeCropBlock) block).getAgeProperty()),
                new ResourceLocation(PacoCraft.MOD_ID, "block/" + textureName + state.getValue(((ChechenArtichokeCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
