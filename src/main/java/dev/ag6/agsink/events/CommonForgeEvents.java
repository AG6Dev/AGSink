package dev.ag6.agsink.events;

import dev.ag6.agsink.ModConstants;
import dev.ag6.agsink.cap.mana.IMagicData;
import dev.ag6.agsink.cap.mana.MagicCapability;
import dev.ag6.agsink.cap.mana.PlayerMagicData;
import dev.ag6.agsink.network.CSyncPlayerMagicDataPacket;
import dev.ag6.agsink.network.ModPacketHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PacketDistributor;

@Mod.EventBusSubscriber(modid = ModConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class CommonForgeEvents {
	@SubscribeEvent
	public static void attachCapabilityEvent(final AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof Player player) {
			final var data = new PlayerMagicData();
			final var provider = new MagicCapability.Provider(LazyOptional.of(() -> data), data);
			event.addCapability(new ResourceLocation(ModConstants.MOD_ID, "magic_data"), provider);
		}
	}

	@SubscribeEvent
	public static void onPlayerCloneEvent(final PlayerEvent.Clone event) {
		event.getOriginal().getCapability(MagicCapability.MAGIC_DATA_CAPABILITY).ifPresent(oldData -> {
			event.getEntity().getCapability(MagicCapability.MAGIC_DATA_CAPABILITY).ifPresent(newData -> {
				newData.setMana(oldData.getMana());
				newData.setActiveSpell(oldData.getActiveSpell());
			});
		});
	}

	@SubscribeEvent
	public static void onPlayerLoggedIn(final PlayerLoggedInEvent event) {
		if (!event.getEntity().getLevel().isClientSide()) {
			event.getEntity().getCapability(MagicCapability.MAGIC_DATA_CAPABILITY).ifPresent(data -> {
				ModPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()),
						new CSyncPlayerMagicDataPacket(data.getMana(), data.getActiveSpell()));
			});
		}
	}

	@SubscribeEvent
	public static void onPlayerTickEvent(final PlayerTickEvent event) {
		final IMagicData magicData = event.player.getCapability(MagicCapability.MAGIC_DATA_CAPABILITY)
				.orElseThrow(NullPointerException::new);
		// Could slow it down if need be, but if it works it works
		if (magicData.getMana() != 100) {
			magicData.setMana(magicData.getMana() + 1);
		}
	}
}
