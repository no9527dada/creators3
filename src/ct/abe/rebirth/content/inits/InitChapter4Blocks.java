package ct.abe.rebirth.content.inits;

import arc.Events;
import arc.graphics.Color;
import arc.struct.Seq;
import ct.abe.rebirth.blocks.power.CreatorsPowerField;
import ct.abe.rebirth.content.CTAttributes;
import ct.abe.rebirth.content.others.ItemsSMC;
import ct.abe.rebirth.content.others.ItemsSMChuaGong;
import ct.abe.rebirth.content.others.ItemsSMChunJu;
import ct.abe.rebirth.content.others.ItemsSMCyeLian;
import ct.type.CreatorsMultiCrafter;
import ct.type.CreatorsRecipe;
import mindustry.content.*;
import mindustry.game.EventType;
import mindustry.gen.Building;
import mindustry.gen.Sounds;
import mindustry.graphics.CacheLayer;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.environment.StaticWall;
import mindustry.world.blocks.environment.SteamVent;
import mindustry.world.blocks.power.BeamNode;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.ThermalGenerator;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.Separator;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.units.UnitCargoLoader;
import mindustry.world.blocks.units.UnitCargoUnloadPoint;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.consumers.ConsumeItemFlammable;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawLiquidTile;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;
import mindustry.world.meta.*;

import static ct.abe.rebirth.content.Blocks.*;
import static ct.abe.rebirth.content.Items.*;
import static ct.abe.rebirth.content.Units.*;
import static mindustry.content.Blocks.*;
import static mindustry.content.Items.*;
import static mindustry.type.ItemStack.with;

/*
 *初始化章节四的数据
 */
public class InitChapter4Blocks {
    /*
     *请在Blocks类里面定义Block,在这里赋值
     * 如：
     * Blocks.java
     * ....
     * public static Block tesBlocks
     *
     * Init......java
     * load(){
     *   testBlocks = new Block(){...}
     * }
     */
    public static void load() {
        //初始化章节4
        initBlock();
        //初始化单位工厂等
        initUnitBlock();
    }

