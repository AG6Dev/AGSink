package dev.ag6.agsink;

import com.mojang.logging.LogUtils;
import dev.ag6.agsink.block.ModBlocks;
import dev.ag6.agsink.block.entity.ModBlockEntityTypes;
import dev.ag6.agsink.entity.ModEntities;
import dev.ag6.agsink.item.ModItems;
import dev.ag6.agsink.loot.ModLootModifiers;
import dev.ag6.agsink.menu.ModMenuTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(AGSink.MOD_ID)
public final class AGSink {
    public static final String MOD_ID = "agsink";

    public static final Logger LOGGER = LogUtils.getLogger();

    public AGSink() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(bus);
        ModEntities.ENTITIES.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModBlockEntityTypes.BLOCK_ENTITY_TYPES.register(bus);
        ModCreativeTabs.CREATIVE_TABS.register(bus);
        ModMenuTypes.MENU_TYPES.register(bus);
        ModLootModifiers.LOOT_MODIFIERS.register(bus);
    }
}
