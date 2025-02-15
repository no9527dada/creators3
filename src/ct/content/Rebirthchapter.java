package ct.content;


public class Rebirthchapter {
    public static void load() {
        //加载顺序非必要不能随意变动
        //RebirthItem.load();//已经在主类加载

        RebirthCoreUnit.load();
        RebirthUnitNPC.load();
        RebirthBullets.load();
        RebirthTurrets.load();
        RebirthBlocks.load();
        RebirthWall.load();

        CT3CoreBlocks.load();
        RebirthWuLiu.load();
        RebirthDrill.load();

        CT3editorBlocks.load();//编辑器使用方块

        RebirthPlanet.load();
        RebirthMaps.load();
        RebirthTechTree.load();


    }
}
