package ct.abe.rebirth.content;

import arc.graphics.Color;
import arc.graphics.g2d.Fill;
import arc.math.Mathf;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.Effect;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.graphics.Pal;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.lineAngle;
import static arc.math.Angles.randLenVectors;
import static ct.abe.rebirth.content.Items.*;
public class Bullets {
    public static BulletType 陶月牙, 翠月牙, 运符月牙;
    public static BulletType 运符墨雪, 幻烬墨雪, 灵玉墨雪, 缕墨雪;
    public static BulletType Bullet刺镰;
    public static BulletType 缕赤狐,幻烬赤狐,灵玉赤狐,威灵赤狐,血晶赤狐;

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
            length = 190f;
            ammoMultiplier = 1f;
            pierce = true;
            // pierceCap = 4;
        }};
        缕赤狐 = new ArtilleryBulletType(3f, 1) {{
            hitEffect = Fx.blastExplosion;
            hitColor=缕.color;
            trailEffect = Fx.incendTrail;
            trailColor=缕.color;
             frontColor =  缕.color;//Color.valueOf("f8ad42");
            backColor =  Color.valueOf("1e74a5");


            knockback = 1.8f;//击退

            lifetime = 80f;
            width = height = 13f;
            collidesTiles = false;
            splashDamageRadius = 25f * 0.75f;
            splashDamage = 35f;
             reloadMultiplier = 1f;//攻速
            ammoMultiplier = 2f;//弹药效率
        }};
        幻烬赤狐 = new ArtilleryBulletType(3f, 1) {{
            hitColor=幻烬.color;
            hitEffect = Fx.blastExplosion;
            trailColor=幻烬.color;
            trailEffect = Fx.incendTrail;
            frontColor = Pal.lightishOrange;
            backColor = Pal.lightOrange;

            homingPower = 0.08f;//追踪精度
            homingRange = 50f;//追踪范围


            lifetime = 80f;
            width = height = 13f;
            collidesTiles = false;
            splashDamageRadius = 25f * 0.75f;
            splashDamage = 35f;
            reloadMultiplier = 1.5f;//攻速
            ammoMultiplier = 2f;//弹药效率
        }};
        灵玉赤狐= new ArtilleryBulletType(3f, 1) {{
            hitColor=灵玉.color;
            hitEffect = Fx.blastExplosion;
            trailColor=灵玉.color;
            trailEffect = Fx.incendTrail;
            frontColor = Pal.lightishOrange;
            backColor = Pal.lightOrange;

            knockback = 2.8f;//击退

            lifetime = 80f;
            width = height = 13f;
            collidesTiles = false;
            splashDamageRadius = 25f * 0.75f;
            splashDamage = 55f;
            reloadMultiplier = 1.2f;//攻速
            ammoMultiplier = 2f;//弹药效率

            status = StatusEffects.burning;
            statusDuration = 60f * 5f;
        }};
        血晶赤狐= new ArtilleryBulletType(3f, 1) {{
            hitColor=血晶.color;
            hitEffect = Fx.blastExplosion;
            trailColor=血晶.color;
            trailEffect = Fx.incendTrail;
            frontColor = Pal.lightishOrange;
            backColor = Pal.lightOrange;
            knockback = 2.8f;//击退
            homingPower = 0.08f;//追踪精度
            homingRange = 50f;//追踪范围
            lifetime = 80f;
            width = height = 13f;
            collidesTiles = false;
            splashDamageRadius = 25f * 0.75f;
            splashDamage = 80f;
            reloadMultiplier = 1.2f;//攻速
            ammoMultiplier = 2f;//弹药效率

            status = StatusEffects.burning;
            statusDuration = 60f * 5f;
        }};
        威灵赤狐 = new ArtilleryBulletType(3f, 1) {{
            hitColor=明宝.color;
            hitEffect = Fx.blastExplosion;
            trailColor=明宝.color;
            trailEffect = Fx.incendTrail;
            frontColor = Pal.lightishOrange;
            backColor = Pal.lightOrange;

            knockback = 2.8f;//击退
            homingPower = 0.08f;//追踪精度
            homingRange = 50f;//追踪范围

            lifetime = 80f;
            width = height = 13f;
            collidesTiles = false;
            splashDamageRadius = 25f * 0.75f;
            splashDamage = 85f;
            reloadMultiplier = 1.8f;//弹药效率
            status = StatusEffects.burning;
            statusDuration = 60f * 10f;


        }};
    }
};
