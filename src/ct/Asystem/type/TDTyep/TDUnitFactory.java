package ct.Asystem.type.TDTyep;

import arc.Core;
import mindustry.Vars;
import mindustry.game.Team;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.units.UnitFactory;

public class TDUnitFactory extends UnitFactory {
    public TDUnitFactory(String name) {
        super(name);
        armor = 500;
    }

    public Block 升级前置 = null;

    public boolean canReplace(Block other) {
        if (other.alwaysReplace) return true;
        return 升级前置 == null ? super.canReplace(other) : 升级前置 == other;
    }

    @Override
    public boolean canPlaceOn(Tile tile, Team team, int rotation) {
        if (tile == null) return false;
        if (Vars.state.isEditor() || 升级前置 == null) return true;

        tile.getLinkedTilesAs(this, tempTiles);
        return tempTiles.contains(o -> o.block() == 升级前置);
    }

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid) {
        if (!valid && 升级前置 != null)
            drawPlaceText(Core.bundle.format("cttd.UpgradeFront") + 升级前置.localizedName, x, y, false);

        super.drawPlace(x, y, rotation, valid);
    }
}
