package my.toplib.anarchyutils;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedCuboidRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import my.toplib.anarchyutils.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Buildings {

    public static void createPlast(Player player) {

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

        new BukkitRunnable() {

            @Override
            public void run() {
                for (Map.Entry<Location, Material> entry : blocks.entrySet()) {
                    entry.getKey().getBlock().setType(entry.getValue());
                }
                blocks.clear();
                player.sendMessage(Utils.color(AnarchyUtils.instance.getConfig().getString("Messages.player_plastDisable")).replaceAll("%player%", player.getName()));
            }
        }.runTaskLater(AnarchyUtils.instance, AnarchyUtils.instance.getConfig().getInt("Items.Plast.despawn_delay"));
    }

    public static void createBox(Player player) {

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
        RegionContainer rgc = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionManager rgm = rgc.get(BukkitAdapter.adapt(player.getWorld()));

        ProtectedCuboidRegion region = new ProtectedCuboidRegion(id, BukkitAdapter.asBlockVector(point1), BukkitAdapter.asBlockVector(point2));
        rgm.addRegion(region);

        new BukkitRunnable() {

            @Override
            public void run() {
                for (Map.Entry<Location, Material> entry : blocks.entrySet()) {
                    entry.getKey().getBlock().setType(entry.getValue());
                }
                rgm.removeRegion(id);
                blocks.clear();
                player.sendMessage(Utils.color(AnarchyUtils.instance.getConfig().getString("Messages.player_TrapDisable")).replaceAll("%player%", player.getName()));
            }
        }.runTaskLater(AnarchyUtils.instance, AnarchyUtils.instance.getConfig().getInt("Items.Trap.despawn_delay"));
    }
}
