package dev._2lstudios.hypercosmetics.cosmetics.projectiles;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Arrow;

public class TrailedProjectile {

	private final Arrow projectile;
	private final Particle particle;
	private final World world;

	TrailedProjectile(final Arrow arrow, final Particle particle) {
		this.projectile = arrow;
		this.particle = particle;
		this.world = this.projectile.getWorld();
	}

	public void spawnParticle() {
		Location location = this.projectile.getLocation();
		this.world.spawnParticle(this.particle, location, 1);
	}
}
