package cn.kylin.dreamlevel.dreamlevelreloaded.runnable;

import cn.kylin.dreamlevel.dreamlevelreloaded.DreamLevelReloaded;
import cn.kylin.dreamlevel.dreamlevelreloaded.listener.PlayerListener;
import org.bukkit.Bukkit;

import java.util.Set;

public class FlushNoPerMsgRunnable implements Runnable {

    @Override
    public void run() {
        Set<String> keys = PlayerListener.map.keySet();
        for (String key : keys) {
            PlayerListener.map.put(key, true);
        }
    }

    public static void runTask(){
        Bukkit.getScheduler().runTaskTimer(DreamLevelReloaded.plugin, new FlushNoPerMsgRunnable(), 3*1200, 3*1200);
    }
}
