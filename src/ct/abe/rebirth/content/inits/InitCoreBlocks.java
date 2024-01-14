package ct.abe.rebirth.content.inits;

import arc.Core;
import ct.abe.rebirth.blocks.stroge.CTCoreBlock;
import mindustry.type.Category;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.meta.BuildVisibility;

import static ct.abe.rebirth.content.Blocks.*;
import static ct.abe.rebirth.content.Items.*;
import static ct.abe.rebirth.content.Units.*;
import static mindustry.type.ItemStack.with;

public class InitCoreBlocks {

    public static void load() {
        //敌人的隐形核心，作用于刷怪，不可被攻击和摧毁，只能用逻辑清除该方块，达到胜利的目的
        new CoreBlock("invisibilityCore") {
            {
                localizedName = Core.bundle.get("block.invisibilityCore");
                description = Core.bundle.getOrNull("block.description.invisibilityCore");
                requirements(Category.effect, BuildVisibility.editorOnly, with(陶, 100));
                alwaysUnlocked = true;
                incinerateNonBuildable = true;//不可建造，会在建造UI面板隐藏
                isFirstTier = false;//核心地板限制
                //unitType = 核心机0号;
                health = 20000;
                itemCapacity = 10000;
                size = 1;
                solid = false;//固体
                targetable = false;//被单位攻击？
                canOverdrive = false;//超速
                unitCapModifier = 999999;
                hasShadow = false;//方块黑影
                drawTeamOverlay = false;//方块绘制队伍斜杠
                buildType = Build::new;
            }

            class Build extends CoreBlock.CoreBuild {
                @Override
                public void damage(float damage) {
                }

                public void drawLight() {
                }//不发光

            }
        };
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
            requirements(Category.effect, with(陶, 2000, 翠, 2500, 幻烬, 500));
            // alwaysUnlocked = true;
            // incinerateNonBuildable = true;
            solid = false;//固体
            isFirstTier = false;//核心地板限制
            unitType = 核心机1号;
            health = 2000;
            itemCapacity = 8000;
            size = 3;
            researchCost = with(陶, 20000, 翠, 25000, 幻烬, 11000);
            unitCapModifier = 6;
        }};
        core2 = new CTCoreBlock("core2") {{
            localizedName = Core.bundle.get("block.core2");
            description = Core.bundle.getOrNull("block.description.core2");
            requirements(Category.effect, with(陶, 5000, 翠, 5000, 缕, 1500));
            // alwaysUnlocked = true;
            // incinerateNonBuildable = true;
            solid = false;//固体
            isFirstTier = false;//核心地板限制
            unitType = 核心机2号;
            health = 2800;
            itemCapacity = 10000;
            size = 4;
            armor = 2;
            researchCost = with(陶, 20000, 翠, 25000, 幻烬, 11000);
            unitCapModifier = 6;
        }};
    }
}
