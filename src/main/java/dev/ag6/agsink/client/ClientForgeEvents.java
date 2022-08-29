package dev.ag6.agsink.client;

import java.util.Objects;

import com.mojang.blaze3d.systems.RenderSystem;

import dev.ag6.agsink.ModConstants;
import dev.ag6.agsink.cap.mana.MagicCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ClientForgeEvents {
	@SuppressWarnings("resource")
	@SubscribeEvent
	public static void renderOverlayEvents(RenderGuiOverlayEvent.Post event) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderTexture(0, new ResourceLocation("agsink", "textures/gui/magicoverlay.png"));

		var player = Objects.requireNonNull(Minecraft.getInstance().player);
		var magicData = player.getCapability(MagicCapability.MAGIC_DATA_CAPABILITY)
				.orElseThrow(NullPointerException::new);

		final var x = event.getWindow().getGuiScaledWidth() - 108;
		final var y = event.getWindow().getGuiScaledHeight() - 10;

		GuiComponent.blit(event.getPoseStack(), x, y, 0, 0, 0, 108, 5, 128, 128);
		ModConstants.LOGGER.debug("Player mana amount: {}", magicData.getMana());
		if (magicData.getMana() > 0) {
			int scale = (int) ((magicData.getMana() / 100F) * 108F);
			GuiComponent.blit(event.getPoseStack(), x, y, 0, 0, 5, scale, 10, 128, 128);
		}

		Minecraft.getInstance().font.draw(event.getPoseStack(), "Amount", event.getWindow().getGuiScaledWidth() - 68,
				event.getWindow().getGuiScaledHeight() - 20, 0xFFFFFF);
	}
}
