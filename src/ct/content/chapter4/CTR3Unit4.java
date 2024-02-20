package ct.content.chapter4;

import arc.Core;
import arc.graphics.Blending;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Interp;
import arc.math.Mathf;
import arc.math.geom.Rect;
import arc.math.geom.Vec2;
import arc.util.Time;
import ct.Asystem.type.CT3UnitType.CTRErekirUnitType;
import ct.Asystem.type.CT3UnitType.CTRTankUnitType;
import ct.Asystem.type.CT3UnitType.CTRUnitType;
import mindustry.ai.UnitCommand;
import mindustry.ai.types.CargoAI;
import mindustry.ai.types.FlyingFollowAI;
import mindustry.ai.types.MinerAI;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.Effect;
import mindustry.entities.Units;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.ExplosionEffect;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.effect.WrapEffect;
import mindustry.entities.part.FlarePart;
import mindustry.entities.part.HoverPart;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootHelix;
import mindustry.entities.pattern.ShootPattern;
import mindustry.entities.pattern.ShootSpread;
import mindustry.game.Team;
import mindustry.gen.Sounds;
import mindustry.gen.Unit;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.StatusEffect;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.type.ammo.PowerAmmoType;
import mindustry.type.unit.MissileUnitType;
import mindustry.type.weapons.PointDefenseWeapon;
import mindustry.type.weapons.RepairBeamWeapon;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.lineAngle;
import static arc.graphics.g2d.Lines.stroke;
import static arc.math.Angles.randLenVectors;
import static mindustry.Vars.tilePayload;
import static mindustry.content.Fx.*;
import static mindustry.content.StatusEffects.burning;
import static mindustry.content.StatusEffects.electrified;
import static mindustry.content.StatusEffects.sapped;
import static mindustry.content.StatusEffects.*;

public class CTR3Unit4 {

    public static UnitType kuangji1, kuangji2, kuangji3;
    public static UnitType 运输1, 运输2, 运输3;
    public static UnitType 海辅1, 海辅2, 海辅3, 海辅4, 海辅5;
    public static UnitType 坦克1, 坦克2, 坦克3, 坦克4, 坦克5;
    public static UnitType 蜘蛛1, 蜘蛛2, 蜘蛛3, 蜘蛛4, 蜘蛛5;
    public static UnitType 空军1, 空军2, 空军3, 空军4, 空军5;
    public static UnitType T2盾牌单位, T3盾牌单位, T4盾牌单位, T5盾牌单位;

