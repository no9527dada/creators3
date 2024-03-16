package ct.Asystem.type.TDTyep;

import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.StatusEffect;
import mindustry.world.blocks.defense.turrets.PowerTurret;

//冰冻炸弹
public class BombTurret extends PowerTurret {
    public BombTurret(String name, float 范围, float 时间, StatusEffect 状态) {
        super(name);
        size = 3;
        armor = 500;
        destroyEffect = Fx.reactorExplosion;
        requirements(Category.defense, new ItemStack[]{});
        range = 范围;
        rotateSpeed = 0;//武器旋转速度
        shootCone = 360;//射击瞄准角度
        createRubble = false;//被破坏后的黑色残留
        //rebuildable = false;//不会自动重建，不会留下残影 星球规则里同：ghostBlocks= false
        shootType = new BasicBulletType(0, 1) {{
            lifetime = 0f;
            ammoMultiplier = 1;//装弹倍率
            splashDamageRadius = 范围;
            splashDamage = 0;
            status = 状态;
            statusDuration = 时间;
        }};
    }

    public class BombTurretBuild extends PowerTurretBuild {
        @Override
        protected void shoot(BulletType type) {
            super.shoot(type);
            damage(health * 100);
        }

        @Override
        public BulletType useAmmo() {
            return shootType;
        }

        @Override
        public boolean hasAmmo() {
            return true;
        }

        @Override
        public BulletType peekAmmo() {
            return shootType;
        }
    }
}

