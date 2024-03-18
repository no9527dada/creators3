package ct;

import arc.Core;
import arc.Events;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.scene.ui.ImageButton;
import arc.struct.ObjectMap;
import arc.struct.ObjectSet;
import arc.struct.Seq;
import arc.util.Time;
import arc.util.Timer;
import ct.Asystem.CTUpdater;
import ct.Asystem.Wave;
import ct.Asystem.dialogs.CT3InfoDialog;
import ct.Asystem.dialogs.CT3PlanetDialog;
import ct.Asystem.type.CTResearchDialog;
import ct.Asystem.type.UnitDeathReward;
import ct.content.*;
import ct.content.Effect.NewFx;
import ct.content.chapter1.Item1;
import ct.content.chapter1.chapter1;
import ct.content.chapter2.chapter2;
import ct.content.chapter3.chapter3;
import ct.content.chapter4.Turrets;
import ct.content.chapter4.chapter4;
import ct.ui.CT3ClassificationUi;
import mindustry.Vars;
import mindustry.content.Items;
import mindustry.content.UnitTypes;
import mindustry.game.EventType;
import mindustry.graphics.Layer;
import mindustry.mod.Mod;
import mindustry.mod.Scripts;
import mindustry.type.ItemStack;
import mindustry.type.Planet;
import mindustry.type.UnitType;
import mindustry.ui.dialogs.BaseDialog;
import mindustry.ui.dialogs.PlanetDialog;
import mindustry.ui.dialogs.ResearchDialog;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.distribution.Sorter;
import mindustry.world.blocks.logic.LogicBlock;
import mindustry.world.blocks.sandbox.ItemSource;
import mindustry.world.blocks.sandbox.LiquidSource;
import rhino.Context;
import rhino.Scriptable;
import rhino.ScriptableObject;

import java.util.Objects;

import static arc.Core.camera;
import static mindustry.Vars.*;

public class CTRebirth extends Mod {

//

    public CTRebirth() {
//        Vars.mods.locateMod("creators3").meta.version += "----" +  "[violet]创世神3-仙明决[]";
        //缩放
        Vars.renderer.minZoom = 0.5F;
        Vars.renderer.maxZoom = 32;
//蓝图大小
        Vars.maxSchematicSize = 128;
        //地图禁用建筑隐藏
        Events.on(EventType.WorldLoadEvent.class, event -> {
                    Vars.state.rules.hideBannedBlocks = true;
                }
        );
        //

    }

    public void loadContent() {

/*        LogicBlock {
            @Override
            public boolean canBreak (Tile tile){
                return !privileged || state.rules.editor || state.playtestingMap != null;
            }
            {}}*/
        // Team.sharded.color.set(0.0F, 153.0F, 255.0F, 64.0F);//黄队伍颜色
        //Team.crux.color.set(79.0F, 181.0F, 103.0F, 255.0F);//红队伍颜色
        //难度修改

        Item1.load();
        //CT3Item4.load();
        // 资源5.load();
        Item0.load();


        CTAttributes.load();
        Floors.load();
        NewFx.load();
        CTR4Unit2.load();//敌对单位。改为通用单位，不限制在章节4了
        chapter1.load();
        chapter2.load();
        chapter3.load();
        //chapter4.load();
        // chapter5.load();

        ItemX.load();
        Blocks_z.load();
        SourceCodeModification_Sandbox.load();

        new CT3ClassificationUi();
        Scripts scripts = Vars.mods.getScripts();
        Scriptable scope = scripts.scope;
        try {
            Object obj = Context.javaToJS(new CT3ClassificationUi(), scope);
            ScriptableObject.putProperty(scope, "CT3ClassificationUi", obj);
        } catch (Exception var5) {
            Vars.ui.showException(var5);
        }

        CreatorsModJS.DawnMods();


    }


    public static boolean CTBlockBool = true;//原版蓝图系统解锁
    public static ObjectMap<Block, Block> CTBlock = new ObjectMap<>();

    public static void setPlanet(Planet planet, String[] names) {
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

    public final static Seq<Runnable> BlackListRun = new Seq<>();

    public Seq<String> BaiMingDan = new Seq<>();

    @Override
    public void init() {

        //区块名显示
        Vars.ui.planet = new CT3PlanetDialog();

        //跳波惩罚
        new Wave();

        //檢測更新
        // Events.on(EventType.ClientLoadEvent.class, e -> Timer.schedule(CTUpdater::checkUpdate, 4));

        //选择方块显示图标
        Events.on(EventType.ClientLoadEvent.class, e -> CT3选择方块显示图标());

        //开屏显示
        Events.on(EventType.ClientLoadEvent.class, e -> CT3InfoDialog.show());

       //科技树全显
        CTResearchDialog dialog = new CTResearchDialog();
        ResearchDialog research = Vars.ui.research;
        research.shown(() -> {
            dialog.show();
            Objects.requireNonNull(research);
            Time.runTask(1.0F, research::hide);
        });


    }


    //选择方块显示图标
    public void CT3选择方块显示图标() {
        Events.run(EventType.Trigger.draw, () -> {
            if (Vars.ui != null) {
                indexer.eachBlock(null, camera.position.x, camera.position.y, (30 * tilesize), b -> true, b -> {
                    if (b instanceof LiquidSource.LiquidSourceBuild) {
                        var source = (LiquidSource.LiquidSourceBuild) b;
                        if (source.config() != null) {
                            Draw.z(Layer.block + 1);
                            Draw.rect(source.config().fullIcon, b.x, b.y, 3, 3);
                        }
                    }
                    if (b instanceof ItemSource.ItemSourceBuild) {
                        var source = (ItemSource.ItemSourceBuild) b;
                        if (source.config() != null) {
                            Draw.z(Layer.block + 1);
                            Draw.rect(source.config().fullIcon, b.x, b.y, 3, 3);
                        }
                    }
                    if (b instanceof Sorter.SorterBuild) {
                        var sorter = (Sorter.SorterBuild) b;
                        if (sorter.config() != null) {
                            Draw.z(Layer.block + 1);
                            Draw.rect(sorter.config().fullIcon, b.x, b.y, 3, 3);
                        }
                    }
                });
            }
        });
    }


    public static ImageButton CreatorsIcon(String IconName, ImageButton.ImageButtonStyle imageButtonStyle, BaseDialog dialog) {
        TextureRegion A = Core.atlas.find("ct-" + IconName);

        ImageButton buttonA = new ImageButton(A, imageButtonStyle);
        buttonA.clicked(dialog::show);
        return buttonA;
    }


}
//Vars.state.rules.unitAmmo = true;开启单位消耗子弹
//Vars.ui.editor.save();保存地图 控制台