package dev._2lstudios.hypercosmetics.utils;

import java.util.List;

import org.bukkit.ChatColor;

public class BukkitUtil {
    public static String color(final String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static List<String> color(final List<String> stringList) {
        for (int i = 0; i < stringList.size(); i++) {
            stringList.set(i, ChatColor.translateAlternateColorCodes('&', stringList.get(i)));
        }

        return stringList;
    }
}
