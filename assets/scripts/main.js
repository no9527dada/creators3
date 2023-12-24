
//Java核心系统
function CreatorsPackage(name) {
	var p = Packages.rhino.NativeJavaPackage(name, Vars.mods.mainLoader());
	Packages.rhino.ScriptRuntime.setObjectProtoAndParent(p, Vars.mods.scripts.scope)
	return p
}
var CreatorsJavaPack = CreatorsPackage('ct')
importPackage(CreatorsJavaPack)
importPackage(CreatorsJavaPack.ahapter)
importPackage(CreatorsJavaPack.chapter1)
importPackage(CreatorsJavaPack.draw)
importPackage(CreatorsJavaPack.type)



CreatorsModJS.RunName.add("ct")
CreatorsModJS.DawnRun.add(run(() => {
	require('变速');
//  require('UnitBlocks');
// require('环保生产厂');
// require('zuantou');
//  require('104单位工厂');
// require('测试');

}));





