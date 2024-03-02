package ct.Asystem.type;
//此类来自ExtraUtilities模组
//By:@guiY

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import mindustry.entities.abilities.Ability;
import mindustry.gen.Unit;
import mindustry.graphics.Pal;

//用法：abilities.add(new EU_healthDisplay(14, 22, 3));
public class EU_healthDisplay {
    public static class healthDisplay extends Ability {
        public float y, width, height;

        public healthDisplay(float y, float width, float height) {
            this.y = y;
            this.width = width;
            this.height = height;
        }

        @Override
        public String localized() {
            return Core.bundle.get("ability.EU_healthDisplay");
        }

        @Override
        public void draw(Unit unit) {
            float drawy = unit.y + y;
            float realWidth = width * (unit.health / unit.maxHealth);
            Draw.color(Pal.health);
            Fill.rect(unit.x, drawy, realWidth, height);
            Draw.reset();
            Draw.color();
        }
    }

    //塔防的血量显示，面板改成显示掉落物以及掉落物的数量
    public static class TDhealthDisplay extends Ability {
        public float y, width, height;

        public TDhealthDisplay(float y, float width, float height) {
            this.y = y;
            this.width = width;
            this.height = height;
        }

        @Override
        public String localized() {
            return Core.bundle.get("ability.EU_healthDisplay");
        }

        @Override
        public void draw(Unit unit) {
            float drawy = unit.y + y;
            float realWidth = width * (unit.health / unit.maxHealth);
            Draw.color(Pal.health);
            Fill.rect(unit.x, drawy, realWidth, height);
            Draw.reset();
            Draw.color();
        }
    }
}
