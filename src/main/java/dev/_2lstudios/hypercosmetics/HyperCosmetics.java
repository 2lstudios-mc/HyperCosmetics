package dev._2lstudios.hypercosmetics;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import dev._2lstudios.hypercosmetics.listeners.PlayerJoinListener;
import dev._2lstudios.hypercosmetics.listeners.PlayerQuitListener;

public class HyperCosmetics extends JavaPlugin {
	@Override
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new PlayerJoinListener(this), this);
		pm.registerEvents(new PlayerQuitListener(this), this);
	}
	
	private static HyperCosmetics Instance;

	public static HyperCosmetics getInstance() {
		return HyperCosmetics.Instance;
	}
}