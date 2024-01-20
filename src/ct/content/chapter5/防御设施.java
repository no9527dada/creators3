package ct.content.chapter5;

import mindustry.content.Items;
import mindustry.world.Block;
import mindustry.world.blocks.defense.OverdriveProjector;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.units.RepairTurret;
import mindustry.world.meta.Env;


import static ct.Asystem.type.CTTechTree.addToTree;
import static ct.content.chapter5.资源.*;
import static mindustry.content.Blocks.*;
import static mindustry.content.Items.*;
import static mindustry.type.Category.*;
import static mindustry.type.ItemStack.with;

//方块
public class 防御设施 {
    public static Block 聚能投影械, 增幅投影器, 极速投影器, 大型维修点, 铅墙, 大型铅墙, 硅墙, 大型硅墙, 相织硅墙, 大型相织硅墙, 钴墙, 大型钴墙, 钛合金墙, 大型钛合金墙, 巨型钛合金墙, 超大型钛合金墙;

    public static void load() {
        // 铅墙
        铅墙 = new Wall("铅墙") {{
            localizedName = "铅墙";
            requirements(defense, with(lead, 4));
            health = 320;
            size = 1;
            envDisabled |= Env.scorching;
        }};

        // 大型铅墙
        大型铅墙 = new Wall("大型铅墙") {{
            localizedName = "大型铅墙";
            requirements(defense, with(lead, 24));
            health = 1300;
            size = 2;
            envDisabled |= Env.scorching;
        }};


        // 硅墙
        硅墙 = new Wall("硅墙") {{
            localizedName = "硅墙";
            requirements(defense, with(silicon, 4));
            chanceDeflect = 3f;
            flashHit = true;
            health = 550;
            size = 2;
            envDisabled |= Env.scorching;
        }};


        // 大型硅墙
        大型硅墙 = new Wall("大型硅墙") {{
            localizedName = "大型硅墙";
            requirements(defense, with(silicon, 24));
            chanceDeflect = 5f;
            flashHit = true;
            health = 2200;
            size = 2;
            envDisabled |= Env.scorching;
        }};


        // 相织硅墙
        相织硅墙 = new Wall("相织硅墙") {{
            localizedName = "相织硅墙";
            requirements(defense, with(相织硅, 20, 铝板, 10));
            chanceDeflect = 10;
            flashHit = true;
            health = 1850;
            size = 2;
            envDisabled |= Env.scorching;
        }};


        // 大型相织硅墙
        大型相织硅墙 = new Wall("大型相织硅墙") {{
            localizedName = "大型相织硅墙";
            requirements(defense, with(相织硅, 100, 铝板, 40));
            chanceDeflect = 20f;
            flashHit = true;
            health = 7250;
            size = 2;
            envDisabled |= Env.scorching;
        }};


        // 钴墙
        钴墙 = new Wall("钴墙") {{
            localizedName = "钴墙";
            requirements(defense, with(钴, 100, surgeAlloy, 70));
            lightningChance = 0.1f;
            lightningDamage = 15;
            lightningLength = 10;
            health = 3000;
            size = 1;
            buildCostMultiplier = 5;
            envDisabled |= Env.scorching;
        }};


        // 大型钴墙
        大型钴墙 = new Wall("大型钴墙") {{
            localizedName = "大型钴墙";
            requirements(defense, with(钴, 350, surgeAlloy, 120));
            lightningChance = 0.1f;
            lightningDamage = 20;
            lightningLength = 15;
            health = 10000;
            size = 2;
            buildCostMultiplier = 7;
            envDisabled |= Env.scorching;
        }};


        钛合金墙 = new Wall("钛合金墙") {{
            localizedName = "钛合金墙";
            requirements(defense, with(钛合金, 10, 固体放射物, 10));
            health = 1000;
            size = 1;
            buildCostMultiplier = 10;
            envDisabled |= Env.scorching;
        }};


        大型钛合金墙 = new Wall("大型钛合金墙") {{
            localizedName = "大型钛合金墙";
            requirements(defense, with(钛合金, 60, 固体放射物, 30));
            health = 3200;
            size = 2;
            buildCostMultiplier = 10;
            envDisabled |= Env.scorching;
        }};


        巨型钛合金墙 = new Wall("巨型钛合金墙") {{
            localizedName = "巨型钛合金墙";
            requirements(defense, with(钛合金, 170, 固体放射物, 70));
            health = 8000;
            size = 3;
            buildCostMultiplier = 10;
            envDisabled |= Env.scorching;
        }};


        超大型钛合金墙 = new Wall("超大型钛合金墙") {{
            localizedName = "超大型钛合金墙";
            requirements(defense, with(钛合金, 350, 固体放射物, 120, 钴, 210));
            health = 15500;
            size = 4;
            buildCostMultiplier = 10;
            envDisabled |= Env.scorching;
        }};

//功能
        大型维修点 = new RepairTurret("大型维修点") {{
            localizedName = "大型维修点";
            repairSpeed = 0.45f;
            repairRadius = 150;
            beamWidth = 0.73f;
            powerUse = 3.5f;
            pulseRadius = 150f;

            requirements(units, with(
                    copper, 60,
                    lead, 60,
                    silicon, 35,
                    钴, 10
            ));
            health = 150;
            size = 2;

        }};
        addToTree(大型维修点, repairPoint);


        极速投影器 = new OverdriveProjector("极速投影器") {{
            localizedName = "极速投影器";
            health = 480;
            range = 25 * 8;//范围
            phaseRangeBoost = 8 * 8f;//范围加成
            speedBoost = 2.8f;//加速
            speedBoostPhase = 1f;//加速加成
            useTime = 320;
            requirements(effect, with(
                    lead, 300,
                    titanium, 220,
                    silicon, 240,
                    plastanium, 120,
                    金, 100,
                    钴, 80,
                    相织硅, 80,
                    钻石, 30
            ));
            consumePower(2300 / 60f);
            size = 3;
            consumeItem(相织硅).boost();
        }};
        addToTree(极速投影器, repairPoint);

        增幅投影器 = new OverdriveProjector("增幅投影器") {{
            localizedName = "增幅投影器";
            health = 480 + 250;
            range = 33 * 8;//范围
            phaseRangeBoost = 9 * 8f;//范围加成
            speedBoost = 3;//加速
            speedBoostPhase = 1.5f;//加速加成
            useTime = 450;
            requirements(effect, with(
                    lead, 300,
                    titanium, 220,
                    silicon, 240,
                    plastanium, 120,
                    啸动合金, 75,
                    铝板, 80,
                    相织硅, 280,
                    钻石, 130
            ));
            consumePower(7400 / 60f);
            size = 3;
            consumeItem(电池, 5).boost();
        }};
        addToTree(增幅投影器, 极速投影器);

        聚能投影械 = new OverdriveProjector("聚能投影械") {{
            localizedName = "聚能投影械";
            health = 480 + 250 + 530;
            range = 42 * 8;//范围
            phaseRangeBoost = 13 * 8f;//范围加成
            speedBoost = 4.8f;//加速
            speedBoostPhase = 1f;//加速加成
            useTime = 450;
            requirements(effect, with(
                    lead, 300,
                    titanium, 220,
                    silicon, 240,
                    plastanium, 120,
                    啸动合金, 75,
                    铝板, 80,
                    相织硅, 280,
                    钻石, 130
            ));
            consumePower(28000 / 60f);
            size = 4;
            consumeItem(放射混合物).boost();
        }};
        addToTree(聚能投影械, 增幅投影器);


    }
}