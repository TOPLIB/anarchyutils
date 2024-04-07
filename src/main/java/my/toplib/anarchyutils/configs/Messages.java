package my.toplib.anarchyutils.configs;

import my.toplib.anarchyutils.AnarchyUtils;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Messages {

    private static File messagesFile;
    private static YamlConfiguration messagesConfig;

    public static void initMessages() {
        if (!AnarchyUtils.instance.getDataFolder().exists()) AnarchyUtils.instance.getDataFolder().mkdir();
        messagesFile = new File(AnarchyUtils.instance.getDataFolder(), "messages.yml");
        messagesConfig = YamlConfiguration.loadConfiguration(messagesFile);
        if(!messagesFile.exists()){
            try {
                messagesFile.createNewFile();
                messagesConfig.set("player_setPlast", "&fYou &6%player% &fplaced the &6Plast&f!");
                messagesConfig.set("player_setPlastLog", "&fPlayer &6%player% &fplaced the &6Plast&f on Location: &6X: %location_x% Y: %location_y% Z: %location_z%");
                messagesConfig.set("player_plastDisable", "&fYour &6Plast&f has been disabled Player &6%player%");
                messagesConfig.set("player_setTrap", "&fYou &6%player% &fplaced the &6Trap&f!");
                messagesConfig.set("player_setTrapLog", "&fPlayer &6%player% &fplaced the &6Trap&f on Location: &6X: %location_x% Y: %location_y% Z: %location_z%");
                messagesConfig.set("player_TrapDisable", "&fYour &6Trap&f has been disabled Player &6%player%");
                messagesConfig.set("receive_item", "&fYou receive item: &6%item%");
                messagesConfig.set("player_offline", "&cPlayer offline");
                messagesConfig.set("no_permissions", "&cYou don't have permission to do this!");
                messagesConfig.set("reload", "&aPlugin reloaded");
                messagesConfig.set("cooldown", "&cError please wait before using this item again.");
                messagesConfig.set("error", "&cERROR! Please contact with administrator.");
                messagesConfig.set("itemNotFound", "&c%item% doesn't exists!");
                messagesConfig.set("noEnoughSpace", "&cYou don't have enough space to get item!");
                messagesConfig.save(messagesFile);

                messagesFile = new File(AnarchyUtils.instance.getDataFolder(), "messages.yml");
                messagesConfig = YamlConfiguration.loadConfiguration(messagesFile);
            } catch (IOException e){
                throw new RuntimeException(e);
            }
        }

    }

    public static YamlConfiguration get(){
        return messagesConfig;
    }

    public static void reloadConfig(){
        initMessages();
    }
}
