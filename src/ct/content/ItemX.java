package ct.content;

import arc.Core;
import arc.graphics.Color;
import mindustry.type.Item;

public class ItemX {
    public static Item 物品;

    public static void load() {
        物品 = new Item("物品", Color.valueOf("f1b7e3")) {{
            localizedName = Core.bundle.get("items.mull");
            description = Core.bundle.getOrNull("items.description.null");
            // radioactivity = 2f;
            // frames = 5;// >0时会有有动画
            // transitionFrames = 1;//每帧之间生成的过渡帧的数量
            //frameTime = 10f;//贴图变换之间的时间，默认5
        }};
    }
}
