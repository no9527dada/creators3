package ct.content.Bullets;

import arc.graphics.Color;
import arc.graphics.g2d.Fill;
import arc.math.Interp;
import ct.content.Effect.CT3FxEffect;
import ct.content.NewColor;
import ct.content.Effect.NewEffect;
import ct.content.Effect.NewFx;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.Effect;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.ExplosionEffect;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.part.HaloPart;
import mindustry.gen.Sounds;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;

import static arc.graphics.g2d.Draw.color;
import static ct.Asystem.CT3Sound.loadSound;
import static ct.content.NewColor.*;
import static mindustry.content.Fx.*;
import static mindustry.gen.Sounds.laser;
import static mindustry.gen.Sounds.plasmaboom;

public class Bullets5 {
    //如果要要写个贴图 用string xxx
    //drag=0.014; 子弹会有一个有快变慢的过程
    //homingRange = 3 * 8//追踪范围
    //homingPower = 0.3 //追踪力度
    //homingDelay = 0;//追踪延迟
    //fragVelocityMin = 0.2f;//破片力度最小值
    // fragVelocityMax = 1f;//破片力度最大值
    //knockback = 3;//击退
    //targetAir = true; //空 炮塔
    //targetGround = false; //地 炮塔

    // collidesAir = collidesGround = true;//对空对地 子弹
    public static class 制裁Bullet extends BasicBulletType {
        public 制裁Bullet(float lifetimee, float damagee, float speedd) {
            // super();
            lifetime = lifetimee;
            damage = damagee;
            speed = speedd;
            width = 15;
            height = 15;
            shootEffect = shootBig;
            smokeEffect = shootSmallSmoke;
            ammoMultiplier = 5;
            pierce = true;
            trailColor = NewColor.制裁Bullet颜色;
            trailParam = 2;
            trailLength = 5;
            trailWidth = 2;
            trailEffect = none;

            //子弹命中目标的效果
            hitEffect = Fx.hitBulletSmall;

            /*子弹消失时的效果，可能和hitEffect有些相似。
            不同的是这个效果只会显示一次，如果是hitEffect可能会在多个目标上显示，比如子弹贯穿多个单位或建筑*/
            despawnEffect = NewFx.制裁子弹消失;
            splashDamage = 0;//范围伤害
            splashDamageRadius = 0;//范围伤害的范围
            collidesAir = collidesGround = true;//对空对地
        }
    }

    public static class 灭亡Bullet extends BasicBulletType {
        public 灭亡Bullet(float lifetimee, float damagee, float speedd, float 射速, float 倍率) {
            lifetime = lifetimee;
            damage = damagee;
            speed = speedd;
            width = 17;
            height = 23;
            //蓄力射击开始时产生的效果;仅适用于具有 firstShotDelay / shotDelay 的单发武器。
            chargeEffect = Fx.none;
            shootEffect = shootBig;//发射的炮口产生的特效
            smokeEffect = shootSmallSmoke;//发射时产生额外的烟雾效果。
            ammoMultiplier = 倍率;
            reloadMultiplier = 射速;
            trailColor = NewColor.灭亡Bullet颜色;
            trailParam = 2;
            trailLength = 8;
            trailWidth = 3;
            trailEffect = none;
            /*子弹消失时的效果，可能和hitEffect有些相似。
            不同的是这个效果只会显示一次，如果是hitEffect可能会在多个目标上显示，比如子弹贯穿多个单位或建筑*/
            despawnEffect = NewFx.灭亡子弹消失;
            splashDamage = 0;//范围伤害
            splashDamageRadius = 0;//范围伤害的范围
            collidesAir = collidesGround = true;//对空对地
        }
    }

    public static class 毁灭Bullet extends BasicBulletType {
        public 毁灭Bullet(float lifetimee, float damagee, float speedd, float 射速, float 倍率) {
            // super();
            lifetime = lifetimee;
            damage = 0;
            speed = speedd;
            sprite = "ct-round";
            width = 24;
            height = 33;
            ammoMultiplier = 倍率;
            reloadMultiplier = 射速;
            shootEffect = shootBig;
            smokeEffect = shootSmallSmoke;
            //pierce = true;
            trailColor = NewColor.毁灭Bullet颜色;
            trailParam = 2;
            trailLength = 18;
            trailWidth = 8;
            trailRotation = true;
            trailEffect = new Effect(16f, e -> {
                color(Pal.orangeSpark);
                Drawf.tri(e.x, e.y, 40, 5, e.rotation + 180); //e.rotation + 180
            });
            trailInterval = 3f;
            trailChance = 0.3f;
            splashDamage = damagee;//范围伤害
            splashDamageRadius = 8 * 8;//范围伤害的范围
            collidesAir = collidesGround = true;//对空对地
                       /*子弹消失时的效果，可能和hitEffect有些相似。
            不同的是这个效果只会显示一次，如果是hitEffect可能会在多个目标上显示，比如子弹贯穿多个单位或建筑*/
            despawnEffect = NewFx.毁灭despawnEffect(); //NewFx.制裁子弹消失;

            //蓄力射击开始时产生的效果;仅适用于具有 firstShotDelay / shotDelay 的单发武器。
            chargeEffect = none;
        }
    }

