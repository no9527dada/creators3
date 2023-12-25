package ct.abe.rebirth.content;

import arc.Core;
import arc.graphics.Color;
import ct.abe.Evn2;
import mindustry.content.Blocks;
import mindustry.game.Schematics;
import mindustry.game.Team;
import mindustry.graphics.g3d.HexMesh;
import mindustry.maps.planet.TantrosPlanetGenerator;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.Planet;
import mindustry.type.Sector;
import mindustry.world.meta.BuildVisibility;
import mindustry.world.meta.Env;

import static ct.CTRebirth.setPlanet;
import static ct.abe.rebirth.content.Blocks.core0;
import static ct.abe.rebirth.content.Items.*;
import static mindustry.content.Blocks.coreShard;
import static mindustry.type.ItemStack.with;

public class Planets {
    public static Planet
            Planet1,
            Planet2,
            Planet3,
            冥神星,
            Planet4,
            Planet5;


    /*    public static Block
            coreT1,coreT2,coreT3;*/
    public static void load() {
        initPlanet1();
        initPlanet2();
        initPlanet3();
        initPlanet4();
        initPlanet5();
    }

    private static void initPlanet1() {
        coreShard.requirements(Category.effect, BuildVisibility.editorOnly, with());
        Planet1 = new Planet("Planet1", mindustry.content.Planets.sun, 1f, 3) {{
            localizedName = Core.bundle.format("Planet1");
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
            defaultEnv = Evn2.标志1 | Env.terrestrial;//*这个星球上扇区的环境标志。
            defaultCore = core0;
            meshLoader = () -> new HexMesh(this, 5);
            bloom = true;
            startSector = 0;
            //星球的初始核心蓝图：
            generator.defaultLoadout = Schematics.readBase64("bXNjaAF4nGNgZmBmZmDJS8xNZRB7Nnfpi/ZVfv4KlqZG5s9ntbyYPPfp7H0M3CmpxclFmQUlmfl5DAwMbDmJSak5xQxM0bGMDBzJJbrJ+UWpBkAJRhACEgCvlRjA");
            alwaysUnlocked = true;
            clearSectorOnLose = true;//扇区丢失时是否重置地图
            enemyCoreSpawnReplace = false;//攻击图核心变刷怪点
            allowLaunchSchematics = false;//开启发射核心蓝图
            allowLaunchLoadout = false;//开启携带资源发射
            allowSectorInvasion = false;//模拟攻击图入侵
            allowWaveSimulation = false;//模拟后台波次
            accessible = true;

            hiddenItems.addAll(原版资源).removeAll(mod资源);//隐藏原版的资源
            //  hiddenItems.addAll(Item1.仅章节1资源).removeAll(Items.erekirItems);
            //TODO SHOULD there be lighting?
            updateLighting = false;
            ruleSetter = r -> {
                // r. unitAmmo = true;//单位需要子弹
                r.showSpawns = true;//显示单位刷出点
                r.unitCap = 5;//单位上限
                r.onlyDepositCore = true;//物品只能存放在核心
                r.coreDestroyClear = true;//死亡时(敌人)核心半径内的每个敌人方块都会被摧毁。
                r.loadout = ItemStack.list(陶, 100);


                r.waveTeam = Team.malis;
                r.placeRangeCheck = false;
                r.fog = true;
                r.staticFog = true;
                r.lighting = false;


            };
            unlockedOnLand.add(core0);

        }};

        setPlanet(Planet1, new String[]{"ct"});


    }


    private static void initPlanet2() {

        Planet2 = new Planet("Planet2", mindustry.content.Planets.sun, 1f, 3) {{
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


    private static void initPlanet3() {

        Planet3 = new Planet("Planet3", mindustry.content.Planets.sun, 1f, 3) {{
            localizedName = Core.bundle.format("Planet3");
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
            startSector = 100;
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
        setPlanet(Planet3, new String[]{"ct"});
    }

    private static void initPlanet4() {
        //核心
        //星球
        Planet4 = new Planet("Planet4", mindustry.content.Planets.sun, 1f, 3) {{
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

    private static void initPlanet5() {

        Planet5 = new Planet("Planet5", mindustry.content.Planets.sun, 1f, 3) {{
            localizedName = Core.bundle.format("Planet5");
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
            startSector = 100;
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
        setPlanet(Planet5, new String[]{"ct"});
    }
}
