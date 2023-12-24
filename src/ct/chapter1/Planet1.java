package ct.chapter1;

import arc.Core;
import arc.graphics.Color;
import ct.abe.Evn2;
import mindustry.content.Planets;
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
import static ct.ahapter.Item0.mod资源;
import static ct.ahapter.Item0.原版资源;
import static ct.ahapter.核心方块.*;
import static ct.chapter1.Item1.陶;
import static mindustry.content.Blocks.coreShard;
import static mindustry.type.ItemStack.with;

public class Planet1 {
    public static Planet
            Planet1;

/*    public static Block
            coreT1,coreT2,coreT3;*/
    public static void load(){
        coreShard. requirements(Category.effect, BuildVisibility.editorOnly, with());
        Planet1 = new Planet("Planet1", Planets.sun, 1f, 3){{
            localizedName = Core.bundle.format("Planet1");
            generator = new TantrosPlanetGenerator(){
                public boolean allowLanding(Sector sector) {
                return false;
            }//关闭数字区块
                public void generateSector(Sector sector) {

                }//无基地
                {}};
            iconColor = Color.valueOf("fff962");
            defaultEnv = Evn2.标志1 | Env.terrestrial;//*这个星球上扇区的环境标志。
            defaultCore = core0;
            meshLoader = () -> new HexMesh(this, 5);
            bloom = true;
            startSector = 0;
            //星球的初始核心蓝图：
            generator.defaultLoadout= Schematics.readBase64("bXNjaAF4nGNgZmBmZmDJS8xNZRB7Nnfpi/ZVfv4KlqZG5s9ntbyYPPfp7H0M3CmpxclFmQUlmfl5DAwMbDmJSak5xQxM0bGMDBzJJbrJ+UWpBkAJRhACEgCvlRjA");
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

        setPlanet(Planet1,new String[]{"ct"});


    }

}
