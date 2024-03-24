package ct.Asystem.type;

import arc.math.Mathf;
import arc.struct.IntSeq;
import mindustry.ai.Pathfinder;
import mindustry.ai.types.FlyingAI;
import mindustry.ai.types.GroundAI;
import mindustry.entities.Sized;
import mindustry.entities.UnitSorts;
import mindustry.entities.Units;
import mindustry.entities.units.AIController;
import mindustry.game.Team;
import mindustry.gen.Building;
import mindustry.gen.Groups;
import mindustry.gen.Teamc;
import mindustry.gen.Unit;
import mindustry.world.Tile;

import static mindustry.Vars.state;
import static mindustry.Vars.tilesize;

/*
 *@Author:LYBF AIController
 *@Date  :2024/2/27
 *@Desc  :单位仅攻击核心
 * 用法   controller = u -> new OnlyAttackCoreAI();
 */
public class OnlyAttackCoreAI {

    public static class GroundOnlyAttackCoreAI extends GroundAI {

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

    public static class FlyingOnlyAttackCoreAI extends FlyingAI {

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


    public static class DevourSpiritAI extends AIController {
        public void updateMovement() {
            int searchRange = 250;//搜索敌人范围
            Unit 单位目标 = Units.bestEnemy(unit.team, unit.x, unit.y, unit.range() * searchRange, e -> !e.dead(), UnitSorts.closest);
            if (单位目标 != null) {
                moveTo(单位目标, 1, 20f);
                target = 单位目标;
                faceTarget();
                for (var mount : unit.mounts) {
                    mount.target = 单位目标;
                    if (Units.bestEnemy(unit.team, unit.x + 20, unit.y + 20, mount.weapon.bullet.range * 2, e -> !e.dead(), UnitSorts.closest) != null) {
                        mount.shoot = true;
                    }
                }
            }
        }
    }

    //寻路：敌方敌人
    public static class AnnihilateEnemyField extends Pathfinder.Flowfield {
        @Override
        protected void getPositions(IntSeq out) {
            Groups.build.each(b -> {
                if (team != b.team() && b.team() != Team.derelict) {
                    out.add(b.tile.array());
                }
            });
        }
    }
}


