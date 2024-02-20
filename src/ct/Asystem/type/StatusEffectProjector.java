package qodhshai.block.defense;
//单位状态生成仪

import arc.graphics.g2d.Lines;
import arc.struct.Seq;
import mindustry.entities.Effect;
import mindustry.entities.Units;
import mindustry.gen.Building;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.type.PayloadSeq;
import mindustry.type.StatusEffect;
import mindustry.ui.Bar;
import mindustry.world.blocks.payloads.BuildPayload;
import mindustry.world.blocks.payloads.Payload;
import mindustry.world.blocks.payloads.PayloadBlock;
import mindustry.world.consumers.Consume;
import mindustry.world.consumers.ConsumePayloadFilter;
import mindustry.world.consumers.ConsumePower;

public class StatusEffectProjector extends PayloadBlock {
    public Seq<StatusEffectPlan> plans = new Seq<>(1);
    public float range = 120f;
    public Consume consumePower = new ConsumePower(0, 0, false);


    public StatusEffectProjector(String name) {
        super(name);
        update = true;
        solid = true;
        hasItems = true;
        hasLiquids = true;
        hasPower = true;
        sync = true;
        drawArrow = false;
        outputsPayload = false;
        acceptsPayload = true;
    }

    @Override
    public void init() {
        plans.forEach(statusEffectPlan -> consume(statusEffectPlan.consume));
        consume(consumePower);
        super.init();
    }

    @Override
    public void setBars() {
        super.setBars();
        addBar("progress", (StatusEffectProjectorBuild entity) -> new Bar("bar.progress", Pal.ammo, entity::progress));
    }

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid) {
    }

    public static class StatusEffectPlan {
        public StatusEffect statusEffect;
        public Consume consume;
        public float consumeTime;

        public StatusEffectPlan(StatusEffect statusEffect, Consume consume, float consumeTime) {
            this.statusEffect = statusEffect;
            this.consume = consume;
            this.consumeTime = consumeTime;
        }
    }

    public class StatusEffectProjectorBuild extends PayloadBlockBuild<BuildPayload> {
        public StatusEffectPlan currentPlan;
        public float statusEffectTimer = 0;
        public PayloadSeq payloadSeq = new PayloadSeq();

        @Override
        public void drawSelect() {
            Drawf.dashCircle(x, y, range, Pal.accent);
        }

        @Override
        public float progress() {
            return currentPlan == null ? 0 : statusEffectTimer / currentPlan.consumeTime;
        }

        @Override
        public boolean acceptPayload(Building source, Payload payload) {
            if (!payloadSeq.isEmpty() || this.payload != null) {
                return false;
            }
            return plans.find(statusEffectPlan -> statusEffectPlan.consume instanceof ConsumePayloadFilter c
                    && c.filter.get(payload.content())) != null;
        }


        @Override
        public PayloadSeq getPayloads() {
            return payloadSeq;
        }

        @Override
        public void updateTile() {
            if (payload != null && hasArrived() && payloadSeq.isEmpty()) {
                payloadSeq.add(payload.content(), 1);
                payload = null;
            }
            moveInPayload();

            boolean work = false;
            for (StatusEffectPlan statusEffectPlan : plans) {
                if (statusEffectPlan.consume.efficiency(this) > 0) {
                    if (currentPlan != null && currentPlan != statusEffectPlan) {
                        currentPlan.consume.trigger(this);
                        statusEffectTimer = 0;
                    }
                    currentPlan = statusEffectPlan;
                    work = true;
                    break;
                }
            }

            if (!work) currentPlan = null;

            if (currentPlan == null) return;
            consumePower.trigger(this);
            efficiency(currentPlan.consume.efficiency(this) * consumePower.efficiency(this));

            statusEffectTimer += delta() * efficiency;
            Units.nearby(team, x, y, range, unit -> unit.apply(currentPlan.statusEffect, currentPlan.consumeTime * efficiency));
            if (statusEffectTimer > currentPlan.consumeTime) {
                currentPlan.consume.trigger(this);
                statusEffectTimer = 0;
                bigRound.at(x, y, range);
            }
            super.updateTile();
        }

        public Effect bigRound = new Effect(30f, e -> {
            Lines.stroke(4f * e.fout(), Pal.accent);
            Lines.circle(e.x, e.y, e.rotation * e.finpow());
        });

        @Override
        public void draw() {
            drawPayload();
            super.draw();
        }
    }
}
