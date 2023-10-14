package dev.ag6.agsink.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.concurrent.ThreadLocalRandom;

public class WishboneItem extends Item {
    public WishboneItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide()) {
            ThreadLocalRandom random = ThreadLocalRandom.current();

            if(random.nextBoolean()) {
                pPlayer.sendSystemMessage(Component.translatable("item.agsink.wishbone.success"));
                pPlayer.addItem(new ItemStack(Items.DIAMOND, 1));

                return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
            }
            pPlayer.sendSystemMessage(Component.translatable("item.agsink.wishbone.failed"));

            return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
