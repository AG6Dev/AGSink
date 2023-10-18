package dev.ag6.agsink.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class LunchboxMenu extends AbstractContainerMenu {
    public LunchboxMenu(int pContainerId, Inventory inv, FriendlyByteBuf buf) {
        this(pContainerId, inv, ItemStack.EMPTY);
    }

    public LunchboxMenu(int containerId, Inventory playerInv, ItemStack stack) {
        super(ModMenuTypes.LUNCHBOX.get(), containerId);

        var itemHandler = stack.getCapability(ForgeCapabilities.ITEM_HANDLER).orElseGet(() -> new ItemStackHandler(14));

        System.out.println(itemHandler.getSlots());

        //lunchbox inv slots
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 7; j++) {
                this.addSlot(new SlotItemHandler(itemHandler, j + i * 7, 26 + j * 18, 26 + i * 18));
            }
        }

        //player inv
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInv, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }

        //player hotbar
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInv, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return true;
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player playerIn, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (pIndex < 2 * 7) {
                if (!this.moveItemStackTo(itemstack1, 2 * 7, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, 2 * 7, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

}
