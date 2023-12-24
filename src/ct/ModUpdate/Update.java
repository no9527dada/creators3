package ct.ModUpdate;
import arc.Core;
import arc.graphics.Color;
import arc.math.Mathf;
import arc.scene.ui.Dialog;
import arc.struct.ObjectMap;
import arc.util.Http;
import arc.util.Log;
import arc.util.Scaling;
import arc.util.Time;
import arc.util.serialization.Jval;
import mindustry.Vars;
import mindustry.gen.Tex;
import mindustry.graphics.Pal;
import mindustry.mod.Mods;
import mindustry.ui.Fonts;
import mindustry.ui.Styles;
import mindustry.ui.dialogs.BaseDialog;
import java.util.Objects;

import static ct.ModUpdate.ImportMod.githubImportMod;
import static mindustry.Vars.mobile;
import static mindustry.Vars.ui;


//神魂的代码

public class Update {
    public static String ModTime = "22-8-19-00:00";
    public static String XVXModName = "ct";
    public static Mods.LoadedMod BreakingDawn;

    public static String DawnGHAPI = "XVXShenHun/BreakingDawnMod";
    public static String DawnText = "B21";//预告版
    public static String BEText = "A95";//测试版

    public static String DawnName(String name){
        return XVXModName + "-" + name;
    }
    public static float UI窗口按钮大小 = !mobile ? 500 : 300;
    public static float 文字窗口大小 = !mobile ? 700 : 500;
    public String ModName;
    public String ModGHID;
    public String BuildVersion;
    public boolean yes = true;
    public static Dialog.DialogStyle DawnDialog = new Dialog.DialogStyle() {{
       // stageBackground = whiteui.tint(0.0F, 0.0F, 0.0F, 0F);
        titleFont = Fonts.def;
        background = Tex.windowEmpty;
        titleFontColor = Pal.accent;
    }};
    public Update(){}

    public Update(String ModName, String ModGHID, String BuildVersion){
        this.ModName = ModName;
        this.ModGHID = ModGHID;
        this.BuildVersion = BuildVersion;
    }

    protected float[] T = {0.0f};
    protected boolean TA = true;

    public void loadAnd(String text, float time, Runnable call) {
        loadAnd(text, time, call, false);
    }

    public void loadAnd(String text, float time, Runnable call, boolean bool) {
        this.bool = bool;

        ui.loadfrag.show(text);

        ui.loadfrag.setProgress(()-> Math.min((T[0] / time), 1f));

        for(var i = 0; i < time - 1f; i++) {
            Time.runTask(i, () -> {
                if (T[0] < time) {
                    T[0] += Mathf.random(1f, 10f);
                } else {
                    if(TA) {
                        call.run();
                        Vars.ui.loadfrag.hide();
                        TA = false;
                    }
                }
            });
        }
    }

    public boolean bool = false;

    public BaseDialog CensorUpdate(String name){
        return null;
    }

    public BaseDialog Update(String tag, String time, String body){
        return null;
    }

    BaseDialog dialogcu;
    public void CensorUpdate(boolean bool){
        T[0] = 0f;
        TA = true;
        loadAnd(Core.bundle.format("breakingdawnmod-LoadDawn"), bool ? 10f : Mathf.random(60f, 600f), () -> Core.app.post(this::Update), bool);
    }

    public void CensorUpdate(){
        CensorUpdate(false);
    }

    public void CensorUpdateB(){
        if (yes) {
            dialogcu = CensorDawn();
        } else {
            dialogcu = CensorUpdate(ModName);
        }
        dialogcu.show();
    }

    public BaseDialog dialog;
    public void Update() {
        //loadAnd(Core.bundle.format("breakingdawnmod-LoadDawn"), 60f, () -> Core.app.post(() -> {
        Http.get(Vars.ghApi + "/repos/" + ModGHID + "/releases/latest", res -> {
            Jval json = Jval.read(res.getResultAsString());

            String tag = json.get("tag_name").asString();
            String time = json.get("published_at").asString();
            String body = json.get("body").asString();

            if (tag != null && time != null && !tag.equals(Core.settings.getString(ModName + "-最新发布")) && !tag.equals(破晓版本(BuildVersion, ModName))) {
                if (yes) {
                    dialog = DawnUpdate(tag, time, body);
                } else {
                    dialog = Update(tag, time, body);
                }

                if(!bool) {
                    dialog.show();
                }
            } else {
                if (tag != Core.settings.getString(ModName + "-最新发布")) {
                    CensorUpdateB();
                } else {
                    ui.showInfoOnHidden(Core.bundle.format(DawnName("ModUpdateC")), () -> {
                        Core.settings.put(ModName + "-最新发布", "-2");
                    });
                }
            }
        }, ex -> {
            ui.showInfoOnHidden(Core.bundle.format(DawnName("ModUpdateC")), () -> {
                Core.settings.put(ModName + "-最新发布", "-2");
            });
            Log.err(ex.toString());
        });
        //}));
    }

