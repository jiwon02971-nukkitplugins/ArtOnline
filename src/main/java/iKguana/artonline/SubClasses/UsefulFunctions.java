package iKguana.artonline.SubClasses;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.level.Level;
import cn.nukkit.level.Sound;
import cn.nukkit.network.protocol.PlaySoundPacket;
import iKguana.artonline.Profiler.Profiler;

import java.util.ArrayList;
import java.util.Date;

public abstract class UsefulFunctions {
    protected static boolean isNumber(String... nums) {
        try {
            for (String num : nums)
                Integer.parseInt(num);
            return true;
        } catch (Exception err) {
        }
        return false;
    }

    protected static boolean isInteger(String... nums) {
        try {
            for (String num : nums)
                if (Integer.parseInt(num) == Double.parseDouble(num))
                    return true;
        } catch (Exception err) {
        }
        return false;
    }

    protected static boolean isLong(String num) {
        try {
            Long.parseLong(num);
            return true;
        } catch (Exception err) {
        }
        return false;
    }

    protected static boolean isFloat(String... nums) {
        try {
            for (String num : nums)
                Float.parseFloat(num);
            return true;
        } catch (Exception err) {
        }
        return false;
    }

    protected static boolean isDouble(String num) {
        try {
            Double.parseDouble(num);
            return true;
        } catch (Exception err) {
        }
        return false;
    }


    protected static boolean isPlayer(String name) {
        return Profiler.getInstance().isPlayerRegistered(name);
    }

    protected static boolean isPlayerOnline(String name) {
        for (Player player : Server.getInstance().getOnlinePlayers().values())
            if (player.getName().equalsIgnoreCase(name))
                return true;
        return false;
    }

    protected static String getExactName(String name) {
        return Profiler.getInstance().getExactName(name);
    }

    protected static Player getPlayerOnline(String name) {
        for (Player player : Server.getInstance().getOnlinePlayers().values())
            if (player.getName().equalsIgnoreCase(name))
                return player;
        return null;
    }

    protected static ArrayList<Player> getOnlinePlayers() {
        return new ArrayList<Player>(Server.getInstance().getOnlinePlayers().values());
    }

    protected static ArrayList<String> getPlayers() {
        return Profiler.getInstance().getProfileList();
    }

    protected static boolean isLevel(String name) {
        for (Level lvl : Server.getInstance().getLevels().values())
            if (lvl.getName().equalsIgnoreCase(name))
                return true;
        return false;
    }

    protected static Level getLevel(String name) {
        for (Level lvl : Server.getInstance().getLevels().values())
            if (lvl.getName().equalsIgnoreCase(name))
                return lvl;
        return null;
    }

    protected static boolean isSound(String sound) {
        for (Sound snd : Sound.values())
            if (sound.equals(snd.getSound()))
                return true;
        return false;
    }

    protected static void playSound(Player player, String sound) {
        PlaySoundPacket pk = new PlaySoundPacket();
        pk.volume = 1;
        pk.name = sound;

        pk.x = player.getFloorX();
        pk.y = player.getFloorY();
        pk.z = player.getFloorZ();

        pk.pitch = 0;

        player.dataPacket(pk);
    }

    protected static long getTime() {
        return new Date().getTime();
    }

    protected static void sendError(Player player, String cause) {
        player.sendMessage("오류가 발생했습니다. (" + cause + ")");
    }
}
