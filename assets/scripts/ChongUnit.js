//const {UnitEngine} = UnitType;

const lib = require("CT3library");

const exampleSnakeEnd = lib.segment("cheEnd", {//尾部
    hitSize: 10,
    offsetSegment: -2,
    health: 600
}, {});

const exampleSnakeBody = lib.segment("cheBody", {//身体
    hitSize: 10,
   // engineRotOffset: 90,
   // engineOffset: 10,
   // offsetSegment: -1,
    health: 600
}, {});

// exampleSnakeBody.setEnginesMirror(//身体的光圈特效
//     new UnitEngine(10, 0, 3, 0)
// );

const exampleSnake = lib.head("che", {//头部
    body: exampleSnakeBody,
    end: exampleSnakeEnd,
    lengthSnake: 10,
    hitSize: 10,
    speed: 1.5,
    health: 1000
}, {});
