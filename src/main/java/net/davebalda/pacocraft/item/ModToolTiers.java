package net.davebalda.pacocraft.item;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.item.util.ModTags;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier ETNITE = TierSortingRegistry.registerTier(
            new ForgeTier(2, 400, 7.0f, 2.0f, 14,
                    ModTags.Blocks.NEEDS_ETNITE_TOOL, () -> Ingredient.of(ModItems.ETNITE_GEM.get())),
            new ResourceLocation(PacoCraft.MOD_ID, "etnite_gem"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND)
    );
}
