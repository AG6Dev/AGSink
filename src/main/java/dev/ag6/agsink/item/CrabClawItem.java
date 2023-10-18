package dev.ag6.agsink.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.NotNull;

public class CrabClawItem extends Item {
    public CrabClawItem() {
        super(new Item.Properties().stacksTo(1));
    }

    @Override
    public void inventoryTick(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player) {
            if (player.getItemInHand(InteractionHand.OFF_HAND).is(pStack.getItem())) {
                player.getAttribute(ForgeMod.BLOCK_REACH.get()).setBaseValue(4.5D + 1);
            } else {
                player.getAttribute(ForgeMod.BLOCK_REACH.get()).setBaseValue(4.5D);
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }
}
