package ct.type;

import arc.struct.EnumSet;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.meta.BlockFlag;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.Env;

public class CTRStorageBlock extends StorageBlock {

    public CTRStorageBlock(String name) {
        super(name);
        hasItems = true;
        solid = true;
        update = false;
        destructible = true;
        separateItemCapacity = true;
        group = BlockGroup.transportation;
        flags = EnumSet.of(BlockFlag.storage);
        allowResupply = true;
        envEnabled = Env.any;
    }
//连续贴在一起的仓库会共享容量与资源，视为一个整体






















}
