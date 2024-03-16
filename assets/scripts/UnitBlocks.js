const unitCountBuild = require('CTunitCountBuild');
const {
    T1Unit,T2Unit,T3Unit,T4Unit,T5Unit,
    T1hai,T2hai,T3hai,T4hai,T5hai,
    T2FU,T3FU,T4FU,T5FU,
    kuangjiUnit,
} = CTRUnitBlocks;

/* const{
    运输1,运输2,运输3,
    海辅1,海辅2,海辅3,海辅4,海辅5,
    坦克1, 坦克2, 坦克3, 坦克4, 坦克5,
    蜘蛛1,蜘蛛2,蜘蛛3,蜘蛛4,蜘蛛5,
    空军1,空军2,空军3,空军4,空军5}=CTRUnit */
   T1Unit.buildType =  unitCountBuild.FactoryBuildProv(T1Unit,1);
   T2Unit.buildType =  unitCountBuild.FactoryBuildProv(T2Unit,1);
   T3Unit.buildType =  unitCountBuild.FactoryBuildProv(T3Unit,2);
   T4Unit.buildType =  unitCountBuild.FactoryBuildProv(T4Unit,2);
   T5Unit.buildType =  unitCountBuild.FactoryBuildProv(T5Unit,2);

   //海军
   T1hai.buildType =  unitCountBuild.FactoryBuildProv(T1hai,1);
   T2hai.buildType =  unitCountBuild.FactoryBuildProv(T2hai,1);
   T3hai.buildType =  unitCountBuild.FactoryBuildProv(T3hai,2);
   T4hai.buildType =  unitCountBuild.FactoryBuildProv(T4hai,2);
   T5hai.buildType =  unitCountBuild.FactoryBuildProv(T5hai,2);

   //盾兵
   T2FU.buildType =  unitCountBuild.FactoryBuildProv(T2FU,1);
   T3FU.buildType =  unitCountBuild.FactoryBuildProv(T3FU,1);
   T4FU.buildType =  unitCountBuild.FactoryBuildProv(T4FU,2);
   T5FU.buildType =  unitCountBuild.FactoryBuildProv(T5FU,2);

   kuangjiUnit.buildType =  unitCountBuild.FactoryBuildProv(kuangjiUnit,1);


