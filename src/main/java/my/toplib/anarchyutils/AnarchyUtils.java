package my.toplib.anarchyutils;

import my.toplib.anarchyutils.commands.MainCommands;
import my.toplib.anarchyutils.commands.Reload;
import my.toplib.anarchyutils.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AnarchyUtils extends JavaPlugin {

    public static AnarchyUtils instance;
    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getLogger().info("Checking items in config!");
        if (!getConfig().getBoolean("Items.Trap.enabled") && !getConfig().getBoolean("Items.Plast.enabled")) {
            getLogger().warning("==============================================================");
            getLogger().warning("");
            getLogger().warning("Why did you install the plugin when you disabled all elements?");
            getLogger().warning("AnarchyUtils is disabled to improve performance");
            getLogger().warning("");
            getLogger().warning("==============================================================");
            getServer().getPluginManager().disablePlugin(this);
        }
        else {
            getLogger().info("Everything is fine, I continue to launch");
        }
        instance = this;
        ItemManager.init();
        getServer().getPluginManager().registerEvents(new EventHandler(), this);
        getCommand("anarchy_utils").setExecutor(new MainCommands());
        getCommand("anarchy_utils-reload").setExecutor(new Reload());
        Bukkit.getLogger().info(Utils.color("&7[&6AnarchyUtils&7]&r Plugin has been successfully enabled!"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Removing custom recipes!");
        try {
            Bukkit.resetRecipes();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Bukkit.getLogger().info(Utils.color("&7[&6AnarchyUtils&7]&r Plugin has been successfully disabled!"));
    }
}
