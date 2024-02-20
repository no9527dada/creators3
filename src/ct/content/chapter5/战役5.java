package ct.content.chapter5;

import mindustry.type.SectorPreset;

import static ct.Asystem.type.CTTechTree.addToTree;
import static ct.content.chapter5.Planet5.Planet5;
import static mindustry.content.SectorPresets.*;

//方块
public class 战役5 {
    public static SectorPreset
            Map1;

    public static void load() {

        Map1 = new SectorPreset("爆裂矿区", Planet5, 10) {{
            localizedName = "爆裂矿区";
            addStartingItems = true;
            alwaysUnlocked = true;
            difficulty = 1;
        }};
        addToTree(Map1, stainedMountains);
    }
}