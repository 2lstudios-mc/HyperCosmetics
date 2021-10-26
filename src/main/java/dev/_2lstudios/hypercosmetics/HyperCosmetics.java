package dev._2lstudios.hypercosmetics;

import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import dev._2lstudios.hypercosmetics.cosmetics.trails.TrailsController;
import dev._2lstudios.hypercosmetics.cosmetics.trails.TrailsService;
import dev._2lstudios.hypercosmetics.listeners.PlayerJoinListener;
import dev._2lstudios.hypercosmetics.listeners.PlayerQuitListener;

public class HyperCosmetics extends JavaPlugin {
	@Override
	public void onEnable() {
		final Server server = getServer();
		final PluginManager pluginManager = server.getPluginManager();
		final TrailsService trailsService = new TrailsService();
		final TrailsController trailsController = new TrailsController();

		pluginManager.registerEvents(new PlayerJoinListener(trailsController), this);
		pluginManager.registerEvents(new PlayerQuitListener(this), this);
		
		server.getScheduler().runTaskTimer(this, trailsController, 1L, 1L);
	}
	
	private static HyperCosmetics Instance;

	public static HyperCosmetics getInstance() {
		return HyperCosmetics.Instance;
	}
}