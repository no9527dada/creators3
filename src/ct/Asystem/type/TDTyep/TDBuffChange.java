package ct.Asystem.type.TDTyep;

import arc.struct.Seq;
import mindustry.Vars;
import mindustry.gen.Building;
import mindustry.gen.Unit;
import mindustry.logic.LAccess;
import mindustry.type.Category;
import mindustry.type.StatusEffect;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.meta.BuildVisibility;

import static ct.content.ItemX.物品;
import static mindustry.Vars.state;
import static mindustry.type.ItemStack.with;

public class TDBuffChange {
    public static StatusEffect Buff = new StatusEffect("unitBuff") {{
        show = false;
    }};

    public static class BuffSpee extends Block {//速度更改

        public BuffSpee(String name) {
            super(name);
            update = true;
            sync = true;
            canOverdrive = false;
            targetable = false;
            forceDark = true;
            privileged = true;
            size = 1;
            requirements(Category.effect, BuildVisibility.sandboxOnly, with(物品, 1));
        }

        @Override
        public boolean canBreak(Tile tile) {
            return !privileged || state.rules.editor || state.playtestingMap != null;
        }

        public class BuffSpeeBuild extends Building {
            @Override
            public void control(LAccess type, double p1, double p2, double p3, double p4) {
                if (type == LAccess.config) Buff.speedMultiplier = (float) p1;
                super.control(type, p1, p2, p3, p4);
            }

            @Override
            public void updateTile() {
                Vars.state.teams.present.forEach(teamData -> teamData.units.forEach(unit -> unit.apply(Buff, 60)));
            }
        }
    }

    public static class BuffHealth extends Block {//生命更改

        public BuffHealth(String name) {
            super(name);
            update = true;
            sync = true;
            canOverdrive = false;
            targetable = false;
            forceDark = true;
            privileged = true;
            size = 1;
            requirements(Category.effect, BuildVisibility.sandboxOnly, with(物品, 1));
        }

        @Override
        public boolean canBreak(Tile tile) {
            return !privileged || state.rules.editor || state.playtestingMap != null;
        }

        public class BuffHealthBuild extends Building {
            @Override
            public void control(LAccess type, double p1, double p2, double p3, double p4) {
                if (type == LAccess.config) Buff.healthMultiplier = (float) p1;
                super.control(type, p1, p2, p3, p4);
            }

            @Override
            public void updateTile() {
                Vars.state.teams.present.forEach(teamData -> teamData.units.forEach(unit -> unit.apply(Buff, 60)));
            }
        }
    }

    public static class BuffDmage extends Block {//伤害更改

        public BuffDmage(String name) {
            super(name);
            update = true;
            sync = true;
            canOverdrive = false;
            targetable = false;
            forceDark = true;
            privileged = true;
            size = 1;
            requirements(Category.effect, BuildVisibility.sandboxOnly, with(物品, 1));
        }

        @Override
        public boolean canBreak(Tile tile) {
            return !privileged || state.rules.editor || state.playtestingMap != null;
        }

        public class BuffDmageBuild extends Building {
            @Override
            public void control(LAccess type, double p1, double p2, double p3, double p4) {
                if (type == LAccess.config) Buff.damageMultiplier = (float) p1;
                super.control(type, p1, p2, p3, p4);
            }

            @Override
            public void updateTile() {
                Vars.state.teams.present.forEach(teamData -> teamData.units.forEach(unit -> unit.apply(Buff, 60)));
            }
        }
    }

    public static class Buff加盾 extends Block {//直接修改盾，不使用BUFF

        public Buff加盾(String name) {
            super(name);
            update = true;
            sync = true;
            canOverdrive = false;
            targetable = false;
            forceDark = true;
            privileged = true;
            size = 1;
            requirements(Category.effect, BuildVisibility.sandboxOnly, with(物品, 1));
        }

        @Override
        public boolean canBreak(Tile tile) {
            return !privileged || state.rules.editor || state.playtestingMap != null;
        }

        public class 加盾Build extends Building {
            public Seq<Unit> units = new Seq<>();
            public Seq<Unit> removes = new Seq<>();
            public float 盾量 = 0;

            @Override
            public void control(LAccess type, double p1, double p2, double p3, double p4) {
                if (type == LAccess.config) 盾量 = (float) p1;
                super.control(type, p1, p2, p3, p4);
            }

            @Override
            public void updateTile() {
                Vars.state.teams.present.select(teamData -> teamData.team != Vars.state.rules.defaultTeam).forEach(teamData ->
                        teamData.units.select(unit -> !units.contains(unit)).forEach(unit -> {
                            units.add(unit);
                            unit.shield(盾量 - unit.shield);
                        }));
                removes.add(units.select(unit -> unit.dead));
                units.removeAll(removes);
                removes.clear();
            }
        }
    }

}
