package ct.abe.rebirth.utils;
/*
 *@Author:LYBF
 *@Date  :2023/12/6
 */

import arc.struct.OrderedMap;
import mindustry.logic.LogicFx;
import mindustry.logic.LogicFx.*;

import java.lang.reflect.Field;
import java.util.Objects;

public class LogicFxInit {

    private static LogicFx logicFx = new LogicFx();
    private static OrderedMap<String, EffectEntry> orderedMap;

    static {
        try {
            Field map = logicFx.getClass().getDeclaredField("map");
            map.setAccessible(true);
            orderedMap = (OrderedMap<String, EffectEntry>) map.get(logicFx);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     *  @name:特效名
     *  @effectEntry:特效
     *  @desc:使用该方法向世界处理器添加自定义特效
     */
    public static void injectEffect(String name, EffectEntry effectEntry) {
        if (Objects.isNull(name) || Objects.isNull(effectEntry)) return;
        effectEntry.name = name;
        orderedMap.put(name, effectEntry);
    }
}
