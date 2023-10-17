package dev.ag6.agsink.events;

import dev.ag6.agsink.AGSink;
import dev.ag6.agsink.cap.explosives.PlayerExplosiveData;
import dev.ag6.agsink.client.render.CrabRenderer;
import dev.ag6.agsink.entity.CrabEntity;
import dev.ag6.agsink.entity.ModEntities;
import dev.ag6.agsink.menu.ModMenuTypes;
import dev.ag6.agsink.menu.screen.LunchboxScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = AGSink.MOD_ID)
public final class ModEventHandler {
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerExplosiveData.class);
    }

    @SubscribeEvent
    public static void registerMobAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CRAB.get(), CrabEntity.createAttributes());
    }
}
