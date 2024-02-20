package ct.content.chapter1;

import arc.Core;
import arc.graphics.Color;
import ct.Asystem.type.CT3UnitType;
import ct.Asystem.type.CTRepairBeamWeapon;
import mindustry.ai.UnitCommand;
import mindustry.ai.types.BuilderAI;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.abilities.RepairFieldAbility;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class UnitNPC {

    public static UnitType 珮思思0, 探子, 珮思思1, 珮思思2, 鹿恒1;
    public static UnitType 第9关BSS;

    public static void load() {
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
        //UnitNPC.探子.speed=3
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
            engineColor = Color.valueOf("e46ef5");//蓝色尾焰
            //mineRange = 18*8f;//采矿范围
            // canAttack = false;//关闭单位的武器,功能性单位
            abilities.add(new RepairFieldAbility(200f, 60f * 2, 5 * 8f));
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
            abilities.add(new RepairFieldAbility(200f, 60f * 2, 5 * 8f));
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

    }
}
