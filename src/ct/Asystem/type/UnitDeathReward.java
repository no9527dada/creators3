package ct.Asystem.type;

import arc.Events;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.game.Team;
import mindustry.type.ItemStack;
import mindustry.type.UnitType;
import mindustry.world.modules.ItemModule;

import java.util.HashMap;
import java.util.Objects;

/*
 *@Author:LYBF
 *@Date  :2024/2/19
 * 用法示例：
 * UnitDeathReward reward = UnitDeathReward.getInstance();
 * reward.init();
 * reward.add(UnitTypes.mono,new ItemStack(Items.copper,100));
 *
 * 2.
 * UnitDeathReward.getInstance().init().add(UnitTypes.mono,new ItemStack(Items.copper,100))
 *
 * 3.
 *  UnitDeathReward.getInstance().init()
                .with(
                        UnitTypes.dagger, ItemStack.with(mindustry.content.Items.copper, 114, mindustry.content.Items.lead, 514)
                        ....
                );
 */
public class UnitDeathReward {

    public static UnitDeathReward instance;

    //奖励配置
    public static HashMap<String, UnitDeathRewardConfiguration> configurations = new HashMap<>();

    //配置类
    public static class UnitDeathRewardConfiguration {
        //单位
        public UnitType unitType;
        //单位死亡奖励
        public ItemStack[] itemStacks;

        public UnitDeathRewardConfiguration() {

        }

        public UnitDeathRewardConfiguration(UnitType unitType, ItemStack[] itemStacks) {
            this.unitType = unitType;
            this.itemStacks = itemStacks;
        }


    }

    public static UnitDeathReward getInstance() {
        if (instance == null) instance = new UnitDeathReward();
        return instance;
    }

    //初始化
    public UnitDeathReward init() {
        Events.on(EventType.UnitDestroyEvent.class, e -> {
            Team unitTeam = e.unit.team;
            Team playerTeam = Vars.player.team();
            //是同一个队伍时不触发
            if (unitTeam == playerTeam) return;
            UnitDeathRewardConfiguration configuration = configurations.get(e.unit.type.name);
            if (!Objects.isNull(configuration)) {
                ItemModule items = Vars.state.teams.get(Vars.player.team()).core().items();
                for (ItemStack itemStack : configuration.itemStacks) {
                    items.add(itemStack.item, itemStack.amount);
                }
            }
        });
        return instance;
    }

    /*
     *添加奖励规则
     */
    public UnitDeathReward add(UnitDeathRewardConfiguration configuration) {
        return add(configuration.unitType.name, configuration);
    }

    public UnitDeathReward add(UnitType unitType, ItemStack itemStacks) {
        return add(unitType, new ItemStack[]{itemStacks});
    }

    public UnitDeathReward add(UnitType unitType, ItemStack[] itemStacks) {
        UnitDeathRewardConfiguration configuration = new UnitDeathRewardConfiguration(unitType, itemStacks);
        return add(configuration);
    }

    public UnitDeathReward add(String name, UnitDeathRewardConfiguration configuration) {
        if (Objects.isNull(configuration) || Objects.isNull(name) || Objects.isNull(configuration.unitType) || Objects.isNull(configuration.itemStacks)) {
            return instance;
        }
        configurations.put(name, configuration);
        return instance;
    }

    public UnitDeathReward add(UnitDeathRewardConfiguration[] array) {
        for (UnitDeathRewardConfiguration configuration : array) {
            add(configuration.unitType.name, configuration);
        }
        return instance;
    }


    /*
     *添加多个配置
     * 参数为
     * UnitType,ItemStack,UnitType,ItemStack
     */
    public UnitDeathReward with(Object... configs) {
        for (int i = 0; i < configs.length; i += 2) {
            add(new UnitDeathRewardConfiguration((UnitType) configs[i], (ItemStack[]) configs[i + 1]));
            ((UnitType) configs[i]).abilities.add(new ShowShowWhatItemsInUnit((ItemStack[]) configs[i + 1]));
        }
        return instance;
    }

    /*
     *移除规则
     */
    public UnitDeathReward remove(String name) {
        configurations.remove(name);
        return instance;
    }

    public UnitDeathReward remove(UnitType unitType) {
        return remove(unitType.name);
    }
}
