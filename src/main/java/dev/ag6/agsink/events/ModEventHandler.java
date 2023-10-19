package dev.ag6.agsink.events;

import dev.ag6.agsink.AGSink;
import dev.ag6.agsink.cap.explosives.PlayerExplosiveData;
import dev.ag6.agsink.entity.CrabEntity;
import dev.ag6.agsink.entity.ModEntities;
import dev.ag6.agsink.entity.PenguinEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = AGSink.MOD_ID)
public final class ModEventHandler {
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerExplosiveData.class);
    }

    @SubscribeEvent
    public static void registerMobAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CRAB.get(), CrabEntity.createAttributes());
        event.put(ModEntities.PENGUIN.get(), PenguinEntity.createAttributes());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(ModEntities.CRAB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, CrabEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(ModEntities.PENGUIN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, PenguinEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);

    }

    private ModEventHandler() {
    }
}
