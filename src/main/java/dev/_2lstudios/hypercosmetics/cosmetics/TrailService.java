package dev._2lstudios.hypercosmetics.cosmetics;

import java.util.HashMap;
import java.util.Map;

public class TrailService {
    private Map<String, Trail> trails = new HashMap<>();

    public Trail getTrail(final String trailName) {
        return trails.getOrDefault(trailName, null);
    }
}
