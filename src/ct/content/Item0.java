package ct.content;

import arc.Core;
import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;


import static ct.content.chapter1.Item1.*;
import static ct.content.chapter4.CT3Item4.*;
import static ct.content.chapter5.资源5.*;
import static mindustry.content.Items.*;

public class Item0 {
    public static final Seq<Item>
            原版资源 = new Seq<>(),
            mod资源1显示 = new Seq<>(),
            mod资源1隐藏 = new Seq<>(),
            mod资源4显示 = new Seq<>(),
            mod资源4隐藏 = new Seq<>(),
            mod资源5显示 = new Seq<>(),
            mod资源5隐藏 = new Seq<>(),
            erekir隐藏Items = new Seq<>(),
            serpulo隐藏Items = new Seq<>();

    public static void load() {
        ItemX.物品 = new Item("物品", Color.valueOf("f1b7e3")) {{
            localizedName = Core.bundle.get("items.mull");
            description = Core.bundle.getOrNull("items.description.null");
            // radioactivity = 2f;
            // frames = 5;// >0时会有有动画
            // transitionFrames = 1;//每帧之间生成的过渡帧的数量
            //frameTime = 10f;//贴图变换之间的时间，默认5
        }};

 /*       原版资源.addAll(
                scrap, copper, lead, graphite, coal, titanium, thorium, silicon, plastanium,
                phaseFabric, surgeAlloy, sporePod, sand, blastCompound, pyratite, metaglass,
                graphite, thorium, silicon, phaseFabric, surgeAlloy, sand,
                beryllium, tungsten, oxide, carbide, fissileMatter, dormantCyst
        );*/

/*        mod资源1显示.addAll(
                物品, 陶, 翠, 月银沙, 缕, 离, 灵玉, 血晶, 运符, 威灵, 明宝, 精焰, 萤玫, 冰橡子, 余烬, 幻烬, 超烬, 废丹, 筑基丹
        );*/
        mod资源1隐藏.addAll(
                scrap, copper, lead, graphite, coal, titanium, thorium, silicon, plastanium,
                phaseFabric, surgeAlloy, sporePod, sand, blastCompound, pyratite, metaglass,
                graphite, thorium, silicon, phaseFabric, surgeAlloy, sand,
                beryllium, tungsten, oxide, carbide, fissileMatter, dormantCyst,

                爆破弹, 电池, 放射混合物, 放射沙, 钴, 固体放射物, 金, 空壳, 冷冻弹, 钻石矿,
                黎辉水晶, 镍, 镍板, 石英, 水瓶, 碎裂弹, 钛合金, 碳板, 铁, 铁板, 钍电池, 相织硅,
                啸动合金, 硬直弹, 钻石, 钻石混合物,

                /*矿物*/
                魂石, 冥石, 冤藤, 赤焰石, 戾气赤焰石, 气丝晶体, 灵石, 怨石, 烟冰, 沉石, 微晶石,
                /*合成物*/
                棺炆魂矩, 赤水魂矩, 止枢魂矩, 绝情魂矩, 混仑魂矩, 灵屈魂矩,
                魂翠, 冥翠, 相织物, 粉烟, 气光散, 灵魂丝, 沉珠, 冥翠块, 灵珠,
                赤焰膏块, 赤焰膏精, 怨气集束, 怨灵集束, 灵晶, 灵魂束缚容器, 夜灵珠,
                怨石块, 灵魂网束器, 微格晶, 珊绒, 暗珊绒, 冥丝, 灵境, 气丝节束, 魂冲器,
                青羊子, 暗物质, 冥织, 微相织, 衬相织, 缜相织, 灵魂集束, 灵魂核心, 网束器,
                衬光束, 夜灵, 夜灵核心, 灵魂转换因子, 魂力激发块, 硅晶体, 魔能晶, 翠灵晶,
                混沌晶体, 一级燃魂集, 二级燃魂集, 三级燃魂集, 空电池, 满电池,
                /*掉落物*/
                神花碎片
        );
        /*        mod资源4显示.addAll(
         *//*矿物*//*
                魂石, 冥石, 冤藤, 赤焰石, 戾气赤焰石, 气丝晶体, 灵石, 怨石, 烟冰, 沉石, 微晶石,
                *//*合成物*//*
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
                *//*掉落物*//*
                神花碎片
        );*/
        mod资源4隐藏.addAll(
                scrap, copper, lead, graphite, coal, titanium, thorium, silicon, plastanium,
                phaseFabric, surgeAlloy, sporePod, sand, blastCompound, pyratite, metaglass,
                graphite, thorium, silicon, phaseFabric, surgeAlloy, sand,
                beryllium, tungsten, oxide, carbide, fissileMatter, dormantCyst,

                陶, 翠, 月银沙, 缕, 离, 灵玉, 血晶, 运符, 威灵, 明宝, 精焰, 萤玫, 冰橡子, 余烬, 幻烬, 超烬, 废丹, 筑基丹, 聚灵丹, 合婴丹,

                爆破弹, 电池, 放射混合物, 放射沙, 钴, 固体放射物, 金, 空壳, 冷冻弹, 钻石矿,
                黎辉水晶, 镍, 镍板, 石英, 水瓶, 碎裂弹, 钛合金, 碳板, 铁, 铁板, 钍电池, 相织硅,
                啸动合金, 硬直弹, 钻石, 钻石混合物

        );
/*        mod资源5显示.addAll(
                scrap, copper, lead, graphite, coal, titanium, thorium, silicon, plastanium,
                phaseFabric, surgeAlloy, sporePod, sand, blastCompound, pyratite, metaglass,
                爆破弹, 电池, 放射混合物, 放射沙, 钴, 固体放射物, 金, 空壳, 冷冻弹, 钻石矿,
                黎辉水晶, 镍, 镍板, 石英, 水瓶, 碎裂弹, 钛合金, 碳板, 铁, 铁板, 钍电池, 相织硅,
                啸动合金, 硬直弹, 钻石, 钻石混合物
        );*/
        mod资源5隐藏.addAll(
                beryllium, tungsten, oxide, carbide, fissileMatter, dormantCyst,
                陶, 翠, 月银沙, 缕, 离, 灵玉, 血晶, 运符, 威灵, 明宝, 精焰, 萤玫, 冰橡子, 余烬, 幻烬, 超烬, 废丹, 筑基丹, 聚灵丹, 合婴丹,

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
                神花碎片
        );


        erekir隐藏Items.addAll(
                scrap, copper, lead, graphite, coal, titanium, thorium, silicon, plastanium,
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
