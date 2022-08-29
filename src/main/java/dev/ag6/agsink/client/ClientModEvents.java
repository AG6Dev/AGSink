package dev.ag6.agsink.client;

import dev.ag6.agsink.ModConstants;
import dev.ag6.agsink.init.ModKeys;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ClientModEvents {
	@SubscribeEvent
	public static void registerKeyMappingsEvent(RegisterKeyMappingsEvent event) {
		event.register(ModKeys.INSTANCE.SPELL_SELECT);
	}
}
