package dev.ag6.agsink.cap.mana;

import net.minecraft.nbt.CompoundTag;

public class PlayerMagicData implements IMagicData {
	public String spell = "none";
	public int mana = 100;

	@Override
	public void setMana(int mana) {
		this.mana = mana;
	}

	@Override
	public int getMana() {
		return this.mana;
	}

	@Override
	public void setActiveSpell(String spell) {
		this.spell = spell;
	}

	@Override
	public String getActiveSpell() {
		return this.spell;
	}

	public CompoundTag serializeNBT() {
		var tag = new CompoundTag();
		tag.putInt("mana", this.mana);
		tag.putString("activeSpell", this.spell);
		return tag;
	}

	public static PlayerMagicData deserializeNBT(CompoundTag tag) {
		final var newData = new PlayerMagicData();
		newData.setMana(tag.getInt("mana"));
		newData.setActiveSpell(tag.getString("activeSpell"));
		return newData;
	}
}
