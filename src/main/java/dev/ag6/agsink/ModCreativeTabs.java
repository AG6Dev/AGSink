package dev.ag6.agsink;

import dev.ag6.agsink.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModConstants.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_TABS.register("mod_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.literal("AGSINK"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.DETONATOR.get());
                        pOutput.accept(ModItems.HOOK_ITEM.get());
                        pOutput.accept(ModItems.C4_EXPLOSIVE_BLOCK_ITEM.get());
                        pOutput.accept(ModItems.LUNCHBOX.get());
                    }).icon(() -> new ItemStack(Blocks.BAMBOO_BLOCK)).build());

}
