package dev._2lstudios.hypercosmetics.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import dev._2lstudios.hypercosmetics.HyperCosmetics;

public class PlayerJoinListener implements Listener {

	private final HyperCosmetics plugin;

	public PlayerJoinListener(final HyperCosmetics plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent event) {
		this.plugin.getPlayerManager().addPlayer(event.getPlayer());
	}
}
