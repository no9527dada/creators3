package ct.content.chapter1;


import ct.content.Bullets.Bullets1;
import ct.content.CT3CoreBlocks;
import ct.content.Item0;

public class chapter1 {
    public static void load() {
        //加载顺序非必要不能随意变动
        Item1.load();
        Item0.load();
        CoreUnit1.load();
        UnitNPC.load();
        Bullets1.load();
        Turrets1.load();
        Blocks1.load();
        Wall1.load();

        CT3CoreBlocks.load();
        WuLiu1.load();
        Drill1.load();


        Planet1.load();
        Maps1.load();
        TechTree1.load();
    }
}
