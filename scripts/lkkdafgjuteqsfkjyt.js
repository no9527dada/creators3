let https222 = "http://sd674971336.ysepan.com"
let https333 = "https://github.com/no9527dada/CT-origin/releases/tag/NO9527"
let https111 = "https://jq.qq.com/?_wv=1027&k=rZ8D5XGE";
Events.on(EventType.ClientLoadEvent, cons(e => {
    var kaiping = new BaseDialog(Core.bundle.format("9527http00"));
    kaiping.cont.pane((() => {

        var table = new Table();
        table.add(Core.bundle.format("9527http000")).left().growX().wrap().width(620).maxWidth(620).pad(4).labelAlign(Align.left);
        table.row();


table.button(Core.bundle.format("9527http333"), run(() => {
    if (!Core.app.openURI(https333)) {
        Vars.ui.showErrorMessage("@linkfail");
        Core.app.setClipboardText(https222);
    }
})).size(510, 64).row();
table.button(Core.bundle.format("9527http222"), run(() => {
    if (!Core.app.openURI(https222)) {
        Vars.ui.showErrorMessage("@linkfail");
        Core.app.setClipboardText(https222);
    }
})).size(510, 64);
table.row();
table.button(Core.bundle.format("9527http111"), run(() => {
    if (!Core.app.openURI(https333)) {
        Vars.ui.showErrorMessage("@linkfail");
        Core.app.setClipboardText(https111);
    }
})).size(510, 64).row();
return table;
})()).grow().center().maxWidth(770);
kaiping.addCloseListener();//按esc关闭
kaiping.buttons.button("@close", run(() => {
    kaiping.hide();
})).size(100, 64);
kaiping.show();
}));
