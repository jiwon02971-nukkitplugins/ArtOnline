package iKguana.artonline;

import cn.nukkit.plugin.PluginBase;
import iKguana.artonline.Profiler.Profiler;
import iKguana.artonline.SimpleDialog.ST;
import iKguana.artonline.SimpleDialog.SimpleDialogListener;

public class ArtOnlilne extends PluginBase {
    @Override
    public void onEnable(){
        new Profiler(this);

        new ST(this);
        getServer().getPluginManager().registerEvents(new SimpleDialogListener(), this);
    }
    @Override
    public void onDisable(){
        Profiler.getInstance().saveAll();
    }
}
