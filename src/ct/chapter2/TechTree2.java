package ct.chapter2;

import arc.Core;
import mindustry.content.TechTree;
import mindustry.type.SectorPreset;

import static ct.type.CTTechTree.addToTree;
import static mindustry.content.Blocks.*;


public class TechTree2 {
    public static float TechTrees2倍率 = 1;

    public static void load() {
        Planet2.Planet2.techTree = TechTree.nodeRoot(Core.bundle.format("Planet22"), coreShard, true, () -> {
            SectorPreset mull2 = new SectorPreset("mull2",Planet2.Planet2, 100) {{
                localizedName = "未开放";
                captureWave = 10;
                difficulty = 0;
                alwaysUnlocked = false;
//                addStartingItems = true;
//                overrideLaunchDefaults = true;
//                noLighting = true;
            }};
        });
}}
