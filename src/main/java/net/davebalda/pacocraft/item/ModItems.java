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

    //MOD ITEMS
    public static final RegistryObject<Item> ETNITE_GEM = ITEMS.register("etnite_gem",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
