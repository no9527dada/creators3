package ct.content.chapter5;

import arc.Core;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.Separator;
import mindustry.world.draw.*;

import static ct.Asystem.CT3Sound.loadSound;
import static ct.content.chapter5.资源5.*;
import static mindustry.content.Fx.*;
import static mindustry.content.Items.*;
import static mindustry.gen.Sounds.grinding;
import static mindustry.gen.Sounds.respawning;
import static mindustry.type.Category.crafting;
import static mindustry.type.ItemStack.with;
import static mindustry.world.meta.BlockGroup.liquids;
import static mindustry.world.meta.BlockGroup.transportation;


//PixelFactory.PixelFactory.content.工厂
//共计51个工厂
public class 工厂5 {


    public static Block
            资源转换器_废料, 资源转换器_铜铅, 资源转换器_钛, 资源转换器_钍, 资源转换器_钴, 资源转换器_镍, 资源转换器_塑钢,
            军火库, 水晶复合器, 啸动冲击械, 粒子离心机, 黎辉离心机, 钛合金反应炉, 镍板混合器, 碳板压缩机, 硫粉发生机, 镍板合成机,
            军火材料机, 啸动冶炼机, 固体放射机, 制冷液混合机, 冷冻液发生机, 辐射混合机, 放射熔炉, 矿物离心机, 放射混合器,
            物品厂_水瓶, 相织反应炉, 钻石提炼机, 钻石矿加工厂, 铁锻造机, 链式锻造机, 铁板锻造机, 铁板重型加工厂, 黄金熔炼器, 混合熔炼器,
            钻石离心机, 电池转换器, 钻石混合物反应机, 钍电池制造厂, 多重编织机, 合金锤炼厂, 多重冶炼厂, 多重窑炉,
            多重塑钢机, 爆炸冲击机, 空壳制造机, 弹药厂_冷冻, 弹药厂_碎裂, 弹药厂_爆破, 弹药厂_硬直, 大型粉碎机, 石英提取机, 石英磨练机,
            工厂;

