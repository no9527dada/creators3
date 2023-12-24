package ct.chapter4;

import arc.Core;
import ct.chapter3.Planet3;
import mindustry.content.TechTree;
import mindustry.type.SectorPreset;

import static mindustry.content.Blocks.*;


public class TechTree4 {
    public static float TechTrees4倍率 = 1;

    public static void load() {
        Planet4.Planet4.techTree = TechTree.nodeRoot(Core.bundle.format("Planet44"), coreShard, true, () -> {

            SectorPreset mull4 = new SectorPreset("mull4", Planet4.Planet4, 0) {{
                localizedName = "未开放";
                captureWave = 10;
                difficulty = 0;
                alwaysUnlocked = false;
            }};
        });
}}
