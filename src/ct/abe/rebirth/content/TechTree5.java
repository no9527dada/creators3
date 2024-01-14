package ct.abe.rebirth.content;

import arc.Core;
import mindustry.content.TechTree;
import mindustry.type.SectorPreset;

import static mindustry.content.Blocks.*;

public class TechTree5 {
    public static float TechTrees5倍率 = 1;

    public static void load() {
        Planets.Planet5.techTree = TechTree.nodeRoot(Core.bundle.format("Planet55"), coreShard, true, () -> {

            SectorPreset mull5 = new SectorPreset("mull5", Planets.Planet5, 100) {{
                localizedName = "未开放";
                captureWave = 10;
                difficulty = 0;
                alwaysUnlocked = false;
            }};
        });
}}