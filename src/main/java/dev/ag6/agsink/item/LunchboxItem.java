package dev.ag6.agsink.item;

import dev.ag6.agsink.cap.lunchbox.LunchboxItemStackHandlerProvider;
import dev.ag6.agsink.menu.LunchboxMenu;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class LunchboxItem extends Item {
    public LunchboxItem() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        var stack = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide) {
            MenuProvider provider = new SimpleMenuProvider((id, inv, player) -> new LunchboxMenu(id, inv, stack), Component.translatable("container.agsink.lunchbox"));
            NetworkHooks.openScreen((ServerPlayer) pPlayer, provider);
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new LunchboxItemStackHandlerProvider();
    }
}
