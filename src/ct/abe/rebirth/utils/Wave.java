package ct.abe.rebirth.utils;

import arc.Events;
import arc.graphics.Color;
import arc.math.Mathf;
import arc.scene.event.Touchable;
import arc.scene.ui.layout.Table;
import arc.util.Time;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.game.Team;
import mindustry.ui.Styles;

import java.util.concurrent.atomic.AtomicReference;

public class Wave {
    public boolean enable = false;

    public int displayTime = 3;

    public Wave() {
        Events.on(EventType.WorldLoadEvent.class, (ea) -> {
            if (Vars.state.isCampaign() && !enable) {
                enable = true;
                Vars.ui.hudGroup.find("skip").clicked(() -> {

                    float multiple = Float.parseFloat(Vars.state.rules.tags.get("增加敌对伤害生命倍率") == null ? "0.2" : Vars.state.rules.tags.get("增加敌对伤害生命倍率"));
                    if (multiple >= 0) {
                        Vars.state.rules.tags.put("增加敌对伤害生命倍率", String.valueOf(multiple + 0.2f));
                    }
                    Vars.state.rules.teams.get(Team.malis).unitDamageMultiplier = multiple;
                    Vars.state.rules.teams.get(Team.malis).unitHealthMultiplier = multiple;
                    showTips(displayTime, "敌人攻击血量已增加" + String.format("%.2f", multiple * 10) + "%", Color.white, Color.red);
                });
            }
        });

    }

    private void showTips(float sec, String msg, Color color, Color color2) {
        sec *= 60.0F;
        AtomicReference<Float> lifeTime2 = new AtomicReference(sec);
        Table tab = new Table();
        tab.setFillParent(true);
        Table tabl = new Table();
        tabl.collapser((top) -> {
            top.background(Styles.black6).add(msg).pad(8.0F).update((label) -> {
                label.color.set(color).lerp(color2, Mathf.absin(Time.time, 4.0F, 2.0F));
            });
        }, true, () -> {
            if (Vars.state.isPaused()) {
                return false;
            } else if (Vars.state.isMenu()) {
                return false;
            } else {
                lifeTime2.updateAndGet((v) -> {
                    return v - Time.delta;
                });
                return (Float) lifeTime2.get() > 0.0F;
            }
        }).touchable(Touchable.disabled).fillX().row();
        tab.center().bottom().visibility = () -> {
            return Vars.ui.hudfrag.shown;
        };
        tab.marginBottom(350.0F);
        tab.add(tabl);
        Vars.ui.hudGroup.addChild(tab);
    }


}