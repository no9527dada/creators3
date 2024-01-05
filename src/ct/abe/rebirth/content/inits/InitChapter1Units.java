package ct.abe.rebirth.content.inits;

import arc.Core;
import arc.graphics.Color;
import ct.ahapter.lib;
import mindustry.ai.types.BuilderAI;

import static ct.abe.rebirth.content.Units.*;
import static mindustry.content.UnitTypes.nova;
////InitChapter1Units.核心机0号.killable = true
public class InitChapter1Units {

    public static void load() {
        nova.playerControllable = false;
        核心机0号 = new lib.CTRUnitType("U0", "gamma") {{
            localizedName = Core.bundle.get("Unit.U0");
            description = Core.bundle.getOrNull("Unit.description.U0");
            aiController = BuilderAI::new;
            isEnemy = false;
            lowAltitude = true;
            flying = true;
            mineSpeed = 3f;
            mineTier = 1;
            buildSpeed = 0.5f;
            drag = 0.05f;
            speed = 0f;
            rotateSpeed = 15f;
            accel = 0.1f;
            itemCapacity = 30;
            health = 50f;
            engineOffset = 3f;
            hitSize = 8f;
            alwaysUnlocked = true;
            mineRange = 18 * 8f;//采矿范围
            hittable = false;//被子弹击中
            killable = false;//被杀死
            targetable = false;//被敌人瞄准
            physics = false;//单位碰撞
            lightColor = Color.valueOf("ffcd35");
            lightOpacity = 1;
        }};
        核心机1号 = new lib.CTRUnitType("U1", "elude") {{
            localizedName = Core.bundle.get("Unit.U1");
            description = Core.bundle.getOrNull("Unit.description.U1");
            health = 700;
            coreUnitDock = true;//true 解除附身后在其上方出现，而不是核心
            aiController = BuilderAI::new;
            flying = false;
            speed = 2.2f;
            mineSpeed = 3f;//采矿速度
            mineTier = 1;//采矿等级
            buildSpeed = 0.5f;//建造速度
            buildRange = 220.0F;//建造范围
            armor = 1f;
            hitSize = 11f;
            engineOffset = 7f;
            engineSize = 2f;
            hovering = true;//悬停
            itemCapacity = 200;
            useEngineElevation = false;
            mineWalls = false;//开采墙壁矿物
            mineFloor = true;//开采地表矿物
            lightRadius = 30 * 8;
            lightOpacity = 0.5f;

        }};
        核心机2号 = new lib.CTRUnitType("U2", "toxopid") {{
            localizedName = Core.bundle.get("Unit.U2");
            description = Core.bundle.getOrNull("Unit.description.U2");
            health = 1000;
            coreUnitDock = true;//true 解除附身后在其上方出现，而不是核心
            aiController = BuilderAI::new;

            flying = false;
            hovering = true;//悬停
            legCount = 0;//设定蜘蛛类，脚设定0个。实现可以踩方块不能过地图墙
            speed = 2.5f;
            mineSpeed = 4f;//采矿速度
            mineTier = 1;//采矿等级
            buildSpeed = 1f;//建造速度
            buildRange = 220.0F;//建造范围
            armor = 3f;
            hitSize = 11f;
            engineOffset = 7f;
            engineSize = 2f;
            itemCapacity = 240;
            useEngineElevation = false;
            mineWalls = false;//开采墙壁矿物
            mineFloor = true;//开采地表矿物
            lightRadius = 30 * 8;
            lightOpacity = 0.5f;

        }};
    }
}
