package ct.content.chapter1;

import arc.Core;
import arc.graphics.Color;
import mindustry.type.Item;
import mindustry.type.Liquid;


public class Item1 {
    public static Item 陶, 翠, 月银沙, 缕, 离, 灵玉, 血晶, 运符, 威灵, 明宝, 精焰, 萤玫, 冰橡子, 余烬, 幻烬, 超烬, 废丹, 筑基丹, 聚灵丹, 合婴丹;
    public static Liquid
            灵液, 幻液, 精纯灵液,
            液体;

    public static void load() {
        陶 = new Item("陶", Color.valueOf("e6ba83")) {{
            localizedName = Core.bundle.get("items.tao");
            description = Core.bundle.getOrNull("items.description.tao");
            //alwaysUnlocked = true;//默认解锁
            hardness = 1;
            radioactivity = 0.5f;
        }};
        翠 = new Item("翠", Color.valueOf("13ff87")) {{
            localizedName = Core.bundle.get("items.cui");
            description = Core.bundle.getOrNull("items.description.cui");
            Core.bundle.getOrNull("");

            charge = 0.3f;
            hardness = 1;
            radioactivity = 0.5f;
        }};
        月银沙 = new Item("月银沙", Color.valueOf("fef3bb")) {{
            localizedName = Core.bundle.get("items.yueyinsha");
            description = Core.bundle.getOrNull("items.description.yueyinsha");
            hardness = 0;
            // buildable = false;
        }};
        余烬 = new Item("余烬", Color.valueOf("535353")) {{
            localizedName = Core.bundle.get("items.yujing");
            description = Core.bundle.getOrNull("items.description.yujing");
            hardness = 2;
            // buildable = false;
        }};
        缕 = new Item("缕", Color.valueOf("9093dd")) {{
            localizedName = Core.bundle.get("items.lv");
            description = Core.bundle.getOrNull("items.description.lv");
            hardness = 3;
        }};
        离 = new Item("离", Color.valueOf("aca17c")) {{
            localizedName = Core.bundle.get("items.li");
            description = Core.bundle.getOrNull("items.description.li");
            hardness = 4;
        }};
        灵玉 = new Item("灵玉", Color.valueOf("ea90a0")) {{
            localizedName = Core.bundle.get("items.lingyu");
            description = Core.bundle.getOrNull("items.description.lingyu");
            radioactivity = 1f;
            hardness = 5;
        }};
        血晶 = new Item("血晶", Color.valueOf("e8451c")) {{
            localizedName = Core.bundle.get("items.xuejing");
            description = Core.bundle.getOrNull("items.description.xuejing");
            hardness = 5;
        }};
        运符 = new Item("运符", Color.valueOf("b08c42")) {{
            localizedName = Core.bundle.get("items.yunfu");
            description = Core.bundle.getOrNull("items.description.yunfu");
        }};
        幻烬 = new Item("幻烬", Color.valueOf("7f7f7f")) {{
            localizedName = Core.bundle.get("items.huanjing");
            description = Core.bundle.getOrNull("items.description.huanjing");
        }};
        超烬 = new Item("超烬", Color.valueOf("ababab")) {{
            localizedName = Core.bundle.get("items.chaojing");
            description = Core.bundle.getOrNull("items.description.chaojing");
        }};
        威灵 = new Item("威灵", Color.valueOf("5082c1")) {{
            localizedName = Core.bundle.get("items.weiling");
            description = Core.bundle.getOrNull("items.description.weiling\"");
        }};
        明宝 = new Item("明宝", Color.valueOf("816fbe")) {{
            localizedName = Core.bundle.get("items.mingbao");
            description = Core.bundle.getOrNull("items.description.mingbao");
        }};
        萤玫 = new Item("萤玫", Color.valueOf("fff46e")) {{
            localizedName = Core.bundle.get("items.yingmei");
            description = Core.bundle.getOrNull("items.description.yingmei");
        }};
        精焰 = new Item("精焰", Color.valueOf("ff6000")) {{
            localizedName = Core.bundle.get("items.jingyan");
            description = Core.bundle.getOrNull("items.description.jingyan");
            frames = 2;// >0时会有有动画
            transitionFrames = 1;//每帧之间生成的过渡帧的数量
            frameTime = 25f;//贴图变换之间的时间，默认5
        }};
        冰橡子 = new Item("冰橡子", Color.valueOf("f1b7e3")) {{
            localizedName = Core.bundle.get("items.bingxiangzi");
            description = Core.bundle.getOrNull("items.description.bingxiangzi");
            // charge = 0.3f;//放电性，被破坏产生电弧
            frames = 5;// >0时会有有动画
            transitionFrames = 1;//每帧之间生成的过渡帧的数量
            frameTime = 10f;//贴图变换之间的时间，默认5
        }};
        废丹 = new Item("废丹", Color.valueOf("484e53")) {{
            localizedName = Core.bundle.get("items.feidan");
            description = Core.bundle.getOrNull("items.description.feidan");
            radioactivity = 0.5f;
        }};
        筑基丹 = new Item("筑基丹", Color.valueOf("b19207")) {{
            localizedName = Core.bundle.get("items.zhujidan");
            description = Core.bundle.getOrNull("items.description.zhujidan");
            radioactivity = 2f;
            frames = 5;// >0时会有有动画
            transitionFrames = 1;//每帧之间生成的过渡帧的数量
            frameTime = 10f;//贴图变换之间的时间，默认5
        }};
        聚灵丹 = new Item("聚灵丹", Color.valueOf("b19207")) {{
            localizedName = Core.bundle.get("items.julingdan");
            description = Core.bundle.getOrNull("items.description.julingdan");
            radioactivity = 3f;
            frames = 5;// >0时会有有动画
            transitionFrames = 1;//每帧之间生成的过渡帧的数量
            frameTime = 10f;//贴图变换之间的时间，默认5
        }};
        合婴丹 = new Item("合婴丹", Color.valueOf("b19207")) {{
            localizedName = Core.bundle.get("items.heyingdan");
            description = Core.bundle.getOrNull("items.description.heyingdan");
            radioactivity = 5f;
            frames = 5;// >0时会有有动画
            transitionFrames = 1;//每帧之间生成的过渡帧的数量
            frameTime = 10f;//贴图变换之间的时间，默认5
        }};

        灵液 = new Liquid("灵液", Color.valueOf("2eb3ff")) {{
            localizedName = Core.bundle.get("liquid.lingye");
            description = Core.bundle.getOrNull("liquid.description.lingye");
            flammability = 0f;
            temperature = 0f;
            heatCapacity = 0.6f;
            viscosity = 0.2f;
            explosiveness = 0f;
            // lightColor = Color.valueOf("153ff2").a(0.3f);
            lightColor = Color.valueOf("0097f5").a(0.2f);
            gasColor = Color.valueOf("c1e8f5");
        }};
        精纯灵液 = new Liquid("精纯灵液", Color.valueOf("afd8f4")) {{
            localizedName = Core.bundle.get("liquid.jingcunlingye");
            description = Core.bundle.getOrNull("liquid.description.jingcunlingye");
            flammability = 0f;
            temperature = 0f;
            heatCapacity = 1.2f;
            viscosity = 0.2f;
            explosiveness = 0f;
            // lightColor = Color.valueOf("153ff2").a(0.3f);
            lightColor = Color.valueOf("0097f5").a(0.2f);
            gasColor = Color.valueOf("c1e8f5");
        }};
        幻液 = new Liquid("幻液", Color.valueOf("69f892")) {{
            localizedName = Core.bundle.get("liquid.huanye");
            description = Core.bundle.getOrNull("liquid.description.huanye");
            flammability = 0f;//易燃
            temperature = 0.6f;//热量
            heatCapacity = 0f;//冷量
            viscosity = 0.2f;
            explosiveness = 0f;//爆炸
            // lightColor = Color.valueOf("153ff2").a(0.3f);
            lightColor = Color.valueOf("0097f5").a(0.2f);
            gasColor = Color.valueOf("c1e8f5");
        }};


    }
}

