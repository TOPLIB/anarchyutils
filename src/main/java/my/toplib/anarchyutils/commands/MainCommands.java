package my.toplib.anarchyutils.commands;

import my.toplib.anarchyutils.AnarchyUtils;
import my.toplib.anarchyutils.ItemManager;
import my.toplib.anarchyutils.configs.Messages;
import my.toplib.anarchyutils.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class MainCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            return false;
        }
        switch (args[0].toLowerCase()) {
            case "reload":
                if(sender.hasPermission("anarchyutils.reload")){
                    AnarchyUtils.instance.saveDefaultConfig();
                    AnarchyUtils.instance.reloadConfig();
                    ItemManager.reload();
                    Messages.reloadConfig();
                    sender.sendMessage(Utils.color(Messages.get().getString("reload")));
                    return true;
                } else {
                    sender.sendMessage(Utils.color(Messages.get().getString("no_permissions")));
                    return true;
                }
            case "info":
                sender.sendMessage("§9Anarchy Utils §fversion §6" + AnarchyUtils.instance.getDescription().getVersion());
                return true;
            case "give":
                if(sender.hasPermission("anarchyutils.giveCMD")) {
                    if(args.length == 1){
                        return false;
                    } else if(args.length == 2) {
                        if (!ItemManager.containsItem(args[1].toLowerCase())) {
                            sender.sendMessage(Utils.color(Messages.get().getString("itemNotFounded").replaceAll("%item%", args[1].toLowerCase())));
                            return true;
                        }
                    } else if (args.length == 3) {
                        Player p = Bukkit.getPlayer(args[2]);
                        if (p == null){
                            sender.sendMessage(Utils.color(Messages.get().getString("player_offline")));
                            return true;
                        }
                        if (!ItemManager.containsItem(args[1].toLowerCase())) {
                            p.sendMessage(Utils.color(Messages.get().getString("itemNotFounded").replaceAll("%item%", args[1].toLowerCase())));
                            return true;
                        }
                        switch (ItemManager.giveItemToPlayer(p, args[1].toLowerCase(), 1)){
                            case "success":
                                p.sendMessage(Utils.color(Messages.get().getString("receive_item").replaceAll("%item%", ItemManager.getItem(args[1].toLowerCase()).getItemMeta().getDisplayName())));
                                return true;
                            case "error":
                                p.sendMessage(Utils.color(Messages.get().getString("noEnoughSpace")));
                                return true;
                            default:
                                p.sendMessage(Utils.color(Messages.get().getString("error")));
                                return true;
                        }
                    }
                } else {
                    sender.sendMessage(Utils.color(Messages.get().getString("no_permissions")));
                    return true;
                }
            default:
                return false;
        }
    }
}
//p.getInventory().addItem(ItemManager.Plast);