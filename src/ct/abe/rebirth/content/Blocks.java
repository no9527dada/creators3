package ct.abe.rebirth.content;

import arc.files.Fi;
import arc.struct.Seq;
import ct.abe.rebirth.blocks.stroge.CTCoreBlock;
import ct.abe.rebirth.content.inits.*;
import mindustry.Vars;
import mindustry.graphics.CacheLayer;
import mindustry.graphics.Shaders;
import mindustry.type.Category;
import mindustry.type.Item;
import mindustry.type.Liquid;
import mindustry.world.Block;
import mindustry.world.meta.BuildVisibility;

import static ct.abe.rebirth.content.Items.*;
import static ct.abe.rebirth.content.Units.*;
import static mindustry.type.ItemStack.with;

public class Blocks {
    public static float T0time = 60f * 3f;
    public static float T1time = 60f / 1f;
    public static float T2time = 60f / 1.5f;
    public static float T3time = 60f / 2.8f;
    public static float p0t = 0f;
    public static float p1t = 1 / 60f;
    public static float p2t = 3 / 60f;
    public static float p3t = 6 / 60f;

    //核心
    public static Block core0, core1, core2;


    //Chapter1
    public static final Seq<Item> 包涵章节1资源 = new Seq<>(),
            仅章节1资源 = new Seq<>();
    public static Block 翠矿, 陶矿, 缕矿, 离矿, 血晶石矿, 月银沙地板, 余烬矿, 灵玉石矿, 发光地板,
            地板矿物;
    public static Block 幻液地板, 灵液地板, 灵脉地板,
            其他地板;
    public static Block 幻烬炼宝器, 运符炼宝器, 血晶炼宝器, 威灵炼宝器, 明宝聚宝炉, 萤玫化宝鼎,
            精焰化宝鼎, 幻烬聚宝炉, 灵玉炼宝器, 灵玉炼宝炉, 冰橡子炼玄器, 超烬化宝鼎, 灵液炼制炉,
            精纯灵液炼制炉, 资源炼化器, 资源炼化炉, 幻液炼制炉, 筑基丹炼制炉, 聚灵丹炼制炉,
            工厂方块;
    public static Block 灵力收集器, 一品灵力产生器, 二品灵力产生器, 十字节点, 十字节点电池, 圆形节点, 灵力射线塔,
            电力方块;

    public static Block 陶玉钻头, 灵玉钻头, 威灵钻头, 明宝钻头, 汲水器, 液体泵;


    //墙
    public static Block 陶墙1, 陶墙2, 幻烬墙, 缕墙, 灵化缕墙;

    public static Block 陶玉运输带, 威灵运输带, 灵化威灵运输带, 明宝打包运输带, 焚化炉,
            路由器, 连接器, 分配器, 分类器, 反向分类器, 溢流门, 反向溢流门, 灵玉运输桥, 萤玫运输桥, 物品卸载器, 仓库, 大仓库,
            液体导管, 灵化液体导管, 液体路由器, 液体连接器, 液仓, 液体桥接器, 远程液体桥接器;


    /*****************************/
    //---------------Chapter2----------------
    public static Block 灵脉;
    //            地板矿物;
    public static Item 天厥石, 地参精, 炼妖石, 混魔石, 仙玉, 灵魂沙,
            物品;
    public static Liquid 鬼气, 人烨,
            液体;


    //-------------Chapter4-----------------------

    public static Block
            //地板：
            冥矿, 魂矿, 冤藤矿, 魔力石, 赤焰石矿, 戾气赤焰石墙矿, 气丝晶体墙矿, 灵石矿, 怨石矿, 烟冰矿, 沉石矿, 微晶石矿, 硅晶矿,
            灵液地板2, 黑油地板, 黑油喷口, 叹酸地板, 叮浆地板,
    //墙壁
    墙壁,
    //工厂：
    油泵, 黑油精炼台, 夜灵核心融合器, 珊绒透筛器, 珊绒重组器, 暗物质羽窃器,

    //电力
    十字能量节点, 小小能量节点, 能量节点, 能量收集器, 能量发生器,
            能源储蓄块制造器, 充能器, 能源释放器,
    //物流
    传送带2, Armored传送带2, 传送带, Armored传送带, CTjunction, CTsorter,
            分类器2, 反向分类器2, 溢流门2, 反向溢流门2, 传送桥, 辉阳传送带,
            辉阳路由器,
            单位装载器1, 单位装载器2, 单位装载器3, 单位卸载器;


    public static Block 锁定, 方块;


    public static Block
            coreT1, coreT2, coreT3;

    //UnitBlocks
    public static Block T1Unit, T2Unit, T3Unit, T4Unit, T5Unit;
    public static Block T1hai, T2hai, T3hai, T4hai, T5hai;
    public static Block T2FU, T3FU, T4FU, T5FU;//盾兵
    public static Block kuangjiUnit;
    public static Block yunshu_shengcheng, yunshu_jiesou;

    public static Fi shaders = Vars.mods.locateMod("ct").root.child("CTshaders");
    public static Shaders.SurfaceShader s1 = new Shaders.SurfaceShader(Shaders.getShaderFi("screenspace.vert").readString(),
            shaders.child("cryofluid2.frag").readString());
    public static CacheLayer.ShaderLayer m = new CacheLayer.ShaderLayer(s1);

    static {
        CacheLayer.add(m);
    }


    public static void load() {
        //加载章节资源
        InitChapter1Blocks.load();
        InitChapter2Blocks.load();
        InitChapter3Blocks.load();
        InitChapter4Blocks.load();
        InitChapter5Blocks.load();
        InitCoreBlocks.load();
    }
}
