package ct.content;

import mindustry.world.meta.Attribute;

import static mindustry.world.meta.Attribute.add;

public class CTAttributes {

    public static final Attribute 灵力收集 = add("灵力收集");

    public static Attribute Vent, YanBing;

    public static void load() {
        Vent = Attribute.add("Vent");
        YanBing = Attribute.add("YanBing");
    }
}
