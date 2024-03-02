package ct.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Interp;
import arc.math.Mathf;
import arc.math.geom.Vec2;
import arc.struct.ObjectSet;
import ct.Asystem.type.BlockDestroyReward;
import ct.Asystem.type.OnlyAttackCoreAI;
import mindustry.ai.types.DefenderAI;
import mindustry.ai.types.GroundAI;
import mindustry.ai.types.SuicideAI;
import mindustry.content.*;
import mindustry.entities.Effect;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.ExplosionEffect;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootHelix;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.ItemStack;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.type.ammo.PowerAmmoType;
import mindustry.type.weapons.PointDefenseWeapon;
import mindustry.type.weapons.RepairBeamWeapon;
import mindustry.world.meta.BlockFlag;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.lineAngle;
import static arc.graphics.g2d.Lines.stroke;
import static arc.math.Angles.randLenVectors;
import static ct.Asystem.type.CT3UnitType.CTRUnitType;
import static mindustry.Vars.tilePayload;
import static mindustry.content.Fx.rand;
import static mindustry.content.StatusEffects.*;

//UnitTypes.latum.hidden = false
public class CTR4Unit2 {

    public static float 生命倍率 = 2.5F;
    //陆军
    public static UnitType 尖刀, 战锤, crawler, 堡垒, 权杖, 君主, 帝王, vela;
    //空军
    public static UnitType flare, eclipse, horizon, zenith, antumbra, avert, obviate;
    //空辅
    public static UnitType mega, evoke, incite, emanate, quell, disrupt;
    //地爬
    public static UnitType corvus, atrax, merui, cleroi, anthicus, tecta, collaris;
    //虫子
    public static UnitType latum1, renale1;

