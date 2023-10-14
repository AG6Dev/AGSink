package dev.ag6.agsink.entity;

import dev.ag6.agsink.AGSink;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AGSink.MOD_ID);

    public static final RegistryObject<EntityType<HookEntity>> HOOK = ENTITIES.register("hook", () -> EntityType.Builder.<HookEntity>of(HookEntity::new, MobCategory.MISC).sized(0.25F, 0.25F).build("hook"));

}
