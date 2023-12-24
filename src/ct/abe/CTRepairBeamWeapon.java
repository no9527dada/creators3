package ct.abe;

import arc.func.Cons;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import arc.math.geom.Rect;
import arc.util.Time;
import arc.util.Tmp;
import mindustry.entities.units.WeaponMount;
import mindustry.gen.Building;
import mindustry.gen.Bullet;
import mindustry.gen.Groups;
import mindustry.gen.Unit;
import mindustry.type.weapons.RepairBeamWeapon;

public class CTRepairBeamWeapon extends RepairBeamWeapon {
    public Color 光条颜色 ;
    public static Unit unit;
    public static float BlockRange;
    public static Building building;
    public static final Cons<Bullet> consumer = example -> {
        if (example.team != unit.team && Tmp.r1.set(new Rect().setCentered(building.x, building.y, BlockRange * 2f)).contains(Tmp.v1.set(example.x, example.y))) {
            example.absorb();
        }
    };

    public CTRepairBeamWeapon(String name){
        super(name);

        reload = 1f;
        predictTarget = false;
        autoTarget = true;
        controllable = false;
        rotate = true;
        useAmmo = false;
        mountType = HealBeamMount::new;
        recoil = 0f;
        noAttack = true;
    }

    public CTRepairBeamWeapon(){
        reload = 1f;
        predictTarget = false;
        autoTarget = true;
        controllable = false;
        rotate = true;
        useAmmo = false;
        mountType = HealBeamMount::new;
        recoil = 0f;
        noAttack = true;
        光条颜色=Color.valueOf("6ef591");;
    }

    public void update(Unit unit, WeaponMount mount) {
        super.update(unit, mount);
        HealBeamMount heal = (HealBeamMount)mount;

        if (heal.target instanceof Building && mount.shoot) {
            Building b = (Building)heal.target;

            float range = b.block.size * 4F + 8;

            CTRepairBeamWeapon.unit = unit;
            CTRepairBeamWeapon.BlockRange = range;
            CTRepairBeamWeapon.building = b;

            Groups.bullet.intersect(b.x - range, b.y - range, range * 2f, range * 2f, consumer);
        }

    }

    public void draw(Unit unit, WeaponMount mount) {
        super.draw(unit, mount);
        if (mount.target instanceof Building && mount.shoot) {
            Building b = (Building)mount.target;

            float range = b.block.size * 4F + 16;
            Draw.color(Color.white, 光条颜色/*team.color*/, Mathf.absin(Time.time, 4.0F, 1.0F));
            Lines.poly(b.x, b.y, 4, range, 45);
        }
    }
}
