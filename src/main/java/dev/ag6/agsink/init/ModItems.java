package dev.ag6.agsink.init;

import dev.ag6.agsink.ModConstants;
import dev.ag6.agsink.item.MagicWandItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> MOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModConstants.MOD_ID);

    public static final RegistryObject<Item> MAGIC_WAND = MOD_ITEMS.register("magic_wand", MagicWandItem::new);
}
