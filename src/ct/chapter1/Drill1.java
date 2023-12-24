package ct.chapter1;

import arc.Core;
import ct.abe.CTBurstDrill;
import ct.abe.CTDrawMultiWeave;
import mindustry.content.Fx;
import mindustry.content.Liquids;
import mindustry.entities.effect.MultiEffect;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;
import mindustry.world.meta.BlockGroup;


import static ct.chapter1.Item1.*;
import static mindustry.type.ItemStack.with;

public class Drill1 {
    public static Block 陶玉钻头,灵玉钻头,威灵钻头,明宝钻头,汲水器,液体泵;
    public static void load(){
        陶玉钻头 = new Drill("陶玉钻头"){{
            localizedName = Core.bundle.get("Drill.tao");
            description = Core.bundle.getOrNull("Drill.description.tao");
            requirements(Category.production, with(陶, 24));
            tier = 2;
            drillTime = 280;
            canOverdrive=false;//不可超速
            size = 2;
            health = 300;
           // hasLiquids=false;
            liquidBoostIntensity = 2f;
            consumeLiquid(Liquids.water, 0.06f).boost();
            //mechanical drill doesn't work in space
           // envEnabled ^= Env.space;

        }};

        灵玉钻头 = new Drill("灵玉钻头"){{
            localizedName = Core.bundle.get("Drill.lingyu");
            description = Core.bundle.getOrNull("Drill.description.lingyu");
            requirements(Category.production, with(灵玉,15,幻烬, 40, 翠 ,160));
            tier = 3;
            drillTime = 240;
            canOverdrive=false;
            size = 2;
            health = 700;
            hasLiquids=false;
            conductivePower=true;//可以导电
            researchCost = with(灵玉,3000,幻烬, 8000, 翠 ,48000);
           // liquidBoostIntensity = 1.2f;
            consumePower(180/60f);
            //consumeLiquid(Liquids.water, 0.06f).boost();
        }};

        威灵钻头 = new Drill("威灵钻头"){{
                        localizedName = Core.bundle.get("Drill.weiling");
            description = Core.bundle.getOrNull("Drill.description.weiling");
            requirements(Category.production, with(威灵, 35, 血晶, 30, 灵玉, 30, 缕, 20));
            drillTime = 120;
            size = 3;
            hasPower = true;
            canOverdrive=false;
            tier = 4;
            health = 1200;
            researchCostMultiplier = 2.5f;//科技树中的研究资源倍率
            updateEffect = Fx.pulverizeMedium;
            drillEffect = Fx.mineBig;
            liquidBoostIntensity = 1.4f;
            consumePower(260/60f);
            consumeLiquid(灵液, 4/60f).boost();
            conductivePower=true;//可以导电
        }};

        明宝钻头 = new CTBurstDrill("明宝钻头"){{
            localizedName = Core.bundle.get("Drill.mingbao");
            description = Core.bundle.getOrNull("Drill.description.mingbao");
            requirements(Category.production, with(威灵, 65, 离, 60, 灵玉, 50, 明宝, 75));
            drillTime = 90;
            canOverdrive=false;
            size = 4;
            tier = 5;
            itemCapacity = 50;
            liquidCapacity = 15;
            health = 2500;
            researchCostMultiplier = 3f;//科技树中的研究资源倍率
           // drillMultipliers.put(Items.beryllium, 2.5f);//*每个矿物的钻速乘数。默认为1
            //  researchCostMultiplier = 0.5f;//研究倍率
            drillEffect = new MultiEffect(Fx.mineImpact,
                    Fx.dynamicSpikes.wrap(明宝.color, 20f));
            shake = 1f;//屏幕震动
                  //blockedItem = Items.thorium;//黑名单矿物
            fogRadius = 4;
            liquidBoostIntensity = 2.7f;//液体增幅比

            consumePower(380/60f);
            consumeLiquid(精纯灵液, 0.1f).boost();
        }};
        汲水器 = new GenericCrafter("汲水器"){{
            localizedName = Core.bundle.get("Drill.shui");
            description = Core.bundle.getOrNull("Drill.description.shui");
            requirements(Category.production, with(幻烬, 20, 威灵, 60,灵玉,40,陶,30));
            health = 500;
            size = 3;
            craftTime = 60;
            canOverdrive=false;
            hasItems=false;
            outputsLiquid = true;
            buildCostMultiplier = 0.5f;
                     outputLiquid = new LiquidStack(Liquids.water, 90f / 60f);
            group = BlockGroup.liquids;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.water),
                          // new DrawBlurSpin("-rotator", 6f),
                    new CTDrawMultiWeave(){{
                        rotateSpeed=3;
                    }},//一个外部贴图旋转
                    new DrawDefault());

           ambientSound = Sounds.hum;

           consumePower(150f/60);
            liquidCapacity = 200f;
        }};
        液体泵 = new Pump("液体泵"){{
            requirements(Category.production, with(
                    威灵, 30,
                    血晶,40,
                    陶,50
            ));
            health = 800;
            canOverdrive=false;
            pumpAmount = 0.18f;
            consumePower(120/60f);
            liquidCapacity = 40f;
            hasPower = true;
            size = 2;
        }};
    }
}

