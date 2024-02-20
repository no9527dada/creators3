package ct.content.chapter5;

import arc.Core;

import arc.struct.Seq;
import mindustry.content.TechTree;
import mindustry.game.Objectives;
import mindustry.type.SectorPreset;

import static ct.Asystem.type.CTTechTree.addToTree;
import static ct.content.CT3CoreBlocks.P5Core;
import static ct.content.chapter5.工厂5.*;
import static ct.content.chapter5.物流5.*;
import static ct.content.chapter5.防御设施5.*;
import static mindustry.content.Blocks.*;


public class TechTree5 {
    public static float TechTrees5倍率 = 1;

    public static void load() {
        Planet5.Planet5.techTree = TechTree.nodeRoot(Core.bundle.format("Planet55"), P5Core, true, () -> {

            SectorPreset mull5 = new SectorPreset("mull5", Planet5.Planet5, 100) {{
                localizedName = "未开放";
                captureWave = 10;
                difficulty = 0;
                alwaysUnlocked = false;
            }};

            //工厂
            addToTree(石英提取机, P5Core);
            addToTree(石英磨练机, 石英提取机);
            addToTree(铁锻造机, 石英提取机, null, Seq.with(new Objectives.Research(mechanicalDrill)));
            addToTree(碳板压缩机, 铁锻造机, null, Seq.with(new Objectives.Research(multiPress)));
            addToTree(空壳制造机, 铁锻造机, null, Seq.with(new Objectives.Research(multiPress)));
            addToTree(弹药厂_爆破, 空壳制造机);
            addToTree(弹药厂_冷冻, 空壳制造机);
            addToTree(弹药厂_碎裂, 空壳制造机);
            addToTree(弹药厂_硬直, 空壳制造机);
            addToTree(钍电池制造厂, 空壳制造机);
            addToTree(电池转换器, 钍电池制造厂);
            addToTree(链式锻造机, 铁锻造机);
            addToTree(铁板锻造机, 铁锻造机);
            addToTree(多重冶炼厂, 铁锻造机, null, Seq.with(new Objectives.Research(siliconSmelter)));
            addToTree(合金锤炼厂, 铁锻造机, null, Seq.with(new Objectives.Research(surgeSmelter)));
            addToTree(硫粉发生机, 铁锻造机, null, Seq.with(new Objectives.Research(multiPress)));
            addToTree(爆炸冲击机, 硫粉发生机);
            addToTree(黄金熔炼器, 铁锻造机);
            addToTree(资源转换器_废料, 铁锻造机);
            addToTree(资源转换器_铜铅, 资源转换器_废料);
            addToTree(资源转换器_钛, 资源转换器_废料);
            addToTree(资源转换器_钍, 资源转换器_废料);
            addToTree(资源转换器_钴, 资源转换器_废料);
            addToTree(资源转换器_镍, 资源转换器_钴);
            addToTree(资源转换器_塑钢, 资源转换器_钴);
            addToTree(铁板重型加工厂, 铁板锻造机);
            addToTree(大型粉碎机, 铁板锻造机, null, Seq.with(new Objectives.Research(blastMixer)));
            addToTree(镍板合成机, 链式锻造机);
            addToTree(镍板混合器, 镍板合成机);
            addToTree(钛合金反应炉, 镍板合成机);
            addToTree(混合熔炼器, 黄金熔炼器);
            addToTree(钻石离心机, 合金锤炼厂);
            addToTree(钻石矿加工厂, 钻石离心机);
            addToTree(钻石混合物反应机, 黄金熔炼器);
            addToTree(多重编织机, 钻石混合物反应机, null, Seq.with(new Objectives.Research(phaseWeaver)));
            addToTree(多重塑钢机, 钻石混合物反应机, null, Seq.with(new Objectives.Research(plastaniumCompressor)));
            addToTree(钻石提炼机, 钻石混合物反应机);
            addToTree(相织反应炉, 钻石混合物反应机);
            addToTree(物品厂_水瓶, 空壳制造机);


            addToTree(放射熔炉, 爆炸冲击机);
            addToTree(固体放射机, 放射熔炉);
            addToTree(放射混合器, 爆炸冲击机);

            addToTree(辐射混合机, 放射熔炉);
            addToTree(辐射混合机, 放射熔炉);
            addToTree(粒子离心机, 矿物离心机);
            addToTree(黎辉离心机, 矿物离心机);
            addToTree(冷冻液发生机, P5Core);

            addToTree(制冷液混合机, 冷冻液发生机);
            addToTree(啸动冶炼机, 合金锤炼厂);
            addToTree(军火材料机, 啸动冶炼机);
            addToTree(军火库, 军火材料机);
            addToTree(水晶复合器, 军火材料机);
            addToTree(啸动冲击械, 制冷液混合机);


            // 防御设施
            addToTree(铅墙, P5Core, null, Seq.with(new Objectives.Research(copperWall)));
            addToTree(大型铅墙, 铅墙);
            addToTree(硅墙, 大型铅墙);
            addToTree(大型硅墙, 硅墙);
            addToTree(相织硅墙, 硅墙, null, Seq.with(new Objectives.Research(phaseWallLarge)));
            addToTree(大型相织硅墙, 相织硅墙);
            addToTree(钴墙, 硅墙);
            addToTree(大型钴墙, 钴墙);
            addToTree(钛合金墙, 钴墙);
            addToTree(大型钛合金墙, 钛合金墙);
            addToTree(巨型钛合金墙, 大型钛合金墙);
            addToTree(超大型钛合金墙, 巨型钛合金墙);

            //物流
            addToTree(大型仓库, P5Core, null, Seq.with(new Objectives.Research(vault)));
            addToTree(超大型仓库, 大型仓库);
            addToTree(战地仓库, 超大型仓库);
            addToTree(镍板连接器, P5Core, null, Seq.with(new Objectives.Research(junction)));
            addToTree(钴传送带, 镍板连接器, null, Seq.with(new Objectives.Research(armoredConveyor)));
            addToTree(装甲钴传送带, 钴传送带);
            addToTree(镍板传送带, 钴传送带);
            addToTree(装甲镍板传送带, 镍板传送带);
            addToTree(啸动传送带, 镍板传送带);
            addToTree(装甲啸动传送带, 镍板传送带);
            addToTree(钻石传送带, 装甲啸动传送带);
            addToTree(钍传送带桥, 镍板连接器, null, Seq.with(new Objectives.Research(conveyor)));
            addToTree(钴传送带桥, 钍传送带桥);
            addToTree(动能卸货器, 大型仓库, null, Seq.with(new Objectives.Research(unloader)));
            addToTree(驱动器, 大型仓库, null, Seq.with(new Objectives.Research(massDriver)));
            addToTree(数据驱动器, 驱动器);
            addToTree(质量转换终端, 数据驱动器, null, Seq.with(new Objectives.Research(数据驱动器)));
            addToTree(质量驱逐器, 质量转换终端);
            addToTree(大型储液罐, 大型仓库, null, Seq.with(new Objectives.Research(liquidTank)));
            addToTree(钴制导管, 大型储液罐, null, Seq.with(new Objectives.Research(liquidTank)));
            addToTree(硬速导管, 钴制导管);
            addToTree(钍导管桥, 镍板连接器, null, Seq.with(new Objectives.Research(phaseConduit)));
            addToTree(钴导管桥, 钍导管桥);


        });
    }
}
