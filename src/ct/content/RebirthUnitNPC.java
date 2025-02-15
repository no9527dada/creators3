package ct.content;

import CtCoreSystem.CoreSystem.type.BulletType.RoundBulletType;
import arc.Core;
import arc.graphics.Color;
import CtCoreSystem.CoreSystem.type.CT3UnitType;
import CtCoreSystem.CoreSystem.type.CTRepairBeamWeapon;
import CtCoreSystem.CoreSystem.type.yuan;
import arc.math.Mathf;
import mindustry.ai.UnitCommand;
import mindustry.ai.types.BuilderAI;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.content.UnitTypes;
import mindustry.entities.abilities.RepairFieldAbility;
import mindustry.entities.abilities.SpawnDeathAbility;
import mindustry.entities.abilities.SuppressionFieldAbility;
import mindustry.entities.bullet.*;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.MissileUnitType;
import mindustry.world.meta.BlockFlag;

import static CtCoreSystem.CoreSystem.type.CTColor.C;
import static mindustry.Vars.tilePayload;
import static mindustry.content.Fx.none;
import static mindustry.content.UnitTypes.*;

public class RebirthUnitNPC {

    public static UnitType 珮思思0, 探子, 珮思思1, 珮思思2, 鹿恒1, 萝莉儿;
    public static UnitType 第9关BSS, 第17关BSS;

