package dev._2lstudios.hypercosmetics.cosmetics.killeffects;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;

import dev._2lstudios.hypercosmetics.utils.BukkitUtil;

public class KillEffect {
    public static KillEffect BLOOD = new BloodKillEffect();

    private final String displayName;
    private final List<String> description;
    
    KillEffect(final String displayName, final List<String> description) {
        this.displayName = BukkitUtil.color(displayName);
        this.description = BukkitUtil.color(description);
    }

    public void run(final World world, final Location location) {
        // Override
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<String> getDescription() {
        return description;
    }
}