    //            outputLiquid = new LiquidStack(Liquids.slag, 12f / 60f);
    public static void load() {

        石英提取机 = new GenericCrafter("石英提取机") {{

            localizedName = "石英提取机";
            description = "";
            consumeItems(with(lead, 2

            ));
            //consumeLiquid(Liquids.water, 0.1f);
            consumePower(50 / 60f);
            outputItem = new ItemStack(石英, 1);
            health = 110;
            itemCapacity = 10;
            size = 1;
            craftTime = 50;
            // craftEffect = fireballsmoke;
            // updateEffect = plasticExplosion;
            updateEffectChance = 0.1F;
            group = transportation;
            ambientSound = respawning;
            ambientSoundVolume = 0.5f;
            requirements(crafting, with(
                    Items.copper, 15,
                    Items.lead, 20,
                    graphite, 5
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        石英磨练机 = new GenericCrafter("石英磨练机") {{
            localizedName = "石英提取机";
            description = "";
            consumeItems(with(lead, 2,
                    silicon, 1

            ));
            //consumeLiquid(Liquids.water, 0.1f);
            consumePower(50 / 60f);
            outputItem = new ItemStack(石英, 5);
            health = 180;
            itemCapacity = 10;
            size = 2;
            craftTime = 60;
            craftEffect = fireballsmoke;
            // updateEffect = plasticExplosion;
            updateEffectChance = 0.1F;
            group = transportation;
            ambientSound = respawning;
            ambientSoundVolume = 0.5f;
            requirements(crafting, with(
                    Items.copper, 20,
                    Items.lead, 30,
                    graphite, 40,
                    铁, 20
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

        铁锻造机 = new GenericCrafter("铁锻造机") {{
            localizedName = "铁锻造机";
            description = "";
            consumeItems(with(
                    copper, 2,
                    lead, 2
            ));
            //consumeLiquid(Liquids.oil, 15/60f);
            consumePower(50 / 60f);
            outputItem = new ItemStack(铁, 1);
            health = 220;
            itemCapacity = 10;
            size = 2;
            craftTime = 100;
            craftEffect = Fx.fireballsmoke;
            updateEffect = Fx.mine;
            group = transportation;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    石英, 100,
                    lead, 45,
                    graphite, 70,
                    copper, 80
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        链式锻造机 = new GenericCrafter("链式锻造机") {{
            localizedName = "链式锻造机";
            description = "";
            consumeItems(with(
                    copper, 2,
                    lead, 3
            ));
            //consumeLiquid(Liquids.oil, 15/60f);
            consumePower(150 / 60f);
            outputItem = new ItemStack(铁, 5);
            health = 280;
            itemCapacity = 10;
            size = 3;
            craftTime = 140;
            group = transportation;
            craftEffect = Fx.fireballsmoke;
            updateEffect = Fx.mine;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    石英, 200,
                    lead, 120,
                    graphite, 70,
                    镍, 50,
                    铁板, 10//使用铁板 不用铁 进一步增加升级难度
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        铁板锻造机 = new GenericCrafter("高炉") {{
            localizedName = "铁板锻造机";
            description = "";
            consumeItems(with(
                    铁, 6,
                    coal, 10
            ));
            //consumeLiquid(Liquids.oil, 15/60f);
            consumePower(560 / 60f);
            outputItem = new ItemStack(铁板, 1);
            health = 280;
            itemCapacity = 10;
            size = 3;
            craftTime = 600;
            craftEffect = Fx.fireballsmoke;
            updateEffect = Fx.mine;
            updateEffectChance = 0.1F;
            ambientSoundVolume = 0.2f;
            ambientSound = loadSound("gaolu");
            group = transportation;
            requirements(crafting, with(
                    石英, 200,
                    copper, 220,
                    石英, 200,
                    钴, 80,
                    铁, 80,
                    镍, 150
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        铁板重型加工厂 = new GenericCrafter("重型加工厂") {{
            localizedName = "铁板重型加工厂";
            description = "";
            consumeItems(with(
                    铁, 10,
                    coal, 13//建议换碳板
            ));
            //consumeLiquid(Liquids.oil, 15/60f);
            consumePower(700 / 60f);
            outputItem = new ItemStack(铁板, 3);
            health = 420;
            itemCapacity = 30;
            size = 4;
            craftTime = 300;
            group = transportation;
            craftEffect = Fx.fireballsmoke;
            updateEffect = Fx.fireballsmoke;
            updateEffectChance = 0.1F;
            ambientSoundVolume = 0.2f;
            ambientSound = loadSound("gaolu2");
            requirements(crafting, with(
                    石英, 250,
                    copper, 320,
                    石英, 250,
                    钴, 80,
                    铁板, 30,
                    碳板, 20,
                    镍板, 150
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        硫粉发生机 = new GenericCrafter("硫粉发生机") {{
            localizedName = "硫粉发生机";
            description = "";
            consumeItems(with(coal, 2,
                    lead, 3,
                    sand, 3
            ));
            //consumeLiquid(Liquids.water, 0.1f);
            consumePower(50 / 60f);
            outputItem = new ItemStack(pyratite, 4);
            health = 110;
            itemCapacity = 10;
            size = 3;
            craftTime = 90;
            craftEffect = fireballsmoke;
            updateEffect = plasticExplosion;
            updateEffectChance = 0.1F;
            group = transportation;
            ambientSound = respawning;
            ambientSoundVolume = 0.5f;
            requirements(crafting, with(
                    Items.copper, 150,
                    Items.lead, 100,
                    graphite, 50,
                    铁, 50
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        爆炸冲击机 = new GenericCrafter("爆炸冲击机") {{
            localizedName = "爆炸冲击机";
            description = "";
            consumeItems(with(Items.pyratite, 2, Items.sporePod, 2));
            consumeLiquid(Liquids.water, 0.1f);
            consumePower(50 / 60f);
            outputItem = new ItemStack(blastCompound, 3);
            health = 110;
            itemCapacity = 10;
            size = 3;
            craftTime = 90;
            craftEffect = fire;
            group = transportation;
            updateEffect = plasticExplosion;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.5f;
            requirements(crafting, with(
                    Items.titanium, 50,
                    Items.lead, 150,
                    铁板, 35,
                    石英, 110
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        大型粉碎机 = new GenericCrafter("大型粉碎机") {{
            localizedName = "大型粉碎机";
            description = "";
            consumeItems(with(Items.scrap, 2));
            // consumeLiquid(Liquids.water, 0.1f);
            consumePower(0.25f);
            outputItem = new ItemStack(sand, 3);
            health = 130;
            itemCapacity = 15;
            size = 2;
            craftTime = 40;
            craftEffect = mine;
            updateEffect = none;
            group = transportation;
            updateEffectChance = 0.1F;
            ambientSound = grinding;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    Items.copper, 150,
                    Items.lead, 100,
                    铁板, 30,
                    钴, 20
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        碳板压缩机 = new GenericCrafter("煤炭压缩机") {{
            localizedName = "碳板压缩机";
            description = "";
            consumeItems(with(coal, 50

            ));
            //consumeLiquid(Liquids.water, 0.1f);
            consumePower(50 / 60f);
            outputItem = new ItemStack(碳板, 3);
            health = 180;
            itemCapacity = 200;
            size = 2;
            craftTime = 250;
            group = transportation;
            craftEffect = fireballsmoke;
            updateEffect = smoke;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.5f;
            requirements(crafting, with(
                    Items.copper, 80,
                    Items.lead, 50,
                    graphite, 20,
                    silicon, 50
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        空壳制造机 = new GenericCrafter("空壳制造机") {{
            localizedName = "空壳制造机";
            description = "";
            consumeItems(with(metaglass, 4,
                    铁, 2));
            // consumeLiquid(Liquids.water, 0.1f);
            consumePower(1.5f);
            outputItem = new ItemStack(空壳, 3);
            health = 150;
            itemCapacity = 10;
            size = 2;
            craftTime = 80;
            group = transportation;
            // craftEffect=hitLancer;
            updateEffect = smoke;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    Items.lead, 90,
                    Items.copper, 100,
                    metaglass, 55

            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        弹药厂_爆破 = new GenericCrafter("弹药厂-爆破") {{
            localizedName = "弹药厂-爆破";
            description = "";
            consumeItems(with(空壳, 1,
                    blastCompound, 1));
            // consumeLiquid(Liquids.water, 0.1f);
            consumePower(1.5f);
            outputItem = new ItemStack(爆破弹, 1);
            health = 220;
            itemCapacity = 10;
            size = 2;
            craftTime = 60;
            group = transportation;
            craftEffect = hitLancer;
            updateEffect = hitLancer;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    Items.lead, 150,
                    Items.thorium, 50,
                    石英, 150,
                    铁, 110
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        弹药厂_冷冻 = new GenericCrafter("弹药厂-冷冻") {{
            localizedName = "弹药厂-冷冻";
            description = "";
            consumeItems(with(空壳, 1,
                    titanium, 1));
            consumeLiquid(Liquids.water, 0.1f);
            consumePower(1.5f);
            outputItem = new ItemStack(冷冻弹, 1);
            health = 220;
            itemCapacity = 10;
            size = 2;
            craftTime = 60;
            group = transportation;
            craftEffect = hitLancer;
            updateEffect = hitLancer;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    Items.lead, 150,
                    Items.thorium, 50,
                    titanium, 50,
                    石英, 150,
                    铁, 110
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        弹药厂_碎裂 = new GenericCrafter("弹药厂-碎裂") {{
            localizedName = "弹药厂-碎裂";
            description = "";
            consumeItems(with(空壳, 1,
                    scrap, 1, metaglass, 1));
            //consumeLiquid(Liquids.water, 0.1f);
            consumePower(1.5f);
            outputItem = new ItemStack(碎裂弹, 1);
            health = 220;
            itemCapacity = 10;
            size = 2;
            craftTime = 60;
            group = transportation;
            craftEffect = hitLancer;
            updateEffect = hitLancer;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    Items.lead, 150,
                    // Items.thorium, 50,
                    metaglass, 50,
                    石英, 150,
                    铁, 110
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        弹药厂_硬直 = new GenericCrafter("弹药厂-硬直") {{
            localizedName = "弹药厂-硬直";
            description = "";
            consumeItems(with(空壳, 1,
                    钻石混合物, 1, 钴, 1));
            //consumeLiquid(Liquids.water, 0.1f);
            consumePower(1.5f);
            outputItem = new ItemStack(硬直弹, 1);
            health = 220;
            itemCapacity = 10;
            size = 2;
            craftTime = 60;
            group = transportation;
            craftEffect = hitLancer;
            updateEffect = hitLancer;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    Items.lead, 150,
                    // Items.thorium, 50,
                    钴, 110,
                    石英, 150,
                    铁, 110
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        钍电池制造厂 = new GenericCrafter("钍电池制造厂") {{
            localizedName = "钍电池制造厂";
            description = "";
            consumeItems(with(thorium, 8,
                    空壳, 2));
            consumeLiquid(Liquids.water, 4 / 60f);
            consumePower(2.5f);
            outputItem = new ItemStack(钍电池, 1);
            health = 160;
            itemCapacity = 20;
            size = 2;
            craftTime = 200;
            group = transportation;
            craftEffect = hitFuse;
            updateEffect = fireSmoke;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    Items.lead, 120,
                    copper, 120,
                    silicon, 55,
                    thorium, 200
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        电池转换器 = new GenericCrafter("电池转换器") {{
            localizedName = "电池转换器";
            description = "";
            consumeItems(with(钍电池, 1
            ));
            consumeLiquid(Liquids.cryofluid, 2 / 60f);
            consumePower(1.5f);
            outputItem = new ItemStack(电池, 3);
            health = 160;
            itemCapacity = 30;
            size = 2;
            craftTime = 120;
            group = transportation;
            craftEffect = hitLancer;
            updateEffect = fireSmoke;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    Items.lead, 150,
                    Items.titanium, 110,
                    金, 20,
                    石英, 180,
                    thorium, 20
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        多重编织机 = new GenericCrafter("多重编织机") {{
            localizedName = "多重编织机";
            description = "";
            consumeItems(with(sand, 15,
                    thorium, 6
            ));
            consumeLiquid(Liquids.water, 12 / 60f);
            consumePower(2.5f);
            outputItem = new ItemStack(phaseFabric, 3);
            health = 250;
            itemCapacity = 30;
            size = 3;
            craftTime = 70;
            group = transportation;
            craftEffect = hitLancer;
            updateEffect = fireSmoke;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    Items.lead, 150,
                    Items.phaseFabric, 20,
                    金, 90,
                    石英, 300,
                    thorium, 400,
                    铁, 110,
                    钻石混合物, 50
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        多重塑钢机 = new GenericCrafter("多重塑钢机") {{
            localizedName = "多重塑钢机";
            description = "";
            consumeItems(with(
                    titanium, 6
            ));
            consumeLiquid(Liquids.oil, 15 / 60f);
            consumePower(2.5f);
            outputItem = new ItemStack(plastanium, 3);
            health = 250;
            itemCapacity = 10;
            liquidCapacity = 30;
            size = 3;
            craftTime = 70;
            group = transportation;
            craftEffect = hitLancer;
            updateEffect = fireSmoke;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    Items.lead, 300,
                    Items.plastanium, 35,
                    金, 90,
                    graphite, 250,
                    石英, 300,
                    titanium, 200,
                    铁, 90,
                    钻石混合物, 30
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

        多重窑炉 = new GenericCrafter("多重窑炉") {{
            localizedName = "多重窑炉";
            description = "";
            consumeItems(with(
                    lead, 2,
                    sand, 3
            ));
            //consumeLiquid(Liquids.oil, 15/60f);
            consumePower(2.5f);
            outputItem = new ItemStack(metaglass, 3);
            health = 250;
            itemCapacity = 10;
            size = 3;
            craftTime = 50;
            group = transportation;
            craftEffect = hitLancer;
            updateEffect = fireSmoke;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    Items.copper, 150,
                    Items.lead, 100,
                    graphite, 250,
                    石英, 125,
                    thorium, 50,
                    铁, 90
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        多重冶炼厂 = new GenericCrafter("多重冶炼厂") {{
            localizedName = "多重冶炼厂";
            description = "";
            consumeItems(with(
                    coal, 2,
                    sand, 3
            ));
            //consumeLiquid(Liquids.oil, 15/60f);
            consumePower(2.5f);
            outputItem = new ItemStack(silicon, 3);
            health = 250;
            itemCapacity = 10;
            size = 3;
            craftTime = 60;
            group = transportation;
            craftEffect = Fx.steam;
            updateEffect = Fx.fireSmoke;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    Items.copper, 120,
                    Items.lead, 110,
                    silicon, 20,
                    石英, 120,
                    titanium, 50,
                    铁, 50
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        合金锤炼厂 = new GenericCrafter("合金锤炼厂") {{
            localizedName = "合金锤炼厂";
            description = "";
            consumeItems(with(
                    铁, 3,
                    silicon, 5,
                    titanium, 4
            ));
            //consumeLiquid(Liquids.oil, 15/60f);
            consumePower(480 / 60f);
            outputItem = new ItemStack(surgeAlloy, 5);
            health = 480;
            itemCapacity = 30;
            size = 4;
            craftTime = 110;
            group = transportation;
            craftEffect = Fx.fireballsmoke;
            updateEffect = Fx.mine;
            updateEffectChance = 0.1F;
            ambientSoundVolume = 0.2f;
            ambientSound = loadSound("surgeAlloy");
            requirements(crafting, with(
                    Items.copper, 230,
                    碳板, 200,
                    surgeAlloy, 25,
                    镍板, 120,
                    silicon, 180,
                    铁板, 100
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        镍板合成机 = new GenericCrafter("镍板合成机") {{
            localizedName = "镍板合成机";
            description = "";
            consumeItems(with(铁, 1, 镍, 2

            ));
            //  consumeLiquid(Liquids.water, 0.1f);
            consumePower(160 / 60f);
            outputItem = new ItemStack(镍板, 1);
            health = 230;
            itemCapacity = 10;
            size = 2;
            craftTime = 80;
            group = transportation;
            craftEffect = bubble;
            updateEffect = smoke;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.5f;
            requirements(crafting, with(
                    Items.copper, 80,
                    Items.lead, 50,
                    graphite, 20,
                    silicon, 50,
                    石英, 80,
                    铁板, 20
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

        镍板混合器 = new GenericCrafter("镍板混合器") {{
            localizedName = "镍板混合器";
            description = "";
            consumeItems(with(铁板, 1, 镍, 5
            ));
            //  consumeLiquid(Liquids.water, 0.1f);
            consumePower(160 / 60f);
            outputItem = new ItemStack(镍板, 5);
            health = 230;
            itemCapacity = 10;
            size = 3;
            craftTime = 120;
            group = transportation;
            craftEffect = bubble;
            updateEffect = bubble;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.5f;
            requirements(crafting, with(
                    Items.copper, 80,
                    石英, 150,
                    镍板, 100,
                    silicon, 50,
                    金, 80,
                    钻石, 50
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        黄金熔炼器 = new GenericCrafter("黄金熔炼器") {{
            localizedName = "黄金熔炼器";
            description = "";
            consumeItems(with(
                    铁, 2,
                    sand, 5
            ));
            //consumeLiquid(Liquids.oil, 15/60f);
            consumePower(70 / 60f);
            outputItem = new ItemStack(金, 1);
            health = 220;
            itemCapacity = 10;
            size = 2;
            craftTime = 70;
            group = transportation;
            craftEffect = Fx.fireballsmoke;
            updateEffect = Fx.smoke;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    石英, 100,
                    copper, 120,
                    lead, 110,
                    铁, 50,
                    titanium, 50
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        混合熔炼器 = new GenericCrafter("混合熔炼器") {{
            localizedName = "黄金混合熔炼器";
            description = "";
            consumeItems(with(
                    铁, 5,
                    sand, 8
            ));
            //consumeLiquid(Liquids.oil, 15/60f);
            consumePower(150 / 60f);
            outputItem = new ItemStack(金, 2);
            health = 280;
            itemCapacity = 10;
            size = 3;
            craftTime = 120;
            group = transportation;
            craftEffect = Fx.fireballsmoke;
            updateEffect = Fx.mine;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    石英, 200,
                    lead, 120,
                    graphite, 80,
                    镍板, 70,
                    silicon, 70,
                    铁板, 65
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        钻石离心机 = new GenericCrafter("钻石离心机") {{
            localizedName = "钻石离心机";
            description = "";
            consumeItems(with(
                    碳板, 5,//我觉得使用碳板更好 而不是60个煤炭
                    thorium, 7
            ));
            consumeLiquid(Liquids.cryofluid, 6 / 60f);
            consumePower(160 / 60f);
            outputItem = new ItemStack(钻石, 1);
            health = 220;
            itemCapacity = 15;
            size = 3;
            craftTime = 300;
            group = transportation;
            craftEffect = Fx.fuelburn;
            updateEffect = Fx.absorb;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    石英, 300,
                    thorium, 350,
                    silicon, 220,
                    镍板, 50,
                    金, 130,
                    铁, 180

            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        钻石混合物反应机 = new GenericCrafter("钻石混合物反应机") {{
            localizedName = "钻石混合物反应机";
            description = "";
            consumeItems(with(
                    coal, 7,
                    thorium, 4,
                    金, 2
            ));
            consumeLiquid(Liquids.water, 6 / 60f);
            consumePower(230 / 60f);
            outputItem = new ItemStack(钻石混合物, 4);
            health = 260;
            itemCapacity = 15;
            size = 3;
            craftTime = 110;
            group = transportation;
            //craftEffect = Fx.fuelburn;
            updateEffect = Fx.smoke;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    石英, 300,
                    lead, 325,
                    silicon, 225,
                    镍板, 320,
                    金, 100,
                    铁, 150,
                    titanium, 200,
                    钻石, 20

            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

        钻石矿加工厂 = new GenericCrafter("钻石矿加工厂") {{
            localizedName = "钻石矿加工厂";
            description = "";
            consumeItems(with(
                    钻石矿, 5
            ));
            consumeLiquid(Liquids.water, 6 / 60f);
            consumePower(350 / 60f);
            outputItem = new ItemStack(钻石混合物, 3);
            health = 260;
            itemCapacity = 15;
            size = 3;
            craftTime = 90;
            group = transportation;
            //craftEffect = Fx.fuelburn;
            updateEffect = Fx.smoke;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    石英, 300,
                    lead, 325,
                    silicon, 225,
                    镍板, 320,
                    金, 100,
                    铁, 150,
                    titanium, 200,
                    钻石, 200

            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

        钻石提炼机 = new GenericCrafter("钻石提炼机") {{
            localizedName = "钻石提炼机";
            description = "";
            consumeItems(with(
                    钻石混合物, 5,
                    graphite, 5

            ));
            //consumeLiquid(Liquids.water, 6/60f);
            consumePower(420 / 60f);
            outputItem = new ItemStack(钻石, 12);
            health = 260;
            itemCapacity = 25;
            size = 3;
            craftTime = 180;
            group = transportation;
            //craftEffect = Fx.fuelburn;
            updateEffect = Fx.smoke;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    石英, 300,
                    lead, 400,
                    graphite, 225,
                    surgeAlloy, 150,
                    铁板, 500,
                    titanium, 200,
                    钻石混合物, 10,
                    相织硅, 80
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        相织反应炉 = new GenericCrafter("相织反应炉") {{
            localizedName = "相织反应炉";
            description = "";
            consumeItems(with(
                    phaseFabric, 3,
                    silicon, 3

            ));
            consumeLiquid(Liquids.water, 12 / 60f);
            consumePower(450 / 60f);
            outputItem = new ItemStack(相织硅, 1);
            health = 260;
            itemCapacity = 12;
            size = 3;
            craftTime = 120;
            group = transportation;
            craftEffect = Fx.fire;
            updateEffect = Fx.hitLancer;
            updateEffectChance = 0.1F;
            ambientSound = respawning;
            ambientSoundVolume = 0.2f;
            requirements(crafting, with(
                    石英, 200,
                    lead, 240,
                    thorium, 170,
                    phaseFabric, 60,
                    铁板, 50,
                    silicon, 150,
                    钻石混合物, 50

            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        物品厂_水瓶 = new GenericCrafter("物品厂-水瓶") {{
            localizedName = "物品厂-水瓶";
            description = "";
            consumeItems(with(
                    空壳, 1
            ));
            consumeLiquid(Liquids.water, 3 / 60f);
            consumePower(110 / 60f);
            outputItem = new ItemStack(水瓶, 1);
            health = 240;
            itemCapacity = 10;
            size = 2;
            craftTime = 50;
            group = transportation;
            craftEffect = Fx.hitLancer;
            updateEffect = Fx.hitLancer;
            updateEffectChance = 0.1F;
            ambientSoundVolume = 0.2f;
            ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    石英, 150,
                    lead, 150,
                    copper, 100,
                    metaglass, 50


            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        钛合金反应炉 = new GenericCrafter("钛合金反应炉") {{
            localizedName = "钛合金反应炉";
            description = "";
            consumeItems(with(
                    钴, 3, surgeAlloy, 1//使用钴更合理，硬度更高。
            ));
            consumeLiquid(Liquids.water, 3 / 60f);
            consumePower(360 / 60f);
            outputItem = new ItemStack(钛合金, 1);
            health = 240;
            itemCapacity = 10;
            size = 2;
            craftTime = 90;
            group = transportation;
            craftEffect = Fx.hitLancer;
            updateEffect = Fx.mine;
            updateEffectChance = 0.1F;
            ambientSoundVolume = 0.2f;
            ambientSound = respawning;
            requirements(crafting, with(
                    石英, 150,
                    铁, 110,
                    钴, 220,
                    镍板, 45


            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};
        放射混合器 = new GenericCrafter("放射混合器") {{
            localizedName = "放射混合器";
            description = "";
            consumeItems(with(
                    thorium, 2, blastCompound, 1
            ));
            //consumeLiquid(Liquids.water, 3/60f);
            consumePower(140 / 60f);
            outputItem = new ItemStack(放射混合物, 1);
            health = 240;
            itemCapacity = 10;
            size = 2;
            craftTime = 80;
            group = transportation;
            craftEffect = Fx.mine;
            updateEffect = Fx.smoke;
            updateEffectChance = 0.1F;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    石英, 100,
                    钴, 120,
                    lead, 100


            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};
        放射熔炉 = new GenericCrafter("放射熔炉") {{
            localizedName = "放射熔炉";
            description = "";
            consumeItems(with(
                    sand, 4, thorium, 3
            ));
            //consumeLiquid(Liquids.water, 3/60f);
            consumePower(140 / 60f);
            outputItem = new ItemStack(放射沙, 1);
            health = 240;
            itemCapacity = 10;
            size = 2;
            craftTime = 120;
            group = transportation;
            craftEffect = Fx.mine;
            updateEffect = Fx.mine;
            updateEffectChance = 0.1F;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    石英, 80,
                    graphite, 45,
                    copper, 100,
                    thorium, 75,
                    metaglass, 45,
                    铁板, 5


            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

        固体放射机 = new GenericCrafter("物品厂-固体放射物") {{
            localizedName = "固体放射机";
            description = "";
            consumeItems(with(
                    放射混合物, 2, 放射沙, 2, 空壳, 3
            ));
            //consumeLiquid(Liquids.water, 3/60f);
            consumePower(140 / 60f);
            outputItem = new ItemStack(固体放射物, 1);
            health = 240;
            itemCapacity = 10;
            size = 3;//就是3，自己改贴图
            craftTime = 120;
            group = transportation;
            craftEffect = Fx.hitLancer;
            updateEffect = Fx.hitLancer;
            updateEffectChance = 0.1F;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    石英, 80,
                    lead, 120,
                    copper, 100,
                    铁板, 25


            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};
        辐射混合机 = new GenericCrafter("辐射混合机") {{
            localizedName = "辐射混合机";
            description = "";
            consumeItems(with(
                    thorium, 1, sand, 2, titanium, 1
            ));
            //consumeLiquid(辐射混合物, 3/60f);
            consumePower(140 / 60f);
            //outputItem = new ItemStack(放射混合物, 1);
            outputLiquid = new LiquidStack(辐射混合物, 12 / 60f);
            health = 350;
            itemCapacity = 10;
            size = 3;
            craftTime = 160;
            group = liquids;
            craftEffect = Fx.hitLaser;
            updateEffect = Fx.steam;
            updateEffectChance = 0.1F;
            liquidCapacity = 50;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    石英, 320,
                    copper, 130,
                    silicon, 80,
                    titanium, 80,
                    镍板, 40

            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

        矿物离心机 = new Separator("矿物离心机") {{
            localizedName = "矿物离心机";
            description = "";
            consumeLiquid(辐射混合物, 3 / 60f);
            consumePower(220 / 60f);

            results = with(
                    surgeAlloy, 70,
                    放射沙, 100,
                    金, 50,
                    铁, 50,
                    镍, 50,
                    钻石混合物, 50
            );
            health = 350;
            itemCapacity = 20;
            size = 3;
            craftTime = 20;
            group = transportation;
            //craftEffect = Fx.hitLaser;
            //updateEffect = Fx.steam;
            //updateEffectChance = 0.1F;
            liquidCapacity = 10;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    graphite, 80,
                    copper, 200,
                    铁板, 60,
                    titanium, 120,
                    镍板, 20
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

        粒子离心机 = new Separator("粒子离心机") {{
            localizedName = "粒子离心机";
            description = "";
            consumeLiquid(军用液体, 4 / 60f);
            consumePower(340 / 60f);

            results = with(
                    surgeAlloy, 4,
                    surgeAlloy, 60,
                    silicon, 130,
                    plastanium, 90,
                    铁板, 30,
                    钻石, 30
            );
            health = 420;
            group = transportation;
            itemCapacity = 50;
            size = 3;
            craftTime = 30;
            liquidCapacity = 10;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    titanium, 450,
                    graphite, 250,
                    铁板, 60,
                    啸动合金, 100
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

        黎辉离心机 = new Separator("资源产生器") {{
            localizedName = "黎辉离心机";
            description = "";
            consumeLiquid(军用液体, 2 / 60f);
            consumePower(630 / 60f);

            results = with(
                    surgeAlloy, 100,
                    钛合金, 80,
                    铁板, 50,
                    镍板, 50,
                    钻石, 35
            );
            health = 660;
            itemCapacity = 200;
            size = 5;
            group = transportation;
            craftTime = 5;
            liquidCapacity = 10;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    titanium, 450,
                    graphite, 250,
                    铁板, 60,
                    啸动合金, 100
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

        冷冻液发生机 = new GenericCrafter("冷冻液发生机") {{
            localizedName = "冷冻液发生机";
            description = "";
            consumeItems(with(
                    水瓶, 3, titanium, 3
            ));
            //consumeLiquid(辐射混合物, 3/60f);
            consumePower(160 / 60f);
            //outputItem = new ItemStack(放射混合物, 1);
            outputLiquid = new LiquidStack(Liquids.cryofluid, 60 / 60f);
            health = 350;
            itemCapacity = 10;
            size = 3;
            craftTime = 60;
            craftEffect = Fx.hitLaser;
            group = liquids;
            updateEffect = Fx.smeltsmoke;
            updateEffectChance = 0.1F;
            liquidCapacity = 200;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    石英, 120,
                    copper, 120,
                    silicon, 50,
                    titanium, 80,
                    lead, 100,
                    铁, 50,
                    钴, 10

            ));
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.cryofluid) {{
                drawLiquidLight = true;
            }}, new DrawDefault());

        }};


        制冷液混合机 = new GenericCrafter("制冷液混合机") {{
            localizedName = "制冷液混合机";
            description = "";
            consumeItems(with(
                    水瓶, 2, titanium, 4
            ));
            consumeLiquid(Liquids.cryofluid, 30 / 60f);
            consumePower(200 / 60f);
            //outputItem = new ItemStack(放射混合物, 1);
            outputLiquid = new LiquidStack(制冷液, 24 / 60f);
            health = 420;
            itemCapacity = 10;
            size = 3;
            craftTime = 80;
            group = liquids;
            craftEffect = Fx.hitLaser;
            updateEffect = Fx.smeltsmoke;
            updateEffectChance = 0.1F;
            liquidCapacity = 200;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    石英, 150,
                    copper, 150,
                    silicon, 80,
                    titanium, 100,
                    lead, 140,
                    铁, 50,
                    钻石混合物, 80

            ));
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.cryofluid) {{
                drawLiquidLight = true;
            }}, new DrawDefault());

        }};


//啸动合金后科技

        啸动冶炼机 = new GenericCrafter("啸动冶炼机") {{
            localizedName = "啸动冶炼机";
            description = "";
            consumeItems(with(
                    铁板, 7, 镍板, 6, 钛合金, 8,
                    surgeAlloy, 6
            ));
            //consumeLiquid(Liquids.water, 3/60f);
            consumePower(750 / 60f);
            outputItem = new ItemStack(啸动合金, 1);
            health = 720;
            itemCapacity = 25;
            size = 5;
            craftTime = 650;
            group = transportation;
            craftEffect = Fx.fireballsmoke;
            updateEffect = Fx.mine;
            updateEffectChance = 0.1F;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    石英, 300,
                    lead, 300,
                    铁板, 220,
                    silicon, 200,
                    镍板, 100,
                    固体放射物, 50


            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        军火材料机 = new GenericCrafter("军火材料机") {{
            localizedName = "军火材料机";
            description = "";
            consumeItems(with(
                    啸动合金, 1, 水瓶, 6, titanium, 2

            ));
            // consumeLiquid(制冷液, 12/60f);
            consumePower(480 / 60f);
            outputLiquid = new LiquidStack(军用液体, 48 / 60f);
            health = 650;
            itemCapacity = 16;
            size = 3;
            craftTime = 160;
            group = liquids;
            liquidCapacity = 200;
            craftEffect = Fx.fireballsmoke;
            updateEffect = Fx.steam;
            updateEffectChance = 0.1F;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    石英, 300,
                    copper, 200,
                    silicon, 100,
                    titanium, 100,
                    镍板, 170,
                    固体放射物, 80


            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        军火库 = new Separator("军火库") {{
            localizedName = "军火库";
            description = "";
            consumeLiquid(军用液体, 1.5f / 60f);
            consumePower(3200 / 60f);
            canOverdrive = false;//禁止超速
            results = with(
                    硬直弹, 1,
                    冷冻弹, 1,
                    碎裂弹, 1,
                    爆破弹, 1
            );
            health = 560;
            group = transportation;
            itemCapacity = 1000;
            size = 3;
            craftTime = 5;
            liquidCapacity = 10;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    graphite, 80,
                    copper, 300,
                    石英, 300,
                    lead, 300,
                    固体放射物, 300,
                    silicon, 200,
                    镍板, 100
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

////-----------
        水晶复合器 = new GenericCrafter("水晶复合器") {{
            localizedName = "水晶复合器";
            description = "";
            consumeItems(with(
                    钻石, 4, 固体放射物, 4, 啸动合金, 3, 电池, 3

            ));
            consumeLiquid(军用液体, 16 / 60f);
            consumePower(4300 / 60f);
            outputItem = new ItemStack(黎辉水晶, 1);
            health = 720;
            itemCapacity = 25;
            size = 5;
            craftTime = 300;
            group = transportation;
            liquidCapacity = 50;
            craftEffect = Fx.fireballsmoke;
            updateEffect = Fx.mine;
            updateEffectChance = 0.1F;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    固体放射物, 550,
                    thorium, 750,
                    钍电池, 400,
                    啸动合金, 250
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

        啸动冲击械 = new GenericCrafter("啸动冲击械") {{
            localizedName = "啸动冲击械";
            description = "";
            consumeItems(with(
                    水瓶, 3,
                    titanium, 2,
                    冷冻弹, 2,
                    啸动合金, 1

            ));
            consumeLiquid(制冷液, 48 / 60f);
            consumePower(5200 / 60f);
            // outputItem = new ItemStack(黎辉水晶, 1);
            outputLiquid = new LiquidStack(啸冷剂, 120 / 60);
            health = 1400;
            group = transportation;
            itemCapacity = 10;
            size = 5;
            craftTime = 120;
            liquidCapacity = 500;
            craftEffect = Fx.fireballsmoke;
            updateEffect = Fx.mine;
            updateEffectChance = 0.1F;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    silicon, 450,
                    镍板, 300,
                    碳板, 150,
                    啸动合金, 80
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        资源转换器_废料 = new GenericCrafter("回收中心") {{
            localizedName = "资源转换器-废料";
            description = "";
            consumeItems(with(
                    copper, 2,
                    lead, 2
            ));
            //  consumeLiquid(制冷液, 48/60f);
            consumePower(60 / 60f);
            outputItem = new ItemStack(scrap, 3);
            health = 180;
            itemCapacity = 10;
            size = 2;
            group = transportation;
            craftTime = 50;
            // liquidCapacity=10;
            //craftEffect = Fx.fireballsmoke;
            updateEffect = Fx.smoke;
            updateEffectChance = 0.1F;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    copper, 20,
                    石英, 110,
                    lead, 110,
                    铁, 50,
                    titanium, 50
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

        资源转换器_铜铅 = new GenericCrafter("资源转换器-铜铅") {{
            localizedName = "资源转换器-铜铅";
            description = "";
            consumeItems(with(
                    scrap, 3

            ));
            //  consumeLiquid(制冷液, 48/60f);
            consumePower(60 / 60f);
            outputItems = ItemStack.with(
                    copper, 2,
                    lead, 2
            );
            health = 180;
            group = transportation;
            itemCapacity = 10;
            size = 2;
            craftTime = 50;
            // liquidCapacity=10;
            //craftEffect = Fx.fireballsmoke;
            updateEffect = Fx.smoke;
            updateEffectChance = 0.1F;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    copper, 20,
                    石英, 110,
                    lead, 110,
                    铁, 50,
                    titanium, 50
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};


        资源转换器_钛 = new GenericCrafter("资源转换器-钛") {{
            localizedName = "资源转换器-钛";
            description = "";
            consumeItems(with(
                    thorium, 1,
                    lead, 2
            ));
            consumePower(90 / 60f);
            outputItem = new ItemStack(titanium, 2);
            //outputLiquid = new LiquidStack(啸冷剂, 120/60);
            health = 240;
            group = transportation;
            itemCapacity = 10;
            size = 2;
            craftTime = 20;
            //craftEffect = Fx.fireballsmoke;
            updateEffect = Fx.steam;
            updateEffectChance = 0.1F;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    石英, 220,
                    thorium, 170,
                    silicon, 140,
                    铁, 150,
                    titanium, 150,
                    钴, 140
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

        资源转换器_钍 = new GenericCrafter("资源转换器-钍") {{
            localizedName = "资源转换器-钍";
            description = "";
            consumeItems(with(
                    titanium, 2,
                    copper, 2
            ));
            consumePower(120 / 60f);
            outputItem = new ItemStack(thorium, 1);
            //outputLiquid = new LiquidStack(啸冷剂, 120/60);
            health = 240;
            itemCapacity = 10;
            size = 2;
            craftTime = 20;
            group = transportation;
            //craftEffect = Fx.fireballsmoke;
            updateEffect = Fx.steam;
            updateEffectChance = 0.1F;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    石英, 220,
                    thorium, 170,
                    silicon, 140,
                    铁, 150,
                    titanium, 150,
                    钴, 140
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

        资源转换器_钴 = new GenericCrafter("资源转换器-钴") {{
            localizedName = "资源转换器-钴";
            description = "";
            consumeItems(with(
                    plastanium, 3,
                    铁, 2

            ));
            consumePower(220 / 60f);
            outputItem = new ItemStack(钴, 3);
            //outputLiquid = new LiquidStack(啸冷剂, 120/60);
            health = 240;
            itemCapacity = 10;
            size = 2;
            craftTime = 70;
            group = transportation;
            //craftEffect = Fx.fireballsmoke;
            updateEffect = Fx.steam;
            updateEffectChance = 0.1F;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    石英, 220,
                    thorium, 200,
                    titanium, 100,
                    铁, 100
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

        资源转换器_镍 = new GenericCrafter("资源转换器-镍") {{
            localizedName = "资源转换器-镍";
            description = "";
            consumeItems(with(
                    plastanium, 3,
                    钴, 2

            ));
            consumePower(340 / 60f);
            outputItem = new ItemStack(镍, 4);
            //outputLiquid = new LiquidStack(啸冷剂, 120/60);
            health = 240;
            itemCapacity = 10;
            size = 2;
            craftTime = 50;
            group = transportation;
            //craftEffect = Fx.fireballsmoke;
            updateEffect = Fx.steam;
            updateEffectChance = 0.1F;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    石英, 220,
                    thorium, 200,
                    titanium, 100,
                    钴, 100
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

        资源转换器_塑钢 = new GenericCrafter("资源转换器-塑钢") {{
            localizedName = "资源转换器-塑钢";
            description = "";
            consumeItems(with(
                    phaseFabric, 2

            ));
            consumePower(480 / 60f);
            outputItem = new ItemStack(plastanium, 4);
            //outputLiquid = new LiquidStack(啸冷剂, 120/60);
            health = 240;
            itemCapacity = 10;
            size = 2;
            craftTime = 50;
            group = transportation;
            //craftEffect = Fx.fireballsmoke;
            updateEffect = Fx.steam;
            updateEffectChance = 0.1F;
            //ambientSoundVolume = 0.2f;
            //ambientSound = loadSound("shuisheng");
            requirements(crafting, with(
                    石英, 220,
                    thorium, 240,
                    silicon, 320,
                    铁, 120,
                    titanium, 100,
                    钴, 140
            ));
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
        }};

    }
}