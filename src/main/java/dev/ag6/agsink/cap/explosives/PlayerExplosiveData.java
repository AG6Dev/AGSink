package dev.ag6.agsink.cap.explosives;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.ListTag;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.List;

public interface PlayerExplosiveData extends INBTSerializable<ListTag> {
    List<BlockPos> getPositions();

    void addPosition(BlockPos pos);

    void removePosition(BlockPos pos);

    void clear();
}
