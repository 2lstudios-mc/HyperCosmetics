package dev._2lstudios.hypercosmetics.cosmetics.trails;

import org.bukkit.Location;
import org.bukkit.Particle;

public class Trail {
    private final Particle particle;

    public Trail(final Particle particle) {
        this.particle = particle;
    }

    public Particle getParticle() {
        return particle;
    }

    public void spawnParticles(final Location location) {
        location.getWorld().spawnParticle(particle, location, 1);
    }
}
