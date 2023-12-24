package ct.chapter2;

import arc.Core;
import arc.graphics.Color;
import mindustry.type.Item;
import mindustry.type.Liquid;


public class Item2 {
    public static Item 仙玉,
            物品;
    public static Liquid

            液体;

    public static void load() {

        仙玉 = new Item("仙玉", Color.valueOf("ea90a0")) {{
            localizedName = Core.bundle.get("items.xianyu");
            description = Core.bundle.getOrNull("items.description.xianyu");
        }};


   }
}
