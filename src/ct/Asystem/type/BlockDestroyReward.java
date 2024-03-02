package ct.Asystem.type;

import arc.Events;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.game.Team;
import mindustry.type.ItemStack;
import mindustry.type.UnitType;
import mindustry.world.Block;
import mindustry.world.modules.ItemModule;

import java.util.HashMap;
import java.util.Objects;

/*
 *@Author:LYBF
 *@Date  :2024/2/27
 */
//毁坏目标方块获得相应资源进核心
// 用法   BlockDestroyReward.getInstance().apply().add(Blocks.copperWall,new ItemStack(Items.copper,100));
public class BlockDestroyReward {

    public static BlockDestroyReward instance = new BlockDestroyReward();

    //奖励配置
    public static HashMap<String, BlockDestroyRewardConfiguration> configurations = new HashMap<>();

    //配置类
    public static class BlockDestroyRewardConfiguration {
        //毁坏目标方块
        public Block target;
        //奖励
        public ItemStack[] itemStacks;

        public BlockDestroyRewardConfiguration() {
        }

        public BlockDestroyRewardConfiguration(Block targetBlock, ItemStack[] itemStacks) {
            this.target = targetBlock;
            this.itemStacks = itemStacks;
        }


    }

    public static BlockDestroyReward getInstance() {
        return instance;
    }

    //初始化
    public BlockDestroyReward apply() {
        Events.on(EventType.BlockDestroyEvent.class, e -> {
            Team unitTeam = e.tile.team();
            Team playerTeam = Vars.player.team();
            //是同一个队伍时不触发
            if (unitTeam == playerTeam) return;
            BlockDestroyRewardConfiguration configuration = configurations.get(e.tile.block().name);
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
    public BlockDestroyReward add(BlockDestroyRewardConfiguration configuration) {
        return add(configuration.target.name, configuration);
    }

    public BlockDestroyReward add(Block block, ItemStack itemStacks) {
        return add(block, new ItemStack[]{itemStacks});
    }

    public BlockDestroyReward add(Block target, ItemStack[] itemStacks) {
        BlockDestroyRewardConfiguration configuration = new BlockDestroyRewardConfiguration(target, itemStacks);
        return add(configuration);
    }

    public BlockDestroyReward add(String name, BlockDestroyRewardConfiguration configuration) {
        if (Objects.isNull(configuration) || Objects.isNull(name) || Objects.isNull(configuration.target) || Objects.isNull(configuration.itemStacks)) {
            return instance;
        }
        configurations.put(name, configuration);
        return instance;
    }

    public BlockDestroyReward add(BlockDestroyRewardConfiguration[] array) {
        for (BlockDestroyRewardConfiguration configuration : array) {
            add(configuration.target.name, configuration);
        }
        return instance;
    }


    /*
     *添加多个配置
     * 参数为
     * Block,ItemStack,Block,ItemStack
     */
    public BlockDestroyReward with(Object... configs) {
        for (int i = 0; i < configs.length; i += 2) {
            add(new BlockDestroyRewardConfiguration((Block) configs[i], (ItemStack[]) configs[i + 1]));
        }
        return instance;
    }

    /*
     *移除规则
     */
    public BlockDestroyReward remove(String name) {
        configurations.remove(name);
        return instance;
    }

    public BlockDestroyReward remove(Block target) {
        return remove(target.name);
    }

}
