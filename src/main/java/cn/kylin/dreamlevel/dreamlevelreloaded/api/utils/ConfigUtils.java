package cn.kylin.dreamlevel.dreamlevelreloaded.api.utils;

import cn.kylin.dreamlevel.dreamlevelreloaded.api.data.Level;
import cn.kylin.dreamlevel.dreamlevelreloaded.config.LevelLoader;
import org.bukkit.configuration.ConfigurationSection;

public class ConfigUtils {

    public static Level loadLevel(ConfigurationSection section){
        return LevelLoader.loadLevel(section);
    }


}
