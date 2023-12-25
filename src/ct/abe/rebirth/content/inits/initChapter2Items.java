package ct.abe.rebirth.content.inits;

import arc.Core;
import arc.graphics.Color;
import mindustry.type.Item;

import static ct.abe.rebirth.content.Items.*;
/*
 * 初始化第二章资源
 */
public class initChapter2Items {
    /*
     *请在Items类里面定义Items,在这里赋值
     * 如：
     * Items.java
     * ....
     * public static Items item
     *
     * Init......java
     * load(){
     *   items = new Item(){...}
     * }
     */
    public static void load() {
        仙玉 = new Item("仙玉", Color.valueOf("ea90a0")) {{
            localizedName = Core.bundle.get("items.xianyu");
            description = Core.bundle.getOrNull("items.description.xianyu");
        }};


    }
}
