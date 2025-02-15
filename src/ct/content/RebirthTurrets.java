package ct.content;

import CtCoreSystem.CoreSystem.type.BulletType.JiGuangFanWeiShangHaiBulletType;
import CtCoreSystem.content.Effect.CTRegionPart;
import CtCoreSystem.content.Effect.NewFx;
import arc.Core;
import arc.graphics.Blending;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import mindustry.content.Fx;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.Effect;
import mindustry.entities.Fires;
import mindustry.entities.UnitSorts;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Fire;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ContinuousTurret;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.LaserTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.draw.DrawTurret;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.BuildVisibility;

import static CtCoreSystem.CoreSystem.type.CTColor.C;
import static arc.math.Interp.swingIn;
import static ct.content.RebirthBuffs.毒;
import static ct.content.RebirthBullets.*;
import static ct.content.RebirthItem.*;
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

public class RebirthTurrets {
    public static Block 月牙, 闪电链, 墨雪, 刺镰, 飞星, 赤狐, 宏裂, 冰蜂, 火辰, 阳辰, 熔岩, 熔火, 炎辰;

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
            shoot.shots = 4;
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
        飞星 = new ItemTurret("飞星") {{
            shoot = new ShootSpread(2, 35f);
            shootCone = 90F;//瞄准角度
            range = 23 * 8f;
            reload = 40f;
            size = 2;
            health = 560;
            shootSound = Sounds.plasmaboom;
            ammo(
                    缕, new BasicBulletType(4f, 43, "ctcoresystem-斜四星") {{
                        shootEffect = new ParticleEffect() {{
                            interp = swingIn;
                            region = "ctcoresystem-斜四星";
                            colorFrom =
                                    colorTo = 缕.color;
                            //length = 20f;baseLength = 10f;
                            sizeFrom = 7f;
                            sizeTo = 0f;
                            spin = 5f;
                            particles = 1;
                            length = 0;
                            lifetime = 30;


                        }};

                        hitEffect = new MultiEffect(new Effect(22.0F, (e) -> {
                            Draw.color(缕.color);
                            e.scaled(20.0F, (i) -> {
                                Lines.stroke(3.0F * i.fout());
                                Lines.circle(e.x, e.y, 10.0F + i.fin() * 15.0F);
                            });
                        }),
                                new Effect(60.0F, (e) -> {
                                    Draw.color(缕.color);
                                    Angles.randLenVectors(e.id, e.fin(), 7, 9.0F, (x, y, fin, fout) -> {
                                        Fill.circle(e.x + x, e.y + y, 10.0F * fout);
                                    });
                                }));
                        shrinkX =
                                shrinkY = 0;
                        width =
                                height = 21f;
                        lifetime = 60f;
                        ammoMultiplier = 2;//装弹倍率
                        trailLength = 8;
                        trailWidth = 2;
                        spin = 8;
                        hitColor = frontColor = backColor = trailColor = 缕.color;
                        splashDamageRadius = 5 * 8;
                        splashDamage = 20F;
                        homingRange = 20 * 8f;//追踪范围
                        homingPower = 0.3f; //追踪力度
                        homingDelay = 10;//追踪延迟*/
                    }},
                    灵玉, new BasicBulletType(4f, 40, "ctcoresystem-斜四星") {{
                        shootEffect = new ParticleEffect() {{
                            interp = swingIn;
                            region = "ctcoresystem-斜四星";
                            colorFrom =
                                    colorTo = 灵玉.color;
                            //length = 20f;baseLength = 10f;
                            sizeFrom = 7f;
                            sizeTo = 0f;
                            spin = 5f;
                            particles = 1;
                            length = 0;
                            lifetime = 30;


                        }};

                        hitEffect = new MultiEffect(new Effect(22.0F, (e) -> {
                            Draw.color(灵玉.color);
                            e.scaled(20.0F, (i) -> {
                                Lines.stroke(3.0F * i.fout());
                                Lines.circle(e.x, e.y, 10.0F + i.fin() * 15.0F);
                            });
                        }),
                                new Effect(60.0F, (e) -> {
                                    Draw.color(灵玉.color);
                                    Angles.randLenVectors(e.id, e.fin(), 7, 9.0F, (x, y, fin, fout) -> {
                                        Fill.circle(e.x + x, e.y + y, 10.0F * fout);
                                    });
                                }));
                        shrinkX =
                                shrinkY = 0;
                        width =
                                height = 21f;
                        lifetime = 60f;
                        ammoMultiplier = 4;//装弹倍率
                        reloadMultiplier = 1.5f;//弹药射速
                        trailLength = 8;
                        trailWidth = 2;
                        spin = 8;
                        hitColor = frontColor = backColor = trailColor = 灵玉.color;
                        splashDamageRadius = 5 * 8;
                        splashDamage = 20F;
                        homingRange = 20 * 8f;//追踪范围
                        homingPower = 0.3f; //追踪力度
                        homingDelay = 10;//追踪延迟*/
                    }}

                    , 陶, new BasicBulletType(4f, 15, "ctcoresystem-斜四星") {{
                        hitEffect = new MultiEffect(new Effect(22.0F, (e) -> {
                            Draw.color(陶.color);
                            e.scaled(20.0F, (i) -> {
                                Lines.stroke(3.0F * i.fout());
                                Lines.circle(e.x, e.y, 10.0F + i.fin() * 15.0F);
                            });
                        }), new Effect(60.0F, (e) -> {
                            Draw.color(陶.color);
                            Angles.randLenVectors(e.id, e.fin(), 7, 9.0F, (x, y, fin, fout) -> {
                                Fill.circle(e.x + x, e.y + y, 10.0F * fout);
                            });
                        }));
                        width = height = 21f;
                        lifetime = 60f;
                        ammoMultiplier = 2;//装弹倍率
                        trailLength = 8;
                        trailWidth = 2;
                        spin = 8;
                        frontColor = backColor = trailColor = 陶.color;
                        splashDamageRadius = 5 * 8;
                        splashDamage = 5F;
                        homingRange = 20 * 8f;//追踪范围
                        homingPower = 0.3f; //追踪力度
                        homingDelay = 10;//追踪延迟*/
                    }}
                    , 翠, new BasicBulletType(4f, 15, "ctcoresystem-斜四星") {{
                        hitEffect = new MultiEffect(
                                new Effect(22.0F, (e) -> {
                                    Draw.color(翠.color);
                                    e.scaled(20.0F, (i) -> {
                                        Lines.stroke(3.0F * i.fout());
                                        Lines.circle(e.x, e.y, 10.0F + i.fin() * 15.0F);
                                    });
                                }),
                                new Effect(60.0F, (e) -> {
                                    Draw.color(翠.color);
                                    Angles.randLenVectors(e.id, e.fin(), 7, 9.0F, (x, y, fin, fout) -> {
                                        Fill.circle(e.x + x, e.y + y, 10.0F * fout);
                                    });
                                }));
                        width =
                                height = 21f;
                        lifetime = 60f;
                        ammoMultiplier = 2;//装弹倍率
                        trailLength = 8;
                        trailWidth = 2;
                        spin = 8;
                        frontColor = backColor = trailColor = 翠.color;
                        splashDamageRadius = 5 * 8;
                        splashDamage = 5F;
                        homingRange = 20 * 8f;//追踪范围
                        homingPower = 0.3f; //追踪力度
                        homingDelay = 10;//追踪延迟*/
                    }}
            );
            consumePower(60 / 60f);
            requirements(Category.turret, with(缕, 40, 幻烬, 45, 陶, 80));
        }};
        刺镰 = new PowerTurret("刺镰") {{
            localizedName = Core.bundle.get("Turret.cilian");
            description = Core.bundle.getOrNull("Turret.description.cilian");
            requirements(Category.turret, with(缕, 45, 灵玉, 30, 翠, 120));
            range = 17 * 8f;

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
                    缕, 50, 幻烬, 70, 翠, 90, 陶, 50
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

            reload = 50f;
            shake = 4f;
            range = 17 * 8f;
            recoil = 5f;

            shoot = new ShootSpread(3, 10f);

            shootCone = 30;
            size = 3;

            researchCostMultiplier = 1.8f;//科技树中的研究资源倍率
            health = 760;
            shootSound = Sounds.shotgun;
            coolant = consumeCoolant(0.3f);
            consumePower(2f);
            float brange = range + 3f;
            ammo(
                    缕, new ShrapnelBulletType() {{
                        length = brange;
                        damage = 66f;
                        ammoMultiplier = 2f;
                        width = 17f;
                        reloadMultiplier = 1.3f;
                        toColor = 缕.color;
                        pierce = true;
                        pierceCap = 5;
                    }},
                    血晶, new ShrapnelBulletType() {{
                        length = brange;
                        damage = 105f;
                        ammoMultiplier = 5f;
                        toColor = 血晶.color;
                        pierce = true;
                        pierceCap = 5;
                        shootEffect = smokeEffect = Fx.thoriumShoot;
                    }},
                    威灵, new ShrapnelBulletType() {{
                        length = brange + 32;
                        damage = 130f;
                        ammoMultiplier = 3f;
                        toColor = 威灵.color;
                        pierce = true;
                        pierceCap = 5;
                        shootEffect = smokeEffect = Fx.thoriumShoot;
                    }}
            );
        }};
        火辰 = new ContinuousTurret("火辰") {

            {
                localizedName = Core.bundle.get("Turret.huochen");
                description = Core.bundle.getOrNull("Turret.description.huochen");
                buildType = Build::new;
                requirements(Category.turret, with(缕, 75, 血晶, 30, 翠, 120, 幻烬, 50));
                shootEffect = Fx.shootBigSmoke2;
                shootCone = 10f;
                group = BlockGroup.turrets;
                unitSort = UnitSorts.strongest;//优先最强，攻击单位时的优先选择/closest/farthest/strongest/weakest
                size = 2;
                health = 600;
                range = 25 * 8;
                shootSound = Sounds.none;
                loopSound = Sounds.tractorbeam;
                loopSoundVolume = 0.5f;
                recoil = 1;//武器后座
                //  shootY = 0;//中心发射子弹
                rotateSpeed = 1;
                shootY = 5;
                shootType = new JiGuangFanWeiShangHaiBulletType() {{
                    beamEffectInterval = 10.0F;//特效循环延迟
                    beamEffectSize = 3.5F;//特效大小
                    beamEffect = new Effect(22.0F, (e) -> {
                        Draw.color(Color.valueOf("f8be74"));
                        e.scaled(20.0F, (i) -> {
                            Lines.stroke(3.0F * i.fout());
                            Lines.circle(e.x, e.y, 3.0F + i.fin() * 15.0F);
                        });
                    });
                    buildingDamageMultiplier = 0.3f;
                    hitColor = Color.valueOf("f8be74");
                    sprite = "ct-火辰-laser";
                    splashDamage = 25;
                    splashDamageRadius = 4 * 8f;
                    //pierceArmor = true;//穿甲 穿透护甲
                    incendChance = 0.4f;
                    incendSpread = 5f;
                    incendAmount = 1;//>=1时会有燃烧效果
                }};
                //   coolant = consumeCoolant(0);
                consumePower(160 / 60f);
                consumeLiquid(灵液, 6 / 60f);
                //  buildType = Build::new;
            }

            class Build extends ContinuousTurretBuild {
                public void updateTile() {
                    super.updateTile();
                    //不被火焰灼伤
                    if (bullets.any()) {
                        for (var entry : bullets) {
                            updateBullet(entry);
                        }

                        wasShooting = true;
                        heat = 1f;
                        curRecoil = recoil;
                    }
                    tile.getLinkedTiles(t -> {
                        if (t == null || !Fires.has(t.x, t.y)) return;

                        Fire fire = Fires.get(t.x, t.y);
                        fire.remove();
                    });
                }
            }
        };
        炎辰 = new ContinuousTurret("炎辰") {
            {
                localizedName = Core.bundle.get("Turret.yanchen");
                description = Core.bundle.getOrNull("Turret.description.yanchen");
                buildType = Build::new;
                requirements(Category.turret, with(缕, 150, 血晶, 30, 翠, 250, 威灵, 50, 精焰, 25));
                shootEffect = Fx.shootBigSmoke2;
                shootCone = 10f;
                group = BlockGroup.turrets;
                unitSort = UnitSorts.strongest;//优先最强，攻击单位时的优先选择/closest/farthest/strongest/weakest
                size = 3;
                shootY = 5;
                health = 1400;
                range = 35 * 8;
                shootSound = Sounds.none;
                loopSound = Sounds.tractorbeam;
                loopSoundVolume = 0.5f;
                recoil = 1;//武器后座
                //shootY = 0;//中心发射子弹
                rotateSpeed = 1;
                shootType = new JiGuangFanWeiShangHaiBulletType() {{
                    beamEffect = new Effect(22.0F, (e) -> {
                        Draw.color(Color.valueOf("fda981"));
                        e.scaled(20.0F, (i) -> {
                            Lines.stroke(3.0F * i.fout());
                            Lines.circle(e.x, e.y, 3.0F + i.fin() * 15.0F);
                        });
                    });
                    buildingDamageMultiplier = 0.3f;
                    hitColor = Color.valueOf("fda981");
                    beamEffectInterval = 10.0F;
                    beamEffectSize = 3.5F;
                    splashDamage = 35;
                    splashDamageRadius = 4 * 8f;
                    pierceArmor = true;//穿甲 穿透护甲
                    incendChance = 0.4f;
                    incendSpread = 5f;
                    incendAmount = 1;//>=1时会有燃烧效果
                }};
                //  coolant = consumeCoolant(0);
                consumePower(480 / 60f);
                consumeLiquid(幻液, 12 / 60f);
                //  buildType = Build::new;
            }

            class Build extends ContinuousTurretBuild {
                public void updateTile() {
                    super.updateTile();
                    //不被火焰灼伤
                    if (bullets.any()) {
                        for (var entry : bullets) {
                            updateBullet(entry);
                        }

                        wasShooting = true;
                        heat = 1f;
                        curRecoil = recoil;
                    }
                    tile.getLinkedTiles(t -> {
                        if (t == null || !Fires.has(t.x, t.y)) return;

                        Fire fire = Fires.get(t.x, t.y);
                        fire.remove();
                    });
                }
            }
        };
        阳辰 = new ContinuousTurret("阳辰") {
            {
                localizedName = Core.bundle.get("Turret.yangchen");
                description = Core.bundle.getOrNull("Turret.description.yangchen");
                buildType = Build::new;
                requirements(Category.turret, with(缕, 150, 血晶, 30, 翠, 250, 威灵, 50, 超烬, 25));
                shootEffect = Fx.shootBigSmoke2;
                shootCone = 10f;
                group = BlockGroup.turrets;
                unitSort = UnitSorts.strongest;//优先最强，攻击单位时的优先选择/closest/farthest/strongest/weakest
                size = 4;

                shootY = 5;
                range = 50 * 8;
                shootSound = Sounds.none;
                loopSound = Sounds.tractorbeam;
                loopSoundVolume = 0.5f;
                recoil = 1;//武器后座
                //shootY = 0;//中心发射子弹
                rotateSpeed = 1;
                shootType = new JiGuangFanWeiShangHaiBulletType() {{
                    beamEffect = new Effect(22.0F, (e) -> {
                        Draw.color(Color.valueOf("fe869e"));
                        e.scaled(20.0F, (i) -> {
                            Lines.stroke(3.0F * i.fout());
                            Lines.circle(e.x, e.y, 3.0F + i.fin() * 15.0F);
                        });
                    });
                    buildingDamageMultiplier = 0.3f;
                    hitColor = Color.valueOf("fe869e");
                    sprite = "ct-阳辰-laser";
                    beamEffectInterval = 10.0F;
                    beamEffectSize = 3.5F;
                    splashDamage = 70;
                    splashDamageRadius = 6 * 8f;
                    pierceArmor = true;//穿甲 穿透护甲
                    incendChance = 0.4f;
                    incendSpread = 5f;
                    incendAmount = 1;//>=1时会有燃烧效果
                }};
                //  coolant = consumeCoolant(0);
                consumePower(480 / 60f);
                consumeLiquid(精纯灵液, 4 / 60f);
                //  buildType = Build::new;
            }

            class Build extends ContinuousTurretBuild {
                public void updateTile() {
                    super.updateTile();
                    //不被火焰灼伤
                    if (bullets.any()) {
                        for (var entry : bullets) {
                            updateBullet(entry);
                        }

                        wasShooting = true;
                        heat = 1f;
                        curRecoil = recoil;
                    }
                    tile.getLinkedTiles(t -> {
                        if (t == null || !Fires.has(t.x, t.y)) return;

                        Fire fire = Fires.get(t.x, t.y);
                        fire.remove();
                    });
                }
            }
        };
        冰蜂 = new ItemTurret("冰蜂") {
            {
                localizedName = Core.bundle.get("Turret.bingfeng");
                description = Core.bundle.getOrNull("Turret.description.bingfeng");
                requirements(Category.turret, with(
                        缕, 60, 血晶, 75, 翠, 120, 陶, 130, 明宝, 35
                ));
                health = 2100;
                size = 3;
                targetGround = false;
                targetAir = true;
                range = 32 * 8;
                inaccuracy = 8;
                recoil = 3;//后座力动画
                reload = 7;//射速
                rotateSpeed = 10f;
                shootSound = Sounds.shootBig;
                ammoUseEffect = NewFx.子弹抛壳2(5, 50, Pal.lightOrange, Pal.lightishGray, Pal.lightishGray);//弹壳脱壳动画效果
                shoot = new ShootAlternate() {{
                    spread = 15;
                    shots = 2;
                    barrels = 2;
                }};
                xRand = 2;
                shootCone = 30;
                maxAmmo = 10;
                ammo(
                        血晶, new 冰蜂Bullet(50, 26, 5, 1, 6, C("fa836a")) {{
                            backColor = C("f95a88");
                            frontColor = C("f9ad9d");
                        }},
                        灵玉, new 冰蜂Bullet(50, 32, 5, 1, 6, 灵玉.color),
                        威灵, new 冰蜂Bullet(50, 48, 5, 1, 6, 威灵.color),
                        萤玫, new 冰蜂Bullet(50, 40, 5, 1, 6, 萤玫.color)
                );

            }
        };

