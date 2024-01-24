/*
package ct.content.chapter4;


import mindustry.content.TechTree;
import mindustry.type.ItemStack;


import static ct.Asystem.type.CTTechTree.addToTree;

import static ct.content.chapter4.CT3Blocks4.*;
import static ct.content.chapter4.CT3Item4.*;
import static ct.content.chapter4.ItemsSMCyeLian.*;
import static ct.content.chapter4.Planet4.*;


public class BlocksTechTrees {

    public static float BlocksTechTrees倍率 = 1;

    public static void load() {
        Planet4.techTree = TechTree.nodeRoot("重生-工厂/战役", coreT1, true, () -> {
            //--------------------------------资源冶炼台1, 资源冶炼台2,资源冶炼台3;
            addToTree(珊绒透筛器, coreT1, ItemStack.with(//
                    冥翠块, 250,
                    怨石块, 400,
                    怨气集束, 300,
                    灵魂核心, 100,
                    棺炆魂矩, 220 * BlocksTechTrees倍率, 赤水魂矩, 350 * BlocksTechTrees倍率
            ));
            addToTree(珊绒重组器, 珊绒透筛器, ItemStack.with(//
                    翠灵晶, 300,
                    混沌晶体, 250,
                    灵魂核心, 120,
                    缜相织, 400,
                    气光散, 200,
                    棺炆魂矩, 1000 * BlocksTechTrees倍率, 赤水魂矩, 1000 * BlocksTechTrees倍率, 止枢魂矩, 1000 * BlocksTechTrees倍率
            ));

            addToTree(资源冶炼台1, coreT1, ItemStack.with(//
                    冥翠块, 250,
                    怨石块, 400,
                    怨气集束, 300,
                    灵魂核心, 100,
                    棺炆魂矩, 220 * BlocksTechTrees倍率, 赤水魂矩, 350 * BlocksTechTrees倍率
            ));
            addToTree(资源冶炼台2, 资源冶炼台1, ItemStack.with(//
                    冥翠块, 1,
                    怨石块, 1,
                    怨气集束, 1,
                    灵魂核心, 1,
                    棺炆魂矩, 2500 * BlocksTechTrees倍率, 止枢魂矩, 1800 * BlocksTechTrees倍率, 绝情魂矩, 1400 * BlocksTechTrees倍率
            ));
            addToTree(资源冶炼台3, 资源冶炼台2, ItemStack.with(//
                    冥翠块, 1,
                    怨石块, 1,
                    怨气集束, 1,
                    灵魂核心, 1,
                    棺炆魂矩, 2500 * BlocksTechTrees倍率, 止枢魂矩, 1800 * BlocksTechTrees倍率, 绝情魂矩, 1400 * BlocksTechTrees倍率, 混仑魂矩, 1000 * BlocksTechTrees倍率
            ));


        });
    }
}*/
