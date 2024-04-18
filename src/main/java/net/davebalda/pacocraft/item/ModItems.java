package net.davebalda.pacocraft.item;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.sound.ModSounds;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PacoCraft.MOD_ID);

    /*
     * To add new items just add new RegistryObject objects down here.
     * There's NO NEED to recreate other methods!
     */
    public static final RegistryObject<Item> ETNITE_GEM = ITEMS.register("etnite_gem",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ETNITE_SWORD = ITEMS.register("etnite_sword",
            () -> new SwordItem(ModToolTiers.ETNITE, 4, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> ETNITE_PICKAXE = ITEMS.register("etnite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ETNITE, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> ETNITE_AXE = ITEMS.register("etnite_axe",
            () -> new AxeItem(ModToolTiers.ETNITE, 7, -3.1f, new Item.Properties()));
    public static final RegistryObject<Item> ETNITE_SHOVEL = ITEMS.register("etnite_shovel",
            () -> new ShovelItem(ModToolTiers.ETNITE, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> ETNITE_HOE = ITEMS.register("etnite_hoe",
            () -> new HoeItem(ModToolTiers.ETNITE, -2, -1.0f, new Item.Properties()));

    public static final RegistryObject<Item> ETNITE_HELMET = ITEMS.register("etnite_helmet",
            () -> new ArmorItem(ModArmorMaterials.ETNITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ETNITE_CHESTPLATE = ITEMS.register("etnite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ETNITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ETNITE_LEGGINGS = ITEMS.register("etnite_leggings",
            () -> new ArmorItem(ModArmorMaterials.ETNITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ETNITE_BOOTS = ITEMS.register("etnite_boots",
            () -> new ArmorItem(ModArmorMaterials.ETNITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> PROTEIN_SHAKE = ITEMS.register("protein_shake",
            () -> new Item(new Item.Properties().food(ModFoods.PROTEIN_SHAKE)));
    public static final RegistryObject<Item> CHECHEN_ARTICHOKE = ITEMS.register("chechen_artichoke",
            () -> new ItemNameBlockItem(ModBlocks.CHECHEN_ARTICHOKE_CROP.get(), new Item.Properties().food(ModFoods.CHECHEN_ARTICHOKE)));

    public static final RegistryObject<Item> MUSIC_DISC_FACCETTA_NERA = ITEMS.register("music_disc_faccetta_nera",
            () -> new RecordItem(6, ModSounds.FACCETTA_NERA,
                    new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 3120));
    public static final RegistryObject<Item> MUSIC_DISC_CHECHNYA = ITEMS.register("music_disc_chechnya",
            () -> new RecordItem(6, ModSounds.CHECHNYA,
                    new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 3840));


    /*
    * Item-related methods.
    */
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