    public static void load() {
        new UnitType("机关A") {{
            constructor = UnitTypes.flare.constructor;
            localizedName = "机关A";
            health = 100f;
            hitSize = 8f;
            hittable =
                    killable =
                            targetable = false;//被敌人瞄准
            logicControllable = true;//逻辑器控制单位
            speed = 0.5f;//需要移速
            weapons.add(new Weapon("vela-weapon") {{
                mirror = false;
                top = false;
                shake = 0f;
                shootY = 0f;
                x = y = 0f;
                // shoot.firstShotDelay = Fx.greenLaserChargeSmall.lifetime - 1f;
                parentizeEffects = true;
                //  reload = 155f;
                //  recoil = 0f;
                chargeSound =
                        shootSound = Sounds.none;
                // continuous = true;
                //  cooldownTime = 200f;

                rotateSpeed = 50f;//炮塔旋转速度
                new ContinuousLaserBulletType(2000 / 12f) {{
                    length = 20 * 8;
                    hitEffect = Fx.hitMeltdown;
                    hitColor = Pal.meltdownHit;
                    drawSize = 420f / 2;
                    // timescaleDamage = true;
                    incendChance = 0.4f;
                    incendSpread = 5f;
                    incendAmount = 1;
                    ammoMultiplier = 1f;
                }};
            }});
        }};

        //昏迷珮思思
        珮思思0 = new CT3UnitType.CTR1UnitTypeNpc("珮思思0", "gamma") {{
            localizedName = Core.bundle.get("Unit.pei0");
            description = Core.bundle.getOrNull("Unit.description.pei0");
            aiController = BuilderAI::new;
            // mineSpeed = 3f;
            //mineTier = 1;
            //buildSpeed = 0.5f;
            speed = 2f;//需要移速，逻辑指导跟随猪脚移动
            // itemCapacity = 30;
            armor = 2;
            health = 2000f;
            hitSize = 8f;
            engineSize = 6;
            engineOffset = 0f;
            hittable = true;//被子弹击中
            killable = true;//被杀死
            targetable = true;//被敌人瞄准
            engineColor = Color.valueOf("e46ef5");//蓝色尾焰
            //mineRange = 18*8f;//采矿范围
            logicControllable = true;//逻辑器控制单位
            // canAttack = false;//关闭单位的武器,功能性单位
            weapons.add(new CTRepairBeamWeapon() {{
                autoTarget = true;//被动开火
                shootCone = 15;
                光条颜色 = Color.valueOf("e46ef5");
                mirror = false;
                repairSpeed = 500 / 60f + 1;
                ;
                //fractionRepairSpeed = 0.06f;
                targetUnits = false;//对单位治疗
                targetBuildings = true;//对建筑治疗
                controllable = false;//可控制 这个武器是否可以由玩家手动瞄准*/
                aiControllable = true;//该武器是否能被单位自动瞄准
                bullet = new BulletType() {{
                    maxRange = 120f;
                }};
            }});
        }};
        //RebirthUnitNPC.探子.speed=3
        //4关的探子
        探子 = new CT3UnitType.CTR1UnitType("探子", "flare") {{
            localizedName = "探子";//Core.bundle.get("Unit.tanzi");
            description = Core.bundle.getOrNull("Unit.description.null");

            speed = 1.5f;
            accel = 0.08f;
            drag = 0.04f;
            flying = true;
            health = 2000 * 1.5f;
            engineOffset = 5.75f;
            //TODO balance
            //targetAir = false;
            //targetFlags = new BlockFlag[]{BlockFlag.generator, null};
            hitSize = 9;
            itemCapacity = 0;

            weapons.add(new Weapon() {{
                y = 0f;
                x = 2f;
                reload = 20f;
                rotate = true;
                controllable = false;//玩家操控开火
                autoTarget = true;//被动开火?
                // aiControllable = true;//该武器是否能被单位自动瞄准
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(2.5f, 20) {{
                    width = 7f;
                    height = 9f;
                    lifetime = 55f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    ammoMultiplier = 2;
                }};
                shootSound = Sounds.pew;
            }});
        }};
        珮思思1 = new CT3UnitType.CTR1UnitTypeNpc("珮思思1", "gamma") {{
            localizedName = Core.bundle.get("Unit.pei1");
            description = Core.bundle.getOrNull("Unit.description.pei1");
            aiController = BuilderAI::new;
            // mineSpeed = 3f;
            //mineTier = 1;
            //buildSpeed = 0.5f;
            speed = 3f;//需要移速，逻辑指导跟随猪脚移动
            // itemCapacity = 30;
            armor = 2;
            health = 2000f;
            hitSize = 8f;
            engineSize = 6;
            engineOffset = 0f;
            buildSpeed = 0.5f;//建造速度,这里必须要有建造功能，才能用鼠标指挥跟随玩家，不在用逻辑了
            hittable = true;//被子弹击中
            killable = true;//被杀死
            targetable = true;//被敌人瞄准
            engineColor = Color.valueOf("e46ef5");//尾焰
            //mineRange = 18*8f;//采矿范围
            // canAttack = false;//关闭单位的武器,功能性单位
            abilities.add(new RepairFieldAbility(200f, 60f * 2, 5 * 8f), new yuan(30, 120, C("eb97ff")));
            weapons.add(new CTRepairBeamWeapon() {{
                autoTarget = true;//被动开火
                shootCone = 15;
                光条颜色 = Color.valueOf("e46ef5");
                mirror = false;
                repairSpeed = 500 / 60f + 1;
                ;
                //fractionRepairSpeed = 0.06f;
                targetUnits = false;//对单位治疗
                targetBuildings = true;//对建筑治疗
                controllable = false;//可控制 这个武器是否可以由玩家手动瞄准*/
                aiControllable = true;//该武器是否能被单位自动瞄准
                bullet = new BulletType() {{
                    maxRange = 200f;
                }};
            }});
        }};
        珮思思2 = new CT3UnitType.CTR1UnitTypeNpc("珮思思2", "gamma") {{
            localizedName = Core.bundle.get("Unit.pei2");
            description = Core.bundle.getOrNull("Unit.description.pei1");
            // aiController = BuilderAI::new;
            defaultCommand = UnitCommand.repairCommand;
            // mineSpeed = 3f;
            //mineTier = 1;
            //buildSpeed = 0.5f;
            speed = 3f;//需要移速，逻辑指导跟随猪脚移动
            // itemCapacity = 30;
            armor = 5;
            health = 2500f;
            hitSize = 8f;
            engineSize = 6;
            engineOffset = 0f;
            buildSpeed = 0.5f;//建造速度,这里必须要有建造功能，才能用鼠标指挥跟随玩家，不在用逻辑了
            hittable = true;//被子弹击中
            killable = true;//被杀死
            targetable = true;//被敌人瞄准
            engineColor = Color.valueOf("e46ef5");
            //mineRange = 18*8f;//采矿范围
            // canAttack = false;//关闭单位的武器,功能性单位
            abilities.add(new RepairFieldAbility(200f, 60f * 2, 5 * 8f), new yuan(30, 120, C("eb97ff")));
            weapons.add(new CTRepairBeamWeapon() {{
                autoTarget = true;//被动开火
                shootCone = 15;
                光条颜色 = Color.valueOf("e46ef5");
                mirror = false;
                repairSpeed = 500 / 60f + 1;
                ;
                //fractionRepairSpeed = 0.06f;
                targetUnits = false;//对单位治疗
                targetBuildings = true;//对建筑治疗
                controllable = false;//可控制 这个武器是否可以由玩家手动瞄准*/
                aiControllable = true;//该武器是否能被单位自动瞄准
                bullet = new BulletType() {{
                    maxRange = 200f;
                }};
            }});
            weapons.add(//
                    new Weapon("ct-heal1") {{
                        shootSound = Sounds.lasershoot;
                        reload = 5;
                        x = 5;
                        y = 0;
                        rotate = true;
                        bullet = new LaserBoltBulletType() {{
                            speed = 5.2f;
                            damage = 10;
                            lifetime = 70;
                            healPercent = 2f;
                            collidesTeam = true;
                            backColor = Pal.heal;
                            frontColor = Color.white;
                        }};
                    }});
            lightRadius = 30 * 8;
            lightOpacity = 0.7f;
            lightColor = Color.valueOf("e46ef5");
        }};
        鹿恒1 = new CT3UnitType.CTR1UnitTypeNpc("鹿恒1", "flare") {{
            armor = 7;
            health = 2000f;
            engineOffset = 5f;
            speed = 3.5f;
            hittable = true;//被子弹击中
            killable = true;//被杀死
            targetable = true;//被敌人瞄准
            mineSpeed = 5f;//采矿速度
            mineTier = 1;//采矿等级
            buildSpeed = 2f;//建造速度
            buildRange = 32 * 8F;//建造范围
            lightColor = Color.valueOf("0025ff");
            lightOpacity = 1;
            abilities.add(new yuan(30, 120, C("97afff")));
            weapons.add(
                    new Weapon() {{
                        shoot.shots = 7;
                        shoot.shotDelay = 10f;
                        reload = 120f;
                        rotate = true;//旋转
                        bullet = new LightningBulletType() {{
                            damage = 50;
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
                    }}
            );
        }};
        萝莉儿 = new CT3UnitType.CTR1UnitTypeNpc("萝莉儿", "flare") {{
            //  aiController = FlyingFollowAI::new;
            envDisabled = 0;
            lowAltitude = false;
            flying = true;
            drag = 0.07f;
            speed = 2f;
            rotateSpeed = 2f;
            accel = 0.1f;
            health = 2000f;
            armor = 10f;
            hitSize = 46f;
            payloadCapacity = Mathf.sqr(6f) * tilePayload;
            targetAir = false;
            constructor = UnitTypes.flare.constructor;
            engineSize = 6f;
            engineOffset = 25.25f;
            mineSpeed = 1f;//采矿速度
            mineTier = 3;//采矿等级
            buildSpeed = 1f;//建造速度
            buildRange = 100 * 8F;//建造范围
            //  hittable = false;//被子弹击中
            killable = false;//被杀死
            targetable = false;//被敌人瞄准
            // physics = false;//单位碰撞

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

            weapons.add(new Weapon("萝莉儿-weapon") {{
                shootSound = Sounds.missileLarge;
                x = 78f / 4f;
                y = -10f / 4f;
                mirror = true;
                rotate = true;
                rotateSpeed = 0.4f;
                reload = 70f;
                layerOffset = -20f;
                recoil = 1f;
                rotationLimit = 22f;
                minWarmup = 0.95f;
                shootWarmupSpeed = 0.1f;
                shootY = 2f;
                shootCone = 40f;
                shoot.shots = 4;
                shoot.shotDelay = 5f;
                inaccuracy = 28f;

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
                bullet = new BasicBulletType() {
                    {
                        speed = 3f;
                        lifetime = 140;
                        damage = 20;
                        trailParam = 2;
                        trailLength = 50;
                        trailWidth = 2;
                        width = 10;
                        height = 13;
                        shrinkX =
                                shrinkY = 0;
                        trailEffect = none;
                        trailColor = C("ffffff");
                        fragBullets = 1;
                        fragBullet = new RoundBulletType() {{
                            damage = 50;
                        }};
                    }
                };
            }});

            setEnginesMirror(
                    new UnitEngine(95 / 4f, -56 / 4f, 5f, 330f),
                    new UnitEngine(89 / 4f, -95 / 4f, 4f, 315f)
            );
            engineColor = Color.valueOf("ffffff");
        }};
        第9关BSS = new CT3UnitType.CTR1UnitType("暗袭兽", "toxopid") {{
            localizedName = Core.bundle.get("chapter.9boss");
            description = Core.bundle.getOrNull("chapter.9boss.description");
            drag = 0.1f;
            speed = 0.5f;
            hitSize = 26f;
            health = 200000;
            armor = 0;
            lightRadius = 140f;
            logicControllable = true;//逻辑器控制单位
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
            legSplashDamage = 80;
            legSplashRange = 60;

            hovering = true;
            shadowElevation = 0.95f;
            groundLayer = Layer.legUnit;

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

                        shoot = new ShootSpread(2, 17f);

                        bullet = new ShrapnelBulletType() {{
                            length = 90f;
                            damage = 110f;
                            width = 25f;
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

            weapons.add(new Weapon("toxopid-cannon") {{
                y = -14f;
                x = 0f;
                shootY = 22f;
                mirror = false;
                reload = 210;
                shake = 10f;
                recoil = 10f;
                rotateSpeed = 1f;
                ejectEffect = Fx.casing3;
                shootSound = Sounds.artillery;
                rotate = true;
                shadow = 30f;

                rotationLimit = 80f;

                bullet = new ArtilleryBulletType(3f, 50) {{
                    hitEffect = Fx.sapExplosion;
                    knockback = 0.8f;
                    lifetime = 80f;
                    width = height = 25f;
                    collidesTiles = collides = true;
                    ammoMultiplier = 4f;
                    splashDamageRadius = 80f;
                    splashDamage = 75f;
                    backColor = Pal.sapBulletBack;
                    frontColor = lightningColor = Pal.sapBullet;
                    lightning = 5;
                    lightningLength = 20;
                    smokeEffect = Fx.shootBigSmoke2;
                    hitShake = 10f;
                    lightRadius = 40f;
                    lightColor = Pal.sap;
                    lightOpacity = 0.6f;

                    status = StatusEffects.sapped;
                    statusDuration = 60f * 10;

                    fragLifeMin = 0.3f;
                    fragBullets = 9;

                    fragBullet = new ArtilleryBulletType(2.3f, 30) {{
                        hitEffect = Fx.sapExplosion;
                        knockback = 0.8f;
                        lifetime = 90f;
                        width = height = 20f;
                        collidesTiles = false;
                        splashDamageRadius = 70f;
                        splashDamage = 40f;
                        backColor = Pal.sapBulletBack;
                        frontColor = lightningColor = Pal.sapBullet;
                        lightning = 2;
                        lightningLength = 5;
                        smokeEffect = Fx.shootBigSmoke2;
                        hitShake = 5f;
                        lightRadius = 30f;
                        lightColor = Pal.sap;
                        lightOpacity = 0.5f;

                        status = StatusEffects.sapped;
                        statusDuration = 60f * 10;
                    }};
                }};
            }});
        }};

        第17关BSS = new UnitType("eclipse2") {{
            speed = 0.54f;
            accel = 0.04f;
            drag = 0.04f;
            rotateSpeed = 1f;
            flying = true;
            lowAltitude = true;
            health = 22000;
            engineOffset = 38;
            engineSize = 7.3f;
            hitSize = 58f;
            armor = 13f;
            constructor = eclipse.constructor;
            targetFlags = new BlockFlag[]{BlockFlag.reactor, BlockFlag.battery, BlockFlag.core, null};
            //ammoType = new ItemAmmoType(Items.thorium);

            BulletType fragBullet = new FlakBulletType(4f, 15) {{
                shootEffect = Fx.shootBig;
                ammoMultiplier = 4f;
                splashDamage = 65f;
                splashDamageRadius = 25f;
                collidesGround = true;
                lifetime = 47f;

                status = StatusEffects.blasted;
                statusDuration = 60f;
            }};

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
                            length = 230f;
                            shootEffect = Fx.shockwave;
                            colors = new Color[]{Color.valueOf("ec7458aa"), Color.valueOf("ff9c5a"), Color.white};
                        }};
                    }},
                    new Weapon("large-artillery") {{
                        x = 11f;
                        y = 27f;
                        rotateSpeed = 2f;
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
                        ejectEffect = Fx.casing1;
                        rotateSpeed = 7f;
                        shake = 1f;
                        shootSound = Sounds.shoot;
                        rotate = true;
                        shadow = 12f;
                        shootY = 7.25f;
                        bullet = fragBullet;
                    }});
            abilities.add(new SpawnDeathAbility(new UnitType("antumbra2") {{
                constructor = antumbra.constructor;
                speed = 0.8f;
                accel = 0.04f;
                drag = 0.04f;
                rotateSpeed = 1.9f;
                flying = true;
                lowAltitude = true;
                health = 7200;
                armor = 9f;
                engineOffset = 21;
                engineSize = 5.3f;
                hitSize = 46f;
                targetFlags = new BlockFlag[]{BlockFlag.generator, BlockFlag.core, null};
                // ammoType = new ItemAmmoType(Items.thorium);

                BulletType missiles = new MissileBulletType(2.7f, 18) {{
                    width = 8f;
                    height = 8f;
                    shrinkY = 0f;
                    drag = -0.01f;
                    splashDamageRadius = 20f;
                    splashDamage = 37f;
                    ammoMultiplier = 4f;
                    lifetime = 50f;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;

                    status = StatusEffects.blasted;
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
                            bullet = new BasicBulletType(7f, 55) {{
                                width = 12f;
                                height = 18f;
                                lifetime = 25f;
                                shootEffect = Fx.shootBig;
                            }};
                        }}
                );
            }}, 1, 8));
        }};
    }

}
