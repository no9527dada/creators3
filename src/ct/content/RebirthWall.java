package ct.content;

import arc.Core;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;

import static ct.content.RebirthItem.*;
import static mindustry.type.ItemStack.with;

public class RebirthWall {
    public static Block 陶墙1, 陶墙2, 幻烬墙, 缕墙, 灵化缕墙, 小离墙, 离墙;

    ;

    public static void load() {
        陶墙1 = new Wall("陶墙1") {{
            localizedName = Core.bundle.get("Wall.tao1");
            health = 420;
            size = 1;
            buildCostMultiplier = 2.5f;//建造时间倍率
            requirements(Category.defense, with(
                    陶, 15
            ));
        }};
        陶墙2 = new Wall("陶墙2") {{
            localizedName = Core.bundle.get("Wall.tao2");
            description = Core.bundle.getOrNull("Wall.description.tao2");

            health = 2500;
            size = 2;
            buildCostMultiplier = 0.8f;//建造时间倍率
            requirements(Category.defense, with(
                    陶, 80
            ));
        }};
        幻烬墙 = new Wall("幻烬墙") {{
            localizedName = Core.bundle.get("Wall.huanjing");
            description = Core.bundle.getOrNull("Wall.description.huanjing");
            health = 3400;
            size = 2;
            buildCostMultiplier = 0.7f;//建造时间倍率
            requirements(Category.defense, with(
                    幻烬, 40
            ));
        }};
        缕墙 = new Wall("缕墙") {{
            localizedName = Core.bundle.get("Wall.lv");
            description = Core.bundle.getOrNull("Wall.description.lv");
            health = 5200;
            size = 2;
            researchCostMultiplier = 3f;//科技树中的研究资源倍率
            buildCostMultiplier = 1.3f;//建造时间倍率
            requirements(Category.defense, with(
                    缕, 70
            ));
        }};
        灵化缕墙 = new Wall("灵化缕墙") {{
            localizedName = Core.bundle.get("Wall.lv2");
            description = Core.bundle.getOrNull("Wall.description.lv2");
            health = 4000;
            size = 2;
            insulated = false;//绝缘
            absorbLasers = true;//吸收激光
            researchCostMultiplier = 4f;//科技树中的研究资源倍率
            buildCostMultiplier = 1f;//建造时间倍率
            requirements(Category.defense, with(
                    缕, 50, 灵玉, 20
            ));
        }};
        小离墙 = new Wall("小离墙") {{
            localizedName = Core.bundle.get("Wall.li");
            description = Core.bundle.getOrNull("Wall.description.li");
            health = 1600;
            size = 1;
            researchCostMultiplier = 3f;//科技树中的研究资源倍率
            buildCostMultiplier = 1.3f;//建造时间倍率
            requirements(Category.defense, with(
                    离, 12
            ));
        }};
        离墙 = new Wall("离墙") {{
            localizedName = Core.bundle.get("Wall.li2");
            description = Core.bundle.getOrNull("Wall.description.li2");
            health = 6400;
            size = 2;
            researchCostMultiplier = 3f;//科技树中的研究资源倍率
            buildCostMultiplier = 1.3f;//建造时间倍率
            requirements(Category.defense, with(
                    离, 35
            ));
        }};

    }
}
