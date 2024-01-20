package ct.Asystem.type;

import arc.graphics.Color;
import ct.Asystem.Evn2;
import mindustry.Vars;
import mindustry.type.UnitType;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.type.unit.ErekirUnitType;
import mindustry.type.unit.TankUnitType;
import mindustry.world.meta.Env;

import static ct.content.chapter1.Item1.*;

public class CT3UnitType {
    public static class CTRUnitType extends UnitType {
        public CTRUnitType(String name, String MDTName) {
            super(name);
            constructor = Vars.content.unit(MDTName).constructor;
            controller = Vars.content.unit(MDTName).controller;
        }

    }

    public static class CTRTankUnitType extends TankUnitType {
        public CTRTankUnitType(String name, String MDTName) {
            super(name);

            constructor = Vars.content.unit(MDTName).constructor;
            controller = Vars.content.unit(MDTName).controller;
        }
    }

    public static class CTRErekirUnitType extends ErekirUnitType {
        public CTRErekirUnitType(String name, String MDTName) {
            super(name);

            constructor = Vars.content.unit(MDTName).constructor;
            controller = Vars.content.unit(MDTName).controller;
        }
    }


    public static class CTR1UnitType extends UnitType {
        public CTR1UnitType(String name, String MDTName) {
            super(name);
            //envRequired = Evn2.标志1| Env.terrestrial;
            envEnabled = Evn2.标志1 | Env.terrestrial;
            ammoType = new ItemAmmoType(陶);
            constructor = Vars.content.unit(MDTName).constructor;
            controller = Vars.content.unit(MDTName).controller;
        }

    }

    public static class CTR1UnitTypeNpc extends UnitType {
        public CTR1UnitTypeNpc(String name, String MDTName) {
            super(name);
            envEnabled = Evn2.标志1 | Env.terrestrial;
            ammoType = new ItemAmmoType(陶);
            constructor = Vars.content.unit(MDTName).constructor;
            controller = Vars.content.unit(MDTName).controller;
            hittable = false;//被子弹击中
            killable = false;//被杀死
            targetable = false;//被敌人瞄准
            physics = false;//单位碰撞
            flying = true;
            speed = 2f;
            engineOffset = 3f;
            engineColor= Color.valueOf("3580fd");//蓝色尾焰
            alwaysUnlocked = true;
            logicControllable = true;//逻辑器控制单位
            rotateSpeed = 15f;//转向速度
            drag = 0.05f;//移动且停止后的向前惯性，越小惯性越小 0~1
            accel = 0.5f;//准备移动时的加速度惯性 0~1
            isEnemy = false;//是否可在波次中设置为敌人
            lowAltitude = true;//单位贴图是否在子弹的上面“false”或下面“true”
            playerControllable = false;//玩家操控//NPC单位非特殊情况不能被玩家附身
        }

    }

}
