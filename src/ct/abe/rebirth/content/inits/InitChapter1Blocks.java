package ct.abe.rebirth.content.inits;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.math.Mathf;
import ct.abe.CTDrawMultiWeave;
import ct.abe.rebirth.blocks.productions.CTBurstDrill;
import mindustry.content.Fx;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.effect.MultiEffect;
import mindustry.gen.Building;
import mindustry.gen.Sounds;
import mindustry.graphics.CacheLayer;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.BuildTurret;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.environment.StaticWall;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.power.BeamNode;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.power.ThermalGenerator;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.consumers.ConsumeItemRadioactive;
import mindustry.world.draw.*;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.BuildVisibility;

import static ct.abe.Evn2.标志1;
import static ct.abe.rebirth.content.Blocks.*;
import static ct.abe.rebirth.content.Items.*;
import static ct.abe.rebirth.meta.地形加成.灵力收集;
import static mindustry.gen.Sounds.respawning;
import static mindustry.type.Category.crafting;
import static mindustry.type.Category.power;
import static mindustry.type.ItemStack.with;
import static mindustry.world.meta.BlockGroup.transportation;

/*
 * 章节一数据
 */
public class InitChapter1Blocks {
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
        //初始化方块
        initBlock();
        //初始化钻头
        initDrills();
        //初始化墙
        initWalls();
        //初始化物流块
        initLogistical();
    }


    private static void initBlock() {
        灵脉地板 = new Floor("灵脉地板") {{
            //  dragMultiplier = 0.35f;
            //  speedMultiplier = 0.9f;
            // albedo = 0.65f;
            localizedName = Core.bundle.get("Floor.lingmai");
            variants = 3;
            attributes.set(灵力收集, 2.25f);
            emitLight = true;
            lightRadius = 40f;
            lightColor = Color.valueOf("5313ba").a(0.15f);
        }};
        发光地板 = new Floor("发光地板") {{
            //  dragMultiplier = 0.35f;
            //  speedMultiplier = 0.9f;
            // albedo = 0.65f;
            localizedName = Core.bundle.get("Floor.guang");
            variants = 1;
            // attributes.set(灵力收集, 2.25f);
            emitLight = true;
            lightRadius = 70 * 8f;
            lightColor = Color.valueOf("8cfffa").a(0.7f);
        }};

        灵液地板 = new Floor("灵液地板") {{
            localizedName = Core.bundle.get("Floor.lingye");
            speedMultiplier = 0.5f;
            variants = 9;
            status = StatusEffects.wet;//在上面单位能加血
            statusDuration = 90f;
            liquidDrop = 灵液;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;
            emitLight = true;
            lightRadius = 20;
            lightColor = Color.valueOf("63e2ff").a(0.3f);
        }};

        幻液地板 = new Floor("幻液地板") {{
            localizedName = Core.bundle.get("Floor.huanye");
            speedMultiplier = 0.5f;
            variants = 3;
            status = StatusEffects.wet;//在上面单位能加攻速
            statusDuration = 90f;
            liquidDrop = 幻液;
            isLiquid = true;
            // cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            cacheLayer = m;
            supportsOverlay = true;
            emitLight = true;
            lightRadius = 20;
            lightColor = Color.valueOf("96feb4").a(0.3f);
        }};


        ///*/*//*/*/
        翠矿 = new OreBlock("翠矿", 翠) {{
            localizedName = Core.bundle.get("OreBlock.cuikuang");
            oreDefault = true;
            variants = 6;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};
        陶矿 = new OreBlock("陶矿", 陶) {{
            localizedName = Core.bundle.get("OreBlock.taokuang");
            oreDefault = true;
            variants = 6;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};
        月银沙地板 = new Floor("ore月银沙") {{
            localizedName = Core.bundle.get("items.yueyinsha");
            itemDrop = 月银沙;
            playerUnmineable = true;
            variants = 4;
            // attributes.set(Attribute.oil, 0.7f);
        }};
        余烬矿 = new OreBlock("余烬矿", 余烬) {{
            localizedName = Core.bundle.get("OreBlock.yujingkuang");
            oreDefault = true;
            oreThreshold = 0.846f;
            oreScale = 24.428572f;
        }};
        缕矿 = new OreBlock("缕矿", 缕) {{
            localizedName = Core.bundle.get("OreBlock.lvkuang");
            oreDefault = true;
            variants = 6;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
            emitLight = true;
            lightRadius = 13f;
            lightColor = Color.orange.cpy();
            // lightColor = 缕.color.a(0.3f);

        }};
        离矿 = new OreBlock("离矿", 离) {{
            localizedName = Core.bundle.get("OreBlock.likuang");
            oreDefault = true;
            variants = 4;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};
        血晶石矿 = new OreBlock("血晶石矿", 血晶) {{
            localizedName = Core.bundle.get("OreBlock.xuejingshikuang");
            oreDefault = true;
            variants = 6;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};
        灵玉石矿 = new StaticWall("灵玉石矿") {{
            localizedName = Core.bundle.get("OreBlock.lingyu");
            itemDrop = 灵玉;//直接墙壁矿
            variants = 4;
        }};

        幻烬炼宝器 = new GenericCrafter("幻烬炼宝器") {{
            localizedName = Core.bundle.get("block.huanjing");
            description = Core.bundle.getOrNull("block.description.null");
            consumeItems(with(余烬, 2
            ));
            //consumeLiquid(Liquids.water, 0.1f);
            consumePower(60 / 60f);
            outputItem = new ItemStack(幻烬, 1);
            health = 160;
            itemCapacity = 10;
            size = 2;
            craftTime = 80;
            // craftEffect = fireballsmoke;
            // updateEffect = plasticExplosion;
            updateEffectChance = 0.1F;
            group = transportation;
            requirements(crafting, with(
                    翠, 75,
                    陶, 45
            ));
            drawer = new DrawMulti(new DrawDefault(),
                    new DrawFlame() {
                        {
                        }

                        public void load(Block block) {
                            top = Core.atlas.find(幻烬炼宝器.name + "-top");
                        }

                        public void draw(Building build) {
                            if (build.warmup() > 0.0F && this.flameColor.a > 0.001F) {
                                Draw.z(30.01F);
                                Draw.alpha(build.warmup());
                                Draw.rect(top, build.x, build.y);
                            }
                        }
                    }
            );
        }};
        幻烬聚宝炉 = new GenericCrafter("幻烬聚宝炉") {{//二阶段工厂
            localizedName = Core.bundle.get("block.huanjing2");
            description = Core.bundle.getOrNull("block.description.null");
            consumeItems(with(余烬, 5
            ));
            consumeLiquid(灵液, 0.1f);
            consumePower(240 / 60f);
            outputItem = new ItemStack(幻烬, 3);
            health = 160;
            itemCapacity = 20;
            size = 3;
            craftTime = 40;
            // craftEffect = fireballsmoke;
            // updateEffect = plasticExplosion;
            updateEffectChance = 0.1F;
            group = transportation;
            requirements(crafting, with(
                    幻烬, 60,
                    翠, 50,
                    陶, 70,
                    缕, 120
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};
        运符炼宝器 = new GenericCrafter("运符炼宝器") {{
            localizedName = Core.bundle.get("block.yunfu");
            description = Core.bundle.getOrNull("block.description.null");
            consumeItems(with(翠, 2, 陶, 2
            ));
            //consumeLiquid(Liquids.water, 0.1f);
            consumePower(90 / 60f);
            outputItem = new ItemStack(运符, 3);
            health = 150;
            itemCapacity = 10;
            size = 2;
            craftTime = 50;
            // craftEffect = fireballsmoke;
            // updateEffect = plasticExplosion;
            group = transportation;
//            ambientSound = respawning;
//            ambientSoundVolume = 0.5f;
            requirements(crafting, with(
                    幻烬, 10,
                    翠, 40,
                    陶, 35
            ));
            drawer = new DrawMulti(new DrawDefault(),
                    new DrawFlame() {
                        {
                        }

                        public void load(Block block) {
                            top = Core.atlas.find(运符炼宝器.name + "-top");
                        }

                        public void draw(Building build) {
                            if (build.warmup() > 0.0F && this.flameColor.a > 0.001F) {
                                Draw.z(30.01F);
                                Draw.alpha(build.warmup());
                                Draw.rect(top, build.x, build.y);
                            }
                        }
                    });
        }};
        灵玉炼宝器 = new GenericCrafter("灵玉炼宝器") {{
            localizedName = Core.bundle.get("block.lingyu");
            description = Core.bundle.getOrNull("block.description.null");
            consumeItems(with(余烬, 2, 运符, 1
            ));
            //consumeLiquid(Liquids.water, 0.1f);
            consumePower(90 / 60f);
            outputItem = new ItemStack(灵玉, 1);
            health = 160;
            itemCapacity = 10;
            size = 2;
            craftTime = 110;
            // craftEffect = fireballsmoke;
            // updateEffect = plasticExplosion;
            //updateEffectChance = 0.1F;
            group = transportation;
            requirements(crafting, with(
                    翠, 75,
                    陶, 45,
                    运符, 20
            ));
            drawer = new DrawMulti(new DrawDefault(),
                    new DrawFlame() {
                        {
                        }

                        public void load(Block block) {
                            top = Core.atlas.find(灵玉炼宝器.name + "-top");
                        }

                        public void draw(Building build) {
                            if (build.warmup() > 0.0F && this.flameColor.a > 0.001F) {
                                Draw.z(30.01F);
                                Draw.alpha(build.warmup());
                                Draw.rect(top, build.x, build.y);
                            }
                        }
                    }
/*            new DrawSpikes(){{//外部贴图旋转
                color = Color.valueOf("ffd59e");
                stroke = 1.5f;
                layers = 2;
                amount = 12;
                rotateSpeed = 0.5f;
                layerSpeed = -0.9f;
            }};*/
            );
        }};
        灵玉炼宝炉 = new GenericCrafter("灵玉炼宝炉") {{
            localizedName = Core.bundle.get("block.lingyu2");
            description = Core.bundle.getOrNull("block.description.null");
            consumeItems(with(余烬, 3, 运符, 3
            ));
            consumeLiquid(灵液, 0.1f);
            consumePower(160 / 60f);
            outputItem = new ItemStack(灵玉, 4);
            health = 160;
            itemCapacity = 10;
            size = 3;
            craftTime = 50;
            // craftEffect = fireballsmoke;
            // updateEffect = plasticExplosion;
            //updateEffectChance = 0.1F;
            group = transportation;
            requirements(crafting, with(
                    血晶, 50,
                    陶, 45,
                    灵玉, 30,
                    明宝, 80
            ));
            drawer = new DrawMulti(new DrawDefault(),
                    new DrawFlame() {
                        {
                        }

                        public void load(Block block) {
                            top = Core.atlas.find(灵玉炼宝炉.name + "-top");
                        }

                        public void draw(Building build) {
                            if (build.warmup() > 0.0F && this.flameColor.a > 0.001F) {
                                Draw.z(30.01F);
                                Draw.alpha(build.warmup());
                                Draw.rect(top, build.x, build.y);
                            }
                        }
                    }
/*            new DrawSpikes(){{//外部贴图旋转
                color = Color.valueOf("ffd59e");
                stroke = 1.5f;
                layers = 2;
                amount = 12;
                rotateSpeed = 0.5f;
                layerSpeed = -0.9f;
            }};*/
            );
        }};
        幻液炼制炉 = new GenericCrafter("幻液炼制炉") {{
            localizedName = Core.bundle.get("block.huanye");
            description = Core.bundle.getOrNull("block.description.null");
            outputLiquid = new LiquidStack(幻液, 12f / 60f);
            size = 3;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            rotate = false;
            solid = true;
            outputsLiquid = true;
            // envEnabled = Env.any;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(幻液) {{
                drawLiquidLight = true;
            }}, new DrawDefault());
            liquidCapacity = 24f;
            craftTime = 60;
            lightLiquid = Liquids.cryofluid;
            group = transportation;
            requirements(crafting, with(
                    缕, 40,
                    威灵, 20,
                    陶, 75
            ));
            consumePower(90 / 60f);
            consumeItem(运符, 1);
            // consumeLiquid(Liquids.water, 12f / 60f);
        }};
        资源炼化器 = new Separator("资源炼化器") {{
            localizedName = Core.bundle.get("block.ziyuan");

            requirements(Category.crafting, with(陶, 30, 缕, 25));
            results = with(
                    陶, 100,
                    翠, 100,
                    月银沙, 80,
                    余烬, 50,
                    缕, 20
            );
            hasPower = true;
            craftTime = 20f;
            size = 2;
            consumePower(70 / 60f);
            consumeLiquid(幻液, 4f / 60f);
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(), new DrawRegion("-spinner", 3, true), new DrawDefault());
        }};
        资源炼化炉 = new Separator("资源炼化炉") {{
            localizedName = Core.bundle.get("block.ziyuan2");
            description = Core.bundle.getOrNull("block.description.ziyuan2");
            requirements(Category.crafting, with(陶, 120, 离, 80, 明宝, 30));
            results = with(
                    月银沙, 100

            );
            hasPower = true;
            craftTime = 10f;
            size = 4;
            consumePower(70 / 60f);
            consumeLiquid(幻液, 2f / 60f);
            consumeItem(运符, 2);
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(), new DrawRegion("-spinner", 3, true), new DrawDefault());
        }};


        灵液炼制炉 = new GenericCrafter("灵液炼制炉") {{
            localizedName = Core.bundle.get("block.lingye");
            description = Core.bundle.getOrNull("block.description.null");
            outputLiquid = new LiquidStack(灵液, 12f / 60f);
            size = 3;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            rotate = false;
            solid = true;
            outputsLiquid = true;
            // envEnabled = Env.any;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.water), new DrawLiquidTile(灵液) {{
                drawLiquidLight = true;
            }}, new DrawDefault());
            liquidCapacity = 24f;
            craftTime = 60;
            lightLiquid = Liquids.cryofluid;
            group = transportation;
            researchCostMultiplier = 4f;//科技树中的研究资源倍率
            requirements(crafting, with(
                    缕, 35,
                    翠, 45,
                    陶, 55
            ));
            consumePower(90 / 60f);
            consumeItem(翠, 2);
            consumeLiquid(Liquids.water, 12f / 60f);
        }};
        威灵炼宝器 = new GenericCrafter("威灵炼宝器") {{
            localizedName = Core.bundle.get("block.weiling");
            description = Core.bundle.getOrNull("block.description.null");
            consumeItems(with(缕, 3
            ));
            consumeLiquid(灵液, 12f / 60f);
            consumePower(270 / 60f);
            outputItem = new ItemStack(威灵, 1);
            health = 180;
            itemCapacity = 10;
            size = 2;
            craftTime = 90;
            // craftEffect = fireballsmoke;
            // updateEffect = plasticExplosion;
            updateEffectChance = 0.1F;
            group = transportation;
            requirements(crafting, with(
                    幻烬, 40,
                    缕, 30,
                    翠, 60,
                    陶, 50
            ));
            drawer = new DrawMulti(new DrawDefault()
                  /*  new DrawFlame() {
                {}public void load(Block block) {
                    top = Core.atlas.find(威灵炼宝器.name + "-top");
                }
                public void draw(Building build) {
                    if (build.warmup() > 0.0F && this.flameColor.a > 0.001F) {
                        Draw.z(30.01F);
                        Draw.alpha(build.warmup());
                        Draw.rect(top, build.x, build.y);
                    }
                }
            }*/);
        }};
        血晶炼宝器 = new GenericCrafter("血晶炼宝器") {{
            localizedName = Core.bundle.get("block.xuejing");
            description = Core.bundle.getOrNull("block.description.null");
            consumeItems(with(月银沙, 2, 缕, 1
            ));
            //consumeLiquid(Liquids.water, 0.1f);
            consumePower(180 / 60f);
            outputItem = new ItemStack(血晶, 1);
            health = 180;
            itemCapacity = 10;
            size = 2;
            craftTime = 120;
            // craftEffect = fireballsmoke;
            // updateEffect = plasticExplosion;
            group = transportation;
//            ambientSound = respawning;
//            ambientSoundVolume = 0.5f;
            requirements(crafting, with(
                    灵玉, 20,
                    翠, 70,
                    陶, 100
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("F07D75")));
        }};
        明宝聚宝炉 = new GenericCrafter("明宝聚宝炉") {{
            localizedName = Core.bundle.get("block.mingbao");
            description = Core.bundle.getOrNull("block.description.null");
            consumeItems(with(灵玉, 3, 离, 3
            ));
            consumePower(360 / 60f);
            outputItem = new ItemStack(明宝, 1);
            health = 180;
            itemCapacity = 10;
            size = 2;
            craftTime = 120;
            // craftEffect = fireballsmoke;
            // updateEffect = plasticExplosion;
            updateEffectChance = 0.1F;
            group = transportation;
            ambientSound = respawning;
            ambientSoundVolume = 0.5f;
            requirements(crafting, with(
                    威灵, 80,
                    缕, 70,
                    幻烬, 70,
                    陶, 110
            ));
            drawer = new DrawMulti(new DrawDefault(),
                    new DrawFlame() {
                        {
                        }

                        public void load(Block block) {
                            top = Core.atlas.find(明宝聚宝炉.name + "-top");
                        }

                        public void draw(Building build) {
                            if (build.warmup() > 0.0F && this.flameColor.a > 0.001F) {
                                Draw.z(30.01F);
                                Draw.alpha(build.warmup());
                                Draw.rect(top, build.x, build.y);
                            }
                        }
                    }
            );
        }};
        萤玫化宝鼎 = new GenericCrafter("萤玫炼宝器") {{
            localizedName = Core.bundle.get("block.yingmei");
            description = Core.bundle.getOrNull("block.description.null");
            consumeItems(with(灵玉, 2, 缕, 1
            ));
            consumePower(120 / 60f);
            outputItem = new ItemStack(萤玫, 1);
            health = 180;
            itemCapacity = 10;
            size = 2;
            craftTime = 70;
            // craftEffect = fireballsmoke;
            // updateEffect = plasticExplosion;
            group = transportation;
            requirements(crafting, with(
                    血晶, 30,
                    威灵,35,
                    翠, 75,
                    陶, 120
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};
        精焰化宝鼎 = new GenericCrafter("精焰化宝鼎") {{
            localizedName = Core.bundle.get("block.jingyan");
            description = Core.bundle.getOrNull("block.description.null");
            consumeItems(with(萤玫, 2, 威灵, 1
            ));
            consumeLiquid(幻液, 9f / 60f);
            consumePower(220 / 60f);
            outputItem = new ItemStack(精焰, 1);
            health = 230;
            itemCapacity = 10;
            size = 3;
            craftTime = 80;
            // craftEffect = fireballsmoke;
            // updateEffect = plasticExplosion;
            group = transportation;
            requirements(crafting, with(
                    威灵, 45,
                    翠, 60,
                    缕, 50,
                    灵玉, 30
            ));
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(幻液), new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};
        超烬化宝鼎 = new GenericCrafter("超烬化宝鼎") {{
            localizedName = Core.bundle.get("block.chaojing");
            description = Core.bundle.getOrNull("block.description.null");
            consumeItems(with(幻烬, 3, 萤玫, 2, 灵玉, 3
            ));
            consumePower(320 / 60f);
            outputItem = new ItemStack(超烬, 1);
            health = 230;
            itemCapacity = 10;
            size = 3;
            craftTime = 100;
            // craftEffect = fireballsmoke;
            // updateEffect = plasticExplosion;
            group = transportation;
            requirements(crafting, with(
                    精焰, 15,
                    翠, 80,
                    陶, 70,
                    明宝, 20,
                    灵玉, 50
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

        精纯灵液炼制炉 = new GenericCrafter("精纯灵液炼制炉") {{
            localizedName = Core.bundle.get("block.jingcunlingye");
            description = Core.bundle.getOrNull("block.description.null");
            outputLiquid = new LiquidStack(精纯灵液, 6f / 60f);
            size = 2;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            rotate = false;
            solid = true;
            outputsLiquid = true;
            // envEnabled = Env.any;
            drawer = new DrawMulti(new DrawRegion("-bottom"),
                    new DrawLiquidTile(灵液), new DrawLiquidTile(精纯灵液) {{
                drawLiquidLight = true;
            }}, new DrawDefault());
            liquidCapacity = 24f;
            craftTime = 120;
            lightLiquid = Liquids.cryofluid;
            group = transportation;
            requirements(crafting, with(
                    缕, 35,
                    翠, 45,
                    陶, 55
            ));
            consumePower(240 / 60f);
            consumeItem(灵玉, 2);
            consumeLiquid(灵液, 12f / 60f);
        }};
        冰橡子炼玄器 = new GenericCrafter("冰橡子炼玄器") {{
            localizedName = Core.bundle.get("block.bingxiangzi");
            description = Core.bundle.getOrNull("block.description.null");
            consumeItems(with(超烬, 1, 血晶, 2, 威灵, 2, 明宝, 1
            ));
            consumeLiquid(精纯灵液, 9f / 60f);
            consumePower(560 / 60f);
            outputItem = new ItemStack(冰橡子, 1);
            health = 320;
            itemCapacity = 10;
            size = 4;
            craftTime = 420;
            // craftEffect = fireballsmoke;
            // updateEffect = plasticExplosion;
            group = transportation;
            requirements(crafting, with(
                    翠, 220,
                    陶, 300,
                    威灵, 90,
                    灵玉, 150,
                    幻烬, 110

            ));
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawMultiWeave() {{//一个外部贴图旋转
                        glowColor = Color.valueOf("ffc6f1");
                    }},
                    new DrawDefault(),//本体
                    new DrawFlame() {
                        {
                        }

                        public void load(Block block) {
                            top = Core.atlas.find(冰橡子炼玄器.name + "-top");
                        }

                        public void draw(Building build) {
                            if (build.warmup() > 0.0F && this.flameColor.a > 0.001F) {
                                Draw.z(30.01F);
                                Draw.alpha(build.warmup());
                                Draw.rect(top, build.x, build.y);
                            }
                        }
                    }
            );
        }};
        筑基丹炼制炉 = new Separator("筑基丹炼制炉") {{
            localizedName = Core.bundle.get("block.zhujidan");

            requirements(Category.crafting, with(威灵, 70, 缕, 120, 灵玉, 240, 血晶, 100));
            results = with(
                    筑基丹, 1,
                    废丹, 9
            );
            itemCapacity = 15;
            hasPower = true;
            craftTime = 300f;
            size = 2;
            consumeItems(with(超烬, 1, 精焰, 10));
            consumePower(100 / 60f);
            consumeLiquid(灵液, 12f / 60f);
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(), new DrawRegion("-spinner", 3, true), new DrawDefault());
        }};
        聚灵丹炼制炉 = new Separator("聚灵丹炼制炉") {{
            localizedName = Core.bundle.get("block.zhujidan");

            requirements(Category.crafting, with(威灵, 70, 缕, 120, 灵玉, 240, 血晶, 100));
            results = with(
                    聚灵丹, 1,
                    废丹, 9
            );
            itemCapacity = 45;
            hasPower = true;
            craftTime = 300f;
            size = 2;
            consumeItems(with(冰橡子, 1, 精焰, 20));
            consumePower(200 / 60f);
            consumeLiquid(精纯灵液, 12f / 60f);
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(), new DrawRegion("-spinner", 3, true), new DrawDefault());
        }};
///电力
        十字节点 = new BeamNode("beam-node") {{
            localizedName = Core.bundle.get("power.beam-node");
            description = Core.bundle.getOrNull("power.description.beam-node");
            requirements(Category.power, with(翠, 8, 陶, 8, 幻烬, 5));
            consumesPower = outputsPower = true;
            health = 90;
            range = 10;
            fogRadius = 1;
            researchCost = with(翠, 100, 陶, 100, 幻烬, 30);
            consumePowerBuffered(4000f);
        }};
        十字节点电池 = new BeamNode("beam-node2") {{
            localizedName = Core.bundle.get("power.beam-node2");
            description = Core.bundle.getOrNull("power.description.beam-node2");
            requirements(Category.power, with(翠, 25, 陶, 10, 灵玉, 30));
            consumesPower = outputsPower = true;
            size = 3;
            health = 210;
            range = 0;
            fogRadius = 1;
            researchCost = with(余烬, 50);
            consumePowerBuffered(90000f);
        }};

        圆形节点 = new PowerNode("power-node") {{
            localizedName = Core.bundle.get("power.power-node");
            description = Core.bundle.getOrNull("power.description..power-node");
            requirements(Category.power, with(运符, 20, 明宝, 3, 陶, 30));
            maxNodes = 5;
            laserRange = 15;
        }};
        灵力射线塔 = new PowerNode("power-node2") {{
            localizedName = Core.bundle.get("power.power-node2");
            description = Core.bundle.getOrNull("power.description.power-node2");
            requirements(Category.power, with(运符, 200, 明宝, 50, 陶, 300, 翠, 250, 灵玉, 200));
            maxNodes = 1;
            laserRange = 120;
            size = 4;
        }};
        灵力收集器 = new ThermalGenerator("灵力收集器") {
            {//√
                localizedName = Core.bundle.get("power.lingli0");
                description = Core.bundle.getOrNull("power.description.null");
                displayEfficiencyScale = 1f / 9f;
                powerProduction = 60 / 540f;//这个每单位是540电力，和其他发电机60不一样
                //attribute = Attribute.heat;
                attribute = 灵力收集;
                generateEffect = Fx.lightningCharge;
                effectChance = 0.04f;
                size = 2;
                ambientSound = Sounds.hum;
                ambientSoundVolume = 0.06f;
                drawer = new DrawMulti(
                        new DrawRegion("-bottom"),
                        new DrawLiquidTile(Liquids.water),
                        new DrawDefault(),
                        new DrawFlame() {
                            {
                            }

                            public void load(Block block) {
                                top = Core.atlas.find(灵力收集器.name + "-top");
                            }

                            public void draw(Building build) {
                                if (build.warmup() > 0.0F && this.flameColor.a > 0.001F) {
                                    Draw.z(30.01F);
                                    Draw.alpha(build.warmup());
                                    Draw.rect(top, build.x, build.y);
                                }
                            }
                        }
                );
                hasLiquids = true;
                liquidCapacity = 20f;
                outputLiquid = new LiquidStack(Liquids.water, 6f / 60f / 4);
                group = transportation;
                requirements(power, with(
                        翠, 65,
                        陶, 80
                ));
                buildType = Build::new;
            }

            class Build extends ThermalGenerator.ThermalGeneratorBuild {
                public void drawLight() {
                    Drawf.light(x, y, (40f + Mathf.absin(10f, 5f)) * Math.min(productionEfficiency, 2f) * size, Color.valueOf("5313ba"), 0.7f);
                }
            }
        };
        一品灵力产生器 = new ConsumeGenerator("一品灵力产生器") {{
            localizedName = Core.bundle.get("power.lingli1");
            description = Core.bundle.getOrNull("power.description.lingli1");
            size = 2;
            powerProduction = 380 / 60f;
            itemDuration = 60 * 1.5f;
            envEnabled = 标志1;
            generateEffect = Fx.generatespark;
            researchCostMultiplier = 3f;//科技树中的研究资源倍率
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawWarmupRegion() {{
                        color = Color.valueOf("bbf2ff");
                    }});
            consume(new ConsumeItemRadioactive());
            group = transportation;
            requirements(power, with(
                    幻烬, 40,
                    翠, 70,
                    陶, 60,
                    缕, 50
            ));
        }};
        二品灵力产生器 = new ConsumeGenerator("二品灵力产生器") {{
            localizedName = Core.bundle.get("power.lingli2");
            description = Core.bundle.getOrNull("power.description.lingli2");
            consumeItems(with(灵玉, 3
            ));
            size = 3;
            powerProduction = 2500 / 60f;
            itemDuration = 60 * 5f;
            // envEnabled = Env.any;
            generateEffect = Fx.generatespark;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.06f;
            consumeLiquid(精纯灵液, 2f / 60f);
            researchCostMultiplier = 3f;//科技树中的研究资源倍率
            hasLiquids = true;
            drawer = new DrawMulti(
                    //  new DrawWarmupRegion(),
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(精纯灵液),
                    new DrawDefault(),
                    new DrawRegion("-turbine1") {{
                        rotateSpeed = 2f;
                    }},
                    new DrawRegion("-turbine2") {{
                        rotateSpeed = -2f;
                        rotation = 45f;
                    }}
            );
            // consume(new ConsumeItemRadioactive());
            group = transportation;
            requirements(power, with(
                    幻烬, 40,
                    翠, 90,
                    血晶, 50
            ));
        }};
        BuildTurret 辅助建造塔 = new BuildTurret("辅助建造塔") {{
            requirements(Category.effect, BuildVisibility.editorOnly, with(陶, 100));
            outlineColor = Pal.darkOutline;
            range = 200f;
            size = 3;
            buildSpeed = 1.5f;
            targetable = false;
            solid = false;
            // consumePower(3f);
            //  consumeLiquid(Liquids.nitrogen, 3f / 60f);
        }};


    }

    private static void initDrills() {
        陶玉钻头 = new Drill("陶玉钻头") {{
            localizedName = Core.bundle.get("Drill.tao");
            description = Core.bundle.getOrNull("Drill.description.tao");
            requirements(Category.production, with(陶, 24));
            tier = 2;
            drillTime = 280;
            canOverdrive = false;//不可超速
            size = 2;
            health = 300;
            // hasLiquids=false;
            liquidBoostIntensity = 2f;
            consumeLiquid(Liquids.water, 0.06f).boost();
            //mechanical drill doesn't work in space
            // envEnabled ^= Env.space;

        }};

        灵玉钻头 = new Drill("灵玉钻头") {{
            localizedName = Core.bundle.get("Drill.lingyu");
            description = Core.bundle.getOrNull("Drill.description.lingyu");
            requirements(Category.production, with(灵玉, 15, 幻烬, 40, 翠, 160));
            tier = 3;
            drillTime = 240;
            canOverdrive = false;
            size = 2;
            health = 700;
            hasLiquids = false;
            conductivePower = true;//可以导电
            researchCost = with(灵玉, 3000, 幻烬, 8000, 翠, 48000);
            // liquidBoostIntensity = 1.2f;
            consumePower(180 / 60f);
            //consumeLiquid(Liquids.water, 0.06f).boost();
        }};

        威灵钻头 = new Drill("威灵钻头") {{
            localizedName = Core.bundle.get("Drill.weiling");
            description = Core.bundle.getOrNull("Drill.description.weiling");
            requirements(Category.production, with(威灵, 35, 血晶, 30, 灵玉, 30, 缕, 20));
            drillTime = 120;
            size = 3;
            hasPower = true;
            canOverdrive = false;
            tier = 4;
            health = 1200;
            researchCostMultiplier = 2.5f;//科技树中的研究资源倍率
            updateEffect = Fx.pulverizeMedium;
            drillEffect = Fx.mineBig;
            liquidBoostIntensity = 1.4f;
            consumePower(260 / 60f);
            consumeLiquid(灵液, 4 / 60f).boost();
            conductivePower = true;//可以导电
        }};

        明宝钻头 = new CTBurstDrill("明宝钻头") {{
            localizedName = Core.bundle.get("Drill.mingbao");
            description = Core.bundle.getOrNull("Drill.description.mingbao");
            requirements(Category.production, with(威灵, 65, 离, 60, 灵玉, 50, 明宝, 75));
            drillTime = 90;
            canOverdrive = false;
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

            consumePower(380 / 60f);
            consumeLiquid(精纯灵液, 0.1f).boost();
        }};
        汲水器 = new GenericCrafter("汲水器") {{
            localizedName = Core.bundle.get("Drill.shui");
            description = Core.bundle.getOrNull("Drill.description.shui");
            requirements(Category.production, with(幻烬, 20, 威灵, 60, 灵玉, 40, 陶, 30));
            health = 500;
            size = 3;
            craftTime = 60;
            canOverdrive = false;
            hasItems = false;
            outputsLiquid = true;
            buildCostMultiplier = 0.5f;
            outputLiquid = new LiquidStack(Liquids.water, 90f / 60f);
            group = BlockGroup.liquids;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.water),
                    // new DrawBlurSpin("-rotator", 6f),
                    new CTDrawMultiWeave() {{
                        rotateSpeed = 3;
                    }},//一个外部贴图旋转
                    new DrawDefault());

            ambientSound = Sounds.hum;

            consumePower(150f / 60);
            liquidCapacity = 200f;
        }};
        液体泵 = new Pump("液体泵") {{
            requirements(Category.production, with(
                    威灵, 30,
                    血晶, 40,
                    陶, 50
            ));
            health = 800;
            canOverdrive = false;
            pumpAmount = 0.18f;
            consumePower(120 / 60f);
            liquidCapacity = 40f;
            hasPower = true;
            size = 2;
        }};

    }

    private static void initWalls() {

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
    }

    private static void initLogistical() {
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
            requirements(Category.effect, with(缕, 30, 陶, 50));
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
            requirements(Category.liquid, with(萤玫, 50, 运符, 150));
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
