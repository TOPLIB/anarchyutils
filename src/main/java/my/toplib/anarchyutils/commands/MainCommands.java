package my.toplib.anarchyutils.commands;

import my.toplib.anarchyutils.AnarchyUtils;
import my.toplib.anarchyutils.ItemManager;
import my.toplib.anarchyutils.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender.hasPermission("anarchyutils.giveCMD"))) {
            sender.sendMessage(
                    Utils.color(AnarchyUtils.instance.getConfig().getString("Messages.no_permissions")));
            return true;
        }
        if (args.length != 2) {
            sender.sendMessage("Usage: /anarchy_utils <Trap-give|Plast-give> <Player>");
            return true;
        }
        Player player = Bukkit.getPlayer(args[1]);
        if (args[0].equalsIgnoreCase("Trap-give")) {
            if (player == null) { // player not online/invalid
                sender.sendMessage(Utils.color(AnarchyUtils.instance.getConfig().getString("Messages.player_offline")));
                return true;
            } else {
                player.getInventory().addItem(ItemManager.Trap);
                player.sendMessage(Utils.color(AnarchyUtils.instance.getConfig().getString("Messages.receive_item").replaceAll("%item%", ItemManager.Trap.getItemMeta().getDisplayName())));
                return true;
            }
        }
        else if (args[0].equalsIgnoreCase("Plast-give")) {
            if (player == null) { // player not online/invalid
                sender.sendMessage(Utils.color(AnarchyUtils.instance.getConfig().getString("Messages.player_offline")));
                return true;
            } else {
                player.getInventory().addItem(ItemManager.Plast);
                player.sendMessage(Utils.color(AnarchyUtils.instance.getConfig().getString("Messages.receive_item").replaceAll("%item%", ItemManager.Plast.getItemMeta().getDisplayName())));
                return true;
            }
        }
        return false;
    }
}