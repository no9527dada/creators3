Events.on(EventType.ClientLoadEvent, cons(e => {

Vars.ui.hudGroup.fill(cons(table => {
	let shown = false;
	table.button(Icon.downSmall, Styles.defaulti, () => {
		shown = !shown;
	}).checked(b => shown).size(40).left().row();
	table.collapser(t => {
		t.top().left();
	
		//加速条
		t.table(Styles.black6, speedTable => {
			setupSpeedTable(speedTable);
		}).growX();


	}, false, () => shown).left();
	table.top().left().marginTop(110);
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