    public BaseDialog CensorDawn(){
        return new BaseDialog(Core.bundle.format(DawnName("ModUpdateB"))){{
            setStyle(Styles.fullDialog);
            cont.pane(t -> {
                t.add(Core.bundle.format(DawnName("ModUpdateB"))).padRight(10).padTop(0);
                t.row();
                t.image().color(Color.valueOf("9370DB")).fillX().height(3).pad(3);
                t.row();

                t.add(Core.bundle.format(DawnName("OldUpdate"))).scaling(Scaling.fit).color(Color.gray);
                t.row();
                t.add(破晓版本A(BuildVersion, ModName)).scaling(Scaling.fit);
                t.row();

              /*  var S = Core.bundle.format(ModName + "-ModTime");
                S = DawnModsDialog.检测(S, ModName + "-ModTime");
                t.add(Objects.equals(ModName, XVXModName) ? ModTime : S).scaling(Scaling.fit);
*/
                t.row();
                t.image().color(Color.valueOf("9370DB")).fillX().height(3).pad(3);
                t.row();
                t.button("@close", this::hide).size(UI窗口按钮大小 / 2, 50).scaling(Scaling.fit);
            });
            cont.row();
        }};
    }

    public BaseDialog DawnUpdate(String tag, String time, String body){
        BaseDialog log = new BaseDialog(Core.bundle.format(DawnName("ModUpdate"), Vars.mods.locateMod(ModName).meta.displayName()));
        log.addCloseListener();

        if (Core.scene.hasDialog()) {
            log.setStyle(Styles.fullDialog);
        } else {
            log.titleTable.remove();
            log.setStyle(DawnDialog);
        }

        log.cont.pane(t -> {
            t.add(new Image() {{
                var B = new DawnIcon(ModName);
                update(() -> setDrawable(B.Icon()));
                border(Pal.accent);
            }}).scaling(Scaling.fit).size(UI窗口按钮大小 / 2);
            t.row();

            t.image().color(Color.valueOf("9370DB")).fillX().height(3).pad(3);
            t.row();

            t.add(Core.bundle.format(DawnName("NewUpdate"))).padRight(10).padTop(0);
            t.row();
            t.add(tag).scaling(Scaling.fit);
            t.row();
            t.add(time).scaling(Scaling.fit);
            t.row();

            t.image().color(Color.valueOf("9370DB")).fillX().height(3).pad(3);
            t.row();

            t.add(Core.bundle.format(DawnName("OldUpdate"))).padRight(10).padTop(0);
            t.row();
            t.add(破晓版本A(BuildVersion, ModName)).scaling(Scaling.fit);
            t.row();

/*
            var S = Core.bundle.format(ModName + "-ModTime");
            S = DawnModsDialog.检测(S, ModName + "-ModTime");
            t.add(Objects.equals(ModName, XVXModName) ? ModTime : S).scaling(Scaling.fit);
*/

            t.row();
            t.image().color(Color.valueOf("9370DB")).fillX().height(3).pad(3);
            t.row();
            t.add(body).scaling(Scaling.fit);
            t.row();
            t.image().color(Color.valueOf("9370DB")).fillX().height(3).pad(3);
            t.row();
            t.button(Core.bundle.format("breakingdawnmod-ModUpdateD", tag), ()->{
                githubImportMod(ModGHID, Vars.mods.locateMod(ModName).isJava());
            }).size(UI窗口按钮大小 / 2, 50).scaling(Scaling.fit);

            if(Objects.equals(ModName, XVXModName)) {
                t.row();
                t.button(Core.bundle.format("breakingdawnmod-ModUpdateE", tag), () -> {
                    String sp = "https://gh.tinylake.tk/";
                    String http = "https://github.com/XVXShenHun/BreakingDawnMod/releases/download/" + tag + "/BreakingDawnMod.jar";

                    if (!Core.app.openURI(sp + http)) {
                        ui.showErrorMessage("@linkfail");
                        Core.app.setClipboardText(sp + http);
                    }
                }).size(UI窗口按钮大小 / 2, 50).scaling(Scaling.fit);
            }
        });
        log.cont.row();
        log.cont.pane(t -> {
            t.button(Core.bundle.format(DawnName("ModUpdateA")), () -> {
                Core.settings.put(ModName + "-最新发布", tag);
                log.hide();
            }).size(UI窗口按钮大小 / 2, 50);
            t.row();
            t.button("@close", log::hide).size(UI窗口按钮大小 / 2, 50);
        }).scaling(Scaling.fit);
        log.addCloseListener();

        return log;
    }

    public static String 破晓版本(String BuildVersion, String ModName){
        if(!Objects.equals(ModName, XVXModName)){
            return BuildVersion;
        }

        if(Objects.equals(BuildVersion, "0")){
            return DawnText;
        }
        if(Objects.equals(BuildVersion, "-1")){
            return BEText;
        }
        return BuildVersion;
    }

    public static String 破晓版本A(String BuildVersion, String ModName){
        if(!Objects.equals(ModName, XVXModName)){
            return BuildVersion;
        }

        if(Objects.equals(BuildVersion, "0")){
            return "[red]" + DawnText + "[]";
        }

        if(Objects.equals(BuildVersion, "-1")){
            return "[yellow]" + BEText + "[]";
        }
        return BuildVersion;
    }


    public static ObjectMap<String, String> ModNameUpdate = new ObjectMap<>();
    public static void SetUpdate(String mod, String id){
        ModNameUpdate.put(mod, id);
    }
}


