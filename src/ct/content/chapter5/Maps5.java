package ct.content.chapter5;

import ct.content.chapter1.Planet1;
import mindustry.type.SectorPreset;

import static mindustry.content.Planets.serpulo;

public class Maps5 {
    public static SectorPreset 零号, 盐碱荒滩, 冰冻森林, 生物质合成区, 陨石坑, 废墟海岸, 风吹海岛, 绵延群山, 提取前哨, 海岸线,
            海军要塞, 真菌通道, 增生区, 油田, 冲击区, 荒芜裂谷, 核矩阵, 行星发射终端,
            战役;

    public static void load() {

        零号 = new SectorPreset("CT3groundZero", Planet1.Planet1, 15) {{
            alwaysUnlocked = true;
            addStartingItems = true;
            captureWave = 10;
            difficulty = 1;
            overrideLaunchDefaults = true;
            noLighting = true;
            startWaveTimeMultiplier = 3f;
        }};

        盐碱荒滩 = new SectorPreset("CT3saltFlats", Planet1.Planet1, 101) {{
            difficulty = 5;
        }};

        冰冻森林 = new SectorPreset("CT3frozenForest", Planet1.Planet1, 86) {{
            captureWave = 15;
            difficulty = 2;
        }};

        生物质合成区 = new SectorPreset("CT3biomassFacility", Planet1.Planet1, 81) {{
            captureWave = 20;
            difficulty = 3;
        }};

        陨石坑 = new SectorPreset("CT3craters", Planet1.Planet1, 18) {{
            captureWave = 20;
            difficulty = 2;
        }};

        废墟海岸 = new SectorPreset("CT3ruinousShores", Planet1.Planet1, 213) {{
            captureWave = 30;
            difficulty = 3;
        }};

        风吹海岛 = new SectorPreset("CT3windsweptIslands", Planet1.Planet1, 246) {{
            captureWave = 30;
            difficulty = 4;
        }};

        绵延群山 = new SectorPreset("CT3stainedMountains", Planet1.Planet1, 20) {{
            captureWave = 30;
            difficulty = 3;
        }};

        提取前哨 = new SectorPreset("CT3extractionOutpost", Planet1.Planet1, 165) {{
            difficulty = 5;
        }};
//边际海岸
        海岸线 = new SectorPreset("CT3coastline", Planet1.Planet1, 108) {{
            captureWave = 30;
            difficulty = 5;
        }};

        海军要塞 = new SectorPreset("CT3navalFortress", Planet1.Planet1, 216) {{
            difficulty = 9;
        }};

        真菌通道 = new SectorPreset("CT3fungalPass", Planet1.Planet1, 21) {{
            difficulty = 4;
        }};

        增生区 = new SectorPreset("CT3overgrowth", Planet1.Planet1, 134) {{
            difficulty = 5;
        }};

        油田 = new SectorPreset("CT3tarFields", Planet1.Planet1, 23) {{
            captureWave = 40;
            difficulty = 5;
        }};

        冲击区 = new SectorPreset("CT3impact0078", Planet1.Planet1, 227) {{
            captureWave = 45;
            difficulty = 7;
        }};

        荒芜裂谷 = new SectorPreset("CT3desolateRift", Planet1.Planet1, 123) {{
            captureWave = 18;
            difficulty = 8;
        }};

        核矩阵 = new SectorPreset("CT3nuclearComplex", Planet1.Planet1, 130) {{
            captureWave = 50;
            difficulty = 7;
        }};

        行星发射终端 = new SectorPreset("CT3planetaryTerminal", Planet1.Planet1, 93) {{
            difficulty = 10;
            isLastSector = true;
        }};



/*        跌落遗境 = new SectorPreset("跌落遗境", Planet1.Planet1, 0) {{
            localizedName = "跌落遗境";
            description = "你从昏迷中醒来，发现身体已无无法动弹。曾经叱咤风云的你，只记得触碰上古禁止后被打落至练气境界。但具体是如何遭遇你却是已经记忆不清";
            captureWave = 10;
            difficulty = 0;
            alwaysUnlocked = true;
            addStartingItems = true;
            overrideLaunchDefaults = true;
            noLighting = true;
        }};
        异声 = new SectorPreset("2异声", Planet1.Planet1, 2) {{
            localizedName = "异声";
            description = "正打坐恢复时，你前方不远处竟发生打斗。你内心焦灼万分，生怕被人发现";
            captureWave = 20;
            difficulty = 0;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};*/
    }
}
