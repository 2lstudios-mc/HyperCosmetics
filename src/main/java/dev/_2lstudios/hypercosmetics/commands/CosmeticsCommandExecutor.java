package dev._2lstudios.hypercosmetics.commands;

import com.comphenix.protocol.wrappers.EnumWrappers.Particle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;

import dev._2lstudios.hypercosmetics.cosmetics.trails.TrailsController;
import net.md_5.bungee.api.ChatColor;

public class CosmeticsCommandExecutor implements CommandExecutor {
    private final TrailsController trailsController;

    public CosmeticsCommandExecutor(final TrailsController trailsController) {
        this.trailsController = trailsController;
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String label,
            final String[] args) {
        if (args.length > 0) {
            if (sender instanceof LivingEntity) {
                final LivingEntity livingEntity = (LivingEntity) sender;
                final String particleName = args[0];
                final Particle effect = Particle.valueOf(particleName);

                trailsController.applyTrail(livingEntity, effect);
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aselected trail!"));
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cnot from console!"));
            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c/cosmetics <particle>"));
        }

        return true;
    }
}
