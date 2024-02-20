Events.on(EventType.ClientLoadEvent, cons(e => {
    const kaite = new ImageButton.ImageButtonStyle();
    kaite.down = Tex.buttonDown;
    kaite.up = Styles.black3;
    kaite.over = Tex.buttonOver;
    kaite.imageDisabledColor = Color.gray;
    kaite.imageUpColor = Color.white;
    kaite.disabled = Tex.buttonDisabled;
Vars.ui.hudGroup.fill(cons(table => {
    let shown = false;
    table.button(Icon.downSmall, Styles.defaulti, () => {
        shown = !shown;
    }).checked(b => shown).size(40).left().row();
    table.collapser(t => {
        t.top().left();

        let buttons = t.table().left().get();

        function addButton(icon, style, runnable, checked, tooltipName) {
            let cell = buttons.button(icon, style, 36, runnable).size(46).tooltip(Core.bundle.get(tooltipName));
            if (checked != null) {
                cell.checked(checked);
            }
        }

        addButton(Icon.home, kaite, () => {
            CT3InfoDialog.show();
        }, null, "9527shouye"); // 首页

        addButton(Icon.refresh, kaite, () => {
            Call.sendChatMessage("/sync")
        }, null, "refresh"); // 刷新

        addButton(Icon.eye, Styles.clearTogglei, () => {
            let c = Core.settings.get("effects", true);
            Core.settings.put("effects", !c);
        }, b => Core.settings.get("effects", true), "NOFF"); // 全局特效开关

        addButton(Icon.info, kaite, () => {
            let sector = Vars.state.getSector();
            if (sector != null && sector.save != null) {
                Reflect.invoke(Vars.ui.planet, "showStats", [Vars.state.getSector()], Sector);
            }
        }, null, "tongji"); //统计 

        t.row();
        //加速条
        t.table(Styles.black6, speedTable => {
            setupSpeedTable(speedTable);
        }).growX();


    }, false, () => shown).left();
    table.top().left().marginTop(110);

}));
Vars.ui.hudGroup.fill(cons(cundang => {//存档
    function exportData(fi) {
        Vars.ui.settings.exportData(fi)
    }
    cundang.button(Icon.upload, Styles.defaulti, run(() => {
        if (Vars.ios) {
            let file = Core.files.local("mindustry-data-export.zip");
            try {
                exportData(file);
            } catch (e) {
                Vars.showException(e)
            }
            Vars.platform.shareFile(file)
        } else {
            Vars.platform.showFileChooser(false, "zip", file => {
                try {
                    exportData(file);
                    Vars.showInfo("@data.exported");
                } catch (e) {
                    // e.printStackTrace()
                    // Vars.showException(e)
                }
            });
        }
    })).width(40).height(40).name("ores").tooltip("@data.export");
    cundang.top().left().marginTop(110).marginLeft(40);
}));
}));
function setupSpeedTable(table) {
    function getText(value) {
        let speed = Math.pow(2, Math.abs(value));

        let text = "";
        let color = null;

        if (value == 0) {
            text = "x";
        } else if (value > 0) {
            text = "{shake}[#F5F132]x";
        } else {
            text = "{wave}[#5DDC74]x";
        }

        return text + speed;
    }
    let slider = new Slider(-3, 2, 1, false);
    let label = new FLabel("");

    let effects = Reflect.get(label, "activeEffects");

    let colorSpeedUp = Color.valueOf("ffd59e");
    let colorSpeedDown = Color.valueOf("99ffff");

    slider.moved(value => {
        let speed = Math.pow(2, value);
        Time.setDeltaProvider(() => Math.min(Core.graphics.getDeltaTime() * 60 * speed, 3 * speed));

        label.restart(getText(value));
    });

    slider.setValue(0);

    table.add(label).width(52);

    table.button(Icon.refresh, Styles.clearNonei, 30, () => {
        slider.setValue(0);
    }).size(40).padLeft(6);

    table.add(slider).growX();
}