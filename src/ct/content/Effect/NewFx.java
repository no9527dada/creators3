package ct.content.Effect;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Interp;
import arc.math.Mathf;
import arc.math.Rand;
import arc.struct.FloatSeq;
import ct.Asystem.LogicFxInit;
import ct.content.NewColor;
import mindustry.entities.Effect;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.part.HaloPart;
import mindustry.entities.part.ShapePart;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.logic.LogicFx;
import mindustry.world.draw.DrawTurret;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.lineAngle;
import static arc.graphics.g2d.Lines.stroke;
import static arc.math.Angles.*;
import static ct.content.NewColor.*;
import static mindustry.entities.part.DrawPart.PartProgress.reload;
import static mindustry.entities.part.DrawPart.PartProgress.warmup;

public class NewFx {
    public static int 数量 = 6;
    public static float 特效粒子的范围 = 120f;
    public static float 特效粒子外径 = 120;
    //虽然规定内外径，但是并没有内径必须比外径小的必要
    public static float 特效粒子内径 = 12;
    //这里填X角星,五角星就填5，四角星就填4
    public static int X角星 = 16;

    public static FloatSeq 星星图形(float x, float y, float out, float in, int side, float rotation) {
        FloatSeq floatSeq = new FloatSeq(side * 4 + 4);
        floatSeq.add(x, y);

        for (int i = 0; i < side; i++) {
            float pointRotation = rotation + 360f / side * i;
            floatSeq.add((float) (x + out * Math.cos(Mathf.degreesToRadians * pointRotation)),
                    y + (float) (out * Math.sin(Mathf.degreesToRadians * pointRotation)));
            floatSeq.add((float) (x + in * Math.cos(Mathf.degreesToRadians * (pointRotation + 180f / side))),
                    y + (float) (in * Math.sin(Mathf.degreesToRadians * (pointRotation + 180f / side))));
        }

        floatSeq.add((float) (x + out * Math.cos(Mathf.degreesToRadians * rotation)),
                y + (float) (out * Math.sin(Mathf.degreesToRadians * rotation)));

        return floatSeq;
    }

    public static Effect 四角星(int 数量, float 特效粒子的范围, float 特效粒子外径, float 特效粒子内径, int X角星) {
        return new Effect(120, e -> {
            Draw.color(Color.white, Color.pink, e.fin());
            // color(Color.white, e.color, e.fin());
            randLenVectors(e.id, 数量, 特效粒子的范围, (x, y) -> {
                float angle = Mathf.angle(x, y);
                Fill.poly(星星图形(e.finpow() * x + e.x, e.finpow() * y + e.y,
                        特效粒子外径 * (1 - Mathf.sqr(1 - e.fslope())),
                        特效粒子内径 * (1 - Mathf.sqr(1 - e.fslope())), X角星, angle));
            });
        });
    }

    /*////////////////////////////////////*/
    public static Effect D1, D2, D3, D4;
    public static Effect 制裁子弹消失, 灭亡子弹消失;

