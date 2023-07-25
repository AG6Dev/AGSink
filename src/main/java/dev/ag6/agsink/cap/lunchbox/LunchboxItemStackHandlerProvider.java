package dev.ag6.agsink.cap.lunchbox;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LunchboxItemStackHandlerProvider implements ICapabilitySerializable<CompoundTag> {
    private LunchboxItemStackHandler handler;
    private final LazyOptional<IItemHandler> lazy = LazyOptional.of(this::getCachedInventory);

    public LunchboxItemStackHandler getCachedInventory() {
        return handler == null ? handler = new LunchboxItemStackHandler() : handler;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return ForgeCapabilities.ITEM_HANDLER.orEmpty(cap, lazy);
    }

    @Override
    public CompoundTag serializeNBT() {
        return getCachedInventory().serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        getCachedInventory().deserializeNBT(nbt);
    }
}
