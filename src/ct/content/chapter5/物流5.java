package ct.content.chapter5;


import ct.Asystem.type.CTTechTree;
import mindustry.content.Items;
import mindustry.entities.bullet.MassDriverBolt;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.liquid.Conduit;
import mindustry.world.blocks.liquid.LiquidBridge;
import mindustry.world.blocks.liquid.LiquidRouter;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.Env;

import static ct.Asystem.type.CTTechTree.addToTree;
import static ct.content.chapter5.资源.*;
import static mindustry.content.Blocks.*;
import static mindustry.content.Items.*;
import static mindustry.type.Category.*;
import static mindustry.type.ItemStack.with;


//
public class 物流5 {
    public static Block
            钴制导管, 硬速导管, 钴导管桥, 钍导管桥, 钍传送带桥, 动能卸货器, 钴传送带桥, 铝板连接器, 大型储液罐, 数据驱动器, 驱动器, 质量驱逐器, 大型仓库, 超大型仓库,
            质量转换终端, 战地仓库, 装甲啸动传送带, 铝板传送带, 啸动传送带, 装甲铝板传送带, 钴传送带, 装甲钴传送带, 钻石传送带,
            物流仓储;

    public static void load() {


        大型仓库 = new StorageBlock("大型仓库") {{
            localizedName = "大型仓库";
            requirements(effect, with(
                    titanium, 750,
                    石英, 550,
                    thorium, 450,
                    铁, 200,
                    金, 100
            ));
            health = 1000;
            itemCapacity = 3500;
            size = 4;
            group = BlockGroup.transportation;
        }};
        addToTree(大型仓库, vault);


        超大型仓库 = new StorageBlock("超大型仓库") {{
            localizedName = "超大型仓库";
            requirements(effect, with(
                    titanium, 950,
                    thorium, 650,
                    铁, 300,
                    石英, 750,
                    钴, 450,
                    石英, 750,
                    金, 250,
                    铝板, 100
            ));
            health = 1500;
            itemCapacity = 15000;
            size = 5;
            group = BlockGroup.transportation;
        }};
        addToTree(超大型仓库, 大型仓库);

        战地仓库 = new StorageBlock("战地仓库") {{
            localizedName = "战地仓库";
            requirements(effect, with(
                    copper, 1500,
                    lead, 1500,
                    titanium, 1000,
                    石英, 1000,
                    thorium, 800,
                    铁, 500,
                    钻石, 300,
                    铝板, 300
            ));
            health = 3000;
            itemCapacity = 50000;
            size = 8;
            group = BlockGroup.transportation;
        }};
        addToTree(战地仓库, 超大型仓库);

        铝板连接器 = new Junction("铝板连接器") {{
            localizedName = "铝板连接器";
            requirements(Category.distribution, with(
                    铝板, 40,
                    钴, 20

            ));
            consumesPower = true;
            outputsPower = true;
            hasPower = true;
            consumePower(0);
            capacity = 3;
            health = 140;
            speed = 1;
            group = BlockGroup.transportation;
        }};
        addToTree(铝板连接器, junction);

        钴传送带 = new Conveyor("钴传送带") {
            {
                localizedName = "钴传送带";
                requirements(distribution, with(
                        plastanium, 1,
                        钴, 1,
                        铁, 1,
                        金, 1
                ));
                health = 400;
                speed = 0.2f;
                buildCostMultiplier = 2f;
                researchCost = with(plastanium, 100,
                        钴, 100,
                        铁, 100,
                        金, 100);//研究成本
                group = BlockGroup.transportation;
            }

            @Override
            public void init() {
                super.init();

                junctionReplacement = junction;
                bridgeReplacement = 钴传送带桥;
            }
        };
        addToTree(钴传送带, armoredConveyor);

        装甲钴传送带 = new ArmoredConveyor("装甲钴传送带") {
            {
                localizedName = "装甲钴传送带";
                requirements(distribution, with(
                        plastanium, 2,
                        钴, 3,
                        铁, 3,
                        金, 2

                ));
                health = 130;
                speed = 0.2f;
                buildCostMultiplier = 2f;
                researchCost = with(plastanium, 200,
                        钴, 300,
                        铁, 300,
                        金, 200);//研究成本
                group = BlockGroup.transportation;
            }

            @Override
            public void init() {
                super.init();

                junctionReplacement = junction;
                bridgeReplacement = 钴传送带桥;
            }
        };
        addToTree(装甲钴传送带, 钴传送带);

        铝板传送带 = new Conveyor("铝板传送带") {
            {
                localizedName = "铝板传送带";
                requirements(distribution, with(
                        铝板, 1,
                        固体放射物, 1

                ));
                health = 130;
                speed = 0.5f;
                buildCostMultiplier = 2f;
                researchCost = with(铝板, 100,
                        固体放射物, 100);//研究成本
                group = BlockGroup.transportation;
            }

            @Override
            public void init() {
                super.init();

                junctionReplacement = 铝板连接器;
                bridgeReplacement = 钴传送带桥;
            }
        };
        addToTree(铝板传送带, 钴传送带);

        装甲铝板传送带 = new ArmoredConveyor("装甲铝板传送带") {
            {
                localizedName = "装甲铝板传送带";
                requirements(distribution, with(
                        铝板, 1,
                        固体放射物, 3,
                        金, 3

                ));
                health = 180;
                speed = 0.5f;
                buildCostMultiplier = 2f;
                researchCost = with(
                        铝板, 100,
                        固体放射物, 300,
                        金, 300);//研究成本
                group = BlockGroup.transportation;
            }

            @Override
            public void init() {
                super.init();

                junctionReplacement = 铝板连接器;
                bridgeReplacement = 钴传送带桥;
            }
        };
        addToTree(装甲铝板传送带, 铝板传送带);

        啸动传送带 = new Conveyor("啸动传送带") {
            {
                localizedName = "啸动传送带";
                requirements(distribution, with(
                        钛合金, 10,
                        surgeAlloy, 10,
                        铁板, 10,
                        铝板, 10

                ));
                buildCostMultiplier = 15;
                health = 1000;
                speed = 1.5f;
                researchCost = with(
                        钛合金, 200,
                        surgeAlloy, 800,
                        铁板, 800,
                        铝板, 800);//研究成本
                group = BlockGroup.transportation;
            }

            @Override
            public void init() {
                super.init();

                junctionReplacement = 铝板连接器;
                bridgeReplacement = 钴传送带桥;
            }
        };
        addToTree(啸动传送带, 铝板传送带);

        装甲啸动传送带 = new ArmoredConveyor("装甲啸动传送带") {
            {
                localizedName = " 装甲啸动传送带";
                requirements(distribution, with(
                        钴, 20,
                        钛合金, 10,
                        钻石, 10


                ));
                buildCostMultiplier = 15;
                health = 1000;
                speed = 1.5f;
                researchCost = with(
                        钴, 1200,
                        钛合金, 200,
                        钻石, 800

                );//研究成本
                group = BlockGroup.transportation;
            }

            @Override
            public void init() {
                super.init();

                junctionReplacement = 铝板连接器;
                bridgeReplacement = 钴传送带桥;
            }
        };
        addToTree(装甲啸动传送带, 铝板传送带);

        钻石传送带 = new StackConveyor("钻石传送带") {{
            localizedName = "钻石传送带";
            requirements(distribution, with(
                    钴, 20,
                    钛合金, 10,
                    surgeAlloy, 10,
                    铁板, 10,
                    铝板, 10
            ));
            health = 330;
            speed = 8f / 60f;
            itemCapacity = 30;

            outputRouter = false;
            hasPower = true;
            consumesPower = true;
            conductivePower = true;
            group = BlockGroup.transportation;
            underBullets = true;
            baseEfficiency = 1f;
            consumePower(10f / 60f);
            group = BlockGroup.transportation;
            researchCost = with(surgeAlloy, 30, tungsten, 80);
        }};
        addToTree(钻石传送带, 装甲啸动传送带);

        钍传送带桥 = new ItemBridge("钍传送带桥") {{
            localizedName = "钍传送带桥";
            health = 120;
            requirements(Category.distribution, with(
                    copper, 30,
                    Items.silicon, 10,
                    thorium, 15
            ));
            envEnabled |= Env.space;
            range = 7;
            pulse = true;
            itemCapacity = 20;
            arrowPeriod = 0.9f;
            arrowTimeScl = 2.75f;
            transportTime = 2f;
            group = BlockGroup.transportation;
            //  arrowSpacing = 6f;
            // bufferCapacity = 14;
        }};
        addToTree(钍传送带桥, conveyor);

        钴传送带桥 = new BufferedItemBridge("钴传送带桥") {
            {
                localizedName = "钴传送带桥";
                requirements(Category.distribution, with(
                        Items.plastanium, 30,
                        钴, 55,
                        thorium, 60,
                        石英, 30
                ));
                arrowPeriod = 0.9f;
                arrowTimeScl = 2.75f;
                itemCapacity = 20;
                fadeIn = moveArrows = false;
                range = 50;
                speed = 0;
                transportTime = 0.001f;
                health = 210;
                group = BlockGroup.transportation;
                buildType = Build::new;
            }

            class Build extends BufferedItemBridgeBuild {
                public boolean timer(int index, float time) {
                    return super.timer(index, time / 1000f);
                }
            }
        };
        addToTree(钴传送带桥, 钍传送带桥);

        动能卸货器 = new Unloader("动能卸货器") {
            {
                health = 350;
                requirements(Category.effect, with(石英, 175,
                        金, 125,
                        钻石混合物, 30,
                        Items.titanium, 125, Items.silicon, 130));
                speed = 60f / 200f;
                group = BlockGroup.transportation;
                buildType = Build::new;
            }

            float limit = 30f / 100;

            class Build extends UnloaderBuild {
                int counter = 0;

                public void updateTile() {
                    counter += this.edelta();

                    while (counter >= limit) {
                        this.unloadTimer = speed;

                        super.updateTile();

                        counter -= limit;
                    }
                }
            }
        };
        addToTree(动能卸货器, unloader);

        驱动器 = new MassDriver("驱动器") {{
            localizedName = "驱动器";
            requirements(distribution, with(
                    silicon, 40,
                    titanium, 50,
                    铁, 20,
                    lead, 100
            ));
            size = 1;
            itemCapacity = 45;
            reload = 60f;
            range = 25 * 8f;
            knockback = 1;
            health = 150;
            shake = 0f;
            rotateSpeed = 5;//转速
            minDistribute = itemCapacity / 2;
            bullet = new MassDriverBolt();
            consumePower(1f);
            group = BlockGroup.transportation;
        }};
        addToTree(驱动器, massDriver);

        数据驱动器 = new MassDriver("数据驱动器") {{
            localizedName = "数据驱动器";
            requirements(distribution, with(
                    silicon, 50,
                    titanium, 75,
                    铁, 40,
                    thorium, 150
            ));
            size = 2;
            itemCapacity = 75;
            reload = 80f;
            range = 60 * 8f;
            knockback = 3;
            health = 150;
            shake = 0.3f;
            rotateSpeed = 5;//转速
            minDistribute = itemCapacity / 2;
            bullet = new MassDriverBolt();
            consumePower(1f);
            group = BlockGroup.transportation;
        }};
        addToTree(数据驱动器, 驱动器);


        质量转换终端 = new MassDriver("质量转换终端") {{
            localizedName = "质量转换终端";
            requirements(distribution, with(
                    lead, 375,
                    titanium, 375,
                    thorium, 150,
                    silicon, 210,
                    铁, 180,
                    铝板, 50,
                    相织硅, 50
            ));
            minDistribute = itemCapacity / 2;
            size = 4;
            itemCapacity = 300;
            reload = 120f;
            range = 90 * 8;
            knockback = 6;
            health = 500;
            shake = 0.5f;
            consumePower(4f);
            group = BlockGroup.transportation;
        }};
        addToTree(质量转换终端, massDriver);
        质量驱逐器 = new MassDriver("质量驱逐器") {
            {
                localizedName = "质量驱逐器";
                requirements(distribution, with(
                        silicon, 450,
                        titanium, 370,
                        啸动合金, 150,
                        铝板, 270,
                        相织硅, 350
                ));
                size = 4;
                itemCapacity = 750;
                reload = 120f;
                range = 150 * 8f;
                knockback = 8;
                health = 800;
                shake = 0.5f;
                bulletLifetime = 1000;
                minDistribute = itemCapacity / 2;
                bullet = new MassDriverBolt();
                consumePower(15f);
                group = BlockGroup.transportation;
                buildType = Build::new;
            }

            class Build extends MassDriverBuild {
                public void updateTile() {
                    super.updateTile();
                    if (this.state == MassDriver.DriverState.idle || this.state == MassDriver.DriverState.accepting) {
                        var Times = 20;//输出速度倍率写 2 总输出速度为默认的 200%
                        for (var i = 0; i < Times; i++) {
                            this.dumpAccumulate();
                        }
                    }
                }
            }
        };
        addToTree(质量驱逐器, 质量转换终端);


        大型储液罐 = new LiquidRouter("大型储液罐") {{
            localizedName = "大型储液罐";
            requirements(liquid, with(
                    titanium, 135,
                    metaglass, 100,
                    铁, 30,
                    钴, 10
            ));
            size = 4;
            solid = true;
            liquidCapacity = 5000;
            health = 700;

        }};
        addToTree(大型储液罐, liquidTank);

        钴制导管 = new Conduit("钴制导管") {
            {
                localizedName = "钴制导管";
                requirements(liquid, with(
                        plastanium, 1,
                        metaglass, 2,
                        钴, 1

                ));
                liquidCapacity = 30;
                health = 240;

            }

            @Override
            public void init() {
                super.init();

                // junctionReplacement = junction;
                bridgeReplacement = 钴导管桥;
            }
        };
        addToTree(钴制导管, liquidTank);

        硬速导管 = new Conduit("硬速导管") {
            {
                localizedName = "硬速导管";
                requirements(liquid, with(
                        plastanium, 5,
                        metaglass, 5,
                        钴, 10,
                        铁, 3
                ));
                liquidCapacity = 30;
                health = 240;

            }

            @Override
            public void init() {
                super.init();

                // junctionReplacement = junction;
                bridgeReplacement = 钴导管桥;
            }
        };
        addToTree(硬速导管, 钴制导管);

        钍导管桥 = new LiquidBridge("钍导管桥") {{
            localizedName = "钍导管桥";
            requirements(liquid, with(

                    lead, 20,
                    metaglass, 30,
                    thorium, 15
            ));
            liquidCapacity = 20;
            health = 120;

            //fadeIn = moveArrows = false;
            // arrowSpacing = 6f;
            range = 7;
            hasPower = false;
        }};
        addToTree(钍导管桥, phaseConduit);

        钴导管桥 = new LiquidBridge("钴导管桥") {{
            localizedName = "钴导管桥";
            requirements(liquid, with(
                    copper, 80,
                    lead, 70,
                    plastanium, 40,
                    metaglass, 55,
                    钴, 35,
                    铁, 35
            ));
            liquidCapacity = 30;
            health = 240;

            // fadeIn = moveArrows = false;
            //arrowSpacing = 6f;
            range = 50;
            hasPower = false;
        }};
        addToTree(钴导管桥, 钴制导管);


    }


}