package ct.Asystem.dialogs;

import arc.Core;
import arc.graphics.Color;
import arc.util.Align;
import mindustry.Vars;
import mindustry.mod.Mods;
import mindustry.ui.dialogs.BaseDialog;

public class CT3InfoDialog {
    public static BaseDialog ct3info;

    public static void show() {

        // String framer = Core.bundle.format("framer");
        Mods.LoadedMod mod = Vars.mods.getMod("ct");
        String version = mod.meta.version;
        String MODname = Core.bundle.format("planet.ct3.ModName");
        String QQ群2 = "https://jq.qq.com/?_wv=1027&k=oygqLbJ5";
        String TD网盘 = "https://pan.baidu.com/s/1WJ2ZrehLvl8m17bl6-RbGQ?pwd=bjt3";

        ct3info = new BaseDialog("[yellow]Creators[#7bebf2] " + version + "[] Adapt 146+" + "\n策划:9527，贴图:皴皲，处理器逻辑指导:咕咕点心\nQQ群:909130592") {{
            addCloseListener();//按esc关闭
            buttons.defaults().size(210, 64);
            buttons.button("@close", (this::hide)).size(100, 64);//关闭按钮
            buttons.button(Core.bundle.get("difficulty.game", "难度设置"), (() -> {//游戏难度设置
                new SettingDifficultyDialog().onDifficutyChange(e -> {
                }).show();
            })).size(150, 64);
            cont.pane((table -> {
                table.add(MODname).left().growX().wrap().width(620).maxWidth(620).pad(4).labelAlign(Align.left);
                table.row();

                table.image().color(Color.valueOf("69dcee")).fillX().height(3).pad(3);
                table.row();

                table.image(Core.atlas.find("ct-CT-logo", Core.atlas.find("clear"))).height(290).width(587).pad(3);
                table.row();

//                   table.add(TZ).left().growX().wrap().width(620).maxWidth(620).pad(4).labelAlign(Align.left);
//                   table.row();

                table.add(MODname + "[][#88ff6e] " + version + "[]" + " _更新内容:").left().growX().wrap().width(620).maxWidth(620).pad(4).labelAlign(Align.left);
                table.row();

                table.add(Core.bundle.format("ct3-update")).left().growX().wrap().width(620).maxWidth(620).pad(4).labelAlign(Align.left);
                table.row();

                table.add(Core.bundle.format("ct3-notice")).left().growX().wrap().width(620).maxWidth(620).pad(4).labelAlign(Align.left);
                table.row();
            })).grow().center().maxWidth(770).row();
            String CT3framer = Core.bundle.format("CT3framer");
            buttons.button(CT3framer, (() -> {
                new BaseDialog("[yellow]Creators[#7bebf2] " + version + "\n" + CT3framer + "\nQQ群:909130592") {{
                    addCloseListener();//按esc关闭
                    buttons.defaults().size(210, 64);
                    buttons.button("@close", (this::hide)).size(100, 64);//关闭按钮
                    cont.pane((table -> {
                        table.add(Core.bundle.format("CT3framer_txt")).left().growX().wrap().width(620).maxWidth(620).pad(4).labelAlign(Align.left);
                        table.row();
                    }));
                }}.show();
            })).size(150, 64);
            String CT3TD按钮 = Core.bundle.format("CT3TD按钮");
            buttons.button(CT3TD按钮, (() -> {
                new BaseDialog("[yellow]Creators[#7bebf2] " + version + "\n" + CT3framer + "\nQQ群:909130592") {{
                    addCloseListener();//按esc关闭
                    buttons.defaults().size(210, 64);
                    buttons.button("@close", (this::hide)).size(100, 64);//关闭按钮
                    cont.pane((table -> {
                        table.add(Core.bundle.format("CT3TD说明")).left().growX().wrap().width(620).maxWidth(620).pad(4).labelAlign(Align.left).row();
                        table.image().color(Color.valueOf("69dcee")).fillX().height(3).pad(3).row();
                        table.button(Core.bundle.format("QQ群2"), (() -> {
                            if (!Core.app.openURI(QQ群2)) {
                                Vars.ui.showErrorMessage("@linkfail");
                                Core.app.setClipboardText(QQ群2);
                            }
                        })).size(510, 64).row();
                        table.button(Core.bundle.format("TD网盘"), (() -> {
                            if (!Core.app.openURI(TD网盘)) {
                                Vars.ui.showErrorMessage("@linkfail");
                                Core.app.setClipboardText(TD网盘);
                            }
                        })).size(510, 64).row();

                    }));
                }}.show();
            })).size(150, 64);
        }};
        ct3info.show();
    }
}
