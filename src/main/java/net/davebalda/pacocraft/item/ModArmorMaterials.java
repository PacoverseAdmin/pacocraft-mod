package net.davebalda.pacocraft.item;

import net.davebalda.pacocraft.PacoCraft;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    ETNITE("etnite",20, new int[]{ 2, 6, 7, 3}, 10, SoundEvents.ARMOR_EQUIP_IRON,
            0.0f, 0.0f, () -> Ingredient.of(ModItems.ETNITE_GEM.get()));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 15, 13};

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue,
                      SoundEvent equipSound, float toughness, float knockbackResistance,
                      Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return PacoCraft.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
