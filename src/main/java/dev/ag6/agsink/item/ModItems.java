package dev.ag6.agsink.item;

import dev.ag6.agsink.AGSink;
import dev.ag6.agsink.block.ModBlocks;
import dev.ag6.agsink.entity.ModEntities;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AGSink.MOD_ID);

    public static final RegistryObject<Item> DETONATOR = ITEMS.register("detonator", DetonatorItem::new);
    public static final RegistryObject<Item> LUNCHBOX = ITEMS.register("lunchbox", LunchboxItem::new);
    public static final RegistryObject<Item> WISHBONE = ITEMS.register("wishbone", WishboneItem::new);
    public static final RegistryObject<Item> CRAB_CLAW = ITEMS.register("crab_claw", CrabClawItem::new);

    public static final RegistryObject<Item> CRAB_SPAWN_EGG = ITEMS.register("crab_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.CRAB, 0x469E12,0xFFA500, new Item.Properties()));
    public static final RegistryObject<Item> PENGUIN_SPAWN_EGG = ITEMS.register("penguin_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.PENGUIN, 0x000000,0xFFFFFF, new Item.Properties()));

    public static final RegistryObject<Item> C4_EXPLOSIVE_BLOCK_ITEM = ITEMS.register("c4_explosive", () -> new BlockItem(ModBlocks.C4_EXPLOSIVE.get(), new Item.Properties()));

    private ModItems() {
    }
}
