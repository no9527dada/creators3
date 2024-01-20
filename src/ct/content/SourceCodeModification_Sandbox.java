package ct.content;

import arc.Core;
import arc.graphics.Color;
import ct.Asystem.type.XVXSource;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Planets;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.payloads.PayloadSource;
import mindustry.world.blocks.payloads.PayloadVoid;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.meta.BuildVisibility;


import static ct.content.Item0.erekir隐藏Items;
import static ct.content.Item0.serpulo隐藏Items;
import static ct.content.chapter1.Item1.物品;
import static mindustry.type.ItemStack.with;

public class SourceCodeModification_Sandbox {
    public static void load() {

        Planets.erekir.hiddenItems.addAll(erekir隐藏Items).removeAll(Items.erekirItems);
        Planets.serpulo.hiddenItems.addAll(serpulo隐藏Items).removeAll(Items.serpuloItems);

 /*      Blocks.powerSource.envDisabled = Evn2.标志1 | Env.terrestrial;
        Blocks. powerVoid.envDisabled = Evn2.标志1 | Env.terrestrial;
        Blocks. itemSource.envDisabled = Evn2.标志1 | Env.terrestrial;
        Blocks.  itemVoid.envDisabled = Evn2.标志1 | Env.terrestrial;
        Blocks.  liquidSource.envDisabled = Evn2.标志1 | Env.terrestrial;
        Blocks.    liquidVoid.envDisabled = Evn2.标志1 | Env.terrestrial;*/


        //沙盒全能物品源
        new XVXSource("Automatic-adaptation-source") {
            {
                this.requirements(Category.distribution, BuildVisibility.sandboxOnly, ItemStack.with(new Object[0]));
                this.alwaysUnlocked = true;
                this.localizedName = "沙盒源";
            }
        };

        //沙盒炮
        new PowerTurret("SandboxTurret") {
            {
                localizedName = Core.bundle.get("Turret.SandboxTurret");
                description = Core.bundle.getOrNull("Turret.description.SandboxTurret");
                requirements(Category.turret, with(物品, 0));
                targetable = false;//被单位攻击？
                canOverdrive = false;//超速
                shootType = new BasicBulletType(9f, 20) {{
                    width = 9f;
                    height = 12f;
                    reloadMultiplier = 1.3f;
                    damage = 9527;
                    lifetime = 70f;
                    ammoMultiplier = 1;
                    trailColor = Color.valueOf("f1cc68");
                    trailParam = 5;
                    trailLength = 8;
                    trailWidth = 5;
                    trailInterval = 10;
                    trailChance = 1;
                    trailRotation = true;
                    trailEffect = Fx.none;
                    homingRange = 3 * 8f;//追踪范围 跟踪
                    homingPower = 0.3f; //追踪
                    homingDelay = 0;
                    splashDamageRadius = 2f * 8f;
                    splashDamage = Float.POSITIVE_INFINITY;

                }};
                reload = 20f;
                range = 70 * 8;
                armor = 114154f;
                shootCone = 365f;
                ammoUseEffect = Fx.casing1;
                health = 909130592;
                inaccuracy = 1f; //精准
                rotateSpeed = 30f;//炮塔旋转速度
                buildVisibility = BuildVisibility.sandboxOnly;
                buildType = Build::new;
            }

            class Build extends PowerTurret.PowerTurretBuild {
                @Override
                public void damage(float damage) {
                }
            }
        };

        //沙盒无敌墙
        new Wall("SandboxWall") {
            {
                localizedName = Core.bundle.get("Wall.SandboxWall");
                description = Core.bundle.getOrNull("Wall.description.SandboxWall");
                health = 100000;
                size = 2;
                targetable = false;//被单位攻击？
                requirements(Category.defense, with(
                        物品, 0
                ));
                buildType = Build::new;
            }

            class Build extends Wall.WallBuild {
                @Override
                public void damage(float damage) {
                }
            }
        };


        new PowerSource("power-source") {{
            requirements(Category.power, BuildVisibility.sandboxOnly, with(物品, 0));
            powerProduction = 9000000f / 60f;
            laserRange = 30;
            maxNodes = 100;
            alwaysUnlocked = true;
        }};

        new PowerVoid("power-void") {{
            requirements(Category.power, BuildVisibility.sandboxOnly, with(物品, 0));
            alwaysUnlocked = true;
        }};

        new ItemSource("item-source") {{
            requirements(Category.distribution, BuildVisibility.sandboxOnly, with(物品, 0));
            alwaysUnlocked = true;
            itemsPerSecond = 1000;
        }};

        new ItemVoid("item-void") {{
            requirements(Category.distribution, BuildVisibility.sandboxOnly, with(物品, 0));
            alwaysUnlocked = true;
        }};

        new LiquidSource("liquid-source") {{
            requirements(Category.liquid, BuildVisibility.sandboxOnly, with(物品, 0));
            alwaysUnlocked = true;
        }};

        new LiquidVoid("liquid-void") {{
            requirements(Category.liquid, BuildVisibility.sandboxOnly, with(物品, 0));
            alwaysUnlocked = true;
        }};

        new PayloadSource("payload-source") {{
            requirements(Category.units, BuildVisibility.sandboxOnly, with(物品, 0));
            size = 5;
            alwaysUnlocked = true;
        }};

        new PayloadVoid("payload-void") {{
            requirements(Category.units, BuildVisibility.sandboxOnly, with(物品, 0));
            size = 5;
            alwaysUnlocked = true;
        }};
    }
}
