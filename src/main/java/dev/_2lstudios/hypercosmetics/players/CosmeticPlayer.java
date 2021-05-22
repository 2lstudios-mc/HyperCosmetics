package dev._2lstudios.hypercosmetics.players;

import org.bukkit.entity.Player;

public class CosmeticPlayer {
	private final Player bukkitPlayer;

	CosmeticPlayer(final Player player) {
		this.bukkitPlayer = player;
	}

	public Player getBukkitPlayer() {
		return this.bukkitPlayer;
	}
}
