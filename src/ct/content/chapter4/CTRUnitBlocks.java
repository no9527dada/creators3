package ct.content.chapter4;

import arc.Events;
import arc.struct.Seq;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.game.EventType;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.units.UnitCargoLoader;
import mindustry.world.blocks.units.UnitCargoUnloadPoint;
import mindustry.world.blocks.units.UnitFactory;


import static ct.content.chapter4.CTR3Unit4.*;
import static mindustry.type.ItemStack.with;

public class CTRUnitBlocks {
    public static Block T1Unit, T2Unit, T3Unit, T4Unit, T5Unit;
    public static Block T1hai, T2hai, T3hai, T4hai, T5hai;
    public static Block T2FU, T3FU, T4FU, T5FU;//盾兵
    public static Block kuangjiUnit;
    public static Block yunshu_shengcheng, yunshu_jiesou;

    public static void load() {

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
