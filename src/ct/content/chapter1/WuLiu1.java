package ct.content.chapter1;

import arc.Core;
import arc.graphics.Color;
import arc.math.Mathf;
import mindustry.graphics.Drawf;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.production.Incinerator;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.meta.BlockGroup;

import static ct.content.chapter1.Item1.*;
import static mindustry.type.ItemStack.with;

public class WuLiu1 {
    public static Block 陶玉运输带, 威灵运输带, 灵化威灵运输带, 明宝打包运输带, 焚化炉,
            路由器, 连接器, 分配器, 分类器, 反向分类器, 溢流门, 反向溢流门, 灵玉运输桥, 萤玫运输桥, 物品卸载器, 仓库, 大仓库,
            液体导管, 灵化液体导管, 液体路由器, 液体连接器, 液仓, 液体桥接器, 远程液体桥接器;

    ;

    public static void load() {
        陶玉运输带 = new Conveyor("conveyor") {
            {
                localizedName = Core.bundle.get("WuLiu.tao");
                description = Core.bundle.getOrNull("WuLiu.description.tao");
                requirements(Category.distribution, with(陶, 1));
                health = 45;
                speed = 0.12f;
                displayedSpeed = 17f;
                buildCostMultiplier = 2f;
                researchCost = with(陶, 50);

            }

            @Override
            public void init() {
                super.init();
                junctionReplacement = 连接器;
                bridgeReplacement = 灵玉运输桥;
            }
        };
        威灵运输带 = new Conveyor("titanium-conveyor") {
            {
                localizedName = Core.bundle.get("WuLiu.weiling");
                description = Core.bundle.getOrNull("WuLiu.description.weiling");
                requirements(Category.distribution, with(翠, 1, 威灵, 1, 陶, 1));
                health = 100;
                speed = 0.27f;
                displayedSpeed = 35f;
            }

            @Override
            public void init() {
                super.init();
                junctionReplacement = 连接器;
                bridgeReplacement = 灵玉运输桥;
            }
        };
        灵化威灵运输带 = new ArmoredConveyor("armored-conveyor") {
            {
                localizedName = Core.bundle.get("WuLiu.linghuaweiling");
                description = Core.bundle.getOrNull("WuLiu.description.linghuaweiling");
                requirements(Category.distribution, with(翠, 1, 威灵, 1, 陶, 1, 灵玉, 3));
                health = 180;
                speed = 0.35f;
                displayedSpeed = 42f;
                buildType = Build::new;
            }

            class Build extends ArmoredConveyor.ArmoredConveyorBuild {//发光

                @Override
                public void drawLight() {
                    Drawf.light(x, y, 16, Color.valueOf("ff1a91"), 0.65f + Mathf.absin(20f, 0.1f));
                }
            }

            @Override
            public void init() {
                super.init();
                junctionReplacement = 连接器;
                bridgeReplacement = 灵玉运输桥;
            }
        };
        明宝打包运输带 = new StackConveyor("plastanium-conveyor") {{
            localizedName = Core.bundle.get("WuLiu.mingbao");
            description = Core.bundle.getOrNull("WuLiu.description.null");
            requirements(Category.distribution, with(明宝, 1, 灵玉, 3, 陶, 5, 离, 2));
            health = 75;
            speed = 12f / 60f;
            itemCapacity = 10;
        }};
        路由器 = new Router("router") {{
            localizedName = Core.bundle.get("WuLiu.router");
            description = Core.bundle.getOrNull("WuLiu.description.null");
            requirements(Category.distribution, with(陶, 5));
            buildCostMultiplier = 4f;
            researchCost = with(陶, 50);
        }};
        连接器 = new Junction("junction") {{
            localizedName = Core.bundle.get("WuLiu.junction");
            description = Core.bundle.getOrNull("WuLiu.description.null");
            requirements(Category.distribution, with(翠, 3));
            speed = 0;
            capacity = 6;
            health = 30;
            buildCostMultiplier = 6f;
            researchCost = with(翠, 50);
        }};
        分配器 = new Router("distributor") {{
            localizedName = Core.bundle.get("WuLiu.distributor");
            description = Core.bundle.getOrNull("WuLiu.description.null");
            requirements(Category.distribution, with(翠, 4, 陶, 4));
            buildCostMultiplier = 3f;
            size = 2;
        }};
        分类器 = new Sorter("sorter") {{
            localizedName = Core.bundle.get("WuLiu.sorter");
            description = Core.bundle.getOrNull("WuLiu.description.null");
            requirements(Category.distribution, with(翠, 3));
            buildCostMultiplier = 3f;
            researchCost = with(翠, 50);
        }};
        反向分类器 = new Sorter("inverted-sorter") {{
            localizedName = Core.bundle.get("WuLiu.inverted-sorter");
            description = Core.bundle.getOrNull("WuLiu.description.null");
            requirements(Category.distribution, with(陶, 3, 翠, 3));
            buildCostMultiplier = 3f;
            invert = true;
        }};
        溢流门 = new OverflowGate("overflow-gate") {{
            localizedName = Core.bundle.get("WuLiu.overflow-gate");
            description = Core.bundle.getOrNull("WuLiu.description.null");
            requirements(Category.distribution, with(陶, 5, 翠, 3));
            buildCostMultiplier = 3f;
        }};
        反向溢流门 = new OverflowGate("underflow-gate") {{
            localizedName = Core.bundle.get("WuLiu.underflow-gate");
            description = Core.bundle.getOrNull("WuLiu.description.null");
            requirements(Category.distribution, with(陶, 3, 翠, 5));
            buildCostMultiplier = 3f;
            invert = true;
        }};
        灵玉运输桥 = new BufferedItemBridge("bridge-conveyor") {{
            localizedName = Core.bundle.get("WuLiu.lingyuqiao");
            description = Core.bundle.getOrNull("WuLiu.description.null");
            requirements(Category.distribution, with(灵玉, 3, 翠, 10));
            fadeIn = moveArrows = false;
            range = 7;
            speed = 24f;
            arrowSpacing = 6f;
            bufferCapacity = 14;
        }};
        萤玫运输桥 = new ItemBridge("phase-conveyor") {{
            localizedName = Core.bundle.get("WuLiu.yinmeiqiao");
            description = Core.bundle.getOrNull("WuLiu.description.null");
            requirements(Category.distribution, with(萤玫, 5, 灵玉, 5, 翠, 10, 陶, 10));
            range = 50;
            arrowPeriod = 0.9f;
            arrowTimeScl = 2.75f;
            hasPower = true;
            pulse = true;
            consumePower(2f);
        }};
        物品卸载器 = new Unloader("物品卸载器") {{
            localizedName = Core.bundle.get("WuLiu.Unloader1");
            description = Core.bundle.getOrNull("WuLiu.description.null");
            requirements(Category.effect, with(缕, 30, 灵玉, 10));
            speed = 60f / 11f;
            hasPower = true;
            conductivePower = true;//导电
            consumePower(0.5f);
            group = BlockGroup.transportation;
            researchCostMultiplier = 10f;//科技树中的研究资源倍率
        }};

        仓库 = new StorageBlock("仓库") {{
            localizedName = Core.bundle.get("WuLiu.cangku1");
            description = Core.bundle.getOrNull("WuLiu.description.null");
            requirements(Category.effect, with(血晶, 20, 缕, 30, 陶, 50));
            size = 2;
            group = BlockGroup.transportation;
            itemCapacity = 200;
            health = 150;
            coreMerge = false;
        }};
        大仓库 = new StorageBlock("大仓库") {{
            localizedName = Core.bundle.get("WuLiu.cangku2");
            description = Core.bundle.getOrNull("WuLiu.description.null");
            requirements(Category.effect, with(离, 50, 缕, 70, 陶, 200));
            size = 3;
            group = BlockGroup.transportation;
            itemCapacity = 3000;
            health = 500;
            coreMerge = false;
        }};
        焚化炉 = new Incinerator("incinerator") {{
            localizedName = Core.bundle.get("WuLiu.incinerator");
            description = Core.bundle.getOrNull("WuLiu.description.null");
            requirements(Category.effect, with(幻烬, 15, 陶, 10));
            health = 90;
            consumePower(1f);
        }};
        //液体运输
        液体导管 = new Conduit("conduit") {
            {
                localizedName = Core.bundle.get("WuLiu.conduit");
                description = Core.bundle.getOrNull("WuLiu.description.null");
                requirements(Category.liquid, with(运符, 5));
                health = 45;
            }

            @Override
            public void init() {
                super.init();

                junctionReplacement = 液体连接器;
                bridgeReplacement = 液体桥接器;
            }
        };
        灵化液体导管 = new ArmoredConduit("plated-conduit") {
            {
                localizedName = Core.bundle.get("WuLiu.plated-conduit");
                description = Core.bundle.getOrNull("WuLiu.description.null");
                requirements(Category.liquid, with(运符, 10, 灵玉, 1));
                liquidCapacity = 16f;
                liquidPressure = 1.025f;
                health = 220;

            }

            @Override
            public void init() {
                super.init();

                junctionReplacement = 液体连接器;
                bridgeReplacement = 液体桥接器;
            }
        };

        液体路由器 = new LiquidRouter("液体路由器") {{
            localizedName = Core.bundle.get("WuLiu.liquid-router");
            description = Core.bundle.getOrNull("WuLiu.description.null");
            requirements(Category.liquid, with(运符, 10, 陶, 4));
            liquidCapacity = 20f;
            underBullets = true;
            solid = false;
        }};
        液体连接器 = new LiquidJunction("液体连接器") {{
            localizedName = Core.bundle.get("WuLiu.yetilianjieqi");
            description = Core.bundle.getOrNull("WuLiu.description.null");
            requirements(Category.liquid, with(运符, 10, 翠, 4));
            solid = false;
        }};
        液仓 = new LiquidRouter("液仓") {{
            localizedName = Core.bundle.get("WuLiu.yeticangku");
            description = Core.bundle.getOrNull("WuLiu.description.null");
            requirements(Category.liquid, with(血晶, 20, 缕, 100, 运符, 150));
            liquidCapacity = 2500f;
            size = 2;
            solid = true;
        }};
        液体桥接器 = new LiquidBridge("液体桥接器") {{
            localizedName = Core.bundle.get("WuLiu.yetiqiaojieqi");
            description = Core.bundle.getOrNull("WuLiu.description.null");
            requirements(Category.liquid, with(运符, 10, 灵玉, 3, 翠, 5));
            fadeIn = moveArrows = false;
            arrowSpacing = 6f;
            range = 7;
            hasPower = false;
        }};
        远程液体桥接器 = new LiquidBridge("远程液体桥接器") {{
            localizedName = Core.bundle.get("WuLiu.yuancengyetiqiaojieqi");
            description = Core.bundle.getOrNull("WuLiu.description.null");
            requirements(Category.liquid, with(萤玫, 5, 运符, 10, 灵玉, 5));
            range = 40;
            arrowPeriod = 0.9f;
            arrowTimeScl = 2.75f;
            hasPower = true;
            canOverdrive = false;
            pulse = true;
            consumePower(0.80f);
        }};
    }
}
