package me.aerobyte.potions;

import me.aerobyte.potions.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main plugin;

    public void onEnable() {
        plugin = this;
        getCommand("all").setExecutor(new PotionsCommand());
        getCommand("invis").setExecutor(new InvisCommand());
        getCommand("fr").setExecutor(new FireCommand());
        getCommand("sp").setExecutor(new SpeedCommand());
        getCommand("lol").setExecutor(new LolCommand());
        getCommand("nv").setExecutor(new NightCommand());
    }

    public static Main getPlugin() {
        return plugin;
    }

}