package dev.ag6.agsink.block;

import dev.ag6.agsink.ModConstants;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModConstants.MOD_ID);

    public static final RegistryObject<Block> C4_EXPLOSIVE = BLOCKS.register("c4_explosive", C4ExplosiveBlock::new);
}
