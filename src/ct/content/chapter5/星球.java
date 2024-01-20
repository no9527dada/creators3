package ct.content.chapter5;

import arc.graphics.Color;
import mindustry.content.Items;
import mindustry.content.Planets;
import mindustry.game.Team;
import mindustry.graphics.Pal;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.maps.planet.SerpuloPlanetGenerator;
import mindustry.type.Planet;
import mindustry.world.Block;

//方块
public class 星球 {
    public static Planet
            PF星球;
    public static Block FRcore;

    public static void load() {
/*           FRcore = new CoreBlock("core-shard") {{
               requirements(Category.effect, BuildVisibility.hidden, with(Items.copper, 1000, Items.lead, 800));
               alwaysUnlocked = true;

               isFirstTier = true;
               unitType = UnitTypes.alpha;
               health = 1100;
               itemCapacity = 4000;
               size = 3;

               unitCapModifier = 8;
           }};*/
        PF星球 = new Planet("PF星球", Planets.sun, 1f, 3) {{
            localizedName = "像素工业";
            generator = new SerpuloPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 11, 0.15f, 0.13f, 5, new Color().set(Pal.spore).mul(0.9f).a(0.75f), 2, 0.45f, 0.9f, 0.38f),
                    new HexSkyMesh(this, 1, 0.6f, 0.16f, 5, Color.white.cpy().lerp(Pal.spore, 0.55f).a(0.75f), 2, 0.45f, 1f, 0.41f)
            );

            launchCapacityMultiplier = 1f;
            sectorSeed = 2;
            allowWaves = false;


            //doesn't play well with configs
            prebuildBase = false;
            ruleSetter = r -> {
                r.teams.get(Team.sharded).unitDamageMultiplier = 0.5f;//单位伤害减半
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = false;
            };
            iconColor = Color.valueOf("c9b965");
            atmosphereColor = Color.valueOf("c9b965");
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            startSector = 1;

            landCloudColor = Pal.spore.cpy().a(0.5f);
            hiddenItems.addAll(Items.erekirItems).removeAll(Items.serpuloItems);

            alwaysUnlocked = true;
            clearSectorOnLose = false;//扇区丢失时是否重置地图
            enemyCoreSpawnReplace = false;//攻击图核心变刷怪点
            allowLaunchSchematics = false;//发射核心蓝图
            allowLaunchLoadout = false;//携带资源发射
            allowSectorInvasion = true;//模拟攻击图入侵
            allowWaveSimulation = false;//模拟后台波次

        }};

    }
}