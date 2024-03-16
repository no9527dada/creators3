package ct.Asystem.type.TDTyep;

import mindustry.Vars;
import mindustry.content.Blocks;
import mindustry.game.Team;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.environment.Floor;

import static mindustry.Vars.state;

//己方的掉血墙
public class TDsuicideWall extends Wall {
    /**
     * 伤害百分比
     */
    public float damagePercent = 1f;
    /**
     * 固定数值伤害
     */
    public float damageAmount = 0f;
    /**
     * 伤害间隔
     */
    public float damageTime = 120f;

    public TDsuicideWall(String name) {
        super(name);
        update = true;
        health = 10000;
        armor = 500;
        placeableLiquid = true;
        floor = (Floor) Blocks.water;//需要的地板
    }

    public class TDsuicideWallBuild extends WallBuild {
        @Override
        public void updateTile() {
            if (timer().get(damageTime)) {
                damage(damageAmount);
                damage(damagePercent * maxHealth / 100);
            }
        }

    }

    /**
     * 通用地板限制
     */
    public Floor floor;//需要的地板

    @Override
    public boolean canPlaceOn(Tile tile, Team team, int rotation) {
        if (tile == null) return false;
        if (Vars.state.isEditor()) return true;

        tile.getLinkedTilesAs(this, tempTiles);
        return !tempTiles.contains(o -> o.floor() != floor);
    }

    public Block 升级前置 = this;

    public boolean canReplace(Block other) {
        if (other.alwaysReplace) return true;
        return 升级前置 == null ? super.canReplace(other) : 升级前置 == other;
    }

    /**
     * 不可拆
     *
     * @Override public boolean canBreak(Tile tile) {
     * return false;
     * }
     */

    //生存模式不可拆
    @Override
    public boolean canBreak(Tile tile) {
        return state.rules.editor || state.playtestingMap != null;
    }
}