    public static void load() {


        制裁子弹消失 = new Effect(14, e -> {
            color(Color.white, Pal.lightOrange, e.fin());

            e.scaled(7f, s -> {
                stroke(0.5f + s.fout());
                Lines.circle(e.x, e.y, s.fin() * 15f);
            });
            color(制裁Bullet颜色);
            randLenVectors(e.id, 5, 2f + 23f * e.finpow(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, e.fout() * 4f + 0.5f);
            });
            stroke(0.5f + e.fout() * 1.5f);

            Drawf.light(e.x, e.y, 40f, Pal.lightOrange, 0.6f * e.fout());
        });
        灭亡子弹消失 = new Effect(14, e -> {
            color(Color.white, Pal.lightOrange, e.fin());

            e.scaled(7f, s -> {
                stroke(0.5f + s.fout());
                Lines.circle(e.x, e.y, s.fin() * 15f);
            });
            color(灭亡Bullet颜色);
            randLenVectors(e.id, 5, 2f + 23f * e.finpow(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, e.fout() * 4f + 0.5f);
            });
            stroke(0.5f + e.fout() * 1.5f);

            Drawf.light(e.x, e.y, 40f, Pal.lightOrange, 0.6f * e.fout());
        });
        D1 = new Effect(60, e -> {
            Draw.color(Color.valueOf("f9f9ca"));
            Lines.stroke(e.fout() + 0.2f);
            Angles.randLenVectors(e.id, 2, 1 + 20 * e.fout(), e.rotation, 120, (x, y) -> {
                Lines.circle(e.x + x, e.y + y, 1 + e.fin() * 3);
                Drawf.tri(e.x + x, e.y + y, e.fslope() * 3 + 1, e.fslope() * 3 + 1, Mathf.angle(x, y));
            });
        });

        D2 = new Effect(120, e -> {//八卦阴阳鱼
            float rad = 16f;
            float rotation = 2 * e.fin() * 6.283f;

            Drawf.circles(e.x, e.y, 32, Color.white);
            Draw.z(90f);
            //大圆
            Draw.color(Color.white);
            Fill.arc(e.x, e.y, rad * 2, 0.5f, 180 + rotation * 360 / 6.283f);
            Draw.color(Color.black);
            Fill.arc(e.x, e.y, rad * 2, 0.5f, rotation * 360 / 6.283f);

            //中圆
            Draw.color(Color.black);
            Fill.circle((float) (e.x - rad * Math.cos(rotation)), (float) (e.y - rad * Math.sin(rotation)), rad);
            Draw.color(Color.white);
            Fill.circle((float) (e.x + rad * Math.cos(rotation)), (float) (e.y + rad * Math.sin(rotation)), rad);

            //小圆
            Draw.color(Color.black);
            Fill.circle((float) (e.x + rad * Math.cos(rotation)), (float) (e.y + rad * Math.sin(rotation)), rad / 3f);
            Draw.color(Color.white);
            Fill.circle((float) (e.x - rad * Math.cos(rotation)), (float) (e.y - rad * Math.sin(rotation)), rad / 3f);

        });
        D3 = new Effect(90, 200f, e -> {
            randLenVectors(e.id, 10, e.finpow() * 90f, (x, y) -> {
                float size = e.fout() * 14f;
                color(Color.lime, Color.gray, e.fin());
                Fill.circle(e.x + x, e.y + y, size / 2f);
            });
        });

        D4 = new Effect(13f, 300f, e -> {
            color(Pal.lighterOrange, Color.lightGray, e.fin());
            stroke(e.fout() * 4f + 0.2f);
            Lines.circle(e.x, e.y, e.fin() * 200f);
        });

    }

    public static void init() {
        //
        //世处注入特效
        LogicFxInit.injectEffect("D1", new LogicFx.EffectEntry(NewFx.D1).color().size());
        LogicFxInit.injectEffect("D2", new LogicFx.EffectEntry(NewFx.D2).color().size());

    }


    //子弹特效  子弹效果
    public static DrawTurret 光棱塔蓄力射击效果() {
        return new DrawTurret() {{
            parts.addAll(
                    new HaloPart() {{
                        progress = warmup;
                        shapeRotation = 60;
                        y = 0;
                        sides = 3;
                        shapes = 2;
                        color = NewColor.光棱塔Bullet1;
                        colorTo = NewColor.光棱塔Bullet2;
                        hollow = true;
                        radius = 0;
                        radiusTo = 6;
                        triLength = 0;
                        triLengthTo = 30;
                        haloRadius = 0;
                        haloRotation = 0;
                        haloRotateSpeed = 5;
                        layer = 110;
                    }},
                    new HaloPart() {{
                        progress = warmup;
                        shapeRotation = 30;
                        y = 0;
                        sides = 3;
                        shapes = 2;
                        color = NewColor.光棱塔Bullet1;
                        colorTo = NewColor.光棱塔Bullet2;
                        hollow = true;
                        radius = 0;
                        radiusTo = 6;
                        triLength = 0;
                        triLengthTo = 30;
                        haloRadius = 0;
                        haloRotation = 0;
                        haloRotateSpeed = -5f;
                        layer = 110f;

                    }}
            );
        }};
    }

    public static DrawTurret 超级光棱塔蓄力射击效果() {
        return new DrawTurret() {{
            parts.addAll(

                    new HaloPart() {{
                        progress = warmup;
                        shapeRotation = 60;
                        y = 35;
                        sides = 3;
                        shapes = 2;
                        color = NewColor.光棱塔Bullet1;
                        colorTo = NewColor.光棱塔Bullet2;
                        tri = hollow = true;
                        radius = 0;
                        radiusTo = 6;
                        triLength = 30;
                        triLengthTo = 30;
                        haloRadius = 0;
                        haloRotation = 0;
                        haloRotateSpeed = -2;
                        layer = 110;
                    }},
                    new HaloPart() {{
                        progress = warmup;
                        shapeRotation = 30;
                        y = 35;
                        sides = 3;
                        shapes = 2;
                        color = NewColor.光棱塔Bullet1;
                        colorTo = NewColor.光棱塔Bullet2;
                        tri = hollow = true;
                        radius = 0;
                        radiusTo = 6;
                        triLength = 30;
                        triLengthTo = 30;
                        haloRadius = 0;
                        haloRotation = 120;
                        haloRotateSpeed = -2f;
                        layer = 110f;

                    }},
                    new HaloPart() {{
                        progress = warmup;
                        shapeRotation = 60;
                        y = 0;
                        sides = 3;
                        shapes = 2;
                        color = NewColor.光棱塔Bullet1;
                        colorTo = NewColor.光棱塔Bullet2;
                        hollow = true;
                        radius = 0;
                        radiusTo = 6;
                        triLength = 0;
                        triLengthTo = 30;
                        haloRadius = 0;
                        haloRotation = 0;
                        haloRotateSpeed = 5;
                        layer = 110;
                    }},
                    new HaloPart() {{
                        progress = warmup;
                        shapeRotation = 30;
                        y = 0;
                        sides = 3;
                        shapes = 2;
                        color = NewColor.光棱塔Bullet1;
                        colorTo = NewColor.光棱塔Bullet2;
                        hollow = true;
                        radius = 0;
                        radiusTo = 6;
                        triLength = 0;
                        triLengthTo = 30;
                        haloRadius = 0;
                        haloRotation = 0;
                        haloRotateSpeed = -5f;
                        layer = 110f;

                    }}
            );
        }};
    }

    public static Effect 起源蓄力效果() {
        return new MultiEffect() {{
            //lifetime = 80;
            //rotWithParent = true;
            //followParent = true;
            effects = new Effect[]{
                    new ParticleEffect() {{//实心圆，从小到大
                        particles = 1;
                        sizeFrom = 5;
                        sizeTo = 13;
                        interp = Interp.swing;
                        length = 1;
                        lifetime = 50;
                        colorFrom = 起源Bullet颜色1;
                        colorTo = 起源Bullet颜色2;
                    }},
                    new ParticleEffect() {{
                        line = true;
                        particles = 15;
                        lifetime = 60;
                        length = 45;
                        offset = 4;
                        baseLength = -45;
                        cone = -360;
                        lenFrom = 20;
                        lenTo = 0;
                        colorFrom = 起源Bullet颜色1;
                        colorTo = 起源Bullet颜色2;
                    }},
                    new WaveEffect() {{
                        lifetime = 70;
                        sizeFrom = 40;
                        sizeTo = 0;
                        strokeFrom = 0;
                        strokeTo = 7;
                        colorFrom = 起源Bullet颜色1;
                        colorTo = 起源Bullet颜色2;
                    }},
                    new WaveEffect() {{
                        lifetime = 70;
                        sizeFrom = 30;
                        sizeTo = 0;
                        strokeFrom = 0;
                        strokeTo = 7;
                        colorFrom = 起源Bullet颜色1;
                        colorTo = 起源Bullet颜色2;
                    }},
            };
        }};
    }

    public static Effect 尘埃蓄力效果() {
        return new MultiEffect() {{
            effects = new Effect[]{
                    new NewEffect.BulletParticleEffect() {{//外部线条向内聚集缩小，,适用蓄力效果
                        sizeFrom = 130;
                        sizeTo = 30;
                        line = true;
                        particles = 50;
                        lifetime = 200;
                        offset = 4;
                        cone = -360;
                        lenFrom = 200;
                        lenTo = 0;
                        colorFrom = 尘埃Bullet颜色1;
                        colorTo = 尘埃Bullet颜色2;
                    }},
                    new ParticleEffect() {{//实心圆，从小到大
                        particles = 1;
                        sizeFrom = 1;
                        sizeTo = 10.5f;
                        length = 0;
                        lifetime = 200;
                        cone = 360;
                        colorFrom = 尘埃Bullet颜色1;
                        colorTo = 尘埃Bullet颜色1;
                    }},
                    new ParticleEffect() {{//实心圆，从小到大
                        particles = 1;
                        sizeFrom = 1;
                        sizeTo = 27;
                        length = 0;
                        lifetime = 200;
                        layer = 109;
                        cone = 360;
                        colorFrom = 尘埃Bullet颜色1;
                        colorTo = 尘埃Bullet颜色1;
                    }},
                    new ParticleEffect() {{
                        particles = 1;
                        sizeFrom = 2;
                        sizeTo = 80;
                        length = 0;
                        spin = -10;
                        layer = 109;
                        lifetime = 200;
                        region = "ct-菱形2";
                        colorFrom = 尘埃Bullet颜色1;
                        colorTo = 尘埃Bullet颜色2;
                    }},
                    new ParticleEffect() {{
                        particles = 1;
                        sizeFrom = 2;
                        sizeTo = 50;
                        length = 0;
                        spin = 10;
                        layer = 109;
                        lifetime = 200;
                        region = "ct-菱形3";
                        colorFrom = 尘埃Bullet颜色1;
                        colorTo = 尘埃Bullet颜色2;
                    }},
                    new WaveEffect() {{
                        startDelay = 150;
                        lifetime = 50;
                        sizeFrom = 150;
                        sizeTo = 0;
                        strokeFrom = 6;
                        strokeTo = 0;
                        colorFrom = 尘埃Bullet颜色1;
                        colorTo = 尘埃Bullet颜色2;
                    }},
                    new WaveEffect() {{
                        startDelay = 150;
                        lifetime = 35;
                        sizeFrom = 150;
                        sizeTo = 0;
                        strokeFrom = 6;
                        strokeTo = 0;
                        colorFrom = 尘埃Bullet颜色1;
                        colorTo = 尘埃Bullet颜色2;
                    }},
                    new WaveEffect() {{
                        startDelay = 130;
                        lifetime = 50;
                        sizeFrom = 50;
                        sizeTo = 0;
                        strokeFrom = 6;
                        strokeTo = 0;
                        colorFrom = 尘埃Bullet颜色1;
                        colorTo = 尘埃Bullet颜色2;
                    }},
                    new WaveEffect() {{
                        startDelay = 100;
                        lifetime = 50;
                        sizeFrom = 70;
                        sizeTo = 0;
                        strokeFrom = 6;
                        strokeTo = 0;
                        colorFrom = 尘埃Bullet颜色1;
                        colorTo = 尘埃Bullet颜色2;
                    }},
                    new WaveEffect() {{
                        startDelay = 50;
                        lifetime = 50;
                        sizeFrom = 110;
                        sizeTo = 0;
                        strokeFrom = 6;
                        strokeTo = 0;
                        colorFrom = 尘埃Bullet颜色1;
                        colorTo = 尘埃Bullet颜色2;
                    }},
                    new WaveEffect() {{
                        lifetime = 200;
                        sizeFrom = 150;
                        sizeTo = 0;
                        strokeFrom = 6;
                        strokeTo = 0;
                        colorFrom = 尘埃Bullet颜色1;
                        colorTo = 尘埃Bullet颜色2;
                    }},
            };
        }};
    }

    public static Effect 尘埃子弹2次击中消失效果() {
        return new MultiEffect() {{
            lifetime = 80;
            effects = new Effect[]{

                    new WaveEffect() {{
                        lifetime = 30;
                        sizeFrom = 150;//开始范围直径
                        sizeTo = 0;//结束范围直径
                        strokeFrom = 8;//开始圈的线的粗度
                        strokeTo = 0;//结束圈的线的粗度
                        colorFrom = 尘埃Bullet颜色2;
                        colorTo = 尘埃Bullet颜色1;
                    }},

                    new WaveEffect() {{
                        startDelay = 25;//延迟出现时间
                        lifetime = 30;
                        sizeFrom = 50;
                        sizeTo = 0;
                        strokeFrom = 6;
                        strokeTo = 0;
                        colorFrom = 尘埃Bullet颜色2;
                        colorTo = 尘埃Bullet颜色1;
                    }},
                    new WaveEffect() {{
                        lifetime = 30;
                        sizeFrom = 100;
                        sizeTo = 0;
                        strokeFrom = 8;
                        strokeTo = 0;
                        colorFrom = 尘埃Bullet颜色2;
                        colorTo = 尘埃Bullet颜色1;
                    }},

                    new WaveEffect() {{
                        startDelay = 30;
                        lifetime = 30;
                        sizeFrom = 0;
                        sizeTo = 100;
                        strokeFrom = 6;
                        strokeTo = 0;
                        colorFrom = 尘埃Bullet颜色2;
                        colorTo = 尘埃Bullet颜色1;
                    }},
                    new WaveEffect() {{
                        startDelay = 50;
                        lifetime = 30;
                        sizeFrom = 0;
                        sizeTo = 100;
                        strokeFrom = 6;
                        strokeTo = 0;
                        colorFrom = 尘埃Bullet颜色2;
                        colorTo = 尘埃Bullet颜色1;
                    }},
                    new ParticleEffect() {{
                        lightOpacity = 0;
                        particles = 50;
                        length = 250;
                        baseLength = 5;
                        lifetime = 150;
                        layer = 106;
                        interp = Interp.circleOut;
                        sizeFrom = 24;
                        sizeTo = 10;
                        colorFrom = 尘埃Bullet颜色1;
                        colorTo = 尘埃Bullet颜色2;
                    }},
                    new ParticleEffect() {{
                        lightOpacity = 0;
                        particles = 50;
                        length = 250;
                        baseLength = 10;
                        lifetime = 180;
                        layer = 106;
                        interp = Interp.circleOut;
                        sizeFrom = 30;
                        sizeTo = 23;
                        colorFrom = 尘埃Bullet颜色1;
                        colorTo = 尘埃Bullet颜色2;
                        ;
                    }}
            };
        }};
    }

    public static Effect 尘埃子弹拖尾效果() {
        return new MultiEffect() {{
            lifetime = 20;
            layer = 105;
            effects = new Effect[]{
                    new ParticleEffect() {{
                        lightOpacity = 0;
                        length = 105;
                        cone = 0;
                        randLength = false;
                        sizeFrom = 45;
                        sizeTo = 45;
                        region = "ct-菱形2";
                        ;
                        particles = 1;
                        lifetime = 35;
                        colorFrom = 尘埃Bullet颜色2;
                        colorTo = 尘埃Bullet颜色1;
                        spin = 6.5f;
                    }},
                    new ParticleEffect() {{
                        lightOpacity = 0;
                        length = 105;
                        cone = 0;
                        randLength = false;
                        sizeFrom = 60;
                        sizeTo = 60;
                        region = "ct-菱形3";
                        ;
                        particles = 1;
                        lifetime = 35;
                        colorFrom = 尘埃Bullet颜色2;
                        colorTo = 尘埃Bullet颜色1;
                        spin = -6.5f;
                    }}
            };
        }};
    }

    public static DrawTurret 起源装弹效果() {//两个3角型旋转
        return new DrawTurret() {{
            parts.addAll(
                    new ShapePart() {{
                        progress = reload;
                        y = 0;
                        sides = 3;//边数
                        color = 起源Bullet颜色1;
                        stroke = 1;
                        strokeTo = 1;
                        radius = 17;
                        radiusTo = 0;
                        //circle= true;//圆
                        hollow = true;
                        layer = 110;
                        rotateSpeed = 0.5f;//旋转
                    }},
                    new ShapePart() {{
                        progress = reload;
                        y = 0;
                        sides = 3;//边数
                        color = 起源Bullet颜色1;
                        stroke = 1;//线条粗细初始值
                        strokeTo = 0;//线条粗细结束值
                        radius = 17;
                        radiusTo = 0;
                        //circle= true;//圆
                        hollow = true;
                        layer = 110;
                        rotateSpeed = -0.5f;//旋转
                    }}
            );
        }};
    }

    public static DrawTurret 皇后装弹效果() {//两个3角型旋转
        return new DrawTurret() {{
            parts.addAll(

                    new ShapePart() {{
                        progress = reload;
                        y = 17;
                        sides = 3;//边数
                        color = 皇后Bullet颜色3;
                        colorTo = 皇后Bullet颜色2;
                        stroke = 2;
                        strokeTo = 2;
                        radius = 5;
                        radiusTo = 0;
                        //circle= true;//圆
                        rotation = 0;
                        hollow = true;
                        layer = 110;
                        rotateSpeed = 0.5f;//旋转
                    }},
                    new ShapePart() {{
                        progress = reload;
                        y = 17;
                        sides = 3;//边数
                        color = 皇后Bullet颜色3;
                        colorTo = 皇后Bullet颜色2;
                        stroke = 2;//线条粗细初始值
                        strokeTo = 2;//线条粗细结束值
                        radius = 5;
                        radiusTo = 0;
                        //circle= true;//圆
                        rotation = 180;
                        hollow = true;
                        layer = 110;
                        rotateSpeed = 0.5f;//旋转
                    }}, new ShapePart() {{
                        progress = reload;
                        y = 17;
                        //sides = 3;//边数
                        color = 皇后Bullet颜色3;
                        stroke = 3;//线条粗细初始值
                        strokeTo = 3.5f;//线条粗细结束值
                        radius = 2f;
                        radiusTo = 0;
                        circle = true;//圆
                        rotation = 180;
                        hollow = true;
                        layer = 110;
                        rotateSpeed = 0f;//旋转
                    }}
            );
        }};
    }

    public static DrawTurret 帝王装弹效果() {//两个3角型旋转
        return new DrawTurret() {{
            parts.addAll(

                    new ShapePart() {{
                        progress = reload;
                        y = 17;
                        sides = 3;//边数
                        color = 帝王Bullet颜色1;
                        colorTo = 帝王Bullet颜色2;
                        stroke = 2;
                        strokeTo = 2;
                        radius = 5;
                        radiusTo = 0;
                        //circle= true;//圆
                        rotation = 0;
                        hollow = true;
                        layer = 110;
                        rotateSpeed = 0.5f;//旋转
                    }},
                    new ShapePart() {{
                        progress = reload;
                        y = 17;
                        sides = 3;//边数
                        color = 帝王Bullet颜色3;
                        colorTo = 帝王Bullet颜色2;
                        stroke = 2;//线条粗细初始值
                        strokeTo = 2;//线条粗细结束值
                        radius = 5;
                        radiusTo = 0;
                        //circle= true;//圆
                        rotation = 180;
                        hollow = true;
                        layer = 110;
                        rotateSpeed = 0.5f;//旋转
                    }}, new ShapePart() {{
                        progress = reload;
                        y = 17;
                        //sides = 3;//边数
                        color = 帝王Bullet颜色3;
                        stroke = 3;//线条粗细初始值
                        strokeTo = 3.5f;//线条粗细结束值
                        radius = 2f;
                        radiusTo = 0;
                        circle = true;//圆
                        rotation = 180;
                        hollow = true;
                        layer = 110;
                        rotateSpeed = 0f;//旋转
                    }}
            );
        }};
    }

    public static final Rand rand = new Rand();

    public static Effect 普通击中despawnEffect(Color 颜色) {
        return new Effect(14, 55f, e -> {
            {
                color(Color.white, 颜色, e.fin());
                e.scaled(7f, s -> {
                    stroke(0.5f + s.fout());
                    Lines.circle(e.x, e.y, s.fin() * 5f);
                });
                stroke(0.5f + e.fout());
                randLenVectors(e.id, 5, e.fin() * 15f, (x, y) -> {
                    float ang = Mathf.angle(x, y);
                    lineAngle(e.x + x, e.y + y, ang, e.fout() * 3 + 1f);
                });
                Drawf.light(e.x, e.y, 20f, 颜色, 0.6f * e.fout());
                Drawf.tri(e.x, e.y, 2, 10, e.rotation + 180);
                Drawf.tri(e.x, e.y, 10, 2, e.rotation + 180);
                Fill.circle(e.x, e.y, e.fout() + 3f);
            }
        });
    }


    public static Effect 毁灭despawnEffect() {
        return new Effect(30, 55f, b -> {
            float intensity = 6.8f;
            float baseLifetime = 25f + intensity * 11f;
            b.lifetime = 50f + intensity * 65f;
            color(Color.valueOf("c6a873"));
            alpha(0.7f);
            for (int i = 0; i < 4; i++) {
                rand.setSeed(b.id * 2 + i);
                float lenScl = rand.random(0.4f, 1f);
                int fi = i;
                b.scaled(60, e -> {
                    randLenVectors(e.id + fi - 1, e.fin(Interp.pow10Out), (int) (2.9f * intensity), 22f * intensity, (x, y, in, out) -> {
                        float fout = e.fout(Interp.pow5Out) * rand.random(0.5f, 1f);
                        float rad = fout * ((2f + intensity) * 2.35f);

                        Fill.circle(e.x + x, e.y + y, rad);
                        Drawf.light(e.x + x, e.y + y, rad * 2.5f, Color.valueOf("f99592"), 0.5f);
                    });
                });
            }
            b.scaled(baseLifetime, e -> {
                Draw.color();
                e.scaled(5 + intensity * 2f, i -> {
                    stroke((3.1f + intensity / 5f) * i.fout());
                    Lines.circle(e.x, e.y, (3f + i.fin() * 14f) * intensity);
                    Drawf.light(e.x, e.y, i.fin() * 14f * 2f * intensity, Color.white, 0.9f * e.fout());
                });
                color(Pal.lighterOrange, Pal.reactorPurple, e.fin());
                stroke((2f * e.fout()));
                Draw.z(Layer.effect + 0.001f);
                randLenVectors(e.id + 1, e.finpow() + 0.001f, (int) (8 * intensity), 28f * intensity, (x, y, in, out) -> {
                    lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + out * 4 * (4f + intensity));
                    Drawf.light(e.x + x, e.y + y, (out * 4 * (3f + intensity)) * 3.5f, Draw.getColor(), 0.8f);
                });
            });
        });
    }


    public static Effect 赤狐trailEffect(Color 颜色) {
        return new Effect(20, e -> {
            color(颜色);
            Fill.circle(e.x, e.y, e.rotation * e.fout());
            randLenVectors(e.id, 3, 2f + 15f * e.finpow(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, e.fout() * 3f + 0.5f);
            });
        });
    }

    public static Effect 子弹抛壳(float 抛壳大小, float 抛壳距离, Color Color1, Color Color2, Color Color3) {
        return new Effect(34f, e -> {
            color(Color1, Color2, Color3, e.fin());
            alpha(e.fout(0.3f));
            float rot = Math.abs(e.rotation) + 90f;
            int i = -Mathf.sign(e.rotation);
            float len = (2f + e.finpow() * 抛壳距离) * i;
            float lr = rot + e.fin() * 20f * i;
            rect(Core.atlas.find("casing"),
                    e.x + trnsx(lr, len) + Mathf.randomSeedRange(e.id + i + 7, 3f * e.fin()),
                    e.y + trnsy(lr, len) + Mathf.randomSeedRange(e.id + i + 8, 3f * e.fin()),
                    抛壳大小 + 0, 抛壳大小 + 1, rot + e.fin() * 50f * i
            );
        }).layer(Layer.bullet);
    }

    public static Effect 子弹抛壳2(float 抛壳大小, float 抛壳距离, Color Color1, Color Color2, Color Color3) {
        return new Effect(40f, e -> {
            color(Color1, Color2, Color3, e.fin());
            alpha(e.fout(0.5f));
            float rot = Math.abs(e.rotation) + 90f;
            int i = -Mathf.sign(e.rotation);
            float len = (4f + e.finpow() * 9f) * i;
            float lr = rot + Mathf.randomSeedRange(e.id + i + 6, 20f * e.fin()) * i;

            rect(Core.atlas.find("casing"),
                    e.x + trnsx(lr, len) + Mathf.randomSeedRange(e.id + i + 7, 3f * e.fin()),
                    e.y + trnsy(lr, len) + Mathf.randomSeedRange(e.id + i + 8, 3f * e.fin()),
                    抛壳大小 + 0, 抛壳大小 + 2,
                    rot + e.fin() * 50f * i
            );
        }).layer(Layer.bullet);

    }
}
