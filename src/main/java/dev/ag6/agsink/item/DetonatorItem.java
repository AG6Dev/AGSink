package dev.ag6.agsink.item;

import dev.ag6.agsink.block.C4ExplosiveBlock;
import dev.ag6.agsink.cap.explosives.PlayerExplosiveDataCapability;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DetonatorItem extends Item {
    public DetonatorItem() {
        super(new Properties().stacksTo(1).durability(5));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            var data = pPlayer.getCapability(PlayerExplosiveDataCapability.EXPLOSIVE_DATA).orElseThrow(() -> new RuntimeException("Could not get player explosive data capability!"));
            var stack = pPlayer.getItemInHand(pUsedHand);

            for (int i = 0; i < data.getPositions().size(); i++) {
                var blockPos = data.getPositions().get(i);
                if (pLevel.getBlockState(blockPos).getBlock() != Blocks.AIR && pLevel.getBlockState(blockPos).getBlock() instanceof C4ExplosiveBlock explosiveBlock) {
                    if (pPlayer.blockPosition().distSqr(blockPos) < 1024) {
                        explosiveBlock.explode(pLevel, blockPos);
                        data.removePosition(blockPos);
                        stack.hurtAndBreak(1, pPlayer, (player) -> player.broadcastBreakEvent(pUsedHand));
                    }
                }
            }
        }
        return InteractionResultHolder.sidedSuccess(pPlayer.getItemInHand(pUsedHand), pLevel.isClientSide());
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.literal("Right click to detonate!"));
    }
}
