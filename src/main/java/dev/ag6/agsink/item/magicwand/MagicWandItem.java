package dev.ag6.agsink.item.magicwand;

import dev.ag6.agsink.ModConstants;
import dev.ag6.agsink.cap.mana.IMagicData;
import dev.ag6.agsink.cap.mana.MagicCapability;
import dev.ag6.agsink.init.ModSpells;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

//TODO: Fix sync issues and make it less janky
public class MagicWandItem extends Item {
	public MagicWandItem() {
		super(new Properties().tab(ModConstants.TAB).stacksTo(1));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
		final IMagicData playerData = pPlayer.getCapability(MagicCapability.MAGIC_DATA_CAPABILITY)
				.orElseThrow(NullPointerException::new);
		final Spell spell = ModSpells.registeredSpells.get(/* playerData.getActiveSpell() */"explode");

		if (playerData.getMana() >= spell.manaConsumed()) {
			spell.action().accept(pLevel, pPlayer);
			playerData.setMana(playerData.getMana() - spell.manaConsumed());
		}
		return super.use(pLevel, pPlayer, pUsedHand);
	}
}
