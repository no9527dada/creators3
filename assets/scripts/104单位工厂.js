// 假设这是你的单位
const XX = require('unitCountBuild');
var { mono, flare } = UnitTypes;
mono.useUnitCap = false; // 你的单位不需要限制
flare.useUnitCap = false; // 你的单位不需要限制

const { UnitPlan } = UnitFactory;

// 假设这是你的单位工厂
var Blocksfactory = Blocks.airFactory;
Blocksfactory.plans = Seq.with(
    new UnitPlan(mono, 60 * 1, ItemStack.with(Items.silicon, 30, Items.lead, 15)),
    new UnitPlan(flare, 60 * 1, ItemStack.with(Items.silicon, 30))
);



 //移除单位条
 Events.on(ContentInitEvent, e => {
     Blocksfactory.removeBar("units");
 });
// 用 FactoryBuildProv 获取对象 给你的工厂的buildType赋值就行
Blocksfactory.buildType =  XX.FactoryBuildProv(Blocksfactory,4);


