/** 
    太阳能那样根据光照来出产率，然后可以选择两种模式：
    1.发电(太阳能模式);
    2.生产物品。然后可以像加速仪那种可以选择输入物品来强化生产速度;
*/

const Integer = java.lang.Integer;

var generatorMode = {
    icon: null,
    text: "发电模式",
    
    powerProduction: 1,
    drawer: new DrawDefault(),
    
    load(block){
        this.icon = Blocks.solarPanel.uiIcon;
        this.drawer.load(block);
    },
    
    setStats(block){
        block.stats.add(Stat.basePowerGeneration, this.powerProduction * 60, StatUnit.powerSecond);
    },
    
    setBars(block){
        block.addBar("power", entity => 
        !entity.isMode(this) ? null : 
        new Bar(() =>
            Core.bundle.format("bar.poweroutput",
            Strings.fixed(entity.getPowerProduction() * 60 * entity.timeScale, 1)),
            () => Pal.powerBar,
            () => entity.getProductionEfficiency()));
    },
    
    updateMode(build){
        build.setProductionEfficiency(build.lightEfficiency());
    },
    
    updateDisenable(build){
        build.setProductionEfficiency(0);
    },
    
}

var crafterMode = {
    icon: null,
    text: "生产模式",
    
    powerProduction: 0,
    drawer: new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99"))),
    
    load(block){
        this.icon = Blocks.siliconSmelter.uiIcon;
        this.drawer.load(block);
    },
    
    setStats(block){
    },
    
    setBars(block){
    },
    
    updateMode(build){
        build.super$updateTile();
    },
    
    updateDisenable(build){
    },
}

const modes = Seq.with(generatorMode, crafterMode);
var environmentalCrafter = extend(GenericCrafter,"青羊子收集器" ,{//青羊子收集器
//var environmentalCrafter = (CTBlocks.qiangyangzi, {//青羊子收集器

    // 一些PowerGenerator和GenericCrafter的基础属性设置
    update: true,
    solid: true,
    hasPower: true,
    consumesPower: false,
    outputsPower: true,
    sync: true,
    baseExplosiveness: 5,
    drawArrow: false,
    
    // 来自GenericCrafter
    // 这里借用硅厂的数据(
    craftEffect: Fx.smeltsmoke,
    outputItem: new ItemStack(CTItem.青羊子, 1),
    craftTime: 1200,
    ambientSound: Sounds.smelter,
    ambientSoundVolume: 0.07,
    size: 4,
    hasLiquids: false,
    configurable: true,
    
    // 一些PowerGenerator和GenericCrafter的方法
    setStats(){
        this.super$setStats();
        
        modes.each(m => m.setStats(this));
        
        this.stats.add(Stat.boostEffect, "+100%");
    },
    
    setBars(){
        this.super$setBars();

        modes.each(m => m.setBars(this));
    },
    
    icons(){
        return this.drawer.finalIcons(this);
    },
    
    load(){
        this.super$load();
        
        modes.each(m => {
            m.load(this);
        });
    },
        
    drawPlanRegion(plan, list){
        this.drawer.drawPlan(this, plan, list);
    },
});

let block = environmentalCrafter;

block.flags.with(BlockFlag.generator);
block.flags.with(BlockFlag.factory);

block.setupRequirements(Category.crafting, BuildVisibility.shown, ItemStack.with(
    CTItem.翠灵晶, 60,
                    CTItem.混沌晶体, 35,
                    CTItem.夜灵核心, 10,
                    CTItem.魔能晶, 40,
                    CTItem.灵魂束缚容器, 20
));
//block.consumeItems(ItemStack.with(Items.coal, 1, Items.sand, 2));
block.consumeItems(ItemStack.with());
block.consumeItem(CTItem.夜灵珠).boost();
 //block.speedBoost = 30
 // block.       hasBoost = false;
block.config(Integer, (build, num) => {
    build.setModeIndex(num);
});

block.buildType = () => {
    let productionEfficiency = 0;
    
    //生产模式
    let modeIndex = 0;
    let mode = modes.get(modeIndex);
    
    return extend(GenericCrafter.GenericCrafterBuild, block, {
            
        updateTile(){
            mode.updateMode(this);
            
            modes.each(m => {
                if(!this.isMode(m)){
                    m.updateDisenable(this);
                }
            });
        },
        
        draw(){
            mode.drawer.draw(this);
        },
        
        buildConfiguration(table){
            table.background(Tex.pane);
            
            for(let i = 0; i < modes.size; i ++){
                let m = modes.get(i);
                let index = i;
                this.addButton(table, m.icon, m.text, () => this.configure(Integer(index)), () => modeIndex == index);
            }
        },
        
        // private static
        addButton(table, icon, text, listener, checked){
            table.button(cons(button => {
                button.image(icon).size(60);
                button.add(text).padLeft(3);
            }), Styles.clearTogglei, listener)
            .checked(checked).size(64 * 1.618, 64);
            
            table.row();
        },
        
        isMode(m){
            return mode == m;
        },
        
        getModeIndex(){
            return modeIndex;
        },
        
        setModeIndex(newModeIndex){
            modeIndex = Mathf.clamp(newModeIndex, 0, modes.size - 1);
            mode = modes.get(modeIndex);
        },
        
        setProductionEfficiency(p){
            productionEfficiency = p;
        },
        
        getProductionEfficiency(){
            return productionEfficiency;
        },
        
        efficiencyScale(){
            return this.lightEfficiency() * (1 + this.optionalEfficiency);
        },
        
        lightEfficiency(){
            let rules = Vars.state.rules;
            return this.enabled ? 
                Mathf.maxZero(Attribute.light.env() + 
                    (rules.lighting ? 1 - rules.ambientLight.a : 1)
                ) : 0;
        },
        
        ambientVolume(){
            return Mathf.clamp(productionEfficiency);
        },
        
        getPowerProduction(){
            return mode.powerProduction * productionEfficiency;
        },
        
        write(write){
            this.super$write(write);
            
            write.f(productionEfficiency);
            write.i(Mathf.clamp(modeIndex, 0, modes.size - 1));
        },
    
        read(read, revision){
            this.super$read(read, revision);
            
            productionEfficiency = read.f();
            modeIndex = read.i();
            
            this.setModeIndex(modeIndex);
        },
        
    });
}