package ct.Asystem.type;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.scene.style.*;
import arc.scene.ui.layout.*;
import arc.struct.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.*;
import mindustry.entities.*;
import mindustry.entities.units.*;
import mindustry.game.EventType;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.io.*;
import mindustry.logic.*;
import mindustry.type.*;
import mindustry.ui.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.units.UnitBlock;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

/**
 * 示例: unitType = new UnitPlan(UnitTypes.dagger, 60f * 15, with(Items.silicon, 10, Items.lead, 10));
 */
//新科技写的104单位工厂，有些BUG，没使用
public class oldUnitFactory extends UnitBlock {
    public int[] capacities = {};

    public UnitPlan unitType;
    public static int maxunit = 10;

    public oldUnitFactory(String name) {
        super(name);
        update = true;
        hasPower = true;
        hasItems = true;
        solid = false;
        configurable = false;
        clearOnDoubleTap = true;
        outputsPayload = false;
        rotate = false;
        regionRotated1 = 1;
        commandable = true;
        ambientSound = Sounds.respawning;

        consume(new ConsumeItemDynamic((oldUnitFactoryBuild e) -> e.currentPlan != -1 ? unitType.requirements : ItemStack.empty));
    }

    @Override
    public void init() {
        capacities = new int[Vars.content.items().size];

        for (ItemStack stack : unitType.requirements) {
            capacities[stack.item.id] = Math.max(capacities[stack.item.id], stack.amount * 2);
            itemCapacity = Math.max(itemCapacity, stack.amount * 2);
        }
        consumeBuilder.each(c -> c.multiplier = b -> state.rules.unitCost(b.team));

        super.init();
    }

    @Override
    public void setBars() {
        super.setBars();
        addBar("progress", (oldUnitFactoryBuild e) -> new Bar("bar.progress", Pal.ammo, e::fraction));

        addBar("units", (oldUnitFactoryBuild e) -> new Bar(() -> e.unit() == null ? "[lightgray]" + Iconc.cancel : Core.bundle.format("bar.unitcap", Fonts.getUnicodeStr(e.unit().name), e.units.size, maxunit), () -> Pal.power, () -> e.unit() == null ? 0f : (float) e.units.size / maxunit));
    }

    @Override
    public boolean outputsItems() {
        return false;
    }

    @Override
    public void setStats() {
        super.setStats();

        stats.remove(Stat.itemCapacity);

        stats.add(new Stat("生产"), table -> {
            table.row();

            table.table(Styles.grayPanel, t -> {

                if (unitType.unit.isBanned()) {
                    t.image(Icon.cancel).color(Pal.remove).size(40);
                    return;
                }

                if (unitType.unit.unlockedNow()) {
                    t.image(unitType.unit.uiIcon).size(40).pad(10f).left().scaling(Scaling.fit);
                    t.table(info -> {
                        info.add(unitType.unit.localizedName).left();
                        info.row();
                        info.add(Strings.autoFixed(unitType.time / 60f, 1) + " " + Core.bundle.get("unit.seconds")).color(Color.lightGray);
                    }).left();

                    t.table(req -> {
                        req.right();
                        for (int i = 0; i < unitType.requirements.length; i++) {
                            if (i % 6 == 0) {
                                req.row();
                            }

                            ItemStack stack = unitType.requirements[i];
                            req.add(new ItemDisplay(stack.item, stack.amount, false)).pad(5);
                        }
                    }).right().grow().pad(10f);
                } else {
                    t.image(Icon.lock).color(Pal.darkerGray).size(40);
                }
            }).growX().pad(5);
            table.row();
        });
    }

    @Override
    public TextureRegion[] icons() {
        return new TextureRegion[]{region, outRegion, topRegion};
    }

    @Override
    public void drawPlanRegion(BuildPlan plan, Eachable<BuildPlan> list) {
        Draw.rect(region, plan.drawx(), plan.drawy());
        Draw.rect(outRegion, plan.drawx(), plan.drawy(), plan.rotation * 90);
        Draw.rect(topRegion, plan.drawx(), plan.drawy());
    }

    public static class UnitPlan {
        public UnitType unit;
        public ItemStack[] requirements;
        public float time;

        public UnitPlan(UnitType unit, float time, ItemStack[] requirements) {
            this.unit = unit;
            this.time = time;
            this.requirements = requirements;
        }

        UnitPlan() {
        }
    }

    public class oldUnitFactoryBuild extends UnitBuild {
        public @Nullable Vec2 commandPos;
        public int currentPlan = -1;

        public Seq<Integer> units = new Seq<>();

        @Override
        public void onDestroyed() {
            killUnit();
            super.onDestroyed();
        }

        @Override
        public void remove() {
            killUnit();
            super.remove();
        }

        public void killUnit() {
           /*for (Unit unit : Groups.unit){
               if (unit.type == unitType.unit){
                   unit.kill();
               }
           }*/
            for (Integer i : units) {
                Unit unit = Groups.unit.getByID(i);
                if (unit != null) {
                    unit.kill();
                }
            }
        }


        public float fraction() {
            return currentPlan == -1 ? 0 : progress / unitType.time;
        }

        @Override
        public Vec2 getCommandPosition() {
            return commandPos;
        }

