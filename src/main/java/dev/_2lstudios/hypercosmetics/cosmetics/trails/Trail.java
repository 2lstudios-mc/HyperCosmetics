package dev._2lstudios.hypercosmetics.cosmetics.trails;

import java.lang.reflect.InvocationTargetException;

import com.comphenix.protocol.wrappers.EnumWrappers.Particle;

import org.bukkit.Location;

import dev._2lstudios.hypercosmetics.utils.ProtocolUtils;

public class Trail {
    private final Particle effect;

    public Trail(final Particle effect) {
        this.effect = effect;
    }

    public Particle getEffect() {
        return effect;
    }

    public void spawnParticles(final Location location) throws InvocationTargetException {
        ProtocolUtils.spawnParticle(location, effect);
    }
}
