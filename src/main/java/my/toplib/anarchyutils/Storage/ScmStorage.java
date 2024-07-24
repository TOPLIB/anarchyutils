package my.toplib.anarchyutils.Storage;

import my.toplib.anarchyutils.AnarchyUtils;
import my.toplib.anarchyutils.utils.BPos;
import my.toplib.anarchyutils.utils.Vector3;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScmStorage {
    public static List<BPos> parseFile(File file) {
        List<BPos> result = new ArrayList<>();
        int lineId = 1;
        boolean fileHasError = false;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty() || line.startsWith("#")) {
                    lineId++;
                    continue;
                }

                String[] lineParts = line.split(";", 2);
                if (lineParts.length < 2) {
                    AnarchyUtils.instance.getLogger().warning("Error while parsing: " + file.getName() + ", Invalid syntax: Need 2 arguments. Line: " + lineId);
                    fileHasError = true;
                } else if(lineParts.length > 2){
                    AnarchyUtils.instance.getLogger().info("Error while parsing: " + file.getName() + ", Invalid syntax: Need 2 arguments. Line: " + lineId);
                    fileHasError = true;
                }
                if(!fileHasError) {
                    int x = Integer.parseInt(lineParts[1].split(":")[0]);
                    int y = Integer.parseInt(lineParts[1].split(":")[1]);
                    int z = Integer.parseInt(lineParts[1].split(":")[2]);
                    BPos bPos = new BPos(Material.valueOf(lineParts[0]), new Vector3(x, y, z));
                    result.add(bPos);
                }
                lineId++;
            }
        } catch (FileNotFoundException e) {
            AnarchyUtils.instance.getLogger().warning("File not found: " + file.getAbsolutePath());
        }

        if (fileHasError) {
            return null;
        }

        return result;
    }

    public static void writeLineInSCMFile(File file, BPos bPos){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(bPos.getBlock().name() +
                    ";" + bPos.getPosition().getX() +
                    ":" + bPos.getPosition().getY() +
                    ":" + bPos.getPosition().getZ());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            AnarchyUtils.instance.getLogger().warning("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void init(){
        ConfigurationSection shematics = AnarchyUtils.instance.getConfig().getConfigurationSection("Schematics");
        for (String key : shematics.getKeys(false)) {
            ConfigurationSection schematic = shematics.getConfigurationSection(key);
            if(new File(AnarchyUtils.instance.getDataFolder(), schematic.getString("file")).exists()){
                System.out.println("YESSSSSSSSSSSSSSSSSSS");
            } else {
                System.out.println("noo");
            }
        }
    }

}
