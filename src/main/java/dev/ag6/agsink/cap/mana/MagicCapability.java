package dev.ag6.agsink.cap.mana;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class MagicCapability {
	public static final Capability<IMagicData> MAGIC_DATA_CAPABILITY = CapabilityManager
			.get(new CapabilityToken<IMagicData>() {
			});

	public static class Provider implements ICapabilitySerializable<CompoundTag> {
		public final LazyOptional<IMagicData> cap;
		public final IMagicData instance;

		public Provider(LazyOptional<IMagicData> cap, IMagicData instance) {
			this.cap = cap;
			this.instance = instance;
		}

		@Override
		public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
			return MAGIC_DATA_CAPABILITY.orEmpty(cap, this.cap);
		}

		@Override
		public CompoundTag serializeNBT() {
			return ((PlayerMagicData) instance).serializeNBT();
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			PlayerMagicData.deserializeNBT(nbt);
		}
	}
}
