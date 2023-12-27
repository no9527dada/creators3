package ct.abe.rebirth.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Mathf;
import ct.abe.rebirth.utils.LogicFxInit;
import mindustry.entities.Effect;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.logic.LogicFx;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.stroke;
import static arc.math.Angles.randLenVectors;

public class NewFx {
    public static Effect D1, D2, D3, D4;

    public static void load() {
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
    static Effect  赤狐trailEffect(Color 颜色){
        return   new Effect(50, e -> {
            color(颜色);
            Fill.circle(e.x, e.y, e.rotation * e.fout());
            randLenVectors(e.id, 5, 2f + 23f * e.finpow(), (x, y) -> {
                Fill.circle(e.x + x, e.y + y, e.fout() * 3f + 0.5f);
            });
        });
    }
}
