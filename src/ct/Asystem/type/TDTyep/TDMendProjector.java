package ct.Asystem.type.TDTyep;

import arc.math.Mathf;
import mindustry.Vars;
import mindustry.content.Blocks;
import mindustry.content.Fx;
import mindustry.game.Team;
import mindustry.world.Tile;
import mindustry.world.blocks.defense.MendProjector;
import mindustry.world.blocks.environment.Floor;

import static mindustry.Vars.indexer;

/**
 * 非百分比的数值修复器
 */
public class TDMendProjector extends MendProjector {
    public float healAmount = 40f;//修复的数值

    public TDMendProjector(String name) {
        super(name);
        healPercent = 0;//这个接口无用，不要动他
        phaseBoost = 40;//是加入（相织布）提升的数值
        reload = 5 * 60;//5秒1次加血
        floor = (Floor) Blocks.slag;//需要的地板
    }

    public Floor floor;//需要的地板

    @Override
    public boolean canPlaceOn(Tile tile, Team team, int rotation) {
        if (tile == null) return false;
        if (Vars.state.isEditor()) return true;

        tile.getLinkedTilesAs(this, tempTiles);
        return !tempTiles.contains(o -> o.floor() != floor);
    }

    public class TDMendBuild extends MendBuild {
        @Override
        public void updateTile() {
            boolean canHeal = !checkSuppression();

            smoothEfficiency = Mathf.lerpDelta(smoothEfficiency, efficiency, 0.08f);
            heat = Mathf.lerpDelta(heat, efficiency > 0 && canHeal ? 1f : 0f, 0.08f);
            charge += heat * delta();

            phaseHeat = Mathf.lerpDelta(phaseHeat, optionalEfficiency, 0.1f);

            if (optionalEfficiency > 0 && timer(timerUse, useTime) && canHeal) {
                consume();
            }

            if (charge >= reload && canHeal) {
                float realRange = range + phaseHeat * phaseRangeBoost;
                charge = 0f;

                indexer.eachBlock(this, realRange, b -> b.damaged() && !b.isHealSuppressed(), other -> {
                    other.heal((healAmount + phaseHeat * phaseBoost) * efficiency);
                    other.recentlyHealed();
                    Fx.healBlockFull.at(other.x, other.y, other.block.size, baseColor, other.block);
                });
            }
        }
    }
}