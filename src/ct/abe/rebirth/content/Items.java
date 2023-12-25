package ct.abe.rebirth.content;

import arc.struct.Seq;
import ct.abe.rebirth.content.inits.*;
import mindustry.type.Item;
import mindustry.type.Liquid;

import static mindustry.content.Items.*;
import static mindustry.content.Items.dormantCyst;

public class Items {
    public static final Seq<Item>
            原版资源 = new Seq<>(),
            mod资源 = new Seq<>(),
            erekir隐藏Items = new Seq<>(),
            serpulo隐藏Items = new Seq<>();


    public static Item 陶, 翠, 月银沙, 缕, 离, 灵玉, 血晶, 运符, 威灵, 明宝, 精焰, 萤玫, 冰橡子, 余烬, 幻烬, 超烬, 废丹, 筑基丹, 聚灵丹, 合婴丹,
            物品;
    public static Liquid
            灵液, 幻液, 精纯灵液,
            液体;


    //-------------------------第二章资源-----------------------
    public static Item 仙玉;


    //----------------------第四章资源--------------------------
    public static final Seq<Item> 重生Items = new Seq<>();
    //注册物品/液体 变量
    public static Item
            /*矿物*/
            魂石, 冥石, 冤藤, 赤焰石, 戾气赤焰石, 气丝晶体, 灵石, 怨石, 烟冰, 沉石, 微晶石,
            /*合成物*/
            棺炆魂矩,
            赤水魂矩,
            止枢魂矩,
            绝情魂矩,
            混仑魂矩,
            灵屈魂矩,
            魂翠, 冥翠, 相织物, 粉烟, 气光散, 灵魂丝, 沉珠, 冥翠块, 灵珠,
            赤焰膏块, 赤焰膏精, 怨气集束, 怨灵集束, 灵晶, 灵魂束缚容器, 夜灵珠,
            怨石块, 灵魂网束器, 微格晶, 珊绒, 暗珊绒, 冥丝, 灵境, 气丝节束, 魂冲器,
            青羊子, 暗物质, 冥织, 微相织, 衬相织, 缜相织, 灵魂集束, 灵魂核心, 网束器,
            衬光束, 夜灵, 夜灵核心, 灵魂转换因子, 魂力激发块, 硅晶体, 魔能晶, 翠灵晶,
            混沌晶体, 一级燃魂集, 二级燃魂集, 三级燃魂集, 空电池, 满电池,
    /*掉落物*/
    神花碎片;


    public static Liquid 黑油, 恐油, 叹酸, 叮浆;


    public static final Seq<Item> serpuloItems = new Seq<>(), erekirItems = new Seq<>(), erekirOnlyItems = new Seq<>();


    public static void load() {
        //初始化章节一资源
        initChapter1Items.load();
        initChapter2Items.load();
        InitChapter3Items.load();
        InitChapter4Items.load();
        InitChapter5Items.load();
        initItems();
    }

    private static void initItems() {
        原版资源.addAll(
                scrap, copper, lead, graphite, coal, titanium, thorium, silicon, plastanium,
                phaseFabric, surgeAlloy, sporePod, sand, blastCompound, pyratite, metaglass,
                graphite, thorium, silicon, phaseFabric, surgeAlloy, sand,
                beryllium, tungsten, oxide, carbide, fissileMatter, dormantCyst
        );

        mod资源.addAll(
                陶, 翠, 月银沙, 缕, 离, 灵玉, 血晶, 运符, 威灵, 明宝, 精焰, 萤玫, 冰橡子, 余烬, 幻烬, 超烬, 废丹, 筑基丹
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
