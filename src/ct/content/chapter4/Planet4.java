package ct.content.chapter4;

import arc.Core;
import arc.graphics.Color;
import mindustry.content.Blocks;
import mindustry.content.Planets;
import mindustry.content.UnitTypes;
import mindustry.game.Team;
import mindustry.graphics.g3d.HexMesh;
import mindustry.maps.planet.TantrosPlanetGenerator;
import mindustry.type.Category;
import mindustry.type.Planet;
import mindustry.type.Sector;
import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.meta.BuildVisibility;

import static ct.CTRebirth.setPlanet;
import static ct.content.chapter4.CTItem.*;
import static mindustry.type.ItemStack.with;

public class Planet4 {

    public static Planet
            Planet4, 冥神星;

    public static Block
            coreT1, coreT2, coreT3;

    public static void load() {
        //核心
        coreT1 = new CoreBlock("core-shard") {{
            requirements(Category.effect, BuildVisibility.editorOnly, with(魂石, 300, 冥石, 500));
            alwaysUnlocked = true;//默认解锁
            incinerateNonBuildable = true;//焚烧不可建造的资源
            isFirstTier = true;
            unitType = UnitTypes.alpha;
            health = 1100;
            itemCapacity = 6000;
            size = 3;
            unitCapModifier = 0;
        }};

        //星球
        Planet4 = new Planet("Planet4", Planets.sun, 1f, 3) {{
            localizedName = Core.bundle.format("Planet4");
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
            //TODO SHOULD there be lighting?
            updateLighting = false;
            startSector = 0;
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

            unlockedOnLand.add(Blocks.coreBastion);
        }};

        setPlanet(Planet4, new String[]{"ct"});


    }

}
