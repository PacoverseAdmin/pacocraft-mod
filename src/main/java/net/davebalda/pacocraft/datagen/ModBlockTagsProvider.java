package net.davebalda.pacocraft.datagen;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PacoCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        //MINEABLE WITH PICKAXE blocks
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.ETNITE_ORE.get(),
                ModBlocks.DEEPSLATE_ETNITE_ORE.get(),
                ModBlocks.ETNITE_BLOCK.get()
        );

        //MINEABLE WITH AXE blocks
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(
                ModBlocks.ORLEGNO_PLANKS.get()
        );

        //NEEDS STONE TOOL blocks
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.ETNITE_BLOCK.get());

        //NEEDS IRON TOOL blocks
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
                ModBlocks.ETNITE_ORE.get(),
                ModBlocks.DEEPSLATE_ETNITE_ORE.get()
        );

        //PLANKS (for crafting/smelting)
        this.tag(BlockTags.PLANKS).add(
                ModBlocks.ORLEGNO_PLANKS.get()
        );

        //FENCES (for connection)
        this.tag(BlockTags.FENCES).add(
                ModBlocks.ORLEGNO_FENCE.get()
        );

        //FENCE GATES (for connection)
        this.tag(BlockTags.FENCE_GATES).add(
                ModBlocks.ORLEGNO_FENCE_GATE.get()
        );
    }
}
