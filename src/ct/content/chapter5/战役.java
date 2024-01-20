package ct.content.chapter5;

import mindustry.type.SectorPreset;

import static ct.Asystem.type.CTTechTree.addToTree;
import static ct.content.chapter5.星球.PF星球;
import static mindustry.content.SectorPresets.*;

//方块
public class 战役 {
    public static SectorPreset
            Map1;

    public static void load() {

        Map1 = new SectorPreset("爆裂矿区", PF星球, 10) {{
            localizedName = "爆裂矿区";
            addStartingItems = true;
            alwaysUnlocked = true;
            difficulty = 1;
        }};
        addToTree(Map1, stainedMountains);
    }
}