    public static class 散射炮Bullet extends BasicBulletType {
        public 散射炮Bullet(float lifetimee, float damagee, float speedd, float 射速, float 倍率) {
            // super();
            lifetime = lifetimee;
            damage = damagee * 3 / 4;
            speed = speedd;

            width = 10;
            height = 13;
            ammoMultiplier = 倍率;
            reloadMultiplier = 射速;
            shootEffect = shootBig;
            smokeEffect = shootSmallSmoke;
            //pierce = true;
            trailColor = NewColor.毁灭Bullet颜色;
            trailParam = 2;
            trailLength = 50;
            trailWidth = 2;
            trailEffect = none;
            // trailInterval=3f;
            //trailChance = 0.3f;
            splashDamage = damagee * 3;//范围伤害,负值禁用
            splashDamageRadius = 4.5f * 8;//范围伤害的范围
            collidesAir = collidesGround = true;//对空对地
                       /*子弹消失时的效果，可能和hitEffect有些相似。
            不同的是这个效果只会显示一次，如果是hitEffect可能会在多个目标上显示，比如子弹贯穿多个单位或建筑*/
            despawnEffect = Fx.hitBulletSmall; //NewFx.制裁子弹消失;

            //蓄力射击开始时产生的效果;仅适用于具有 firstShotDelay / shotDelay 的单发武器。
            chargeEffect = none;
        }
    }

    public static class 追动Bullet extends BasicBulletType {
        public 追动Bullet(float lifetimee, float damagee, float speedd, float 射速, float 倍率) {
            // super();
            sprite = "missile";
            lifetime = lifetimee;
            damage = damagee;
            speed = speedd;
            // sprite=   "ct-round";
            width = 12;
            height = 15;
            ammoMultiplier = 倍率;
            reloadMultiplier = 射速;
            shootEffect = shootBig;
            smokeEffect = shootSmallSmoke;
            //pierce = true;
            trailColor = NewColor.毁灭Bullet颜色;
            trailParam = 2;
            trailLength = 3;
            trailWidth = 2;
            homingPower = 0.08f;//追终
            trailEffect = new Effect(70, e -> {
                color(e.color);
                Fill.circle(e.x, e.y, e.rotation * e.fout());
            }).layer(Layer.bullet - 0.001f); //below bullets;;
            trailChance = 0.2f;
            // trailInterval=3f;
            //trailChance = 0.3f;
            splashDamage = -1;//范围伤害,负值禁用
            splashDamageRadius = 0;//范围伤害的范围
            collidesAir = collidesGround = true;//对空对地
                       /*子弹消失时的效果，可能和hitEffect有些相似。
            不同的是这个效果只会显示一次，如果是hitEffect可能会在多个目标上显示，比如子弹贯穿多个单位或建筑*/
            despawnEffect = Fx.blastExplosion; //NewFx.制裁子弹消失;

            //蓄力射击开始时产生的效果;仅适用于具有 firstShotDelay / shotDelay 的单发武器。
            chargeEffect = none;
            hitEffect = Fx.blastExplosion;

            backColor = Pal.missileYellowBack;
            frontColor = Pal.missileYellow;
        }
    }

