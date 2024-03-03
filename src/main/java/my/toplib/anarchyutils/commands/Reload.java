package my.toplib.anarchyutils.commands;

import my.toplib.anarchyutils.AnarchyUtils;
import my.toplib.anarchyutils.ItemManager;
import my.toplib.anarchyutils.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Reload implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(sender.hasPermission("anarchyutils.reload")) {
            AnarchyUtils.instance.reloadConfig();
            try {
                Bukkit.resetRecipes();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            ItemManager.init();
            sender.sendMessage(Utils.color(AnarchyUtils.instance.getConfig().getString("Messages.reload")));
            return true;
        } else {
            sender.sendMessage(Utils.color(AnarchyUtils.instance.getConfig().getString("Messages.no_permissions")));
        }
        return true;
    }
}
