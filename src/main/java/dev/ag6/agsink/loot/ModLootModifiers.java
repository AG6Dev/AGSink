package dev.ag6.agsink.loot;

import com.mojang.serialization.Codec;
import dev.ag6.agsink.AGSink;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, AGSink.MOD_ID);

    public static final RegistryObject<Codec<? extends AddItemWithChanceModifier>> ADD_ITEM = LOOT_MODIFIERS.register("add_item_with_chance", AddItemWithChanceModifier.CODEC);

    private ModLootModifiers() {}
}
