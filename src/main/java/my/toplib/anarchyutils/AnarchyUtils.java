package my.toplib.anarchyutils;

import my.toplib.anarchyutils.commands.MainCommands;
import my.toplib.anarchyutils.commands.MainTabComplete;
import my.toplib.anarchyutils.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;


public final class AnarchyUtils extends JavaPlugin {

    public static AnarchyUtils instance;
    @Override
    public void onEnable() {
        Bukkit.getLogger().info(" ");
        Bukkit.getLogger().info("AnarchyUtils | --------------------------");
        Bukkit.getLogger().info("AnarchyUtils | AnarchyUtils - Version: " + getDescription().getVersion());
        Bukkit.getLogger().info("AnarchyUtils | --------------------------");
        Bukkit.getLogger().info(" ");
        saveDefaultConfig();
        instance = this;
        ItemManager.init();
        getServer().getPluginManager().registerEvents(new Events(), this);
        getCommand("anarchy_utils").setExecutor(new MainCommands());
        getCommand("anarchy_utils").setTabCompleter(new MainTabComplete());
        Bukkit.getLogger().info("AnarchyUtils | Plugin has been successfully enabled!");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(Utils.color("AnarchyUtils | Plugin has been successfully disabled!"));
    }
}
