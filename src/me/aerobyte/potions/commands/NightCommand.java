package me.aerobyte.potions.commands;

import me.aerobyte.potions.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(Utils.chat("&cOnly players may execute this command"));
            return true;
        }
        Player player = (Player) commandSender;

        if (player.hasPermission("potions.nv")) {
            if (player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                player.sendMessage(Utils.chat("&6» &eYour night vision has been &cdisabled&e."));
                return true;
            }
            player.sendMessage(Utils.chat("&6» &eYour night vision has been &aenabled&e."));
            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 99999999, 1));
            return true;
        } else {
            player.sendMessage(Utils.chat("&cNo permission"));
            return false;
        }
    }
}