package ct.Asystem.type;

import arc.struct.Seq;
import mindustry.content.TechTree;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Objectives;
import mindustry.type.ItemStack;


public class CTTechTree {


//科技树子父写法Type,水人提供代码
/*
 * @author abomb4 2022-12-27 08:29:39
 */


    /**
     * 加入现有科技树
     *
     * @param content      内容
     * @param parent       爹
     * @param requirements 物品需求
     * @param objectives   目标
     */
    public static void addToTree(UnlockableContent content, UnlockableContent parent,
                                 ItemStack[] requirements,
                                 Seq<Objectives.Objective> objectives) {
        TechTree.all.each(t -> t.content == content, TechTree.TechNode::remove);

        // find parent node
        TechTree.all.each(t -> t.content == parent, parentNode -> {
            final TechTree.TechNode node = new TechTree.TechNode(null, content,
                    requirements == null ? content.researchRequirements() : requirements);

            if (objectives != null) {
                node.objectives.addAll(objectives);
            }

            if (node.parent != null) {
                node.parent.children.remove(node);
            }

            if (!parentNode.children.contains(node)) {
                parentNode.children.add(node);
            }
            node.parent = parentNode;
        });
    }

    /**
     * 加入现有科技树
     *
     * @param content      内容
     * @param parent       爹
     * @param requirements 物品需求
     */
    public static void addToTree(UnlockableContent content, UnlockableContent parent,
                                 ItemStack[] requirements) {
        addToTree(content, parent, requirements, null);
    }

    /**
     * 加入现有科技树
     *
     * @param content 内容
     * @param parent  爹
     */
    public static void addToTree(UnlockableContent content, UnlockableContent parent) {
        addToTree(content, parent, null, null);
    }








/*    public static void load() {
        // clone serpulo tree
        final TechTree.TechNode tmp = Planets.serpulo.techTree;
        SerpuloTechTree.load();
        final TechTree.TechNode newTree = TechTree.nodeRoot("wrek", dimensionTechnologyCore5, () -> {});

        newTree.planet = DsPlanets.wrek;
        newTree.planet.techTree = newTree;
        Events.on(EventType.ClientLoadEvent.class, ev ->
                newTree.icon = new TextureRegionDrawable(dimensionTechnologyCore5.uiIcon));

        // -=-=-=-=-=-=-=-=-=-=-=- No core needed -=-=-=-=-=-=-=-=-=-=-=-
        addToTree(phaseSpaceBridge, Blocks.phaseConveyor);

        // -=-=-=-=-=-=-=-=-=-=-=- After core -=-=-=-=-=-=-=-=-=-=-=-
        // factory line
        addToTree(DsBlocks.shardReceiver, Blocks.phaseWeaver, ItemStack.with(
                Items.silicon, 200 * 30,
                Items.thorium, 320 * 30,
                Items.phaseFabric, 330 * 30,
                Items.surgeAlloy, 100 * 30
        ));
        addToTree(spaceCrystallizer, dimensionTechnologyCore5, null,
                Seq.with(new Objectives.SectorComplete(dimensionFall)));

        // distribution line
        addToTree(hardPhaseSpaceBridge, phaseSpaceBridge);

        // unit line
        addToTree(beat, dimensionT4Reconstructor);
        addToTree(rhapsody, beat, null, Seq.with(
                new Objectives.Research(dimensionT5Reconstructor),
                new Objectives.SectorComplete(darkGuard),
                new Objectives.SectorComplete(thunderLightning)
        ));

        // zones
        addToTree(dimensionFall, SectorPresets.planetaryTerminal);
        addToTree(hardStuff, dimensionFall, null, Seq.with(new Objectives.SectorComplete(dimensionFall)));
    }*/


}
