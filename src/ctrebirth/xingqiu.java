package ctrebirth;

import arc.graphics.Color;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.Planets;
import mindustry.content.UnitTypes;
import mindustry.game.Team;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.graphics.g3d.SunMesh;
import mindustry.maps.planet.TantrosPlanetGenerator;
import mindustry.type.Category;
import mindustry.type.Planet;
import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.BuildVisibility;
import mindustry.world.meta.Env;

import static mindustry.type.ItemStack.with;

public class xingqiu {
    public static Planet
            恒星,冥神星;

    public static Block
            coreT1,coreT2,coreT3;
    public static void load(){
        coreT1 = new CoreBlock("core-shard"){{
            requirements(Category.effect, BuildVisibility.editorOnly, with(Items.copper, 1000, Items.lead, 800));
            alwaysUnlocked = true;

            isFirstTier = true;
            unitType = UnitTypes.alpha;
            health = 1100;
            itemCapacity = 4000;
            size = 3;

            unitCapModifier = 8;
        }};
        恒星 = new Planet("恒星", Planets.sun, 4f){{
            bloom = true;
            accessible = false;
            orbitRadius=520;
            meshLoader = () -> new SunMesh(
                    this, 4,
                    5, 0.3, 1.7, 1.2, 1,
                    1.1f,
                    Color.valueOf("ff7a38"),
                    Color.valueOf("ff9638"),
                    Color.valueOf("ffc64c"),
                    Color.valueOf("ffc64c"),
                    Color.valueOf("ffe371"),
                    Color.valueOf("f4ee8e")
            );
        }};
        冥神星 = new Planet("冥神星", 恒星, 1f, 2){{
            generator = new TantrosPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 5);
//            cloudMeshLoader = () -> new MultiMesh(
//                    new HexSkyMesh(this, 2, 0.15f, 0.14f, 5, Color.valueOf("eba768").a(0.75f), 2, 0.42f, 1f, 0.43f),
//                    new HexSkyMesh(this, 3, 0.6f, 0.15f, 5, Color.valueOf("eea293").a(0.75f), 2, 0.42f, 1.2f, 0.45f)
//            );
//
//            landCloudColor = Color.valueOf("ed6542");
//            atmosphereColor = Color.valueOf("f07218");
//            defaultEnv = Env.scorching | Env.terrestrial;
//            startSector = 10;
//            atmosphereRadIn = 0.02f;
//            atmosphereRadOut = 0.3f;
//            tidalLock = true;
//            orbitSpacing = 2f;
//            totalRadius += 2.6f;
//            lightSrcTo = 0.5f;
//            lightDstFrom = 0.2f;
//
//            defaultCore = Blocks.coreBastion;
//            iconColor = Color.valueOf("ff9266");
//            hiddenItems.addAll(Items.serpuloItems).addAll(Items.erekirItems);
//            enemyBuildSpeedMultiplier = 0.4f;




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


            ruleSetter = r -> {
                r.waveTeam = Team.malis;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.fog = true;
                r.staticFog = true;
                r.lighting = false;
                r.coreDestroyClear = true;
                r.onlyDepositCore = true;
            };

            unlockedOnLand.add(Blocks.coreBastion);
        }};




    }

}
