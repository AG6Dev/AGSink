package dev.ag6.agsink.client.event;

import dev.ag6.agsink.AGSink;
import dev.ag6.agsink.client.model.CrabModel;
import dev.ag6.agsink.client.model.PenguinModel;
import dev.ag6.agsink.client.render.CrabRenderer;
import dev.ag6.agsink.client.render.PenguinRenderer;
import dev.ag6.agsink.entity.ModEntities;
import dev.ag6.agsink.menu.ModMenuTypes;
import dev.ag6.agsink.menu.screen.LunchboxScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public final class ClientEventHandler {
    @Mod.EventBusSubscriber(modid = AGSink.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static final class ModEvents {
        @SubscribeEvent
        public static void registerLayersEvent(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(CrabModel.LAYER_LOCATION, CrabModel::createBodyLayer);
            event.registerLayerDefinition(PenguinModel.LAYER_LOCATION, PenguinModel::createBodyLayer);
        }

        @SubscribeEvent
        public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(ModEntities.CRAB.get(), CrabRenderer::new);
            event.registerEntityRenderer(ModEntities.PENGUIN.get(), PenguinRenderer::new);
        }

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                MenuScreens.register(ModMenuTypes.LUNCHBOX.get(), LunchboxScreen::new);
            });
        }

        private ModEvents() {
        }
    }

    private ClientEventHandler() {
    }
}
