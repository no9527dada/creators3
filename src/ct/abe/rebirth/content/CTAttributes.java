package ct.abe.rebirth.content;

import mindustry.world.meta.Attribute;

public class CTAttributes {
    public static Attribute Vent, YanBing;

    public static void load() {
        Vent = Attribute.add("Vent");
        YanBing = Attribute.add("YanBing");
    }
}
