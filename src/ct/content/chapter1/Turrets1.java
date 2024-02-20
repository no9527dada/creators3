package ct.content.chapter1;

import arc.Core;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.entities.bullet.ShrapnelBulletType;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.meta.BuildVisibility;


import static ct.content.Bullets.Bullets1.*;
import static ct.content.chapter1.Item1.*;
import static mindustry.type.ItemStack.with;

/**
 * /**图标的颜色
 * public Color outlineColor = Color. valueof ("404049");
 * /**是否添加了任何图标区域的轮廓。* /
 * public boolean outlineIcon = false;
 * /**轮廓图标半径。* /
 * public int outlineRadius = 4;
 * /**哪个图标区域的轮廓被添加。如果<= 0则使用最后一个图标。* /
 * public int outlinedIcon = -1;
 * researchCostMultiplier =1.2f;//科技树中的研究资源倍率
 */

public class Turrets1 {
    public static Block 月牙, 闪电链, 墨雪, 刺镰, 赤狐, 宏裂;

    public static void load() {
        月牙 = new ItemTurret("月牙") {{
            localizedName = Core.bundle.get("Turret.yueya");
            description = Core.bundle.getOrNull("Turret.description.yueya");
            requirements(Category.turret, with(陶, 70));
            ammo(
                    陶, 陶月牙,
                    翠, 翠月牙,
                    运符, 运符月牙
            );

            // shoot = new ShootAlternate(3.5f);//多炮管时的发射间距
            outlineColor = Color.valueOf("404049");
            outlineRadius = 1;
            shootY = 3f;
            reload = 20f;
            range = 150;
            armor = 2f;
            shootCone = 15f;
            ammoUseEffect = Fx.casing1;
            health = 280;
            inaccuracy = 2f; //精准
            rotateSpeed = 10f;//炮塔旋转速度
            coolant = consumeCoolant(0.1f);//消耗的液体数量 1：60
            researchCostMultiplier = 1.5f;//科技树中的研究资源倍率
            buildVisibility = BuildVisibility.shown;
            limitRange();
        }};
        闪电链 = new PowerTurret("闪电链") {{
            localizedName = Core.bundle.get("Turret.sandian");
            description = Core.bundle.getOrNull("Turret.description.sandian");
            requirements(Category.turret, with(陶, 70, 幻烬, 20));
            outlineRadius = 1;
            targetAir = false;//对空

            shootType =

                    new LightningBulletType() {{
                        damage = 20;
                        lightningLength = 20;
                        lightningLengthRand = 30;
                        collidesAir = true;//空中
                        ammoMultiplier = 1f;

                        //for visual stats only.
                        //  buildingDamageMultiplier = 0.25f;

                        lightningType = new BulletType(0.0001f, 0f) {{
                            lifetime = Fx.lightning.lifetime;
                            hitEffect = Fx.hitLancer;
                            despawnEffect = Fx.none;
                            status = StatusEffects.shocked;
                            statusDuration = 10f;
                            hittable = false;
                            lightColor = Color.white;
                            collidesAir = true;
                            buildingDamageMultiplier = 0.25f;
                        }};
                    }};
            shoot.shots = 2;
            shoot.shotDelay = 5f;
            reload = 50f;
            shootCone = 40f;
            rotateSpeed = 8f;
            targetAir = true;
            range = 110f;
            shootEffect = Fx.lightningShoot;
            heatColor = Color.red;
            recoil = 1f;
            size = 1;
            health = 260;
            shootSound = Sounds.spark;
            consumePower(180 / 60f);
            coolant = consumeCoolant(0.1f);
        }};

        墨雪 = new ItemTurret("墨雪") {{
            localizedName = Core.bundle.get("Turret.moxue");
            description = Core.bundle.getOrNull("Turret.description.moxue");
            requirements(Category.turret, with(幻烬, 40, 翠, 120, 陶, 150));
            ammo(
                    幻烬, 幻烬墨雪,
                    灵玉, 灵玉墨雪,
                    运符, 运符墨雪,
                    缕, 缕墨雪
            );
            buildCostMultiplier = 0.7f;//建造时间倍率
            outlineRadius = 3;
            //shootSound = loadSound("nu1");
            shootSound = Sounds.shootBig;
            size = 2;
            range = 190f;
            reload = 70f;
            consumeAmmoOnce = false;
            ammoEjectBack = 3f;
            recoil = 1f;
            shake = 1f;
            shoot.shots = 3;
            shoot.shotDelay = 3f;
            ammoUseEffect = Fx.casing2;
            scaledHealth = 240;
            // shoot = new ShootAlternate(3.5f);//多炮管时的发射间距
            shootY = 3f;
            shootCone = 15f;
            health = 280;
            inaccuracy = 2f; //精准
            rotateSpeed = 10f;//炮塔旋转速度
            coolant = consumeCoolant(0.1f);//消耗的液体数量 1：60
            researchCostMultiplier = 1.2f;//科技树中的研究资源倍率
            buildVisibility = BuildVisibility.shown;
            limitRange();
        }};
        刺镰 = new PowerTurret("刺镰") {{
            localizedName = Core.bundle.get("Turret.cilian");
            description = Core.bundle.getOrNull("Turret.description.cilian");
            requirements(Category.turret, with(缕, 45, 灵玉, 30, 翠, 120));
            range = 185f;

            shoot.firstShotDelay = 40f;

            recoil = 2f;
            reload = 55f;
            shake = 2f;
            shootEffect = Fx.lancerLaserShoot;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            size = 2;
            health = 780;
            targetAir = false;
            moveWhileCharging = false;
            accurateDelay = false;
            shootSound = Sounds.laser;
            coolant = consumeCoolant(0.2f);

            consumePower(6f);
            researchCostMultiplier = 1.5f;//科技树中的研究资源倍率
            shootType = Bullet刺镰;
        }};
        赤狐 = new ItemTurret("赤狐") {{
            localizedName = Core.bundle.get("Turret.cihu");
            description = Core.bundle.getOrNull("Turret.description.cihu");
            requirements(Category.turret, with(
                    缕, 50, 幻烬, 150, 翠, 90, 陶, 50
            ));
            ammo(
                    缕, 缕赤狐,
                    幻烬, 幻烬赤狐,
                    灵玉, 灵玉赤狐,
                    血晶, 血晶赤狐,
                    威灵, 威灵赤狐
            );
            targetAir = false;
            reload = 70f;
            recoil = 2f;
            range = 235 + 8 * 8f;
            inaccuracy = 1f;
            size = 2;
            shootCone = 10f;
            health = 700;
            researchCostMultiplier = 1.5f;//科技树中的研究资源倍率
            shootSound = Sounds.bang;
            coolant = consumeCoolant(0.1f);
            limitRange(0f);
        }};
        宏裂 = new ItemTurret("宏裂") {{
            localizedName = Core.bundle.get("Turret.honglie");
            description = Core.bundle.getOrNull("Turret.description.honglie");
            requirements(Category.turret, with(缕, 150, 血晶, 30, 翠, 250, 威灵, 50));

            reload = 35f;
            shake = 4f;
            range = 28 * 8f;
            recoil = 5f;

            shoot = new ShootSpread(3, 10f);

            shootCone = 30;
            size = 3;

            researchCostMultiplier = 1.8f;//科技树中的研究资源倍率
            health = 760;
            shootSound = Sounds.shotgun;
            coolant = consumeCoolant(0.3f);

            float brange = range + 10f;

            ammo(
                    缕, new ShrapnelBulletType() {{
                        length = brange;
                        damage = 66f;
                        ammoMultiplier = 2f;
                        width = 17f;
                        reloadMultiplier = 1.3f;
                        toColor = 缕.color;
                    }},
                    血晶, new ShrapnelBulletType() {{
                        length = brange;
                        damage = 105f;
                        ammoMultiplier = 5f;
                        toColor = 血晶.color;
                        shootEffect = smokeEffect = Fx.thoriumShoot;
                    }},
                    威灵, new ShrapnelBulletType() {{
                        length = brange + 32;
                        damage = 130f;
                        ammoMultiplier = 3f;
                        toColor = 威灵.color;
                        shootEffect = smokeEffect = Fx.thoriumShoot;
                    }}
            );
        }};
    }

}
