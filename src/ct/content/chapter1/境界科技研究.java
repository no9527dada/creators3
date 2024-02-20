package ct.content.chapter1;

import arc.Core;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.meta.BuildVisibility;
import mindustry.world.meta.Env;


public class 境界科技研究 {
    public static Block 筑基境界, 金丹境界, 元婴境界;

    public static void load() {
        筑基境界 = new Wall("筑基境界") {{
            localizedName = Core.bundle.get("jingjie.zhuji");
            envDisabled = Env.any;//禁止在任何星球战役中出现
            buildVisibility = BuildVisibility.hidden;//隐藏，但会再核心数据库中出现
        }};
        金丹境界 = new Wall("金丹境界") {{
            localizedName = Core.bundle.get("jingjie.jindan");
            envDisabled = Env.any;//禁止在任何星球战役中出现
            buildVisibility = BuildVisibility.hidden;//隐藏，但会再核心数据库中出现
        }};
        元婴境界 = new Wall("元婴境界") {{
            localizedName = Core.bundle.get("jingjie.yuanying");
            envDisabled = Env.any;//禁止在任何星球战役中出现
            buildVisibility = BuildVisibility.hidden;//隐藏，但会再核心数据库中出现
        }};
    }
}