package ct.ahapter;

import mindustry.content.Items;
import mindustry.content.Planets;

import static ct.ahapter.Item0.erekir隐藏Items;
import static ct.ahapter.Item0.serpulo隐藏Items;

public class 原版修改 {
    public static void load() {

        Planets.erekir.hiddenItems.addAll(erekir隐藏Items).removeAll(Items.erekirItems);
        Planets.serpulo.hiddenItems.addAll(serpulo隐藏Items).removeAll(Items.serpuloItems);
    }
}
