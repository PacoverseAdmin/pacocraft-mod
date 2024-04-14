package net.davebalda.pacocraft.item.util;

import net.davebalda.pacocraft.PacoCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        //public static final TagKey<Block> VALUABLE_LIST_OF_SOMETHING = tag("smht_val_list");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(PacoCraft.MOD_ID, name));
        }
    }

    public static class Items {
        //public static final TagKey<Item> VALUABLE_LIST_OF_SOMETHING = tag("smht_val_list");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(PacoCraft.MOD_ID, name));
        }
    }
}
