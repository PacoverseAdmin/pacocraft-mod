package net.davebalda.pacocraft.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties PROTEIN_SHAKE = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.2f).effect(
                    () -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 0), 1.0f
            ).build();
}
