package ct.content;

import arc.Core;
import arc.struct.Seq;
import mindustry.content.TechTree;
import mindustry.game.Objectives;
import mindustry.type.ItemStack;

import static CtCoreSystem.CoreSystem.type.CTTechTree.addToTree;

import static ct.content.境界科技研究.*;
import static ct.content.CT3CoreBlocks.*;
import static ct.content.RebirthBlocks.*;
import static ct.content.RebirthDrill.*;
import static ct.content.RebirthItem.*;
import static ct.content.RebirthMaps.*;
import static ct.content.RebirthTurrets.*;
import static ct.content.RebirthWall.*;
import static ct.content.RebirthWuLiu.*;

//     researchCostMultiplier = 1.5f;//科技树中的研究资源倍率

public class RebirthTechTree {
    public static float TechTrees1倍率 = 1;

    public static void load() {
        境界科技研究.load();

        RebirthPlanet.Planet1.techTree = TechTree.nodeRoot(Core.bundle.format("Planet11"), core0, true, () -> {
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
            addToTree(core2, core1, null,
                    Seq.with(
                            new Objectives.SectorComplete(曲沿通道)//占领地图
                    ));
            addToTree(core3, core2, null,
                    Seq.with(
                            new Objectives.SectorComplete(幻境)//占领地图
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
            addToTree(物品卸载器, 路由器, null, Seq.with(
                    new Objectives.SectorComplete(通道分支)//占领地图
            ));
            addToTree(仓库, 物品卸载器, null, Seq.with(
                    new Objectives.SectorComplete(倾巢而出)//占领地图
            ));
            // addToTree(大仓库, 仓库);


            addToTree(液体导管, core0);
            addToTree(液体路由器, 液体导管);
            addToTree(液体连接器, 液体导管);
            addToTree(灵化液体导管, 液体导管);
            addToTree(液体桥接器, 液体导管, null,
                    Seq.with(new Objectives.SectorComplete(洞穴躲藏))//占领地图)
            );
            addToTree(远程液体桥接器, 液体桥接器);
            addToTree(液仓, 液体桥接器, null,
                    Seq.with(
                            new Objectives.Research(萤玫)//研究方块或资源
                    ));


            addToTree(陶玉钻头, core0, ItemStack.with(
                    陶, 100
            ));
            addToTree(灵玉钻头, 陶玉钻头, null, Seq.with(
                    new Objectives.SectorComplete(神秘少女)//占领地图
            ));
            addToTree(威灵钻头, 灵玉钻头, null, Seq.with(
                    new Objectives.SectorComplete(通道分支)//占领地图
            ));
            addToTree(明宝钻头, 威灵钻头, null, Seq.with(
                    new Objectives.SectorComplete(虫母)//占领地图
            ));
//            addToTree(汲水器, 威灵钻头);
            /**************/
            addToTree(幻烬炼宝器, core0);
            addToTree(运符炼宝器, 幻烬炼宝器, null, Seq.with(
                    new Objectives.SectorComplete(异声)//占领地图
            ));
            addToTree(焚化炉, 幻烬炼宝器, null, Seq.with(
                    new Objectives.SectorComplete(异声)//占领地图
            ));
            addToTree(破碎炉, 焚化炉, null, Seq.with(
                    new Objectives.SectorComplete(虫穴)//占领地图
            ));
            addToTree(灵玉炼宝器, 运符炼宝器, null, Seq.with(
                    new Objectives.SectorComplete(神秘少女)//占领地图
            ));
            addToTree(灵液炼制炉, 灵玉炼宝器, null, Seq.with(
                    new Objectives.SectorComplete(洞穴躲藏)//占领地图
            ));
            addToTree(血晶炼宝器, 灵玉炼宝器, null, Seq.with(
                    new Objectives.SectorComplete(洞穴躲藏)//占领地图
            ));
            addToTree(威灵炼宝器, 灵液炼制炉, null, Seq.with(
                    new Objectives.SectorComplete(曲沿通道)//占领地图
            ));
            addToTree(幻烬聚宝炉, 幻烬炼宝器, null, Seq.with(
                    new Objectives.SectorComplete(倾巢而出)//占领地图
            ));
            addToTree(萤玫化宝鼎, 威灵炼宝器, null, Seq.with(
                    new Objectives.SectorComplete(暗袭兽)//占领地图
            ));
            /**************/
            addToTree(修补器, core0, null,
                    Seq.with(new Objectives.SectorComplete(虫穴))//占领地图)
            );


            addToTree(陶墙1, core0, null, Seq.with(
                    new Objectives.SectorComplete(异声)//占领地图
            ));
            addToTree(陶墙2, 陶墙1);
            addToTree(幻烬墙, 陶墙2, null,
                    Seq.with(new Objectives.SectorComplete(洞穴躲藏))//占领地图)
            );
            addToTree(缕墙, 幻烬墙, null,
                    Seq.with(new Objectives.SectorComplete(洞穴深处))//占领地图)
            );
            addToTree(灵化缕墙, 缕墙, null,
                    Seq.with(new Objectives.SectorComplete(曲沿通道))//占领地图)
            );
            addToTree(小离墙, 缕墙, null
                    // Seq.with(new Objectives.SectorComplete(曲沿通道))//占领地图)
            );
            addToTree(离墙, 小离墙, null
                    // Seq.with(new Objectives.SectorComplete(曲沿通道))//占领地图)
            );
            /**************/
            addToTree(灵力收集器, core0, null,
                    Seq.with(new Objectives.Research(幻烬炼宝器))
            );
            addToTree(十字节点, 灵力收集器);
            addToTree(一品灵力产生器, 灵力收集器, null,
                    Seq.with(new Objectives.SectorComplete(曲沿通道))//占领地图)
            );//打7-1关


            /**************/
            addToTree(月牙, core0, null,
                    Seq.with(new Objectives.Research(幻烬炼宝器), new Objectives.Research(幻烬))
            );
            addToTree(闪电链, 月牙, null,
                    Seq.with(new Objectives.SectorComplete(神秘少女))//占领地图)
            );
            addToTree(墨雪, 月牙, null,
                    Seq.with(new Objectives.SectorComplete(洞穴躲藏))//占领地图)
            );
            addToTree(刺镰, 闪电链, null,
                    Seq.with(new Objectives.SectorComplete(洞穴深处))//占领地图)
            );
            addToTree(赤狐, 墨雪, null,
                    Seq.with(new Objectives.SectorComplete(通道分支))//占领地图)
            );
            addToTree(飞星, 墨雪, null,
                    Seq.with(new Objectives.SectorComplete(出口))//占领地图)
            );
            addToTree(宏裂, 刺镰, null,
                    Seq.with(new Objectives.SectorComplete(暗袭兽))//占领地图)
            );
            addToTree(冰蜂, 飞星, null,
                    Seq.with(new Objectives.SectorComplete(重逢))//占领地图)
            );
            /**************/
            addToTree(跌落遗境, core0);
            addToTree(异声, 跌落遗境, null, Seq.with(
                    new Objectives.SectorComplete(跌落遗境)//占领地图
            ));
            addToTree(神秘少女, 异声, null, Seq.with(
                    new Objectives.SectorComplete(异声)//占领地图
            ));
            addToTree(洞穴躲藏, 神秘少女, null, Seq.with(
                    new Objectives.SectorComplete(神秘少女)//占领地图
            ));
            addToTree(洞穴深处, 洞穴躲藏, null, Seq.with(
                    new Objectives.SectorComplete(洞穴躲藏)//占领地图
            ));
            addToTree(曲沿通道, 洞穴深处, null, Seq.with(
                    new Objectives.SectorComplete(洞穴深处)//占领地图
            ));
            addToTree(通道分支, 曲沿通道, null, Seq.with(
                    new Objectives.Research(core2),//研究方块或资源
                    new Objectives.SectorComplete(曲沿通道)//占领地图
            ));
            addToTree(倾巢而出, 曲沿通道, null, Seq.with(
                    new Objectives.Research(赤狐),//研究方块或资源
                    new Objectives.SectorComplete(通道分支)//占领地图
            ));
            addToTree(暗袭兽, 倾巢而出, null, Seq.with(
                    new Objectives.Research(赤狐),//研究方块或资源
                    new Objectives.SectorComplete(倾巢而出)//占领地图
            ));
            addToTree(小秘境, core0, null, Seq.with(
                    new Objectives.Research(宏裂),//研究方块或资源
                    new Objectives.SectorComplete(暗袭兽)//占领地图
            ));
            addToTree(机关通道, 小秘境, null, Seq.with(
                    new Objectives.SectorComplete(小秘境)//占领地图
            ));
            addToTree(出口, 机关通道, null, Seq.with(
                    new Objectives.SectorComplete(机关通道)//占领地图
            ));
            addToTree(虫穴前沿, 出口, null, Seq.with(
                    new Objectives.SectorComplete(出口)//占领地图
            ));
            addToTree(虫穴, 虫穴前沿, null, Seq.with(
                    new Objectives.SectorComplete(虫穴前沿)//占领地图
            ));
            addToTree(虫母, 虫穴, null, Seq.with(
                    new Objectives.SectorComplete(虫穴)//占领地图
            ));
            addToTree(重逢, 虫母, null, Seq.with(
                    new Objectives.SectorComplete(虫母)//占领地图
            ));
            addToTree(皴皲真人, 重逢, null, Seq.with(
                    new Objectives.SectorComplete(重逢)//占领地图
            ));
        });
    }
}

