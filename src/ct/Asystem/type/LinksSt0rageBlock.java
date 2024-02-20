package ct.Asystem.type;

import arc.struct.Seq;
import mindustry.gen.Building;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.modules.ItemModule;

//这是给9527用的
//连锁仓库
public class LinksSt0rageBlock extends StorageBlock {
    public LinksSt0rageBlock(String name) {
        super(name);
        update = true;
        sync = true;
        itemCapacity = 1000;
        coreMerge = false;
    }

    public class LinksSt0rageBuild extends StorageBuild {

        @Override
        public void updateTile() {
            Seq<Building> builds = new Seq<>();
            proximity.forEach(building -> {
                if (building.block == block) builds.add(building);
            });
            builds.add(this);
            if (builds.size == 1) {
                return;
            }
            ItemModule itemModule = new ItemModule();
            builds.forEach(building -> itemModule.add(building.items));

            itemModule.each(((item, i) -> {
                int average = i / builds.size;
                builds.forEach(building -> {
                    if (building != this && items.get(item) - building.items.get(item) > 1 && building.items.get(item) < average) {
                        int amount = Math.min((items.get(item) - building.items.get(item)) / 2, average - building.items.get(item));
                        items.remove(item, amount);
                        building.handleStack(item, amount, this);
                    }
                });

            }));
        }
    }
}
