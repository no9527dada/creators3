package ct.chapter1;

import ct.ahapter.Item0;
import ct.ahapter.CoreBlocks;

public class chapter1 {
    public static void load() {
        //加载顺序非必要不能随意变动
        Item1.load();
        Item0.load();
        Unit1.load();
        Bullets.load();
        Turrets.load();
        Blocks1.load();
        Wall1.load();

        CoreBlocks.load();
        WuLiu1.load();
        Drill1.load();


        Planet1.load();
        Maps1.load();
        TechTree1.load();
    }
}
