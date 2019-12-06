package iKguana.artonline.SimpleDialog;

import cn.nukkit.utils.Config;
import iKguana.artonline.ArtOnline;

import java.io.File;

public class SimpleDialogConfig {
    private static ArtOnline $plugin;
    private static Config cfg;

    public SimpleDialogConfig(ArtOnline plugin) {
        $plugin = plugin;

        File path = new File(plugin.getDataFolder() + File.separator + "SimpleDialog");
        path.mkdirs();

        $plugin.saveDefaultConfig("config_SimpleDialog.yml", "config.yml", false, path);

        cfg = new Config(new File(path, "config.yml"), Config.YAML);
    }

    public static Config getConfig() {
        return cfg;
    }

    public static String getMessage(String key) {
        return getMessage(key, new String[]{});
    }

    public static String getMessage(String key, String... strings) {
        String str = getConfig().getString("messages." + key);

        for (int i = 0; i < strings.length; i++)
            str = str.replace("%" + (i + 1), strings[i]);
        return str;
    }
}
