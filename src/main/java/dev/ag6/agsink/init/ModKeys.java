package dev.ag6.agsink.init;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;

public final class ModKeys {
	public static final ModKeys INSTANCE = new ModKeys();

	public final KeyMapping SPELL_SELECT = new KeyMapping("agsink.spell_select.key", KeyConflictContext.IN_GAME,
			KeyModifier.SHIFT, InputConstants.getKey(InputConstants.KEY_X, -1), KeyMapping.CATEGORY_INTERFACE);
}
