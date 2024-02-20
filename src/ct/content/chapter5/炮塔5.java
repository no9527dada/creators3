package ct.content.chapter5;

import arc.Core;
import arc.graphics.Color;
import ct.content.Bullets.Bullets5;
import ct.content.NewColor;
import ct.content.Effect.NewEffect;
import ct.content.Effect.NewFx;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.UnitSorts;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.ContinuousLaserBulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootHelix;
import mindustry.entities.pattern.ShootPattern;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.StatusEffect;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.LaserTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.draw.DrawTurret;

import static ct.Asystem.CT3Sound.loadSound;
import static ct.content.NewColor.制裁Bullet颜色;

import static ct.content.chapter5.资源5.*;
import static mindustry.content.Fx.shootBig;
import static mindustry.content.Fx.shootSmallSmoke;
import static mindustry.content.Items.*;
import static mindustry.gen.Sounds.*;
import static mindustry.type.ItemStack.with;

//unitSort = UnitSorts.strongest;//攻击单位时的优先选择/closest/farthest/strongest/weakest
//方块
public class 炮塔5 {
    public static Block 真双管炮, 咻咻炮, 制裁, 灭亡, 毁灭, 散射炮, 追动, 光棱塔, 超级光棱塔, 起源, 皇后, 帝王, 空之驱逐, 空中祸害,
            魂灭, 魄散, 尘埃,
            炮塔aaa;

