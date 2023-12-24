package ct.chapter4;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.type.Item;
import mindustry.type.Liquid;

import static mindustry.content.Items.*;

/**
 * @author WOW
 * @date 2022/10/04
 * 存放全部物品
 */
public class CTItem {
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
            混沌晶体, 一级燃魂集, 二级燃魂集, 三级燃魂集,空电池,满电池,
    /*掉落物*/
    神花碎片,

    物品;



    public static Liquid
            灵液, 黑油, 恐油, 叹酸, 叮浆,

    液体;


    public static final Seq<Item> serpuloItems = new Seq<>(), erekirItems = new Seq<>(), erekirOnlyItems = new Seq<>();


    public static void load() {

        /*jinhuiboli = new Item("jinhuiboli",Color.valueOf("F3D272")){{
           hardness = 1;//硬度
           buildable = false;//禁止进入核心
            charge = 0.3f;//放电性，被破坏产生电弧
            frames = 8;// >0时会有有动画
            transitionFrames = 1;//每帧之间生成的过渡帧的数量
            frameTime = 10f;//贴图变换之间的时间，默认5
        }};*/
        棺炆魂矩 = new Item("棺炆魂符", Color.valueOf("ffffff")) {{//蓝

        }};
        赤水魂矩 = new Item("赤水魂符", Color.valueOf("ffffff")) {{//红

        }};
        止枢魂矩 = new Item("止枢魂符", Color.valueOf("ffffff")) {{//黄

        }};
        绝情魂矩 = new Item("绝情魂符", Color.valueOf("ffffff")) {{//紫

        }};
        混仑魂矩 = new Item("混仑魂符", Color.valueOf("ffffff")) {{//绿

        }};
        灵屈魂矩 = new Item("灵屈魂符", Color.valueOf("ffffff")) {{//白

        }};

        神花碎片 = new Item("神花碎片", Color.valueOf("ffffff")) {{
            frames = 50;// >0时会有有动画
            transitionFrames = 1;//每帧之间生成的过渡帧的数量
            frameTime = 4f;//贴图变换之间的时间，默认5
        }};



        魂石 = new Item("soul_stone", Color.valueOf("ffffff")) {{//铜999
            buildable = false;
            charge = 0.3f;
            hardness = 1;
        }};
        冥石 = new Item("Skystone", Color.valueOf("ffffff")) {{//铁999
            buildable = false;
            hardness = 1;
        }};
        冤藤 = new Item("ghost_vine", Color.valueOf("ffffff")) {{//煤999
            flammability = 1f;
            buildable = false;
            hardness = 1;
        }};
        怨石 = new Item("resentment_stone", Color.valueOf("ffffff")) {{//石头999
            buildable = false;
            hardness = 1;
        }};
        赤焰石 = new Item("flame_stone", Color.valueOf("ffffff")) {{//硅999
            buildable = false;
            hardness = 1;
        }};
        戾气赤焰石 = new Item("anger_flame_stone", Color.valueOf("ffffff")) {{//分型硅999
            buildable = false;
            hardness = 1;
        }};
        烟冰 = new Item("smokeice", Color.valueOf("ffffff")) {{//可燃冰
            flammability = 0.8f;
            buildable = false;
            hardness = 1;
        }};
        灵石 = new Item("fairy_stone", Color.valueOf("ffffff")) {{//钛石999
            buildable = false;
            hardness = 1;
        }};
        气丝晶体 = new Item("气丝晶体", Color.valueOf("ffffff")) {{//刺笋结晶
            buildable = false;
            hardness = 1;
        }};
//   //沉晶石
        沉石 = new Item("gravity_stone", Color.valueOf("ffffff")) {{//金伯利矿石
            buildable = false;
            hardness = 1;
        }};
        微晶石 = new Item("微晶石", Color.valueOf("ffffff")) {{//光珊石
            buildable = false;
            hardness = 1;
        }};
        魔能晶 = new Item("魔能晶", Color.valueOf("ffffff")) {{//单极磁石

        }};



        魂翠 = new Item("魂翠", Color.valueOf("ffffff")) {{//铜板999

        }};
        冥翠 = new Item("冥翠", Color.valueOf("ffffff")) {{//铁板999

        }};
        冥织 = new Item("冥织", Color.valueOf("ffffff")) {{//磁铁999

        }};
        怨石块 = new Item("怨石块", Color.valueOf("ffffff")) {{//石板999

        }};
        怨气集束 = new Item("怨气集束", Color.valueOf("ffffff")) {{//玻璃999

        }};
        粉烟 = new Item("粉烟", Color.valueOf("ffffff")) {{//石墨999
            flammability = 1.5f;
        }};
        冥翠块 = new Item("冥翠块", Color.valueOf("ffffff")) {{//钢材999

        }};
        赤焰膏块 = new Item("赤焰膏块", Color.valueOf("ffffff")) {{//硅板999

        }};
        赤焰膏精 = new Item("赤焰膏精", Color.valueOf("ffffff")) {{//晶格硅999

        }};

        灵珠 = new Item("灵珠", Color.valueOf("ffffff")) {{//钛板999

        }};
        沉珠 = new Item("沉珠", Color.valueOf("ffffff")) {{//金刚石999

        }};
        翠灵晶 = new Item("翠灵晶", Color.valueOf("ffffff")) {{//钛合金999

        }};
/***************/
        冥丝 = new Item("冥丝", Color.valueOf("ffffff")) {{//齿轮999

        }};
        相织物 = new Item("相织物", Color.valueOf("ffffff")) {{//线圈 999

        }};
        微相织 = new Item("微相织", Color.valueOf("ffffff")) {{//电动机999

        }};
        衬相织 = new Item("衬相织", Color.valueOf("ffffff")) {{//电磁涡轮999

        }};
        缜相织 = new Item("缜相织", Color.valueOf("ffffff")) {{//超级磁场环999

        }};
        灵境 = new Item("灵境", Color.valueOf("ffffff")) {{//棱镜999

        }};
        灵魂丝 = new Item("灵魂丝", Color.valueOf("ffffff")) {{//电路板999

        }};
        硅晶体 = new Item("silicon_crystal", Color.valueOf("ffffff")) {{//有机晶体999
            buildable = false;
            hardness = 1;
        }};
        灵晶 = new Item("灵晶", Color.valueOf("ffffff")) {{//钛晶石999
            flammability = 1.8f;
        }};
        魂力激发块 = new Item("魂力激发块", Color.valueOf("ffffff")) {{//电浆激发器999

        }};
        一级燃魂集 = new Item("一级燃魂集", Color.valueOf("ffffff")) {{
            flammability = 3f;
        }};
        二级燃魂集 = new Item("二级燃魂集", Color.valueOf("ffffff")) {{
            flammability = 5f;
           // alwaysUnlocked = true;
        }};
        三级燃魂集 = new Item("三级燃魂集", Color.valueOf("ffffff")) {{
            flammability = 12f;

        }};
        空电池 = new Item("能源储蓄块(空)", Color.valueOf("ffffff")) {{

        }};
        满电池 = new Item("能源储蓄块(满)", Color.valueOf("ffffff")) {{

        }};
        怨灵集束 = new Item("怨灵集束", Color.valueOf("ffffff")) {{//钛化玻璃999

        }};
        微格晶 = new Item("微格晶", Color.valueOf("ffffff")) {{//卡西米尔晶体999

        }};
        灵魂集束 = new Item("灵魂集束", Color.valueOf("ffffff")) {{//微晶元件999

        }};
        灵魂核心 = new Item("灵魂核心", Color.valueOf("ffffff")) {{//处理器999

        }};
        灵魂转换因子 = new Item("灵魂转换因子", Color.valueOf("ffffff")) {{//位面过滤器999

        }};
        夜灵 = new Item("夜灵", Color.valueOf("ffffff")) {{//量子芯片999

        }};
        灵魂网束器 = new Item("灵魂网束器", Color.valueOf("ffffff")) {{//粒子带宽999

        }};
        夜灵珠 = new Item("夜灵珠", Color.valueOf("ffffff")) {{//引力透镜999

        }};
        衬光束 = new Item("衬光束", Color.valueOf("ffffff")) {{//粒子容器//999
            frames = 7;// >0时会有有动画
            transitionFrames = 1;//每帧之间生成的过渡帧的数量
            frameTime = 10f;//贴图变换之间的时间，默认5
        }};
        灵魂束缚容器 = new Item("灵魂束缚容器", Color.valueOf("ffffff")) {{//泯灭约束球999

        }};
        混沌晶体 = new Item("混沌晶体", Color.valueOf("ffffff")) {{//框架材料999

        }};
        魂冲器 = new Item("魂冲器", Color.valueOf("ffffff")) {{//地基??

        }};
        /*============*/
        夜灵核心 = new Item("夜灵核心", Color.valueOf("ffffff")) {{//奇异物质999

        }};


/*================*/

        网束器 = new Item("网束器", Color.valueOf("ffffff")) {{//塑料999
            flammability = 1.5f;
        }};
        气光散 = new Item("气光散", Color.valueOf("ffffff")) {{//石墨烯999
            flammability = 1.3f;
        }};
        珊绒 = new Item("珊绒", Color.valueOf("ffffff")) {{//氢
            flammability = 0.2f;
        }};
        气丝节束 = new Item("气丝节束", Color.valueOf("ffffff")) {{//纳米碳管999

        }};
        暗珊绒 = new Item("暗珊绒", Color.valueOf("ffffff")) {{//重氢
            flammability = 0.5f;
        }};
        青羊子 = new Item("青羊子", Color.valueOf("ffffff")) {{//光子999

        }};
        暗物质 = new Item("暗物质", Color.valueOf("ffffff")) {{//反物质999

        }};











/*        灵液 = new Liquid("灵液", Color.valueOf("718cff")) {{
            flammability = 0f;
            temperature = 0f;
            heatCapacity = 0.6f;
            viscosity = 0.2f;
            explosiveness = 0f;
           // lightColor = Color.valueOf("153ff2").a(0.3f);
            lightColor = Color.valueOf("0097f5").a(0.2f);
            gasColor = Color.valueOf("c1e8f5");
        }};*/
        黑油 = new Liquid("黑油", Color.valueOf("000000")) {{
            viscosity = 0.75f;
            flammability = 1.2f;
            explosiveness = 1.2f;
            heatCapacity = 0.7f;
            barColor = Color.valueOf("6b675f");
            effect = StatusEffects.tarred;
            boilPoint = 0.65f;
            gasColor = Color.grays(0.4f);
            canStayOn.add(灵液);
        }};
        恐油 = new Liquid("恐油", Color.valueOf("3f2e67")) {{
            gas = true;
            barColor = Color.valueOf("3f2e67");
            flammability = 0f;
            temperature = 0f;
            heatCapacity = 0.6f;
            viscosity = 0.2f;
            explosiveness = 0f;
        }};
        叹酸 = new Liquid("叹酸", Color.valueOf("53AE3C")) {{
            flammability = 0f;
            temperature = 0f;
            heatCapacity = 0.6f;
            viscosity = 0.2f;
            explosiveness = 0f;
            lightColor = Color.valueOf("25ee16").a(0.2f);
        }};
        叮浆 = new Liquid("叮浆", Color.valueOf("c74713")) {{
            temperature = 1f;
            viscosity = 0.7f;
            effect = StatusEffects.melting;
            lightColor = Color.valueOf("c74713").a(0.4f);
        }};

        重生Items.addAll(Items.scrap, copper, lead, graphite, coal, titanium, thorium, silicon, plastanium,
                phaseFabric, surgeAlloy, sporePod, sand, blastCompound, pyratite, metaglass,
                graphite, thorium, silicon, phaseFabric, surgeAlloy, sand,
                beryllium, tungsten, oxide, carbide, fissileMatter, dormantCyst);
        //定义变量为物品/液体属性


    }
}
