package net.davebalda.pacocraft.item;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PacoCraft.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PC_ITEMS_TAB = CREATIVE_MODE_TABS.register("pc_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ETNITE_GEM.get()))
                    .title(Component.translatable("creativetab.pc_items_tab"))
                    .displayItems((pParameters, pOutput) ->{

                        //ITEMS OF "PC: ITEMS" CATEGORY
                        pOutput.accept(ModItems.ETNITE_GEM.get());
                        pOutput.accept(ModBlocks.ETNITE_BLOCK.get());

                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
