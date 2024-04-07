package my.toplib.anarchyutils.API;

import my.toplib.anarchyutils.AnarchyUtils;
import my.toplib.anarchyutils.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class api {



    public void spawnBox(Location loc, int timeBeforeClear){
        HashMap<Location, Material> blocks = new HashMap<>();
        loc.setY(loc.getY() - 1);

        Location point1 = loc.clone();
        point1.setX(point1.getX() - 2);
        point1.setZ(point1.getZ() - 2);

        Location point2 = loc.clone();
        point2.setX(point2.getX() + 2);
        point2.setZ(point2.getZ() + 2);
        point2.setY(point2.getY() + 4);

        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 3);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 2);
        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() - 3);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 3);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 2);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 2);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 2);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 2);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setY(loc.getY() + 4);
        loc.setZ(loc.getZ() - 2);
        loc.setX(loc.getX() + 2);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 3);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 2);
        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() - 3);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 3);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 2);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 2);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 2);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 2);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setY(loc.getY() - 1);
        loc.setZ(loc.getZ() - 4);
        loc.setX(loc.getX() + 4);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setY(loc.getY() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setY(loc.getY() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setY(loc.getY() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setY(loc.getY() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setY(loc.getY() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setY(loc.getY() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setY(loc.getY() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setY(loc.getY() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

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
            }
        }.runTaskLater(AnarchyUtils.instance, timeBeforeClear);
    }
    public void spawnPlast(Location loc, int timeBeforeClear) {
        HashMap<Location, Material> blocks = new HashMap<>();

        loc.setY(loc.getY() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 3);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 2);
        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() - 3);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 3);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());
        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());
        loc.setX(loc.getX() - 2);
        blocks.put(loc.clone(), loc.getBlock().getType());
        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 2);
        blocks.put(loc.clone(), loc.getBlock().getType());
        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());
        loc.setX(loc.getX() + 2);
        blocks.put(loc.clone(), loc.getBlock().getType());
        loc.setX(loc.getX() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());

        loc.setZ(loc.getZ() + 1);
        blocks.put(loc.clone(), loc.getBlock().getType());
        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());
        loc.setX(loc.getX() - 2);
        blocks.put(loc.clone(), loc.getBlock().getType());
        loc.setX(loc.getX() - 1);
        blocks.put(loc.clone(), loc.getBlock().getType());
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
            }
        }.runTaskLater(AnarchyUtils.instance, timeBeforeClear);
    }
    public void sendCMessage(String message, Player p){
        p.sendMessage(Utils.color(message));
    }
    public void broadcastMessage(@NotNull String message, @NotNull String prefix){
        AnarchyUtils.instance.getServer().broadcastMessage(Utils.color(prefix + message));
    }
    public scmParser getScmParser(){
        return new scmParser();
    }
}
