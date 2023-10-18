package dev.ag6.agsink.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

public class WishboneItem extends Item {
    public WishboneItem() {
        super(new Item.Properties());
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, @NotNull InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide()) {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            if (random.nextBoolean()) {
                pPlayer.displayClientMessage(Component.translatable("item.agsink.wishbone.success"), true);
                pPlayer.addItem(new ItemStack(Items.DIAMOND, random.nextInt(1, 3)));
            } else {
                pPlayer.displayClientMessage(Component.translatable("item.agsink.wishbone.failure"), true);
            }

            if (!pPlayer.getAbilities().instabuild) {
                itemStack.shrink(1);
            }
        }
        return InteractionResultHolder.sidedSuccess(itemStack, pLevel.isClientSide());
    }
}
