package ct.content.chapter5;

import mindustry.content.Items;
import mindustry.type.Category;

import static ct.content.chapter5.资源5.*;
import static mindustry.content.Blocks.*;
import static mindustry.type.ItemStack.with;


//方块
public class 原版修改5 {
    public static void load() {

        blastDrill.requirements(Category.production, with(//爆破钻头
                Items.copper, 65, Items.silicon, 60, Items.titanium, 50, Items.thorium, 75, 铁, 30
        ));
        laserDrill.requirements(Category.production, with(//激光钻头
                Items.copper, 35, Items.graphite, 30, Items.silicon, 30, Items.titanium, 20, 石英, 10
        ));
        impulsePump.requirements(Category.liquid, with(//蓝大水泵
                Items.copper, 80, Items.metaglass, 90, Items.silicon, 30, Items.titanium, 40, Items.thorium, 35, 钴, 25
        ));
        rotaryPump.requirements(Category.liquid, with(//蓝小水泵
                Items.copper, 70, Items.metaglass, 50, Items.silicon, 20, Items.titanium, 35, 铁, 5
        ));
        massDriver.requirements(Category.distribution, with(//直驱
                Items.titanium, 125, Items.silicon, 75, Items.lead, 125, Items.thorium, 50, 铁, 5
        ));
        steamGenerator.requirements(Category.power, with(//涡轮发电机
                Items.copper, 35, Items.graphite, 25, Items.lead, 40, Items.silicon, 30, 石英, 20
        ));
        //电力节点
        powerNode.requirements(Category.power, with(Items.copper, 1, Items.lead, 3));


        //大型电力节点
        powerNodeLarge.requirements(Category.power, with(Items.titanium, 5, Items.lead, 10, Items.silicon, 3, 铁, 5));

        //巨浪电力塔
        surgeTower.requirements(Category.power, with(Items.titanium, 7, Items.lead, 10, Items.silicon, 15, Items.surgeAlloy, 15, 铁板, 10));


        thoriumReactor.requirements(Category.power, with(//钍反应堆
                Items.lead, 300, Items.silicon, 200, Items.graphite, 150, Items.thorium, 150, Items.metaglass, 50, 铁, 30, 钴, 3
        ));
        impactReactor.requirements(Category.power, with(//冲击反应堆
                Items.lead, 500, Items.silicon, 300, Items.graphite, 400, Items.thorium, 100, Items.surgeAlloy, 250, Items.metaglass, 250, 镍板, 20
        ));

        //超速投影
        overdriveProjector.requirements(Category.effect, with(Items.lead, 100, Items.titanium, 75, Items.silicon, 75, Items.plastanium, 30, 石英, 20));


    }
}