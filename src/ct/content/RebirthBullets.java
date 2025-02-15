package ct.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Mathf;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.Effect;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.graphics.Pal;

import static CtCoreSystem.content.Effect.NewFx.赤狐trailEffect;
import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.lineAngle;
import static arc.math.Angles.randLenVectors;
import static arc.math.Interp.circleOut;
import static ct.content.RebirthItem.*;
import static mindustry.content.Fx.none;

public class RebirthBullets {
    public static BulletType 陶月牙, 翠月牙, 运符月牙;
    public static BulletType 运符墨雪, 幻烬墨雪, 灵玉墨雪, 缕墨雪;
    public static BulletType Bullet刺镰;
    public static BulletType 缕赤狐, 幻烬赤狐, 灵玉赤狐, 威灵赤狐, 血晶赤狐;

    public static void load() {
        陶月牙 = new BasicBulletType(2.5f, 10, "ct-yueya") {{
            width = 5f;
            height = 5f;
            lifetime = 60f;
            ammoMultiplier = 1;//子弹装填倍率
            spin = 20;
            shrinkY = 0;
            shrinkX = 0;
            //pierce = true; //穿透
            backColor = Color.valueOf("ffffff"); //背景颜色
            frontColor = 陶.color;//Color.valueOf("cba1ff"); //前面颜色
            fragBullet = new BasicBulletType(2.5f, 10, "ct-yueya")//分裂的子弹
            {{
                width = 5f;
                height = 5f;
                lifetime = 45f;
                spin = 20;
                shrinkY = 0;
                shrinkX = 0;
                backColor = Color.valueOf("ffffff"); //背景颜色
                frontColor = 陶.color; //前面颜色
                pierce = true;
                despawnEffect = Fx.none;
            }};
            fragBullets = 1;//分裂的数量
            fragRandomSpread = 0f;//分裂的角度
            fragAngle = 180f;//分裂的角度偏移，一般角度(上一个接口)越小越容易看出来
            fragVelocityMin = 1f;//随机范围的破片速度最小0。
            fragVelocityMax = 1f;//随机范围的破片速度最大1。
            fragLifeMin = 1f;//随机范围的碎片寿命作为乘数最小0
            fragLifeMax = 1f;//随机范围的碎片寿命作为乘数最大1。
            despawnEffect = Fx.none;
            hitEffect = Fx.none;
        }};
        翠月牙 = new BasicBulletType(2.5f, 10, "ct-yueya") {{
            width = 5f;
            height = 5f;
            lifetime = 60f;
            ammoMultiplier = 1;//子弹装填倍率
            spin = 20;
            shrinkY = 0;
            shrinkX = 0;
            pierce = true; //穿透
            backColor = Color.valueOf("ffffff"); //背景颜色
            frontColor = 翠.color;//Color.valueOf("cba1ff"); //前面颜色
            fragBullet = new BasicBulletType(2.5f, 10, "ct-yueya")//分裂的子弹
            {{
                width = 5f;
                height = 5f;
                lifetime = 45f;
                spin = 20;
                shrinkY = 0;
                shrinkX = 0;
                backColor = Color.valueOf("ffffff"); //背景颜色
                frontColor = 翠.color; //前面颜色
                pierce = true;
                despawnEffect = Fx.none;
            }};
            fragBullets = 1;//分裂的数量
            fragRandomSpread = 0f;//分裂的角度
            fragAngle = 180f;//分裂的角度偏移，一般角度(上一个接口)越小越容易看出来
            fragVelocityMin = 1f;//随机范围的破片速度最小0。
            fragVelocityMax = 1f;//随机范围的破片速度最大1。
            fragLifeMin = 1f;//随机范围的碎片寿命作为乘数最小0
            fragLifeMax = 1f;//随机范围的碎片寿命作为乘数最大1。
            despawnEffect = Fx.none;
            hitEffect = Fx.none;
        }};
        运符月牙 = new BasicBulletType(2.5f, 17, "ct-yueya") {{
            width = 7f;
            height = 7f;
            lifetime = 60f;
            ammoMultiplier = 1;//子弹装填倍率
            spin = 20;
            shrinkY = 0;
            shrinkX = 0;
            // pierce = true; //穿透  打到敌人就回来，不穿透
            backColor = Color.valueOf("ffffff"); //背景颜色
            frontColor = 运符.color;//Color.valueOf("cba1ff"); //前面颜色
            fragBullet = new BasicBulletType(2.5f, 17, "ct-yueya")//分裂的子弹
            {{
                width = 5f;
                height = 5f;
                lifetime = 45f;
                spin = 20;
                shrinkY = 0;
                shrinkX = 0;
                backColor = Color.valueOf("ffffff"); //背景颜色
                frontColor = 翠.color; //前面颜色
                pierce = true;
                despawnEffect = Fx.none;
            }};
            fragBullets = 1;//分裂的数量
            fragRandomSpread = 0f;//分裂的角度
            fragAngle = 180f;//分裂的角度偏移，一般角度(上一个接口)越小越容易看出来
            fragVelocityMin = 1f;//随机范围的破片速度最小0。
            fragVelocityMax = 1f;//随机范围的破片速度最大1。
            fragLifeMin = 1f;//随机范围的碎片寿命作为乘数最小0
            fragLifeMax = 1f;//随机范围的碎片寿命作为乘数最大1。
            despawnEffect = Fx.none;
            hitEffect = Fx.none;
        }};
        幻烬墨雪 = new BasicBulletType(3.5f, 20) {{
            width = 9f;
            height = 12f;
            reloadMultiplier = 1.3f;
            pierce = true;
            pierceCap = 2;
            lifetime = 60f;
            ammoMultiplier = 4;
            trailColor = 幻烬.color;
            trailParam = 5;
            trailLength = 8;
            trailWidth = 5;
            trailInterval = 10;
            trailChance = 1;
            trailRotation = true;
            trailEffect = Fx.none;
        }};
        运符墨雪 = new BasicBulletType(4f, 25, "bullet") {{
            width = 10f;
            height = 13f;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            pierce = true;
            pierceCap = 2;
            lifetime = 60f;
            ammoMultiplier = 2;
            trailColor = 运符.color;
            trailParam = 5;
            trailLength = 8;
            trailWidth = 2;
            trailInterval = 10;
            trailChance = 1;
            trailRotation = true;
            trailEffect = Fx.none;
        }};
        灵玉墨雪 = new BasicBulletType(4f, 40, "bullet") {{
            width = 10f;
            height = 13f;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            ammoMultiplier = 4;
            lifetime = 60f;
            reloadMultiplier = 1.2f; //装弹速度
            trailColor = 灵玉.color;
            trailParam = 5;
            trailLength = 8;
            trailWidth = 2;
            trailInterval = 10;
            trailChance = 1;
            trailRotation = true;
            trailEffect = Fx.none;
            pierce = true;
            pierceCap = 3;

        }};
        缕墨雪 = new BasicBulletType(4f, 30, "bullet") {{
            width = 10f;
            height = 13f;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            ammoMultiplier = 2;
            lifetime = 60f;
            reloadMultiplier = 1.5f; //装弹速度
            trailColor = 缕.color;
            trailParam = 5;
            trailLength = 8;
            trailWidth = 2;
            trailInterval = 10;
            trailChance = 1;
            trailRotation = true;
            trailEffect = Fx.none;
            pierce = true;
            pierceCap = 2;
        }};
        Bullet刺镰 = new LaserBulletType(55) {{
            Color Bullet刺镰颜色 = Color.valueOf("abffa9");
            colors = new Color[]{Bullet刺镰颜色.cpy().a(0.4f), Bullet刺镰颜色, Color.white};
            //TODO merge
            chargeEffect = new MultiEffect(
                    new Effect(38f, e -> {
                        color(Bullet刺镰颜色);

                        randLenVectors(e.id, 14, 1f + 20f * e.fout(), e.rotation, 120f, (x, y) -> {
                            lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), e.fslope() * 3f + 1f);
                        });
                    }),
                    new Effect(60f, e -> {
                        float margin = 1f - Mathf.curve(e.fin(), 0.9f);
                        float fin = Math.min(margin, e.fin());

                        color(Bullet刺镰颜色);
                        Fill.circle(e.x, e.y, fin * 3f);

                        color();
                        Fill.circle(e.x, e.y, fin * 2f);
                    }));

            //buildingDamageMultiplier = 0.25f;
            hitEffect = Fx.hitLancer;
            hitSize = 4;
            lifetime = 16f;
            drawSize = 400f;
            collidesAir = false;
            length = 150;
            ammoMultiplier = 1f;
            pierce = true;
            pierceCap = 6;
        }};

        缕赤狐 = new ArtilleryBulletType(3f, 1) {{
            hitEffect = Fx.blastExplosion;
            hitColor = 缕.color;
            trailEffect = 赤狐trailEffect(缕.color);
            frontColor = 缕.color;//Color.valueOf("f8ad42");
            backColor = Color.valueOf("1e74a5");
            knockback = 1.8f;//击退
            lifetime = 100f;
            width = height = 13f;
            collidesTiles = false;
            splashDamageRadius = 25f * 0.75f;
            splashDamage = 35f;
            reloadMultiplier = 1f;//攻速
            ammoMultiplier = 2f;//弹药效率
        }};
        幻烬赤狐 = new ArtilleryBulletType(3f, 1) {{
            hitColor = 幻烬.color;
            hitEffect = Fx.blastExplosion;
            trailEffect = 赤狐trailEffect(幻烬.color);
            frontColor = Pal.lightishOrange;
            backColor = Pal.lightOrange;
            homingPower = 0.08f;//追踪精度
            homingRange = 50f;//追踪范围
            lifetime = 80f;
            width = height = 13f;
            collidesTiles = false;
            splashDamageRadius = 3.5f * 8f;
            splashDamage = 35f;
            reloadMultiplier = 1.5f;//攻速
            ammoMultiplier = 2f;//弹药效率
        }};
        灵玉赤狐 = new ArtilleryBulletType(3f, 1) {{
            hitColor = 灵玉.color;
            hitEffect = Fx.blastExplosion;

            trailEffect = 赤狐trailEffect(灵玉.color);
            frontColor = Pal.lightishOrange;
            backColor = Pal.lightOrange;
            knockback = 2.8f;//击退
            lifetime = 80f;
            width = height = 13f;
            collidesTiles = false;
            splashDamageRadius = 3.5f * 8f;
            splashDamage = 55f;
            reloadMultiplier = 1.2f;//攻速
            ammoMultiplier = 2f;//弹药效率

            status = StatusEffects.burning;
            statusDuration = 60f * 5f;
        }};
        血晶赤狐 = new ArtilleryBulletType(3f, 1) {{
            hitColor = 血晶.color;
            hitEffect = Fx.blastExplosion;

            trailEffect = 赤狐trailEffect(血晶.color);
            frontColor = Pal.lightishOrange;
            backColor = Pal.lightOrange;
            knockback = 2.8f;//击退
            homingPower = 0.08f;//追踪精度
            homingRange = 50f;//追踪范围
            lifetime = 80f;
            width = height = 13f;
            collidesTiles = false;
            splashDamageRadius = 3.5f * 8f;
            splashDamage = 80f;
            reloadMultiplier = 1.2f;//攻速
            ammoMultiplier = 3f;//弹药效率

            status = StatusEffects.burning;
            statusDuration = 60f * 5f;
        }};
        威灵赤狐 = new ArtilleryBulletType(3f, 1) {{
            hitColor = 威灵.color;
            hitEffect = Fx.blastExplosion;
            trailEffect = 赤狐trailEffect(威灵.color);
            frontColor = Pal.lightishOrange;
            backColor = Pal.lightOrange;
            knockback = 2.8f;//击退
            homingPower = 0.08f;//追踪精度
            homingRange = 50f;//追踪范围
            lifetime = 80f;
            width = height = 13f;
            collidesTiles = false;
            splashDamageRadius = 3.5f * 8f;
            splashDamage = 85f;
            reloadMultiplier = 1.8f;//弹药射速
            status = StatusEffects.burning;
            statusDuration = 60f * 10f;
            ammoMultiplier = 4f;//弹药效率


        }};

    }

    public static class 冰蜂Bullet extends BasicBulletType {
        public 冰蜂Bullet(float lifetimee, float damagee, float speedd, float 射速, float 倍率, Color 颜色) {
            sprite = "ctcoresystem-子弹1";
            lifetime = lifetimee;
            damage = damagee;
            speed = speedd;
            width = 8;
            height = 15;
            //蓄力射击开始时产生的效果;仅适用于具有 firstShotDelay / shotDelay 的单发武器。
            chargeEffect = Fx.none;
            //  smokeEffect = shootSmallSmoke;//发射时产生额外的烟雾效果。
            ammoMultiplier = 倍率;
            reloadMultiplier = 射速;
            trailColor = 颜色;
            trailParam = 2;
            trailLength = 8;
            trailWidth = 2;
            trailEffect = none;
            shrinkY = shrinkX = splashDamage = 0;//范围伤害
            splashDamageRadius = 0;//范围伤害的范围
            collidesAir = true;//对空
            collidesGround = false;//对地
            //   pierceBuilding =
            pierce = true;//双穿
            pierceCap = 3;
            // pierceDamageFactor = 0.15f;
            homingRange = 20 * 8f;//追踪范围
            homingPower = 0.3f; //追踪力度
            homingDelay = 10;//追踪延迟*/
            frontColor = backColor = 颜色;
            shootEffect = new MultiEffect() {{
                effects = new Effect[]{
                        new ParticleEffect() {{
                            line = true;
                            particles = 5;
                            cone = 10;
                            lifetime = 30;
                            length = 75;
                            lenFrom = 8;
                            lenTo = 0;
                            colorFrom = 颜色;
                            // colorTo= C("66B1FFFF");
                        }},
                        new ParticleEffect() {{
                            particles = 6;
                            length = 40;
                            cone = 10;
                            lifetime = 56;
                            interp = circleOut;
                            sizeFrom = 3.5F;
                            sizeTo = 0;
                            colorFrom = 颜色;
                        }},
                };
            }};
                 /*子弹消失时的效果，可能和hitEffect有些相似。
            不同的是这个效果只会显示一次，如果是hitEffect可能会在多个目标上显示，比如子弹贯穿多个单位或建筑*/

            /*击中效果*/
            hitEffect = new Effect(22.0F, (e) -> {
                Draw.color(颜色);
                e.scaled(15.0F, (i) -> {
                    Lines.stroke(3.0F * i.fout());
                    Lines.circle(e.x, e.y, 3.0F + i.fin() * 10.0F);
                });

            });
            /*落地效果*/
            despawnEffect = new MultiEffect(
                    new Effect(22.0F, (e) -> {
                        Draw.color(颜色);
                        e.scaled(15, (i) -> {
                            Lines.stroke(3.0F * i.fout());
                            Lines.circle(e.x, e.y, 10.0F + i.fin() * 15.0F);
                        });
                    }),
                    new Effect(30, (e) -> {
                        Draw.color(颜色);
                        Angles.randLenVectors(e.id, e.fin(), 3, 9.0F, (x, y, fin, fout) -> {
                            Fill.circle(e.x + x, e.y + y, 17.0F * fout);
                        });
                    })
            );


        }
    }
};