    public static void load() {


        尖刀 = new CTRUnitType("dagger", "dagger") {{
            localizedName = "CT利刃";
            speed = 0.5f;
            hitSize = 8f;
            health = 280;
            weapons.add(new Weapon("large-weapon") {{
                reload = 60f;
                x = 4f;
                y = 2f;
                top = false;
                shoot = new ShootSpread(3, 4f);
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(2f, 8) {{
                    width = 5f;
                    height = 7f;
                    lifetime = 60f;
                    trailWidth = 3f;
                    trailLength = 6;
                    trailRotation = true;
                    trailInterval = 3f;
                    trailEffect = Fx.none;
                }};
            }});
        }};

        战锤 = new CTRUnitType("mace", "mace") {{
            localizedName = "CT战锤";
            speed = 0.5f;
            hitSize = 10f;
            health = 830;
            armor = 4f;
            // ammoType = new ItemAmmoType(Items.coal);
            // immunities.add(StatusEffects.burning);
            weapons.add(new Weapon("large-weapon") {{
                reload = 60f;
                x = 4f;
                y = 2f;
                top = false;
                shoot.shots = 3;
                shoot.shotDelay = 5f;
                inaccuracy = 12f;
                //shoot = new ShootSpread(3, 4f);
                ejectEffect = Fx.casing1;

                bullet = new BasicBulletType(3f, 17) {{
                    shootEffect = new Effect(12f, e -> {
                        color(Pal.lightFlame, Pal.darkFlame, Color.gray, e.fin());
                        stroke(e.fout() * 1.2f + 0.5f);
                        randLenVectors(e.id, 7, 25f * e.finpow(), e.rotation, 50f, (x, y) -> {
                            lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), e.fin() * 5f + 2f);
                        });
                    });
                    pierceBuilding = true;
                    pierceCap = 2;
                    hitEffect = Fx.hitFlameSmall;
                    status = burning;
                    width = 5f;
                    height = 7f;
                    lifetime = 60f;
                    trailWidth = 3f;
                    trailLength = 6;
                    trailRotation = true;
                    trailInterval = 3f;
                    trailEffect = Fx.shootSmallFlame;
                }};
            }});
        }};
        堡垒 = new CTRUnitType("fortress", "fortress") {{
            localizedName = "CT堡垒";
            speed = 0.43f;
            hitSize = 13f;
            rotateSpeed = 3f;
            targetAir = false;
            health = 1700;
            armor = 9f;
            mechFrontSway = 0.55f;
            ammoType = new ItemAmmoType(Items.graphite);

            weapons.add(new Weapon("artillery") {{
                top = false;
                y = 1f;
                x = 9f;
                reload = 180f;
                recoil = 4f;
                shake = 2f;
                ejectEffect = Fx.casing2;
                shootSound = Sounds.artillery;
                shoot.shots = 5;
                shoot.shotDelay = 15f;
                inaccuracy = 20f;
                bullet = new ArtilleryBulletType(2f, 30, "shell") {{
                    hitEffect = new Effect(120, e -> {
                        Draw.color(Color.valueOf("d7b528"));
                        e.scaled(6, i -> {
                            Lines.stroke(3 * i.fout());
                            Lines.circle(e.x, e.y, 3 + i.fin() * 25);
                        });
                        Draw.color(Color.gray);
                        Angles.randLenVectors(e.id, 6, 2 + 23 * e.finpow(), (x, y) -> {
                            Fill.circle(e.x + x, e.y + y, e.fout() * 4 + 0.5f);
                        });
                        Draw.color(Color.valueOf("d75128"));
                        Lines.stroke(e.fout());
                        Angles.randLenVectors(e.id + 1, 4, 1 + 23 * e.finpow(), (x, y) -> {
                            Lines.lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1 + e.fout() * 3);
                        });
                        Drawf.light(e.x, e.y, 60, Color.valueOf("df630f"), 0.7f * e.fout());
                    });//Fx.blastExplosion;
                    knockback = 0.8f;
                    lifetime = 120f;
                    width = height = 14f;
                    collides = true;
                    collidesTiles = true;
                    splashDamageRadius = 35f;
                    splashDamage = 80f;
                    backColor = Pal.bulletYellowBack;
                    frontColor = Pal.bulletYellow;
                    trailLength = 22;
                    trailWidth = 3;
                    trailEffect = new Effect(15, 50, e -> {
                        color(Pal.lightFlame, Pal.darkFlame, Color.gray, e.fin());
                        Angles.randLenVectors(e.id, 6, 2 + 23 * e.finpow(), (x, y) -> {
                            Fill.circle(e.x + x, e.y + y, e.fout() * 4 + 0.5f);
                        });
                    });
                    /* */
                    intervalBullet = new LaserBulletType(40) {{
                        colors = new Color[]{Pal.lightFlame.cpy().a(0.4f), Pal.darkFlame, Color.white};
                        //TODO merge
                        chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
                        shoot.shots = 3;
                        buildingDamageMultiplier = 0.25f;
                        hitEffect = Fx.hitLancer;
                        hitSize = 4;
                        lifetime = 16f;
                        drawSize = 400f;
                        collidesAir = false;
                        length = 32f;
                        ammoMultiplier = 1f;
                        pierceCap = 4;
                    }};

                }};
//                    intervalRandomSpread = 360;//随机散布间隔子弹的角度
//                    intervalBullets = 1;//每个间隔产生的子弹数
//                    intervalAngle = 0;//间隔弹的角度偏移。
//                    intervalSpread = 0;//各个间隔弹之间的夹角。


            }});
        }};
        权杖 = new CTRUnitType("scepter", "scepter") {{

            localizedName = "CT王权";
            speed = 0.36f;
            hitSize = 22f;
            rotateSpeed = 2.1f;
            health = 15000;
            armor = 10f;
            mechFrontSway = 1f;
            ammoType = new ItemAmmoType(Items.thorium);

            mechStepParticles = true;
            stepShake = 0.15f;
            singleTarget = true;
            drownTimeMultiplier = 4f;


            BulletType smallBullet2 = new BasicBulletType(13f, 40) {{
                pierce = true;
                pierceCap = 10;
                width = 14f;
                height = 33f;
                lifetime = 20f;
                shootEffect = Fx.shootBig;
                fragVelocityMin = 0.4f;

                //hitEffect = Fx.blastExplosion;
                hitEffect = new Effect(33, e -> {
                    color(Pal.missileYellow);

                    e.scaled(10, i -> {
                        stroke(3f * i.fout());
                        Lines.circle(e.x, e.y, 8f + i.fin() * 15f);
                    });

                    color(Color.gray);

                    randLenVectors(e.id, 7, 2f + 23f * e.finpow(), (x, y) -> {
                        Fill.circle(e.x + x, e.y + y, e.fout() * 4f + 0.5f);
                    });

                    color(Pal.missileYellowBack);
                    stroke(e.fout());

                    randLenVectors(e.id + 1, 4, 1f + 23f * e.finpow(), (x, y) -> {
                        lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + e.fout() * 3f);
                    });

                    Drawf.light(e.x, e.y, 45f, Pal.missileYellowBack, 0.8f * e.fout());
                });
                splashDamage = 18f;
                splashDamageRadius = 24f;
                trailWidth = 5f;
                trailLength = 8;
                trailRotation = true;
                trailInterval = 3f;
                trailEffect = Fx.none;

/*                fragBullets = 3;
                fragLifeMin = 0f;
                fragRandomSpread = 30f;

                fragBullet = new BasicBulletType(9f, 20){{
                    width = 10f;
                    height = 10f;
                    pierce = true;
                    pierceBuilding = true;
                    pierceCap = 3;

                    lifetime = 20f;
                    hitEffect = Fx.flakExplosion;
                    splashDamage = 15f;
                    splashDamageRadius = 10f;
                }};*/
            }};
            BulletType smallBullet = new BasicBulletType(7f, 30) {{
                width = 13f;
                height = 17f;
                lifetime = 40f;
                hitEffect = Fx.flakExplosion;

            }};

            weapons.add(
                    new Weapon("mount-weapon") {{
                        reload = 30f;
                        x = 8.5f;
                        y = 6f;
                        rotate = true;
                        inaccuracy = 7f;
                        bullet = smallBullet2;
                        shoot.shots = 2;
                        shoot.shotDelay = 20f;
                        ejectEffect = Fx.casing4;
                        shootSound = Sounds.bang;
                    }},
                    new Weapon("mount-weapon") {{
                        reload = 60f;
                        x = 8.5f;
                        y = -7f;
                        rotate = true;
                        inaccuracy = 7f;
                        bullet = smallBullet2;
                        shake = 2f;
                        shoot.shots = 2;
                        shoot.shotDelay = 20f;
                        ejectEffect = Fx.casing4;
                        shootSound = Sounds.bang;
                    }}


            );

            weapons.add(
                    new Weapon("large-laser-mount") {{
                        shake = 4f;
                        shootY = 9f;
                        x = 18f;
                        y = 5f;
                        rotateSpeed = 2f;
                        reload = 45f;
                        recoil = 4f;
                        shootSound = Sounds.laser;
                        shadow = 20f;
                        rotate = true;

                        bullet = new LaserBulletType() {{
                            damage = 115f;
                            sideAngle = 20f;
                            sideWidth = 1.5f;
                            sideLength = 80f;
                            width = 25f;
                            length = 350f;
                            shootEffect = Fx.shockwave;
                            colors = new Color[]{Color.valueOf("ec7458aa"), Color.valueOf("ff9c5a"), Color.white};
                        }};
                    }}
            );
        }};


        君主 = new CTRUnitType("reign", "reign") {
            {
                localizedName = "CT君主";
                speed = 0.35f;
                hitSize = 26f;
                rotateSpeed = 1.65f;
                health = 56000;
                armor = 14f;
                mechStepParticles = true;
                stepShake = 0.75f;
                drownTimeMultiplier = 6f;
                mechFrontSway = 1.9f;
                mechSideSway = 0.6f;
                ammoType = new ItemAmmoType(Items.thorium);
                abilities.add(
                        new RepairFieldAbility(15000, 15 * 60, 0.1f * 8)//给自己(oct那种治疗)
                        {{
                            healEffect = Fx.none;
                            activeEffect = Fx.none;
                            parentizeEffects = true;
                        }}
                );
                weapons.add(
                        new Weapon("reign-weapon") {{
                            top = false;
                            y = 1f;
                            x = 21.5f;
                            shootY = 11f;
                            reload = 30f;
                            recoil = 10f;
                            shake = 2f;
                            ejectEffect = Fx.casing4;
                            shootSound = Sounds.bang;

                            inaccuracy = 8;
                            shoot = new ShootAlternate() {{
                                spread = 4.7f;
                                shots = 4;
                                barrels = 4;
                                shotDelay = 6;
                            }};
                            bullet = new BasicBulletType(13f, 80) {{
                                pierce = true;
                                pierceCap = 5;
                                width = 20f;
                                height = 40f;
                                lifetime = 28f;
                                shootEffect = Fx.shootBig;
                                fragVelocityMin = 0.4f;

                                hitEffect = Fx.blastExplosion;
                                splashDamage = 18f;
                                splashDamageRadius = 13f;

                                trailWidth = 5f;
                                trailLength = 8;
                                trailRotation = true;
                                trailInterval = 3f;
                                trailEffect = Fx.none;

                                fragBullets = 3;
                                fragLifeMin = 0f;
                                fragRandomSpread = 30f;

                                fragBullet = new BasicBulletType(9f, 15) {{
                                    width = 10f;
                                    height = 10f;
                                    pierce = true;
                                    pierceBuilding = true;
                                    pierceCap = 3;

                                    lifetime = 20f;
                                    hitEffect = Fx.flakExplosion;
                                    splashDamage = 15f;
                                    splashDamageRadius = 10f;
                                }};
                            }};
                        }}

                );
            }
        };

        //绿色路
        CTRUnitType 新星 = new CTRUnitType("nova", "nova") {{
            canBoost = true;
            boostMultiplier = 1.5f;
            speed = 0.65f;
            hitSize = 8f;
            health = 120f;

            armor = 1f;

            weapons.add(new RepairBeamWeapon("gamesmod-CGrepair-beam-weapon-center") {{
                x = 0f;
                y = -5.5f;
                shootY = 6f;
                beamWidth = 0.8f;
                mirror = false;
                repairSpeed = 0.75f;

                bullet = new BulletType() {{
                    maxRange = 120f;
                }};
            }});
            // ammoType = new PowerAmmoType(1000);

            weapons.add(new Weapon("heal-weapon") {{
                top = false;
                shootY = 2f;
                reload = 18f;
                x = 4.5f;
                alternate = false;
                ejectEffect = Fx.none;
                recoil = 2f;
                shootSound = Sounds.lasershoot;

                bullet = new LaserBoltBulletType(5.2f, 25) {{
                    lifetime = 50f;
                    healPercent = 5f;
                    collidesTeam = true;
                    backColor = Pal.heal;
                    frontColor = Color.white;
                }};
            }});
        }};

        CTRUnitType 恒星 = new CTRUnitType("pulsar", "pulsar") {{
            canBoost = true;
            boostMultiplier = 1.6f;
            speed = 0.83f;
            hitSize = 11f;
            health = 320f;

            armor = 4f;
            riseSpeed = 0.07f;


            abilities.add(new ShieldRegenFieldAbility(20f, 200f, 60f * 5, 60f));
            //ammoType = new PowerAmmoType(1300);

            weapons.add(new Weapon("heal-shotgun-weapon") {{
                top = false;
                x = 5f;
                shake = 2.2f;
                y = 0.5f;
                shootY = 2.5f;

                reload = 45f;
                inaccuracy = 35;

                shoot.shots = 3;
                shoot.shotDelay = 0.5f;

                ejectEffect = Fx.none;
                recoil = 2.5f;
                shootSound = Sounds.spark;

                bullet = new LightningBulletType() {{
                    lightningColor = hitColor = Pal.heal;
                    damage = 20f;
                    lightningLength = 20;
                    lightningLengthRand = 7;
                    shootEffect = Fx.shootHeal;
                    //Does not actually do anything; Just here to make stats work
                    healPercent = 2f;

                    lightningType = new BulletType(0.0001f, 0f) {{
                        lifetime = Fx.lightning.lifetime;
                        hitEffect = Fx.hitLancer;
                        despawnEffect = Fx.none;
                        status = StatusEffects.shocked;
                        statusDuration = 10f;
                        hittable = false;
                        healPercent = 1.6f;
                        collidesTeam = true;
                    }};
                }};
            }});
        }};

        CTRUnitType 耀星 = new CTRUnitType("quasar", "quasar") {{

            boostMultiplier = 2f;
            health = 640f;

            canBoost = true;
            armor = 9f;
            mechLandShake = 2f;
            riseSpeed = 0.05f;

            mechFrontSway = 0.55f;
            ammoType = new PowerAmmoType(1500);

            speed = 0.45f;
            hitSize = 13f;


            drawShields = false;

            abilities.add(new ForceFieldAbility(60f, 0.4f, 1200f, 60f * 6));

            weapons.add(new Weapon("beam-weapon") {{
                top = false;
                shake = 2f;
                shootY = 4f;
                x = 6.5f;
                reload = 55f;
                recoil = 4f;
                shootSound = Sounds.laser;
                shoot.shots = 2;
                shoot.shotDelay = 15;
                bullet = new LaserBulletType() {{
                    damage = 45f;
                    recoil = 0.3f;//射击回退
                    sideAngle = 45f;
                    sideWidth = 1f;
                    sideLength = 70f;
                    healPercent = 10f;
                    collidesTeam = true;
                    length = 200f;
                    colors = new Color[]{Pal.heal.cpy().a(0.4f), Pal.heal, Color.white};
                }};
            }});
        }};

        CTRUnitType 灾星 = new CTRUnitType("vela", "vela") {{
            hitSize = 24f;

            rotateSpeed = 1.8f;
            mechFrontSway = 1f;


            mechStepParticles = true;
            stepShake = 0.15f;
            ammoType = new PowerAmmoType(2500);
            drownTimeMultiplier = 4f;

            speed = 0.44f;
            boostMultiplier = 2.4f;
            engineOffset = 12f;
            engineSize = 6f;
            lowAltitude = true;
            riseSpeed = 0.02f;

            health = 8200f;
            armor = 9f;
            canBoost = true;
            mechLandShake = 4f;
            immunities = ObjectSet.with(burning);

            singleTarget = true;

            weapons.add(new Weapon("vela-weapon") {{
                mirror = false;
                top = false;
                shake = 4f;
                shootY = 14f;
                x = y = 0f;

                shoot.firstShotDelay = Fx.greenLaserChargeSmall.lifetime - 1f;
                parentizeEffects = true;

                reload = 155f;
                recoil = 0f;
                chargeSound = Sounds.lasercharge2;
                shootSound = Sounds.beam;
                continuous = true;
                cooldownTime = 200f;

                bullet = new ContinuousLaserBulletType() {{
                    damage = 500f / 12;
                    length = 180f * 1.2f;
                    hitEffect = Fx.hitMeltHeal;
                    drawSize = 420f;
                    lifetime = 160f * 1.2f;
                    shake = 1f;
                    despawnEffect = Fx.smokeCloud;
                    smokeEffect = Fx.none;

                    chargeEffect = Fx.greenLaserChargeSmall;

                    incendChance = 0.1f;
                    incendSpread = 5f;
                    incendAmount = 1;

                    //constant healing
                    healPercent = 1f;
                    collidesTeam = true;

                    colors = new Color[]{Pal.heal.cpy().a(.2f), Pal.heal.cpy().a(.5f), Pal.heal.cpy().mul(1.2f), Color.white};
                }};

                shootStatus = StatusEffects.slow;
                shootStatusDuration = bullet.lifetime + shoot.firstShotDelay;
            }});
            abilities.add(new RepairFieldAbility(300f, 60f, 140f));
        }};

        CTRUnitType 死星 = new CTRUnitType("corvus", "corvus") {{
            hitSize = 29f;
            health = 18000f;
            armor = 9f;
            stepShake = 1.5f;
            rotateSpeed = 1.5f;
            drownTimeMultiplier = 6f;

            legCount = 4;
            legLength = 14f;
            legBaseOffset = 11f;
            legMoveSpace = 1.5f;
            legForwardScl = 0.58f;
            hovering = true;
            shadowElevation = 0.4f;
            // ammoType = new PowerAmmoType(4000);
            groundLayer = Layer.legUnit;

            speed = 0.54f;

            drawShields = false;

            weapons.add(new Weapon("corvus-weapon") {{
                shootSound = Sounds.laserblast;
                chargeSound = Sounds.lasercharge;
                soundPitchMin = 1f;
                top = false;
                mirror = false;
                shake = 14f;
                shootY = 5f;
                x = y = 0;
                reload = 280f;
                recoil = 0f;

                cooldownTime = 350f;

                shootStatusDuration = 60f * 1f;
                shootStatus = StatusEffects.slow;
                shoot.firstShotDelay = Fx.greenLaserCharge.lifetime;
                parentizeEffects = true;

                bullet = new LaserBulletType() {{
                    length = 460f;
                    damage = 560f;
                    width = 75f;

                    lifetime = 65f;

                    lightningSpacing = 35f;
                    lightningLength = 5;
                    lightningDelay = 1.1f;
                    lightningLengthRand = 15;
                    lightningDamage = 50;
                    lightningAngleRand = 40f;
                    largeHit = true;
                    lightColor = lightningColor = Pal.heal;

                    chargeEffect = Fx.greenLaserCharge;

                    healPercent = 25f;
                    collidesTeam = true;

                    sideAngle = 15f;
                    sideWidth = 0f;
                    sideLength = 0f;
                    colors = new Color[]{Pal.heal.cpy().a(0.4f), Pal.heal, Color.white};
                }};
            }});
        }};

        //endregion
        //region ground legs
        //紫色爬爬
        CTRUnitType 爬虫 = new CTRUnitType("crawler", "crawler") {{
            aiController = SuicideAI::new;

            speed = 1.1f;
            hitSize = 8f;
            health = 200;
            mechSideSway = 0.25f;
            range = 40f;
            //ammoType = new ItemAmmoType(Items.coal);
            abilities.add(new SpawnDeathAbility(crawler, 5, 11f));//死亡分裂
            weapons.add(new Weapon() {{
                shootOnDeath = true;
                reload = 24f;
                shootCone = 180f;
                ejectEffect = Fx.none;
                shootSound = Sounds.explosion;
                x = shootY = 0f;
                mirror = false;
                bullet = new BulletType() {{
                    collidesTiles = false;
                    collides = false;
                    hitSound = Sounds.explosion;

                    rangeOverride = 30f;
                    hitEffect = Fx.pulverize;
                    speed = 0f;
                    splashDamageRadius = 55f;
                    instantDisappear = true;
                    splashDamage = 90f;
                    killShooter = true;
                    hittable = false;
                    collidesAir = true;
                }};
            }});
        }};

        CTRUnitType 毒蛛 = new CTRUnitType("atrax", "atrax") {{
            speed = 0.6f;
            drag = 0.4f;
            hitSize = 13f;
            rotateSpeed = 3f;
            targetAir = false;
            health = 600;
            immunities = ObjectSet.with(burning, StatusEffects.melting);

            legCount = 4;
            legLength = 9f;
            legForwardScl = 0.6f;
            legMoveSpace = 1.4f;
            hovering = true;
            armor = 5f;
            //ammoType = new ItemAmmoType(Items.coal);

            shadowElevation = 0.2f;
            groundLayer = Layer.legUnit - 1f;

            weapons.add(new Weapon("atrax-weapon") {{
                top = false;
                shootY = 3f;
                reload = 9f;
                ejectEffect = Fx.none;
                recoil = 1f;
                x = 7f;
                shootSound = Sounds.flame;
                velocityRnd = 0.5f;//子弹的随机力度
                bullet = new LiquidBulletType(Liquids.slag) {{
                    damage = 30;
                    pierce = true;
                    speed = 3.3f;
                    drag = 0.009f;
                    shootEffect = Fx.shootSmall;
                    lifetime = 57f * 2.4f;
                    collidesAir = true;
                }};
            }});
        }};

        CTRUnitType 血侄 = new CTRUnitType("spiroct", "spiroct") {{
            speed = 0.54f;
            drag = 0.4f;
            hitSize = 15f;
            rotateSpeed = 3f;
            health = 1000;
            legCount = 6;
            legLength = 13f;
            legForwardScl = 0.8f;
            legMoveSpace = 1.4f;
            legBaseOffset = 2f;
            hovering = true;
            armor = 12f;
            // ammoType = new PowerAmmoType(1000);

            shadowElevation = 0.3f;
            groundLayer = Layer.legUnit;

            weapons.add(new Weapon("spiroct-weapon") {{
                shootY = 4f;
                reload = 14f;
                ejectEffect = Fx.none;
                recoil = 2f;
                rotate = true;
                shootSound = Sounds.sap;

                x = 8.5f;
                y = -1.5f;

                bullet = new SapBulletType() {{
                    sapStrength = 1.3f;//吸血比
                    length = 90 * 2.2f;
                    damage = 23;
                    shootEffect = Fx.shootSmall;
                    hitColor = color = Color.valueOf("bf92f9");
                    despawnEffect = Fx.none;
                    width = 0.54f;
                    lifetime = 35f;
                    knockback = -1.24f;
                }};
            }});

            weapons.add(new Weapon("mount-purple-weapon") {{
                reload = 18f;
                rotate = true;
                x = 4f;
                y = 3f;
                shootSound = Sounds.sap;

                bullet = new SapBulletType() {{
                    sapStrength = 0.8f;//吸血比
                    length = 40 * 1.8f;
                    damage = 30;
                    shootEffect = Fx.shootSmall;
                    hitColor = color = Color.valueOf("bf92f9");
                    despawnEffect = Fx.none;
                    width = 0.4f;
                    lifetime = 25f;
                    knockback = -0.65f;
                }};
            }});
        }};

        CTRUnitType 毒蛊 = new CTRUnitType("arkyid", "arkyid") {{
            drag = 0.1f;
            speed = 0.7f;
            hitSize = 23f;
            health = 8000;
            armor = 15f;
            float spawnTime = 60f * 5f;
            abilities.add(new UnitSpawnAbility(爬虫, spawnTime, 19.25f, -31.75f), new UnitSpawnAbility(爬虫, spawnTime, -19.25f, -31.75f));
            rotateSpeed = 2.7f;

            legCount = 6;
            legMoveSpace = 1f;
            legPairOffset = 3;
            legLength = 30f;
            legExtension = -15;
            legBaseOffset = 10f;
            stepShake = 1f;
            legLengthScl = 0.96f;
            rippleScale = 2f;
            legSpeed = 0.2f;
            ammoType = new PowerAmmoType(2000);

            legSplashDamage = 32;
            legSplashRange = 30;
            drownTimeMultiplier = 2f;

            hovering = true;
            shadowElevation = 0.65f;
            groundLayer = Layer.legUnit;

            abilities.add(new ShieldArcAbility() {{
                region = "tecta-shield";
                radius = 34f;
                angle = 82f;
                regen = 0.6f;
                cooldown = 60f * 8f;
                max = 4000f;
                y = -20f;
                width = 8f;
            }});
            BulletType sapper = new SapBulletType() {{
                sapStrength = 0.85f;
                length = 55f * 3;
                damage = 40;
                shootEffect = Fx.shootSmall;
                hitColor = color = Color.valueOf("bf92f9");
                despawnEffect = Fx.none;
                width = 0.55f;
                lifetime = 30f;
                knockback = -1f;
            }};

            weapons.add(
                    new Weapon("spiroct-weapon") {{
                        reload = 9f;
                        x = 4f;
                        y = 8f;
                        rotate = true;
                        bullet = sapper;
                        shootSound = Sounds.sap;
                    }},
                    new Weapon("spiroct-weapon") {{
                        reload = 14f;
                        x = 9f;
                        y = 6f;
                        rotate = true;
                        bullet = sapper;
                        shootSound = Sounds.sap;
                    }},
                    new Weapon("spiroct-weapon") {{
                        reload = 22f;
                        x = 14f;
                        y = 0f;
                        rotate = true;
                        bullet = sapper;
                        shootSound = Sounds.sap;
                    }},
                    new Weapon("large-purple-mount") {{
                        y = -7f;
                        x = 9f;
                        shootY = 7f;
                        reload = 45;
                        shake = 3f;
                        rotateSpeed = 2f;
                        ejectEffect = Fx.casing1;
                        shootSound = Sounds.artillery;
                        rotate = true;
                        shadow = 8f;
                        recoil = 3f;
                        shoot.shots = 3;
                        shoot.shotDelay = 20;
                        inaccuracy = 15;
                        bullet = new ArtilleryBulletType(2f, 12) {{
                            hitEffect = Fx.sapExplosion;
                            knockback = 0.8f;
                            lifetime = 120f;
                            width = height = 19f;
                            collidesTiles = true;
                            ammoMultiplier = 4f;
                            splashDamageRadius = 70f;
                            splashDamage = 65f;
                            backColor = Pal.sapBulletBack;
                            frontColor = lightningColor = Pal.sapBullet;
                            lightning = 3;
                            lightningLength = 10;
                            smokeEffect = Fx.shootBigSmoke2;
                            shake = 5f;

                            status = sapped;
                            statusDuration = 60f * 10;
                        }};
                    }});
        }};

        CTRUnitType 天蝎 = new CTRUnitType("toxopid", "toxopid") {{
            drag = 0.1f;
            speed = 0.7f;
            hitSize = 26f;
            health = 22000;
            armor = 45f;
            lightRadius = 140f;

            rotateSpeed = 1.9f;
            drownTimeMultiplier = 3f;

            legCount = 8;
            legMoveSpace = 0.8f;
            legPairOffset = 3;
            legLength = 75f;
            legExtension = -20;
            legBaseOffset = 8f;
            stepShake = 1f;
            legLengthScl = 0.93f;
            rippleScale = 3f;
            legSpeed = 0.19f;
            ammoType = new ItemAmmoType(Items.graphite, 8);

            legSplashDamage = 80;
            legSplashRange = 60;

            hovering = true;
            shadowElevation = 0.95f;
            groundLayer = Layer.legUnit;
            targetFlags = new BlockFlag[]{BlockFlag.turret, BlockFlag.factory, null};//优先炮塔
            weapons.add(
                    new Weapon("large-purple-mount") {{
                        y = -5f;
                        x = 11f;
                        shootY = 7f;
                        reload = 30;
                        shake = 4f;
                        rotateSpeed = 2f;
                        ejectEffect = Fx.casing1;
                        shootSound = Sounds.shootBig;
                        rotate = true;
                        shadow = 12f;
                        recoil = 3f;

                        shoot = new ShootSpread(3, 15f);

                        bullet = new ShrapnelBulletType() {{
                            length = 90 * 2.6f;
                            damage = 110f;
                            width = 35f;
                            serrationLenScl = 7f;
                            serrationSpaceOffset = 60f;
                            serrationFadeOffset = 0f;
                            serrations = 10;
                            serrationWidth = 6f;
                            fromColor = Pal.sapBullet;
                            toColor = Pal.sapBulletBack;
                            shootEffect = smokeEffect = Fx.sparkShoot;
                        }};
                    }});
            weapons.add(new Weapon() {{//闪电球子弹
                shootSound = Sounds.shockBlast;
                x = 0f;
                y = -2f;
                shootY = 0f;
                reload = 140f;
                mirror = false;
                minWarmup = 0.95f;
                shake = 3f;
                cooldownTime = reload - 10f;
                inaccuracy = 15;
                bullet = new BasicBulletType() {{
                    shoot = new ShootHelix() {{
                        mag = 1f;
                        scl = 5f;
                    }};

                    shootEffect = new MultiEffect(Fx.shootTitan, new WaveEffect() {{
                        colorTo = Pal.sapBulletBack;
                        sizeTo = 26f;
                        lifetime = 14f;
                        strokeFrom = 4f;
                    }});
                    smokeEffect = Fx.shootSmokeTitan;
                    hitColor = Pal.sapBullet;
                    despawnSound = Sounds.spark;

                    sprite = "large-orb";
                    trailEffect = Fx.missileTrail;
                    trailInterval = 3f;
                    trailParam = 4f;
                    speed = 3f;
                    damage = 45f;
                    lifetime = 130f;
                    width = height = 30f;
                    backColor = Pal.sapBulletBack;
                    frontColor = Pal.sapBullet;
                    shrinkX = shrinkY = 0f;
                    trailColor = Pal.sapBulletBack;
                    trailLength = 12;
                    trailWidth = 2.2f;
                    despawnEffect = hitEffect = new ExplosionEffect() {{
                        waveColor = Pal.sapBullet;
                        smokeColor = Color.gray;
                        sparkColor = Pal.sap;
                        waveStroke = 4f;
                        waveRad = 40f;
                    }};

                    intervalBullet = new LightningBulletType() {{
                        damage = 20;
                        collidesAir = false;
                        ammoMultiplier = 1f;
                        lightningColor = Pal.sapBullet;
                        lightningLength = 7;
                        lightningLengthRand = 6;

                        //for visual stats only.
                        buildingDamageMultiplier = 0.25f;

                        lightningType = new BulletType(0.0001f, 0f) {{
                            lifetime = Fx.lightning.lifetime;
                            hitEffect = Fx.hitLancer;
                            despawnEffect = Fx.none;
                            status = StatusEffects.shocked;
                            statusDuration = 10f;
                            hittable = false;
                            lightColor = Color.white;
                            buildingDamageMultiplier = 0.25f;
                        }};
                    }};

                    bulletInterval = 4f;

                    lightningColor = Pal.sapBullet;
                    lightningDamage = 8;
                    lightning = 8;
                    lightningLength = 15;
                    lightningLengthRand = 15;
                }};

            }});
            weapons.add(new Weapon() {{//狙击
                shootSound = Sounds.shockBlast;
                x = 0f;
                y = 0f;
                shootY = 0f;
                reload = 180f;
                mirror = false;
                //  minWarmup = 0.95f;
                shake = 3f;
                // cooldownTime = reload - 10f;
                //inaccuracy=10;
                bullet = new PointBulletType() {{
                    shootEffect = Fx.instShoot;
                    hitEffect = Fx.instHit;
                    smokeEffect = Fx.smokeCloud;
                    trailEffect = new Effect(30, e -> {
                        for (int i = 0; i < 2; i++) {
                            color(i == 0 ? Pal.sapBulletBack : Pal.sapBullet);

                            float m = i == 0 ? 1f : 0.5f;

                            float rot = e.rotation + 180f;
                            float w = 15f * e.fout() * m;
                            Drawf.tri(e.x, e.y, w, (30f + Mathf.randomSeedRange(e.id, 15f)) * m, rot);
                            Drawf.tri(e.x, e.y, w, 10f * m, rot + 180f);
                        }

                        Drawf.light(e.x, e.y, 60f, Pal.sapBulletBack, 0.6f * e.fout());
                    });
                    despawnEffect = new Effect(55f, 100f, e -> {
                        color(Pal.sapBulletBack);
                        stroke(e.fout() * 4f);
                        Lines.circle(e.x, e.y, 4f + e.finpow() * 20f);

                        for (int i = 0; i < 4; i++) {
                            Drawf.tri(e.x, e.y, 6f, 1.5f * 80f * e.fout(), i * 90 + 45);
                        }

                        color();
                        for (int i = 0; i < 4; i++) {
                            Drawf.tri(e.x, e.y, 3f, 1.5f * 30f * e.fout(), i * 90 + 45);
                        }

                        Drawf.light(e.x, e.y, 200f, Pal.sapBulletBack, 0.9f * e.fout());
                    });
                    trailSpacing = 20f;
                    damage = 1350;
                    buildingDamageMultiplier = 0.2f;
                    speed = 7;
                    hitShake = 6f;
                    ammoMultiplier = 1f;
                    fragBullets = 5;
                    //despawnSound = CreatorsSound.loadSound("none");//Sounds.plasmaboom
                    fragBullet = new PointBulletType() {
                        {
                            //despawnSound = CreatorsSound.loadSound("none");//自定义音效
                            collidesAir = true;
                            trailEffect = Fx.none;
                            splashDamageRadius = 24;
                            splashDamage = 35;
                            buildingDamageMultiplier = 0.5f;
                            hitEffect = Fx.none;
                            despawnEffect = new MultiEffect(
                                    new Effect(130, e -> {
                                        color(Pal.sapBulletBack);
                                        e.scaled(30, i -> {
                                            Lines.stroke(3 * i.fout());
                                            Lines.circle(e.x, e.y, 3 + i.fin() * 15);
                                        });
                                    }));
                            lifetime = 12;
                            speed = 8;
                        }
                    };
                }};
            }});
        }};

        //endregion
        //region air attack
        //黄飞行
        CTRUnitType 星辉 = new CTRUnitType("flare", "flare") {{
            speed = 4f;
            accel = 0.08f;
            drag = 0.04f;
            flying = true;
            health = 70;
            engineOffset = 5.75f;
            //TODO balance
            //targetAir = false;
            circleTarget = true;
            targetFlags = new BlockFlag[]{BlockFlag.generator, null};
            hitSize = 9;
            itemCapacity = 10;
            weapons.add(new Weapon() {{
                y = 0f;
                x = 2f;
                reload = 20f;
                ejectEffect = Fx.casing1;
                shoot.shots = 3;
                shoot.shotDelay = 10;
                bullet = new BasicBulletType(2.5f, 9) {{
                    width = 7f;
                    height = 9f;
                    lifetime = 45f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    ammoMultiplier = 2;
                }};
                shootSound = Sounds.pew;
            }});
        }};

        CTRUnitType 天垠 = new CTRUnitType("horizon", "horizon") {{
            health = 340;
            speed = 3f;
            accel = 0.08f;
            drag = 0.016f;
            flying = true;
            hitSize = 10f;
            targetAir = false;
            engineOffset = 7.8f;
            range = 140f;
            faceTarget = false;
            armor = 3f;
            itemCapacity = 0;
            targetFlags = new BlockFlag[]{BlockFlag.factory, BlockFlag.generator, null};
            circleTarget = true;
            // ammoType = new ItemAmmoType(Items.graphite);

            weapons.add(new Weapon() {{
                minShootVelocity = 0.75f;
                x = 3f;
                shootY = 0f;
                reload = 12f;
                shootCone = 180f;
                ejectEffect = Fx.none;
                inaccuracy = 15f;
                ignoreRotation = true;
                shootSound = Sounds.none;
                shoot.shots = 3;
                shoot.shotDelay = 23;
                bullet = new BombBulletType(27f, 25f) {{
                    width = 10f;
                    height = 14f;
                    hitEffect = Fx.flakExplosion;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;

                    status = blasted;
                    statusDuration = 60f;
                }};
            }});
        }};

        CTRUnitType 苍穹 = new CTRUnitType("zenith", "zenith") {{
            health = 700;
            speed = 2f;
            accel = 0.04f;
            drag = 0.016f;
            flying = true;
            range = 140f;
            hitSize = 20f;
            lowAltitude = true;
            forceMultiTarget = true;
            armor = 5f;

            targetFlags = new BlockFlag[]{BlockFlag.launchPad, BlockFlag.storage, BlockFlag.battery, null};
            engineOffset = 12f;
            engineSize = 3f;
            ammoType = new ItemAmmoType(Items.graphite);
            weapons.add(new Weapon("locus-weapon") {{
                shootSound = Sounds.bolt;
                layerOffset = 0.0001f;
                reload = 18f;
                shootY = 10f;
                recoil = 1f;
                rotate = true;
                rotateSpeed = 1.4f;
                mirror = false;
                shootCone = 2f;
                x = 0f;
                y = 0f;
                heatColor = Color.valueOf("f9350f");
                cooldownTime = 30f;

                shoot = new ShootAlternate(3.5f);

                bullet = new RailBulletType() {{
                    length = 150f;
                    damage = 48f;
                    hitColor = Color.valueOf("feb380");
                    hitEffect = endEffect = Fx.hitBulletColor;
                    pierceDamageFactor = 0.8f;

                    smokeEffect = Fx.colorSpark;

                    endEffect = new Effect(14f, e -> {
                        color(e.color);
                        Drawf.tri(e.x, e.y, e.fout() * 1.5f, 5f, e.rotation);
                    });

                    shootEffect = new Effect(10, e -> {
                        color(e.color);
                        float w = 1.2f + 7 * e.fout();

                        Drawf.tri(e.x, e.y, w, 30f * e.fout(), e.rotation);
                        color(e.color);

                        for (int i : Mathf.signs) {
                            Drawf.tri(e.x, e.y, w * 0.9f, 18f * e.fout(), e.rotation + i * 90f);
                        }

                        Drawf.tri(e.x, e.y, w, 4f * e.fout(), e.rotation + 180f);
                    });

                    lineEffect = new Effect(20f, e -> {
                        if (!(e.data instanceof Vec2 v)) return;

                        color(e.color);
                        stroke(e.fout() * 0.9f + 0.6f);

                        rand.setSeed(e.id);
                        for (int i = 0; i < 7; i++) {
                            Fx.v.trns(e.rotation, rand.random(8f, v.dst(e.x, e.y) - 8f));
                            Lines.lineAngleCenter(e.x + Fx.v.x, e.y + Fx.v.y, e.rotation + e.finpow(), e.foutpowdown() * 20f * rand.random(0.5f, 1f) + 0.3f);
                        }

                        e.scaled(14f, b -> {
                            stroke(b.fout() * 1.5f);
                            color(e.color);
                            Lines.line(e.x, e.y, v.x, v.y);
                        });
                    });
                }};
            }});
            weapons.add(new Weapon("zenith-missiles") {{
                reload = 40f;
                x = 7f;
                rotate = true;
                shake = 1f;
                shoot.shots = 3;
                shoot.shotDelay = 10;
                inaccuracy = 5f;
                velocityRnd = 0.2f;
                shootSound = Sounds.missile;

                bullet = new MissileBulletType(3f, 40) {{
                    width = 8f;
                    height = 8f;
                    shrinkY = 0f;
                    drag = -0.003f;
                    homingRange = 60f;
                    keepVelocity = false;
                    splashDamageRadius = 25f;
                    splashDamage = 15f;
                    lifetime = 70f;
                    trailColor = Pal.unitBack;
                    backColor = Pal.unitBack;
                    frontColor = Pal.unitFront;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                    weaveScale = 6f;
                    weaveMag = 1f;
                }};
            }});
        }};

        CTRUnitType 月影 = new CTRUnitType("antumbra", "antumbra") {{
            speed = 0.8f;
            accel = 0.04f;
            drag = 0.04f;
            rotateSpeed = 1.9f;
            flying = true;
            lowAltitude = true;
            health = 7200;
            armor = 17f;
            engineOffset = 21;
            engineSize = 5.3f;
            hitSize = 46f;
            targetFlags = new BlockFlag[]{BlockFlag.generator, BlockFlag.core, null};
            ammoType = new ItemAmmoType(Items.thorium);

            BulletType missiles = new MissileBulletType(2.7f, 40) {{
                width = 18f;
                height = 16f;
                shrinkY = 0f;
                drag = -0.01f;
                splashDamageRadius = 20f;
                splashDamage = 37f;
                ammoMultiplier = 4f;
                lifetime = 60f;
                hitEffect = Fx.blastExplosion;
                despawnEffect = Fx.blastExplosion;

                status = blasted;
                statusDuration = 60f;
            }};

            weapons.add(
                    new Weapon("missiles-mount") {{
                        y = 8f;
                        x = 17f;
                        reload = 20f;
                        ejectEffect = Fx.casing1;
                        rotateSpeed = 8f;
                        bullet = missiles;
                        shootSound = Sounds.missile;
                        rotate = true;
                        shadow = 6f;
                    }},
                    new Weapon("missiles-mount") {{
                        y = -8f;
                        x = 17f;
                        reload = 35;
                        rotateSpeed = 8f;
                        ejectEffect = Fx.casing1;
                        bullet = missiles;
                        shootSound = Sounds.missile;
                        rotate = true;
                        shadow = 6f;
                    }},
                    new Weapon("large-bullet-mount") {{
                        y = 2f;
                        x = 10f;
                        shootY = 10f;
                        reload = 12;
                        shake = 1f;
                        rotateSpeed = 2f;
                        ejectEffect = Fx.casing1;
                        shootSound = Sounds.shootBig;
                        rotate = true;
                        shadow = 8f;
                        bullet = new BasicBulletType(7f, 95) {{
                            width = 18f;
                            height = 27f;
                            lifetime = 30f;
                            shootEffect = Fx.shootBig;
                        }};
                    }}
            );
        }};

        CTRUnitType 日蚀 = new CTRUnitType("eclipse", "eclipse") {{
            speed = 0.64f;
            accel = 0.04f;
            drag = 0.04f;
            rotateSpeed = 1f;
            flying = true;
            lowAltitude = true;
            health = 22000;
            engineOffset = 38;
            engineSize = 7.3f;
            hitSize = 58f;
            armor = 45f;
            targetFlags = new BlockFlag[]{BlockFlag.reactor, BlockFlag.battery, BlockFlag.core, null};
            //ammoType = new ItemAmmoType(Items.thorium);

            BulletType fragBullet = new FlakBulletType(4f, 33) {{
                shootEffect = Fx.shootBig;
                ammoMultiplier = 4f;
                splashDamage = 65f;
                splashDamageRadius = 25f;
                collidesGround = true;
                lifetime = 70f;
                width = 12f;
                height = 20f;
                status = blasted;
                statusDuration = 60f;
            }};
            weapons.add(new Weapon("gamesmod-conquer-weapon") {{
                shootSound = Sounds.largeCannon;
                layerOffset = 0.1f;
                reload = 100f;
                shootY = 32.5f;
                shake = 5f;
                recoil = 5f;
                rotate = true;
                rotateSpeed = 0.6f;
                mirror = false;
                x = 0f;
                y = -2f;
                shadow = 50f;
                heatColor = Color.valueOf("f9350f");
                shootWarmupSpeed = 0.06f;
                cooldownTime = 110f;
                heatColor = Color.valueOf("f9350f");
                minWarmup = 0.9f;
                bullet = new BasicBulletType(8f, 360f) {{
                    sprite = "missile-large";
                    width = 12f;
                    height = 20f;
                    lifetime = 55f;
                    hitSize = 6f;

                    smokeEffect = Fx.shootSmokeTitan;
                    pierceCap = 3;
                    pierce = true;
                    pierceBuilding = true;
                    hitColor = backColor = trailColor = Color.valueOf("feb380");
                    frontColor = Color.white;
                    trailWidth = 4f;
                    trailLength = 9;
                    hitEffect = despawnEffect = Fx.massiveExplosion;

                    shootEffect = new ExplosionEffect() {{
                        lifetime = 40f;
                        waveStroke = 4f;
                        waveColor = sparkColor = trailColor;
                        waveRad = 15f;
                        smokeSize = 5f;
                        smokes = 8;
                        smokeSizeBase = 0f;
                        smokeColor = trailColor;
                        sparks = 8;
                        sparkRad = 40f;
                        sparkLen = 4f;
                        sparkStroke = 3f;
                    }};

                    int count = 6;
                    for (int j = 0; j < count; j++) {
                        int s = j;
                        for (int i : Mathf.signs) {
                            float fin = 0.05f + (j + 1) / (float) count;
                            float spd = speed;
                            float life = lifetime / Mathf.lerp(fin, 1f, 0.5f);
                            spawnBullets.add(new BasicBulletType(spd * fin, 60) {{
                                drag = 0.002f;
                                width = 12f;
                                height = 11f;
                                lifetime = life + 5f;
                                weaveRandom = false;
                                hitSize = 5f;
                                pierceCap = 2;
                                pierce = true;
                                pierceBuilding = true;
                                hitColor = backColor = trailColor = Color.valueOf("feb380");
                                frontColor = Color.white;
                                trailWidth = 2.5f;
                                trailLength = 7;
                                weaveScale = (3f + s / 2f) / 1.2f;
                                weaveMag = i * (4f - fin * 2f);

                                splashDamage = 65f;
                                splashDamageRadius = 30f;
                                despawnEffect = new ExplosionEffect() {{
                                    lifetime = 50f;
                                    waveStroke = 4f;
                                    waveColor = sparkColor = trailColor;
                                    waveRad = 30f;
                                    smokeSize = 7f;
                                    smokes = 6;
                                    smokeSizeBase = 0f;
                                    smokeColor = trailColor;
                                    sparks = 5;
                                    sparkRad = 30f;
                                    sparkLen = 3f;
                                    sparkStroke = 1.5f;
                                }};
                            }});
                        }
                    }
                }};
            }});
            weapons.add(
                    new Weapon("large-laser-mount") {{
                        shake = 4f;
                        shootY = 9f;
                        x = 18f;
                        y = 5f;
                        rotateSpeed = 2f;
                        reload = 45f;
                        recoil = 4f;
                        shootSound = Sounds.laser;
                        shadow = 20f;
                        rotate = true;

                        bullet = new LaserBulletType() {{
                            damage = 115f;
                            sideAngle = 20f;
                            sideWidth = 1.5f;
                            sideLength = 80f;
                            width = 60f;
                            length = 310f;
                            shootEffect = Fx.shockwave;
                            colors = new Color[]{Color.valueOf("ec7458aa"), Color.valueOf("ff9c5a"), Color.white};
                        }};
                    }},
                    new Weapon("large-artillery") {{
                        x = 11f;
                        y = 27f;
                        rotateSpeed = 2f;
                        inaccuracy = 33;
                        reload = 9f;
                        shootSound = Sounds.shoot;
                        shadow = 7f;
                        rotate = true;
                        recoil = 0.5f;
                        shootY = 7.25f;
                        bullet = fragBullet;
                    }},
                    new Weapon("large-artillery") {{
                        y = -13f;
                        x = 20f;
                        reload = 12f;
                        inaccuracy = 33;
                        ejectEffect = Fx.casing1;
                        rotateSpeed = 7f;
                        shake = 1f;
                        shootSound = Sounds.shoot;
                        rotate = true;
                        shadow = 12f;
                        shootY = 7.25f;
                        bullet = fragBullet;
                    }});
        }};

        //endregion
        //region air support

        CTRUnitType 独影 = new CTRUnitType("mono", "flare") {{
            //there's no reason to command monos anywhere. it's just annoying.
            // controller = u -> new MinerAI();

            //defaultCommand = UnitCommand.mineCommand;

            flying = true;
            drag = 0.06f;
            accel = 0.12f;
            speed = 1.5f;
            health = 100;
            engineSize = 1.8f;
            engineOffset = 5.7f;
            range = 50f;
            // isEnemy = false;

            ammoType = new PowerAmmoType(500);

            mineTier = 1;
            mineSpeed = 2.5f;
            weapons.add(new Weapon("merui-weapon") {{
                shootSound = Sounds.missile;
                mirror = false;
                x = 0f;
                y = 1f;
                shootY = 4f;
                reload = 60f;
                cooldownTime = 42f;
                heatColor = Pal.turretHeat;

                bullet = new ArtilleryBulletType(3f, 40) {{
                    shootEffect = new MultiEffect(Fx.shootSmallColor, new Effect(9, e -> {
                        color(Color.white, e.color, e.fin());
                        stroke(0.7f + e.fout());
                        Lines.square(e.x, e.y, e.fin() * 5f, e.rotation + 45f);

                        Drawf.light(e.x, e.y, 23f, e.color, e.fout() * 0.7f);
                    }));

                    collidesTiles = true;
                    backColor = hitColor = Pal.heal;
                    frontColor = Color.white;

                    knockback = 0.8f;
                    lifetime = 40f;
                    width = height = 9f;
                    splashDamageRadius = 19f;
                    splashDamage = 30f;

                    trailLength = 27;
                    trailWidth = 2.5f;
                    trailEffect = Fx.none;
                    trailColor = backColor;

                    trailInterp = Interp.slope;

                    shrinkX = 0.6f;
                    shrinkY = 0.2f;

                    hitEffect = despawnEffect = new MultiEffect(Fx.hitSquaresColor, new WaveEffect() {{
                        colorFrom = colorTo = Pal.heal;
                        sizeTo = splashDamageRadius + 2f;
                        lifetime = 9f;
                        strokeFrom = 2f;
                    }});
                }};
            }});
        }};

        CTRUnitType 幻型 = new CTRUnitType("poly", "flare") {{
            //  defaultCommand = UnitCommand.rebuildCommand;
            flying = true;
            drag = 0.05f;
            speed = 2.6f;
            rotateSpeed = 15f;
            accel = 0.1f;
            range = 130f;
            health = 400;

            engineOffset = 6.5f;
            hitSize = 9f;
            lowAltitude = true;

            // ammoType = new PowerAmmoType(900);


            abilities.add(new RepairFieldAbility(500f, 60f * 3, 70f));

            weapons.add(new Weapon("poly-weapon") {{
                top = false;
                y = -2.5f;
                x = 3.75f;
                reload = 5f;
                ejectEffect = Fx.none;
                recoil = 2f;
                shootSound = Sounds.missile;
                velocityRnd = 0.5f;
                inaccuracy = 15f;
                alternate = true;

                bullet = new MissileBulletType(4f, 20) {{
                    homingPower = 0.08f;
                    weaveMag = 4;
                    weaveScale = 4;
                    lifetime = 80f;
                    keepVelocity = false;
                    shootEffect = Fx.shootHeal;
                    smokeEffect = Fx.hitLaser;
                    hitEffect = despawnEffect = Fx.hitLaser;
                    frontColor = Color.white;
                    hitSound = Sounds.none;

                    healPercent = 5.5f;
                    collidesTeam = true;
                    backColor = Pal.heal;
                    trailColor = Pal.heal;
                }};
            }});
        }};

        CTRUnitType 巨像 = new CTRUnitType("mega", "flare") {{
            //defaultCommand = UnitCommand.repairCommand;


            health = 460;
            armor = 11f;
            speed = 2.5f;
            accel = 0.06f;
            drag = 0.017f;
            lowAltitude = true;
            flying = true;
            engineOffset = 10.5f;
            faceTarget = false;
            hitSize = 16.05f;
            engineSize = 3f;
            payloadCapacity = (2 * 2) * tilePayload;

            isEnemy = false;
            // ammoType = new PowerAmmoType(1100);
            LaserBoltBulletType MegaBullet = new LaserBoltBulletType(5.2f, 30) {{
                pierce = true; //穿透
                pierceCap = 2; //穿透数量
                lifetime = 60f;
                healPercent = 3f;
                collidesTeam = true;
                backColor = Pal.heal;
                frontColor = Color.white;
            }};
            weapons.add(
                    new Weapon("heal-weapon-mount") {{
                        shootSound = Sounds.lasershoot;
                        reload = 8f;
                        x = 8f;
                        y = -6f;
                        rotate = true;
                        itemCapacity = 30;
                        bullet = MegaBullet;
                    }},
                    new Weapon("heal-weapon-mount") {{
                        shootSound = Sounds.lasershoot;
                        reload = 12f;
                        x = 4f;
                        y = 5f;
                        rotate = true;
                        itemCapacity = 30;
                        bullet = MegaBullet;

                    }});
            abilities.add(new ForceFieldAbility(40f, 0.25f, 1200f, 60f * 6));//护盾力场

            weapons.add(new PointDefenseWeapon("cleroi-point-defense") {{//裂解
                x = 16f / 4f;
                y = -20f / 4f;
                reload = 9f;

                targetInterval = 9f;
                targetSwitchInterval = 12f;
                recoil = 0.5f;

                bullet = new BulletType() {{
                    shootSound = Sounds.lasershoot;
                    shootEffect = Fx.sparkShoot;
                    hitEffect = Fx.pointHit;
                    maxRange = 100f;
                    damage = 38f;
                }};
            }});
        }};

        CTRUnitType 雷霆 = new CTRUnitType("quad", "quad") {{
            armor = 1000f;
            health = 6000;
            speed = 1.7f;
            rotateSpeed = 2f;
            accel = 0.05f;
            drag = 0.017f;
            lowAltitude = false;
            flying = true;
            circleTarget = true;
            engineOffset = 13f;
            engineSize = 7f;
            faceTarget = false;
            hitSize = 36f;
            payloadCapacity = (3 * 3) * tilePayload;

            range = 140f;
            targetAir = false;
            targetFlags = new BlockFlag[]{BlockFlag.battery, BlockFlag.factory, null};

            // ammoType = new PowerAmmoType(3000);

            weapons.add(
                    new Weapon() {{
                        x = y = 0f;
                        mirror = false;
                        reload = 55f;
                        minShootVelocity = 0.01f;

                        soundPitchMin = 1f;
                        shootSound = Sounds.plasmadrop;

                        bullet = new BasicBulletType() {{
                            sprite = "large-bomb";
                            width = height = 120 / 4f;

                            maxRange = 30f;
                            ignoreRotation = true;

                            backColor = Pal.heal;
                            frontColor = Color.white;
                            mixColorTo = Color.white;

                            hitSound = Sounds.plasmaboom;

                            shootCone = 180f;
                            ejectEffect = Fx.none;
                            hitShake = 4f;

                            collidesAir = false;

                            lifetime = 70f;

                            despawnEffect = Fx.greenBomb;
                            hitEffect = Fx.massiveExplosion;
                            keepVelocity = false;
                            spin = 2f;

                            shrinkX = shrinkY = 0.7f;

                            speed = 0f;
                            collides = false;

                            healPercent = 15f;
                            splashDamage = 230f;
                            splashDamageRadius = 80f;
                        }};
                    }});
        }};

        CTRUnitType 要塞 = new CTRUnitType("oct", "oct") {{
            aiController = DefenderAI::new;
            armor = 16f;
            health = 24000;
            speed = 0.8f;
            rotateSpeed = 1f;
            accel = 0.04f;
            drag = 0.018f;
            flying = true;
            engineOffset = 46f;
            engineSize = 7.8f;
            faceTarget = false;
            hitSize = 66f;
            payloadCapacity = (5.5f * 5.5f) * tilePayload;

            drawShields = false;
            lowAltitude = true;

            ammoCapacity = 1;
            weapons.add(
                    new Weapon() {{
                        x = y = 0f;
                        mirror = false;
                        reload = 55f;
                        minShootVelocity = 0.01f;
                        autoTarget = true;//被动开火
                        soundPitchMin = 1f;
                        shootSound = Sounds.plasmadrop;
                        bullet = new BasicBulletType() {{
                            sprite = "large-bomb";
                            width = height = 120 / 4f;
                            maxRange = 30f;
                            ignoreRotation = true;
                            backColor = Pal.heal;
                            frontColor = Color.white;
                            mixColorTo = Color.white;
                            hitSound = Sounds.plasmaboom;
                            shootCone = 180f;
                            ejectEffect = Fx.none;
                            hitShake = 4f;
                            collidesAir = false;
                            lifetime = 70f;
                            hitEffect = Fx.massiveExplosion;
                            keepVelocity = false;
                            spin = 2f;
                            shrinkX = shrinkY = 0.7f;
                            speed = 0f;
                            collides = false;
                            healPercent = 15f;
                            splashDamage = 350f;
                            splashDamageRadius = 80f;
                        }};
                    }});

            abilities.add(new ForceFieldAbility(26 * 8f, 1000 / 60f, 70000f, 60f * 8, 12, 30f), new RepairFieldAbility(5000f, 60f * 2, 140f));
        }};

        //endregion
        //region naval attack
        //黄船
        CTRUnitType 梭鱼 = new CTRUnitType("risso", "risso") {{
            speed = 1.5f;
            drag = 0.13f;
            hitSize = 10f;
            health = 280;
            accel = 0.4f;
            rotateSpeed = 3.3f;
            faceTarget = false;

            armor = 7f;

            weapons.add(new Weapon("mount-weapon") {{
                reload = 13f;
                x = 4f;
                shootY = 4f;
                y = 1.5f;
                rotate = true;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(2.5f, 16) {{
                    width = 7f;
                    height = 9f;
                    lifetime = 60f;
                    ammoMultiplier = 2;
                }};
            }});

            weapons.add(new Weapon("missiles-mount") {{
                mirror = false;
                reload = 25f;
                x = 0f;
                y = -5f;
                rotate = true;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.missile;
                bullet = new MissileBulletType(2.7f, 18, "missile") {{
                    keepVelocity = true;
                    width = 8f;
                    height = 8f;
                    shrinkY = 0f;
                    drag = -0.003f;
                    homingRange = 60f;
                    splashDamageRadius = 25f;
                    splashDamage = 10f;
                    lifetime = 65f;
                    trailColor = Color.gray;
                    backColor = Pal.bulletYellowBack;
                    frontColor = Pal.bulletYellow;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                    weaveScale = 8f;
                    weaveMag = 2f;
                }};
            }});
        }};

        CTRUnitType 飞鲨 = new CTRUnitType("minke", "minke") {{
            health = 600;
            speed = 1.1f;
            drag = 0.15f;
            hitSize = 13f;
            armor = 16f;
            accel = 0.3f;
            rotateSpeed = 2.6f;
            faceTarget = false;
            ammoType = new ItemAmmoType(Items.graphite);

            trailLength = 20;
            waveTrailX = 5.5f;
            waveTrailY = -4f;
            trailScl = 1.9f;

            weapons.add(new Weapon("mount-weapon") {{
                reload = 10f;
                x = 5f;
                y = 3.5f;
                rotate = true;
                rotateSpeed = 5f;
                inaccuracy = 8f;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.shoot;
                bullet = new FlakBulletType(4.2f, 7) {{
                    lifetime = 75f;
                    ammoMultiplier = 4f;
                    shootEffect = Fx.shootSmall;
                    width = 12f;
                    height = 9f;
                    hitEffect = Fx.flakExplosion;
                    splashDamage = 27f * 2f;
                    splashDamageRadius = 15f;
                }};
            }});

            weapons.add(new Weapon("artillery-mount") {{
                reload = 30f;
                x = 5f;
                y = -5f;
                rotate = true;
                inaccuracy = 2f;
                rotateSpeed = 2f;
                shake = 1.5f;
                ejectEffect = Fx.casing2;
                shootSound = Sounds.bang;
                bullet = new ArtilleryBulletType(3f, 35, "shell") {{
                    hitEffect = Fx.flakExplosion;
                    knockback = 0.8f;
                    lifetime = 100f;
                    width = height = 17f;
                    collidesTiles = false;
                    splashDamageRadius = 30f * 0.75f;
                    splashDamage = 40f;
                }};
            }});
        }};

        CTRUnitType 戟鲸 = new CTRUnitType("bryde", "bryde") {{
            health = 910;
            speed = 0.92f;
            accel = 0.2f;
            rotateSpeed = 1.8f;
            drag = 0.17f;
            hitSize = 20f;
            armor = 18f;
            faceTarget = false;
            ammoType = new ItemAmmoType(Items.graphite);

            trailLength = 22;
            waveTrailX = 7f;
            waveTrailY = -9f;
            trailScl = 1.5f;

            //abilities.add(new ForceFieldAbility(60f, 0.4f, 1600f, 60f * 6));
            abilities.add(new ShieldRegenFieldAbility(20f, 40f, 60f * 4, 60f));

            weapons.add(new Weapon("large-artillery") {{
                reload = 65f;
                mirror = false;
                x = 0f;
                y = -3.5f;
                rotateSpeed = 1.7f;
                rotate = true;
                shootY = 7f;
                shake = 5f;
                recoil = 4f;
                shadow = 12f;
                inaccuracy = 7f;
                ejectEffect = Fx.casing3;
                shootSound = Sounds.artillery;
                bullet = new ArtilleryBulletType(3.2f, 35) {{
                    trailMult = 0.8f;
                    hitEffect = Fx.massiveExplosion;
                    knockback = 1.5f;
                    lifetime = 100f;
                    height = 15.5f;
                    width = 15f;
                    collidesTiles = false;
                    splashDamageRadius = 40f;
                    splashDamage = 80f;
                    backColor = Pal.missileYellowBack;
                    frontColor = Pal.missileYellow;
                    trailEffect = Fx.artilleryTrail;
                    trailSize = 6f;
                    hitShake = 4f;
                    shootEffect = Fx.shootBig2;
                    status = blasted;
                    statusDuration = 60f;
                }};
            }});

            weapons.add(new Weapon("missiles-mount") {{
                reload = 20f;
                x = 8.5f;
                y = -9f;
                shadow = 6f;
                rotateSpeed = 4f;
                rotate = true;
                shoot.shots = 2;
                shoot.shotDelay = 3f;
                inaccuracy = 5f;
                velocityRnd = 0.1f;
                shootSound = Sounds.missile;
                ammoType = new ItemAmmoType(Items.thorium);
                ejectEffect = Fx.none;
                bullet = new MissileBulletType(2.7f, 32) {{
                    width = 12f;
                    height = 12f;
                    shrinkY = 0f;
                    drag = -0.003f;
                    homingRange = 60f;
                    keepVelocity = false;
                    splashDamageRadius = 25f;
                    splashDamage = 10f;
                    lifetime = 90f;
                    trailColor = Color.gray;
                    backColor = Pal.bulletYellowBack;
                    frontColor = Pal.bulletYellow;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                    weaveScale = 8f;
                    weaveMag = 1f;
                }};
            }});
        }};

        CTRUnitType 蛟龙 = new CTRUnitType("sei", "sei") {{
            health = 11000;
            armor = 30f;
            speed = 0.73f;
            drag = 0.17f;
            hitSize = 39f;
            accel = 0.2f;
            rotateSpeed = 1.3f;
            faceTarget = false;
            ammoType = new ItemAmmoType(Items.thorium);
            trailLength = 50;
            waveTrailX = 18f;
            waveTrailY = -21f;
            trailScl = 3f;
            abilities.add(new ShieldArcAbility() {{
                region = "tecta-shield";
                radius = 45f;
                angle = 82f;
                regen = 0.6f;
                cooldown = 60f * 8f;
                max = 7000f;
                y = -20f;
                width = 10f;
            }});
            weapons.add(new Weapon("sei-launcher") {{

                x = 0f;
                y = 0f;
                rotate = true;
                rotateSpeed = 4f;
                mirror = false;

                shadow = 20f;

                shootY = 4.5f;
                recoil = 4f;
                reload = 45f;
                velocityRnd = 0.4f;
                inaccuracy = 7f;
                ejectEffect = Fx.none;
                shake = 1f;
                shootSound = Sounds.missile;
                float spawnTime = 60f * 8f;
                abilities.add(new UnitSpawnAbility(星辉, spawnTime, 19.25f, -31.75f), new UnitSpawnAbility(星辉, spawnTime, -19.25f, -31.75f));
                shoot = new ShootAlternate() {{
                    shots = 6;
                    shotDelay = 1.5f;
                    spread = 4f;
                    barrels = 3;
                }};

                bullet = new MissileBulletType(4.2f, 42) {{
                    homingPower = 0.12f;
                    width = 8f;
                    height = 8f;
                    shrinkX = shrinkY = 0f;
                    drag = -0.003f;
                    homingRange = 80f;
                    keepVelocity = false;
                    splashDamageRadius = 35f;
                    splashDamage = 45f;
                    lifetime = 80f;
                    trailColor = Pal.bulletYellowBack;
                    backColor = Pal.bulletYellowBack;
                    frontColor = Pal.bulletYellow;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                    weaveScale = 8f;
                    weaveMag = 2f;
                }};
            }});

            weapons.add(new Weapon("large-bullet-mount") {{
                reload = 60f;
                cooldownTime = 90f;
                x = 70f / 4f;
                y = -66f / 4f;
                rotateSpeed = 4f;
                rotate = true;
                shootY = 7f;
                shake = 2f;
                recoil = 3f;
                shadow = 12f;
                ejectEffect = Fx.casing3;
                shootSound = Sounds.shootBig;

                shoot.shots = 3;
                shoot.shotDelay = 4f;
                inaccuracy = 1f;
                bullet = new BasicBulletType(7f, 57) {{
                    width = 13f;
                    height = 19f;
                    shootEffect = Fx.shootBig;
                    lifetime = 45f;
                }};
            }});
        }};

        CTRUnitType 海神 = new CTRUnitType("omura", "omura") {{
            health = 22000;
            speed = 0.68f;
            drag = 0.18f;
            hitSize = 58f;
            armor = 35f;
            accel = 0.19f;
            rotateSpeed = 0.9f;
            faceTarget = false;
            ammoType = new PowerAmmoType(4000);

            float spawnTime = 60f * 4f;

            abilities.add(new UnitSpawnAbility(天垠, spawnTime, 19.25f, -31.75f), new UnitSpawnAbility(天垠, spawnTime, -19.25f, -31.75f));

            trailLength = 70;
            waveTrailX = 23f;
            waveTrailY = -32f;
            trailScl = 3.5f;
            weapons.add(new Weapon() {{ //狙击定点
                shootSound = Sounds.shockBlast;
                rotate = true;
                rotateSpeed = 2f;
                x = 0f;
                y = 0f;
                shootY = 0f;
                reload = 180f;
                mirror = false;
                shoot = new ShootSpread(2, 8f);
                shake = 3f;
                bullet = new PointBulletType() {{
                    shootEffect = Fx.instShoot;
                    hitEffect = Fx.instHit;
                    smokeEffect = Fx.smokeCloud;
                    trailEffect = Fx.instTrail;
                    despawnEffect = new Effect(55f, 100f, e -> {
                        color(Pal.orangeSpark);
                        stroke(e.fout() * 4f);
                        Lines.circle(e.x, e.y, 4f + e.finpow() * 20f);

                        for (int i = 0; i < 4; i++) {
                            Drawf.tri(e.x, e.y, 6f, 1.5f * 80f * e.fout(), i * 90 + 45);
                        }

                        color();
                        for (int i = 0; i < 4; i++) {
                            Drawf.tri(e.x, e.y, 3f, 1.5f * 30f * e.fout(), i * 90 + 45);
                        }

                        Drawf.light(e.x, e.y, 200f, Pal.orangeSpark, 0.9f * e.fout());
                    });
                    trailSpacing = 20f;
                    damage = 1350;
                    buildingDamageMultiplier = 0.2f;
                    speed = 7;
                    hitShake = 6f;
                    ammoMultiplier = 1f;
                    fragBullets = 5;
                    //despawnSound = CreatorsSound.loadSound("none");//Sounds.plasmaboom
                    fragBullet = new PointBulletType() {
                        {
                            //despawnSound = CreatorsSound.loadSound("none");//自定义音效
                            collidesAir = true;
                            trailEffect = Fx.none;
                            splashDamageRadius = 32;
                            splashDamage = 350;
                            buildingDamageMultiplier = 0.1f;
                            hitEffect = Fx.none;
                            despawnEffect = new MultiEffect(
                                    new Effect(130, e -> {
                                        color(Pal.orangeSpark);
                                        e.scaled(30, i -> {
                                            Lines.stroke(3 * i.fout());
                                            Lines.circle(e.x, e.y, 3 + i.fin() * 15);
                                        });
                                    }));
                            lifetime = 12;
                            speed = 8;
                        }
                    };
                }};
            }});
            weapons.add(new Weapon("omura-cannon") {{//狙击穿透
                reload = 110f;
                cooldownTime = 90f;
                mirror = false;
                x = 0f;
                y = -3.5f;
                rotateSpeed = 1.4f;
                rotate = true;
                shootY = 23f;
                shake = 6f;
                recoil = 10.5f;
                shadow = 50f;
                shootSound = Sounds.railgun;

                ejectEffect = Fx.none;

                bullet = new RailBulletType() {
                    {
                        scaleLife = true;
                        shootEffect = Fx.railShoot;
                        length = 500;
                        pointEffectSpace = 60f;
                        pierceEffect = Fx.railHit;
                        pointEffect = Fx.railTrail;
                        hitEffect = Fx.massiveExplosion;
                        smokeEffect = Fx.shootBig2;
                        damage = 1250;
                        pierceDamageFactor = 0.1f;
                    }
                };
            }});


        }};




/*
        renale1 = new CTR1UnitType("renale", "renale") {{
            health = 500;
            armor = 2;
            hitSize = 9f;
            omniMovement = false;
            rotateSpeed = 2.5f;
            drownTimeMultiplier = 2f;
            segments = 3;
            drawBody = false;
            hidden = false;
            crushDamage = 0.5f;
            aiController = HugAI::new;
            targetAir = false;

            segmentScl = 3f;
            segmentPhase = 5f;
            segmentMag = 0.5f;
            speed = 1.2f;
        }};

        latum1 = new CTR1UnitType("latum", "latum") {{
            health = 20000;
            armor = 12;
            hitSize = 48f;
            omniMovement = false;
            rotateSpeed = 1.7f;
            drownTimeMultiplier = 4f;
            segments = 4;
            drawBody = false;
            hidden = false;
            crushDamage = 2f;
            aiController = HugAI::new;
            targetAir = false;

            segmentScl = 4f;
            segmentPhase = 5f;
            speed = 1f;

            abilities.add(new SpawnDeathAbility(renale1, 5, 11f));
        }};*/

    }

    //坦克


}
