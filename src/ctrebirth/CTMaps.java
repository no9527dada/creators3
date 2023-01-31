package ctrebirth;

import mindustry.type.SectorPreset;

import static ctrebirth.xingqiu.冥神星;

public class CTMaps {

        public static SectorPreset
                测试地图;
        public static void load() {
            //region serpulo


            测试地图 = new SectorPreset("测试地图", 冥神星, 15) {{
                alwaysUnlocked = true;
                addStartingItems = true;
                captureWave = 10;
                difficulty = 1;
                overrideLaunchDefaults = true;
                noLighting = true;
                startWaveTimeMultiplier = 3f;
            }};
        }
        }