    public static class 光棱塔Bullet extends PointBulletType {
        public 光棱塔Bullet(float damagee) {
            super();
            damage = damagee;
            speed = 100;
            lifetime = 10;
            hitShake = 8;
            buildingDamageMultiplier = 0.2f;
            statusDuration = 80;
            ammoMultiplier = 1;
            //蓄力射击开始时产生的效果;仅适用于具有 firstShotDelay / shotDelay 的单发武器。
            hitEffect = chargeEffect = new MultiEffect(Fx.lancerLaserChargeBegin) {
                {
                    effects = new Effect[]{
                            new NewEffect.BulletWaveEffect() {{
                                sizeFrom = 0f;
                                sizeTo = 30f;
                                //持续时间
                                lifetime = 50;
                                strokeFrom = 5f;
                                strokeTo = 0f;
                                colorFrom = NewColor.光棱塔Bullet1;
                                colorTo = NewColor.光棱塔Bullet2;
                            }},
                    };
                }
            };
            chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
            trailEffect = new MultiEffect() {
                {
                    effects = new Effect[]{
                            new NewEffect.BulletParticleEffect() {{
                                particles = 1;
                                length = 1;
                                baseLength = 0;
                                lifetime = 30;
                                line = true;
                                randLength = false;
                                lenFrom = 10;
                                lenTo = 11;
                                strokeFrom = 3;
                                cone = 0;
                                colorFrom = NewColor.光棱塔Bullet1;
                                colorTo = NewColor.光棱塔Bullet2;
                            }},
                    };
                }
            };
            hitSound = loadSound("hit光棱");
            fragBullets = 4;
            fragBullet = new LightningBulletType() {{
                damage = 20;
                lightningLength = 40;
                collidesAir = true;
                ammoMultiplier = 1f;
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
                    collidesAir = false;
                    buildingDamageMultiplier = 0.25f;
                }};
            }};
        }
    }

    public static class 超级光棱塔Bullet extends PointBulletType {
        public 超级光棱塔Bullet(float damagee) {
            super();
            damage = damagee;
            speed = 100;
            lifetime = 10;
            hitShake = 8;
            buildingDamageMultiplier = 0.2f;
            statusDuration = 80;
            ammoMultiplier = 1;
            //蓄力射击开始时产生的效果;仅适用于具有 firstShotDelay / shotDelay 的单发武器。
            hitEffect = new MultiEffect(Fx.lancerLaserChargeBegin) {
                {
                    effects = new Effect[]{
                            new NewEffect.BulletWaveEffect() {{
                                sizeFrom = 0f;
                                sizeTo = 30f;
                                //持续时间
                                lifetime = 50;
                                strokeFrom = 5f;
                                strokeTo = 0f;
                                colorFrom = NewColor.光棱塔Bullet1;
                                colorTo = NewColor.光棱塔Bullet2;
                            }},
                    };
                }
            };
            //蓄力射击开始时产生的效果;仅适用于具有 firstShotDelay / shotDelay 的单发武器。
            chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
            trailEffect = new MultiEffect() {
                {
                    effects = new Effect[]{
                            new NewEffect.BulletParticleEffect() {{
                                particles = 1;
                                length = 1;
                                baseLength = 0;
                                lifetime = 50;
                                line = true;
                                randLength = false;
                                lenFrom = 10;
                                lenTo = 11;
                                strokeFrom = 6;
                                cone = 0;
                                colorFrom = NewColor.光棱塔Bullet1;
                                colorTo = NewColor.光棱塔Bullet2;
                            }},
                    };
                }
            };
            hitSound = loadSound("hit光棱2");
            fragBullets = 5;
            fragBullet = new LaserBulletType(800) {{
                colors = new Color[]{NewColor.光棱塔Bullet1.cpy().a(0.4f), NewColor.光棱塔Bullet1, NewColor.光棱塔Bullet2};
                //TODO merge
                chargeEffect = new NewEffect.BulletWaveEffect() {{
                    sizeFrom = 0f;
                    sizeTo = 20f;
                    //持续时间
                    lifetime = 20;
                    strokeFrom = 2f;
                    strokeTo = 0f;
                    colorFrom = NewColor.光棱塔Bullet1;
                    colorTo = NewColor.光棱塔Bullet2;
                }};
                collidesAir = collidesGround = true;
                //buildingDamageMultiplier = 0.25f;
                hitEffect = Fx.hitLancer;
                hitSize = 4;
                lifetime = 16f;
                drawSize = 400f;
                length = 190f;
                ammoMultiplier = 1f;
                pierce = true;
                // pierceCap = 4;
            }};
        }
    }


    public static class 起源Bullet备用 extends BasicBulletType {
        public 起源Bullet备用(float damagee) {
/*        shoot = new ShootHelix(){{
            mag = 1f;
            scl = 5f;
        }};*/

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
            damage = damagee;
            lifetime = 240;
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
            intervalBullets = 20;
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
        }
    }

    ;

    public static class 起源Bullet备用2 extends BasicBulletType {
        public 起源Bullet备用2(float damagee) {
/*        shoot = new ShootHelix(){{
            mag = 1f;
            scl = 5f;
        }};*/

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
            speed = 2f;
            damage = damagee;
            lifetime = 240;
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
           /* intervalBullets = 3;
            intervalBullet = new BasicBulletType(4,55,"ct-起源2"){{
                lifetime = 70;
                collidesAir = true;
                //for visual stats only.
                buildingDamageMultiplier = 0.25f;
                spin=2;
                trailColor = NewColor.制裁Bullet颜色;
                trailParam = 2;
                trailLength = 5;
                trailWidth = 1;
                trailEffect = none;
            }};
            bulletInterval = 4f;*/
            lightningColor = Pal.sapBullet;
            lightningDamage = 17;
            lightning = 8;
            lightningLength = 2;
            lightningLengthRand = 8;
        }
    }

    ;

    public static class 起源Bullet extends ArtilleryBulletType {
        public 起源Bullet(float damagee, float 倍率, float splashDamagee) {
/*        shoot = new ShootHelix(){{
            mag = 1f;
            scl = 5f;
        }};*/
            homingPower = 0.9f;//追终
            splashDamageRadius = 10f * 8f;
            splashDamage = splashDamagee;
            shootEffect = new MultiEffect(Fx.shootTitan, new WaveEffect() {{
                colorTo = Pal.sapBulletBack;
                sizeTo = 26f;
                lifetime = 14f;
                strokeFrom = 4f;
            }});
            smokeEffect = Fx.shootSmokeTitan;
            hitColor = Pal.sapBullet;
            despawnSound = Sounds.spark;
            //pierce = true;
            sprite = "ct-large-orb";
            trailEffect = Fx.missileTrail;
            trailInterval = 3f;//间隔距离
            trailParam = 4f;//数量
            trailColor = 起源Bullet颜色2;
            trailLength = 70;
            trailWidth = 13f;
            speed = 2f;
            damage = 0;
            lifetime = 280;
            width = height = 55f;
            backColor = 起源Bullet颜色1;
            frontColor = 起源Bullet颜色2;
            shrinkX = shrinkY = 0f;
            ammoMultiplier = 倍率;
            //collidesAir = collidesGround = false;//使用类子弹的就行了 这里注释掉
            //蓄力射击开始时产生的效果;仅适用于具有 firstShotDelay / shotDelay 的单发武器。
            chargeEffect = NewFx.起源蓄力效果();
            // Z子弹消失效果
            despawnEffect = new ExplosionEffect() {{
                waveColor = Pal.sapBullet;
                smokeColor = Color.gray;
                sparkColor = Pal.sap;
                waveStroke = 4f;
                waveRad = 40f;
            }};
            intervalBullets = 3;
            intervalBullet = new BasicBulletType(4, damagee, "ct-起源2") {{
                lifetime = 70;
                width = height = 9f;
                collidesAir = true;
                frontColor = 起源Bullet颜色1;
                backColor = 起源Bullet颜色2;
                buildingDamageMultiplier = 0.25f;
                spin = 8;
                despawnEffect = hitEffect = NewFx.普通击中despawnEffect(起源Bullet颜色2);
                trailColor = 起源Bullet颜色2;
                trailParam = 2;
                trailLength = 5;
                trailWidth = 1;
                trailEffect = none;
            }};
            bulletInterval = 4f;
            lightningColor = 起源Bullet颜色1;
            lightningDamage = 17;
            lightning = 8;
            lightningLength = 2;
            lightningLengthRand = 8;
        }
    }

    ;

    public static class 皇后Bullet extends BasicBulletType {
        public 皇后Bullet(float damagee, float 倍率, float 速度, float 射速) {
            /*      ;*/

            shootEffect = new MultiEffect(Fx.shootTitan, new WaveEffect() {{
                colorTo = 皇后Bullet颜色1;
                sizeTo = 26f;
                lifetime = 14f;
                strokeFrom = 4f;
            }});
            smokeEffect = Fx.shootSmokeTitan;
            hitColor = 皇后Bullet颜色2;
            despawnSound = Sounds.spark;
            spin = 10;
            sprite = "ct-皇后1";
            trailEffect = none;
            // trailInterval = 3f;
            // trailParam = 4f;
            pierce = true;
            speed = 速度;
            damage = damagee;
            lifetime = 240;
            width = height = 50f;
            backColor = 皇后Bullet颜色1;
            frontColor = 皇后Bullet颜色2;
            shrinkX = shrinkY = 0f;
            trailColor = 皇后Bullet颜色1;
            trailLength = 30;
            trailWidth = 5f;
            ammoMultiplier = 倍率;
            reloadMultiplier = 射速;
            despawnEffect = hitEffect = new ExplosionEffect() {{
                waveColor = 皇后Bullet颜色2;
                smokeColor = Color.gray;
                sparkColor = Pal.sap;
                waveStroke = 4f;
                waveRad = 40f;
            }};
        }
    }

    ;

    public static class 帝王Bullet extends BasicBulletType {
        public 帝王Bullet(float damagee, float damagee2, float 倍率, float 速度, float 射速) {
            /*      ;*/

            // shootEffect =
            smokeEffect = Fx.shootSmokeTitan;
            hitColor = 帝王Bullet颜色2;
            despawnSound = Sounds.spark;
            spin = 5;
            sprite = "ct-帝王1";
            trailEffect = new ParticleEffect() {{
                region = "ct-正四星";
                colorFrom = 帝王Bullet颜色2;
                colorTo = 帝王Bullet颜色1;
                length = 20f;
                baseLength = 10f;
                sizeFrom = 9f;
                sizeTo = 3f;
                spin = 5f;
            }};
            trailInterval = 2f;//每次产生的间隔时间
            trailParam = 3f;//每次产生的数量
            trailColor = 帝王Bullet颜色2;
            trailRotation = false;
            trailLength = -6;//小于等于0会禁用
            trailWidth = -6f;
            trailSinMag = 0f;
            trailSinScl = 3f;

            pierce = true;
            drag = 0.01f;
            speed = 速度;
            damage = damagee;
            lifetime = 40;
            width = 25;
            height = 40f;
            backColor = 帝王Bullet颜色1;
            frontColor = 帝王Bullet颜色2;
            shrinkX = shrinkY = 0f;
            // trailColor =  帝王Bullet颜色1;
            // trailLength = 30;
            //trailWidth = 5f;
            ammoMultiplier = 倍率;
            reloadMultiplier = 射速;
            despawnEffect = hitEffect = new ExplosionEffect() {{
                waveColor = 帝王Bullet颜色2;
                smokeColor = Color.gray;
                sparkColor = Pal.sap;
                waveStroke = 4f;
                waveRad = 40f;
            }};
            fragBullets = 5;
            fragVelocityMin = 1f;//破片力度最小值
            fragVelocityMax = 1f;//破片力度最大值
            fragBullet = new BasicBulletType(-3, 0, "ct-帝王1") {{
                width = 8f;
                height = 13f;
                trailEffect = new ParticleEffect() {{
                    region = "ct-正四星";
                    colorFrom = 帝王Bullet颜色2;
                    colorTo = 帝王Bullet颜色1;
                    //length = 20f;baseLength = 10f;
                    sizeFrom = 3f;
                    sizeTo = 1f;
                    spin = 5f;
                }};
                trailInterval = 13f;//每次产生的间隔时间
                trailParam = 1f;//每次产生的数量
                trailColor = 帝王Bullet颜色3;
                trailWidth = 2f;
                trailLength = 9;//小于等于0会禁用

                splashDamage = damagee2;//范围伤害
                splashDamageRadius = 5 * 8;//范围伤害的范围
                backColor = 帝王Bullet颜色1;
                frontColor = 帝王Bullet颜色2;
                lifetime = 360f;

                hitEffect = despawnEffect = new NewEffect.BulletWaveEffect() {{
                    sizeFrom = 0f;
                    sizeTo = 20f;
                    //持续时间
                    lifetime = 40;
                    strokeFrom = 2f;
                    strokeTo = 0f;
                    colorFrom = NewColor.帝王Bullet颜色1;
                    colorTo = NewColor.帝王Bullet颜色2;
                }};
                homingDelay = 50;//追踪延迟
                homingRange = 90 * 8;//追踪范围
                homingPower = 0.9f; //追踪力度
            }};
            //TODO merge
            chargeEffect = new NewEffect.BulletWaveEffect() {{
                sizeFrom = 0f;
                sizeTo = 20f;
                //持续时间
                lifetime = 20;
                strokeFrom = 2f;
                strokeTo = 0f;
                colorFrom = NewColor.光棱塔Bullet1;
                colorTo = NewColor.光棱塔Bullet2;
            }};
            fragRandomSpread = -45f;
        }
    }

    ;

    public static class 空之驱逐Bullet extends BasicBulletType {
        public 空之驱逐Bullet(float damagee, float 倍率, float 速度, float 射速, float 击退) {
            sprite = "ct-Bullet月牙";
            damage = damagee;
            speed = 速度;
            ammoMultiplier = 倍率;
            reloadMultiplier = 射速;
            lifetime = 60;
            width = height = 30;
            backColor = 帝王Bullet颜色1;
            frontColor = 帝王Bullet颜色2;
            fragVelocityMin = 0.3f;//破片力度最小值
            fragVelocityMax = 1f;//破片力度最大值
            collidesGround = false;//对地
   /*         homingRange = 60 * 8f;//追踪范围
            homingPower = 0.3f; //追踪力度
            homingDelay = 20;//追踪延迟*/
            knockback = 击退;
            despawnEffect = hitEffect = new ExplosionEffect() {{
                waveColor = 帝王Bullet颜色2;
                smokeColor = Color.gray;
                sparkColor = Pal.sap;
                waveStroke = 4f;
                waveRad = 40f;
            }};

            trailEffect = new ParticleEffect() {{
                region = "ct-正四星";
                colorFrom = 帝王Bullet颜色2;
                colorTo = 帝王Bullet颜色1;
                //length = 20f;baseLength = 10f;
                sizeFrom = 6f;
                sizeTo = 0f;
                spin = 5f;
            }};
            trailInterval = 1.5f;//每次产生的间隔时间
            trailParam = 2f;//每次产生的数量
            trailColor = 帝王Bullet颜色2;
            trailRotation = false;
            trailLength = -6;//小于等于0会禁用
            trailWidth = -6f;
            trailSinMag = 0f;
            trailSinScl = 3f;
        }
    }

    ;

    public static class 空中祸害Bullet extends BasicBulletType {
        public 空中祸害Bullet(float damagee, float 倍率, float 速度, float 射速, float 击退) {
            shootEffect = CT3FxEffect.greenBomb2;
            sprite = "ct-月牙";
            damage = damagee;
            speed = 速度;
            ammoMultiplier = 倍率;
            reloadMultiplier = 射速;
            lifetime = 130;
            width = height = 50;
            pierce = true;
            backColor = 空中祸害Bullet颜色1;
            frontColor = 空中祸害Bullet颜色2;
            fragVelocityMin = 0.3f;//破片力度最小值
            fragVelocityMax = 1f;//破片力度最大值
            collidesGround = false;//对地
   /*         homingRange = 60 * 8f;//追踪范围
            homingPower = 0.3f; //追踪力度
            homingDelay = 20;//追踪延迟*/
            knockback = 击退 * 2;
            despawnEffect = hitEffect = new ExplosionEffect() {{
                waveColor = 空中祸害Bullet颜色2;
                smokeColor = Color.gray;
                sparkColor = Pal.sap;
                waveStroke = 4f;
                waveRad = 40f;
                lifetime = 70;
            }};

            trailEffect = none;
            trailInterval = 1.5f;//每次产生的间隔时间
            trailParam = 2f;//每次产生的数量
            trailColor = 空中祸害Bullet颜色2;
            trailRotation = false;
            trailLength = 30;//小于等于0会禁用
            trailWidth = 8f;
            trailSinMag = 0f;
            trailSinScl = 3f;

            intervalBullet = new ArtilleryBulletType(2, damagee / 3) {{
                despawnEffect = hitEffect = new ExplosionEffect() {{//波纹
                    waveColor = 空中祸害Bullet颜色2;
                    smokeColor = Color.gray;
                    sparkColor = Pal.sap;
                    waveStroke = 4f;
                    waveRad = 40f;
                    lifetime = 50;
                }};
                lifetime = 130;
                knockback = 击退;
                backColor = 空中祸害Bullet颜色1;
                frontColor = 空中祸害Bullet颜色2;
                width = height = 20;
                collidesTiles = collides = collidesAir = true;
                homingRange = 5 * 8f;//追踪范围
                homingPower = 1f; //追踪力度
                trailEffect =//NewFx.四角星(1,5,4,1,4);;
                        new ParticleEffect() {{
                            particles = 3;
                            region = "ct-正四星";
                            colorFrom = 空中祸害Bullet颜色2;
                            colorTo = 空中祸害Bullet颜色1;
                            //length = 20f;baseLength = 10f;
                            sizeFrom = 4f;
                            sizeTo = 0f;
                            spin = 5f;
                        }};
                trailInterval = 15f;//每次产生的间隔时间
                // trailParam = 1f;//每次产生的数量
            }};
            bulletInterval = 6;//每次产生的间隔时间
            intervalRandomSpread = 20;
            intervalBullets = 2;
            // intervalAngle = 180;
            // intervalSpread = 300;
        }
    }

    ;

    public static class 尘埃Bullet extends BasicBulletType {
        public 尘埃Bullet() {
             /*  collidesTiles = false;
            collides = false;
            scaleLife = true;
            */
            scaleLife = true;//开启指哪打哪
            frontColor = 尘埃Bullet颜色1;
            backColor = 尘埃Bullet颜色2;
            sprite = "circle-bullet";
            lifetime = 6 * 60;
            damage = 6000;
            speed = 3.5f;
            width = 55;
            height = 55;
            //shootEffect = NewFx.尘埃子弹效果();
            smokeEffect = shootSmallSmoke;
            ammoMultiplier = 1;
            pierce = true;
            //
            trailColor = 尘埃Bullet颜色1;
            trailParam = 5;
            trailLength = 19;
            trailWidth = 8;
            trailInterval = 30;
            trailRotation = true;
            trailEffect = none;
            parts.addAll(
                    new HaloPart() {{
                        rotateSpeed = 0;
                        shapeRotation = 0;
                        sides = 3;
                        shapes = 2;
                        color = 尘埃Bullet颜色1;
                        colorTo = 尘埃Bullet颜色2;
                        tri = true;
                        hollow = true;
                        radius = 10;
                        radiusTo = 5;
                        triLength = 85;
                        triLengthTo = 50;
                        haloRadius = 0;
                        haloRotation = 0;
                        haloRotateSpeed = 9f;
                        layer = 110;
                    }},
                    new HaloPart() {{
                        rotateSpeed = 0;
                        shapeRotation = 0;
                        sides = 3;
                        shapes = 2;
                        color = 尘埃Bullet颜色1;
                        colorTo = 尘埃Bullet颜色2;
                        tri = true;
                        hollow = true;
                        radius = 23;
                        radiusTo = 18;
                        triLength = 125;
                        triLengthTo = 50;
                        haloRadius = 0;
                        haloRotation = 0;
                        haloRotateSpeed = -5.5f;
                        layer = 110;
                    }}
            );
            //子弹命中目标的效果
            hitEffect = NewFx.尘埃子弹2次击中消失效果();
            /*子弹消失时的效果，可能和hitEffect有些相似。
            不同的是这个效果只会显示一次，如果是hitEffect可能会在多个目标上显示，比如子弹贯穿多个单位或建筑*/
            despawnEffect = none;
            splashDamage = 0;//范围伤害
            splashDamageRadius = 0;//范围伤害的范围
            collidesAir = collidesGround = true;//对空对地
            chargeEffect = NewFx.尘埃蓄力效果();

            fragBullets = 1;
            fragBullet = new BasicBulletType(0, 0, "circle-bullet") {{
                frontColor = 尘埃Bullet颜色1;
                backColor = 尘埃Bullet颜色2;
                lifetime = 5 * 60;//持续5秒
                width = height = 60f;
                collidesTiles = false;
                collides = false;
                collidesAir = false;
                //TODO merge
                parts.addAll(
                        new HaloPart() {{
                            rotateSpeed = 0;
                            shapeRotation = 0;
                            sides = 3;
                            shapes = 2;
                            color = 尘埃Bullet颜色1;
                            colorTo = 尘埃Bullet颜色1;
                            tri = true;
                            hollow = true;
                            radius = 10;
                            radiusTo = 10;
                            triLength = 85;
                            triLengthTo = 85;
                            haloRadius = 0;
                            haloRotation = 0;
                            haloRotateSpeed = 9f;
                            layer = 110;
                        }},
                        new HaloPart() {{
                            rotateSpeed = 0;
                            shapeRotation = 0;
                            sides = 3;
                            shapes = 2;
                            color = 尘埃Bullet颜色1;
                            colorTo = 尘埃Bullet颜色1;
                            tri = true;
                            hollow = true;
                            radius = 23;
                            radiusTo = 23;
                            triLength = 125;
                            triLengthTo = 125;
                            haloRadius = 0;
                            haloRotation = 0;
                            haloRotateSpeed = -5.5f;
                            layer = 110;
                        }}
                );
                hitSound = plasmaboom;
                intervalBullets = 3;
                bulletInterval = 6;//每次产生的间隔时间
                intervalBullet = new BasicBulletType(4, 888, "ct-正四星") {{
                    lifetime = 90;
                    width = height = 27f;
                    collidesAir = true;
                    frontColor = 尘埃Bullet颜色1;
                    backColor = 尘埃Bullet颜色2;
                    buildingDamageMultiplier = 0.25f;
                    spin = 8;
                    despawnEffect = hitEffect = NewFx.普通击中despawnEffect(尘埃Bullet颜色2);
                    trailColor = 尘埃Bullet颜色1;
                    trailParam = 2;
                    trailLength = 12;
                    trailWidth = 2.5f;
                    trailEffect = none;
                    pierce = true;
                }};
                fragBullets = 5;
                fragLifeMin = 0.5f;
                fragAngle = 35;
                fragBullet = new BasicBulletType(0, 0) {
                    {
                        hitSound = plasmaboom;
                        speed = 16;
                        damage = 0;
                        collidesGround = false;
                        collidesAir = false;
                        collides = false;
                        lifetime = 5;
                        lightOpacity = 0;
                        shootEffect = none;
                        height = 0.1f;
                        width = 0.1f;
                        frontColor = 透明颜色;
                        backColor = 透明颜色;
                        hitEffect = none;
                        despawnEffect = none;
                        //status= freezing;
                        lightning = 6;
                        lightningColor = 尘埃Bullet颜色1;
                        lightningDamage = 780;
                        lightningCone = 360;
                        lightningLengthRand = 2;
                        lightningLength = 1;
                        lightningType = new LaserBulletType() {{
                            length = 260;
                            width = 20;
                            lifetime = 50;
                            damage = 5000;
                            lightColor = 尘埃Bullet颜色1;
                            hitSound = laser;
                            hitEffect = new ParticleEffect() {
                                {
                                    line = true;
                                    particles = 15;
                                    lifetime = 20;
                                    offset = 50;
                                    length = 55;
                                    cone = -360;
                                    lenFrom = 5;
                                    lenTo = 0;
                                    colorFrom = 尘埃Bullet颜色1;
                                    colorTo = 尘埃Bullet颜色2;
                                }
                            };
                            colors = new Color[]{尘埃Bullet颜色1, 尘埃Bullet颜色1, Color.white};
                            sideAngle = 25;
                            sideLength = 0;
                            sideWidth = 0;
                            hitSound = plasmaboom;
                            lightRadius = 100;
                            statusDuration = 200;
                            trailColor = 尘埃Bullet颜色2;
                            trailParam = 5;
                            trailLength = 19;
                            trailWidth = 8;
                            trailInterval = 30;
                            trailRotation = true;
                            trailEffect = none;
                            shrinkY = 0;
                            shrinkX = 0;
                            absorbable = false;
                            speed = 3;
                            lifetime = 70;
                            damage = 666;
                            height = 35;
                            width = 35;
                            hitEffect = new MultiEffect() {{
                                effects = new Effect[]{
                                        new ParticleEffect() {
                                            {
                                                lightOpacity = 0;
                                                particles = 30;
                                                length = 130;
                                                baseLength = 10;
                                                lifetime = 280;
                                                layer = 106;
                                                interp = Interp.swing;
                                                sizeFrom = 24;
                                                sizeTo = 10;
                                                colorFrom = 尘埃Bullet颜色1;
                                                colorTo = 尘埃Bullet颜色2;
                                            }
                                        },

                                        new ParticleEffect() {
                                            {
                                                lightOpacity = 0;
                                                particles = 20;
                                                length = 170;
                                                baseLength = 10;
                                                lifetime = 280;
                                                layer = 106;
                                                interp = Interp.swing;
                                                sizeFrom = 30;
                                                sizeTo = 23;
                                                colorFrom = 尘埃Bullet颜色1;
                                                colorTo = 尘埃Bullet颜色2;
                                            }
                                        },
                                        new WaveEffect() {
                                            {
                                                lifetime = 125;
                                                sizeFrom = 0;
                                                sizeTo = 200;
                                                strokeFrom = 8;
                                                strokeTo = 0;
                                                colorFrom = 尘埃Bullet颜色1;
                                                colorTo = 尘埃Bullet颜色2;
                                            }
                                        },
                                        new ParticleEffect() {
                                            {
                                                lightOpacity = 0;
                                                length = 0;
                                                sizeFrom = 75;
                                                sizeTo = 0;
                                                region = "ct-菱形3";
                                                particles = 1;
                                                interp = Interp.swing;
                                                lifetime = 200;
                                                colorFrom = 尘埃Bullet颜色1;
                                                colorTo = 尘埃Bullet颜色2;
                                                spin = 8;
                                            }
                                        },
                                        new ParticleEffect() {
                                            {
                                                lightOpacity = 0;
                                                length = 0;
                                                sizeFrom = 100;
                                                sizeTo = 0;
                                                region = "ct-菱形2";
                                                particles = 1;
                                                interp = Interp.pow3Out;
                                                lifetime = 200;
                                                colorFrom = 尘埃Bullet颜色1;
                                                colorTo = 尘埃Bullet颜色2;
                                                spin = -8;
                                            }
                                        },
                                        new ParticleEffect() {
                                            {
                                                particles = 1;
                                                sizeFrom = 40;
                                                sizeTo = 0;
                                                length = 0;
                                                interp = Interp.pow3Out;
                                                lifetime = 200;
                                                layer = 109;
                                                colorFrom = 尘埃Bullet颜色1;
                                                colorTo = 尘埃Bullet颜色2;
                                            }
                                        },
                                        new ParticleEffect() {
                                            {
                                                particles = 1;
                                                sizeFrom = 20;
                                                sizeTo = 0;
                                                interp = Interp.pow3Out;
                                                length = 0;
                                                lifetime = 200;
                                                colorTo = colorFrom = Color.white;

                                            }
                                        }

                                };


                                splashDamageRadius = 90;
                                splashDamage = 37000;
                                frontColor = 尘埃Bullet颜色1;
                                backColor = 尘埃Bullet颜色2;
                                fragBullets = 5;
                                fragLifeMin = 0.5f;
                                fragBullet = new BasicBulletType(3.5f, 450, "circle-bullet") {{

                                    //  status= freezing;
                                    lightRadius = 50;
                                    // statusDuration= 1000;
                                    hitSound = plasmaboom;
                                    trailColor = 尘埃Bullet颜色2;
                                    absorbable = false;
                                    trailParam = 5;
                                    trailLength = 12;
                                    trailWidth = 7;
                                    shrinkY = 0;
                                    shrinkX = 0;
                                    lightning = 17;
                                    lightningDamage = 500;
                                    lightningColor = 尘埃Bullet颜色2;
                                    lightningCone = 360;
                                    lightningLengthRand = 21;
                                    lightningLength = 11;
                                    lifetime = 100;
                                    height = 28;
                                    width = 28;
                                    hitEffect = new MultiEffect() {
                                        {
                                            effects = new Effect[]{
                                                    new ParticleEffect() {{
                                                        lightOpacity = 0;
                                                        particles = 10;
                                                        length = 100;
                                                        baseLength = 5;
                                                        lifetime = 180;
                                                        layer = 106;
                                                        interp = Interp.circleOut;
                                                        sizeFrom = 24;
                                                        sizeTo = 10;
                                                        colorFrom = 尘埃Bullet颜色1;
                                                        colorTo = 尘埃Bullet颜色2;
                                                    }},
                                                    new ParticleEffect() {{
                                                        lightOpacity = 0;
                                                        particles = 10;
                                                        length = 130;
                                                        baseLength = 10;
                                                        lifetime = 180;
                                                        layer = 106;
                                                        interp = Interp.circleOut;
                                                        sizeFrom = 30;
                                                        sizeTo = 23;
                                                        colorFrom = 尘埃Bullet颜色1;
                                                        colorTo = 尘埃Bullet颜色2;
                                                        ;
                                                    }},
                                                    new WaveEffect() {{
                                                        lifetime = 45;
                                                        sizeFrom = 0;
                                                        sizeTo = 70;
                                                        strokeFrom = 6;
                                                        strokeTo = 0;
                                                        colorFrom = 尘埃Bullet颜色1;
                                                        colorTo = 尘埃Bullet颜色2;
                                                    }},
                                            };
                                        }
                                    };

                                    trailEffect = none;
                                    homingRange = 170;
                                    homingPower = 0.0567F;
                                    splashDamageRadius = 54;
                                    splashDamage = 276;
                                    frontColor = 尘埃Bullet颜色1;
                                    backColor = 尘埃Bullet颜色2;
                                    fragBullets = 6;
                                    fragLifeMin = 0.3F;
                                    fragBullet = new BasicBulletType(0, 0, "circle-bullet") {{
                                        //status= freezing;
                                        statusDuration = 1000;
                                        splashDamageRadius = 50;
                                        splashDamage = 106;
                                        absorbable = false;
                                        speed = 3;
                                        shrinkY = 0;
                                        shrinkX = 0;
                                        trailColor = 尘埃Bullet颜色2;
                                        trailParam = 5;
                                        trailLength = 6;
                                        trailWidth = 4;
                                        lifetime = 80;
                                        damage = 320;
                                        trailEffect = none;
                                        height = 13;
                                        width = 13;
                                        hitEffect = new ParticleEffect() {{
                                            particles = 10;
                                            length = 60;
                                            lifetime = 46;
                                            interp = Interp.circleOut;
                                            cone = 360;
                                            sizeFrom = 3;
                                            sizeTo = 0;
                                            colorFrom = 尘埃Bullet颜色1;
                                            colorTo = 尘埃Bullet颜色2;
                                        }};

                                        frontColor = 尘埃Bullet颜色1;
                                        backColor = 尘埃Bullet颜色2;
                                        fragBullets = 1;
                                        fragBullet = new ShrapnelBulletType() {{
                                            serrations = 0;
                                            splashDamageRadius = 47;
                                            length = 122;
                                            lifetime = 36;
                                            width = 30;
                                            lightColor = 尘埃Bullet颜色1;
                                            fromColor = 尘埃Bullet颜色2;
                                            toColor = 尘埃Bullet颜色3;
                                            damage = 300;
                                        }};
                                    }};
                                }};
                            }};
                        }};

                    }
                };
            }};
        }
    }
}
