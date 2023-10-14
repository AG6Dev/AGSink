package dev.ag6.agsink.events;

import dev.ag6.agsink.AGSink;
import dev.ag6.agsink.block.ModBlocks;
import dev.ag6.agsink.cap.explosives.PlayerExplosiveDataCapability;
import dev.ag6.agsink.cap.explosives.PlayerExplosiveDataProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AGSink.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ForgeEventHandler {
    @SubscribeEvent
    public static void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            PlayerExplosiveDataProvider.attach(event);
        }
    }

    @SubscribeEvent
    public static void onBlockPlaced(BlockEvent.EntityPlaceEvent event) {
        if (!event.getLevel().isClientSide()) {
            if (event.getPlacedBlock().getBlock().equals(ModBlocks.C4_EXPLOSIVE.get())) {
                if (event.getEntity() instanceof Player player) {
                    player.getCapability(PlayerExplosiveDataCapability.EXPLOSIVE_DATA).ifPresent(data -> data.addPosition(event.getPos()));
                }
            }
        }
    }
}