        @Override
        public void onCommand(Vec2 target) {
            commandPos = target;
        }

        @Override
        public Object senseObject(LAccess sensor) {
            if (sensor == LAccess.config) return currentPlan == -1 ? null : unitType.unit;
            return super.senseObject(sensor);
        }

        @Override
        public boolean shouldActiveSound() {
            return shouldConsume();
        }

        @Override
        public double sense(LAccess sensor) {
            if (sensor == LAccess.progress) return Mathf.clamp(fraction());
            return super.sense(sensor);
        }

        @Override
        public void buildConfiguration(Table table) {

        }

        @Override
        public boolean acceptPayload(Building source, Payload payload) {
            return false;
        }

        @Override
        public void display(Table table) {
            super.display(table);

            TextureRegionDrawable reg = new TextureRegionDrawable();

            table.row();
            table.table(t -> {
                t.left();
                t.image().update(i -> {
                    i.setDrawable(currentPlan == -1 ? Icon.cancel : reg.set(unitType.unit.uiIcon));
                    i.setScaling(Scaling.fit);
                    i.setColor(currentPlan == -1 ? Color.lightGray : Color.white);
                }).size(32).padBottom(-4).padRight(2);
                t.label(() -> currentPlan == -1 ? "@none" : unitType.unit.localizedName).wrap().width(230f).color(Color.lightGray);
            }).left();
        }

        @Override
        public Object config() {
            return currentPlan;
        }

        @Override
        public void draw() {
            Draw.rect(region, x, y);
            //Draw.rect(outRegion, x, y, rotdeg());

            if (currentPlan != -1) {
                Draw.draw(Layer.blockOver, () -> Drawf.construct(this, unitType.unit, rotdeg(), progress / unitType.time, speedScl, time));
            }

            Draw.z(Layer.blockOver);

            payRotation = rotdeg();
            drawPayload();

            Draw.z(Layer.blockOver + 0.1f);

            Draw.rect(topRegion, x, y);
        }

        boolean a = false;

        @Override
        public void updateTile() {
            if (!a) {
                Events.on(EventType.UnitDestroyEvent.class, e -> {
                    for (Integer integer : units) {
                        if (integer.equals(e.unit.id)) {
                            units.remove(integer);
                        }
                    }
                });
                a = true;
            }
      /*    for (Integer i : units){
              Unit byID = Groups.unit.getByID(i);
              if (byID != null && byID.dead){
                  units.remove(i);
              }
          }*/


            if (!configurable) {
                currentPlan = 0;
            }

            if (currentPlan < 0) {
                currentPlan = -1;
            }


            if (efficiency > 0 && currentPlan != -1 && units.size < maxunit && team.data().countType(unit()) < Units.getCap(team)) {
                time += edelta() * speedScl * Vars.state.rules.unitBuildSpeed(team);
                progress += edelta() * Vars.state.rules.unitBuildSpeed(team);
                speedScl = Mathf.lerpDelta(speedScl, 1f, 0.05f);
            } else {
                speedScl = Mathf.lerpDelta(speedScl, 0f, 0.05f);
            }

            if (currentPlan != -1) {

                //make sure to reset plan when the unit got banned after placement
                if (unitType.unit.isBanned()) {
                    currentPlan = -1;
                    return;
                }

                if (progress >= unitType.time) {
                    progress %= 1f;

                    Unit unit = unitType.unit.create(team);
                    if (commandPos != null && unit.isCommandable()) {
                        unit.command().commandPosition(commandPos);
                    }

                    unit.set(tile.drawx() + Mathf.range(4), tile.drawy() + Mathf.range(4));
                    unit.rotation = 90f;
                    unit.add();
                    units.add(unit.id);
                    Call.unitTetherBlockSpawned(tile, unit.id);
                    payVector.setZero();
                    consume();
                    Events.fire(new UnitCreateEvent(unit, this));
                }

                progress = Mathf.clamp(progress, 0, unitType.time);
            } else {
                progress = 0f;
            }
        }

        @Override
        public boolean shouldConsume() {
            if (currentPlan == -1) return false;
            return enabled;
        }

        @Override
        public int getMaximumAccepted(Item item) {
            return capacities[item.id];
        }

        @Override
        public boolean acceptItem(Building source, Item item) {
            return currentPlan != -1 && items.get(item) < getMaximumAccepted(item) && Structs.contains(unitType.requirements, stack -> stack.item == item);
        }

        public @Nullable UnitType unit() {
            return currentPlan == -1 ? null : unitType.unit;
        }

        @Override
        public byte version() {
            return 2;
        }

        @Override
        public void write(Writes write) {
            super.write(write);
            write.f(progress);
            write.s(currentPlan);
            write.i(units.size);
            for (Integer unit : units) {
                write.i(unit);
            }
            TypeIO.writeVecNullable(write, commandPos);
        }

        @Override
        public void read(Reads read, byte revision) {
            super.read(read, revision);
            progress = read.f();
            currentPlan = read.s();
            int i = read.i();
            for (int i1 = 0; i1 < i; i1++) {
                int i2 = read.i();
                units.add(i2);
            }
            if (revision >= 2) {
                commandPos = TypeIO.readVecNullable(read);
            }
        }
    }
}