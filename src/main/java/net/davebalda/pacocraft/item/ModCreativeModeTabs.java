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

    /*
     * To add new tabs just add new RegistryObject objects down here.
     * There's NO NEED to recreate other methods!
     */
    public static final RegistryObject<CreativeModeTab> PC_ITEMS_TAB = CREATIVE_MODE_TABS.register("pc_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ETNITE_GEM.get()))
                    .title(Component.translatable("creativetab.pc_items_tab"))
                    .displayItems((pParameters, pOutput) ->{

                        //ITEMS OF "PC: ITEMS" CATEGORY
                        pOutput.accept(ModItems.ETNITE_GEM.get());
                        pOutput.accept(ModItems.PROTEIN_SHAKE.get());
                        pOutput.accept(ModItems.CHECHEN_ARTICHOKE.get());
                        pOutput.accept(ModItems.MUSIC_DISC_FACCETTA_NERA.get());
                        pOutput.accept(ModItems.MUSIC_DISC_CHECHNYA.get());

                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> PC_BLOCKS_TAB = CREATIVE_MODE_TABS.register("pc_creative_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.ORLEGNO_PLANKS.get()))
                    .title(Component.translatable("creativetab.pc_blocks_tab"))
                    .displayItems((pParameters, pOutput) ->{

                        //ITEMS OF "PC: BLOCKS" CATEGORY
                        pOutput.accept(ModBlocks.ETNITE_BLOCK.get());
                        pOutput.accept(ModBlocks.ETNITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_ETNITE_ORE.get());
                        pOutput.accept(ModBlocks.ORLEGNO_PLANKS.get());
                        pOutput.accept(ModBlocks.ORLEGNO_STAIRS.get());
                        pOutput.accept(ModBlocks.ORLEGNO_SLAB.get());
                        pOutput.accept(ModBlocks.ORLEGNO_FENCE.get());
                        pOutput.accept(ModBlocks.ORLEGNO_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.ORLEGNO_BUTTON.get());
                        pOutput.accept(ModBlocks.ORLEGNO_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.ORLEGNO_DOOR.get());
                        pOutput.accept(ModBlocks.ORLEGNO_TRAPDOOR.get());

                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> PC_TOOLS_TAB = CREATIVE_MODE_TABS.register("pc_tools_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ETNITE_PICKAXE.get()))
                    .title(Component.translatable("creativetab.pc_tools_tab"))
                    .displayItems((pParameters, pOutput) ->{

                        //ITEMS OF "PC: TOOLS" CATEGORY
                        pOutput.accept(ModItems.ETNITE_SWORD.get());
                        pOutput.accept(ModItems.ETNITE_PICKAXE.get());
                        pOutput.accept(ModItems.ETNITE_AXE.get());
                        pOutput.accept(ModItems.ETNITE_SHOVEL.get());
                        pOutput.accept(ModItems.ETNITE_HOE.get());
                        pOutput.accept(ModItems.ETNITE_HELMET.get());
                        pOutput.accept(ModItems.ETNITE_CHESTPLATE.get());
                        pOutput.accept(ModItems.ETNITE_LEGGINGS.get());
                        pOutput.accept(ModItems.ETNITE_BOOTS.get());

                    })
                    .build());

    /*
    * Tabs-related methods.
    */
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
