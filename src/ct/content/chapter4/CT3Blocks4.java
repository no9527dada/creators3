package ct.content.chapter4;

import arc.graphics.Color;
import ct.Asystem.type.CreatorsPowerField;
import ct.Asystem.type.MultiCrafter.CT3_MultiCrafter;
import ct.Asystem.type.MultiCrafter.CreatorsRecipe;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.gen.Building;
import mindustry.gen.Sounds;
import mindustry.graphics.CacheLayer;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
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
import mindustry.world.blocks.units.UnitCargoLoader;
import mindustry.world.blocks.units.UnitCargoUnloadPoint;
import mindustry.world.consumers.ConsumeItemFlammable;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawLiquidTile;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;
import mindustry.world.meta.*;


import static ct.content.CTAttributes.Vent;
import static ct.content.Floors.m;
import static ct.content.chapter4.CT3Item4.*;
import static ct.content.chapter4.CTR3Unit4.*;
import static mindustry.content.Blocks.*;
import static mindustry.content.Items.*;
import static mindustry.type.ItemStack.with;

public class CT3Blocks4 {
    public static float T0time = 60f * 3f;
    public static float T1time = 60f / 1f;
    public static float T2time = 60f / 1.5f;
    public static float T3time = 60f / 2.8f;
    public static float p0t = 0f;
    public static float p1t = 1 / 60f;
    public static float p2t = 3 / 60f;
    public static float p3t = 6 / 60f;


    public static Block
            //地板：
            冥矿, 魂矿, 冤藤矿, 魔力石, 赤焰石矿, 戾气赤焰石墙矿, 气丝晶体墙矿, 灵石矿, 怨石矿, 烟冰矿, 沉石矿, 微晶石矿, 硅晶矿,
            灵液地板, 黑油地板, 黑油喷口, 叹酸地板, 叮浆地板,
    //墙壁
    墙壁,
    //工厂：
    油泵, 黑油精炼台, 夜灵核心融合器, 珊绒透筛器, 珊绒重组器, 暗物质羽窃器,

    //电力
    十字能量节点, 小小能量节点, 能量节点, 能量收集器, 能量发生器,
            能源储蓄块制造器, 充能器, 能源释放器,
    //物流
    传送带2, Armored传送带2, 传送带, Armored传送带, 连接器4, 路由器4,
            分类器4, 反向分类器4, 溢流门4, 反向溢流门4, 传送桥4, 辉阳传送带,
            辉阳路由器,
            单位装载器1, 单位装载器2, 单位装载器3, 单位卸载器;


    public static void load() {


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
            attributes.set(Vent, 1f);//地形限制与加成
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


        ItemsSMChunJu.load();//魂矩器
        ItemsSMCyeLian.load();//资源冶炼器
        ItemsSMC.load();//资源合成台
        //ItemsSMCjingLian.load();//精炼台 有问题 要修
        ItemsSMChuaGong.load();//  资源炼化器


        油泵 = new ThermalGenerator("油泵") {{
            requirements(Category.power, with(copper, 30));
            size = 3;
            attribute = Vent;//地形限制与加成

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
            //consumeLiquid(灵液4, 0.15f);//这里需要改发电机的type，地热类没有液体输入。或许可以改温差+地形限制，下次看到再改
            itemDuration = 100;
            size = 4;
            itemCapacity = 5;
            powerProduction = 300 / 60f;
            consume(new ConsumeItemFlammable());
            consumeItems(with(/*冥翠, 6,赤焰膏精,6,缜相织,1*/));
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
        能源释放器 = new CT3_MultiCrafter("能源释放器", 1) {{//发电数值没算好
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


//
        //物流

        传送带 = new Conveyor("传送带") {
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

                junctionReplacement = 连接器4;
                bridgeReplacement = 传送桥4;
            }
        };
        Armored传送带 = new ArmoredConveyor("Armored传送带") {
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

                junctionReplacement = 连接器4;
                bridgeReplacement = 传送桥4;
            }
        };
        传送带2 = new Conveyor("传送带2") {
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

                junctionReplacement = 连接器4;
                bridgeReplacement = 传送桥4;
            }
        };
        Armored传送带2 = new ArmoredConveyor("Armored传送带2") {
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

                junctionReplacement = 连接器4;
                bridgeReplacement = 传送桥4;
            }
        };

        连接器4 = new Junction("连接器4") {{//连接器4
            requirements(Category.distribution, with(Items.copper, 2));
            speed = 26;
            capacity = 6;
            health = 30;
            solid = false;
            //buildCostMultiplier = 6f;
        }};
        //路由器4
        路由器4 = new DuctRouter("路由器4") {{
            requirements(Category.distribution, with(Items.copper, 10));
            health = 90;
            speed = 1f;
            regionRotated1 = 1;
            solid = false;
        }};
        //分类器4
        分类器4 = new Sorter("分类器4") {{
            requirements(Category.distribution, with(Items.lead, 2, Items.copper, 2));
            buildCostMultiplier = 3f;
        }};
        //反向分类器4
        反向分类器4 = new Sorter("反向分类器4") {{
            requirements(Category.distribution, with(Items.lead, 2, Items.copper, 2));
            buildCostMultiplier = 3f;
            invert = true;
        }};
        //溢流门4
        溢流门4 = new OverflowGate("溢流门4") {{
            requirements(Category.distribution, with(Items.lead, 2, Items.copper, 4));
            buildCostMultiplier = 3f;
        }};
        //反向溢流门4
        反向溢流门4 = new OverflowGate("反向溢流门4") {{
            requirements(Category.distribution, with(Items.lead, 2, Items.copper, 4));
            buildCostMultiplier = 3f;
            invert = true;
        }};
        //传送桥4
        传送桥4 = new ItemBridge("传送桥4") {{
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
}
