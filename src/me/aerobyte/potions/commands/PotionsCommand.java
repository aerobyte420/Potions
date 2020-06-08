package me.aerobyte.potions.commands;

import me.aerobyte.potions.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage(Utils.chat("&cOnly players may execute this command"));
            return true;
        }
        Player player = (Player) commandSender;
        if (player.hasPermission("potions.all")) {
            if (player.hasPotionEffect(PotionEffectType.INVISIBILITY) &&  player.hasPotionEffect(PotionEffectType.SPEED) && player.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE) && player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                player.removePotionEffect(PotionEffectType.INVISIBILITY);
                player.removePotionEffect(PotionEffectType.SPEED);
                player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                player.sendMessage(Utils.chat("&6» &eYou have &cdisabled &eall potion effects"));
                player.sendMessage(Utils.chat("    &7&m(&b&mSpeed II&f&m, &6&mFire Resistance II&f&m, Invisibility II, &9&mNight Vision II&7&m)"));
                return true;
            }
            player.sendMessage(Utils.chat("&6» &eYou have &aenabled &eall potion effects"));
            player.sendMessage(Utils.chat("    &7(&bSpeed II&f, &6Fire Resistance II&f, Invisibility II, &9Night Vision II&7)"));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999999, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999999, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 99999999, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 99999999, 1));
            return true;
        } else {
            player.sendMessage(Utils.chat("&cNo permission"));
            return false;
        }
    }
}