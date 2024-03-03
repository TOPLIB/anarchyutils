package my.toplib.anarchyutils;

import com.google.common.base.Objects;
import my.toplib.anarchyutils.utils.Utils;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class EventHandler implements Listener {

    @org.bukkit.event.EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getItem() == null) return;

        if (e.getItem().getType() == Material.valueOf(AnarchyUtils.instance.getConfig().getString("Items.Plast.Material")) &&
                e.getItem().getItemMeta().equals(ItemManager.Plast.getItemMeta())) {
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                e.setCancelled(true);
                if(AnarchyUtils.instance.getConfig().getBoolean("Items.Plast.enabled")){
                    Buildings.createPlast(e.getPlayer());
                    e.getPlayer().sendMessage(Utils.color(AnarchyUtils.instance.getConfig().getString("Messages.player_setPlast"))
                            .replaceAll("%player%", e.getPlayer().getName()));
                    AnarchyUtils.instance.getLogger().info(Utils.color(AnarchyUtils.instance.getConfig().getString("Messages.player_setPlastLog"))
                            .replaceAll("%player%", e.getPlayer().getName())
                            .replaceAll("%location_x%", String.valueOf(e.getPlayer().getLocation().getX()))
                            .replaceAll("%location_y%", String.valueOf(e.getPlayer().getLocation().getY()))
                            .replaceAll("%location_z%", String.valueOf(e.getPlayer().getLocation().getZ())));
                    if (e.getPlayer().getInventory().getItemInMainHand().isSimilar(ItemManager.Plast)) {
                        e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() -1 );
                    } else if(e.getPlayer().getInventory().getItemInOffHand().isSimilar(ItemManager.Plast)) {
                        e.getPlayer().getInventory().getItemInOffHand().setAmount(e.getPlayer().getInventory().getItemInOffHand().getAmount() -1 );
                    }
                }
            }
        }

        if (e.getItem().getType() == Material.valueOf(AnarchyUtils.instance.getConfig().getString("Items.Trap.Material")) && e.getItem().getItemMeta().equals(ItemManager.Trap.getItemMeta())) {
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                e.setCancelled(true);
                if(AnarchyUtils.instance.getConfig().getBoolean("Items.Trap.enabled")){
                    Buildings.createBox(e.getPlayer());
                    e.getPlayer().sendMessage(Utils.color(AnarchyUtils.instance.getConfig().getString("Messages.player_setTrap")).replaceAll("%player%", e.getPlayer().getName()));
                    AnarchyUtils.instance.getLogger().info(Utils.color(AnarchyUtils.instance.getConfig().getString("Messages.player_setTrapLog"))
                            .replaceAll("%player%", e.getPlayer().getName())
                            .replaceAll("%location_x%", String.valueOf(e.getPlayer().getLocation().getX()))
                            .replaceAll("%location_y%", String.valueOf(e.getPlayer().getLocation().getY()))
                            .replaceAll("%location_z%", String.valueOf(e.getPlayer().getLocation().getZ())));
                    if (e.getPlayer().getInventory().getItemInMainHand().isSimilar(ItemManager.Trap)) {
                        e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() -1 );
                    } else if(e.getPlayer().getInventory().getItemInOffHand().isSimilar(ItemManager.Trap)) {
                        e.getPlayer().getInventory().getItemInOffHand().setAmount(e.getPlayer().getInventory().getItemInOffHand().getAmount() -1 );
                    }
                }
            }
        }
    }
}


