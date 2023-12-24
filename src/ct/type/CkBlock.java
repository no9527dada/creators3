package ct.type;

import arc.Core;
import arc.Events;
import arc.graphics.g2d.Draw;
import arc.math.Interp;
import arc.math.Mathf;
import arc.struct.EnumSet;
import arc.struct.Seq;
import arc.util.Nullable;
import arc.util.Time;
import mindustry.content.Fx;
import mindustry.core.UI;
import mindustry.ctype.UnlockableContent;
import mindustry.entities.TargetPriority;
import mindustry.game.EventType.Trigger;
import mindustry.game.Team;
import mindustry.gen.*;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.logic.LAccess;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.ui.Bar;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.meta.BlockFlag;
import mindustry.world.meta.Env;
import mindustry.world.modules.ItemModule;

import static mindustry.Vars.*;
//联结相通的仓库，有BUG
public class CkBlock extends StorageBlock {
    //hacky way to pass item modules between methods
    private static ItemModule nextItems;
    public boolean isFirstTier;
    public boolean incinerateNonBuildable = false;
    public Seq<CkBuild> CkBuildList = new Seq<>();
    public CkBlock(String name){
        super(name);

        solid = true;
        update = true;
        hasItems = true;
        priority = TargetPriority.core;
        flags = EnumSet.of(BlockFlag.core);
        unitCapModifier = 10;
        loopSound = Sounds.respawning;
        loopSoundVolume = 1f;
        drawDisabled = false;
        canOverdrive = false;
        envEnabled |= Env.space;

        //support everything
        replaceable = false;
        //TODO should AI ever rebuild this?
        //rebuildable = false;
    }
    @Override
    public void setBars(){
        super.setBars();

        addBar("capacity", (CkBuild e) -> new Bar(
                () -> Core.bundle.format("bar.capacity", UI.formatAmount(e.storageCapacity)),
                () -> Pal.items,
                () -> e.items.total() / ((float)e.storageCapacity * content.items().count(UnlockableContent::unlockedNow))
        ));
    }

    @Override
    public void init(){
        //assign to update clipSize internally
        lightRadius = 30f + 20f * size;
        fogRadius = Math.max(fogRadius, (int)(lightRadius / 8f * 3f) + 13);
        emitLight = true;
        super.init();
    }


    @Override
    public void placeBegan(Tile tile, Block previous){
        //finish placement immediately when a block is replaced.
        if(previous instanceof CkBlock){
            tile.setBlock(this, tile.team());
            tile.block().placeEffect.at(tile, tile.block().size);
            Fx.upgradeCore.at(tile.drawx(), tile.drawy(), 0f, tile.block());
            Fx.upgradeCoreBloom.at(tile, tile.block().size);
            //set up the correct items
            if(nextItems != null){
                //force-set the total items
                if(tile.team().core() != null){
                    tile.team().core().items.set(nextItems);
                }
                nextItems = null;
            }
        }
    }

    @Override
    public void beforePlaceBegan(Tile tile, Block previous){
        if(tile.build instanceof CkBuild){
            //right before placing, create a "destination" item array which is all the previous items minus core requirements
            ItemModule items = tile.build.items.copy();
            if(!state.rules.infiniteResources){
                items.remove(ItemStack.mult(requirements, state.rules.buildCostMultiplier));
            }

            nextItems = items;
        }
    }

    public class CkBuild extends Building{
        public int storageCapacity;
        public boolean noEffect = false;
        public Team lastDamage = Team.derelict;
        public float iframes = -1f;
        public float thrusterTime = 0f;

        @Override
        public void draw(){
            //draw thrusters when just landed
            if(thrusterTime > 0){
                float frame = thrusterTime;

                Draw.alpha(1f);
                Draw.rect(block.region, x, y);
                Draw.alpha(Interp.pow4In.apply(frame));
                Draw.reset();
                drawTeamTop();
            }else{
                super.draw();
            }
        }

        @Override
        public void damage(@Nullable Team source, float damage){
            if(iframes > 0) return;
            if(source != null && source != team){
                lastDamage = source;
            }
            super.damage(source, damage);
        }


        @Override
        public double sense(LAccess sensor){
            if(sensor == LAccess.itemCapacity) return storageCapacity;
            return super.sense(sensor);
        }

