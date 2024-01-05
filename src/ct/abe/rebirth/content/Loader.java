package ct.abe.rebirth.content;

import ct.abe.rebirth.content.others.*;

public class Loader {
    //该方法负责初始化模组所需内容
    public static void load() {
        CTAttributes.load();
        //初始化物品
        Items.load();
        //初始化单位
        Units.load();
        //初始化子弹类
        Bullets.load();
        //初始化炮塔
        Turrets.load();
        //初始化Blocks
        Blocks.load();
        //初始化Floors
        Floors.load();
        //初始化星球
        Planets.load();
        //初始化地图
        Maps1.load();
        //初始化自定义特效
        NewFx.load();
        //注入自定义特效
        NewFx.init();
        //初始化SMC
        initSMCContent();
        //初始化科技树
        TechTree1.load();
        TechTree2.load();
        TechTree3.load();
       // TechTree4.load();
        //TechTree5.load();

    }

    private static void initSMCContent() {
        ItemsSMC.load();
        ItemsSMCblocks.load();
        ItemsSMChuaGong.load();
        ItemsSMChunJu.load();
        ItemsSMCjingLian.load();
        ItemsSMCyeLian.load();
        ct.abe.rebirth.content.others.Turrets.load();
    }
}
