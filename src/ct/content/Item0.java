package ct.content;

import arc.struct.Seq;
import mindustry.type.Item;


import static ct.content.chapter1.Item1.*;
import static mindustry.content.Items.*;

public class Item0 {
    public static final Seq<Item>
            原版资源 = new Seq<>(),
            mod资源 = new Seq<>(),
            erekir隐藏Items = new Seq<>(),
            serpulo隐藏Items = new Seq<>();

    public static void load() {
        原版资源.addAll(
                scrap, copper, lead, graphite, coal, titanium, thorium, silicon, plastanium,
                phaseFabric, surgeAlloy, sporePod, sand, blastCompound, pyratite, metaglass,
                graphite, thorium, silicon, phaseFabric, surgeAlloy, sand,
                beryllium, tungsten, oxide, carbide, fissileMatter, dormantCyst
        );

        mod资源.addAll(
                物品, 陶, 翠, 月银沙, 缕, 离, 灵玉, 血晶, 运符, 威灵, 明宝, 精焰, 萤玫, 冰橡子, 余烬, 幻烬, 超烬, 废丹, 筑基丹
        );


        erekir隐藏Items.addAll(scrap, copper, lead, graphite, coal, titanium, thorium, silicon, plastanium,
                phaseFabric, surgeAlloy, sporePod, sand, blastCompound, pyratite, metaglass,
                陶, 翠, 月银沙, 缕, 离, 灵玉, 血晶, 运符, 威灵, 明宝, 精焰, 萤玫, 冰橡子, 余烬, 幻烬, 超烬, 废丹, 筑基丹
        );
        serpulo隐藏Items.addAll(
                graphite, thorium, silicon, phaseFabric, surgeAlloy, sand,
                beryllium, tungsten, oxide, carbide, fissileMatter, dormantCyst,
                陶, 翠, 月银沙, 缕, 离, 灵玉, 血晶, 运符, 威灵, 明宝, 精焰, 萤玫, 冰橡子, 余烬, 幻烬, 超烬, 废丹, 筑基丹
        );

    }
}
