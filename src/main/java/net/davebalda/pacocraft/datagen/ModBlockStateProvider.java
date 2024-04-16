package net.davebalda.pacocraft.datagen;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

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
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
