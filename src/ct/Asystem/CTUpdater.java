package ct.Asystem;

import arc.Core;
import arc.input.KeyCode;
import arc.scene.ui.Label;
import arc.util.Http;
import arc.util.Reflect;
import arc.util.serialization.Jval;
import mindustry.Vars;
import mindustry.mod.Mods.LoadedMod;
import mindustry.ui.dialogs.BaseDialog;
import mindustry.ui.dialogs.ModsDialog;

import java.util.Objects;

import static mindustry.Vars.*;

//更新检测
public class CTUpdater {
    public static void showCustomConfirm(String title, String text, String yes, String no, String 网盘, Runnable confirmed, Runnable denied) {
        var https222 = "https://pan.baidu.com/s/1_JQjeMJ9aWcHnZY-YX6FJQ?pwd=1314";
        BaseDialog dialog = new BaseDialog(title);
        ((Label) dialog.cont.add(text).width(Vars.mobile ? 400.0F : 500.0F).wrap().pad(4.0F).get()).setAlignment(1, 1);
        dialog.buttons.defaults().size(140.0F, 54.0F).pad(2.0F);
        dialog.setFillParent(false);
        dialog.buttons.button(no, () -> {
            dialog.hide();
            denied.run();
        });
        dialog.buttons.button(yes, () -> {
            dialog.hide();
            confirmed.run();
        });
        dialog.buttons.button(网盘, () -> {
            // dialog.hide();

            if (!Core.app.openURI(https222)) {
                Vars.ui.showErrorMessage("@linkfail");
                Core.app.setClipboardText(https222);
            }

        });
        KeyCode var10001 = KeyCode.escape;
        Objects.requireNonNull(dialog);
        dialog.keyDown(var10001, dialog::hide);
        var10001 = KeyCode.back;
        Objects.requireNonNull(dialog);
        dialog.keyDown(var10001, dialog::hide);
        dialog.show();
    }

    private static LoadedMod mod;
    private static String repo;

    public static void checkUpdate() {
        mod = mods.locateMod("ct");
        repo = mod.getRepo();

        Http.get(ghApi + "/repos/" + repo + "/releases/latest", res -> {
            var json = Jval.read(res.getResultAsString());
            String version = json.getString("tag_name")/*.substring(1)*/;

            if (version.equals(mod.meta.version)) return;

            showCustomConfirm(Core.bundle.get("creators-tools.updater.name"),
                    Core.bundle.format("creators-tools.updater.info", mod.meta.version, version),
                    Core.bundle.get("creators-tools.updater.load"), "@close", "@wangpan", () -> {
                        Reflect.invoke(ModsDialog.class, ui.mods, "githubImportJavaMod", new Object[]{repo, null}, String.class, String.class);
                    }, () -> {
                    });
        }, e -> {
        });
    }

}