    public static void load() {


        kuangji1 = new CTRUnitType("elf", "mono") {{
            controller = u -> new MinerAI();
            logicControllable = false;//逻辑控制
            defaultCommand = UnitCommand.mineCommand;
            flying = true;
            hitSize = 3f;
            drag = 0.06f;
            accel = 0.12f;
            speed = 1.5f;
            health = 90;
            engineSize = 1.8f;
            engineOffset = 3.5f;
            range = 50f;
            outlines = isEnemy = drawItems = false;
            abilities.add(new RepairFieldAbility(-1, 1 * 60, 0.1f * 8) {{
                healEffect = Fx.none;
                activeEffect = Fx.none;
                parentizeEffects = true;
            }});

         /*   muddy = new StatusEffect("muddy") {
                {
                    this.color = Color.valueOf("46382a");
                    this.speedMultiplier = 0.94F;
                    this.effect = Fx.muddy;
                    this.effectChance = 0.09F;
                    this.show = false;
                }
            };
            */
            mineTier = 1;
            mineSpeed = 2.5f;
            canAttack = false;
        }};
        kuangji2 = new CTRUnitType("elf2", "mono") {{
            controller = u -> new MinerAI();
            logicControllable = false;//逻辑控制
            defaultCommand = UnitCommand.mineCommand;
            flying = true;
            hitSize = 8f;
            drag = 0.06f;
            accel = 0.12f;
            speed = 1.5f;
            health = 100;
            engineSize = 1.8f;
            engineOffset = 3.5f;
            range = 50f;
            isEnemy = false;//不是敌人
            outlines = false;
            mineTier = 1;
            mineSpeed = 2.5f;
            canAttack = false;
        }};
        运输1 = new CTRErekirUnitType("黄萤火", "manifold") {{
            controller = u -> new CargoAI();
            isEnemy = false;
            allowedInPayloads = false;
            logicControllable = false;//逻辑控制
            playerControllable = false;
            envDisabled = 0;
            payloadCapacity = 0f;
            useUnitCap = false;//忽略单位上限限制
            lowAltitude = false;
            flying = true;
            outlines = false;
            drag = 0.06f;
            speed = 3f;
            rotateSpeed = 9f;//身体旋转速度
            accel = 0.1f;//加速度
            itemCapacity = 250;
            health = 200f;
            hitSize = 2f;
            abilities.add(
                    new MoveEffectAbility(0f, -7f, Pal.sapBulletBack, Fx.missileTrailShort, 4f) {{
                        teamColor = false;
                    }});

            // engineSize = 2.3f;
            // engineOffset = 6.5f;
            hidden = false;

  /*          setEnginesMirror(
                    new UnitEngine(24 / 4f, -24 / 4f, 2.3f, 315f)
            );*/
        }};
        运输2 = new CTRErekirUnitType("蓝萤火", "manifold") {{
            controller = u -> new CargoAI();
            isEnemy = false;
            allowedInPayloads = false;
            logicControllable = false;
            playerControllable = false;
            envDisabled = 0;
            payloadCapacity = 0f;
            useUnitCap = false;
            outlines = false;
            lowAltitude = false;
            flying = true;
            drag = 0.06f;
            speed = 3f;
            rotateSpeed = 9f;//身体旋转速度
            accel = 0.1f;//加速度
            itemCapacity = 600;
            health = 600f;
            hitSize = 2f;
            // engineSize = 2.3f;
            // engineOffset = 6.5f;
            hidden = false;

  /*          setEnginesMirror(
                    new UnitEngine(24 / 4f, -24 / 4f, 2.3f, 315f)
            );*/
        }};
        运输3 = new CTRErekirUnitType("绿萤火", "manifold") {{
            controller = u -> new CargoAI();
            isEnemy = false;
            allowedInPayloads = false;
            logicControllable = false;
            playerControllable = false;
            envDisabled = 0;
            outlines = false;
            payloadCapacity = 0f;
            useUnitCap = false;
            lowAltitude = false;
            flying = true;
            drag = 0.06f;
            speed = 3f;
            rotateSpeed = 9f;//身体旋转速度
            accel = 0.1f;//加速度
            itemCapacity = 1000;
            health = 200f;
            hitSize = 2f;
            engineSize = 2.3f;
            engineOffset = 6.5f;
            hidden = false;

  /*          setEnginesMirror(
                    new UnitEngine(24 / 4f, -24 / 4f, 2.3f, 315f)
            );*/
        }};
//绿色辅助船

        Color 绿色 = Pal.heal;//Color.valueOf("31de6d");
        Color 浅绿色 = Color.valueOf("b7fdcf");
        海辅1 = new CTRUnitType("retusa", "retusa") {{
            isEnemy = false;
            speed = 0.9f;
            targetAir = false;
            drag = 0.14f;
            hitSize = 11f;
            health = 270 + 80;
            accel = 0.4f;
            rotateSpeed = 5f;
            trailLength = 20;
            waveTrailX = 5f;
            trailScl = 1.3f;
            faceTarget = false;
            range = 100f;
            ammoType = new PowerAmmoType(900);
            armor = 5f;
            useUnitCap = false;
            buildSpeed = 1.5f;
            logicControllable = false;//逻辑控制
            weapons.add(new RepairBeamWeapon("repair-beam-weapon-center") {{
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

            weapons.add(new Weapon() {{
                mirror = false;
                rotate = true;
                reload = 90f;
                x = y = shootX = shootY = 0f;
                shootSound = Sounds.mineDeploy;
                rotateSpeed = 180f;
                targetAir = false;

                shoot.shots = 3;
                shoot.shotDelay = 7f;

                bullet = new BasicBulletType() {{
                    sprite = "mine-bullet";
                    width = height = 8f;
                    layer = Layer.scorch;
                    shootEffect = smokeEffect = Fx.none;

                    maxRange = 50f;
                    ignoreRotation = true;
                    healPercent = 4f;

                    backColor = Pal.heal;
                    frontColor = Color.white;
                    mixColorTo = Color.white;

                    hitSound = Sounds.plasmaboom;

                    ejectEffect = Fx.none;
                    hitSize = 22f;

                    collidesAir = false;

                    lifetime = 87f;

                    hitEffect = new MultiEffect(Fx.blastExplosion, Fx.greenCloud);
                    keepVelocity = false;

                    shrinkX = shrinkY = 0f;

                    inaccuracy = 2f;
                    weaveMag = 5f;
                    weaveScale = 4f;
                    speed = 0.7f;
                    drag = -0.017f;
                    homingPower = 0.05f;
                    collideFloor = true;
                    trailColor = Pal.heal;
                    trailWidth = 3f;
                    trailLength = 8;

                    splashDamage = 33f;
                    splashDamageRadius = 32f;
                }};
            }});
        }};

        海辅2 = new CTRUnitType("oxynoe", "oxynoe") {{
            health = 560 + 200;
            speed = 0.83f;
            drag = 0.14f;
            hitSize = 14f;
            armor = 7f;
            accel = 0.4f;
            rotateSpeed = 4f;
            faceTarget = false;
            useUnitCap = false;
            trailLength = 22;
            waveTrailX = 5.5f;
            waveTrailY = -4f;
            trailScl = 1.9f;
            ammoType = new ItemAmmoType(Items.coal);
            logicControllable = false;//逻辑控制
            abilities.add(new StatusFieldAbility(overclock, 60f * 6, 60f * 6f, 60f));
            abilities.add(new ForceFieldAbility(60f, 0.4f, 1200f, 60f * 6));
            buildSpeed = 2f;
            isEnemy = false;
            weapons.add(new Weapon("plasma-mount-weapon") {{

                reload = 5f;
                x = 4.5f;
                y = 6.5f;
                rotate = true;
                rotateSpeed = 5f;
                inaccuracy = 10f;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.flame;
                shootCone = 30f;

                bullet = new BulletType(3.4f, 23f) {{
                    healPercent = 1.5f;
                    collidesTeam = true;
                    ammoMultiplier = 3f;
                    hitSize = 7f;
                    lifetime = 60f;
                    pierce = true;
                    collidesAir = false;
                    statusDuration = 60f * 4;
                    hitEffect = Fx.hitFlamePlasma;
                    ejectEffect = Fx.none;
                    despawnEffect = Fx.none;
                    status = burning;
                    keepVelocity = false;
                    hittable = false;
                    shootEffect = new Effect(32f, 80f, e -> {
                        color(Color.white, Pal.heal, Color.gray, e.fin());

                        randLenVectors(e.id, 40, e.finpow() * 220f, e.rotation, 8f, (x, y) -> {
                            Fill.circle(e.x + x, e.y + y, 0.65f + e.fout() * 1.5f);
                            Drawf.light(e.x + x, e.y + y, 16f * e.fout(), Pal.heal, 0.6f);
                        });
                    });
                }};
            }});

            weapons.add(new PointDefenseWeapon("point-defense-mount") {{
                mirror = false;
                x = 0f;
                y = 1f;
                reload = 9f;
                targetInterval = 10f;
                targetSwitchInterval = 15f;

                bullet = new BulletType() {{
                    shootEffect = Fx.sparkShoot;
                    hitEffect = Fx.pointHit;
                    maxRange = 100f;
                    damage = 17f;
                }};
            }});

        }};

        海辅3 = new CTRUnitType("cyerce", "cyerce") {{
            health = 870 + 500;
            speed = 0.86f;
            accel = 0.22f;
            rotateSpeed = 2.6f;
            drag = 0.16f;
            hitSize = 20f;
            armor = 9f;
            faceTarget = false;
            ammoType = new ItemAmmoType(Items.graphite);
            useUnitCap = false;
            trailLength = 23;
            waveTrailX = 9f;
            waveTrailY = -9f;
            trailScl = 2f;
            logicControllable = false;//逻辑控制
            buildSpeed = 2f;
            isEnemy = false;
            weapons.add(new RepairBeamWeapon("repair-beam-weapon-center") {{
                x = 11f;
                y = -10f;
                shootY = 6f;
                beamWidth = 0.8f;
                repairSpeed = 0.7f;

                bullet = new BulletType() {{
                    maxRange = 130f;
                }};
            }});
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
                shootCone = 90;
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
            weapons.add(new Weapon("plasma-missile-mount") {{
                reload = 60f;
                x = 9f;
                y = 3f;

                shadow = 5f;

                rotateSpeed = 4f;
                rotate = true;
                inaccuracy = 1f;
                velocityRnd = 0.1f;
                shootSound = Sounds.missile;

                ejectEffect = Fx.none;
                bullet = new FlakBulletType(2.5f, 25) {{
                    sprite = "missile-large";
                    //for targeting
                    scaleLife = true;//开启指哪打哪
                    collidesGround = collidesAir = true;
                    explodeRange = 40f;
                    width = height = 12f;
                    shrinkY = 0f;
                    drag = -0.003f;
                    homingRange = 60f;
                    keepVelocity = false;
                    lightRadius = 60f;
                    lightOpacity = 0.7f;
                    lightColor = Pal.heal;

                    splashDamageRadius = 30f;
                    splashDamage = 25f;

                    lifetime = 80f;
                    backColor = Pal.heal;
                    frontColor = Color.white;

                    hitEffect = new ExplosionEffect() {{
                        lifetime = 28f;
                        waveStroke = 6f;
                        waveLife = 10f;
                        waveRadBase = 7f;
                        waveColor = Pal.heal;
                        waveRad = 30f;
                        smokes = 6;
                        smokeColor = Color.white;
                        sparkColor = Pal.heal;
                        sparks = 6;
                        sparkRad = 35f;
                        sparkStroke = 1.5f;
                        sparkLen = 4f;
                    }};

                    weaveScale = 8f;
                    weaveMag = 1f;

                    trailColor = Pal.heal;
                    trailWidth = 4.5f;
                    trailLength = 29;

                    fragBullets = 7;
                    fragVelocityMin = 0.3f;

                    fragBullet = new MissileBulletType(3.9f, 11) {{
                        homingPower = 0.2f;
                        weaveMag = 4;
                        weaveScale = 4;
                        lifetime = 60f;
                        keepVelocity = false;
                        shootEffect = Fx.shootHeal;
                        smokeEffect = Fx.hitLaser;
                        splashDamage = 13f;
                        splashDamageRadius = 20f;
                        frontColor = Color.white;
                        hitSound = Sounds.none;

                        lightColor = Pal.heal;
                        lightRadius = 40f;
                        lightOpacity = 0.7f;

                        trailColor = Pal.heal;
                        trailWidth = 2.5f;
                        trailLength = 20;
                        trailChance = -1f;

                        healPercent = 2.8f;
                        collidesTeam = true;
                        backColor = Pal.heal;

                        despawnEffect = Fx.none;
                        hitEffect = new ExplosionEffect() {{
                            lifetime = 20f;
                            waveStroke = 2f;
                            waveColor = Pal.heal;
                            waveRad = 12f;
                            smokeSize = 0f;
                            smokeSizeBase = 0f;
                            sparkColor = Pal.heal;
                            sparks = 9;
                            sparkRad = 35f;
                            sparkLen = 4f;
                            sparkStroke = 1.5f;
                        }};
                    }};
                }};
            }});
        }};

        海辅4 = new CTRUnitType("aegires", "aegires") {{
            health = 12000 + 3000;
            armor = 12f;
            useUnitCap = false;
            speed = 0.7f;
            drag = 0.17f;
            hitSize = 44f;
            accel = 0.2f;
            rotateSpeed = 1.4f;
            faceTarget = false;
            ammoType = new PowerAmmoType(3500);
            ammoCapacity = 40;
            logicControllable = false;//逻辑控制
            isEnemy = false;
            //助推飞行
            boostMultiplier = 0.5f;
            engineOffset = 30f;
            engineSize = 12f;
            lowAltitude = true;
            riseSpeed = 0.02f;
            canBoost = true; //助推飞行
            setEnginesMirror(
                    new UnitEngine(21f, 0f, 5f, 315f),
                    new UnitEngine(20f, -20f, 7f, 315f)
            );
            engineColor = Color.valueOf("89f08e");
            singleTarget = false;//所有武器是否攻击同一目标

            //clip size is massive due to energy field
            clipSize = 250f;

            trailLength = 50;
            waveTrailX = 18f;
            waveTrailY = -17f;
            trailScl = 3.2f;
            targetAir = true; //空
            buildSpeed = 2f;
            abilities.add(
                    new RepairFieldAbility(5000, 15f * 60, 15 * 8)//(amount, reload, range)给别单位(oct那种治疗)
                    {{
                        healEffect = new Effect(50, e -> {
                            Draw.color(Color.valueOf("8ffb92"));
                            Lines.stroke(e.fout() * 2);
                            Lines.circle(e.x, e.y, 5 + e.finpow() * 7);
                        });
                        activeEffect = new Effect(22, e -> {
                            Draw.color(Color.valueOf("8ffb92"));
                            Lines.stroke(e.fout() * 10);
                            Lines.circle(e.x, e.y, 4 + e.finpow() * e.rotation);
                        });
                        parentizeEffects = false;
                    }}
            );

            abilities.add(new EnergyFieldAbility(40f, 50f, 180f * 2.5f) {{
                statusDuration = 60f * 6f;
                maxTargets = 25;
            }});

            for (float mountY : new float[]{-18f, 14}) {
                weapons.add(new PointDefenseWeapon("point-defense-mount") {{
                    x = 12.5f;
                    y = mountY;
                    reload = 6f;
                    targetInterval = 8f;
                    targetSwitchInterval = 8f;
                    //  autoTarget = false;//被动开火
                    bullet = new BulletType() {{
                        shootEffect = Fx.sparkShoot;
                        hitEffect = Fx.pointHit;
                        maxRange = 180 * 5f;
                        damage = 60f;
                    }};
                }});
            }


            weapons.add(new Weapon("plasma-laser-mount") {{
                reload = 120f;
                x = 15f;
                y = 3.5f;
                rotate = true;
                rotateSpeed = 5f;
                inaccuracy = 3f;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.shoot;
                targetAir = true; //空
                bullet = new ArtilleryBulletType(3f, 80) {{
                    scaleLife = false;//指哪打哪
                    pierce = true;//穿透
                    lifetime = 200;
                    hitEffect = Fx.sapExplosion;
                    knockback = 0.8f;
                    width = height = 80;

                    spin = 60;//子弹旋转
                    collidesTiles = true;
                    // ollidess = true;
                    ammoMultiplier = 4;
                    splashDamageRadius = 80;
                    splashDamage = 75;
                    backColor = 绿色;
                    frontColor = 浅绿色;

                    smokeEffect = Fx.shootBigSmoke2;
                    hitShake = 10;

                    status = sapped;
                    statusDuration = 60 * 10;
                    intervalBullet = new LightningBulletType() {{
                        damage = 30;
                        collidesAir = false;
                        ammoMultiplier = 1f;
                        lightningColor = 绿色;
                        lightningLength = 5;
                        lightningLengthRand = 10;

                        //for visual stats only.
                        buildingDamageMultiplier = 0.25f;

                        lightningType = new BulletType(0.0001f, 15f) {{
                            lifetime = Fx.lightning.lifetime;
                            hitEffect = Fx.hitLancer;
                            despawnEffect = Fx.none;
                            status = StatusEffects.shocked;
                            statusDuration = 10f;
                            hittable = false;
                            lightColor = 绿色;
                            buildingDamageMultiplier = 0.25f;
                        }};
                    }};
                    //intervalRandomSpread = 20;
                    intervalBullets = 6;
                    intervalAngle = 180;
                    intervalSpread = 300;
                    bulletInterval = 4;
                    lightRadius = 40;
                    lightColor = 绿色;
                    lightOpacity = 0.6f;


                    lightningColor = 绿色;
                    lightningDamage = 21;
                    lightning = 8;
                    lightningLength = 2;
                    lightningLengthRand = 8;

                    // fragBullets = 5;//破片分裂数量
                    // homingRange = 320;//追踪范围
                    // homingPower = 3;//追踪

                }};
            }});


        }};

        海辅5 = new CTRUnitType("navanax", "navanax") {{
            // hovering = true;陆地飞行器接口
            isEnemy = false;
            useUnitCap = false;
            health = 20000;
            speed = 0.65f;
            drag = 0.17f;
            hitSize = 58f;
            armor = 16f;
            accel = 0.2f;
            rotateSpeed = 1.1f;
            faceTarget = false;
            ammoType = new PowerAmmoType(4500);
            logicControllable = false;//逻辑控制
            //助推飞行
            boostMultiplier = 0.5f;
            engineOffset = 40f;
            engineSize = 12f;
            lowAltitude = true;
            riseSpeed = 0.02f;
            canBoost = true; //助推飞行
            setEnginesMirror(
                    new UnitEngine(29f, 7f, 5f, 315f),
                    new UnitEngine(30f, -5f, 5f, 315f),
                    new UnitEngine(25f, -20f, 7f, 315f),
                    new UnitEngine(29f, -43f, 7f, 315f)
            );
            engineColor = 绿色;
            trailLength = 70;
            waveTrailX = 23f;
            waveTrailY = -32f;
            trailScl = 3.5f;

            buildSpeed = 3.5f;
            abilities.add(new MoveEffectAbility(0f, -7f, Pal.sapBulletBack, Fx.none, 4f) {{
                teamColor = true;//移动拖尾技能效果
            }});


     /*       abilities.add(new SuppressionFieldAbility(){{
                color=绿色;
                orbRadius = orbRad;
                particleSize = partRad;
                y = 70f;
                x=20;
                particles = parts;
            }});*/
            for (int i : Mathf.signs) {
                abilities.add(new SuppressionFieldAbility() {{
                    color = Color.valueOf("89f08e");
                    particleColor = Color.valueOf("b3f0b6");
                    layer = 100;
                    orbRadius = 2;
                    particleSize = 1;
                    x = 85f * i;
                    y = 42.5f;
                    particles = 4;
                    //visual only, the middle one does the actual suppressing
                    display = active = false;
                }});
            }
            ContinuousLaserBulletType ContinuousLaserBulletTypeBullet = new ContinuousLaserBulletType() {{
                layer = 110;
                maxRange = 90f;
                damage = 30f;
                length = 95 * 4f;
                hitEffect = hitMeltHeal;
                drawSize = 200f;
                lifetime = 155f;
                shake = 1f;
                shootEffect = shootHeal;
                smokeEffect = Fx.none;
                width = 4f;
                largeHit = false;
                incendChance = 0.03f;
                incendSpread = 5f;
                incendAmount = 1;
                healPercent = 0.4f;
                collidesTeam = true;
                colors = new Color[]{Pal.heal.cpy().a(.2f), Pal.heal.cpy().a(.5f), Pal.heal.cpy().mul(1.2f), Color.white};
            }};
            weapons.add(new Weapon("plasma-laser-mount") {{
                layerOffset = 62;//62,65都是半透明 幽灵炮塔？
                shadow = 20f;
                //  controllable = false;//是否玩家可以开火
                autoTarget = false;//被动开火
                mirror = false;
                shake = 3f;
                shootY = 7f;
                rotate = false;
                shootCone = 35;//射击角度
                x = 84f;
                y = 50;
                baseRotation = 10f;//射击倾斜角度
                targetInterval = 20f;
                targetSwitchInterval = 35f;

                rotateSpeed = 3.5f;
                reload = 170f;
                recoil = 1f;
                shootSound = Sounds.beam;
                continuous = true;
                cooldownTime = reload;
                immunities.add(burning);
                // shoot = new ShootSpread(3, 7);
                bullet = ContinuousLaserBulletTypeBullet;
            }});
            weapons.add(new Weapon("plasma-laser-mount") {{
                layerOffset = 62;
                shadow = 20f;
                //  controllable = false;//是否玩家可以开火
                autoTarget = false;//被动开火
                mirror = false;
                shake = 3f;
                shootY = 7f;
                rotate = false;
                shootCone = 35;//射击角度
                x = -84f;
                y = 50;
                baseRotation = -10f;//射击倾斜角度
                targetInterval = 20f;
                targetSwitchInterval = 35f;

                rotateSpeed = 3.5f;
                reload = 170f;
                recoil = 1f;
                shootSound = Sounds.beam;
                continuous = true;
                cooldownTime = reload;
                immunities.add(burning);
                // shoot = new ShootSpread(3, 7);
                bullet = ContinuousLaserBulletTypeBullet;
            }});
            for (int b : Mathf.signs) {
                weapons.add(new Weapon("plasma-laser-mount") {{
                    // layerOffset = 90;
                    shadow = 20f;
                    //  controllable = false;//是否玩家可以开火
                    autoTarget = false;//被动开火
                    mirror = false;
                    shake = 3f;
                    shootY = 7f;
                    rotate = false;
                    shootCone = 35;//射击角度
                    x = 21 * b;
                    y = 50 / 4f;
                    //baseRotation = 10f;//射击倾斜角度
                    targetInterval = 20f;
                    targetSwitchInterval = 35f;

                    rotateSpeed = 3.5f;
                    reload = 170f;
                    recoil = 1f;
                    shootSound = Sounds.beam;
                    continuous = true;
                    cooldownTime = reload;
                    immunities.add(burning);
                    // shoot = new ShootSpread(3, 7);
                    bullet = ContinuousLaserBulletTypeBullet;
                }});
            }
            ;
            weapons.add(
                    new Weapon("ct-disrupt-weapon2") {{
                        rotate = false;
                        shoot = new ShootSpread(25, 1.5f);
                        reload = 70f;
                        // shoot.shotDelay=15;
                        // shadow = 60f;
                        mirror = false;//镜像
                        y = 10;
                        x = 0;
                        recoil = 2f;
                        shootCone = 40f;
                        shootSound = Sounds.shootAltLong;

                        bullet = new BasicBulletType(10f, 32) {{
                            smokeEffect = new Effect(40f, e -> {
                                color(Color.white, Pal.heal, e.fin());

                                rand.setSeed(e.id);
                                for (int i = 0; i < 2; i++) {
                                    float rot = e.rotation + rand.range(30f);
                                    v.trns(rot, rand.random(e.finpow() * 35f));
                                    Fill.poly(e.x + v.x, e.y + v.y, 4, e.fout() * 3.8f + 0.2f, rand.random(360f));
                                }
                            });
                            knockback = 4f;
                            hitColor = backColor = trailColor = 绿色;
                            shootEffect = new Effect(11, e -> {
                                color(Pal.heal);
                                float w = 1.2f + 9 * e.fout();
                                Drawf.tri(e.x, e.y, w, 32f * e.fout(), e.rotation);
                                Drawf.tri(e.x, e.y, w, 3f * e.fout(), e.rotation + 180f);
                            });
                            hitEffect = despawnEffect = new Effect(14, e -> {
                                color(Color.white, Pal.heal, e.fin());

                                e.scaled(7f, s -> {
                                    stroke(0.5f + s.fout());
                                    Lines.circle(e.x, e.y, s.fin() * 5f);
                                });

                                stroke(0.5f + e.fout());

                                randLenVectors(e.id, 5, e.fin() * 15f, (x, y) -> {
                                    float ang = Mathf.angle(x, y);
                                    lineAngle(e.x + x, e.y + y, ang, e.fout() * 3 + 1f);
                                });

                                Drawf.light(e.x, e.y, 20f, Pal.heal, 0.6f * e.fout());
                            });
                            width = 5f;
                            height = 7f;
                            lifetime = 25f;
                            trailWidth = 6f;
                            trailLength = 3;
                            trailRotation = true;
                            trailInterval = 3f;
                            trailEffect = Fx.none;
                        }};
                    }},
                    new Weapon("emp-cannon-mount") {{
                        rotate = true;

                        x = 70f / 4f;
                        y = -26f / 4f;

                        reload = 65f;
                        shake = 3f;
                        rotateSpeed = 2f;
                        shadow = 30f;
                        shootY = 7f;
                        recoil = 4f;
                        cooldownTime = reload - 10f;
                        //TODO better sound
                        shootSound = Sounds.laser;

                        bullet = new EmpBulletType() {{
                            float rad = 150f;

                            radius = rad;
                            scaleLife = true;
                            lightOpacity = 0.7f;
                            unitDamageScl = 0.8f;
                            healPercent = 20f;
                            timeIncrease = 3f;
                            timeDuration = 60f * 20f;
                            powerDamageScl = 3f;
                            damage = 60;
                            hitColor = lightColor = Pal.heal;
                            lightRadius = 70 * 1.5f;
                            clipSize = 250f;
                            shootEffect = Fx.hitEmpSpark;
                            smokeEffect = Fx.shootBigSmoke2;
                            lifetime = 60f * 1.5f;
                            sprite = "circle-bullet";
                            backColor = Pal.heal;
                            frontColor = Color.white;
                            width = height = 12f;
                            shrinkY = 0f;
                            speed = 5f;
                            trailLength = 20;
                            trailWidth = 6f;
                            trailColor = Pal.heal;
                            trailInterval = 3f;
                            splashDamage = 170f;
                            splashDamageRadius = rad;
                            hitShake = 4f;
                            trailRotation = true;
                            status = electrified;
                            statusDuration = 30;//状态时间
                            hitSound = Sounds.plasmaboom;

                            trailEffect = new Effect(16f, e -> {
                                color(Pal.heal);
                                for (int s : Mathf.signs) {
                                    Drawf.tri(e.x, e.y, 4f, 30f * e.fslope(), e.rotation + 90f * s);
                                }
                            });

                            hitEffect = new Effect(50f, 100f, e -> {
                                e.scaled(7f, b -> {
                                    color(Pal.heal, b.fout());
                                    Fill.circle(e.x, e.y, rad);
                                });

                                color(Pal.heal);
                                stroke(e.fout() * 3f);
                                Lines.circle(e.x, e.y, rad);

                                int points = 10;
                                float offset = Mathf.randomSeed(e.id, 360f);
                                for (int i = 0; i < points; i++) {
                                    float angle = i * 360f / points + offset;
                                    //for(int s : Mathf.zeroOne){
                                    Drawf.tri(e.x + Angles.trnsx(angle, rad), e.y + Angles.trnsy(angle, rad), 6f, 50f * e.fout(), angle /*+ s * 180f*/);
                                    //}
                                }

                                Fill.circle(e.x, e.y, 12f * e.fout());
                                color();
                                Fill.circle(e.x, e.y, 6f * e.fout());
                                Drawf.light(e.x, e.y, rad * 1.6f, Pal.heal, e.fout());
                            });
                        }};
                    }});
        }};


        //region erekir - tank

        坦克1 = new CTRTankUnitType("stell", "stell") {{
            hitSize = 12f;
            treadPullOffset = 3;
            speed = 0.75f;
            rotateSpeed = 3.5f;
            health = 850;
            armor = 6f;
            itemCapacity = 0;
            treadRects = new Rect[]{new Rect(12 - 32f, 7 - 32f, 14, 51)};
            researchCostMultiplier = 0f;
            ammoType = new ItemAmmoType(Items.copper) {{
                range = 80f;
                ammoPerItem = 2;
            }};
            useUnitCap = false;
            logicControllable = false;//逻辑控制
            isEnemy = false;
            weapons.add(new Weapon("stell-weapon") {{
                layerOffset = 0.0001f;
                reload = 50f;
                shootY = 4.5f;
                recoil = 1f;
                rotate = true;
                rotateSpeed = 2.2f;
                mirror = false;
                x = 0f;
                y = -0.75f;
                heatColor = Color.valueOf("f9350f");
                cooldownTime = 30f;

                bullet = new BasicBulletType(4f, 40) {{
                    sprite = "missile-large";
                    smokeEffect = Fx.shootBigSmoke;
                    shootEffect = Fx.shootBigColor;
                    width = 5f;
                    height = 7f;
                    lifetime = 40f;
                    hitSize = 4f;
                    hitColor = backColor = trailColor = Color.valueOf("feb380");
                    frontColor = Color.white;
                    trailWidth = 1.7f;
                    trailLength = 5;
                    despawnEffect = hitEffect = Fx.hitBulletColor;
                }};
            }});
        }};

        坦克2 = new CTRTankUnitType("locus", "locus") {{
            useUnitCap = false;
            hitSize = 18f;
            treadPullOffset = 5;
            speed = 0.7f;
            rotateSpeed = 2.6f;
            health = 2100;
            armor = 8f;
            itemCapacity = 0;
            isEnemy = false;
            logicControllable = false;//逻辑控制
            treadRects = new Rect[]{new Rect(17 - 96f / 2f, 10 - 96f / 2f, 19, 76)};
            researchCostMultiplier = 0f;
            ammoType = new ItemAmmoType(Items.copper) {{
                range = 50f;
            }};
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
                    length = 160f;
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

                        Fx.rand.setSeed(e.id);
                        for (int i = 0; i < 7; i++) {
                            Fx.v.trns(e.rotation, Fx.rand.random(8f, v.dst(e.x, e.y) - 8f));
                            Lines.lineAngleCenter(e.x + Fx.v.x, e.y + Fx.v.y, e.rotation + e.finpow(), e.foutpowdown() * 20f * Fx.rand.random(0.5f, 1f) + 0.3f);
                        }

                        e.scaled(14f, b -> {
                            stroke(b.fout() * 1.5f);
                            color(e.color);
                            Lines.line(e.x, e.y, v.x, v.y);
                        });
                    });
                }};
            }});
        }};

        坦克3 = new CTRTankUnitType("precept", "precept") {{
            hitSize = 26f;
            treadPullOffset = 5;
            speed = 0.64f;
            rotateSpeed = 1.5f;
            health = 5000;
            armor = 11f;
            itemCapacity = 0;
            isEnemy = false;
            logicControllable = false;//逻辑控制
            treadRects = new Rect[]{new Rect(16 - 60f, 48 - 70f, 30, 75), new Rect(44 - 60f, 17 - 70f, 17, 60)};
            researchCostMultiplier = 0f;
            useUnitCap = false;
            weapons.add(new Weapon("precept-weapon") {{
                shootSound = Sounds.dullExplosion;
                layerOffset = 0.0001f;
                reload = 80f;
                shootY = 16f;
                recoil = 3f;
                rotate = true;
                rotateSpeed = 1.3f;
                mirror = false;
                shootCone = 2f;
                x = 0f;
                y = -1f;
                heatColor = Color.valueOf("f9350f");
                cooldownTime = 30f;
                bullet = new BasicBulletType(7f, 120) {{
                    sprite = "missile-large";
                    width = 7.5f;
                    height = 13f;
                    lifetime = 28f;
                    hitSize = 6f;
                    pierceCap = 2;
                    pierce = true;
                    pierceBuilding = true;
                    hitColor = backColor = trailColor = Color.valueOf("feb380");
                    frontColor = Color.white;
                    trailWidth = 2.8f;
                    trailLength = 8;
                    hitEffect = despawnEffect = Fx.blastExplosion;
                    shootEffect = Fx.shootTitan;
                    smokeEffect = Fx.shootSmokeTitan;
                    splashDamageRadius = 20f;
                    splashDamage = 50f;

                    trailEffect = Fx.hitSquaresColor;
                    trailRotation = true;
                    trailInterval = 3f;

                    fragBullets = 4;

                    fragBullet = new BasicBulletType(5f, 35) {{
                        sprite = "missile-large";
                        width = 5f;
                        height = 7f;
                        lifetime = 15f;
                        hitSize = 4f;
                        hitColor = backColor = trailColor = Color.valueOf("feb380");
                        frontColor = Color.white;
                        trailWidth = 1.7f;
                        trailLength = 3;
                        drag = 0.01f;
                        despawnEffect = hitEffect = Fx.hitBulletColor;
                    }};
                }};
            }});
        }};

        坦克4 = new CTRTankUnitType("vanquish", "vanquish") {{
            hitSize = 28f;
            treadPullOffset = 4;
            speed = 0.63f;
            health = 11000;
            armor = 20f;
            itemCapacity = 0;
            crushDamage = 13f / 5f;
            isEnemy = false;
            logicControllable = false;//逻辑控制
            treadRects = new Rect[]{new Rect(22 - 154f / 2f, 16 - 154f / 2f, 28, 130)};
            useUnitCap = false;
            weapons.add(new Weapon("vanquish-weapon") {{
                shootSound = Sounds.mediumCannon;
                layerOffset = 0.0001f;
                reload = 70f;
                shootY = 71f / 4f;
                shake = 5f;
                recoil = 4f;
                rotate = true;
                rotateSpeed = 1f;
                mirror = false;
                x = 0f;
                y = 0;
                shadow = 28f;
                heatColor = Color.valueOf("f9350f");
                cooldownTime = 80f;

                bullet = new BasicBulletType(8f, 190) {{
                    sprite = "missile-large";
                    width = 9.5f;
                    height = 13f;
                    lifetime = 18f;
                    hitSize = 6f;
                    shootEffect = Fx.shootTitan;
                    smokeEffect = Fx.shootSmokeTitan;
                    pierceCap = 2;
                    pierce = true;
                    pierceBuilding = true;
                    hitColor = backColor = trailColor = Color.valueOf("feb380");
                    frontColor = Color.white;
                    trailWidth = 3.1f;
                    trailLength = 8;
                    hitEffect = despawnEffect = Fx.blastExplosion;
                    splashDamageRadius = 20f;
                    splashDamage = 50f;

                    fragOnHit = false;
                    fragRandomSpread = 0f;
                    fragSpread = 10f;
                    fragBullets = 5;
                    fragVelocityMin = 1f;
                    despawnSound = Sounds.dullExplosion;

                    fragBullet = new BasicBulletType(8f, 35) {{
                        sprite = "missile-large";
                        width = 8f;
                        height = 12f;
                        lifetime = 15f;
                        hitSize = 4f;
                        hitColor = backColor = trailColor = Color.valueOf("feb380");
                        frontColor = Color.white;
                        trailWidth = 2.8f;
                        trailLength = 6;
                        hitEffect = despawnEffect = Fx.blastExplosion;
                        splashDamageRadius = 10f;
                        splashDamage = 20f;
                    }};
                }};
            }});

            int i = 0;
            for (float f : new float[]{34f / 4f, -36f / 4f}) {
                int fi = i++;
                weapons.add(new Weapon("vanquish-point-weapon") {{
                    reload = 35f + fi * 5;
                    x = 48f / 4f;
                    y = f;
                    shootY = 5.5f;
                    recoil = 2f;
                    rotate = true;
                    rotateSpeed = 2f;

                    bullet = new BasicBulletType(4.5f, 25) {{
                        width = 6.5f;
                        height = 11f;
                        shootEffect = Fx.sparkShoot;
                        smokeEffect = Fx.shootBigSmoke;
                        hitColor = backColor = trailColor = Color.valueOf("feb380");
                        frontColor = Color.white;
                        trailWidth = 1.5f;
                        trailLength = 4;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                    }};
                }});
            }
        }};

        坦克5 = new CTRTankUnitType("conquer", "conquer") {{
            hitSize = 46f;
            treadPullOffset = 1;
            speed = 0.48f;
            health = 22000;
            armor = 26f;
            crushDamage = 25f / 5f;
            rotateSpeed = 0.8f;
            useUnitCap = false;
            isEnemy = false;
            float xo = 231f / 2f, yo = 231f / 2f;
            treadRects = new Rect[]{new Rect(27 - xo, 152 - yo, 56, 73), new Rect(24 - xo, 51 - 9 - yo, 29, 17), new Rect(59 - xo, 18 - 9 - yo, 39, 19)};
            logicControllable = false;//逻辑控制
            weapons.add(new Weapon("conquer-weapon") {{
                shootSound = Sounds.largeCannon;
                layerOffset = 0.1f;
                reload = 110f;
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

                parts.addAll(
                        new RegionPart("-glow") {{
                            color = Color.red;
                            blending = Blending.additive;
                            outline = mirror = false;
                        }},
                        new RegionPart("-sides") {{
                            progress = PartProgress.warmup;
                            mirror = true;
                            under = true;
                            moveX = 0.75f;
                            moveY = 0.75f;
                            moveRot = 82f;
                            x = 37 / 4f;
                            y = 8 / 4f;
                        }},
                        new RegionPart("-sinks") {{
                            progress = PartProgress.warmup;
                            mirror = true;
                            under = true;
                            heatColor = new Color(1f, 0.1f, 0.1f);
                            moveX = 17f / 4f;
                            moveY = -15f / 4f;
                            x = 32 / 4f;
                            y = -34 / 4f;
                        }},
                        new RegionPart("-sinks-heat") {{
                            blending = Blending.additive;
                            progress = PartProgress.warmup;
                            mirror = true;
                            outline = false;
                            colorTo = new Color(1f, 0f, 0f, 0.5f);
                            color = colorTo.cpy().a(0f);
                            moveX = 17f / 4f;
                            moveY = -15f / 4f;
                            x = 32 / 4f;
                            y = -34 / 4f;
                        }}
                );

                for (int i = 1; i <= 3; i++) {
                    int fi = i;
                    parts.add(new RegionPart("-blade") {{
                        progress = PartProgress.warmup.delay((3 - fi) * 0.3f).blend(PartProgress.reload, 0.3f);
                        heatProgress = PartProgress.heat.add(0.3f).min(PartProgress.warmup);
                        heatColor = new Color(1f, 0.1f, 0.1f);
                        mirror = true;
                        under = true;
                        moveRot = -40f * fi;
                        moveX = 3f;
                        layerOffset = -0.002f;

                        x = 11 / 4f;
                    }});
                }

                bullet = new BasicBulletType(8f, 330f) {{
                    sprite = "missile-large";
                    width = 12f;
                    height = 20f;
                    lifetime = 35f;
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
                            spawnBullets.add(new BasicBulletType(spd * fin, 55) {{
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

                                splashDamage = 60f;
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

            parts.add(new RegionPart("-glow") {{
                color = Color.red;
                blending = Blending.additive;
                layer = -1f;
                outline = false;
            }});
        }};

        //endregion
        //region erekir - mech

        蜘蛛1 = new CTRErekirUnitType("merui", "merui") {{
            speed = 0.72f;
            drag = 0.11f;
            hitSize = 9f;
            rotateSpeed = 3f;
            health = 680;
            armor = 4f;
            legStraightness = 0.3f;
            stepShake = 0f;
            useUnitCap = false;
            isEnemy = false;
            legCount = 6;
            legLength = 8f;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -2f;
            legBaseOffset = 3f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 0.96f;
            legForwardScl = 1.1f;
            legGroupSize = 3;
            rippleScale = 0.2f;
            logicControllable = false;//逻辑控制
            legMoveSpace = 1f;
            allowLegStep = true;
            hovering = true;
            legPhysicsLayer = false;

            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;
            targetAir = false;
            researchCostMultiplier = 0f;

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
                    backColor = hitColor = Pal.techBlue;
                    frontColor = Color.white;

                    knockback = 0.8f;
                    lifetime = 50f;
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
                        colorFrom = colorTo = Pal.techBlue;
                        sizeTo = splashDamageRadius + 2f;
                        lifetime = 9f;
                        strokeFrom = 2f;
                    }});
                }};
            }});

        }};

        蜘蛛2 = new CTRErekirUnitType("cleroi", "cleroi") {{
            speed = 0.7f;
            drag = 0.1f;
            hitSize = 14f;
            rotateSpeed = 3f;
            health = 1100;
            armor = 5f;
            stepShake = 0f;
            useUnitCap = false;
            legCount = 4;
            legLength = 14f;
            lockLegBase = true;
            isEnemy = false;
            legContinuousMove = true;
            legExtension = -3f;
            legBaseOffset = 5f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 0.95f;
            legForwardScl = 0.7f;
            logicControllable = false;//逻辑控制
            legMoveSpace = 1f;
            hovering = true;

            shadowElevation = 0.2f;
            groundLayer = Layer.legUnit - 1f;

            for (int i = 0; i < 5; i++) {
                int fi = i;
                parts.add(new RegionPart("-spine") {{
                    y = 21f / 4f - 45f / 4f * fi / 4f;
                    moveX = 21f / 4f + Mathf.slope(fi / 4f) * 1.25f;
                    moveRot = 10f - fi * 14f;
                    float fin = fi / 4f;
                    progress = PartProgress.reload.inv().mul(1.3f).add(0.1f).sustain(fin * 0.34f, 0.14f, 0.14f);
                    layerOffset = -0.001f;
                    mirror = true;
                }});
            }

            weapons.add(new Weapon("cleroi-weapon") {{
                shootSound = Sounds.blaster;
                x = 14f / 4f;
                y = 33f / 4f;
                reload = 30f;
                layerOffset = -0.002f;
                alternate = false;
                heatColor = Color.red;
                cooldownTime = 25f;
                smoothReloadSpeed = 0.15f;
                recoil = 2f;

                bullet = new BasicBulletType(3.5f, 30) {{
                    backColor = trailColor = hitColor = Pal.techBlue;
                    frontColor = Color.white;
                    width = 7.5f;
                    height = 10f;
                    lifetime = 40f;
                    trailWidth = 2f;
                    trailLength = 4;
                    shake = 1f;

                    trailEffect = Fx.missileTrail;
                    trailParam = 1.8f;
                    trailInterval = 6f;

                    splashDamageRadius = 30f;
                    splashDamage = 43f;

                    hitEffect = despawnEffect = new MultiEffect(Fx.hitBulletColor, new WaveEffect() {{
                        colorFrom = colorTo = Pal.techBlue;
                        sizeTo = splashDamageRadius + 3f;
                        lifetime = 9f;
                        strokeFrom = 3f;
                    }});

                    shootEffect = new MultiEffect(Fx.shootBigColor, new Effect(9, e -> {
                        color(Color.white, e.color, e.fin());
                        stroke(0.7f + e.fout());
                        Lines.square(e.x, e.y, e.fin() * 5f, e.rotation + 45f);

                        Drawf.light(e.x, e.y, 23f, e.color, e.fout() * 0.7f);
                    }));
                    smokeEffect = Fx.shootSmokeSquare;
                    ammoMultiplier = 2;
                }};
            }});

            weapons.add(new PointDefenseWeapon("cleroi-point-defense") {{
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

        蜘蛛3 = new CTRErekirUnitType("anthicus", "anthicus") {{
            speed = 0.65f;
            drag = 0.1f;
            hitSize = 21f;
            rotateSpeed = 3f;
            health = 2900;
            armor = 7f;
            fogRadius = 40f;
            stepShake = 0f;
            useUnitCap = false;
            isEnemy = false;

            legCount = 6;
            legLength = 18f;
            legGroupSize = 3;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -3f;
            legBaseOffset = 7f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 0.95f;
            legForwardScl = 0.9f;
            logicControllable = false;//逻辑控制
            legMoveSpace = 1f;
            hovering = true;

            shadowElevation = 0.2f;
            groundLayer = Layer.legUnit - 1f;

            for (int j = 0; j < 3; j++) {
                int i = j;
                parts.add(new RegionPart("-blade") {{
                    layerOffset = -0.01f;
                    heatLayerOffset = 0.005f;
                    x = 2f;
                    moveX = 6f + i * 1.9f;
                    moveY = 8f + -4f * i;
                    moveRot = 40f - i * 25f;
                    mirror = true;
                    progress = PartProgress.warmup.delay(i * 0.2f);
                    heatProgress = p -> Mathf.absin(Time.time + i * 14f, 7f, 1f);

                    heatColor = Pal.techBlue;
                }});
            }

            weapons.add(new Weapon("anthicus-weapon") {{
                shootSound = Sounds.missileLarge;
                x = 29f / 4f;
                y = -11f / 4f;
                shootY = 1.5f;
                reload = 130f;
                layerOffset = 0.01f;
                heatColor = Color.red;
                cooldownTime = 60f;
                smoothReloadSpeed = 0.15f;
                shootWarmupSpeed = 0.05f;
                minWarmup = 0.9f;
                rotationLimit = 70f;
                rotateSpeed = 2f;
                inaccuracy = 20f;
                shootStatus = StatusEffects.slow;
                alwaysShootWhenMoving = true;

                rotate = true;

                shoot = new ShootPattern() {{
                    shots = 2;
                    shotDelay = 6f;
                }};

                parts.add(new RegionPart("-blade") {{
                    mirror = true;
                    moveRot = -25f;
                    under = true;
                    moves.add(new PartMove(PartProgress.reload, 1f, 0f, 0f));

                    heatColor = Color.red;
                    cooldownTime = 60f;
                }});

                parts.add(new RegionPart("-blade") {{
                    mirror = true;
                    moveRot = -50f;
                    moveY = -2f;
                    moves.add(new PartMove(PartProgress.reload.shorten(0.5f), 1f, 0f, -15f));
                    under = true;

                    heatColor = Color.red;
                    cooldownTime = 60f;
                }});

                bullet = new BulletType() {{
                    shootEffect = new MultiEffect(Fx.shootBigColor, new Effect(9, e -> {
                        color(Color.white, e.color, e.fin());
                        stroke(0.7f + e.fout());
                        Lines.square(e.x, e.y, e.fin() * 5f, e.rotation + 45f);

                        Drawf.light(e.x, e.y, 23f, e.color, e.fout() * 0.7f);
                    }), new WaveEffect() {{
                        colorFrom = colorTo = Pal.techBlue;
                        sizeTo = 15f;
                        lifetime = 12f;
                        strokeFrom = 3f;
                    }});

                    smokeEffect = Fx.shootBigSmoke2;
                    shake = 2f;
                    speed = 0f;
                    keepVelocity = false;
                    inaccuracy = 2f;

                    spawnUnit = new MissileUnitType("anthicus-missile") {{
                        trailColor = engineColor = Pal.techBlue;
                        engineSize = 1.75f;
                        engineLayer = Layer.effect;
                        speed = 3.7f;
                        maxRange = 6f;
                        lifetime = 60f * 1.5f;
                        outlineColor = Pal.darkOutline;
                        health = 55;
                        lowAltitude = true;

                        parts.add(new FlarePart() {{
                            progress = PartProgress.life.slope().curve(Interp.pow2In);
                            radius = 0f;
                            radiusTo = 35f;
                            stroke = 3f;
                            rotation = 45f;
                            y = -5f;
                            followRotation = true;
                        }});

                        weapons.add(new Weapon() {{
                            shootCone = 360f;
                            mirror = false;
                            reload = 1f;
                            shootOnDeath = true;
                            bullet = new ExplosionBulletType(140f, 25f) {{
                                shootEffect = new MultiEffect(Fx.massiveExplosion, new WrapEffect(Fx.dynamicSpikes, Pal.techBlue, 24f), new WaveEffect() {{
                                    colorFrom = colorTo = Pal.techBlue;
                                    sizeTo = 40f;
                                    lifetime = 12f;
                                    strokeFrom = 4f;
                                }});
                            }};
                        }});
                    }};
                }};
            }});
        }};

        蜘蛛4 = new CTRErekirUnitType("tecta", "tecta") {{
            drag = 0.1f;
            speed = 0.6f;
            hitSize = 23f;
            health = 6700;
            armor = 5f;
            useUnitCap = false;
            lockLegBase = true;
            legContinuousMove = true;
            legGroupSize = 3;
            isEnemy = false;
            legStraightness = 0.4f;
            baseLegStraightness = 0.5f;
            legMaxLength = 1.3f;
            researchCostMultiplier = 0f;
            logicControllable = false;//逻辑控制
            abilities.add(new ShieldArcAbility() {{
                region = "tecta-shield";
                radius = 34f;
                angle = 82f;
                regen = 0.6f;
                cooldown = 60f * 8f;
                max = 1500f;
                y = -20f;
                width = 6f;
            }});

            rotateSpeed = 2.1f;

            legCount = 6;
            legLength = 15f;
            legForwardScl = 0.45f;
            legMoveSpace = 1.4f;
            rippleScale = 2f;
            stepShake = 0.5f;
            legExtension = -5f;
            legBaseOffset = 5f;

            ammoType = new PowerAmmoType(2000);

            legSplashDamage = 32;
            legSplashRange = 30;
            drownTimeMultiplier = 2f;

            hovering = true;
            shadowElevation = 0.4f;
            groundLayer = Layer.legUnit;

            weapons.add(new Weapon("tecta-weapon") {{
                shootSound = Sounds.malignShoot;
                mirror = true;
                top = false;

                x = 62 / 4f;
                y = 1f;
                shootY = 47 / 4f;
                recoil = 3f;
                reload = 40f;
                shake = 3f;
                cooldownTime = 40f;

                shoot.shots = 3;
                inaccuracy = 3f;
                velocityRnd = 0.33f;
                heatColor = Color.red;

                bullet = new MissileBulletType(4.2f, 47) {{
                    homingPower = 0.2f;
                    weaveMag = 4;
                    weaveScale = 4;
                    lifetime = 55f;
                    shootEffect = Fx.shootBig2;
                    smokeEffect = Fx.shootSmokeTitan;
                    splashDamage = 60f;
                    splashDamageRadius = 30f;
                    frontColor = Color.white;
                    hitSound = Sounds.none;
                    width = height = 10f;

                    lightColor = trailColor = backColor = Pal.techBlue;
                    lightRadius = 40f;
                    lightOpacity = 0.7f;

                    trailWidth = 2.8f;
                    trailLength = 20;
                    trailChance = -1f;
                    despawnSound = Sounds.dullExplosion;

                    despawnEffect = Fx.none;
                    hitEffect = new ExplosionEffect() {{
                        lifetime = 20f;
                        waveStroke = 2f;
                        waveColor = sparkColor = trailColor;
                        waveRad = 12f;
                        smokeSize = 0f;
                        smokeSizeBase = 0f;
                        sparks = 10;
                        sparkRad = 35f;
                        sparkLen = 4f;
                        sparkStroke = 1.5f;
                    }};
                }};
            }});
        }};

        蜘蛛5 = new CTRErekirUnitType("collaris", "collaris") {{
            drag = 0.1f;
            speed = 1.1f;
            hitSize = 44f;
            health = 18000;
            armor = 9f;
            rotateSpeed = 1.6f;
            lockLegBase = true;
            legContinuousMove = true;
            legStraightness = 0.6f;
            baseLegStraightness = 0.5f;
            useUnitCap = false;
            isEnemy = false;
            legCount = 8;
            legLength = 30f;
            legForwardScl = 2.1f;
            legMoveSpace = 1.05f;
            rippleScale = 1.2f;
            stepShake = 0.5f;
            legGroupSize = 2;
            legExtension = -6f;
            legBaseOffset = 19f;
            legStraightLength = 0.9f;
            legMaxLength = 1.2f;
            logicControllable = false;//逻辑控制
            ammoType = new PowerAmmoType(2000);
            legSplashDamage = 32;
            legSplashRange = 32;
            drownTimeMultiplier = 2f;

            hovering = true;
            shadowElevation = 0.4f;
            groundLayer = Layer.legUnit;

            targetAir = false;
            alwaysShootWhenMoving = true;

            weapons.add(new Weapon("collaris-weapon") {{
                shootSound = Sounds.pulseBlast;
                mirror = true;
                rotationLimit = 30f;
                rotateSpeed = 0.4f;
                rotate = true;

                x = 48 / 4f;
                y = -28f / 4f;
                shootY = 64f / 4f;
                recoil = 4f;
                reload = 130f;
                cooldownTime = reload * 1.2f;
                shake = 7f;
                layerOffset = 0.02f;
                shadow = 10f;

                shootStatus = StatusEffects.slow;
                shootStatusDuration = reload + 1f;

                shoot.shots = 1;
                heatColor = Color.red;

                for (int i = 0; i < 5; i++) {
                    int fi = i;
                    parts.add(new RegionPart("-blade") {{
                        under = true;
                        layerOffset = -0.001f;
                        heatColor = Pal.techBlue;
                        heatProgress = PartProgress.heat.add(0.2f).min(PartProgress.warmup);
                        progress = PartProgress.warmup.blend(PartProgress.reload, 0.1f);
                        x = 13.5f / 4f;
                        y = 10f / 4f - fi * 2f;
                        moveY = 1f - fi * 1f;
                        moveX = fi * 0.3f;
                        moveRot = -45f - fi * 17f;

                        moves.add(new PartMove(PartProgress.reload.inv().mul(1.8f).inv().curve(fi / 5f, 0.2f), 0f, 0f, 36f));
                    }});
                }

                bullet = new ArtilleryBulletType(5.5f, 280) {{
                    collidesTiles = collides = true;
                    lifetime = 75f;
                    shootEffect = Fx.shootBigColor;
                    smokeEffect = Fx.shootSmokeSquareBig;
                    frontColor = Color.white;
                    trailEffect = new MultiEffect(Fx.artilleryTrail, Fx.artilleryTrailSmoke);
                    hitSound = Sounds.none;
                    width = 18f;
                    height = 24f;

                    lightColor = trailColor = hitColor = backColor = Pal.techBlue;
                    lightRadius = 40f;
                    lightOpacity = 0.7f;

                    trailWidth = 4.5f;
                    trailLength = 19;
                    trailChance = -1f;

                    despawnEffect = Fx.none;
                    despawnSound = Sounds.dullExplosion;

                    hitEffect = despawnEffect = new ExplosionEffect() {{
                        lifetime = 34f;
                        waveStroke = 4f;
                        waveColor = sparkColor = trailColor;
                        waveRad = 25f;
                        smokeSize = 0f;
                        smokeSizeBase = 0f;
                        sparks = 10;
                        sparkRad = 25f;
                        sparkLen = 8f;
                        sparkStroke = 3f;
                    }};

                    splashDamage = 85f;
                    splashDamageRadius = 20f;

                    fragBullets = 15;
                    fragVelocityMin = 0.5f;
                    fragRandomSpread = 130f;
                    fragLifeMin = 0.3f;
                    despawnShake = 5f;

                    fragBullet = new BasicBulletType(5.5f, 50) {{
                        pierceCap = 2;
                        pierceBuilding = true;

                        homingPower = 0.09f;
                        homingRange = 150f;

                        lifetime = 50f;
                        shootEffect = Fx.shootBigColor;
                        smokeEffect = Fx.shootSmokeSquareBig;
                        frontColor = Color.white;
                        hitSound = Sounds.none;
                        width = 12f;
                        height = 20f;

                        lightColor = trailColor = hitColor = backColor = Pal.techBlue;
                        lightRadius = 40f;
                        lightOpacity = 0.7f;

                        trailWidth = 2.2f;
                        trailLength = 7;
                        trailChance = -1f;

                        collidesAir = false;

                        despawnEffect = Fx.none;
                        splashDamage = 46f;
                        splashDamageRadius = 30f;

                        hitEffect = despawnEffect = new MultiEffect(new ExplosionEffect() {{
                            lifetime = 30f;
                            waveStroke = 2f;
                            waveColor = sparkColor = trailColor;
                            waveRad = 5f;
                            smokeSize = 0f;
                            smokeSizeBase = 0f;
                            sparks = 5;
                            sparkRad = 20f;
                            sparkLen = 6f;
                            sparkStroke = 2f;
                        }}, Fx.blastExplosion);
                    }};
                }};
            }});
        }};

        //endregion
        //region erekir - flying
        Color 浅紫色 = Color.valueOf("ce9dff");
        Color 紫色 = Color.valueOf("8769c0");
        空军1 = new CTRErekirUnitType("elude", "elude") {{
            hovering = true;
            shadowElevation = 0.1f;
            isEnemy = false;
            drag = 0.07f;
            speed = 1.8f;
            rotateSpeed = 5f;
            useUnitCap = false;
            accel = 0.09f;
            health = 600f;
            armor = 1f;
            hitSize = 11f;
            engineOffset = 7f;
            engineSize = 2f;
            itemCapacity = 0;
            useEngineElevation = false;
            researchCostMultiplier = 0f;
            logicControllable = false;//逻辑控制
            abilities.add(new MoveEffectAbility(0f, -7f, Pal.sapBulletBack, Fx.missileTrailShort, 4f) {{
                teamColor = true;
            }});

            for (float f : new float[]{-3f, 3f}) {
                parts.add(new HoverPart() {{
                    x = 3.9f;
                    y = f;
                    mirror = true;
                    radius = 6f;
                    phase = 90f;
                    stroke = 2f;
                    layerOffset = -0.001f;
                    color = Color.valueOf("bf92f9");
                }});
            }
            weapons.add(new Weapon("avert-weapon") {{
                shootSound = Sounds.blaster;
                reload = 35f;
                x = 0f;
                y = 3f;
                shootY = 5f;
                recoil = 1f;
                top = false;
                layerOffset = -0.01f;
                rotate = false;
                mirror = false;
                shoot = new ShootHelix();

                bullet = new BasicBulletType(5f, 20) {{
                    width = 7f;
                    height = 12f;
                    lifetime = 27f;
                    shootEffect = Fx.sparkShoot;
                    smokeEffect = Fx.shootBigSmoke;
                    hitColor = backColor = trailColor = Pal.suppress;
                    frontColor = Color.white;
                    trailWidth = 1.5f;
                    trailLength = 5;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                }};
            }});
            weapons.add(new Weapon("elude-weapon") {{
                shootSound = Sounds.blaster;
                y = -2f;
                x = 4f;
                top = true;
                mirror = true;
                reload = 40f;
                baseRotation = -35f;
                shootCone = 360f;

                shoot = new ShootSpread(2, 11f);

                bullet = new BasicBulletType(2f, 16) {{

                    homingDelay = 4f;
                    width = 7f;
                    height = 12f;
                    lifetime = 120f;
                    shootEffect = Fx.sparkShoot;
                    smokeEffect = Fx.shootBigSmoke;
                    hitColor = backColor = trailColor = Pal.suppress;
                    frontColor = Color.white;
                    trailWidth = 1.5f;
                    trailLength = 5;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    homingPower = 0.5f;
                }};
            }});
        }};

        空军2 = new CTRErekirUnitType("avert", "avert") {{
            lowAltitude = false;
            flying = true;
            isEnemy = false;
            drag = 0.08f;
            speed = 2f;
            rotateSpeed = 4f;
            accel = 0.09f;
            health = 1100f;
            armor = 3f;
            hitSize = 12f;
            engineSize = 0;
            fogRadius = 25;
            itemCapacity = 0;
            useUnitCap = false;
            logicControllable = false;//逻辑控制
            setEnginesMirror(
                    new UnitEngine(35 / 4f, -38 / 4f, 3f, 315f),
                    new UnitEngine(39 / 4f, -16 / 4f, 3f, 315f)
            );
            for (int i : Mathf.signs) {
                weapons.add(new Weapon("avert-weapon") {{
                    shootSound = Sounds.blaster;
                    reload = 35f;
                    x = 10f * i;
                    y = 5f;
                    shootY = 5f;
                    recoil = 1f;
                    top = true;
                    layerOffset = -0.01f;
                    rotate = false;
                    mirror = false;
                    shoot = new ShootHelix();

                    bullet = new BasicBulletType(5f, 34) {{
                        width = 7f;
                        height = 12f;
                        lifetime = 40f;
                        shootEffect = Fx.sparkShoot;
                        smokeEffect = Fx.shootBigSmoke;
                        hitColor = backColor = trailColor = Pal.suppress;
                        frontColor = Color.white;
                        trailWidth = 1.5f;
                        trailLength = 5;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                    }};
                }});
            }
            weapons.add(new Weapon("avert-weapon") {
                {
                    shootSound = Sounds.blaster;
                    //reload = 35f;
                    x = 0f;
                    y = 0f;
                    shootY = 5f;
                    recoil = 1f;
                    top = false;
                    layerOffset = -0.01f;
                    rotate = false;
                    mirror = false;
                    // shoot = new ShootHelix();//两个子弹齐发？
                    bullet = new ContinuousFlameBulletType() {{
                        damage = 70 / 12f;
                        length = 130;
                        knockback = 1f;
                        pierceCap = 2;
                        buildingDamageMultiplier = 0.3f;

                        colors = new Color[]{Color.valueOf("eb7abe").a(0.55f), Color.valueOf("e189f5").a(0.7f), Color.valueOf("907ef7").a(0.8f), Color.valueOf("91a4ff"), Color.white};
                    }};
                }
            });
        }};

        空军3 = new CTRErekirUnitType("obviate", "obviate") {{
            flying = true;
            drag = 0.08f;
            speed = 1.8f;
            isEnemy = false;
            rotateSpeed = 2.5f;
            accel = 0.09f;
            health = 2300f;
            armor = 6f;
            hitSize = 25f;
            engineSize = 4.3f;
            engineOffset = 54f / 4f;
            fogRadius = 25;
            itemCapacity = 0;
            lowAltitude = true;
            useUnitCap = false;
            setEnginesMirror(
                    new UnitEngine(38 / 4f, -46 / 4f, 3.1f, 315f)
            );
            logicControllable = false;//逻辑控制
            parts.add(
                    new RegionPart("-blade") {{
                        moveRot = -10f;
                        moveX = -1f;
                        moves.add(new PartMove(PartProgress.reload, 2f, 1f, -5f));
                        progress = PartProgress.warmup;
                        mirror = true;

                        children.add(new RegionPart("-side") {{
                            moveX = 2f;
                            moveY = -2f;
                            progress = PartProgress.warmup;
                            under = true;
                            mirror = true;
                            moves.add(new PartMove(PartProgress.reload, -2f, 2f, 0f));
                        }});
                    }});

            weapons.add(new Weapon() {{
                shootSound = Sounds.shootBig;
                x = 12f;
                y = -2f;


                mirror = true;
                minWarmup = 0.95f;
                shake = 3f;

                inaccuracy = 11f;
                reload = 20f;
                shootY = 11f;
                rotateSpeed = 5f;
                shoot = new ShootAlternate() {{
                    spread = 4.7f;
                    shots = 4;
                    barrels = 4;
                }};
                shootCone = 30f;

                targetGround = true;

                bullet = new BasicBulletType() {{
                    damage = 25;
                    speed = 8.5f;
                    width = height = 16;
                    shrinkY = 0.3f;
                    backSprite = "large-bomb-back";
                    sprite = "mine-bullet";
                    velocityRnd = 0.11f;
                    collidesGround = false;
                    collidesTiles = false;
                    shootEffect = Fx.shootBig2;
                    smokeEffect = Fx.shootSmokeDisperse;
                    frontColor = Color.white;
                    backColor = trailColor = hitColor = 紫色;
                    trailChance = 0.44f;
                    ammoMultiplier = 3f;

                    lifetime = 34f;
                    rotationOffset = 90f;
                    trailRotation = true;
                    trailEffect = Fx.disperseTrail;

                    hitEffect = despawnEffect = Fx.hitBulletColor;
                }};
            }});


            weapons.add(new Weapon() {{
                shootSound = Sounds.shockBlast;
                x = 0f;
                y = -2f;
                shootY = 0f;
                reload = 100f;
                mirror = false;
                minWarmup = 0.95f;
                shake = 3f;
                cooldownTime = reload - 10f;

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
                    damage = 75f;
                    lifetime = 100f;
                    width = height = 15f;
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
                        damage = 16;
                        collidesAir = false;
                        ammoMultiplier = 1f;
                        lightningColor = Pal.sapBullet;
                        lightningLength = 3;
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
                    lightningDamage = 17;
                    lightning = 8;
                    lightningLength = 2;
                    lightningLengthRand = 8;
                }};

            }});
        }};

        空军4 = new CTRErekirUnitType("quell", "quell") {{
            aiController = FlyingFollowAI::new;
            envDisabled = 0;
            useUnitCap = false;
            lowAltitude = false;
            isEnemy = false;
            flying = true;
            drag = 0.06f;
            speed = 1.1f;
            rotateSpeed = 3.2f;
            accel = 0.1f;
            health = 8000f;
            armor = 5f;
            hitSize = 36f;
            payloadCapacity = Mathf.sqr(3f) * tilePayload;
            researchCostMultiplier = 0f;
            logicControllable = false;//逻辑控制
            engineSize = 4.8f;
            engineOffset = 61 / 4f;

            abilities.add(new SuppressionFieldAbility() {{
                orbRadius = 5.3f;
                y = 1f;
            }});
            weapons.add(new Weapon("quell-weapon") {{
                rotate = false;
                rotateSpeed = 2f;
                reload = 120f;
                mirror = false;
                top = false;
                x = 0;
                y = 18;
                bullet = new BasicBulletType(5, 180) {{
                    shootEffect = new MultiEffect(Fx.shootTitan, new WaveEffect() {{
                        colorTo = 紫色;
                        sizeTo = 26f;
                        lifetime = 14f;
                        strokeFrom = 4f;
                    }});
                    smokeEffect = Fx.shootSmokeTitan;


                    sprite = "large-orb";
                    trailEffect = Fx.missileTrail;
                    trailInterval = 3f;
                    trailParam = 4f;
                    pierceCap = 2;
                    fragOnHit = false;
                    lifetime = 60f;
                    width = height = 25f;

                    frontColor = Color.white;
                    shrinkX = shrinkY = 0f;
                    hitColor = backColor = trailColor = 紫色;
                    trailLength = 12;
                    trailWidth = 2.2f;
                    despawnEffect = hitEffect = new ExplosionEffect() {{
                        waveColor = 紫色;
                        smokeColor = 浅绿色;
                        sparkColor = 紫色;
                        waveStroke = 4f;
                        waveRad = 40f;
                    }};
                    despawnSound = Sounds.dullExplosion;

                    //TODO shoot sound
                    //  shootSound = Sounds.cannon;

                    fragBullet = intervalBullet = new BasicBulletType(3f, 35) {{
                        width = 9f;
                        hitSize = 5f;
                        height = 15f;
                        pierce = true;
                        lifetime = 35f;
                        pierceBuilding = true;
                        hitColor = backColor = trailColor = Pal.surge;
                        frontColor = Color.white;
                        trailWidth = 2.1f;
                        trailLength = 5;
                        hitEffect = despawnEffect = new WaveEffect() {{
                            colorFrom = colorTo = Pal.surge;
                            sizeTo = 4f;
                            strokeFrom = 4f;
                            lifetime = 10f;
                        }};
                        buildingDamageMultiplier = 0.3f;
                        homingPower = 0.2f;
                    }};

                    bulletInterval = 3f;
                    intervalRandomSpread = 20f;
                    intervalBullets = 2;
                    intervalAngle = 180f;
                    intervalSpread = 300f;
                    hitColor = backColor = trailColor = 紫色;
                    fragBullets = 20;
                    fragVelocityMin = 0.5f;
                    fragVelocityMax = 1.5f;
                    fragLifeMin = 0.5f;
                }};
            }});
            weapons.add(new Weapon("quell-weapon") {{
                shootSound = Sounds.missileLarge;
                x = 51 / 4f;
                y = 5 / 4f;
                rotate = true;
                rotateSpeed = 2f;
                reload = 55f;
                layerOffset = -0.001f;
                recoil = 1f;
                rotationLimit = 60f;
                shootCone = 40f;
                shoot.shots = 5;
                shoot.shotDelay = 5f;
                inaccuracy = 28f;
                bullet = new MissileBulletType(3f, 48) {{
                    width = 10;
                    height = 20;
                    shrinkY = 0f;
                    drag = -0.003f;
                    homingRange = 60f;
                    keepVelocity = false;
                    splashDamageRadius = 25f;
                    splashDamage = 23f;
                    lifetime = 70f;
                    trailColor = 紫色;
                    backColor = 紫色;
                    frontColor = 浅紫色;
                    hitColor = 浅紫色;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                    weaveScale = 6f;
                    weaveMag = 1f;
                }};
            }});

            setEnginesMirror(
                    new UnitEngine(62 / 4f, -60 / 4f, 3.9f, 315f),
                    new UnitEngine(72 / 4f, -29 / 4f, 3f, 315f)
            );
        }};

        空军5 = new CTRErekirUnitType("disrupt", "disrupt") {{
            aiController = FlyingFollowAI::new;
            envDisabled = 0;
            useUnitCap = false;
            lowAltitude = false;
            isEnemy = false;
            flying = true;
            drag = 0.07f;
            speed = 1f;
            rotateSpeed = 2f;
            accel = 0.1f;
            health = 12000f;
            armor = 9f;
            hitSize = 46f;
            payloadCapacity = Mathf.sqr(6f) * tilePayload;
            logicControllable = false;//逻辑控制
            engineSize = 6f;
            engineOffset = 25.25f;

            float orbRad = 5f, partRad = 3f;
            int parts = 10;

            abilities.add(new SuppressionFieldAbility() {{
                orbRadius = orbRad;
                particleSize = partRad;
                y = 10f;
                particles = parts;
            }});

            for (int i : Mathf.signs) {
                abilities.add(new SuppressionFieldAbility() {{
                    orbRadius = orbRad;
                    particleSize = partRad;
                    y = -32f / 4f;
                    x = 43f * i / 4f;
                    particles = parts;
                    //visual only, the middle one does the actual suppressing
                    display = active = false;
                }});
            }

            weapons.add(new Weapon("disrupt-weapon") {{
                parts.add(new RegionPart("-blade") {{
                    heatProgress = PartProgress.warmup;
                    progress = PartProgress.warmup.blend(PartProgress.reload, 0.15f);
                    heatColor = Color.valueOf("9c50ff");
                    x = 5 / 4f;
                    y = 0f;
                    moveRot = -33f;
                    moveY = -1f;
                    moveX = -1f;
                    under = true;
                    mirror = true;
                }});

                shootSound = Sounds.missileLarge;
                x = 78f / 4f;
                y = -10f / 4f;
                mirror = true;
                rotate = true;
                rotateSpeed = 0.4f;
                reload = 40f;
                layerOffset = -20f;
                recoil = 1f;
                rotationLimit = 22f;
                minWarmup = 0.95f;
                shootWarmupSpeed = 0.1f;
                shootY = 2f;
                shootCone = 40f;
                shoot.shots = 3;
                shoot.shotDelay = 5f;
                inaccuracy = 15f;


                velocityRnd = 0.2f;
                // shootSound = Sounds.missile;

                bullet = new MissileBulletType(5f, 67) {{
                    homingRange = 150;//追踪fw
                    homingPower = 6; //追踪
                    width = 15;
                    height = 35;
                    shrinkY = 0f;
                    drag = -0.003f;
                    homingRange = 60f;
                    keepVelocity = false;
                    splashDamageRadius = 25f;
                    splashDamage = 23f;
                    lifetime = 100f;
                    trailColor = 紫色;
                    backColor = 紫色;
                    frontColor = 浅紫色;
                    hitColor = 浅紫色;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                    weaveScale = 6f;
                    weaveMag = 1f;
                }};

            }});
            weapons.add(new Weapon("disrupt-weapon") {{
                Color haloColor = Color.valueOf("d370d3");

                parts.add(new RegionPart("-blade") {{
                    heatProgress = PartProgress.warmup;
                    progress = PartProgress.warmup.blend(PartProgress.reload, 0.15f);
                    heatColor = Color.valueOf("9c50ff");
                    x = 5 / 4f;
                    y = 5f;
                    moveRot = -33f;
                    moveY = -1f;
                    moveX = -3f;
                    under = true;
                    mirror = true;
                }});
                shootSound = Sounds.malignShoot;
                loopSound = Sounds.spellLoop;
                loopSoundVolume = 1.3f;
                velocityRnd = 0.15f;
                // shoot = new ShootSummon(0f, 0f, 3, 48f);
                shoot = new ShootSpread(7, 7);
                shoot.shotDelay = 10;
                // shoot.firstShotDelay=20;
                minWarmup = 0.96f;
                shootWarmupSpeed = 0.03f;
                shootY = -5f;
                outlineColor = Pal.darkOutline;
                reload = 30f;
                shootCone = 30f;
                rotateSpeed = 2f;
                shake = 3f;
                inaccuracy = 7;
                x = 12f;
                y = 7f;
                bullet = new FlakBulletType(8f, 70f) {{
                    sprite = "missile-large";
                    lifetime = 45f;
                    width = 12f;
                    height = 22f;
                    hitSize = 7f;
                    shootEffect = Fx.shootSmokeSquareBig;
                    smokeEffect = Fx.shootSmokeDisperse;
                    ammoMultiplier = 1;
                    hitColor = backColor = trailColor = lightningColor = haloColor;
                    frontColor = Color.white;
                    trailWidth = 3f;
                    trailLength = 12;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    buildingDamageMultiplier = 0.3f;

                    trailEffect = Fx.colorSpark;
                    trailRotation = true;
                    trailInterval = 3f;
                    lightning = 1;
                    lightningCone = 15f;
                    lightningLength = 20;
                    lightningLengthRand = 30;
                    lightningDamage = 20f;

                    homingPower = 0.17f;
                    homingDelay = 19f;
                    homingRange = 160f;

                    explodeRange = 160f;
                    explodeDelay = 0f;

                    flakInterval = 20f;
                    despawnShake = 3f;
                    fragBullets = 5;
                    fragRandomSpread = 4;//破片散布角度
                    fragBullet = new LaserBulletType(65f) {{
                        colors = new Color[]{haloColor.cpy().a(0.4f), haloColor, Color.white};
                        buildingDamageMultiplier = 0.25f;
                        width = 19f;
                        hitEffect = Fx.hitLancer;
                        sideAngle = 175f;
                        sideWidth = 1f;
                        sideLength = 40f;
                        lifetime = 22f;
                        drawSize = 400f;
                        length = 180f;
                        pierceCap = 2;
                    }};

                    fragSpread = 3;


                    splashDamage = 5f;//溅射伤害
                    hitEffect = Fx.hitSquaresColor;
                    collidesGround = true;
                }};
            }});
            setEnginesMirror(
                    new UnitEngine(95 / 4f, -56 / 4f, 5f, 330f),
                    new UnitEngine(89 / 4f, -95 / 4f, 4f, 315f)
            );
        }};


        CTRErekirUnitType 试验 = new CTRErekirUnitType("试验", "quell") {{
            speed = 3.44f;
            useUnitCap = false;
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

                bullet = new PointLaserBulletType() {{
                    damage = 200f;
                    buildingDamageMultiplier = 0.3f;
                    hitColor = Color.valueOf("fda981");
                }};
                new ContinuousLaserBulletType() {{
                    damage = 500f / 12;
                    length = 180f * 3f;
                    width = 3;
                    hitEffect = Fx.hitMeltHeal;
                    drawSize = 420f;
                    lifetime = 160f * 10f;
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
        }};
//
        StatusEffect 盾牌状态 = unmoving;
        //阻挡单位
        T2盾牌单位 = new CTRUnitType("Shield", "flare") {{
            float 大小 = 12f;
            speed = 4f;
            isEnemy = false;
            // accel = 0.08f;
            //drag = 0.04f;
            logicControllable = false;//逻辑控制
            armor = 0f;
            flying = true;
            health = 2000;
            engineOffset = 5.75f;
            hitSize = 大小;
            itemCapacity = 0;
            // targetFlags = new BlockFlag[]{null};
            abilities.add(new CTStatusFieldAbility(盾牌状态, 60f * 6, 60f * 6f + 5, 大小 + 8 * 2));
        }};
        T3盾牌单位 = new CTRUnitType("Peltast", "flare") {{
            float 大小 = 20f;
            speed = 3f;
            isEnemy = false;
            // accel = 0.08f;
            //drag = 0.04f;
            logicControllable = false;//逻辑控制
            armor = 0f;
            flying = true;
            health = 2000;
            engineOffset = 5.75f;
            hitSize = 大小;
            itemCapacity = 0;
            // targetFlags = new BlockFlag[]{null};
            abilities.add(new CTStatusFieldAbility(盾牌状态, 60f * 6, 60f * 6f + 5, 大小 + 8 * 2));
        }};
        T4盾牌单位 = new CTRUnitType("Argyraspides", "flare") {{
            float 大小 = 32f;
            speed = 2f;
            isEnemy = false;
            // accel = 0.08f;
            //drag = 0.04f;
            logicControllable = false;//逻辑控制
            armor = 0f;
            flying = true;
            health = 2000;
            engineOffset = 5.75f;
            hitSize = 大小;
            itemCapacity = 0;
            // targetFlags = new BlockFlag[]{null};
            abilities.add(new CTStatusFieldAbility(盾牌状态, 60f * 6, 60f * 6f + 5, 大小 + 8 * 2));
        }};
        T5盾牌单位 = new CTRUnitType("Blast-shield", "flare") {{
            float 大小 = 45f;
            speed = 1f;
            isEnemy = false;
            // accel = 0.08f;
            //drag = 0.04f;
            logicControllable = false;//逻辑控制
            armor = 0f;
            flying = true;
            health = 2000;
            engineOffset = 5.75f;
            hitSize = 大小;
            itemCapacity = 0;
            // targetFlags = new BlockFlag[]{null};
            abilities.add(new CTStatusFieldAbility(盾牌状态, 60f * 6, 60f * 6f + 5, 大小 + 8 * 2));
        }};
    }


    //--------------------盾兵的静止力场
    public static class CTStatusFieldAbility extends Ability {
        public StatusEffect effect;
        public float duration = 60.0F;
        public float reload = 100.0F;
        public float range = 20.0F;
        public boolean onShoot = false;
        public Effect applyEffect;
        public Effect activeEffect;
        public float effectX;
        public float effectY;
        public boolean parentizeEffects;
        public boolean effectSizeParam;
        protected float timer;

        CTStatusFieldAbility() {
            this.applyEffect = Fx.none;
            this.activeEffect = Fx.none;
            this.effectSizeParam = true;
        }

        public CTStatusFieldAbility(StatusEffect 状态, float 持续时间, float CD, float 范围) {
            this.applyEffect = Fx.none;
            this.activeEffect = Fx.none;
            this.effectSizeParam = true;
            this.duration = 持续时间;
            this.reload = CD;
            this.range = 范围;
            this.effect = 状态;
        }

        public String localized() {
            return Core.bundle.format("ability.CTstatusfield", new Object[]{this.effect.emoji()});
        }

        public void update(Unit unit) {
            this.timer += Time.delta;
            if (this.timer >= this.reload && (!this.onShoot || unit.isShooting)) {
                Units.nearby(Team.crux, unit.x, unit.y, this.range, (other) -> {
                    other.apply(this.effect, this.duration);
                    this.applyEffect.at(other, this.parentizeEffects);
                });
                float x = unit.x + Angles.trnsx(unit.rotation, this.effectY, this.effectX);
                float y = unit.y + Angles.trnsy(unit.rotation, this.effectY, this.effectX);
                this.activeEffect.at(x, y, this.effectSizeParam ? this.range : unit.rotation, this.parentizeEffects ? unit : null);
                this.timer = 0.0F;
            }

        }

        ;
        //--------------------
    }
}
