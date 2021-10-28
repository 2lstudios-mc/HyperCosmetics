package dev._2lstudios.hypercosmetics.utils;

import java.lang.reflect.InvocationTargetException;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers.Particle;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class ProtocolUtils {
    public static void spawnParticle(final Vector location, final Particle particle, final double radius) throws InvocationTargetException {
        final ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();
        final float x;
        final float y;
        final float z;

        if (radius > 0) {
            x = (float) (location.getX() + (Math.random() - 0.5) * (radius * 2));
            y = (float) (location.getY() + (Math.random() - 0.5) * (radius * 2));
            z = (float) (location.getZ() + (Math.random() - 0.5) * (radius * 2));
        } else {
            x = (float) location.getX();
            y = (float) location.getY();
            z = (float) location.getZ();
        }

        final PacketContainer packet = protocolManager.createPacket(PacketType.Play.Server.WORLD_PARTICLES);

        packet.getParticles().write(0, particle);
        packet.getFloat().write(0, x).write(1, y).write(2, z);

        for (final Player player : Bukkit.getOnlinePlayers()) {
            protocolManager.sendServerPacket(player, packet);
        }
    }

    public static void spawnParticle(final Location location, final Particle particle, final double radius) throws InvocationTargetException {
        spawnParticle(location.toVector(), particle, radius);
    }

    public static void spawnParticle(final Location location, final Particle particle) throws InvocationTargetException {
        spawnParticle(location, particle, 0);
    }
}
