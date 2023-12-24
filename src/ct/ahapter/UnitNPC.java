package ct.ahapter;

import arc.Core;
import arc.graphics.Color;
import ct.abe.CTRepairBeamWeapon;
import ct.ahapter.lib;
import mindustry.ai.UnitCommand;
import mindustry.ai.types.BuilderAI;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.abilities.RepairFieldAbility;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.LaserBoltBulletType;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.weapons.RepairBeamWeapon;

public class UnitNPC {

    public static UnitType 珮思思0, 探子, 珮思思1, 珮思思2, 鹿恒1;

    public static void load() {
        //昏迷珮思思
        珮思思0 = new lib.CTRUnitTypeNpc("珮思思0", "gamma") {{
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
        探子 = new lib.CTRUnitType("探子", "flare") {{
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
        珮思思1 = new lib.CTRUnitTypeNpc("珮思思1", "gamma") {{
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
        珮思思2 = new lib.CTRUnitTypeNpc("珮思思2", "gamma") {{
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
            lightRadius = 30*8;
            lightOpacity = 0.7f;
            lightColor = Color.valueOf("e46ef5");
        }};
        鹿恒1 = new lib.CTRUnitTypeNpc("鹿恒1", "flare") {{
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
    }
}
