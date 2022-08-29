package dev.ag6.agsink.network;

import java.util.function.Supplier;

import dev.ag6.agsink.cap.mana.MagicCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

public class CSyncPlayerMagicDataPacket {
	private final int mana;
	private final String activeSpell;

	public CSyncPlayerMagicDataPacket(FriendlyByteBuf buffer) {
		this.mana = buffer.readInt();
		this.activeSpell = buffer.readUtf();
	}

	public CSyncPlayerMagicDataPacket(int mana, String spell) {
		this.mana = mana;
		this.activeSpell = spell;
	}

	public void encode(FriendlyByteBuf buffer) {
		buffer.writeInt(mana);
		buffer.writeUtf(activeSpell);
	}

	@SuppressWarnings("resource")
	public static void handle(CSyncPlayerMagicDataPacket pkt, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			final Player clientPlayer = Minecraft.getInstance().player;
			clientPlayer.getCapability(MagicCapability.MAGIC_DATA_CAPABILITY).ifPresent(data -> {
				data.setMana(pkt.mana);
				data.setActiveSpell(pkt.activeSpell);
			});
		});
	}

}
