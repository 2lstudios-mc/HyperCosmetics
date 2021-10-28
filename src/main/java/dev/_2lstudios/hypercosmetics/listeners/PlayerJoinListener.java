package dev._2lstudios.hypercosmetics.listeners;

import com.comphenix.protocol.wrappers.EnumWrappers.Particle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import dev._2lstudios.hypercosmetics.cosmetics.trails.TrailsController;

public class PlayerJoinListener implements Listener {
	private final TrailsController trailsController;

	public PlayerJoinListener(final TrailsController trailsController) {
		this.trailsController = trailsController;
	}

	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent event) {
		trailsController.applyTrail(event.getPlayer(), Particle.CRIT_MAGIC);
	}
}
