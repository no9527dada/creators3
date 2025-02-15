package ct.content;

import mindustry.type.SectorPreset;

public class RebirthMaps {
    public static SectorPreset 跌落遗境, 异声, 神秘少女, 洞穴躲藏, 洞穴深处, 曲沿通道, 通道分支, 倾巢而出, 暗袭兽;
    public static SectorPreset 小秘境, 机关通道, 出口, 虫穴前沿, 虫穴, 虫母, 幻境, 重逢, 皴皲真人;
    public static void load() {
        跌落遗境 = new SectorPreset("跌落遗境", RebirthPlanet.Planet1, 0) {{
            localizedName = "跌落遗境";
            description = "你从昏迷中醒来，发现身体已无无法动弹。曾经叱咤风云的你，只记得触碰上古禁止后被打落至练气境界。但具体是如何遭遇你却是已经记忆不清";
            captureWave = 10;
            difficulty = 0;
            alwaysUnlocked = true;
            addStartingItems = true;
            overrideLaunchDefaults = true;
            noLighting = true;
        }};
        异声 = new SectorPreset("2异声", RebirthPlanet.Planet1, 2) {{
            localizedName = "异声";
            description = "正打坐恢复时，你前方不远处竟发生打斗。你内心焦灼万分，生怕被人发现";
            captureWave = 20;
            difficulty = 0;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        神秘少女 = new SectorPreset("3神秘少女", RebirthPlanet.Planet1, 3) {{
            localizedName = "神秘少女";
            description = "少女身上的刺青印记使你略感熟悉，但对方已经昏迷，无法得知具体信息";
            captureWave = 30;
            difficulty = 3;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        洞穴躲藏 = new SectorPreset("4洞穴躲藏", RebirthPlanet.Planet1, 4) {{
            localizedName = "洞穴躲藏";
            description = "你带领昏迷女子躲进了一个洞穴，躲避敌人的侦查";
            captureWave = 35;
            difficulty = 3;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        洞穴深处 = new SectorPreset("5洞穴深处", RebirthPlanet.Planet1, 5) {{
            localizedName = "洞穴深处";
            description = "你们在洞穴深处发现了一名受伤修士，在聊事后竟发现珮思思居然是极其稀有的圣体";
            captureWave = 40;
            difficulty = 9;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        曲沿通道 = new SectorPreset("6曲沿通道", RebirthPlanet.Planet1, 6) {{
            localizedName = "曲沿通道";
            description = "洞内曲沿弯折，洞洞相连且又漆黑无比，要是凡人来此必将迷路丢了性命";
            captureWave = 40;
            difficulty = 9;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        通道分支 = new SectorPreset("7通道分支", RebirthPlanet.Planet1, 7) {{
            localizedName = "通道分支";
            description = "你经过几场战斗，道心获得更加纯粹的洗涤，离筑基又更近了一步。思思也提升了境界";
            captureWave = 35;
            difficulty = 9;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        倾巢而出 = new SectorPreset("8倾巢而出", RebirthPlanet.Planet1, 8) {{
            localizedName = "倾巢而出";
            description = "已然接近老巢，这里有大量低阶妖兽盘踞";
            captureWave = 52;
            difficulty = 13;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        暗袭兽 = new SectorPreset("9暗袭兽", RebirthPlanet.Planet1, 9) {{
            localizedName = "暗袭兽";
            description = "阴暗潮湿的洞穴，黑暗中盘伏者惧光妖兽";
            // captureWave = 52;
            difficulty = 13;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        小秘境 = new SectorPreset("10小秘境", RebirthPlanet.Planet1, 10) {{
            localizedName = "小秘境";
            description = "此处就是秘境入口，但此处有大量亡骷在游荡，消灭他们，进入秘境";
            captureWave = 50;
            difficulty = 7;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        机关通道 = new SectorPreset("11机关通道", RebirthPlanet.Planet1, 11) {{
            localizedName = "机关通道";
            description = "刚进入一阵白黄之光闪烁，你顿时失去知觉。醒来时发现思思和鹿恒都不在身边，猜想是被随机传送目的地。你观察四周。发现此地是一个很深的密室通道，不知前方有什么危险等着你";
            // captureWave = 50;
            difficulty = 5;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        出口 = new SectorPreset("12出口", RebirthPlanet.Planet1, 12) {{
            localizedName = "出口";
            description = "你于重重机关中脱困而出，终于来到了这个小秘境中的一角";
            // captureWave = 50;
            difficulty = 0;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        虫穴前沿 = new SectorPreset("13虫穴前沿", RebirthPlanet.Planet1, 13) {{
            localizedName = "虫穴前沿";
            description = "来到秘境后随意选了个方向探索，不久后发现不远处有一处虫族巢穴，风险与机遇并存，你决定进去一探究竟";
            // captureWave = 50;
            difficulty = 9;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        虫穴 = new SectorPreset("14虫穴", RebirthPlanet.Planet1, 14) {{
            localizedName = "虫穴";
            description = "虫穴里遍布大量珍惜矿石，在采掘部分品质优等的资源后，你决定向更深处探寻";
            // captureWave = 50;
            difficulty = 13;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        虫母 = new SectorPreset("15虫母", RebirthPlanet.Planet1, 15) {{
            localizedName = "虫母";
            description = "虫母通过直接吞噬灵气生产虫群，对修士体内的法力灵力更是狂热，此处到处都是被吸干的修士残骸，不过秘境之中应该少有人来，不知是哪来寻得如此之多的修士";
            // captureWave = 50;
            difficulty = 13;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        幻境 = new SectorPreset("16幻境", RebirthPlanet.Planet1, 16) {{
            localizedName = "幻境";
            description = "你被虫母临死时拉入幻境阵法之中，阵法中存在大量机关禁制，当务之急是尽快走出幻境之中，以免被困得身死道消！";
            captureWave = 44;
            difficulty = 10;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        重逢 = new SectorPreset("17重逢", RebirthPlanet.Planet1, 17) {{
            localizedName = "重逢";
            description = "于虫穴中脱困后，你继续在这秘境中探索途中遇到了珮思思，随后一股强大力量从天而降....";
            captureWave = 31;
            difficulty = 10;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
        皴皲真人 = new SectorPreset("18皴皲真人", RebirthPlanet.Planet1, 18) {{
            localizedName = "[yellow]皴皲真人";
            description = "于虫穴中脱困后，你继续在这秘境中探索途中遇到了珮思思，随后一股强大力量从天而降....";
            // captureWave = 31;
            difficulty = 10;
            addStartingItems = true;//添加初始资源（地图编辑器）
            noLighting = true;
        }};
    }
}
