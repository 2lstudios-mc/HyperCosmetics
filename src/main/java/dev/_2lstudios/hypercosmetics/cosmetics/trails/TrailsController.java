package dev._2lstudios.hypercosmetics.cosmetics.trails;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Particle;
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

    public void applyTrail(final LivingEntity livingEntity, final Particle particle) {
        applyTrail(livingEntity, new Trail(particle));
    }

    public void spawnTrails(final LivingEntity livingEntity, final Trail trail) {
        trail.spawnParticles(livingEntity.getLocation());
    }

    public void spawnTrails(final LivingEntity livingEntity) {
        if (trailEntities.containsKey(livingEntity)) {
            final Trail trail = trailEntities.get(livingEntity);

            spawnTrails(livingEntity, trail);
        }
    }

    public void spawnTrails() {
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

        for (final Entry<LivingEntity, Trail> entry : trailEntities.entrySet()) {
            spawnTrails(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void run() {
        spawnTrails();
    }
}
