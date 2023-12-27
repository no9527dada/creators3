package ct.abe.rebirth.utils;

import mindustry.content.Items;
import mindustry.content.Planets;

import static ct.abe.rebirth.content.Items.*;

public class 原版修改 {
    public static void load() {

        Planets.erekir.hiddenItems.addAll(erekir隐藏Items).removeAll(Items.erekirItems);
        Planets.serpulo.hiddenItems.addAll(serpulo隐藏Items).removeAll(Items.serpuloItems);
    }
}
