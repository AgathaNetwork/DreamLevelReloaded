package cn.kylin.dreamlevel.dreamlevelreloaded.api;

import cn.kylin.dreamlevel.dreamlevelreloaded.DreamLevelReloaded;
import cn.kylin.dreamlevel.dreamlevelreloaded.api.data.Level;
import cn.kylin.dreamlevel.dreamlevelreloaded.api.data.PlayerData;
import cn.kylin.dreamlevel.dreamlevelreloaded.covervanilla.CoverManager;
import cn.kylin.dreamlevel.dreamlevelreloaded.data.DataGeneral;
import cn.kylin.dreamlevel.dreamlevelreloaded.permissions.PerManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * DreamLevel 给开发者使用的API主类 有各种静态方法供使用
 */
public class DlApi {

    public static Map<String, Level> getLevels(){
        return DreamLevelReloaded.levels;
    }

    public static List<PlayerData> getAllPlayerData(){
        ArrayList<PlayerData> list = new ArrayList<>();
        Set<String> keys = DreamLevelReloaded.levels.keySet();
        Level level;
        for (String key : keys) {
            level = DreamLevelReloaded.levels.get(key);
            Set<String> keySet = level.datas.keySet();
            for (String s : keySet) {
                list.add(level.datas.get(s));
            }
        }
        return list;
    }

    public static PlayerData getPlayerData(String playerName, String levelName){
        return getLevels().get(levelName).datas.get(playerName);
    }


    public static void insertPlayerData(PlayerData data){
        DataGeneral.insertPlayerData(data);
    }

    public static void updatePlayerData(PlayerData data){
        DataGeneral.updatePlayerData(data);
    }

    public static boolean enableActionBar(){
        return DreamLevelReloaded.enableActionBar;
    }

    public static boolean enableCoverVanilla(){
        return CoverManager.coverVanilla;
    }

    public static boolean checkHasPermission(PlayerData data, int level){
        if (level > data.getCurrentLevel()) return true;
        for (int i = data.getCurrentLevel(); i < level; i++) {
            boolean b = PerManager.checkHasPermission(data);
            if (!b) return false;
        }
        return true;
    }



}
