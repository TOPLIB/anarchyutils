package my.toplib.anarchyutils.action;

import org.bukkit.entity.Player;

public class MessageAction implements Action{
    private final Player player;
    private final String message;

    public MessageAction(Player player, String message) {
        this.player = player;
        this.message = message;
    }

    public Player getPlayer() {
        return player;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public void execute() {
        player.sendMessage(message);
    }
}
