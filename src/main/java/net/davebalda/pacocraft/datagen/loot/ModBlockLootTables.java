package net.davebalda.pacocraft.datagen.loot;

import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        //DROP SELF
        this.dropSelf(ModBlocks.ETNITE_BLOCK.get());
        this.dropSelf(ModBlocks.ORLEGNO_PLANKS.get());
        this.dropSelf(ModBlocks.ORLEGNO_STAIRS.get());
        this.dropSelf(ModBlocks.ORLEGNO_BUTTON.get());
        this.dropSelf(ModBlocks.ORLEGNO_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ORLEGNO_FENCE.get());
        this.dropSelf(ModBlocks.ORLEGNO_FENCE_GATE.get());
        this.dropSelf(ModBlocks.ORLEGNO_TRAPDOOR.get());

        //ORE BLOCKS
        this.add(ModBlocks.ETNITE_ORE.get(),
                block -> createGenericOreDrops(ModBlocks.ETNITE_ORE.get(), ModItems.ETNITE_GEM.get(),
                        1.0F, 1.0F));
        this.add(ModBlocks.DEEPSLATE_ETNITE_ORE.get(),
                block -> createGenericOreDrops(ModBlocks.DEEPSLATE_ETNITE_ORE.get(), ModItems.ETNITE_GEM.get(),
                        1.0F, 1.0F));

        //SLABS
        this.add(ModBlocks.ORLEGNO_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ORLEGNO_SLAB.get()));

        //DOORS
        this.add(ModBlocks.ORLEGNO_DOOR.get(),
                block -> createDoorTable(ModBlocks.ORLEGNO_DOOR.get()));
    }

    protected LootTable.Builder createGenericOreDrops(Block pBlock, Item item, float min, float max) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item).apply(SetItemCountFunction
                        .setCount(UniformGenerator.between(min, max)))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
