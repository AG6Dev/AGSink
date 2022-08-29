package dev.ag6.agsink.item.magicwand;

import java.util.function.BiConsumer;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public record Spell(int manaConsumed, BiConsumer<Level, Player> action) {
}
