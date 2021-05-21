package dev._2lstudios.hypercosmetics.players;

import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class CosmeticPlayer {

	private final Player bukkitPlayer;
	private Particle arrowTrail;

	CosmeticPlayer(final Player player) {
		this.bukkitPlayer = player;
	}

	public Particle getArrowTrail() {
		return this.arrowTrail;
	}

	public Player getBukkitPlayer() {
		return this.bukkitPlayer;
	}

	public void setArrowTrail(Particle arrowTrail) {
		this.arrowTrail = arrowTrail;
	}

}