        熔岩 = new LaserTurret("熔岩") {{
            localizedName = "熔岩";
            requirements(Category.turret, with(缕, 80, 血晶, 100, 翠, 140, 陶, 150, 灵玉, 80));
            shootEffect = Fx.shootBigSmoke2;
            shootCone = 10f;
            shake = 2f;
            size = 3;
            range = 25 * 8;
            reload = 15f;
            shootSound = Sounds.laserbig;
            loopSound = Sounds.beam;
            loopSoundVolume = 0.5f;
            drawer = new DrawTurret() {
                {
                    parts.addAll(
                            new RegionPart("-1") {{
                                progress = PartProgress.warmup;
                                mirror = false;//镜像
                                blending = Blending.additive;
                                // under = true;//在主体下面
                                moveRot = 0;//倾斜角度
                                moveY = -0;//上下
                                moveX = 0f;//左右
                                outline = false;
                                layer = 115;
                                colorTo = Color.valueOf("f8ca4dff");
                                color = Color.valueOf("f8ca4d00");
                                shootWarmupSpeed = 0.0065f;
                                minWarmup = 0.0100f;

                            }},
                            new CTRegionPart.射击时显示("-2", 400, 400, 1, C("f8ca4d00"), C("f8ca4d")) {{
                                shootWarmupSpeed = 0.0065f;
                                minWarmup = 0.0100f;
                            }}
                    );
                }

                ;
            };
            shootDuration = 180; //炮口停留时间
            rotateSpeed = 2f;
            liquidCapacity = 50;
            shootType = new ContinuousLaserBulletType(320 / 12f) {{
                length = 28 * 8;
                hitEffect = Fx.hitMeltdown;
                hitColor = Pal.meltdownHit;
                status = StatusEffects.burning;
                statusDuration = 10 * 60;
                drawSize = 420f / 2;
                width = 5.0F;
                //lifetime=90;
                // timescaleDamage = true;
                // incendChance = 0.4f;
                // incendSpread = 5f;
                incendAmount = 0;//>1时会有燃烧效果
                ammoMultiplier = 1f;

                chargeEffect = new ParticleEffect() {{
                    interp = swingIn;
                    region = "ctcoresystem-斜四星";
                    colorFrom = colorTo = Color.valueOf("18cf9eaa");
                    //length = 20f;baseLength = 10f;
                    sizeFrom = 7f;
                    sizeTo = 0f;
                    spin = 5f;
                    particles = 1;
                    length = 0;
                    lifetime = 30;
                }};
            }};
            // coolantMultiplier = 0.2f; //液体冷却倍率
            //  coolant = consumeCoolant(0.3f);
            consumePower(400 / 60f);
            consumeLiquid(Liquids.water, 18 / 60f);
        }};
        熔火 = new ContinuousTurret("熔火") {{
            localizedName = "熔火";
            requirements(Category.turret, with(缕, 80, 血晶, 100, 翠, 140, 陶, 150, 灵玉, 80));
            shootEffect = Fx.shootBigSmoke2;
            shootCone = 10f;
            shake = 2f;
            size = 3;
            range = 21 * 8;
            rotateSpeed = 2f;
            shootSound = Sounds.laserbig;
            loopSound = Sounds.beam;
            loopSoundVolume = 0.5f;
            drawer = new DrawTurret() {
                {
                    parts.addAll(
                            new RegionPart("-1") {{
                                progress = PartProgress.warmup;
                                mirror = false;//镜像
                                blending = Blending.additive;
                                // under = true;//在主体下面
                                moveRot = 0;//倾斜角度
                                moveY = -0;//上下
                                moveX = 0f;//左右
                                outline = false;
                                layer = 115;
                                colorTo = Color.valueOf("f8ca4dff");
                                color = Color.valueOf("f8ca4d00");
                                shootWarmupSpeed = 0.0065f;
                                minWarmup = 0.0100f;

                            }}
                    );
                }

                ;
            };
            liquidCapacity = 50;


            shootType = new ContinuousLaserBulletType(75 / 12f) {{
                colors = new Color[]{Color.valueOf("0e963e55"), Color.valueOf("18cf9eaa"), Color.valueOf("90ffb3"), Color.white};
                length = 24 * 8;
                hitEffect = Fx.hitMeltdown;
                hitColor = Pal.meltdownHit;
                pierceArmor = true;//穿甲 穿透护甲
                status = 毒;
                statusDuration = 4 * 60;
                drawSize = 420f / 2;
                width = 5.0F;
                // timescaleDamage = true;
                // incendChance = 0.4f;
                // incendSpread = 5f;
                incendAmount = 0;//>1时会有燃烧效果
                ammoMultiplier = 1f;
            }};
            //coolantMultiplier = 0.2f; //液体冷却倍率
            //coolant = consumeCoolant(0.3f);//液体消耗，会影响冷却倍率
            consumePower(380 / 60f);
            consumeLiquid(Liquids.water, 18 / 60f);
        }};
    }
}
