package dev.ag6.agsink.item;

import dev.ag6.agsink.entity.HookEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HookItem extends Item {
    public HookItem() {
        super(new Properties().stacksTo(1).durability(5));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide) {
            pPlayer.getCooldowns().addCooldown(this, 60);

            HookEntity hookEntity = new HookEntity(pPlayer, pLevel);
            hookEntity.setItem(itemStack);
            hookEntity.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0f, 0.5f, 1.0f);
            pLevel.addFreshEntity(hookEntity);
        }

        return InteractionResultHolder.sidedSuccess(itemStack, pLevel.isClientSide);
    }

}
