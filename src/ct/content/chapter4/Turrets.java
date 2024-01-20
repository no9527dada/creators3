package ct.content.chapter4;

import arc.graphics.Color;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.struct.Seq;
import ct.Asystem.type.CTBulletTypes;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.Units;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.Bullet;
import mindustry.gen.Healthc;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.meta.BuildVisibility;


import static ct.Asystem.type.CTBulletTypes.*;
import static ct.content.chapter4.CTItem.*;

import static mindustry.content.Fx.none;
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
        new PowerTurret("ct"){{
            Color TU浅绿色 = Color.valueOf("acff9a");
            requirements(Category.turret, with(Items.copper, 60, Items.lead, 70, Items.silicon, 60, Items.titanium, 30));
            range = 25 * 8;
            recoil = 2f;
            reload = 30f;
            shake = 2f;
            shootEffect = none;
            smokeEffect = none;
            size = 2;
            scaledHealth = 280;
            targetAir = false;
            moveWhileCharging = false;
            accurateDelay = false;
            shootSound = Sounds.laser;
            coolant = consumeCoolant(0.2f);

            consumePower(6f);

            //上面炮塔数据随意
            //下面子弹数据自己改
            float cont = 30/2f;//扩散角度，1/2值，60 = 120
            float bRange = range;//范围
            shootType = new BulletType(){{
                damage = 100;
                lifetime = 120;
                speed = 0;
                keepVelocity = false;
                despawnEffect = hitEffect = none;

                hittable = absorbable = reflectable = false;
            }

                @Override
                public void update(Bullet b) {



                    //super.update(b);
                    Seq<Healthc> seq = new Seq<>();
                   // float r = bRange * (1 - b.foutpow());
                    float r = bRange * (b.fin());
                    Vars.indexer.allBuildings(b.x, b.y, r, bd -> {
                        if (bd.team != b.team && Angles.within(b.rotation(), b.angleTo(bd), cont)) seq.addUnique(bd);
                    });
                    Units.nearbyEnemies(b.team, b.x - r, b.y - r, r * 2, r * 2, u -> {
                        if (u.type != null && u.type.targetable && b.within(u, r) && Angles.within(b.rotation(), b.angleTo(u), cont))
                            seq.addUnique(u);
                    });
                    for (int i = 0; i < seq.size; i++) {
                        Healthc hc = seq.get(i);
                        if (hc != null && !hc.dead()) {
                            if (!b.hasCollided(hc.id())) {
                                //伤害的方式在这里改

                                //普攻
                                hc.damage(damage);

                                //穿甲
                                //hc.damagePierce(damage);

                                //真伤
                                //if(hc.health() <= damage) hc.kill();
                                //else hc.health(hc.health() - damage);
                                b.collided.add(hc.id());
                            }
                        }
                    }
                }
                  float dx(float px, float r, float angel){
                    return px + r * (float) Math.cos(angel * Math.PI/180);
                }

                  float dy(float py, float r, float angel){
                    return py + r * (float) Math.sin(angel * Math.PI/180);
                }
                @Override
                public void draw(Bullet b) {

                    super.draw(b);
                    //float pin = (1 - b.foutpow());
                    float pin = (b.fin());
                    Lines.stroke(3 , Color.valueOf("acff9a"));

                    for(float i = b.rotation() - cont; i < b.rotation() + cont; i++){
                        float lx = dx(b.x, bRange * pin, i);
                        float ly = dy(b.y, bRange * pin, i);
                       // Lines.lineAngle(lx, ly, i, bRange/cont*pin);
                        Lines.lineAngle(lx, ly, i-90, bRange/(cont*2)*pin);
                        Lines.lineAngle(lx, ly, i+90, bRange/(cont*2)*pin);

                    }
                }
            };
        }};


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
