package net.davebalda.pacocraft.item;

import net.davebalda.pacocraft.PacoCraft;
import net.minecraft.world.item.Item;
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

    public static final RegistryObject<Item> PROTEIN_SHAKE = ITEMS.register("protein_shake",
            () -> new Item(new Item.Properties().food(ModFoods.PROTEIN_SHAKE)));


    /*
    * Item-related methods.
    */
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
