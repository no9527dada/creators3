package ct.Asystem.type.TDTyep;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import arc.struct.ObjectMap;
import arc.util.Time;
import arc.util.Tmp;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.Vars;
import mindustry.entities.Units;
import mindustry.gen.Building;
import mindustry.gen.Groups;
import mindustry.gen.Unit;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.StatusEffect;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

import static mindustry.Vars.tilesize;
import static mindustry.Vars.world;

public class UnitPortal extends Block {
    //传送以后给单位加个免疫传送的状态，在这个状态的持续时间里，无法被计入传送
    public static StatusEffect TransferEffect;
    //状态时间 600正常等于10秒
    public float TransferEffectTime = 10 * 60f;

    static final Stat StatLinkRange;
    static final Stat StatUnitRange;
    static final Stat StatTransferSpeed;

    static {
        StatLinkRange = new Stat("StatLinkRange");
        StatUnitRange = new Stat("StatUnitRange");
        StatTransferSpeed = new Stat("StatTransferSpeed");

        TransferEffect = new StatusEffect("immuneTransfer") {
            {
                show = false;
            }

            public void update(Unit unit, float time) {
            }

            @Override
            public void draw(Unit unit) {
                float brcx = unit.x + (unit.hitSize() / 2f) - (tilesize / 2f);
                brcx = unit.x;
                float brcy = unit.y - (unit.hitSize() / 2f) - (tilesize / 2f);
                brcy = unit.y;

                //Draw.z(Layer.flyingUnit + 1);
                // Draw.rect("ct-immuneTransfer", brcx, brcy, tilesize + unit.hitSize() / 2, tilesize + unit.hitSize() / 2);
            }
        };
    }

    //最远连接范围（格）
    public float LinkRange = 50;

    //传送区范围（格）
    //以方块中心为圆形，单位进入区域传送
    public float UnitRange = 8;

    //传送时间 默认60一秒
    public float TransferSpeed = 1 * 60;

    //t 为 全体传送 传送时间到了就传送
    //f 为 单体传送 每一个单位进入传送范围单独计算时间 到了就传送
    public boolean TransferAll = true;

    //t 为 传送以后单位在传送点中心
    //f 为 传送以后单位在传送点的相对位置
    public boolean TransferType = true;

    Color CC = Color.valueOf("d0ffbb32");

    public UnitPortal(String name) {
        super(name);

        solid = false;
        update = true;
        configurable = true;
        drawDisabled = true;
        destructible = true;

        config(Integer.class, (UnitPortalBlockBuild build, Integer i) -> {
            if (i == -1) {
                build.TargetBlock = null;
            } else {
                build.TargetBlock = (UnitPortalBlockBuild) Vars.world.build(i);
            }
        });

        buildType = UnitPortalBlockBuild::new;
    }

