package dev.ag6.agsink.events;

import com.google.common.eventbus.Subscribe;
import com.mojang.blaze3d.systems.RenderSystem;
import dev.ag6.agsink.ModConstants;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ClientForgeEvents {
    @Subscribe
    public static void renderOverlayEvents(final RenderGuiOverlayEvent.Post event) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, new ResourceLocation("agsink", "textures/gui/magicoverlay.png"));

        GuiComponent.blit(event.getPoseStack(), event.getWindow().getX() / 2, event.getWindow().getY() / 2, 0f, 0f, 256, 256, 256, 256);
    }
}
