package my.toplib.anarchyutils;

import my.toplib.anarchyutils.utils.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;
import java.net.URISyntaxException;

public class Events implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getItem() == null) return;

        if (ItemManager.items.get("plast").isSimilar(e.getItem())) {
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if(Buildings.cooldown.containsKey(e.getPlayer().getUniqueId())) return;
                e.setCancelled(true);
                Buildings.createPlast(e.getPlayer());
            }
        } else if (ItemManager.items.get("trap").isSimilar(e.getItem())) {
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if(Buildings.cooldown.containsKey(e.getPlayer().getUniqueId())) return;
                e.setCancelled(true);
                Buildings.createBox(e.getPlayer());
            }
        }
    }
    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent e) throws URISyntaxException, IOException, InterruptedException {
        if(e.getPlayer().hasPermission("anarchyutils.updateCheck")){
            Utils.checkUpdate(e.getPlayer());
        }
    }
}


