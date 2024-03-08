package ct.Asystem.type;

import mindustry.Vars;
import mindustry.gen.Building;
import mindustry.logic.LAccess;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.meta.BuildVisibility;

/*用处理器配置此方块，完成终结波次的修改
getlink q 0
control config q 100
stop
 */
public class waveRule extends Block {
    public waveRule(String name) {
        super(name);
        update = true;
        sync = true;
        canOverdrive = false;
        targetable = false;
        forceDark = true;
        privileged = true;
        size = 1;
        category = Category.effect;
        buildVisibility = BuildVisibility.sandboxOnly;

    }

    public class waveRuleBuild extends Building {
        public int wave = -1;

        @Override
        public void control(LAccess type, double p1, double p2, double p3, double p4) {
            if (type == LAccess.config) {
                wave = (int) p1;
            }

            super.control(type, p1, p2, p3, p4);
        }

        @Override
        public void updateTile() {
            if (wave <= 0) return;
            Vars.state.rules.winWave = wave;
        }
    }
}
