package ct.content.chapter5;

import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.Env;


import static ct.Asystem.type.CTTechTree.addToTree;
import static ct.content.chapter5.资源5.*;
import static mindustry.content.Blocks.*;
import static mindustry.content.Fx.*;
import static mindustry.content.Items.*;
import static mindustry.gen.Sounds.respawning;
import static mindustry.type.Category.*;
import static mindustry.type.ItemStack.with;

//
public class 钻头水泵5 {
    public static Block
            大型培养机, 液体离心机, 金刚钻头, 合金钻头, 动能泵, 中型机械钻头, 大型机械钻头, 中型抽水机, 大型抽水机, 大型机械泵, 超大型机械泵;

    public static void load() {
        大型机械泵 = new Pump("大型机械泵") {{
            localizedName = "大型机械泵";
            requirements(liquid, with(
                    Items.lead, 100,
                    copper, 100,
                    metaglass, 45,
                    石英, 30

            ));
            pumpAmount = 0.125f;
            health = 80;
            size = 2;
            liquidCapacity = 30f;
        }};
        addToTree(大型机械泵, mechanicalPump);

        超大型机械泵 = new Pump("超大型机械泵") {{
            localizedName = "超大型机械泵";
            requirements(liquid, with(
                    Items.lead, 150,
                    copper, 150,
                    metaglass, 75,
                    石英, 80,
                    铁, 80,
                    金, 45

            ));
            pumpAmount = 60 / 60 / 9f;
            health = 130;
            size = 3;
            liquidCapacity = 50;
        }};
        addToTree(超大型机械泵, 大型机械泵);

        动能泵 = new Pump("动能泵") {{
            localizedName = "动能泵";
            consumePower(2.5f);
            requirements(liquid, with(
                    copper, 180,
                    metaglass, 150,
                    titanium, 135,
                    钴, 120,
                    silicon, 100,
                    镍板, 80,
                    固体放射物, 20

            ));
            pumpAmount = 360 / 60 / 16F;
            health = 550;
            size = 4;
            liquidCapacity = 300;
        }};
        addToTree(动能泵, 大型机械泵);


        中型抽水机 = new SolidPump("中型抽水机") {{
            localizedName = "中型抽水机";
            consumePower(1f);

            requirements(production, with(
                    copper, 60,

                    graphite, 40,
                    镍, 30,
                    镍板, 10,
                    lead, 50


            ));
            result = Liquids.water;
            pumpAmount = 0.21348F;
            health = 220;
            size = 2;
            liquidCapacity = 30;
        }};
        addToTree(中型抽水机, waterExtractor);

        大型抽水机 = new SolidPump("大型抽水机") {{
            localizedName = "大型抽水机";
            consumePower(2.5f);

            requirements(production, with(
                    copper, 150,
                    石英, 125,
                    graphite, 70,
                    镍, 80,
                    镍板, 55,
                    铁板, 10,
                    钛合金, 5

            ));
            result = Liquids.water;
            pumpAmount = 0.56413184F;
            health = 280;
            size = 3;
            liquidCapacity = 30;
        }};
        addToTree(大型抽水机, 中型抽水机);

        液体离心机 = new SolidPump("液体离心机") {{
            localizedName = "液体离心机";
            consumePower(4f);
            consumeLiquid(Liquids.water, 12f / 60f);
            requirements(production, with(
                    titanium, 120,
                    silicon, 80,
                    graphite, 70,
                    铁, 80,
                    相织硅, 250


            ));
            attribute = Attribute.water;
            result = Liquids.cryofluid;
            pumpAmount = 3 / 60F;
            health = 500;
            size = 2;
            liquidCapacity = 30;
            updateEffect = smeltsmoke;
            ambientSound = respawning;
            ambientSoundVolume = 0.5f;
        }};
        addToTree(液体离心机, 大型抽水机);


        中型机械钻头 = new Drill("中型机械钻头") {{
            localizedName = "中型机械钻头";
            // consumePower(2.5f);
            consumeLiquid(Liquids.water, 0.07f).boost();
            requirements(production, with(
                    copper, 100,
                    lead, 80,
                    metaglass, 30
            ));
            tier = 3;
            drillTime = 550F;
            health = 230;
            size = 3;

        }};
        addToTree(中型机械钻头, mechanicalDrill);

        大型机械钻头 = new Drill("大型机械钻头") {{
            localizedName = "大型机械钻头";
            // consumePower(2.5f);
            consumeLiquid(Liquids.water, 0.09f).boost();
            requirements(production, with(
                    copper, 150,
                    lead, 120,
                    graphite, 50,
                    石英, 80
            ));
            tier = 4;
            drillTime = 450;
            health = 300;
            size = 4;

        }};
        addToTree(大型机械钻头, 中型机械钻头);

        金刚钻头 = new Drill("金刚钻头") {{
            localizedName = "金刚钻头";
            consumePower(4f);
            consumeLiquid(Liquids.cryofluid, 0.05f).boost();
            requirements(production, with(
                    石英, 225,
                    钻石, 30,
                    lead, 200,
                    铁, 150,
                    silicon, 150,
                    镍板, 30

            ));
            drillEffect = hitBulletBig;
            hardnessDrillMultiplier = 2.5f;
            drawMineItem = true;
            tier = 8;
            rotateSpeed = 7;
            drillTime = 110;
            health = 320;
            size = 3;

        }};
        addToTree(金刚钻头, blastDrill);


        合金钻头 = new Drill("合金钻头") {{
            localizedName = "合金钻头";
            consumePower(20f);
            consumeLiquid(Liquids.cryofluid, 0.1f);
            requirements(production, with(
                    石英, 550,
                    钻石, 225,
                    啸动合金, 65
            ));
            drillEffect = hitBulletBig;
            hardnessDrillMultiplier = 2.5f;
            drawMineItem = true;
            tier = 10;
            rotateSpeed = 10;
            drillTime = 75;
            health = 550;
            size = 3;

        }};
        addToTree(合金钻头, 金刚钻头);


        大型培养机 = new AttributeCrafter("大型培养机") {{
            localizedName = "大型培养机";
            requirements(production, with(
                    copper, 150,
                    lead, 100,
                    silicon, 80,
                    铁, 20
            ));
            liquidCapacity = 60f;
            health = 100;
            outputItem = new ItemStack(Items.sporePod, 3);
            craftTime = 122;
            size = 3;
            hasLiquids = true;
            hasPower = true;
            hasItems = true;
            updateEffectChance = 0.1F;
            craftEffect = none;
            envRequired |= Env.spores;
            attribute = Attribute.spores;
            itemCapacity = 15;
            legacyReadWarmup = true;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.water),
                    new DrawDefault(),
                    new DrawCultivator(),
                    new DrawRegion("-top")
            );
            maxBoost = 2f;

            consumePower(2);
            consumeLiquid(Liquids.water, 0.5f);
        }};
        addToTree(大型培养机, cultivator);


    }


}