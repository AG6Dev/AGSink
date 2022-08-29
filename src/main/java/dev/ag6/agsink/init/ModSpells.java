package dev.ag6.agsink.init;

import java.util.HashMap;
import java.util.Map;

import dev.ag6.agsink.item.magicwand.Spell;
import net.minecraft.world.level.Explosion;

//Custom Registry in the future
public class ModSpells {
	public static final Map<String, Spell> registeredSpells = new HashMap<>();

	static {
		registeredSpells.put("explode", new Spell(100, (level, player) -> {
			var hitResult = player.pick(20.0D, 0.0f, false);
			level.explode(player, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z, 20f,
					Explosion.BlockInteraction.BREAK);
		}));
	}
}
