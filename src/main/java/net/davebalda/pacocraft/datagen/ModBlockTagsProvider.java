package net.davebalda.pacocraft.datagen;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PacoCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //MINEABLE WITH PICKAXE blocks
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.ETNITE_ORE.get(),
                ModBlocks.DEEPSLATE_ETNITE_ORE.get(),
                ModBlocks.ETNITE_BLOCK.get()
        );

        //NEEDS STONE TOOL blocks
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.ETNITE_BLOCK.get());

        //NEEDS IRON TOOL blocks
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
                ModBlocks.ETNITE_ORE.get(),
                ModBlocks.DEEPSLATE_ETNITE_ORE.get()
        );
    }
}
