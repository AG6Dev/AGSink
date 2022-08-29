package dev.ag6.agsink.events;

import dev.ag6.agsink.ModConstants;
import dev.ag6.agsink.cap.mana.IMagicData;
import dev.ag6.agsink.network.ModPacketHandler;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(modid = ModConstants.MOD_ID, bus = Bus.MOD)
public final class CommonModEvents {

	@SubscribeEvent
	public static void commonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(ModPacketHandler::registerPackets);
	}

	@SubscribeEvent
	public static void registerCapabilitiesEvent(RegisterCapabilitiesEvent event) {
		event.register(IMagicData.class);
	}

}