    @Override
    public void setStats() {
        super.setStats();

        stats.add(StatLinkRange, LinkRange, StatUnit.blocks);
        stats.add(StatUnitRange, UnitRange, StatUnit.blocks);
        stats.add(StatTransferSpeed, TransferSpeed / 60, StatUnit.seconds);
    }

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid) {
        Tile tile = world.tile(x, y);

        if (tile == null) return;

        Lines.stroke(1f);
        Draw.color(Pal.heal);
        Drawf.circles(x * tilesize + offset, y * tilesize + offset, UnitRange * tilesize);

        Lines.stroke(1f);
        Draw.color(Pal.placing);
        Drawf.circles(x * tilesize + offset, y * tilesize + offset, LinkRange * tilesize);

        Draw.reset();
    }

    public class UnitPortalBlockBuild extends Building {

        public UnitPortalBlockBuild TargetBlock = null;
        public ObjectMap<Integer, Float> ObjTimer = new ObjectMap<>();

        @Override
        public boolean onConfigureBuildTapped(Building other) {
            if (TargetBlock == null) {
                if (this.dst(other) <= LinkRange * tilesize && other != this) {
                    if (other instanceof UnitPortalBlockBuild) {
                        UnitPortalBlockBuild b = (UnitPortalBlockBuild) other;
                        configure(b.pos());
                        return false;
                    }
                }
                return true;
            } else {
                if (TargetBlock == other) {
                    configure(-1);
                    return false;
                }
            }
            return true;
        }

        @Override
        public void update() {
            super.update();

            if (TargetBlock != null) {
                if (TransferAll) {
                    if (!ObjTimer.containsKey(0)) {
                        ObjTimer.put(0, 0f);
                    }
                    ObjTimer.put(0, ObjTimer.get(0) + power.status * edelta());

                    if (ObjTimer.get(0) > TransferSpeed) {
                        Units.nearby(team, x, y, UnitRange * tilesize, unit -> {
                            if (!unit.hasEffect(TransferEffect)) {
                                if (TransferType) {
                                    unit.set(TargetBlock);
                                } else {
                                    unit.set(unit.x + (TargetBlock.x - x), unit.y + (TargetBlock.y - y));
                                }

                                unit.apply(TransferEffect, TransferEffectTime);
                            }
                        });

                        ObjTimer.put(0, 0f);
                    }
                } else {
                    Units.nearby(team, x, y, UnitRange * tilesize, unit -> {
                        if (!unit.hasEffect(TransferEffect)) {
                            if (!ObjTimer.containsKey(unit.id())) {
                                ObjTimer.put(unit.id(), 0f);
                            }

                            if (ObjTimer.get(unit.id()) > TransferSpeed) {
                                if (TransferType) {
                                    unit.set(TargetBlock);
                                } else {
                                    unit.set(unit.x + (TargetBlock.x - x), unit.y + (TargetBlock.y - y));
                                }

                                unit.apply(TransferEffect, TransferEffectTime);

                                ObjTimer.remove(unit.id());
                            } else {
                                ObjTimer.put(unit.id(), ObjTimer.get(unit.id()) + power.status * edelta());
                            }
                        }
                    });

                    for (var obj : ObjTimer) {
                        if (Groups.unit.getByID(obj.key) == null) {
                            ObjTimer.remove(obj.key);
                            break;
                        }
                    }
                }
            }
        }

        @Override
        public void drawSelect() {
            super.drawSelect();

            Lines.stroke(1.0F);

            Lines.stroke(3.0F, CC);
            Lines.circle(x, y, LinkRange * 8.0F);
            Lines.stroke(1.0F, Pal.accent);
            Lines.circle(x, y, LinkRange * 8.0F);
            Draw.reset();

            if (TargetBlock != null) {
                Drawf.square(TargetBlock.x, TargetBlock.y, TargetBlock.block().size * tilesize / 2f + 1f, Pal.place);
            }
        }

        @Override
        public void drawConfigure() {
            Drawf.circles(x, y, this.block().size * tilesize / 2f + 1f + Mathf.absin(Time.time, 4f, 1f));

            if (TargetBlock != null) {
                Drawf.square(TargetBlock.x, TargetBlock.y, TargetBlock.block().size * tilesize / 2f + 1f, Pal.place);
            }
        }

        @Override
        public void draw() {
            super.draw();

            Lines.stroke(1.0F);

            Lines.stroke(3.0F, CC);
            Lines.circle(x, y, UnitRange * tilesize);
            Lines.stroke(1.0F, Pal.heal);
            Lines.circle(x, y, UnitRange * tilesize);
            Draw.reset();

            if (TargetBlock != null) {
                if (TransferAll) {
                    if (!ObjTimer.containsKey(0)) {
                        ObjTimer.put(0, 0f);
                    }

                    Lines.stroke(1.0F);

                    Lines.stroke(3.0F, CC);
                    Lines.circle(x, y, ((ObjTimer.get(0) / TransferSpeed) * UnitRange) * tilesize);
                    Lines.stroke(1.0F, Tmp.c1.set(Color.white).lerp(Pal.heal, ObjTimer.get(0) / TransferSpeed));
                    Lines.circle(x, y, ((ObjTimer.get(0) / TransferSpeed) * UnitRange) * tilesize);
                    Draw.reset();
                } else {
                    for (var obj : ObjTimer) {
                        if (Groups.unit.getByID(obj.key) == null) return;

                        Unit u = Groups.unit.getByID(obj.key);
                        float t = obj.value;

                        if (u.dst(this) > UnitRange * tilesize) return;

                        Lines.stroke(3.0F, CC);
                        Lines.circle(u.x, u.y, u.hitSize * 2);
                        Lines.stroke(1.0F, Pal.heal);
                        Lines.circle(u.x, u.y, u.hitSize * 2);
                        Draw.reset();

                        Lines.stroke(1.0F);

                        Lines.stroke(3.0F, CC);
                        Lines.circle(u.x, u.y, (t / TransferSpeed) * u.hitSize * 2);
                        Lines.stroke(1.0F, Tmp.c1.set(Color.white).lerp(Pal.heal, t / TransferSpeed));
                        Lines.circle(u.x, u.y, (t / TransferSpeed) * u.hitSize * 2);
                        Draw.reset();
                    }
                }
            }
        }

        @Override
        public void write(Writes write) {
            super.write(write);

            if (TargetBlock == null) {
                write.i(-1);
            } else {
                write.i(TargetBlock.pos());
            }

            if (TransferAll) {
                write.f(ObjTimer.get(0));
            } else {
                write.i(ObjTimer.size);
                for (var map : ObjTimer) {
                    write.i(map.key);
                    write.f(map.value);
                }
            }
        }

        @Override
        public void read(Reads read, byte revision) {
            super.read(read, revision);

            int BuildId = read.i();
            if (BuildId == -1) {
                TargetBlock = null;
            } else {
                TargetBlock = (UnitPortalBlockBuild) Vars.world.build(read.i());
            }

            ObjTimer.clear();
            if (TransferAll) {
                ObjTimer.put(0, read.f());
            } else {
                var IntSize = read.i();
                for (var i = 0; i < IntSize; i++) {
                    var id = read.i();
                    var time = read.f();

                    ObjTimer.put(id, time);
                }
            }
        }
    }
}
