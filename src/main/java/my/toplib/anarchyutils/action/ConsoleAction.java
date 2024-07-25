package my.toplib.anarchyutils.action;

import org.bukkit.Bukkit;

public class ConsoleAction implements Action{

    private final String command;

    public ConsoleAction(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public void execute() {
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command);
    }
}
