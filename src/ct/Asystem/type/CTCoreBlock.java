package ct.Asystem.type;

import mindustry.game.Team;
import mindustry.world.Tile;
import mindustry.world.blocks.storage.CoreBlock;

import static mindustry.Vars.state;
//改核心的覆盖方式
public class CTCoreBlock  extends CoreBlock {
    public CTCoreBlock(String name) {
        super(name);
    }
    public boolean canPlaceOn(Tile tile, Team team, int rotation){
        if(tile == null) return false;
        //in the editor, you can place them anywhere for convenience
        if(state.isEditor()) return true;

        CoreBuild core = team.core();

        //special floor upon which cores can be placed
        tile.getLinkedTilesAs(this, tempTiles);
        if(!tempTiles.contains(o -> !o.floor().allowCorePlacement || o.block() instanceof CoreBlock)){
            return true;
        }

        //must have all requirements
        if(core == null || (!state.rules.infiniteResources && !core.items.has(requirements, state.rules.buildCostMultiplier))) return false;

        return tile.block() instanceof CoreBlock && size >= tile.block().size;//更改原版的限制 现在等于或大于都可以覆盖
    }
}