    private static void initBlock() {
        coreT1 = new CoreBlock("core-shard") {{
            requirements(Category.effect, BuildVisibility.editorOnly, with(魂石, 300, 冥石, 500));
            alwaysUnlocked = true;//默认解锁
            incinerateNonBuildable = true;//焚烧不可建造的资源
            isFirstTier = true;
            unitType = UnitTypes.alpha;
            health = 1100;
            itemCapacity = 6000;
            size = 3;
            unitCapModifier = 0;
        }};


        魂矿 = new OreBlock("soul_ore", 魂石) {{//铜矿
            oreDefault = true;
            variants = 6;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};
        冥矿 = new OreBlock("Skystone_ore", 冥石) {{//铁矿
            oreDefault = true;
            variants = 6;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};
        冤藤矿 = new OreBlock("ghost_vine_ore", 冤藤) {{//煤矿
            oreDefault = true;
            variants = 7;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};
        怨石矿 = new OreBlock("resentment_ore", 怨石) {{//石头
            oreDefault = true;
            variants = 3;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};
        赤焰石矿 = new OreBlock("flame_ore", 赤焰石) {{//硅矿
            oreDefault = true;
            variants = 4;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};
        灵石矿 = new OreBlock("fairy_stone_ore", 灵石) {{//钛石
            oreDefault = true;
            variants = 4;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
            emitLight = true;
            lightRadius = 20;
            lightColor = Color.valueOf("395cf2").a(0.3f);
        }};
        烟冰矿 = new OreBlock("smokeice_ore", 烟冰) {{//可燃冰矿
            oreDefault = true;
            variants = 3;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};
        戾气赤焰石墙矿 = new OreBlock("anger_flame_stone_ore", 戾气赤焰石) {{//分型硅矿
            wallOre = true;//应用墙壁矿
            variants = 4;
        }};

        //沉晶石
        沉石矿 = new StaticWall("gravity_stone_ore") {{//金伯利矿石
            itemDrop = 沉石;//直接墙壁矿
            variants = 3;
        }};
        气丝晶体墙矿 = new OreBlock("qisi_ore", 气丝晶体) {{//刺笋结晶
            wallOre = true;//应用墙壁矿
            variants = 4;
        }};
        硅晶矿 = new StaticWall("silicon_crystal_ore") {{//有机晶体
            itemDrop = 硅晶体;//直接墙壁矿
            variants = 3;
        }};
        微晶石矿 = new StaticWall("微晶石矿") {{//光珊石
            itemDrop = 微晶石;//直接墙壁矿
            variants = 3;
        }};

        魔力石 = new OreBlock("魔力石", 魔能晶) {{//单极磁石矿

        }};


        黑油地板 = new Floor("HeiYouFloor") {{
            drownTime = 230f;
            status = StatusEffects.tarred;
            statusDuration = 240f;
            speedMultiplier = 0.19f;
            variants = 0;
            liquidDrop = 黑油;
            isLiquid = true;
            cacheLayer = CacheLayer.tar;

        }};
        黑油喷口 = new SteamVent("HeiYouVent") {{
            parent = blendGroup = 黑油地板;
            attributes.set(CTAttributes.Vent, 1f);//地形限制与加成
            //attributes.set(Attribute.oil, 1.8f);
            effect = Fx.ventSteam;
            effectColor = Color.valueOf("3C3C3C");
            effectSpacing = 60f;

        }};
        叹酸地板 = new Floor("TanSuanFloor") {{
            drownTime = 230f;
            status = StatusEffects.melting;
            statusDuration = 240f;
            // speedMultiplier = 0.19f;
            variants = 4;
            liquidDrop = 叹酸;
            //cacheLayer = CacheLayer.slag;
            // attributes.set(Attribute.heat, 0.85f);

            emitLight = true;
            lightRadius = 40f;
            //lightColor = Color.valueOf("53AE3C64");
            lightColor = Color.valueOf("53AE3C").a(0.15f);

            playerUnmineable = true;
            speedMultiplier = 0.5F;
            cacheLayer = CacheLayer.arkycite;
            drownTime = 60;
            isLiquid = true;
            hasShadow = false;
            // expanded= true;
        }};
        叮浆地板 = new Floor("DingJangFloor") {{
            drownTime = 230f;
            status = StatusEffects.melting;
            statusDuration = 240f;
            speedMultiplier = 0.19f;
            variants = 4;
            liquidDrop = 叮浆;
            isLiquid = true;
            // cacheLayer = CacheLayer.water;
            cacheLayer = m;
            attributes.set(Attribute.heat, 0.85f);
            emitLight = true;
            lightRadius = 40f;
            lightColor = Color.valueOf("c74713").a(0.4f);
        }};
        墙壁 = new StaticWall("墙壁") {{
            variants = 2;
            iceSnow.asFloor().wall = this;//???
            albedo = 0.6f;
        }};


        /*
        已在Loader.java中加载
        ItemsSMChunJu.load();//魂矩器
        ItemsSMCyeLian.load();//资源冶炼器
        ItemsSMC.load();//资源合成台
        //ItemsSMCjingLian.load();//精炼台 有问题 要修
        ItemsSMChuaGong.load();//  资源炼化器

        */

        油泵 = new ThermalGenerator("油泵") {{
            requirements(Category.power, with(copper, 30));
            size = 3;
            attribute = CTAttributes.Vent;//地形限制与加成

            displayEfficiencyScale = 1f / 9f;
            minEfficiency = 9f - 0.0001f;
            powerProduction = 3f / 9f;
            displayEfficiency = true;
            generateEffect = Fx.turbinegenerate;
            effectChance = 0.04f;
            liquidCapacity = 20f;
            fogRadius = 3;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
//            drawer = new DrawMulti(new DrawDefault(), new DrawBlurSpin("-rotator", 0.6f * 9f){{
//                blurThresh = 0.01f;
//            }});

            hasLiquids = true;
            outputLiquid = new LiquidStack(黑油, 5f / 60f / 9f);

            // researchCost = with(Items.beryllium, 15);//科技研究资源费用
        }};
        黑油精炼台 = new GenericCrafter("黑油精炼台") {{
            requirements(Category.crafting, with(
                    copper, 30,
                    copper, 25,
                    copper, 12,
                    copper, 40,
                    copper, 20
            ));
            hasItems = true;
            hasPower = true;
            outputItem = new ItemStack(珊绒, 1);
            outputLiquid = new LiquidStack(恐油, 2f / 60f);
            // envEnabled |= Env.space;
            craftTime = 4f * 60f;
            size = 3;
            itemCapacity = 16;
            consumePower(150f / 60f);
            consumeLiquid(黑油, 4f / 60f);
            //consumeItems(with(衬光束, 2, 灵珠, 4, 暗珊绒, 8));
        }};
        夜灵核心融合器 = new GenericCrafter("夜灵核心融合器") {{
            requirements(Category.crafting, with(
                    翠灵晶, 30,
                    混沌晶体, 25,
                    夜灵, 12,
                    缜相织, 40,
                    气光散, 20
            ));
            hasItems = true;
            hasPower = true;
            outputItem = new ItemStack(夜灵核心, 1);
            // envEnabled |= Env.space;
            craftTime = 60f * 8f / T1time;
            size = 3;
            itemCapacity = 16;
            consumePower(650f / 60f);
            consumeItems(with(衬光束, 2, 灵珠, 4, 暗珊绒, 8));
        }};
        珊绒透筛器 = new Separator("珊绒透筛器") {{
            requirements(Category.crafting, with(
                    冥翠块, 25,
                    怨石块, 40,
                    怨气集束, 30,
                    灵魂核心, 10
            ));
            results = with(
                    珊绒, 50,
                    暗珊绒, 1
            );
            itemCapacity = 2;
            hasPower = true;
            craftTime = 7f;
            size = 4;
            consumeItem(珊绒);
            consumePower(90f / 60f);
            consumeLiquid(叮浆, 1f / 60f);
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(), new DrawDefault());
            // drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(), new DrawRegion("-spinner", 3, true), new DrawDefault());
        }};
        珊绒重组器 = new GenericCrafter("珊绒重组器") {{
            requirements(Category.crafting, with(
                    翠灵晶, 30,
                    混沌晶体, 25,
                    灵魂核心, 12,
                    缜相织, 40,
                    气光散, 20
            ));
            hasItems = true;
            hasPower = true;
            outputItem = new ItemStack(暗珊绒, 6);
            craftTime = 60f * 3f;
            size = 3;
            itemCapacity = 24;
            consumePower(1500f / 60f);
            consumeItems(with(珊绒, 12));

        }};
      /*  青羊子收集器 = new GenericCrafter("青羊子收集器") {{//这个工厂要重写
            requirements(Category.crafting, with(
                    翠灵晶, 60,
                    混沌晶体, 35,
                    夜灵核心, 10,
                    魔能晶, 40,
                    灵魂束缚容器, 20
            ));
            hasItems = true;
            hasPower = true;
            outputItem = new ItemStack(青羊子, 1);
            craftTime = 60f * 20f;
            size = 3;
            // consumePower(1500f/60f);
            /// consumeItems(with(珊绒, 12));
        }};*/


        暗物质羽窃器 = new GenericCrafter("暗物质羽窃器") {{
            requirements(Category.crafting, with(
                    翠灵晶, 30,
                    混沌晶体, 32,
                    夜灵珠, 30,
                    缜相织, 70,
                    夜灵核心, 20,
                    微格晶, 10,
                    魔能晶, 50
            ));
            hasItems = true;
            hasPower = true;
            outputItems = ItemStack.with(珊绒, 1, 暗物质, 2);
            craftTime = 60f * 2f;
            size = 4;
            consumePower(4000f / 60f);
            consumeItems(with(青羊子, 3));
        }};


        //电力

        十字能量节点 = new BeamNode("十字能量塔") {{
            size = 1;
            range = 25;
            fogRadius = 3;
            health = 320;
            hasPower = true;
            outputsPower = true;
            consumesPower = true;
            consumePowerBuffered(800);
            buildVisibility = BuildVisibility.shown;
            requirements(Category.power, with(
                    copper, 30,
                    copper, 25,
                    copper, 12,
                    copper, 40,
                    copper, 20
            ));
        }};
        小小能量节点 = new CreatorsPowerField("小小能量塔") {{
            laserRange = 8f;
            consumesPower = true;
            insulated = false;
            health = 80;
            size = 1;
            drawAlphaA = 0.0f;
            drawAlphaB = 1f;
            drawColor = Color.valueOf("000000");
            drawColor2 = Color.valueOf("26ffec");//Team.sharded.color;
            consumePower(10f / 60f);
            buildVisibility = BuildVisibility.shown;
            requirements(Category.power, with(
                    copper, 30,
                    copper, 25,
                    copper, 12,
                    copper, 40,
                    copper, 20
            ));
        }};
        能量节点 = new CreatorsPowerField("能量塔") {{
            laserRange = 15f;
            consumesPower = true;
            insulated = false;
            health = 200;
            size = 2;
            drawAlphaA = 0.0f;
            drawAlphaB = 1f;
            drawColor = Color.valueOf("000000");
            drawColor2 = Color.valueOf("26ffec"); //Team.sharded.color;
            consumePower(10f / 60f);
            buildVisibility = BuildVisibility.shown;
            requirements(Category.power, with(
                    copper, 30,
                    copper, 25,
                    copper, 12,
                    copper, 40,
                    copper, 20
            ));
        }};
        能量收集器 = new Wall("能量收集器") {
            public void setStats() {
                super.setStats();
                stats.add(Stat.basePowerGeneration, 60, StatUnit.powerSecond);
            }

            {
                health = 120;
                size = 3;
                conductivePower = true;//可以导电
                hasPower = true;
                consumesPower = false;
                outputsPower = true;
                buildType = () -> new Building() {
                    public float getPowerProduction() {
                        return 1.0f;
                    }
                };
                buildVisibility = BuildVisibility.shown;
                requirements(Category.power, with(
                        copper, 30,
                        copper, 25,
                        copper, 12,
                        copper, 40,
                        copper, 20
                ));
            }
        };

        能量发生器 = new ConsumeGenerator("能量发生器") {{
            requirements(Category.power, with(
                    copper, 30,
                    copper, 25,
                    copper, 12,
                    copper, 40,
                    copper, 20
            ));
            consumeLiquid(灵液, 0.15f);
            itemDuration = 100;
            size = 4;
            itemCapacity = 5;
            powerProduction = 300 / 60f;
            consume(new ConsumeItemFlammable());
            // consumeItems(with(冥翠, 6,赤焰膏精,6,缜相织,1));
        }};

        能源储蓄块制造器 = new GenericCrafter("能源储蓄块制造器") {{
            requirements(Category.power, with(
                    copper, 30,
                    copper, 25,
                    copper, 12,
                    copper, 40,
                    copper, 20
            ));
            outputItem = new ItemStack(空电池, 1);
            craftTime = 60f * 3f;
            size = 3;
            itemCapacity = 20;
            consumePower(1500f / 60f);
            consumeItems(with(冥翠, 6, 赤焰膏精, 6, 缜相织, 1));
        }};
        充能器 = new GenericCrafter("充能器") {{
            requirements(Category.power, with(
                    copper, 30,
                    copper, 25,
                    copper, 12,
                    copper, 40,
                    copper, 20
            ));
            outputItem = new ItemStack(满电池, 1);
            craftTime = 60f * 5f;
            size = 3;
            itemCapacity = 20;
            consumePower(500f / 60f);
            consumeItems(with(空电池, 1, 一级燃魂集, 1));
        }};
        能源释放器 = new CreatorsMultiCrafter("能源释放器", 1) {{//发电数值没算好
            requirements(Category.power, with(
                    copper, 30,
                    copper, 25,
                    copper, 12,
                    copper, 40,
                    copper, 20
            ));
            size = 3;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 1;
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(满电池, 1), 0),
                    new CreatorsRecipe.OutputContents(ItemStack.with(空电池, 1), (2000f / 60f + 0.0001f)), 60f * 2f
            );
        }};

//运输物流
        单位装载器1 = new UnitCargoLoader("单位装载器1") {{
            requirements(Category.distribution, with(Items.silicon, 80, Items.surgeAlloy, 50));
            unitType = 运输1;
            size = 3;
            buildTime = 60f * 8f;

            consumePower(8f / 60f);


            //consumeLiquid(Liquids.nitrogen, 10f / 60f);

            itemCapacity = 250;
            researchCost = with(Items.silicon, 2500, Items.surgeAlloy, 20);
        }};
        单位装载器2 = new UnitCargoLoader("单位装载器2") {{
            requirements(Category.distribution, with(Items.silicon, 80, Items.surgeAlloy, 50));
            unitType = 运输2;
            size = 2;
            buildTime = 60f * 4f;

            consumePower(8f / 60f);


            //consumeLiquid(Liquids.nitrogen, 10f / 60f);

            itemCapacity = 600;
            researchCost = with(Items.silicon, 2500, Items.surgeAlloy, 20);
        }};
        单位装载器3 = new UnitCargoLoader("单位装载器3") {{
            requirements(Category.distribution, with(Items.silicon, 80, Items.surgeAlloy, 50));
            unitType = 运输3;
            size = 1;
            buildTime = 60f * 2f;

            consumePower(8f / 60f);


            //consumeLiquid(Liquids.nitrogen, 10f / 60f);

            itemCapacity = 1000;
            researchCost = with(Items.silicon, 2500, Items.surgeAlloy, 20);
        }};
        单位卸载器 = new UnitCargoUnloadPoint("unit-cargo-unload-point") {{
            requirements(Category.distribution, with(Items.silicon, 60));

            size = 1;

            itemCapacity = 100;

            researchCost = with(Items.silicon, 3000);
        }};

        锁定 = new GenericCrafter("锁定");
//
        //物流
        传送带2 = new Conveyor("duct2") {
            {
                requirements(Category.distribution, with(Items.silicon, 1));
                health = 90;
                speed = 0.1f;
                displayedSpeed = 12f;
                // researchCost = with(Items.silicon, 5);//研究成本
            }

            @Override
            public void init() {
                super.init();

                junctionReplacement = CTjunction;
                bridgeReplacement = 传送桥;
            }
        };
        Armored传送带2 = new ArmoredConveyor("armoredduct2") {
            {
                requirements(Category.distribution, with(Items.silicon, 1));
                health = 90;
                speed = 0.1f;
                displayedSpeed = 12f;
                // researchCost = with(Items.silicon, 5);//研究成本
            }

            @Override
            public void init() {
                super.init();

                junctionReplacement = CTjunction;
                bridgeReplacement = 传送桥;
            }
        };

        传送带 = new Conveyor("duct") {
            {
                requirements(Category.distribution, with(Items.silicon, 1));
                health = 100;
                speed = 0.3f;
                displayedSpeed = 30f;
                // researchCost = with(Items.silicon, 5);//研究成本
            }

            @Override
            public void init() {
                super.init();

                junctionReplacement = CTjunction;
                bridgeReplacement = 传送桥;
            }
        };
        Armored传送带 = new ArmoredConveyor("armoredduct") {
            {
                requirements(Category.distribution, with(Items.silicon, 1));
                health = 100;
                speed = 0.3f;
                displayedSpeed = 30f;
                // researchCost = with(Items.silicon, 5);//研究成本
            }

            @Override
            public void init() {
                super.init();

                junctionReplacement = CTjunction;
                bridgeReplacement = 传送桥;
            }
        };
        CTjunction = new Junction("连接器") {{//连接器
            requirements(Category.distribution, with(Items.copper, 2));
            speed = 26;
            capacity = 6;
            health = 30;
            solid = false;
            //buildCostMultiplier = 6f;
        }};
        //路由器
        CTsorter = new DuctRouter("路由器") {{
            requirements(Category.distribution, with(Items.copper, 10));
            health = 90;
            speed = 1f;
            regionRotated1 = 1;
            solid = false;
        }};
        //分类器
        分类器2 = new Sorter("分类器") {{
            requirements(Category.distribution, with(Items.lead, 2, Items.copper, 2));
            buildCostMultiplier = 3f;
        }};
        //反向分类器
        反向分类器2 = new Sorter("反向分类器") {{
            requirements(Category.distribution, with(Items.lead, 2, Items.copper, 2));
            buildCostMultiplier = 3f;
            invert = true;
        }};
        //溢流门
        溢流门2 = new OverflowGate("溢流门") {{
            requirements(Category.distribution, with(Items.lead, 2, Items.copper, 4));
            buildCostMultiplier = 3f;
        }};
        //反向溢流门
        反向溢流门2 = new OverflowGate("反向溢流门") {{
            requirements(Category.distribution, with(Items.lead, 2, Items.copper, 4));
            buildCostMultiplier = 3f;
            invert = true;
        }};
        //传送桥
        传送桥 = new ItemBridge("传送桥") {{
            requirements(Category.distribution, with(Items.phaseFabric, 5, Items.silicon, 7, Items.lead, 10, Items.graphite, 10));
            range = 8;
            arrowPeriod = 0.9f;
            arrowTimeScl = 2.75f;
            hasPower = true;
            pulse = true;
            envEnabled |= Env.space;
            // consumePower(0.30f);
        }};

        //辉阳传送带
        辉阳传送带 = new StackConveyor("辉阳传送带") {{
            requirements(Category.distribution, with(Items.plastanium, 1, Items.silicon, 1, Items.graphite, 1));
            health = 75;
            speed = 4f / 60f;
            itemCapacity = 10;
        }};

        //辉阳路由器

        辉阳路由器 = new StackRouter("辉阳路由器") {{
            requirements(Category.distribution, with(Items.surgeAlloy, 5, Items.copper, 1));
            health = 130;
            speed = 6f;
            hasPower = true;
            consumesPower = true;
            conductivePower = true;
            baseEfficiency = 1f;
            underBullets = true;
            solid = false;
            consumePower(3f / 60f);
        }};


    }


    private static void initUnitBlock() {
        T1Unit = new UnitFactory("T1Unit-factory") {{
            requirements(Category.units, with(Items.copper, 150, Items.lead, 130, Items.metaglass, 120));
            plans = Seq.with(
                    new UnitPlan(空军1, 60f * 3, with(Items.silicon, 20, Items.metaglass, 35)),
                    new UnitPlan(蜘蛛1, 60f * 4, with(Items.silicon, 15, Items.metaglass, 25, Items.titanium, 20)),
                    new UnitPlan(坦克1, 60f * 5, with(Items.silicon, 15, Items.metaglass, 25, Items.titanium, 20))
            );
            size = 3;
            consumePower(1.2f);
            floating = true;
            solid = false;
            //   teamPassable= false;//队伍碰撞
            //  underBullets =false;//子弹碰撞。false为可以被碰撞
        }};
        T2Unit = new UnitFactory("T2Unit-factory") {{
            requirements(Category.units, with(
                    Items.copper, 150,
                    Items.lead, 130,
                    Items.metaglass, 120
            ));
            plans = Seq.with(
                    new UnitPlan(空军2, 60f * 3, with(Items.silicon, 20, Items.metaglass, 35)),
                    new UnitPlan(蜘蛛2, 60f * 4, with(Items.silicon, 15, Items.metaglass, 25, Items.titanium, 20)),
                    new UnitPlan(坦克2, 60f * 5, with(Items.silicon, 15, Items.metaglass, 25, Items.titanium, 20))
            );
            size = 5;
            consumePower(1.2f);
            floating = true;
            solid = false;

        }};
        T3Unit = new UnitFactory("T3Unit-factory") {{
            requirements(Category.units, with(
                    Items.copper, 150,
                    Items.lead, 130,
                    Items.metaglass, 120
            ));
            plans = Seq.with(
                    new UnitPlan(空军3, 60f * 3, with(Items.silicon, 20, Items.metaglass, 35)),
                    new UnitPlan(蜘蛛3, 60f * 4, with(Items.silicon, 15, Items.metaglass, 25, Items.titanium, 20)),
                    new UnitPlan(坦克3, 60f * 5, with(Items.silicon, 15, Items.metaglass, 25, Items.titanium, 20))
            );
            size = 7;
            consumePower(1.2f);
            floating = true;
            solid = false;
        }};
        T4Unit = new UnitFactory("T4Unit-factory") {{
            requirements(Category.units, with(
                    Items.copper, 150,
                    Items.lead, 130,
                    Items.metaglass, 120
            ));
            plans = Seq.with(
                    new UnitPlan(空军4, 60f * 3, with(Items.silicon, 20, Items.metaglass, 35)),
                    new UnitPlan(蜘蛛4, 60f * 4, with(Items.silicon, 15, Items.metaglass, 25, Items.titanium, 20)),
                    new UnitPlan(坦克4, 60f * 5, with(Items.silicon, 15, Items.metaglass, 25, Items.titanium, 20))
            );
            size = 9;
            consumePower(1.2f);
            floating = true;
            solid = false;
        }};
        T5Unit = new UnitFactory("T5Unit-factory") {{
            requirements(Category.units, with(
                    Items.copper, 150,
                    Items.lead, 130,
                    Items.metaglass, 120
            ));
            plans = Seq.with(
                    new UnitPlan(空军5, 60f * 3, with(Items.silicon, 20, Items.metaglass, 35)),
                    new UnitPlan(蜘蛛5, 60f * 4, with(Items.silicon, 15, Items.metaglass, 25, Items.titanium, 20)),
                    new UnitPlan(坦克5, 60f * 5, with(Items.silicon, 15, Items.metaglass, 25, Items.titanium, 20))
            );
            size = 9;
            consumePower(1.2f);
            floating = true;
            solid = false;
        }};

        ///////////////////////////////////////////////////
        T1hai = new UnitFactory("T1hai-factory") {{
            requirements(Category.units, with(
                    Items.copper, 150,
                    Items.lead, 130,
                    Items.metaglass, 120
            ));
            plans = Seq.with(
                    new UnitPlan(海辅1, 60f * 3, with(Items.silicon, 20, Items.metaglass, 35))
            );
            size = 3;
            consumePower(1.2f);
            floating = true; //solid = false;
        }};
        T2hai = new UnitFactory("T2hai-factory") {{
            requirements(Category.units, with(
                    Items.copper, 150,
                    Items.lead, 130,
                    Items.metaglass, 120
            ));
            plans = Seq.with(
                    new UnitPlan(海辅2, 60f * 3, with(Items.silicon, 20, Items.metaglass, 35))
            );
            size = 5;
            consumePower(1.2f);
            floating = true; //solid = false;
        }};
        T3hai = new UnitFactory("T3hai-factory") {{
            requirements(Category.units, with(
                    Items.copper, 150,
                    Items.lead, 130,
                    Items.metaglass, 120
            ));
            plans = Seq.with(
                    new UnitPlan(海辅3, 60f * 3, with(Items.silicon, 20, Items.metaglass, 35))
            );
            size = 7;
            consumePower(1.2f);
            floating = true; //solid = false;
        }};
        T4hai = new UnitFactory("T4hai-factory") {{
            requirements(Category.units, with(
                    Items.copper, 150,
                    Items.lead, 130,
                    Items.metaglass, 120
            ));
            plans = Seq.with(
                    new UnitPlan(海辅4, 60f * 3, with(Items.silicon, 20, Items.metaglass, 35))
            );
            size = 9;
            consumePower(1.2f);
            floating = true; //solid = false;
        }};
        T5hai = new UnitFactory("T5hai-factory") {{
            requirements(Category.units, with(
                    Items.copper, 150,
                    Items.lead, 130,
                    Items.metaglass, 120
            ));
            plans = Seq.with(
                    new UnitPlan(海辅5, 60f * 3, with(Items.silicon, 20, Items.metaglass, 35))
            );
            size = 11;
            consumePower(1.2f);
            floating = true; //solid = false;
        }};

        //////////////////////////////////////////////
        //盾兵
        T2FU = new UnitFactory("T2FU-factory") {{
            requirements(Category.units, with(
                    Items.copper, 150,
                    Items.lead, 130,
                    Items.metaglass, 120
            ));
            plans = Seq.with(
                    new UnitPlan(T2盾牌单位, 60f * 3, with(Items.silicon, 20, Items.metaglass, 35))
            );
            size = 3;
            consumePower(1.2f);
            floating = true;
            solid = false;
        }};
        T3FU = new UnitFactory("T3FU-factory") {{
            requirements(Category.units, with(
                    Items.copper, 150,
                    Items.lead, 130,
                    Items.metaglass, 120
            ));
            plans = Seq.with(
                    new UnitPlan(T3盾牌单位, 60f * 3, with(Items.silicon, 20, Items.metaglass, 35))
            );
            size = 5;
            consumePower(1.2f);
            floating = true;
            solid = false;
        }};
        T4FU = new UnitFactory("T4FU-factory") {{
            requirements(Category.units, with(
                    Items.copper, 150,
                    Items.lead, 130,
                    Items.metaglass, 120
            ));
            plans = Seq.with(
                    new UnitPlan(T4盾牌单位, 60f * 3, with(Items.silicon, 20, Items.metaglass, 35))
            );
            size = 7;
            consumePower(1.2f);
            floating = true;
            solid = false;
        }};
        T5FU = new UnitFactory("T5FU-factory") {{
            requirements(Category.units, with(
                    Items.copper, 150,
                    Items.lead, 130,
                    Items.metaglass, 120
            ));
            plans = Seq.with(
                    new UnitPlan(T5盾牌单位, 60f * 3, with(Items.silicon, 20, Items.metaglass, 35))
            );
            size = 9;
            consumePower(1.2f);
            floating = true;
            solid = false;
        }};
        kuangjiUnit = new UnitFactory("kuangji-factory") {{
            requirements(Category.units, with(
                    Items.copper, 150,
                    Items.lead, 130,
                    Items.metaglass, 120
            ));
            plans = Seq.with(
                    new UnitPlan(kuangji1, 60f * 3, with())
            );

            size = 2;
            consumePower(1.2f);
            floating = true;
            solid = false;
        }};
        //////////////////////////////////////////////////
//运输->输入
        yunshu_shengcheng = new UnitCargoLoader("yunshuunit") {{
            requirements(Category.distribution, with(Items.silicon, 80, Items.surgeAlloy, 50));

            size = 2;
            unitType = 运输1;
            buildTime = 60f * 5f;
            polyColor = Pal.accent;
            polyStroke = 1.8f;
            polyRadius = 4f;
            polySides = 3;
            consumePower(8f / 60f);
            consumeLiquid(Liquids.oil, 10f / 60f);
            itemCapacity = 500;
            researchCost = with(Items.silicon, 2500, Items.surgeAlloy, 20);
        }};
        //->输出
        yunshu_jiesou = new UnitCargoUnloadPoint("yunshu_jiesouunit") {{
            requirements(Category.distribution, with(Items.silicon, 60, Items.surgeAlloy, 60));
            size = 1;
            itemCapacity = 250;
            researchCost = with(Items.silicon, 3000, Items.surgeAlloy, 20);
        }};


        Events.on(EventType.ContentInitEvent.class, e -> {
            T1Unit.removeBar("units");
        });
        Events.on(EventType.ContentInitEvent.class, e -> {
            T2Unit.removeBar("units");
        });
        Events.on(EventType.ContentInitEvent.class, e -> {
            T3Unit.removeBar("units");
        });
        Events.on(EventType.ContentInitEvent.class, e -> {
            T4Unit.removeBar("units");
        });
        Events.on(EventType.ContentInitEvent.class, e -> {
            T5Unit.removeBar("units");
        });
        Events.on(EventType.ContentInitEvent.class, e -> {
            T1hai.removeBar("units");
        });
        Events.on(EventType.ContentInitEvent.class, e -> {
            T2hai.removeBar("units");
        });
        Events.on(EventType.ContentInitEvent.class, e -> {
            T3hai.removeBar("units");
        });
        Events.on(EventType.ContentInitEvent.class, e -> {
            T4hai.removeBar("units");
        });
        Events.on(EventType.ContentInitEvent.class, e -> {
            T5hai.removeBar("units");
        });
        Events.on(EventType.ContentInitEvent.class, e -> {
            T2FU.removeBar("units");
        });
        Events.on(EventType.ContentInitEvent.class, e -> {
            T3FU.removeBar("units");
        });
        Events.on(EventType.ContentInitEvent.class, e -> {
            T4FU.removeBar("units");
        });
        Events.on(EventType.ContentInitEvent.class, e -> {
            T5FU.removeBar("units");
        });
        Events.on(EventType.ContentInitEvent.class, e -> {
            kuangjiUnit.removeBar("units");
        });

    }
}
