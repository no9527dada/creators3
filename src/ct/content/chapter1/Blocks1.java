package ct.content.chapter1;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.math.Mathf;
import arc.struct.Seq;
import mindustry.content.Fx;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.gen.Building;
import mindustry.gen.Sounds;
import mindustry.graphics.CacheLayer;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.BuildTurret;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.environment.StaticWall;
import mindustry.world.blocks.power.BeamNode;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.power.ThermalGenerator;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.Separator;
import mindustry.world.consumers.ConsumeItemRadioactive;
import mindustry.world.draw.*;
import mindustry.world.meta.BuildVisibility;

import static ct.Asystem.Evn2.*;
import static ct.content.Floors.m;
import static ct.content.chapter1.Item1.*;
import static ct.content.CTAttributes.灵力收集;
import static mindustry.gen.Sounds.respawning;
import static mindustry.type.Category.crafting;
import static mindustry.type.Category.power;
import static mindustry.type.ItemStack.with;
import static mindustry.world.meta.BlockGroup.transportation;


public class Blocks1 {
    public static final Seq<Item> 包涵章节1资源 = new Seq<>(), 仅章节1资源 = new Seq<>();
    public static Block 翠矿, 陶矿, 缕矿, 离矿, 血晶石矿, 月银沙地板, 余烬矿, 灵玉石矿, 发光地板,
            地板矿物;
    public static Block 幻液地板, 灵液地板, 灵脉地板,
            其他地板;
    public static Block 幻烬炼宝器, 运符炼宝器, 血晶炼宝器, 威灵炼宝器, 明宝聚宝炉, 萤玫化宝鼎,
            精焰化宝鼎, 幻烬聚宝炉, 灵玉炼宝器, 灵玉炼宝炉, 冰橡子炼玄器, 超烬化宝鼎, 灵液炼制炉,
            精纯灵液炼制炉, 资源炼化器, 资源炼化炉, 幻液炼制炉, 筑基丹炼制炉, 聚灵丹炼制炉,
            工厂方块;
    public static Block 灵力收集器, 一品灵力产生器, 二品灵力产生器, 十字节点, 十字节点电池, 圆形节点, 灵力射线塔,
            电力方块;


    /*****************************/


    public static void load() {

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
            consumeLiquid(灵液, 3 / 60f);
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

}
