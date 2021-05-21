package dev._2lstudios.hypercosmetics.cosmetics.killeffects;

import java.util.Arrays;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public class SlimeKillEffect extends KillEffect {
    SlimeKillEffect() {
        super("&aSlime", Arrays.asList(new String[] { "" }));
    }

    @Override
    public void run(World world, Location location) {
        world.playEffect(location.add(0.0D, 0.85D, 0.0D), Effect.STEP_SOUND, Material.SLIME_BLOCK);
    }
}
