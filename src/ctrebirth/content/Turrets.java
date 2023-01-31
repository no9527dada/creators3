package ctrebirth.content;

import ctrebirth.type.CTBulletTypes;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.meta.BuildVisibility;


import static ctrebirth.type.CTBulletTypes.*;
import static ctrebirth.content.CTItem.*;
import static mindustry.type.ItemStack.with;

public class Turrets {



    public static Block
            测试炮塔,小旋风,


    炮塔;

    public static void load() {
        CTBulletTypes.load();
/*
* targetAir = true; //空
ZhengFu.targetGround = false; //地
outputsPower = true;//相互导电
consume(new ConsumeCoolant(0.2));//需求的电力
* inaccuracy = 8; //精准
*
*
* */
         测试炮塔 = new ItemTurret("测试炮塔") {{
            requirements(Category.turret, with());
            reload = 120f;
            range = 410;
            shootCone = 25f;
            rotateSpeed = 20f;
            ammo(
                    魂石, 小旋风子弹1,
                    灵石,导弹1,
                    Items.copper,laser01,
                    Items.coal,遗落,
                    Items.lead,记挂,
                    Items.graphite,艺璇,
                    Items.sand,艺璇2
            );
        }};
        小旋风 = new ItemTurret("小旋风") {{
            requirements(Category.turret, with(Items.copper, 35));
            ammo(
                    魂石, 小旋风子弹1
            );

           // shoot = new ShootAlternate(3.5f);//多炮管时的发射间距

            shootY = 3f;
            reload = 20f;
            range = 110;
            shootCone = 15f;
            ammoUseEffect = Fx.casing1;
            health = 250;
            inaccuracy = 2f; //精准
            rotateSpeed = 10f;//炮塔旋转速度
            coolant = consumeCoolant(0.1f);//消耗的液体数量 1：60
            researchCostMultiplier = 0.05f;//科技树中的研究资源倍率
            buildVisibility = BuildVisibility.shown;
            limitRange();
        }};

    }
}
