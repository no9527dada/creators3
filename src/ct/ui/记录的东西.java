package ct.ui;

public class 记录的东西 {
/*
* 获取指定位置的某方块后触发下一条指令
getblock block jj 0 0
jump 3 equal jj @方块名
end
setflag "w80" true
stop
*
* -----------------
*
* shootCone = 360;//射击瞄准角度
*fragRandomSpread = 60;//破片散布角度
* healAmount=25 固定数量的块治疗
* inaccuracy=精准
*
*---------------------
*给核心添加资源
jump 2 equal @waveNumber 51
end
fetch core c @sharded 0 @conveyor
sensor H c @cttd-魂
op add H line 1000
setprop @cttd-魂 c H
print H
message announce 3
stop

*
*
*
*
*
* 随波次增加而增加怪的盾量
jump 3 notEqual ST false
set ST 1
set W @waveNumber
jump 5 equal W @waveNumber
end
op add W @waveNumber 1
getlink q 0
op mul AAA W 0.65
op mul B AAA 10
op floor C B 100
op div D C 10
control config q D 0 0 0
print "下一波敌人生命+"
print D
message toast 3


*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
* */
}
