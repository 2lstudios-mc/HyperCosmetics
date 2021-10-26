package dev._2lstudios.hypercosmetics.cosmetics.trails;

import java.util.HashMap;
import java.util.Map;

public class TrailsService {
    private Map<String, Trail> trails = new HashMap<>();

    public Trail getTrail(final String trailName) {
        return trails.getOrDefault(trailName, null);
    }
}
