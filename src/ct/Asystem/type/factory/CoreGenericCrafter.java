package ct.Asystem.type.factory;

import mindustry.Vars;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.storage.CoreBlock;

/*
 *@Author:LYBF
 *@Date  :2024/3/8
 *@Desc  :
 * 核心工厂 直接产出物品至核心
 * 直接输出Items至核心,拒绝中间商赚差价
 */
public class CoreGenericCrafter extends GenericCrafter {
    public CoreGenericCrafter(String name) {
        super(name);
    }


    public class CoreGenericCrafterBuilding extends GenericCrafterBuild {
        /*
         *dump items to core;
         */
        @Override
        public boolean dump(Item todump) {
            CoreBlock.CoreBuild build = Vars.state.teams.get(team()).core();
            if (build.acceptItem(tile.build, todump)) {
                build.handleItem(tile.build, todump);
                tile.build.removeStack(todump, 1);
            }
            return true;
        }

        @Override
        public void offload(Item item) {
            CoreBlock.CoreBuild build = Vars.state.teams.get(team()).core();
            if (build.acceptItem(tile.build, item)) {
                build.handleItem(tile.build, item);
                tile.build.removeStack(item, 1);
            }
            super.offload(item);
        }
    }
}
