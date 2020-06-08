package me.aerobyte.potions.commands;

import me.aerobyte.potions.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LolCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(Utils.chat("&cOnly players may execute this command"));
            return true;
        }

        Player player = (Player) commandSender;
        player.sendMessage(Utils.chat("&cAerobyte <3"));
        return true;

    }
}
