package my.toplib.anarchyutils.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import my.toplib.anarchyutils.AnarchyUtils;
import org.bukkit.ChatColor;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Utils {
    public static String color(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void checkUpdate(Player p) throws URISyntaxException, IOException, InterruptedException {
        if(AnarchyUtils.instance.getConfig().getBoolean("Settings.checkForUpdates")){
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.github.com/repos/TOPLIB/anarchyutils/releases/latest"))
                    .GET()
                    .build();

            String body = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString()).body();
            JsonObject json = new JsonParser().parse(body).getAsJsonObject();

            String latestVersion = json.get("name").getAsString();
            String downloadLink = json
                    .getAsJsonArray("assets")
                    .get(0).getAsJsonObject()
                    .get("browser_download_url").getAsString();

            if (!AnarchyUtils.instance.getDescription().getVersion().equals(latestVersion)) {
                AnarchyUtils.instance.getLogger().warning("New version is available!");
                AnarchyUtils.instance.getLogger().warning("Latest version: " + latestVersion + " Your version: " + AnarchyUtils.instance.getDescription().getVersion());
                p.sendMessage(color("&fNew version! &c(Only for admins)"));
                p.sendMessage(color("&fLatest version: &a" + latestVersion + " &fYour version: &c" + AnarchyUtils.instance.getDescription().getVersion()));
                p.sendMessage(color("&fYou can download update on: Github, BlackMinecraft, Spigot"));
            }
        }
    }

    public String protectTHash(String text){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2)
        {
            String sub = text.substring(i, i + 2);
            long num = Long.parseLong(sub, 16);
            builder.append(num).append(".");
        }

        String result = builder.toString();
        result = result.substring(0, result.length() - 1);
        return result;
    }
}
