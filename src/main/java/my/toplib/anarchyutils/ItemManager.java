package my.toplib.anarchyutils;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {
    public static ItemStack Trap;
    public static ItemStack Plast;

    public static void init() {
        createTrap();
        createPlast();
    }

    private static void createTrap() {
        if(AnarchyUtils.instance.getConfig().getBoolean("Items.Trap.enabled")){
            Material cfgMaterial = Material.valueOf(AnarchyUtils.instance.getConfig().getString("Items.Plast.Material"));
            ItemStack item = new ItemStack(Material.NETHERITE_SCRAP, 1);
            ItemMeta meta = item.getItemMeta();
            //meta.setDisplayName("§6Трапка");
            meta.setDisplayName(AnarchyUtils.instance.getConfig().getString("Items.Trap.DisplayName")
                    .replaceAll("&", "§"));
            List<String> lore = new ArrayList();
            int iterator = 0;
            while(iterator < AnarchyUtils.instance.getConfig().getStringList("Items.Trap.Lore").size()){
                lore.add(AnarchyUtils.instance.getConfig().getStringList("Items.Trap.Lore").get(iterator).replaceAll("&","§"));
                iterator++;
            }
            meta.setLore(lore);
            item.setItemMeta(meta);
            Trap = item;
            if (AnarchyUtils.instance.getConfig().getBoolean("Items.Trap.Craft.enabled_craft")) {
                ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("trap"), item);
                sr.shape(new String[]{"BBB", "BSB", "BBB"});
                sr.setIngredient('B', Material.OBSIDIAN);
                sr.setIngredient('S', Material.NETHERITE_INGOT);
                Bukkit.getServer().addRecipe(sr);
            }
        }
        else{
            AnarchyUtils.instance.getLogger().warning("Trap is disabled in config skipping");
        }
    }

    private static void createPlast() {
        if(AnarchyUtils.instance.getConfig().getBoolean("Items.Plast.enabled")) {
            Material cfgMaterial = Material.valueOf(AnarchyUtils.instance.getConfig().getString("Items.Plast.Material"));
            ItemStack item = new ItemStack(cfgMaterial, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(AnarchyUtils.instance.getConfig().getString("Items.Plast.DisplayName")
                    .replaceAll("&", "§"));
            List<String> lore = new ArrayList();
            int iterator = 0;
            while(iterator < AnarchyUtils.instance.getConfig().getStringList("Items.Plast.Lore").size()){
                lore.add(AnarchyUtils.instance.getConfig().getStringList("Items.Plast.Lore")
                        .get(iterator).replaceAll("&","§"));
                iterator++;
            }
            meta.setLore(lore);
            item.setItemMeta(meta);
            Plast = item;
            if (AnarchyUtils.instance.getConfig().getBoolean("Items.Plast.Craft.enabled_craft")) {
                ShapedRecipe sre = new ShapedRecipe(NamespacedKey.minecraft("plast"), item);
                sre.shape(new String[]{"BBB", "BSB", "BBB"});
                sre.setIngredient('B', Material.OBSIDIAN);
                sre.setIngredient('S', Material.DIAMOND);
                Bukkit.getServer().addRecipe(sre);
            }
        }
        else{
            AnarchyUtils.instance.getLogger().warning("Plast is disabled in config skipping");
        }
    }
}