package ct.Asystem.type;

import arc.math.Mathf;
import mindustry.ai.Pathfinder;
import mindustry.ai.types.GroundAI;
import mindustry.entities.Sized;
import mindustry.entities.units.AIController;
import mindustry.gen.Building;
import mindustry.gen.Teamc;
import mindustry.world.Tile;

import static mindustry.Vars.state;
import static mindustry.Vars.tilesize;

/*
 *@Author:LYBF AIController
 *@Date  :2024/2/27
 *@Desc  :单位仅攻击核心
 * 用法   controller = u -> new OnlyAttackCoreAI();
 */
public class OnlyAttackCoreAI extends GroundAI {

    @Override
    public void updateMovement() {
        Building core = unit.closestEnemyCore();

        if (core != null && unit.within(core, unit.range() / 1.3f + core.block.size * tilesize / 2f)) {
            target = core;
            for (var mount : unit.mounts) {
                if (mount.weapon.controllable && mount.weapon.bullet.collidesGround) {
                    mount.target = core;
                }
            }
        }

        boolean move = true;

        if (state.rules.waves && unit.team == state.rules.defaultTeam) {
            Tile spawner = getClosestSpawner();
            if (spawner != null && unit.within(spawner, state.rules.dropZoneRadius + 120f)) move = false;
            if (spawner == null && core == null) move = false;
        }

        if (core == null && (!state.rules.waves || getClosestSpawner() == null)) {
            move = false;
        }

        if (move) pathfind(Pathfinder.fieldCore);


        if (unit.type.canBoost && unit.elevation > 0.001f && !unit.onSolid()) {
            unit.elevation = Mathf.approachDelta(unit.elevation, 0f, unit.type.riseSpeed);
        }

        faceTarget();
    }

    @Override
    public Teamc target(float x, float y, float range, boolean air, boolean ground) {
        return unit.closestEnemyCore();
    }
}


