package dev._2lstudios.hypercosmetics.cosmetics.trails;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.comphenix.protocol.wrappers.EnumWrappers;

import org.bukkit.entity.LivingEntity;

public class TrailsController implements Runnable {
    private Map<LivingEntity, Trail> trailEntities = new HashMap<>();

    public void applyTrail(final LivingEntity livingEntity, final Trail trail) {
        if (trail == null) {
            trailEntities.remove(livingEntity);
        } else {
            trailEntities.put(livingEntity, trail);
        }
    }

    public void applyTrail(final LivingEntity livingEntity, final EnumWrappers.Particle effect) {
        applyTrail(livingEntity, new Trail(effect));
    }

    public void spawnTrails(final LivingEntity livingEntity, final Trail trail) throws InvocationTargetException {
        trail.spawnParticles(livingEntity.getLocation());
    }

    public void spawnTrails(final LivingEntity livingEntity) throws InvocationTargetException {
        if (trailEntities.containsKey(livingEntity)) {
            final Trail trail = trailEntities.get(livingEntity);

            spawnTrails(livingEntity, trail);
        }
    }

    public void spawnTrails() throws InvocationTargetException {
        final Iterator<Entry<LivingEntity, Trail>> iterator = trailEntities.entrySet().iterator();

        while (iterator.hasNext()) {
            final Entry<LivingEntity, Trail> entry = iterator.next();
            final LivingEntity key = entry.getKey();
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
}
