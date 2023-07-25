package dev.ag6.agsink.cap.explosives;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.LongTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

import java.util.ArrayList;
import java.util.List;

public class PlayerExplosiveDataCapability implements PlayerExplosiveData {
    public static final Capability<PlayerExplosiveData> EXPLOSIVE_DATA = CapabilityManager.get(new CapabilityToken<>() {
    });

    private final List<BlockPos> positions = new ArrayList<>();

    @Override
    public List<BlockPos> getPositions() {
        return positions;
    }

    @Override
    public void addPosition(BlockPos pos) {
        this.positions.add(pos);
    }

    @Override
    public void removePosition(BlockPos pos) {
        this.positions.remove(pos);
    }

    @Override
    public void clear() {
        positions.clear();
    }

    @Override
    public ListTag serializeNBT() {
        var list = new ListTag();
        for (BlockPos pos : positions) {
            list.add(LongTag.valueOf(pos.asLong()));
        }

        return list;
    }

    @Override
    public void deserializeNBT(ListTag nbt) {
        for (Tag t : nbt) {
            if (t instanceof LongTag tag) {
                positions.add(BlockPos.of(tag.getAsLong()));
            }
        }
    }
}
