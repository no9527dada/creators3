package ctrebirth.content;
/*地形加成与限制*/
import mindustry.world.meta.Attribute;

import static mindustry.world.meta.Attribute.add;

public class CTAttribute {

    //public static final Attribute vent = add("vent");



    public static Attribute Vent,YanBing;
    public static void load() {
        Vent = Attribute.add("Vent");
        YanBing = Attribute.add("YanBing");
    }
}