        @Override
        public void updateTile(){
            iframes -= Time.delta;
            thrusterTime -= Time.delta/90f;
        }


        @Override
        public void drawLight(){
            Drawf.light(x, y, lightRadius, Pal.accent, 0.65f + Mathf.absin(20f, 0.1f));
        }

        @Override
        public boolean acceptItem(Building source, Item item){
            return items.get(item) < getMaximumAccepted(item);
        }

        @Override
        public int getMaximumAccepted(Item item){
            return storageCapacity;
        }

        @Override
        public void onProximityUpdate(){
            super.onProximityUpdate();

            for(Building other : CkBuildList){
                if(other.tile() != tile){
                    this.items = other.items;
                }
            }
            if (!CkBuildList.contains(this)){
                CkBuildList.add(this);
            }


            storageCapacity = itemCapacity + proximity().sum(e -> owns(e) ? e.block.itemCapacity : 0);
            for(Building other : CkBuildList){
                if(other.tile() == tile) continue;
                storageCapacity += other.block.itemCapacity + other.proximity().sum(e -> owns(other, e) ? e.block.itemCapacity : 0);
            }

            //Team.sharded.core().items.set(Items.surgeAlloy, 12000)
            if(!world.isGenerating()){
                for(Item item : content.items()){
                    items.set(item, Math.min(items.get(item), storageCapacity));
                }
            }

            for(CkBuild other : CkBuildList){
                other.storageCapacity = storageCapacity;
            }
        }

        @Override
        public void handleStack(Item item, int amount, Teamc source){
            boolean incinerate = incinerateNonBuildable && !item.buildable;
            int realAmount = incinerate ? 0 : Math.min(amount, storageCapacity - items.get(item));
            super.handleStack(item, realAmount, source);

            if(team == state.rules.defaultTeam && state.isCampaign()){
                if(!incinerate){
                    state.rules.sector.info.handleCoreItem(item, amount);
                }

                if(realAmount == 0 && wasVisible){
                    Fx.coreBurn.at(x, y);
                }
            }
        }

        public boolean owns(Building tile){
            return owns(this, tile);
        }

        public boolean owns(Building core, Building tile){
            return tile instanceof CkBuild;
        }
        @Override
        public int removeStack(Item item, int amount){
            int result = super.removeStack(item, amount);

            if(team == state.rules.defaultTeam && state.isCampaign()){
                state.rules.sector.info.handleCoreItem(item, -result);
            }

            return result;
        }


        @Override
        public void damage(float amount){
            if(player != null && team == player.team()){
                Events.fire(Trigger.teamCoreDamage);
            }
            super.damage(amount);
        }

        @Override
        public void onRemoved(){
            int total = proximity.count(e -> e.items != null && e.items == items);
            float fract = 1f / total / state.teams.cores(team).size;

           CkBuildList.remove(this);

            int max = itemCapacity * state.teams.cores(team).size;
            for(Item item : content.items()){
                items.set(item, Math.min(items.get(item), max));
            }

            for(CkBuild other : CkBuildList){
                other.onProximityUpdate();
            }
        }

        @Override
        public void placed(){
            super.placed();
            if (!CkBuildList.contains(this)){
                CkBuildList.add(this);
            }
        }

        @Override
        public void itemTaken(Item item){
            if(state.isCampaign() && team == state.rules.defaultTeam){
                //update item taken amount
                state.rules.sector.info.handleCoreItem(item, -1);
            }
        }

        @Override
        public void handleItem(Building source, Item item){
            boolean incinerate = incinerateNonBuildable && !item.buildable;

            if(team == state.rules.defaultTeam){
                state.stats.coreItemCount.increment(item);
            }

            if(net.server() || !net.active()){
                if(team == state.rules.defaultTeam && state.isCampaign() && !incinerate){
                    state.rules.sector.info.handleCoreItem(item, 1);
                }

                if(items.get(item) >= storageCapacity || incinerate){
                    //create item incineration effect at random intervals
                    if(!noEffect){
                        incinerateEffect(this, source);
                    }
                    noEffect = false;
                }else{
                    super.handleItem(source, item);
                }
            }else if(((state.rules.coreIncinerates && items.get(item) >= storageCapacity) || incinerate) && !noEffect){
                //create item incineration effect at random intervals
                incinerateEffect(this, source);
                noEffect = false;
            }
        }
    }
}