    public static void load() {
        真双管炮 = new ItemTurret("真双管炮") {{
            localizedName = Core.bundle.get("Turret.真双管炮");
            description = "";
            requirements(Category.turret, with(Items.copper, 35, graphite, 10));
            ammo(
                    Items.copper, new BasicBulletType(2.5f, 9) {{
                        width = 10f;
                        height = 13f;
                        lifetime = 60f;
                        ammoMultiplier = 2;
                    }},
                    graphite, new BasicBulletType(3.5f, 18) {{
                        width = 10f;
                        height = 13f;
                        reloadMultiplier = 0.6f;
                        ammoMultiplier = 4;
                        lifetime = 60f;
                    }},
                    Items.silicon, new BasicBulletType(4f, 12) {{
                        width = 10f;
                        height = 13f;
                        homingPower = 0.1f;
                        reloadMultiplier = 1.5f;
                        ammoMultiplier = 5;
                        lifetime = 60f;
                    }},
                    石英, new BasicBulletType(4f, 15) {{
                        width = 11f;
                        height = 13f;
                        homingPower = 0.1f;
                        reloadMultiplier = 1.5f;
                        ammoMultiplier = 5;
                        lifetime = 60f;
                        knockback = 1;
                    }}
            );

            shoot = new ShootAlternate(3.5f);
            // shoot.shotDelay = 5f;
            shoot.shots = 2;
            recoils = 2;
            drawer = new DrawTurret() {{
                for (int i = 0; i < 2; i++) {
                    int f = i;
                    parts.add(new RegionPart("-barrel-" + (i == 0 ? "l" : "r")) {{
                        progress = PartProgress.recoil;
                        recoilIndex = f;
                        under = true;
                        moveY = -1.5f;
                    }});
                }
            }};

            recoil = 0.5f;
            shootY = 3f;
            reload = 20f;
            range = 150;
            shootCone = 15f;
            ammoUseEffect = Fx.casing1;
            health = 400;
            inaccuracy = 2f;
            rotateSpeed = 10f;
            coolant = consumeCoolant(0.1f);
            researchCostMultiplier = 0.05f;

            limitRange();
        }};
        咻咻炮 = new ItemTurret("咻咻炮") {{
            int 咻咻炮lifetime = 70;
            localizedName = Core.bundle.get("Turret.咻咻炮");
            description = "";
            health = 800;
            size = 2;
            shoot.shots = 4;
            shoot.shotDelay = 2;
            targetGround = targetAir = true;
            range = 210;
            inaccuracy = 5;
            recoil = 2;//后座力动画
            reload = 20;//射速
            rotateSpeed = 10f;
            coolant = consumeCoolant(0.1f);//液体使用量
            ammo(
                    copper, new BasicBulletType() {{
                        speed = 3;
                        damage = 10;
                        pierce = true;
                        width = 11;
                        height = 10;
                        shootEffect = shootBig;
                        smokeEffect = shootSmallSmoke;
                        ammoMultiplier = 2;
                        reloadMultiplier = 1.0f;
                        lifetime = 咻咻炮lifetime;
                    }},
                    铁, new BasicBulletType() {{
                        speed = 3.5f;
                        damage = 25;
                        pierce = true;
                        width = 15;
                        height = 10;
                        shootEffect = shootBig;
                        smokeEffect = shootSmallSmoke;
                        ammoMultiplier = 2;
                        reloadMultiplier = 0.5f;
                        lifetime = 咻咻炮lifetime;
                    }},
                    石英, new BasicBulletType() {{
                        speed = 3.5f;
                        damage = 11;
                        width = 11;
                        height = 10;
                        pierce = true;
                        shootEffect = shootBig;
                        smokeEffect = shootSmallSmoke;
                        ammoMultiplier = 4;
                        reloadMultiplier = 1.2f;
                        lifetime = 咻咻炮lifetime;
                    }},
                    silicon, new BasicBulletType() {{
                        speed = 3.5f;
                        damage = 13;
                        width = 15;
                        pierce = true;
                        height = 10;
                        shootEffect = shootBig;
                        smokeEffect = shootSmallSmoke;
                        ammoMultiplier = 2;
                        reloadMultiplier = 1.2f;
                        lifetime = 咻咻炮lifetime;
                    }},
                    graphite, new BasicBulletType() {{
                        speed = 5;
                        damage = 15;
                        width = 11;
                        height = 10;
                        pierce = true;
                        shootEffect = shootBig;
                        smokeEffect = shootSmallSmoke;
                        ammoMultiplier = 1;
                        reloadMultiplier = 0.8f;
                        lifetime = 咻咻炮lifetime;
                    }},
                    硬直弹, new BasicBulletType() {{
                        speed = 3;
                        damage = 49;
                        width = 13;
                        height = 11;
                        shootEffect = shootBig;
                        smokeEffect = shootSmallSmoke;
                        ammoMultiplier = 3;
                        reloadMultiplier = 0.8f;
                        lifetime = 咻咻炮lifetime;
                    }}
            );
            requirements(Category.turret, with(石英, 60, Items.copper, 35, silicon, 150));
        }};

        制裁 = new ItemTurret("制裁") {
            {
                localizedName = Core.bundle.get("Turret.制裁");
                requirements(Category.turret, with(
                        石英, 300,
                        copper, 320,
                        lead, 320,
                        铁, 200,
                        钛合金, 150
                ));
                description = "";
                health = 1700;
                size = 3;
                //shoot.shots = 4;
                // shoot.shotDelay=2;
                targetGround = targetAir = true;
                range = 330;
                inaccuracy = 2;
                recoil = 2;//后座力动画
                reload = 5;//射速
                rotateSpeed = 10f;
                ammoUseEffect = NewFx.子弹抛壳(3, 20, Color.valueOf("27bbf3"), 制裁Bullet颜色, Pal.lightishGray);//弹壳脱壳动画效果
                shootSound = loadSound("制裁");
                ammo(
                        copper, new Bullets5.制裁Bullet(40, 12, 10),
                        lead, new Bullets5.制裁Bullet(40, 12, 10),
                        silicon, new Bullets5.制裁Bullet(70, 22, 6) {{
                            reloadMultiplier = 0.8f;
                            homingPower = 1;
                            homingRange = 60;
                        }},

                        graphite, new Bullets5.制裁Bullet(40, 22, 10) {{
                            reloadMultiplier = 0.7f;
                        }},
                        titanium, new Bullets5.制裁Bullet(40, 17, 10) {{
                            reloadMultiplier = 1.5f;
                        }},
                        碎裂弹, new Bullets5.制裁Bullet(40, 10, 10) {{
                            ammoMultiplier = 10;
                            reloadMultiplier = 0.8f;
                            pierce = false;
                            despawnEffect = Fx.none;
                            hitEffect = Fx.blastExplosion;
                            fragBullet = new BasicBulletType(2.5f, 5, "bullet") {{
                                width = 10f;
                                height = 12f;
                                shrinkY = 1f;
                                lifetime = 15f;
                                backColor = Pal.plastaniumBack;
                                frontColor = Pal.plastaniumFront;
                                hitEffect = despawnEffect = Fx.none;
                                pierce = true;
                            }};
                            fragBullets = 10;
                        }},
                        硬直弹, new Bullets5.制裁Bullet(40, 45, 10) {{
                            ammoMultiplier = 10;
                            status = StatusEffects.electrified;
                            statusDuration = 30;
                        }},
                        冷冻弹, new Bullets5.制裁Bullet(40, 12, 10) {{
                            reloadMultiplier = 0.3f;
                            pierce = true;
                            status = StatusEffects.freezing;
                            statusDuration = 60;
                        }}

                );


                灭亡 = new ItemTurret("灭亡") {
                    {
                        localizedName = Core.bundle.get("Turret.灭亡");
                        requirements(Category.turret, with(
                                石英, 300,
                                copper, 320,
                                lead, 320,
                                铁, 200,
                                钛合金, 150
                        ));
                        description = "";
                        health = 4000;
                        size = 4;
                        targetGround = targetAir = true;
                        range = 43 * 8;
                        inaccuracy = 0;
                        recoil = 5;//后座力动画
                        reload = 11;//射速
                        rotateSpeed = 10f;
                        shootSound = Sounds.shootBig;
                        ammoUseEffect = NewFx.子弹抛壳2(5, 50, Pal.lightOrange, Pal.lightishGray, Pal.lightishGray);//弹壳脱壳动画效果
                        shoot = new ShootAlternate() {{
                            spread = 15;
                            shots = 2;
                            barrels = 2;
                        }};
                        xRand = 2;
                        shootCone = 40;
                        maxAmmo = 10;
                        // ammoUseEffect = Fx.casing3;
                        requirements(Category.turret, with(
                                石英, 400,
                                graphite, 250,
                                surgeAlloy, 125,
                                相织硅, 100
                        ));
                        ammo(
                                copper, new Bullets5.灭亡Bullet(70, 43, 7, 1.2f, 2),
                                thorium, new Bullets5.灭亡Bullet(70, 65, 7, 1, 4),
                                titanium, new Bullets5.灭亡Bullet(70, 58, 7, 1.5f, 4),
                                钴, new Bullets5.灭亡Bullet(70, 85, 9, 0.7f, 2),
                                硬直弹, new Bullets5.灭亡Bullet(70, 43, 9, 0.9f, 2),
                                铁板, new Bullets5.灭亡Bullet(70, 200, 7, 0.5f, 2) {{
                                    width = height = 30;
                                }},
                                graphite, new Bullets5.灭亡Bullet(70, 60, 7, 1.4f, 4) {{
                                    width = 15;
                                    height = 30;
                                }}
                        );
                    }
                };

                毁灭 = new ItemTurret("毁灭") {
                    {
                        localizedName = Core.bundle.get("Turret.毁灭");
                        description = "";
                        requirements(Category.turret, with(
                                石英, 500,
                                镍板, 100,
                                铁, 250,
                                相织硅, 180
                        ));
                        health = 5500;
                        size = 4;
                        // shootSound = Sounds.artillery;
                        shootSound = loadSound("毁灭");
                        xRand = 2;
                        shootCone = 40;
                        maxAmmo = 15;
                        description = "";
                        targetGround = targetAir = true;
                        range = 55 * 8;
                        inaccuracy = 0;
                        recoil = 5;//后座力动画
                        reload = 90;//射速
                        // shoot.shots = 2;
                        // shoot.shotDelay=30;
                        rotateSpeed = 10f;
                        ammo(
                                graphite, new Bullets5.毁灭Bullet(100, 150, 5, 1.5f, 1),
                                thorium, new Bullets5.毁灭Bullet(100, 360, 5, 1.2f, 1),
                                surgeAlloy, new Bullets5.毁灭Bullet(100, 666, 5, 1.5f, 2),
                                钴, new Bullets5.毁灭Bullet(100, 666, 5, 0.9f, 1),
                                硬直弹, new Bullets5.毁灭Bullet(100, 900, 5, 0.5f, 2),
                                钻石, new Bullets5.毁灭Bullet(100, 1500, 5, 1f, 1),
                                铁板, new Bullets5.毁灭Bullet(100, 720, 5, 1.3f, 1),
                                镍板, new Bullets5.毁灭Bullet(100, 1200, 5, 1.5f, 1)
                        );
                    }
                };

                散射炮 = new ItemTurret("散射炮") {
                    {
                        localizedName = Core.bundle.get("Turret.散射炮");
                        description = "";
                        requirements(Category.turret, with(
                                石英, 20,
                                metaglass, 45,
                                铁, 5
                        ));
                        shootCone = 40;
                        description = "";
                        inaccuracy = 0;
                        recoil = 7;//后座力动画
                        reload = 45;//射速
                        //shoot.shots = 2;
                        // shoot.shotDelay=30;
                        shoot = new ShootSpread(7, 10f);
                        rotateSpeed = 10f;
                        health = 1200;
                        size = 2;
                        targetAir = true;
                        targetGround = false;
                        range = 250;
                        ammo(
                                lead, new Bullets5.散射炮Bullet(17, 20, 15, 1f, 1),
                                sand, new Bullets5.散射炮Bullet(17, 12, 15, 1f, 1),
                                石英, new Bullets5.散射炮Bullet(17, 35, 15, 1f, 2),
                                metaglass, new Bullets5.散射炮Bullet(17, 28, 15, 1f, 1),
                                graphite, new Bullets5.散射炮Bullet(17, 23, 15, 1f, 1),
                                silicon, new Bullets5.散射炮Bullet(17, 30, 15, 1f, 2)
                        );
                    }
                };
                追动 = new ItemTurret("追动") {
                    {
                        localizedName = Core.bundle.get("Turret.追动");
                        description = "";
                        requirements(Category.turret, with(
                                石英, 50,
                                copper, 145,
                                铁, 30,
                                金, 15
                        ));
                        shootCone = 40;
                        description = "";
                        recoil = 7;//后座力动画
                        reload = 63;//射速
                        shoot.shots = 5;
                        shoot.shotDelay = 5;
                        rotateSpeed = 10f;
                        targetAir = targetGround = true;
                        health = 1800;
                        size = 3;
                        shootSound = missile;
                        range = 180 + 80;
                        inaccuracy = 5;
                        ammo(
                                铁, new Bullets5.追动Bullet(20, 32, 15, 1f, 1),
                                graphite, new Bullets5.追动Bullet(20, 13, 15, 1f, 1),
                                sand, new Bullets5.追动Bullet(20, 4, 15, 1.5f, 1),
                                coal, new Bullets5.追动Bullet(20, 6, 15, 1.3f, 1),
                                冷冻弹, new Bullets5.追动Bullet(20, 10, 15, 1.5f, 1) {{
                                    status = StatusEffects.freezing;
                                    statusDuration = 15;
                                }},

                                碳板, new Bullets5.追动Bullet(200, 15, 3, 1f, 1) {{
                                    sprite = "ct-baojian";
                                    height = 40;
                                    width = 12;
                                    homingPower = 0.00769f;
                                    homingRange = 38;
                                }},


                                lead, new Bullets5.追动Bullet(20, 15, 15, 1.2f, 1),
                                copper, new Bullets5.追动Bullet(20, 13, 15, 1.2f, 1)
                        );
                    }
                };

                光棱塔 = new PowerTurret("光棱塔") {
                    {
                        localizedName = Core.bundle.get("Turret.光棱塔");
                        description = "";
                        requirements(Category.turret, with(
                                copper, 750,
                                lead, 700,
                                碳板, 30,
                                电池, 125,
                                相织硅, 100
                        ));

                        drawer = NewFx.光棱塔蓄力射击效果();
                        //充能声音
                        chargeSound = loadSound("光棱充能");
                        shoot.firstShotDelay = 40f;
                        shootEffect = Fx.lancerLaserShoot;
                        smokeEffect = new NewEffect.BulletWaveEffect() {{
                            sizeFrom = 0f;
                            sizeTo = 20f;
                            //持续时间
                            lifetime = 20;
                            strokeFrom = 2f;
                            strokeTo = 0f;
                            colorFrom = NewColor.光棱塔Bullet1;
                            colorTo = NewColor.光棱塔Bullet2;
                        }};
                        heatColor = Color.red;
                        shootCone = 30;
                        description = "";
                        inaccuracy = 0;
                        recoil = 7;//后座力动画
                        reload = 120;//射速
                        //shoot.shots = 2;
                        // shoot.shotDelay=30;
                        //shoot = new ShootSpread(7, 10f);
                        rotateSpeed = 10f;
                        targetGround = targetAir = true;
                        health = 4500;
                        size = 4;
                        range = 85 * 8;
                        consumePower(4500 / 60f);
                        coolant = consumeCoolant(0.1f);
                        shootSound = loadSound("光棱");
                        // ammoUseEffect=Fx.shellEjectSmall;//使用弹药时产生的效果。
                        shootType = new Bullets5.光棱塔Bullet(2400);
                    }
                };


                超级光棱塔 = new PowerTurret("超级光棱塔") {
                    {
                        localizedName = Core.bundle.get("Turret.超级光棱塔");
                        description = "";
                        requirements(Category.turret, with(
                                copper, 3750,
                                lead, 3700,
                                碳板, 220,
                                电池, 480,
                                相织硅, 500,
                                镍板, 320,
                                啸动合金, 50
                        ));

                        drawer = NewFx.超级光棱塔蓄力射击效果();
                        //充能声音
                        chargeSound = loadSound("光棱充能2");
                        shoot.firstShotDelay = 40f;
                        shootEffect = Fx.lancerLaserShoot;
                        smokeEffect = new NewEffect.BulletWaveEffect() {{
                            sizeFrom = 0f;
                            sizeTo = 20f;
                            //持续时间
                            lifetime = 20;
                            strokeFrom = 2f;
                            strokeTo = 0f;
                            colorFrom = NewColor.光棱塔Bullet1;
                            colorTo = NewColor.光棱塔Bullet2;
                        }};
                        heatColor = Color.red;
                        shootCone = 30;
                        description = "";
                        inaccuracy = 0;
                        recoil = 15;//后座力动画
                        reload = 180;//射速
                        //shoot.shots = 2;
                        // shoot.shotDelay=30;
                        //shoot = new ShootSpread(7, 10f);
                        rotateSpeed = 2f;
                        targetGround = targetAir = true;
                        health = 7000;
                        size = 8;
                        range = 130 * 8;
                        consumePower(25000 / 60f);
                        coolant = consumeCoolant(0.1f);
                        shootSound = loadSound("光棱2");
                        // ammoUseEffect=Fx.shellEjectSmall;//使用弹药时产生的效果。
                        shootType = new Bullets5.超级光棱塔Bullet(3400);
                    }
                };
                起源 = new ItemTurret("起源") {
                    {
                        localizedName = Core.bundle.get("Turret.起源");
                        description = "";
                        requirements(Category.turret, with(
                                copper, 300,
                                电池, 100,
                                镍板, 80,
                                钴, 100,
                                石英, 150,
                                lead, 320
                        ));

                        shootSound = Sounds.shootAltLong;
                        drawer = NewFx.起源装弹效果();
                        size = 4;
                        maxAmmo = 32;
                        coolantMultiplier = 1.5f;//液体单位量
                        ammoPerShot = 4;//每发消耗的资源
                        recoil = 7;//后座力动画
                        reload = 240;//射速
                        shoot.firstShotDelay = 60f;
                        health = 3500;
                        range = 70 * 8;
                        ammo(
                                冷冻弹, new Bullets5.起源Bullet(33, 2, 300) {{
                                    status = StatusEffects.freezing;
                                    statusDuration = 20;
                                }},
                                电池, new Bullets5.起源Bullet(60, 1, 750) {{
                                    status = StatusEffects.electrified;
                                    statusDuration = 30;
                                }},
                                钻石, new Bullets5.起源Bullet(100, 2, 1000),
                                硬直弹, new Bullets5.起源Bullet(140, 2, 1300) {{
                                    status = StatusEffects.electrified;
                                    statusDuration = 30;
                                }}
                        );
                        unitSort = UnitSorts.farthest;//最远
                        consumePower(3200 / 60f);
                    }
                };
                皇后 = new ItemTurret("皇后") {
                    {
                        localizedName = Core.bundle.get("Turret.皇后");
                        description = "";
                        requirements(Category.turret, with(
                                石英, 330,
                                金, 200,
                                graphite, 80,
                                surgeAlloy, 350,
                                copper, 150,
                                lead, 180
                        ));

                        shootSound = Sounds.shootAltLong;
                        drawer = NewFx.皇后装弹效果();
                        size = 4;
                        //  maxAmmo=32;
                        coolantMultiplier = 1.5f;//液体单位量
                        // ammoPerShot = 4;//每发消耗的资源
                        recoil = 7;//后座力动画
                        reload = 240;//射速
                        shoot.firstShotDelay = 60f;
                        health = 2400;
                        range = 56 * 8;
                        shoot = new ShootHelix() {{
                            mag = 3.5f;
                            scl = 7f;
                        }};
                        rotateSpeed = 2f;
                        shoot.shots = 5;
                        shoot.shotDelay = 6;
                        ammo(
                                金, new Bullets5.皇后Bullet(60, 2, 2, 1.5F),
                                铁, new Bullets5.皇后Bullet(50F, 2, 2, 1.2F),
                                thorium, new Bullets5.皇后Bullet(45, 2, 2, 1),
                                blastCompound, new Bullets5.皇后Bullet(56, 2, 2, 1.2F),
                                钻石, new Bullets5.皇后Bullet(120, 4, 2, 1),
                                钴, new Bullets5.皇后Bullet(78, 2, 2, 1.7F),
                                硬直弹, new Bullets5.皇后Bullet(140, 2, 2, 1.3F) {{
                                    status = StatusEffects.electrified;
                                    statusDuration = 30;
                                }}
                        );
                    }
                };
                帝王 = new ItemTurret("帝王") {
                    {
                        localizedName = Core.bundle.get("Turret.帝王");
                        description = "";
                        requirements(Category.turret, with(
                                copper, 300,
                                电池, 100,
                                镍板, 80,
                                钴, 100,
                                石英, 150,
                                lead, 320
                        ));

                        shootSound = Sounds.shootAltLong;
                        drawer = NewFx.帝王装弹效果();
                        size = 4;
                        maxAmmo = 32;
                        coolantMultiplier = 1.5f;//液体单位量
                        // ammoPerShot = 4;//每发消耗的资源
                        recoil = 7;//后座力动画
                        reload = 50;//射速
                        shoot.firstShotDelay = 20f;
                        health = 3500;
                        range = 56 * 8 * 2;
                        ammo(thorium, new Bullets5.帝王Bullet(80, 45, 3, 10, 1.3f),
                                铁, new Bullets5.帝王Bullet(130, 55, 2, 10, 1),
                                镍, new Bullets5.帝王Bullet(150, 70, 2, 10, 1.3f),
                                钛合金, new Bullets5.帝王Bullet(120, 50, 4, 10, 2) {{
                                    knockback = 3;
                                }},
                                钻石, new Bullets5.帝王Bullet(220, 120, 1, 10, 1),
                                碎裂弹, new Bullets5.帝王Bullet(190, 105, 3, 10, 1),
                                冷冻弹, new Bullets5.帝王Bullet(130, 80, 2, 10, 1) {{
                                    status = StatusEffects.freezing;
                                    statusDuration = 120;
                                }},
                                硬直弹, new Bullets5.帝王Bullet(250, 130, 3, 10, 1) {{
                                    status = StatusEffects.electrified;
                                    statusDuration = 30;
                                }},
                                啸动合金, new Bullets5.帝王Bullet(8000, 4500, 6, 10, 1.5f)
                        );
                    }
                };

                StatusEffect 冷冻 = new StatusEffect("lengdong") {{
                    reloadMultiplier = 0.7f;//射击速度
                    speedMultiplier = 0.4f;//移速
                }};
                空之驱逐 = new ItemTurret("空之驱逐") {
                    {
                        localizedName = Core.bundle.get("Turret.空之驱逐");
                        description = "";
                        requirements(Category.turret, with(
                                copper, 500,
                                lead, 700,
                                thorium, 150,
                                石英, 125,
                                铁, 80,
                                金, 70,
                                钻石混合物, 30
                        ));
                        targetAir = true; //空
                        targetGround = false; //地
                        // shootSound = Sounds.shootAltLong;
                        // drawer = NewFx.帝王装弹效果();
                        inaccuracy = 10;//精度
                        size = 5;
                        coolantMultiplier = 1.5f;//液体单位量
                        maxAmmo = 66;
                        // ammoPerShot = 4;//每发消耗的资源
                        recoil = 3;//后座力动画
                        reload = 7;//射速
                        shoot.firstShotDelay = 120f;
                        health = 3500;
                        range = 63 * 8;
                        consumePower(700 / 60f);
                        // shoot = new ShootSpread(10, 30f);//射击数量，角度
                        shoot = new ShootAlternate(15f);
                  /*      shoot = new ShootAlternate() {{
                            spread = 15;
                            shots = 2;
                            barrels = 2;
                        }};*/
                        // shoot.shotDelay=reload/5;
                        ammo(thorium, new Bullets5.空之驱逐Bullet(90, 3, 9, 1f, 3),
                                metaglass, new Bullets5.空之驱逐Bullet(40, 5, 9, 1.5f, 1),
                                plastanium, new Bullets5.空之驱逐Bullet(140, 4, 9, 1.2f, 3),
                                碎裂弹, new Bullets5.空之驱逐Bullet(0, 4, 9, 0.7f, 2) {{
                                    splashDamage = 220;//范围伤害
                                    splashDamageRadius = 8 * 8;//范围伤害的范围
                                }},
                                冷冻弹, new Bullets5.空之驱逐Bullet(70, 3, 9, 0.5f, 1) {{
                                    status = 冷冻;
                                    statusDuration = 15;
                                }},
                                金, new Bullets5.空之驱逐Bullet(120, 6, 9, 2f, 6),
                                铁板, new Bullets5.空之驱逐Bullet(360, 3, 9, 1f, 3),
                                钛合金, new Bullets5.空之驱逐Bullet(280, 3, 9, 1f, 3),
                                电池, new Bullets5.空之驱逐Bullet(130, 1, 9, 1f, 3) {{
                                    status = StatusEffects.shocked;
                                    statusDuration = 60;
                                }},
                                水瓶, new Bullets5.空之驱逐Bullet(30, 1, 9, 1f, 0) {{
                                    status = StatusEffects.wet;
                                    statusDuration = 60;
                                }}
                        );
                    }
                };
                空中祸害 = new ItemTurret("空中祸害") {
                    {
                        localizedName = Core.bundle.get("Turret.空中祸害");
                        description = Core.bundle.get("Turret.description.空中祸害");
                        requirements(Category.turret, with(
                                copper, 12000,
                                lead, 15000,
                                电池, 600,
                                镍板, 280,
                                钴, 1300,
                                石英, 750,
                                钻石, 300,
                                相织硅, 230,
                                啸动合金, 100

                        ));
                        unitSort = UnitSorts.strongest;//攻击单位时的优先选择/closest/farthest/strongest/weakest
                        consumePower(6500 / 60f);
                        targetAir = true; //空
                        targetGround = false; //地
                        shootSound = Sounds.shootBig;
                        // drawer = NewFx.帝王装弹效果();
                        inaccuracy = 13;//精度
                        size = 10;
                        maxAmmo = 90;
                        coolantMultiplier = 1.5f;//液体单位量
                        ammoPerShot = 4;//每发消耗的资源
                        recoil = 7;//后座力动画
                        reload = 300;//射速
                        shoot.firstShotDelay = 300;//第一次射击延迟
               /*         shoot = new ShootAlternate() {{
                            spread = 30;
                            shots = 4;
                            barrels = 2;
                        }};*/
                        shoot = new ShootPattern() {
                            {
                                shots = 5;
                                // firstShotDelay=0;
                                shotDelay = 7;
                            }
                        };
                        health = 3500;
                        range = 130 * 8;
                        ammo(thorium, new Bullets5.空中祸害Bullet(90, 3, 9, 1f, 3),
                                metaglass, new Bullets5.空中祸害Bullet(40, 5, 9, 1.5f, 1),
                                plastanium, new Bullets5.空中祸害Bullet(140, 4, 9, 1.2f, 3),
                                碎裂弹, new Bullets5.空中祸害Bullet(0, 4, 9, 0.7f, 2) {{
                                    splashDamage = 220;//范围伤害
                                    splashDamageRadius = 8 * 8;//范围伤害的范围
                                }},
                                冷冻弹, new Bullets5.空中祸害Bullet(70, 3, 9, 0.5f, 1) {{
                                    status = 冷冻;
                                    statusDuration = 15;
                                }},
                                金, new Bullets5.空中祸害Bullet(120, 6, 9, 2f, 6),
                                铁板, new Bullets5.空中祸害Bullet(360, 3, 9, 1f, 3),
                                钛合金, new Bullets5.空中祸害Bullet(280, 3, 9, 1f, 3),
                                电池, new Bullets5.空中祸害Bullet(130, 1, 9, 1f, 3) {{
                                    status = StatusEffects.shocked;
                                    statusDuration = 60;
                                }},
                                水瓶, new Bullets5.空中祸害Bullet(30, 1, 9, 1f, 0) {{
                                    status = StatusEffects.wet;
                                    statusDuration = 60;
                                }},
                                钻石, new Bullets5.空中祸害Bullet(550, 4, 9, 1.4f, 3) {{
                                    status = StatusEffects.slow;
                                    statusDuration = 20;
                                }},
                                镍板, new Bullets5.空中祸害Bullet(890, 4, 9, 1.7f, 3) {{
                                    status = new StatusEffect("jianxue1") {{
                                        healthMultiplier = 0.6f;//血量倍率
                                    }};
                                    statusDuration = 15;
                                }},
                                啸动合金, new Bullets5.空中祸害Bullet(2200, 5, 9, 1.5f, 6) {{
                                    status = new StatusEffect("jianxue2") {{
                                        healthMultiplier = 0.4f;//血量倍率
                                        speedMultiplier = 0.5f;//移速
                                    }};
                                    statusDuration = 25;
                                }}
                        );
                    }
                };
                魂灭 = new LaserTurret("魂灭") {{
                    localizedName = Core.bundle.get("Turret.魂灭");
                    description = Core.bundle.get("Turret.description.魂灭");
                    requirements(Category.turret, with(
                            Items.copper, 1200,
                            Items.lead, 350,
                            Items.graphite,
                            300, Items.surgeAlloy, 325,
                            Items.silicon, 325,
                            金, 20
                    ));
                    shootEffect = Fx.shootBigSmoke2;
                    shootCone = 40f;
                    recoil = 4f;
                    size = 5;
                    shake = 2f;
                    range = 195 * 2f;
                    reload = 90f;
                    firingMoveFract = 0.5f;
                    shootDuration = 320f;
                    shootSound = Sounds.laserbig;
                    loopSound = Sounds.beam;
                    loopSoundVolume = 2f;
                    rotateSpeed = 3f;
                    shootType = new ContinuousLaserBulletType(1300 / 12f) {{
                        length = 400f;
                        hitEffect = Fx.hitMeltdown;
                        hitColor = Pal.meltdownHit;
                        status = StatusEffects.melting;
                        drawSize = 420f;
                        // timescaleDamage = true;
                        incendChance = 0.4f;
                        incendSpread = 5f;
                        incendAmount = 1;
                        ammoMultiplier = 1f;
                    }};
                    scaledHealth = 200;
                    coolant = consumeCoolant(0.5f);
                    consumePower(17f);
                }};
                魄散 = new PowerTurret("魄散") {{
                    localizedName = Core.bundle.get("Turret.魄散");
                    description = Core.bundle.get("Turret.description.魄散");
                    requirements(Category.turret, with(
                            Items.copper, 1200,
                            Items.lead, 350,
                            Items.graphite, 300,
                            Items.surgeAlloy, 325,
                            Items.silicon, 325,
                            金, 20
                    ));
                    range = 195 * 2f;
                    recoil = 2f;
                    shake = 2f;
                    shootEffect = Fx.lancerLaserShoot;
                    smokeEffect = Fx.none;
                    heatColor = Color.red;
                    size = 5;
                    scaledHealth = 280;
                    targetAir = false;
                    moveWhileCharging = false;
                    accurateDelay = false;

                    consumePower(6f);
                    shootSound = loadSound("魄散充能");
                    chargeSound = loadSound("魄散发射");
                    reload = 300;//射速
                    shoot.firstShotDelay = 300;//第一次射击延迟
                    shoot = new ShootPattern() {
                        {
                            shots = 4;
                            // firstShotDelay=0;
                            shotDelay = 15;
                        }
                    };
                    shootType = new LaserBulletType(320) {{
                        // Color[] colors = {Color.valueOf("ec745855"), Color.valueOf("ec7458aa"), Color.valueOf("ff9c5a"), Color.white};
                        colors = new Color[]{Color.valueOf("ec7458"), Color.valueOf("ec7458aa"), Color.valueOf("ff9c5a"), Color.white};
                        //TODO merge
                        chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
                        buildingDamageMultiplier = 0.25f;
                        hitEffect = Fx.hitLancer;
                        hitSize = 4;

                        lifetime = 16f;
                        drawSize = 400f;
                        collidesAir = false;
                        length = 173 * 2.5f;
                        width = 60f;
                        ammoMultiplier = 1f;
                        // pierceCap = 4;
                    }};
                    scaledHealth = 200;
                    coolantMultiplier = 0.8f; //液体冷却倍率
                    coolant = consumeCoolant(0.5f);//液体消耗量
                    consumePower(17f);
                }};


                尘埃 = new ItemTurret("尘埃") {
                    {
                        localizedName = Core.bundle.get("Turret.尘埃");
                        description = Core.bundle.get("Turret.description.尘埃");
                        requirements(Category.turret, with(
                                copper, 12000,
                                lead, 15000,
                                电池, 600,
                                镍板, 280,
                                钴, 1300,
                                石英, 750,
                                钻石, 300,
                                相织硅, 230,
                                啸动合金, 800,
                                黎辉水晶, 100

                        ));
                        unitSort = UnitSorts.strongest;//攻击单位时的优先选择/closest/farthest/strongest/weakest
                        consumePower(6500 / 60f);
                        targetGround = targetAir = true; //空地
                        inaccuracy = 13;//精度
                        coolantMultiplier = 1.5f;//液体单位量
                        ammoPerShot = 10;//每发消耗的资源
                        recoil = 8;//后座力动画
                        reload = 30 * 60;//射速

                        size = 12;
                        health = 15000;
                        range = 150 * 8;
                        maxAmmo = 100;
                        //heatColor= 66B1FFFF;
                        update = true;
                        hasPower = true;
                        shootSound = laserblast;
                        chargeSound = none;
                        moveWhileCharging = true;
                        //  shoot.firstShotDelay = 300;//第一次射击延迟
                        shoot.firstShotDelay = 200;
                        shake = 4;
                        rotateSpeed = 4;
                        liquidCapacity = 60;
                        coolantMultiplier = 0f; //液体冷却倍率
                        consumeLiquid(啸冷剂, 10 / 60f);
                        consumePower(45000 / 60f);
                        ammo(
                                啸动合金, new Bullets5.尘埃Bullet()
                        );
                    }
                };
            }
        };
    }
}