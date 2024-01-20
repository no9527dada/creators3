package ct.content.chapter2;

import arc.Core;
import arc.graphics.Color;
import mindustry.content.Blocks;
import mindustry.content.Planets;
import mindustry.game.Team;
import mindustry.graphics.g3d.HexMesh;
import mindustry.maps.planet.TantrosPlanetGenerator;
import mindustry.type.Planet;
import mindustry.type.Sector;

import static ct.CTRebirth.setPlanet;

public class Planet2 {
    public static Planet
            Planet2;

    /*    public static Block
                coreT1,coreT2,coreT3;*/
    public static void load() {

        Planet2 = new Planet("Planet2", Planets.sun, 1f, 3) {{
            localizedName = Core.bundle.format("Planet2");
            generator = new TantrosPlanetGenerator() {
                public boolean allowLanding(Sector sector) {
                    return false;
                }//关闭数字区块

                public void generateSector(Sector sector) {

                }//无基地

                {
                }
            };
            iconColor = Color.valueOf("fff962");
            meshLoader = () -> new HexMesh(this, 5);
            bloom = true;
            alwaysUnlocked = true;
            clearSectorOnLose = false;//扇区丢失时是否重置地图
            enemyCoreSpawnReplace = false;//攻击图核心变刷怪点
            allowLaunchSchematics = false;//开启发射核心蓝图
            allowLaunchLoadout = false;//开启携带资源发射
            allowSectorInvasion = true;//模拟攻击图入侵
            allowWaveSimulation = false;//模拟后台波次
            accessible = true;
            startSector = 100;
            //TODO SHOULD there be lighting?
            updateLighting = false;
            ruleSetter = r -> {
                r.unitAmmo = true;//单位需要子弹
                r.showSpawns = true;//显示单位刷出点
                r.unitCap = 9999;//单位上限
                r.onlyDepositCore = true;//物品只能存放在核心
                r.coreDestroyClear = true;//死亡时(敌人)核心半径内的每个敌人方块都会被摧毁。


                r.waveTeam = Team.malis;
                r.placeRangeCheck = false;
                r.fog = true;
                r.staticFog = true;
                r.lighting = false;


            };

            unlockedOnLand.add(Blocks.coreShard);
        }};

        setPlanet(Planet2, new String[]{"ct"});


    }

}
