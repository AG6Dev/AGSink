package dev.ag6.agsink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public final class ModConstants {

	public static final String MOD_ID = "agsink";

	public static final Logger LOGGER = LoggerFactory.getLogger(AGSink.class);

	public static final CreativeModeTab TAB = new CreativeModeTab("agsinkTab") {
		@Override
		public ItemStack makeIcon() {
			return ItemStack.EMPTY;
		}
	};
}
