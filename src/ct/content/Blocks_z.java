package ct.content;

import ct.Asystem.type.BlockLimit.GenericCrafterLimit;
import ct.Asystem.type.LinksSt0rageBlock;
import ct.Asystem.type.TDTyep.UnitPortal;
import ct.Asystem.type.心灵控制术法;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.meta.BuildVisibility;

import static ct.content.ItemX.物品;
import static mindustry.type.ItemStack.with;

//本类用于测试相关的Type
public class Blocks_z {
    public static Block 测试工厂1;

    /*****************************/


    public static void load() {
        new UnitPortal("单位传送门A") {{
            TransferSpeed = 180;

            TransferAll = true;
            TransferType = false;

            size = 4;
            requirements(Category.defense, ItemStack.with(Items.copper, 1));

            hasPower = true;
            buildVisibility = BuildVisibility.sandboxOnly;
            consumePower(10);
        }};

        new UnitPortal("单位传送门B") {{
            TransferSpeed = 180;

            TransferAll = false;
            TransferType = true;

            size = 4;
            requirements(Category.defense, ItemStack.with(Items.copper, 1));
            buildVisibility = BuildVisibility.sandboxOnly;
            hasPower = true;
            consumePower(10);
        }};


        new GenericCrafterLimit.工厂前置限制("测试工厂1") {{
            requirements(Category.crafting, with(物品, 1));
            itemCapacity = 15;
            hasPower = true;
            craftTime = 300f;
            size = 2;
            数量 = 3;
            前置方块 = Blocks.arc;
            consumeItems(with(Items.copper, 1
            ));
            outputItem = new ItemStack(Items.lead, 1);
            consumePower(2 / 60f);
            buildVisibility = BuildVisibility.sandboxOnly;
        }};

        new GenericCrafterLimit.工厂数量限制("测试工厂2") {{
            requirements(Category.crafting, with(物品, 1));
            itemCapacity = 15;
            hasPower = true;
            craftTime = 300f;
            size = 2;
            数量 = 5;
            consumeItems(with(Items.copper, 1
            ));
            outputItem = new ItemStack(Items.lead, 1);
            consumePower(2 / 60f);
            buildVisibility = BuildVisibility.sandboxOnly;
        }};
        new LinksSt0rageBlock("测试连锁仓库") {{
            requirements(Category.effect, with(物品, 1));
            itemCapacity = 100;
            size = 2;
            buildVisibility = BuildVisibility.sandboxOnly;
        }};
        new PowerTurret("心灵控制炮") {{
            requirements(Category.turret, with(物品, 1));
            size = 3;
            targetGround = targetAir = true;
            range = 90 * 8;
            //inaccuracy = 2;
            recoil = 2;//后座力动画
            reload = 200;//射速
            rotateSpeed = 10f;
            shootType = new 心灵控制术法(30, 30) {{
                chanceDeflect = 0.001f;
            }};
        }};
    }
}
