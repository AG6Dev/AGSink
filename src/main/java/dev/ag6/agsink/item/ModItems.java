package dev.ag6.agsink.item;

import dev.ag6.agsink.ModConstants;
import dev.ag6.agsink.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModConstants.MOD_ID);

    public static final RegistryObject<Item> HOOK_ITEM = ITEMS.register("hook_item", HookItem::new);
    public static final RegistryObject<Item> DETONATOR = ITEMS.register("detonator", DetonatorItem::new);
    public static final RegistryObject<Item> LUNCHBOX = ITEMS.register("lunchbox", LunchboxItem::new);

    public static final RegistryObject<Item> C4_EXPLOSIVE_BLOCK_ITEM = ITEMS.register("c4_explosive", () -> new BlockItem(ModBlocks.C4_EXPLOSIVE.get(), new Item.Properties()));
}
