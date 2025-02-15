package ct.content;

import arc.graphics.Color;
import arc.math.Mathf;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.type.StatusEffect;

public class RebirthBuffs {
    public static StatusEffect 毒;

    public static void load() {
        毒 = new StatusEffect("毒") {
            {
                localizedName = "中毒";
                color = Color.valueOf("24f667");
                speedMultiplier = 0.8F;
                healthMultiplier = 0.8F;
                damage = 0.5F;
                effect = Fx.melting;
      /*          init(() -> {
                   // opposite(new StatusEffect[]{StatusEffects.wet, StatusEffects.freezing});
                    affinity(StatusEffects.tarred, (unit, result, time) -> {
                        unit.damagePierce(8.0F);
                        Fx.burning.at(unit.x + Mathf.range(unit.bounds() / 2.0F), unit.y + Mathf.range(unit.bounds() / 2.0F));
                        result.set(StatusEffects.melting, Math.min(time + result.time, 200.0F));
                    });
                });*/
            }
        };
    }
}
