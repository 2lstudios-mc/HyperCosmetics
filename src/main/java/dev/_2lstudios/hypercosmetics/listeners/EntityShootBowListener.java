package dev._2lstudios.hypercosmetics.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

import dev._2lstudios.hypercosmetics.cosmetics.trails.Trail;
import dev._2lstudios.hypercosmetics.cosmetics.trails.TrailsController;

public class EntityShootBowListener implements Listener {
    private final TrailsController trailsController;

    public EntityShootBowListener(final TrailsController trailsController) {
        this.trailsController = trailsController;
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerShoot(final EntityShootBowEvent event) {
        final LivingEntity livingEntity = event.getEntity();

        if (livingEntity instanceof Player) {
            final Entity projectile = event.getProjectile();
            final Trail trail = trailsController.getTrail(livingEntity);

            if (trail != null) {
                trailsController.applyTrail(projectile, trail);
            }
        }
    }
}
