package ct.content;

import CtCoreSystem.CoreSystem.type.CTCoreBlock;
import arc.Core;
import mindustry.Vars;
import mindustry.game.Team;
import mindustry.gen.Building;
import mindustry.logic.LAccess;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.meta.BuildVisibility;

import static CtCoreSystem.content.ItemX.物品;
import static ct.content.RebirthCoreUnit.*;
import static ct.content.RebirthItem.*;
import static mindustry.Vars.state;
import static mindustry.content.UnitTypes.eclipse;
import static mindustry.content.UnitTypes.gamma;
import static mindustry.type.ItemStack.with;

public class CT3editorBlocks {
    //改伽马最大血量  18关用到

    public static void load() {
        new Block("伽马血量上限") {
            {
                update = true;
                sync = true;
                canOverdrive = false;
                targetable = false;
                forceDark = true;
                privileged = true;
                size = 1;
                requirements(Category.logic, BuildVisibility.sandboxOnly, with(物品, 1));
                buildType = Build::new;
            }

            @Override
            public boolean canBreak(Tile tile) {
                return Vars.state.rules.infiniteResources || !privileged || state.rules.editor || state.playtestingMap != null;
            }

            public class Build extends Building {
                @Override
                public void control(LAccess type, double p1, double p2, double p3, double p4) {
                    if (type == LAccess.config) {
                        Vars.state.teams.present.select(teamData -> teamData.team == Team.get(1)).each(teamData -> teamData.units.each(unit ->
                                {
                                    if (unit.type == gamma) unit.maxHealth = (int) p1;
                                }
                        ));
                    }
                    super.control(type, p1, p2, p3, p4);
                }

            }
        };
        new Block("日蚀血量上限") {
            {
                update = true;
                sync = true;
                canOverdrive = false;
                targetable = false;
                forceDark = true;
                privileged = true;
                size = 1;
                requirements(Category.logic, BuildVisibility.sandboxOnly, with(物品, 1));
                buildType = Build::new;
            }

            int 队伍 = -1;

            @Override
            public boolean canBreak(Tile tile) {
                return Vars.state.rules.infiniteResources || !privileged || state.rules.editor || state.playtestingMap != null;
            }

            public class Build extends Building {
                @Override
                public void control(LAccess type, double p1, double p2, double p3, double p4) {
                    if (type == LAccess.shootp) {
                        队伍 = (int) p2;
                        if (队伍 < 0) return;
                        Vars.state.teams.present.select(teamData -> teamData.team == Team.get(队伍)).each(teamData -> teamData.units.each(unit ->
                                {
                                    if (unit.type == eclipse) unit.maxHealth = (int) p1;
                                }
                        ));
                    }
                    super.control(type, p1, p2, p3, p4);
                }

            }
        };
    }
}
