package dev.ag6.agsink.cap.explosives;

import dev.ag6.agsink.AGSink;
import net.minecraft.core.Direction;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerExplosiveDataProvider implements ICapabilitySerializable<ListTag> {
    public static final ResourceLocation ID = new ResourceLocation(AGSink.MOD_ID, "player_explosive_data");

    private final PlayerExplosiveData data = new PlayerExplosiveDataCapability();
    private final LazyOptional<PlayerExplosiveData> optional = LazyOptional.of(() -> this.data);

    public static void attach(AttachCapabilitiesEvent<Entity> event) {
        event.addCapability(ID, new PlayerExplosiveDataProvider());
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return PlayerExplosiveDataCapability.EXPLOSIVE_DATA.orEmpty(cap, this.optional);
    }

    @Override
    public ListTag serializeNBT() {
        return this.data.serializeNBT();
    }

    @Override
    public void deserializeNBT(ListTag nbt) {
        this.data.deserializeNBT(nbt);
    }

    public void invalidate() {
        this.optional.invalidate();
    }
}
