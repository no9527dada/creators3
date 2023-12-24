package ct.ahapter;

import arc.Core;
import ct.abe.CTCoreBlock;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.meta.BuildVisibility;

import static ct.chapter1.Item1.*;
import static ct.chapter1.Unit1.*;
import static mindustry.type.ItemStack.with;

public class 核心方块 {
    public static Block core0,core1,core2;
    public static void load() {
        core0 = new CTCoreBlock("core0") {{
            localizedName = Core.bundle.get("block.core0");
            description = Core.bundle.getOrNull("block.description.core0");
            requirements(Category.effect, BuildVisibility.editorOnly, with(陶, 100));
            alwaysUnlocked = true;
            incinerateNonBuildable = true;//不可建造，会在建造UI面板隐藏
            isFirstTier = false;//核心地板限制
            unitType = 核心机0号;
            health = 1100;
            itemCapacity = 6000;
            size = 3;
            solid = false;//固体
            unitCapModifier = 6;
        }};
        core1 = new CTCoreBlock("core1") {{
            localizedName = Core.bundle.get("block.core1");
            description = Core.bundle.getOrNull("block.description.core1");
            requirements(Category.effect,  with(陶, 2000,翠,2500,幻烬,500));
           // alwaysUnlocked = true;
           // incinerateNonBuildable = true;
            solid = false;//固体
            isFirstTier = false;//核心地板限制
            unitType = 核心机1号;
            health = 2000;
            itemCapacity = 8000;
            size = 3;
            researchCost = with(陶, 20000,翠,25000,幻烬,11000);
            unitCapModifier = 6;
        }};
        core2 = new CTCoreBlock("core2") {{
            localizedName = Core.bundle.get("block.core2");
            description = Core.bundle.getOrNull("block.description.core2");
            requirements(Category.effect,  with(陶, 5000,翠,5000,缕,1500));
            // alwaysUnlocked = true;
            // incinerateNonBuildable = true;
            solid = false;//固体
            isFirstTier = false;//核心地板限制
            unitType = 核心机2号;
            health = 2800;
            itemCapacity = 10000;
            size = 4;
            armor=2;
            researchCost = with(陶, 20000,翠,25000,幻烬,11000);
            unitCapModifier = 6;
        }};
    }
}
