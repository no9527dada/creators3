package ct.Asystem.type;

import arc.Core;
import mindustry.entities.abilities.UnitSpawnAbility;
import mindustry.gen.Unit;
import mindustry.type.UnitType;

//单位下崽能力 去掉生产时的特效
public class CTUnitSpawnAbility extends UnitSpawnAbility {
    public CTUnitSpawnAbility(UnitType unit, float spawnTime, float spawnX, float spawnY) {
        this.unit = unit;
        this.spawnTime = spawnTime;
        this.spawnX = spawnX;
        this.spawnY = spawnY;
    }

    @Override
    public void draw(Unit unit) {/*
        if(Units.canCreate(unit.team, this.unit)){
            Draw.draw(Draw.z(), () -> {
                float x = unit.x + Angles.trnsx(unit.rotation, spawnY, spawnX), y = unit.y + Angles.trnsy(unit.rotation, spawnY, spawnX);
                Drawf.construct(x, y, this.unit.fullIcon, unit.rotation - 90, timer / spawnTime, 1f, timer);
            });
        }*/
    }

    @Override
    public String localized() {
        return Core.bundle.format("ability.unitspawn", unit.localizedName);
    }
}
