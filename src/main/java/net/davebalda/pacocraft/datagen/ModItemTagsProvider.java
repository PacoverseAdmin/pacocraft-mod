package net.davebalda.pacocraft.datagen;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, PacoCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //TRIMMABLE
        this.tag(ItemTags.TRIMMABLE_ARMOR).add(
                ModItems.ETNITE_HELMET.get(),
                ModItems.ETNITE_CHESTPLATE.get(),
                ModItems.ETNITE_LEGGINGS.get(),
                ModItems.ETNITE_BOOTS.get()
        );

        this.tag(ItemTags.PLANKS).add(
                ModBlocks.ORLEGNO_PLANKS.get().asItem()
        );

        this.tag(ItemTags.MUSIC_DISCS).add(
                ModItems.MUSIC_DISC_FACCETTA_NERA.get()
        );
    }
}
