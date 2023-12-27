package ct.abe.rebirth.content;

import arc.Core;

import arc.struct.Seq;
import ct.ahapter.境界科技研究;
import mindustry.content.TechTree;
import mindustry.game.Objectives;
import mindustry.type.ItemStack;

import static ct.ahapter.境界科技研究.*;
import static ct.abe.rebirth.content.Blocks.*;
import static ct.abe.rebirth.content.Items.*;
import static ct.abe.rebirth.content.Maps.*;
import static ct.abe.rebirth.content.Turrets.*;
import static ct.type.CTTechTree.addToTree;

//     researchCostMultiplier = 1.5f;//科技树中的研究资源倍率
public class TechTree1 {
    public static float TechTrees1倍率 = 1;

    public static void load() {
        境界科技研究.load();
        Planets.Planet1.techTree = TechTree.nodeRoot(Core.bundle.format("Planet11"), core0, true, () -> {
            addToTree(筑基境界, core0, ItemStack.with(
                    筑基丹, 10),
                    Seq.with(new Objectives.Research(筑基丹))
            );
            addToTree(金丹境界, 筑基境界, ItemStack.with(
                    聚灵丹, 30),
                    Seq.with(new Objectives.Research(聚灵丹))
            );
            addToTree(元婴境界, 金丹境界, ItemStack.with(
                    合婴丹, 50),
                    Seq.with(new Objectives.Research(合婴丹))
            );

            addToTree(core1, core0);
            addToTree(core2, core1,null,
                    Seq.with(
                         new Objectives.SectorComplete(曲沿通道)//占领地图
                    ));

            addToTree(陶玉运输带, core0);
            addToTree(威灵运输带, 陶玉运输带);
            addToTree(灵化威灵运输带, 威灵运输带);
            addToTree(明宝打包运输带, 灵化威灵运输带);
            addToTree(路由器, 陶玉运输带);
            addToTree(连接器, 路由器);
            addToTree(分配器, 路由器);


            addToTree(分类器, 路由器, null,
                    Seq.with(
                            new Objectives.Research(幻烬)//研究方块或资源
                            //  new Objectives.SectorComplete(darkGuard),占领地图
                    ));

            addToTree(反向分类器, 分类器);
            addToTree(溢流门, 分类器);
            addToTree(反向溢流门, 溢流门);
            addToTree(灵玉运输桥, 陶玉运输带);
            addToTree(萤玫运输桥, 灵玉运输桥);
                addToTree(物品卸载器, 路由器,null, Seq.with(
                        new Objectives.SectorComplete(通道分支)//占领地图
                ));
           // addToTree(仓库, 物品卸载器);//打第7-2关
           // addToTree(大仓库, 仓库);


            addToTree(液体导管, core0);
            addToTree(液体路由器, 液体导管);
            addToTree(液体连接器, 液体导管);
                     addToTree(灵化液体导管, 液体导管);
            addToTree(液体桥接器, 液体导管,null,
                    Seq.with( new Objectives.SectorComplete(洞穴躲藏))//占领地图)
            );
            addToTree(远程液体桥接器, 液体桥接器);
            addToTree(液仓, 液体桥接器);


            addToTree(陶玉钻头, core0, ItemStack.with(
                    陶, 100
            ));
            addToTree(灵玉钻头, 陶玉钻头,null, Seq.with(
                    new Objectives.SectorComplete(神秘少女)//占领地图
            ));
           addToTree(威灵钻头, 灵玉钻头,null, Seq.with(
                    new Objectives.SectorComplete(通道分支)//占领地图
            ));
//            addToTree(明宝钻头, 威灵钻头);
//            addToTree(汲水器, 威灵钻头);
            /**************/
            addToTree(幻烬炼宝器, core0);
            addToTree(运符炼宝器, 幻烬炼宝器,null, Seq.with(
                    new Objectives.SectorComplete(异声)//占领地图
            ));
            addToTree(焚化炉, 幻烬炼宝器,null, Seq.with(
                    new Objectives.SectorComplete(异声)//占领地图
            ));
            addToTree(灵玉炼宝器, 运符炼宝器,null, Seq.with(
                    new Objectives.SectorComplete(神秘少女)//占领地图
            ));
            addToTree(灵液炼制炉, 灵玉炼宝器,null, Seq.with(
                    new Objectives.SectorComplete(洞穴躲藏)//占领地图
            ));
            addToTree(血晶炼宝器, 灵玉炼宝器,null, Seq.with(
            new Objectives.SectorComplete(洞穴躲藏)//占领地图
            ));
            addToTree(威灵炼宝器, 灵液炼制炉,null, Seq.with(
                    new Objectives.SectorComplete(曲沿通道)//占领地图
            ));
            /**************/
            addToTree(陶墙1, core0,null, Seq.with(
                    new Objectives.SectorComplete(异声)//占领地图
            ));
            addToTree(陶墙2, 陶墙1);
            addToTree(幻烬墙, 陶墙2,null,
                    Seq.with( new Objectives.SectorComplete(洞穴躲藏))//占领地图)
            );
            addToTree(缕墙, 幻烬墙,null,
                    Seq.with( new Objectives.SectorComplete(洞穴深处))//占领地图)
            );
            addToTree(灵化缕墙, 缕墙,null,
                    Seq.with( new Objectives.SectorComplete(曲沿通道))//占领地图)
            );

            /**************/
            addToTree(灵力收集器, core0, null,
                    Seq.with(new Objectives.Research(幻烬炼宝器))
            );
            addToTree(十字节点, 灵力收集器);
            addToTree(一品灵力产生器, 灵力收集器  ,null,
                    Seq.with( new Objectives.SectorComplete(曲沿通道))//占领地图)
            );//打7-1关


            /**************/
            addToTree(月牙, core0, null,
                    Seq.with(new Objectives.Research(幻烬炼宝器),new Objectives.Research(幻烬))
                 );
            addToTree(闪电链, 月牙, null,
                    Seq.with( new Objectives.SectorComplete(神秘少女))//占领地图)
            );
            addToTree(墨雪, 月牙, null,
                    Seq.with( new Objectives.SectorComplete(洞穴躲藏))//占领地图)
            );
            addToTree(刺镰, 闪电链, null,
                    Seq.with( new Objectives.SectorComplete(洞穴深处))//占领地图)
            );
            addToTree(赤狐, 墨雪, null,
                    Seq.with( new Objectives.SectorComplete(通道分支))//占领地图)
            );
            /**************/
            addToTree(跌落遗境, core0);
            addToTree(异声, 跌落遗境,  null, Seq.with(
                new Objectives.SectorComplete(跌落遗境)//占领地图
            ));
            addToTree(神秘少女, 异声,  null, Seq.with(
                    new Objectives.SectorComplete(异声)//占领地图
            ));
            addToTree(洞穴躲藏, 神秘少女,  null, Seq.with(
                    new Objectives.SectorComplete(神秘少女)//占领地图
            ));
            addToTree(洞穴深处, 洞穴躲藏,  null, Seq.with(
                    new Objectives.SectorComplete(洞穴躲藏)//占领地图
            ));
            addToTree(曲沿通道, 洞穴深处,  null, Seq.with(
                    new Objectives.SectorComplete(洞穴深处)//占领地图
            ));
            addToTree(通道分支, 曲沿通道,  null, Seq.with(
                    new Objectives.Research(core2),//研究方块或资源
                    new Objectives.SectorComplete(曲沿通道)//占领地图
            ));
        });
    }
}
