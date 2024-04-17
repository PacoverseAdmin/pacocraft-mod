package net.davebalda.pacocraft.datagen;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;
import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {

    /**
     * For trimmables
     */
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PacoCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ETNITE_GEM);
        simpleItem(ModItems.PROTEIN_SHAKE);

        handheldItem(ModItems.ETNITE_SWORD);
        handheldItem(ModItems.ETNITE_PICKAXE);
        handheldItem(ModItems.ETNITE_AXE);
        handheldItem(ModItems.ETNITE_HOE);
        handheldItem(ModItems.ETNITE_SHOVEL);

        trimmedArmorItem(ModItems.ETNITE_HELMET);
        trimmedArmorItem(ModItems.ETNITE_CHESTPLATE);
        trimmedArmorItem(ModItems.ETNITE_LEGGINGS);
        trimmedArmorItem(ModItems.ETNITE_BOOTS);

        simpleBlockItem(ModBlocks.ORLEGNO_DOOR);

        simplerBlockItem(ModBlocks.ORLEGNO_STAIRS);
        simplerBlockItem(ModBlocks.ORLEGNO_SLAB);
        simplerBlockItem(ModBlocks.ORLEGNO_PRESSURE_PLATE);
        simplerBlockItem(ModBlocks.ORLEGNO_FENCE_GATE);

        fenceItem(ModBlocks.ORLEGNO_FENCE, ModBlocks.ORLEGNO_PLANKS);

        trapdoorItem(ModBlocks.ORLEGNO_TRAPDOOR);

        buttonItem(ModBlocks.ORLEGNO_BUTTON, ModBlocks.ORLEGNO_PLANKS);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PacoCraft.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(PacoCraft.MOD_ID, "item/" + item.getId().getPath()));
    }

    private void simplerBlockItem(RegistryObject<Block> item){
        this.withExistingParent(PacoCraft.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(item.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(item.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PacoCraft.MOD_ID, "item/" + item.getId().getPath()));
    }

    private void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(PacoCraft.MOD_ID, "block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock.get())).getPath()));
    }

    private void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(PacoCraft.MOD_ID, "block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock.get())).getPath()));
    }

    private void trapdoorItem(RegistryObject<Block> block){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    private void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(), mcLoc("block/wall_inventory"))
                .texture("texture", new ResourceLocation(PacoCraft.MOD_ID, "block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock.get())).getPath()));
    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = PacoCraft.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
}
