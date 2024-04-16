package net.davebalda.pacocraft.datagen;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {

        //SHAPED: 9 etnite gems -> 1 ETNITE BLOCK
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ETNITE_BLOCK.get())
                .pattern("GGG")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModItems.ETNITE_GEM.get())
                .unlockedBy(getHasName(ModItems.ETNITE_GEM.get()), has(ModItems.ETNITE_GEM.get()))
                .save(recipeOutput);

        //SHAPELESS: 1 etnite block -> 9 ETNITE GEMS
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ETNITE_GEM.get(), 9)
                .requires(ModBlocks.ETNITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ETNITE_BLOCK.get()), has(ModBlocks.ETNITE_BLOCK.get()))
                .save(recipeOutput);

        /*
        //SHAPELESS: 1 gunpowder, 1 glowstone_dust, 1 redstone, 1 glass_bottle -> 1 PROTEIN SHAKE
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PROTEIN_SHAKE.get(), 1)
                .requires(((ItemLike) Items.GLASS_BOTTLE))
                .requires(((ItemLike) Items.REDSTONE))
                .requires(((ItemLike) Items.GLOWSTONE_DUST))
                .requires(((ItemLike) Items.GUNPOWDER))
                .unlockedBy(getHasName(((ItemLike) Items.GLASS_BOTTLE)), has(((ItemLike) Items.GLASS_BOTTLE)))
                .save(recipeOutput);
         */
    }

    protected static void oreSmelting(@NotNull RecipeOutput pRecipeOutput, List<ItemLike> pIngredients,
                                      @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience,
                                      int pCookingTime, @NotNull String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory,
                pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(@NotNull RecipeOutput pRecipeOutput, List<ItemLike> pIngredients,
                                      @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience,
                                      int pCookingTime, @NotNull String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory,
                pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput,
                                                                     RecipeSerializer<T> pSerializer,
                                                                     AbstractCookingRecipe.Factory<T> pRecipeFactory,
                                                                     List<ItemLike> pIngredients, RecipeCategory pCategory,
                                                                     ItemLike pResult, float pExperience, int pCookingTime,
                                                                     String pGroup, String pSuffix) {

        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience,
                    pCookingTime, pSerializer, pRecipeFactory).group(pGroup).unlockedBy(getHasName(itemlike),
                    has(itemlike)).save(pRecipeOutput, PacoCraft.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }

    }

}
