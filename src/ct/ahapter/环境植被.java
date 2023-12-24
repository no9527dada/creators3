package ct.ahapter;

import arc.Core;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.SeaBush;
import mindustry.world.blocks.environment.StaticWall;

import static mindustry.content.Blocks.bluemat;

public class 环境植被 {
    public static void load() {
        //可拆除的环境植被
        SeaBush 草1 = new SeaBush("cao1") {{
            localizedName = "绿草";
            bluemat.asFloor().decoration = this;
        }};
        SeaBush 草2 = new SeaBush("cao2") {{
            localizedName = "黄草";
            bluemat.asFloor().decoration = this;
        }};
        new Floor("heizuanFloor") {{
              localizedName = Core.bundle.get("Floor.heizuanFloor");
            variants = 6;
        }};
new StaticWall("heizuanWall"){{
    localizedName = Core.bundle.get("Floor.heizuanWall");
    variants = 2;
}};
/*        SeaBush  草2 = new SeaBush("cao2"){{
            lobesMin = 2;
            lobesMax = 3;
            magMax = 8f;
            magMin = 2f;
            origin = 0.3f;
            spread = 40f;
            sclMin = 60f;
            sclMax = 100f;
        }};*/
/*        Seaweed 树 = new Seaweed ("pur-bush2") {{
            variants = 3;
            bluemat.asFloor().decoration = this;
        }};*/


        //不可拆除的环境植被
      //  ？？？

    }
}
