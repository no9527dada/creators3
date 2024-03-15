package ct.Asystem.type.factory;

import arc.Core;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Mathf;
import arc.scene.ui.layout.Table;
import arc.struct.IntSeq;
import arc.struct.ObjectMap;
import arc.struct.Seq;
import arc.util.Log;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.Vars;
import mindustry.gen.Groups;
import mindustry.gen.Tex;
import mindustry.gen.Unit;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.ui.Bar;
import mindustry.world.blocks.units.UnitFactory;

/*
 *@Author:LYBF
 *@Date  :2024/3/11
 */
public class CreatorsUnitFactory extends UnitFactory {
    public int unitCount;

    public ObjectMap<UnitType, IntSeq> unitMap = new ObjectMap();

    public CreatorsUnitFactory(String name) {
        super(name);
    }

    public CreatorsUnitFactory(String name, Seq<UnitPlan> unitPlan) {
        super(name);
        plans = unitPlan;
    }


    public class CreatorsUnitFactoryBuild extends UnitFactoryBuild {

        @Override
        public void updateTile() {
            super.updateTile();
            checkUnits();
        }

        public void display(Table table) {
            super.display(table);
            if (unitMap.isEmpty()) return;
            table.marginBottom(0);
            table.row();
            table.table(null, main -> {
                main.defaults().growX();
                main.table(Tex.whiteui, title -> {
                    title.add("Units");
                }).color(Pal.gray);
                main.row();
                main.table(Tex.pane2, bars -> {
                    bars.defaults().growX().height(18).pad(4);
                    unitMap.each((type, units) -> {
                        bars.add(new Bar(() -> Core.bundle.format("bar.unitcap", type.emoji(), units.size, unitCount),
                                () -> Pal.power, () -> units.size / unitCount));
                        bars.row();
                    });
                }).pad(8).growX();
            });

        }

        public void checkUnits() {
            if (unitMap.isEmpty()) return;
            CreatorsUnitFactoryBuild payload = this;
            int payloadUnitID = payload == null ? -1 : payload.unit().id;
            unitMap.each((type, units) -> {
                for (int i = 0; i < units.size; i++) {
                    int id = units.get(i);
                    Unit u = Groups.unit.getByID(id);
                    if (payloadUnitID != id && (u == null || !u.isValid())) {
                        units.removeIndex(i--);
                    }
                }
            });
        }

        @Override
        public void onRemoved() {
            super.onRemoved();
            unitMap.each((typeID, units) -> {
                units.each((unit) -> {
                    Unit unit2 = Groups.unit.getByID(unit);
                    if (unit2 != null && unit2.isValid()) {
                        unit2.kill();
                    }
                });
            });
        }

        @Override
        public boolean shouldConsume() {
            boolean superResult = super.shouldConsume();
            UnitType type = this.unit();
            return superResult && type != null && this.getUnitIDs(type).size < unitCount;
        }

        @Override
        public void consume() {
            super.consume();
            Unit unit = this.payload.unit;
            IntSeq units = this.getUnitIDs(unit.type);
            units.add(unit.id);
        }

        public IntSeq getUnitIDs(UnitType type) {
            return unitMap.get(type, () -> new IntSeq());
        }

        @Override
        public void drawSelect() {
            super.drawSelect();
            if (unitMap.isEmpty()) return;
            unitMap.each((typeID, units) -> {
                units.each(id -> {
                    Unit unit = Groups.unit.getByID(id);
                    if (unit == null || !unit.isValid()) return;
                    this.drawUnitLink(unit);
                });
            });
        }

        public void drawUnitLink(Unit unit) {
            float unitX = unit.x, unitY = unit.y;
            float drawX, drawY;
            float angle = Angles.angleRad(x, y, unitX, unitY);
            double sin = Math.sin(angle), cos = Math.cos(angle);
            double tan = Math.abs(sin / cos);
            int size = block.size * Vars.tilesize;
            int halfSize = size / 2;
            int sx = Mathf.sign(unitX >= x), sy = Mathf.sign(unitY >= y);
            if (tan <= 1) {
                drawX = x + sx * halfSize;
                drawY = (float) (y + sy * halfSize * tan);
            } else {
                drawX = (float) (x + sx * halfSize / tan);
                drawY = y + sy * halfSize;
            }

            float circleRadius = 2f,
                    unitRadius = (float) (unit.hitSize * 1.2);

            float startX = (float) (drawX + circleRadius * cos),
                    startY = (float) (drawY + circleRadius * sin);
            float endX = (float) (unitX - unitRadius * cos),
                    endY = (float) (unitY - unitRadius * sin);
            float rot = angle * Mathf.radDeg + 45;
            Lines.stroke(3, Pal.gray);
            Lines.square(drawX, drawY, circleRadius, rot);
            Lines.line(startX, startY, endX, endY);
            Lines.square(unitX, unitY, unitRadius, rot);
            Lines.stroke(1, Pal.accent);
            Lines.square(drawX, drawY, circleRadius, rot);
            Lines.line(startX, startY, endX, endY);
            Lines.square(unitX, unitY, unitRadius, rot);
        }

        @Override
        public void write(Writes write) {
            super.write(write);
            if (unitMap.isEmpty()) return;
            write.i(unitMap.size);
            unitMap.each((type, seq) -> {
                write.i(type.id);
                write.i(seq.size);
                seq.each(write::i);
            });
        }

        @Override
        public void read(Reads read, byte revision) {
            super.read(read, revision);
            unitMap.clear();
            int mapSize = read.i();
            for (int i = 0; i < mapSize; i++) {
                int typeID = read.i();
                UnitType type = Vars.content.unit(typeID);
                if (type == null) {
                    Log.err("Faild read unit's id: @", typeID);
                    continue;
                }
                IntSeq seq = this.getUnitIDs(type);
                int seqSize = read.i();
                for (int j = 0; j < seqSize; j++) {
                    int unitID = read.i();
                    seq.add(unitID);
                }
            }
        }
    }

}
