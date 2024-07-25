package my.toplib.anarchyutils.action;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerAction implements Action{
    private final Player player;
    private final String command;

    public PlayerAction(Player player, String command) {
        this.player = player;
        this.command = command;
    }

    public Player getPlayer() {
        return player;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public void execute() {
        Bukkit.getServer().dispatchCommand(player, command);
    }
}
