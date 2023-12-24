package ct.chapter3;

import arc.Core;
import ct.chapter2.Planet2;
import mindustry.content.TechTree;
import mindustry.type.SectorPreset;

import static mindustry.content.Blocks.*;


public class TechTree3 {
    public static float TechTrees3倍率 = 1;

    public static void load() {
        Planet3.Planet3.techTree = TechTree.nodeRoot(Core.bundle.format("Planet33"), coreShard, true, () -> {

            SectorPreset mull3 = new SectorPreset("mull3", Planet3.Planet3, 100) {{
                localizedName = "未开放";
                captureWave = 10;
                difficulty = 0;
                alwaysUnlocked = false;
            }};
        });
}}
