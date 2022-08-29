package dev.ag6.agsink;

import dev.ag6.agsink.init.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModConstants.MOD_ID)
public class AGSink {
	public AGSink() {
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ModItems.MOD_ITEMS.register(bus);
	}
}
