package dev.ag6.agsink.cap.lunchbox;

import dev.ag6.agsink.item.LunchboxItem;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

public class LunchboxItemStackHandler extends ItemStackHandler {
    public LunchboxItemStackHandler() {
        super(14);
    }

    @Override
    public boolean isItemValid(int slot, @NotNull ItemStack stack) {
        return stack.getItem().isEdible() || !(stack.getItem() instanceof LunchboxItem);
    }

    public NonNullList<Item> getAllItems() {
        NonNullList<Item> list = NonNullList.create();
        for (int i = 0; i < getSlots(); i++) {
            list.add(getStackInSlot(i).getItem());
        }
        return list;
    }
}
