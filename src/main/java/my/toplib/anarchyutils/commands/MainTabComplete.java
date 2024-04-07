package my.toplib.anarchyutils.commands;

import my.toplib.anarchyutils.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MainTabComplete implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {
        switch (args.length){
            case 1:
                if (sender.hasPermission("anarchyutils.giveCMD") && sender.hasPermission("anarchyutils.reload")) {
                    return List.of(
                            "reload",
                            "give",
                            "info"
                    );
                } else if (sender.hasPermission("anarchyutils.giveCMD")) {
                    return List.of(
                            "give",
                            "info"
                    );
                } else if(sender.hasPermission("anarchyutils.reload")){
                    return List.of(
                            "reload",
                            "info"
                    );
                } else {
                    return List.of(
                            "info"
                    );
                }
            case 2:
                if (args[0].equalsIgnoreCase("give")){
                    return ItemManager.totalItems;
                } else {
                    return null;
                }
            default:
                return null;
        }
    }
}
