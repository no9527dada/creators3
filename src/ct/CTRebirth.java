package ct;

import CtCoreSystem.CoreSystem.Wave;
import arc.struct.ObjectSet;
import ct.content.*;
import mindustry.Vars;
import mindustry.mod.Mod;
import mindustry.type.Planet;
import mindustry.type.UnitType;
import mindustry.world.Block;

import java.util.Objects;

import static CtCoreSystem.CoreSystem.compareVersions.compareVersions;
import static mindustry.Vars.content;

public class CTRebirth extends Mod {
    static String MinVersion = "1.23";

    public CTRebirth() {
    }

    public static void CT3setPlanet(Planet planet, String[] names) {
        planet.ruleSetter = r -> {
            // planet.hiddenItems.addAll(Items.serpuloItems);
            var B = new ObjectSet<Block>();
            for (var b : content.blocks()) {
                if (b.minfo.mod == null) {
                    B.add(b);
                    continue;
                }
                boolean yes = true;
                for (var name : names) {
                    if (Objects.equals(b.minfo.mod.meta.name, name) || Objects.equals(b.minfo.mod.name, name)) {
                        yes = false;
                        break;
                    }
                }
                if (yes) {
                    B.add(b);
                }
            }
            r.bannedBlocks.addAll(B);
            var U = new ObjectSet<UnitType>();
            for (var u : content.units()) {
                if (u.minfo.mod == null) {
                    U.add(u);
                    continue;
                }
                boolean yes = true;
                for (var name : names) {
                    if (Objects.equals(u.minfo.mod.meta.name, name) || Objects.equals(u.minfo.mod.name, name)) {
                        yes = false;
                        break;
                    }
                }
                if (yes) {
                    U.add(u);
                }
            }
            r.bannedUnits.addAll(U);
            r.showSpawns = true;//显示单位刷出点
        };
    }

    public void loadContent() {
        if ((Vars.mods.locateMod("ctcoresystem") != null)) {
            if (compareVersions(Vars.mods.getMod("ctcoresystem").meta.version, MinVersion) >= 0) {
                RebirthItem.load();
                RebirthBuffs.load();
                //CT3Item4.load();
                // 资源5.load();
                Item0.load();
                CTAttributes.load();
                RebirthFloors.load();
                CTR4Unit2.load();//敌对单位。改为通用单位，不限制在章节4了
                //  Rebirthchapter.load();//主要内容

            }

            if (Vars.mods.locateMod("creators") == null) {
                Rebirthchapter.load();
                Blocks_z.load();
            }
        }

        //chapter4.load();
        // chapter5.load();


        // SourceCodeModification_Sandbox.load();



          /*      Vars.mods.locateMod("ct")
                .meta.version += "-" + "[violet]创世神3[] 版本：[yellow]"
                + Vars.mods.getMod("ct").meta.version + "[]";

         Team.sharded.color.set(0.0F, 153.0F, 255.0F, 64.0F);//黄队伍颜色
        Team.crux.color.set(79.0F, 181.0F, 103.0F, 255.0F);//红队伍颜色

           */

    }

    public void init() {
        if (Vars.mods.locateMod("ctcoresystem") == null) {
            RebirthInfoDialog.show();
        } else {
            //跳波惩罚
            new Wave();
            if (compareVersions(Vars.mods.getMod("ctcoresystem").meta.version, MinVersion) < 0) {
                RebirthInfoDialog2.show();
            }
        }

    }


}
//Vars.state.rules.unitAmmo = true;开启单位消耗子弹
//Vars.ui.editor.save();保存地图 控制台