package my.toplib.anarchyutils;

import my.toplib.anarchyutils.commands.MainCommands;
import my.toplib.anarchyutils.commands.MainTabComplete;
import my.toplib.anarchyutils.configs.Messages;
import my.toplib.anarchyutils.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;


public final class AnarchyUtils extends JavaPlugin {


    public static AnarchyUtils instance;
    @Override
    public void onEnable() {
        instance = this;
        Messages.initMessages();
        saveDefaultConfig();
        ItemManager.init();
        try {
            File messages = Files.copy(getResource("messages.yml"), new File(getDataFolder(), "messages.yml").toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Bukkit.getLogger().info(" ");
        Bukkit.getLogger().info("             | ");
        Bukkit.getLogger().info("AnarchyUtils | AnarchyUtils - Version: " + getDescription().getVersion());
        Bukkit.getLogger().info("             | ");
        Bukkit.getLogger().info(" ");
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
