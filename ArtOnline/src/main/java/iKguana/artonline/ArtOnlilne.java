package iKguana.artonline;

import cn.nukkit.Server;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Utils;
import iKguana.artonline.Profiler.Profiler;
import iKguana.artonline.SimpleDialog.SimpleDialogConfig;
import iKguana.artonline.SimpleDialog.SimpleDialogListener;

import java.io.File;
import java.io.InputStream;

public class ArtOnlilne extends PluginBase {
    @Override
    public void onEnable(){
        getDataFolder().mkdirs();

        new Profiler(this);

        new SimpleDialogConfig(this);
        getServer().getPluginManager().registerEvents(new SimpleDialogListener(), this);
    }

    public void saveDefaultConfig(String filename, String outputName, boolean replace, File path) {
        File out = new File(path, outputName);

        if (!out.exists() || replace) {
            try {
                InputStream resource = this.getClass().getClassLoader().getResourceAsStream(filename);

                File outFolder = out.getParentFile();
                if (!outFolder.exists())
                    outFolder.mkdirs();

                Utils.writeFile(out, resource);
            } catch (Exception err) {
                Server.getInstance().getLogger().logException(err);
            }
        }
    }

    @Override
    public void onDisable(){
        Profiler.getInstance().saveAll();
    }
}
