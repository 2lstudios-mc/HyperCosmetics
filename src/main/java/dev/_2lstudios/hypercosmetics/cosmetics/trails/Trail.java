package dev._2lstudios.hypercosmetics.cosmetics.trails;

import java.lang.reflect.InvocationTargetException;

import com.comphenix.protocol.wrappers.EnumWrappers;

import dev._2lstudios.hypercosmetics.utils.ProtocolUtils;

import org.bukkit.Location;

public class Trail {
    private final EnumWrappers.Particle effect;

    public Trail(final EnumWrappers.Particle effect) {
        this.effect = effect;
    }

    public EnumWrappers.Particle getEffect() {
        return effect;
    }

    public void spawnParticles(final Location location) throws InvocationTargetException {
        ProtocolUtils.spawnParticle(location);
    }
}
