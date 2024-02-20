package ct.content.Effect;

import arc.graphics.Color;
import arc.math.Interp;
import ct.content.NewColor;
import mindustry.entities.part.HaloPart;
import mindustry.entities.part.ShapePart;
import mindustry.world.draw.DrawTurret;

import static ct.content.NewColor.起源Bullet颜色1;
import static ct.content.NewColor.起源Bullet颜色2;
import static mindustry.entities.part.DrawPart.PartProgress.recoil;
import static mindustry.entities.part.DrawPart.PartProgress.warmup;

public class NewFx备份 {
    //           progress = recoil; 有目标射击射击后消失
    //           progress = warmup;有目标射击时会一直存在
    static Color Colors = Color.valueOf("62ff7d");

    public static void load() {
        new NewEffect.BulletWaveEffect() {{//一个空心圈，适用子弹击中效果
            sizeFrom = 0f;
            sizeTo = 20f;
            //持续时间
            lifetime = 20;
            strokeFrom = 2f;
            strokeTo = 0f;
            colorFrom = NewColor.光棱塔Bullet1;
            colorTo = NewColor.光棱塔Bullet2;
        }};
        new NewEffect.BulletParticleEffect() {{//实心圆，从小到大,适用蓄力效果
            particles = 1;
            sizeFrom = 1;
            sizeTo = 20;
            interp = Interp.swing;
            length = 0;
            lifetime = 80;
            colorFrom = 起源Bullet颜色1;
            colorTo = 起源Bullet颜色2;
        }};
        new NewEffect.BulletParticleEffect() {{//外部线条向内聚集缩小，,适用蓄力效果
            line = true;
            particles = 15;
            lifetime = 30;
            length = 45;
            offset = 4;
            baseLength = -45;
            cone = -360;
            lenFrom = 20;
            lenTo = 0;
            colorFrom = 起源Bullet颜色1;
            colorTo = 起源Bullet颜色2;
        }};
        new NewEffect.BulletWaveEffect() {{//空心圆，从大到小，,适用蓄力效果
            lifetime = 70;
            sizeFrom = 95;
            sizeTo = 0;
            strokeFrom = 0;
            strokeTo = 7;
            colorFrom = 起源Bullet颜色1;
            colorTo = 起源Bullet颜色2;
        }};

    }

    public static DrawTurret 效果1() {//射击后显示两道杠互相旋转
        return new DrawTurret() {{
            parts.addAll(
                    new HaloPart() {{
                        progress = recoil;
                        shapeRotation = 60;
                        y = 0;
                        sides = 3;
                        shapes = 2;
                        color = NewColor.光棱塔Bullet1;
                        colorTo = NewColor.光棱塔Bullet2;
                        tri = true;
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
                        progress = recoil;
                        shapeRotation = 30;
                        y = 0;
                        sides = 3;
                        shapes = 2;
                        color = NewColor.光棱塔Bullet1;
                        colorTo = NewColor.光棱塔Bullet2;
                        tri = true;
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

    public static DrawTurret 效果2() {//射击后显示两个多边尖锐角的圆 互相旋转
        return new DrawTurret() {{
            parts.addAll(
                    new HaloPart() {{
                        progress = recoil;
                        shapeRotation = 60;
                        y = 0;
                        sides = 3;
                        shapes = 2;
                        color = Colors;
                        colorTo = Colors;
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
                        progress = recoil;
                        shapeRotation = 30;
                        y = 0;
                        sides = 3;
                        shapes = 2;
                        color = Colors;
                        colorTo = Colors;
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

    public static DrawTurret 效果3() {//一个空心圆 射击前后不在，射击时出现 没任何动画
        return new DrawTurret() {{
            parts.addAll(
                    new ShapePart() {{
                        progress = warmup;
                        y = 0;
                        color = Colors;
                        stroke = 0;
                        strokeTo = 2;
                        circle = true;
                        hollow = true;
                        radius = 0;
                        radiusTo = 10;
                        layer = 110;
                        rotateSpeed = -5f;//旋转
                    }}
            );
        }};
    }

    public static DrawTurret 效果4() {//一个空心圆 射击前后不在，射击时出现 从小变大动画
        return new DrawTurret() {{
            parts.addAll(
                    new ShapePart() {{
                        progress = warmup;
                        y = 0;
                        color = Colors;
                        stroke = 2;
                        strokeTo = 2;
                        circle = true;
                        hollow = true;
                        radius = 10;
                        radiusTo = 10;
                        layer = 110;
                        rotateSpeed = -5f;//旋转
                        rotation = 90;//初始角度
                    }}
            );
        }};
    }

    public static DrawTurret 效果5() {//一个空心圆 任何情况下一直存在
        return new DrawTurret() {{
            parts.addAll(
                    new ShapePart() {{
                        progress = warmup;
                        y = 0;
                        color = Colors;
                        stroke = 2;
                        strokeTo = 2;
                        circle = true;
                        hollow = true;
                        radius = 10;
                        radiusTo = 10;
                        layer = 110;
                        rotateSpeed = -5f;//旋转
                    }}
            );
        }};
    }


}
