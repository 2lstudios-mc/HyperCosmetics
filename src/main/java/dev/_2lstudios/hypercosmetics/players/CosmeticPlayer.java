package dev._2lstudios.hypercosmetics.players;

import org.bukkit.entity.Player;

import dev._2lstudios.hypercosmetics.cosmetics.killeffects.KillEffect;

public class CosmeticPlayer {
	private final Player bukkitPlayer;
	private KillEffect killEffect;

	CosmeticPlayer(final Player player) {
		this.bukkitPlayer = player;
	}

	public Player getBukkitPlayer() {
		return this.bukkitPlayer;
	}

	public KillEffect getKillEffect() {
		return killEffect;
	}

	public void setKillEffect(KillEffect killEffect) {
		this.killEffect = killEffect;
	}
}
