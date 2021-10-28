package dev._2lstudios.hypercosmetics.cosmetics.trails;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.comphenix.protocol.wrappers.EnumWrappers.Particle;

import org.bukkit.entity.Entity;

public class TrailsController implements Runnable {
    private Map<Entity, Trail> trailEntities = new HashMap<>();

    public void applyTrail(final Entity livingEntity, final Trail trail) {
        if (trail == null) {
            trailEntities.remove(livingEntity);
        } else {
            trailEntities.put(livingEntity, trail);
        }
    }

    public void applyTrail(final Entity livingEntity, final Particle effect) {
        applyTrail(livingEntity, new Trail(effect));
    }

    public void spawnTrails(final Entity livingEntity, final Trail trail) throws InvocationTargetException {
        trail.spawnParticles(livingEntity.getLocation());
    }

    public void spawnTrails(final Entity livingEntity) throws InvocationTargetException {
        if (trailEntities.containsKey(livingEntity)) {
            final Trail trail = trailEntities.get(livingEntity);

            spawnTrails(livingEntity, trail);
        }
    }

    public void spawnTrails() throws InvocationTargetException {
        final Iterator<Entry<Entity, Trail>> iterator = trailEntities.entrySet().iterator();

        while (iterator.hasNext()) {
            final Entry<Entity, Trail> entry = iterator.next();
            final Entity key = entry.getKey();
            final Trail value = entry.getValue();

            if (!key.isValid()) {
                iterator.remove();
            } else {
                spawnTrails(key, value);
            }
        }
    }

    @Override
    public void run() {
        try {
            spawnTrails();
        } catch (final InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Trail getTrail(final Entity livingEntity) {
        return trailEntities.getOrDefault(livingEntity, null);
    }
}
