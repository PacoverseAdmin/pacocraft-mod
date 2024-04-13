package net.davebalda.pacocraft.block;

import com.mojang.blaze3d.shaders.Uniform;
import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.block.custom.TestBlock;
import net.davebalda.pacocraft.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PacoCraft.MOD_ID);

    /**
     * Test Blocks
     */
    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",
            () -> new TestBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK))); //Not in creative tab

    /*
    * To add new blocks just add new RegistryObject objects down here.
    * There's NO NEED to recreate other methods!
    */
    public static final RegistryObject<Block> ETNITE_BLOCK = registerBlock("etnite_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> ETNITE_ORE = registerBlock("etnite_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE)));

    public static final RegistryObject<Block> DEEPSLATE_ETNITE_ORE = registerBlock("deepslate_etnite_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_EMERALD_ORE)));


    /*
    * Block-related methods.
    */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
