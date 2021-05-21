package dev._2lstudios.hypercosmetics;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import dev._2lstudios.hypercosmetics.listeners.PlayerJoinListener;
import dev._2lstudios.hypercosmetics.listeners.PlayerQuitListener;
import dev._2lstudios.hypercosmetics.players.PlayerManager;

public class HyperCosmetics extends JavaPlugin {

	private PlayerManager playerManager;

	@Override
	public void onEnable() {
		this.playerManager = new PlayerManager();

		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new PlayerJoinListener(this), this);
		pm.registerEvents(new PlayerQuitListener(this), this);
	}

	public PlayerManager getPlayerManager() {
		return this.playerManager;
	}

	/* Static instance */
	private static HyperCosmetics Instance;

	public static HyperCosmetics getInstance() {
		return HyperCosmetics.Instance;
	}
}