package dev._2lstudios.hypercosmetics.cosmetics;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;

public class Trail {
    private final Particle particle;

    public Trail(final Particle particle) {
        this.particle = particle;
    }

    public Particle getParticle() {
        return particle;
    }

    public void update(final LivingEntity livingEntity) {
        final Location location = livingEntity.getLocation();

        location.getWorld().spawnParticle(particle, location, 3);
    }
}
