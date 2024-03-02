package ct.Asystem.type;

import arc.graphics.Color;
import arc.graphics.g2d.Lines;
import arc.math.geom.Rect;
import arc.util.Time;
import mindustry.Vars;
import mindustry.entities.Effect;
import mindustry.entities.abilities.Ability;
import mindustry.gen.Unit;

//单位给方块超速力场能力
public class OverdriveAbility extends Ability {
    public float speedBoost;//超速倍率
    public float range;//超速范围
    public float boostTime;//超速每次间隔和持续时间，默认1秒。一般不动

    public float charge = 0;

    public OverdriveAbility(float speedBoost, float range) {
        new OverdriveAbility(speedBoost, range, 60);
    }

    public OverdriveAbility(float speedBoost, float range, float boostTime) {
        this.speedBoost = speedBoost;
        this.range = range;
        this.boostTime = boostTime;
    }

    public Effect rect = new Effect(60f, (e) -> {
        Lines.stroke(2f * e.fout(), Color.valueOf("feb380"));
        Lines.rect(rect(e.x, e.y, range * e.finpow()));
    });

    public Rect rect(float x, float y, float range) {
        return new Rect(x - range / 2, y - range / 2, range, range);
    }

    @Override
    public void update(Unit unit) {
        charge += Time.delta;
        if (charge > boostTime) {
            rect.at(unit.x, unit.y);
            Vars.indexer.eachBlock(unit.team, rect(unit.x, unit.y, range), other -> other.block.canOverdrive,
                    other -> other.applyBoost(speedBoost, boostTime + 1));
            charge -= boostTime;
        }
    }
}
