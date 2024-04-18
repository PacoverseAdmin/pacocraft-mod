package net.davebalda.pacocraft.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties PROTEIN_SHAKE = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.4f).effect(
                    () -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), 1.0f
            ).effect(
                    () -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0), 1.0f
            ).alwaysEat().build();

    public static final FoodProperties CHECHEN_ARTICHOKE = new FoodProperties.Builder().nutrition(1)
            .saturationMod(0.3f).build();
}
