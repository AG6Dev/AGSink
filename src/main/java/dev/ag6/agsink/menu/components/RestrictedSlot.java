package dev.ag6.agsink.menu.components;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class RestrictedSlot extends SlotItemHandler {
    private final Predicate<ItemStack> placeFilter;
    private final boolean canTake;

    public RestrictedSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition, Predicate<ItemStack> placeFilter, boolean canTake) {
        super(itemHandler, index, xPosition, yPosition);

        this.placeFilter = placeFilter;
        this.canTake = canTake;
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        if (!placeFilter.test(stack)) {
            return false;
        }
        return super.mayPlace(stack);
    }

    @Override
    public boolean mayPickup(Player playerIn) {
        if (!canTake) {
            return false;
        }
        return super.mayPickup(playerIn);
    }
}
