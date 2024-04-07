package my.toplib.anarchyutils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemManager {
    public static HashMap<String, ItemStack> items = new HashMap<>();
    public static ItemStack trap;
    public static ItemStack plast;
    public static File scmSchematicsFolder;

    public static List<String> totalItems = new ArrayList<>();

    public static ItemStack getItem(String key){
        if(items.containsKey(key)){
            return items.get(key);
        }
        return null;
    }
    public static String addItem(String key, ItemStack item){
        if(!items.containsKey(key)){
            return "status-already_contains_key";
        } else if(items.containsValue(item)){
            return "status-already_contains_value";
        }
        items.put(key, item);
        return "status-successfully";
    }

    public static void clearItems() { items.clear(); }

    public static boolean containsItem(String key){ return items.containsKey(key); }

    public static Boolean itemEquals(ItemStack item){
        for (Map.Entry<String, ItemStack> entry : items.entrySet()) {
            ItemStack storedItem = entry.getValue();
            if (storedItem.isSimilar(item)) {
                return true;
            }
        }
        return false;
    }

    public static void takeItem(int takeAmount, Player player){
        for(Map.Entry<String, ItemStack> entry : items.entrySet()){
            if(player.getInventory().getItemInMainHand().isSimilar(entry.getValue())){
                if(player.getItemInHand().isSimilar(entry.getValue())){
                    player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - takeAmount);
                }
            } else if(player.getInventory().getItemInOffHand().isSimilar(entry.getValue())){
                player.getInventory().getItemInOffHand().setAmount(player.getInventory().getItemInOffHand().getAmount() - takeAmount);
            }
        }
    }
    public static void init(){
        createTrap();
        createPlast();
    }


    public static void reload() {
        clearItems();
        createTrap();
        createPlast();
    }

    public static String giveItemToPlayer(Player p, String item, int amount){
        for (int i = 0; i < p.getInventory().getSize(); i++) {
            ItemStack slotItem = p.getInventory().getItem(i);
            if (slotItem == null) {
                ItemStack newItem = getItem(item);
                newItem.setAmount(amount);
                p.getInventory().addItem(newItem);
                return "success";
            }
        };
        return "error";
    }

    private static void createTrap() {
        ItemStack item = new ItemStack( Material.valueOf(AnarchyUtils.instance.getConfig().getString("Items.Trap.Material")) , 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(AnarchyUtils.instance.getConfig().getString("Items.Trap.DisplayName")
                .replaceAll("&", "§"));
        ArrayList lore = new ArrayList();
        for(int i = 0; i < AnarchyUtils.instance.getConfig().getStringList("Items.Trap.Lore").size(); i++){
            lore.add(AnarchyUtils.instance.getConfig().getStringList("Items.Trap.Lore").get(i).replaceAll("&","§"));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        items.put("trap".toLowerCase(), item);
        totalItems.add("trap");
        trap = item;
    }

    private static void createPlast() {
        ItemStack item = new ItemStack( Material.valueOf(AnarchyUtils.instance.getConfig().getString("Items.Plast.Material")) , 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(AnarchyUtils.instance.getConfig().getString("Items.Plast.DisplayName")
                .replaceAll("&", "§"));
        ArrayList lore = new ArrayList();
        for(int i = 0; i < AnarchyUtils.instance.getConfig().getStringList("Items.Plast.Lore").size(); i++){
            lore.add(AnarchyUtils.instance.getConfig().getStringList("Items.Plast.Lore").get(i).replaceAll("&","§"));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        items.put("plast".toLowerCase(), item);
        totalItems.add("plast");
        plast = item;
    }
}