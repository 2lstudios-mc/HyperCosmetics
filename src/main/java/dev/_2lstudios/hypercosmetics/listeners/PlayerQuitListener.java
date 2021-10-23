package dev._2lstudios.hypercosmetics.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import dev._2lstudios.hypercosmetics.HyperCosmetics;

public class PlayerQuitListener implements Listener {
	private final HyperCosmetics plugin;

	public PlayerQuitListener(final HyperCosmetics plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerQuit(final PlayerQuitEvent event) {

	}
}
