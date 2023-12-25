package ct.abe.rebirth.content;

import mindustry.type.SectorPreset;

public class Maps {
    public static SectorPreset 跌落遗境,异声,神秘少女,洞穴躲藏,洞穴深处,曲沿通道,通道分支
            ;
    public static void load() {
        跌落遗境 = new SectorPreset("跌落遗境", Planets.Planet1, 0) {{
            localizedName ="跌落遗境";
            description="你从昏迷中醒来，发现身体已无无法动弹。曾经叱咤风云的你，只记得触碰上古禁止后被打落至练气境界。但具体是如何遭遇你却是已经记忆不清";
            captureWave = 10;
            difficulty = 0;
             alwaysUnlocked = true;
             addStartingItems = true;
             overrideLaunchDefaults = true;
             noLighting = true;
        }};
        异声 = new SectorPreset("2异声", Planets.Planet1, 2) {{
            localizedName ="异声";
            description="正打坐恢复时，你前方不远处竟发生打斗。你内心焦灼万分，生怕被人发现";
            captureWave = 20;
            difficulty = 0;
           addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        神秘少女 = new SectorPreset("3神秘少女", Planets.Planet1, 3) {{
            localizedName ="神秘少女";
            description="少女身上的刺青印记使你略感熟悉，但对方已经昏迷，无法得知具体信息";
            captureWave = 30;
            difficulty = 3;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        洞穴躲藏 = new SectorPreset("4洞穴躲藏", Planets.Planet1, 4) {{
            localizedName ="洞穴躲藏";
            description="你带领昏迷女子躲进了一个洞穴，躲避敌人的侦查";
            captureWave = 35;
            difficulty = 3;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        洞穴深处 = new SectorPreset("5洞穴深处", Planets.Planet1, 5) {{
            localizedName ="洞穴深处";
            description="你们在洞穴深处发现了一名受伤修士，在聊事后竟发现珮思思居然是极其稀有的圣体";
            captureWave = 40;
            difficulty = 9;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        曲沿通道 = new SectorPreset("6曲沿通道", Planets.Planet1, 6) {{
            localizedName ="曲沿通道";
            description="洞内曲沿弯折，洞洞相连且又漆黑无比，要是凡人来此必将迷路丢了性命";
            captureWave = 40;
            difficulty = 9;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        通道分支 = new SectorPreset("7通道分支", Planets.Planet1, 7) {{
            localizedName ="通道分支";
            description="你经过几场战斗，道心获得更加纯粹的洗涤，离筑基又更近了一步。思思也提升了境界";
            captureWave = 35;
            difficulty = 9;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};

    }
}
