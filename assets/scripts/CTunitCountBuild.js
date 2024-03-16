
function FactoryBuildProv(block, unitCount, customImpCons) {
    return () => {
        let defImp = new FactoryBuildImp(unitCount);
        if (customImpCons) {
            let customImp = customImpCons(defImp);
            Object.assign(defImp, customImp)
        };
        return extend(UnitFactory.UnitFactoryBuild, block, defImp)
    }
}
function FactoryBuildImp(count) {
    var unitCount = count; var unitMap = new ObjectMap();
    return {
        onRemoved() {
            this.super$onRemoved();
            unitMap.each((typeID, units) => {
                units.each(id => {
                    let unit = Groups.unit.getByID(id);
                    if (unit != null && unit.isValid()) { unit.kill() }
                })
            })
        },
        updateTile() {
            this.super$updateTile();
            this.checkUnits()
        },
        display(table) {
            this.super$display(table);
            if (unitMap.isEmpty()) return;
            table.marginBottom(0);
            table.row();
            table.table(null, main => {
                main.defaults().growX();
                main.table(Tex.whiteui, title => { title.add("Units") }).color(Pal.gray);
                main.row();
                main.table(Tex.pane2, bars => {
                    bars.defaults().growX().height(18).pad(4);
                    unitMap.each((type, units) => { addBar(type, units) });
                    function addBar(type, units) {
                        bars.add(new Bar(() => Core.bundle.format("bar.unitcap", type.emoji(), units.size, unitCount),
                            () => Pal.power, () => units.size / unitCount));
                        bars.row()
                    }
                })
            }).pad(8).growX()
        },
        checkUnits() {
            if (unitMap.isEmpty()) return;
            let { payload } = this; let payloadUnitID = payload == null ? -1 : payload.unit.id;
            unitMap.each((type, units) => {
                for (
                    let i = 0;
                    i < units.size; i++) {
                    let id = units.get(i);
                    let u = Groups.unit.getByID(id);
                    if (payloadUnitID != id && (u == null || !u.isValid())) { units.removeIndex(i--) }
                }
            })
        },
        shouldConsume() {
            let superResult = this.super$shouldConsume();
            let type = this.unit();
            return superResult && type != null && this.getUnitIDs(type).size < unitCount
        }, consume() {
            this.super$consume();
            let unit = this.payload.unit;
            let units = this.getUnitIDs(unit.type);
            units.add(unit.id)
        }, getUnitIDs(type) { return unitMap.get(type, prov(() => new IntSeq())) }, drawSelect() {
            this.super$drawSelect();
            if (unitMap.isEmpty()) return;
            unitMap.each((typeID, units) => {
                units.each(id => {
                    let unit = Groups.unit.getByID(id);
                    if (unit == null || !unit.isValid()) return;
                    this.drawUnitLink(unit)
                })
            })
        }, drawUnitLink(unit) {
            let { x, y, block } = this;
            let unitX = unit.x, unitY = unit.y;
            let drawX, drawY; let angle = Angles.angleRad(x, y, unitX, unitY);
            let sin = Math.sin(angle), cos = Math.cos(angle);
            let tan = Math.abs(sin / cos);
            let size = block.size * Vars.tilesize;
            let halfSize = size / 2;
            let sx = Mathf.sign(unitX >= x), sy = Mathf.sign(unitY >= y);
            if (tan <= 1) {
                drawX = x + sx * halfSize; drawY = y + sy * halfSize * tan
            }
            else { drawX = x + sx * halfSize / tan; drawY = y + sy * halfSize } let circleRadius = 2,
                unitRadius = unit.hitSize * 1.2;
            let startX = drawX + circleRadius * cos, startY = drawY + circleRadius * sin;
            let endX = unitX - unitRadius * cos, endY = unitY - unitRadius * sin;
            let rot = angle * Mathf.radDeg + 45; Lines.stroke(3, Pal.gray); Lines.square(drawX, drawY, circleRadius, rot);
            Lines.line(startX, startY, endX, endY);
            Lines.square(unitX, unitY, unitRadius, rot);
            Lines.stroke(1, Pal.accent);
            Lines.square(drawX, drawY, circleRadius, rot);
            Lines.line(startX, startY, endX, endY);
            Lines.square(unitX, unitY, unitRadius, rot)
        }, write(write) {
            this.super$write(write);
            if (unitMap.isEmpty()) return;
            write.i(unitMap.size);
            unitMap.each((type, seq) => {
                write.i(type.id); write.i(seq.size); seq.each(id => { write.i(id) })
            })
        },
        read(read, revision) {
            this.super$read(read, revision); unitMap.clear();
            let mapSize = read.i();
            for (let i = 0; i < mapSize; i++) {
                let typeID = read.i();
                let type = Vars.content.unit(typeID);
                if (type == null) { Log.err("Faild read unit's id: @", typeID); continue }
                let seq = this.getUnitIDs(type);
                let seqSize = read.i();
                for (let j = 0; j < seqSize; j++) {
                    let unitID = read.i();
                    seq.add(unitID)
                }
            }
        },
    }
} exports.FactoryBuildProv = FactoryBuildProv;