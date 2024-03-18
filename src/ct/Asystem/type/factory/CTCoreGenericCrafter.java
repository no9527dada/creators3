package ct.Asystem.type.factory;

import mindustry.Vars;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.storage.CoreBlock;


public class CTCoreGenericCrafter extends GenericCrafter {
    public CTCoreGenericCrafter(String name) {
        super(name);
    }


    public class CTCoreGenericCrafterBuilding extends GenericCrafterBuild {
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
