package ct.Asystem.type;

import arc.math.Mathf;
import mindustry.ai.Pathfinder;
import mindustry.entities.Sized;
import mindustry.entities.units.AIController;
import mindustry.gen.Building;
import mindustry.gen.Teamc;
import mindustry.world.Tile;

import static mindustry.Vars.state;
import static mindustry.Vars.tilesize;

/*
 *@Author:LYBF
 *@Date  :2024/2/27
 *@Desc  :单位仅攻击核心
 * 用法   controller = u -> new OnlyAttackCoreAI();
 */
public class OnlyAttackCoreAI extends AIController {
    /*    @Override
        public void updateMovement() {
            unloadPayloads();
            if (target != null) {
                moveTo(target, (target instanceof Sized s ? s.hitSize() / 2f * 1.1f : 0f) + unit.hitSize / 2f + 15f, 50f);
                unit.lookAt(target);
            }
        }*/
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

        if ((core == null || !unit.within(core, unit.type.range * 0.5f))) {
            boolean move = true;

            if (state.rules.waves && unit.team == state.rules.defaultTeam) {
                Tile spawner = getClosestSpawner();
                if (spawner != null && unit.within(spawner, state.rules.dropZoneRadius + 120f)) move = false;
                if (spawner == null && core == null) move = false;
            }

            //no reason to move if there's nothing there
            if (core == null && (!state.rules.waves || getClosestSpawner() == null)) {
                move = false;
            }

            if (move) pathfind(Pathfinder.fieldCore);
        }

        if (unit.type.canBoost && unit.elevation > 0.001f && !unit.onSolid()) {
            unit.elevation = Mathf.approachDelta(unit.elevation, 0f, unit.type.riseSpeed);
        }

        faceTarget();
    }

    @Override
    public void updateTargeting() {
        if (retarget()) target = findTarget(unit.x, unit.y, unit.range(), true, true);
    }

    @Override
    public Teamc findTarget(float x, float y, float range, boolean air, boolean ground) {
        //only target core
        if (state.rules.waves && unit.team == state.rules.waveTeam) {
            return unit.closestEnemyCore();
        }
        return null;
    }
}
