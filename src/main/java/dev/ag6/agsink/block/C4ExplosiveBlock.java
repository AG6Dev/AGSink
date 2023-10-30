package dev.ag6.agsink.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class C4ExplosiveBlock extends Block {
    public C4ExplosiveBlock() {
        super(Properties.of().strength(5.0F, -1F));
    }

    public void explode(Level level, BlockPos pos) {
        level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 7.0F, Level.ExplosionInteraction.BLOCK);
    }
}
