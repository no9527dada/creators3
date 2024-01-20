package ct.content.chapter5;

import arc.struct.Seq;

import mindustry.content.TechTree;
import mindustry.game.Objectives;


import static ct.Asystem.type.CTTechTree.addToTree;
import static ct.content.chapter5.工厂.*;
import static ct.content.chapter5.星球.PF星球;

import static ct.content.chapter5.防御设施.*;
import static mindustry.content.Blocks.*;


public class 科技树 {

    public static void load() {

        PF星球.techTree = TechTree.nodeRoot("像素工业", coreShard, true, () -> {
            //工厂
            addToTree(石英提取机, coreShard);
            addToTree(石英磨练机, 石英提取机);
            addToTree(硫粉发生机, coreShard, null, Seq.with(new Objectives.Research(multiPress)));
            addToTree(爆炸冲击机, 硫粉发生机);
            addToTree(大型粉碎机, coreShard, null, Seq.with(new Objectives.Research(blastMixer)));
            addToTree(碳板压缩机, coreShard, null, Seq.with(new Objectives.Research(multiPress)));
            addToTree(空壳制造机, coreShard, null, Seq.with(new Objectives.Research(multiPress)));
            addToTree(弹药厂_爆破, 空壳制造机);
            addToTree(弹药厂_冷冻, 空壳制造机);
            addToTree(弹药厂_碎裂, 空壳制造机);
            addToTree(弹药厂_硬直, 空壳制造机);
            addToTree(钍电池制造厂, 空壳制造机);
            addToTree(电池转换器, 钍电池制造厂);
            addToTree(多重编织机, coreShard, null, Seq.with(new Objectives.Research(phaseWeaver)));
            addToTree(多重塑钢机, coreShard, null, Seq.with(new Objectives.Research(plastaniumCompressor)));
            addToTree(多重塑钢机, coreShard, null, Seq.with(new Objectives.Research(kiln)));
            addToTree(多重冶炼厂, coreShard, null, Seq.with(new Objectives.Research(siliconSmelter)));
            addToTree(合金锤炼厂, coreShard, null, Seq.with(new Objectives.Research(surgeSmelter)));
            addToTree(铁锻造机, coreShard, null, Seq.with(new Objectives.Research(mechanicalDrill)));
            addToTree(链式锻造机, 铁锻造机);
            addToTree(铁板锻造机, 铁锻造机);
            addToTree(铁板重型加工厂, 铁板锻造机);
            addToTree(铝板合成机, 链式锻造机);
            addToTree(铝板混合器, 铝板合成机);
            addToTree(黄金熔炼器, 铁锻造机);
            addToTree(混合熔炼器, 黄金熔炼器);
            addToTree(钻石离心机, 合金锤炼厂);
            addToTree(钻石矿加工厂, 钻石离心机);
            addToTree(钻石混合物反应机, 黄金熔炼器);
            addToTree(钻石提炼机, 钻石混合物反应机);
            addToTree(相织反应炉, 钻石混合物反应机);
            addToTree(物品厂_水瓶, 空壳制造机);
            addToTree(钛合金反应炉, surgeSmelter);
            addToTree(硫粉发生机, coreShard, null, Seq.with(new Objectives.Research(multiPress)));
            addToTree(放射熔炉, 爆炸冲击机);
            addToTree(固体放射机, 放射熔炉);
            addToTree(放射混合器, blastMixer);
            addToTree(硫粉发生机, coreShard, null, Seq.with(new Objectives.Research(multiPress)));
            addToTree(辐射混合机, 放射熔炉);
            addToTree(辐射混合机, 放射熔炉);
            addToTree(粒子离心机, 矿物离心机);
            addToTree(黎辉离心机, 矿物离心机);
            addToTree(冷冻液发生机, cryofluidMixer);
            addToTree(硫粉发生机, coreShard, null, Seq.with(new Objectives.Research(multiPress)));
            addToTree(制冷液混合机, 冷冻液发生机);
            addToTree(啸动冶炼机, 合金锤炼厂);
            addToTree(军火材料机, 啸动冶炼机);
            addToTree(军火库, 军火材料机);
            addToTree(水晶复合器, 军火材料机);
            addToTree(啸动冲击械, 制冷液混合机);
            addToTree(资源转换器_废料, 铁锻造机);
            addToTree(资源转换器_铜铅, 铁锻造机);
            addToTree(资源转换器_钛, 资源转换器_废料);
            addToTree(资源转换器_钍, 资源转换器_废料);
            addToTree(资源转换器_钴, 资源转换器_废料);
            addToTree(资源转换器_铝, 资源转换器_钴);
            addToTree(资源转换器_塑钢, 资源转换器_钴);

            // 防御设施
            addToTree(铅墙, coreShard, null, Seq.with(new Objectives.Research(copperWall)));
            addToTree(大型铅墙, 铅墙);
            addToTree(硅墙, 大型铅墙);
            addToTree(大型硅墙, 硅墙);
            addToTree(相织硅墙, coreShard, null, Seq.with(new Objectives.Research(phaseWallLarge)));
            addToTree(大型相织硅墙, 相织硅墙);
            addToTree(钴墙, 硅墙);
            addToTree(大型钴墙, 钴墙);
            addToTree(钛合金墙, 钴墙);
            addToTree(大型钛合金墙, 钛合金墙);
            addToTree(巨型钛合金墙, 大型钛合金墙);
            addToTree(超大型钛合金墙, 巨型钛合金墙);

        });
    }
}