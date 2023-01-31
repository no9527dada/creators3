package ctrebirth;

//import mindustry.content.Planets;

import mindustry.content.TechTree;

import static ctrebirth.type.CTTechTree.addToTree;
import static ctrebirth.xingqiu.coreT1;
import static mindustry.content.TechTree.node;

public class TechTrees {

    public static float 倍率 = 1;

    public static void load() {
        xingqiu.冥神星.techTree = TechTree.nodeRoot("科技树名字", coreT1, true, () -> {
/*            node(黑油精炼台, () -> {
                node(coreT1, () -> {

                });
            });*/
         //   null
           /* addToTree(黑油精炼台, coreT1, ItemStack.with(
                            Items.silicon, 200 * 30,
                            Items.thorium, 320 * 30,
                            Items.phaseFabric, 330 * 30,
                            Items.surgeAlloy, 100 * 30
                    ),
                    Seq.with(
                            new Objectives.Research(dimensionT5Reconstructor),//研究
                            new Objectives.SectorComplete(darkGuard),//占领

                    ));*/













































































































        });
    }
}
