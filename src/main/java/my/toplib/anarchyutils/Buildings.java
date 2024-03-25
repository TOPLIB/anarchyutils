package my.toplib.anarchyutils;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.flags.RegionGroupFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedCuboidRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import my.toplib.anarchyutils.utils.Utils;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Buildings {
    public static HashMap<UUID, Integer> cooldown = new HashMap<>();

    public static boolean createPlast(Player player) {

        HashMap<Location, Material> blocks = new HashMap<>();

        Location location1 = player.getLocation();

        location1.setY(location1.getY() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 3);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 2);
        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() - 3);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 3);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());
        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());
        location1.setX(location1.getX() - 2);
        blocks.put(location1.clone(), location1.getBlock().getType());
        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 2);
        blocks.put(location1.clone(), location1.getBlock().getType());
        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());
        location1.setX(location1.getX() + 2);
        blocks.put(location1.clone(), location1.getBlock().getType());
        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());
        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());
        location1.setX(location1.getX() - 2);
        blocks.put(location1.clone(), location1.getBlock().getType());
        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        for (Map.Entry<Location, Material> entry : blocks.entrySet()) {
            entry.getKey().getBlock().setType(Material.OBSIDIAN);
        }
        cooldown.put(player.getUniqueId(), 1);
        player.sendMessage(Utils.color(AnarchyUtils.instance.getConfig().getString("Messages.player_setPlast"))
                .replaceAll("%player%", player.getName()));
        AnarchyUtils.instance.getLogger().info(Utils.color(AnarchyUtils.instance.getConfig().getString("Messages.player_setPlastLog"))
                .replaceAll("%player%", player.getName())
                .replaceAll("%location_x%", String.valueOf(player.getLocation().getX()))
                .replaceAll("%location_y%", String.valueOf(player.getLocation().getY()))
                .replaceAll("%location_z%", String.valueOf(player.getLocation().getZ())));
        if (ItemManager.itemEquals(player.getInventory().getItemInMainHand())) {
            player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() -1 );
        } else if(ItemManager.itemEquals(player.getInventory().getItemInOffHand())) {
            player.getInventory().getItemInOffHand().setAmount(player.getInventory().getItemInOffHand().getAmount() -1 );
        }
        new BukkitRunnable() {

            @Override
            public void run() {
                for (Map.Entry<Location, Material> entry : blocks.entrySet()) {
                    entry.getKey().getBlock().setType(entry.getValue());
                }
                blocks.clear();
                cooldown.remove(player.getUniqueId());
                player.sendMessage(Utils.color(AnarchyUtils.instance.getConfig().getString("Messages.player_plastDisable")).replaceAll("%player%", player.getName()));
            }
        }.runTaskLater(AnarchyUtils.instance, AnarchyUtils.instance.getConfig().getInt("Items.Plast.despawn_delay"));
        return true;
    }

    public static boolean createBox(Player player) {

        HashMap<Location, Material> blocks = new HashMap<>();
        Location location1 = player.getLocation();
        location1.setY(location1.getY() - 1);

        Location point1 = location1.clone();
        point1.setX(point1.getX() - 2);
        point1.setZ(point1.getZ() - 2);

        Location point2 = location1.clone();
        point2.setX(point2.getX() + 2);
        point2.setZ(point2.getZ() + 2);
        point2.setY(point2.getY() + 4);

        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 3);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 2);
        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() - 3);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 3);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 2);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 2);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 2);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 2);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setY(location1.getY() + 4);
        location1.setZ(location1.getZ() - 2);
        location1.setX(location1.getX() + 2);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 3);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 2);
        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() - 3);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 3);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 2);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 2);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 2);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 2);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setY(location1.getY() - 1);
        location1.setZ(location1.getZ() - 4);
        location1.setX(location1.getX() + 4);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setY(location1.getY() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setY(location1.getY() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setY(location1.getY() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setY(location1.getY() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setY(location1.getY() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setY(location1.getY() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setX(location1.getX() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setY(location1.getY() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setY(location1.getY() + 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        location1.setZ(location1.getZ() - 1);
        blocks.put(location1.clone(), location1.getBlock().getType());

        for (Map.Entry<Location, Material> entry : blocks.entrySet()) {
            entry.getKey().getBlock().setType(Material.OBSIDIAN);
        }

        String id = String.valueOf(UUID.randomUUID());
        player.sendMessage(Utils.color(AnarchyUtils.instance.getConfig().getString("Messages.player_setTrap")).replaceAll("%player%", player.getName()));
        AnarchyUtils.instance.getLogger().info(Utils.color(AnarchyUtils.instance.getConfig().getString("Messages.player_setTrapLog"))
                .replaceAll("%player%", player.getName())
                .replaceAll("%location_x%", String.valueOf(player.getLocation().getX()))
                .replaceAll("%location_y%", String.valueOf(player.getLocation().getY()))
                .replaceAll("%location_z%", String.valueOf(player.getLocation().getZ())));
        if (ItemManager.itemEquals(player.getInventory().getItemInMainHand())) {
            player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() -1 );
        } else if(ItemManager.itemEquals(player.getInventory().getItemInOffHand())) {
            player.getInventory().getItemInOffHand().setAmount(player.getInventory().getItemInOffHand().getAmount() -1 );
        }
        cooldown.put(player.getUniqueId(), 1);

        new BukkitRunnable() {

            @Override
            public void run() {
                for (Map.Entry<Location, Material> entry : blocks.entrySet()) {
                    entry.getKey().getBlock().setType(entry.getValue());
                }
                blocks.clear();
                cooldown.remove(player.getUniqueId());
                player.sendMessage(Utils.color(AnarchyUtils.instance.getConfig().getString("Messages.player_TrapDisable")).replaceAll("%player%", player.getName()));
            }
        }.runTaskLater(AnarchyUtils.instance, AnarchyUtils.instance.getConfig().getInt("Items.Trap.despawn_delay"));
        return true;
    }
}
