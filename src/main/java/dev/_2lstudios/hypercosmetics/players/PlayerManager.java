package dev._2lstudios.hypercosmetics.players;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

public class PlayerManager {
	private Map<String, CosmeticPlayer> players = new HashMap<String, CosmeticPlayer>();

	public CosmeticPlayer addPlayer(Player player) {
		String username = player.getName();

		if (players.containsKey(username)) {
			this.players.remove(player.getName());
		}

		CosmeticPlayer cosmeticPlayer = new CosmeticPlayer(player);
		this.players.put(player.getName(), cosmeticPlayer);
		return cosmeticPlayer;
	}

	public CosmeticPlayer getPlayer(String name) {
		return this.players.get(name);
	}

	public CosmeticPlayer getPlayer(Player player) {
		return this.getPlayer(player.getName());
	}

	public void removePlayer(String name) {
		this.players.remove(name);
	}

	public void removePlayer(Player player) {
		this.removePlayer(player.getName());
	}
}