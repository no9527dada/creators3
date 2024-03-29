package ct.content;

import arc.Core;
import arc.files.Fi;
import arc.graphics.Color;
import mindustry.Vars;
import mindustry.graphics.CacheLayer;
import mindustry.graphics.Shaders;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.SeaBush;
import mindustry.world.blocks.environment.Seaweed;
import mindustry.world.blocks.environment.StaticWall;

import static mindustry.content.Blocks.bluemat;

public class Floors {
    public static Fi shaders = Vars.mods.locateMod("ct").root.child("CTshaders");
    public static Shaders.SurfaceShader s1 = new Shaders.SurfaceShader(Shaders.getShaderFi("screenspace.vert").readString(),
            shaders.child("cryofluid2.frag").readString());
    public static CacheLayer.ShaderLayer m = new CacheLayer.ShaderLayer(s1);

    static {
        CacheLayer.add(m);
    }

    public static Floor 烟冰地板, 烟冰地板snow, 发光地板1, 发光地板2, 发光地板3, 发光地板4, 发光地板5;
    public static Seaweed 树;

    public static void load() {
        //可拆除的环境植被
        SeaBush 草1 = new SeaBush("cao1") {{
            localizedName = "绿草";
            bluemat.asFloor().decoration = this;
        }};
        SeaBush 草2 = new SeaBush("cao2") {{
            localizedName = "黄草";
            bluemat.asFloor().decoration = this;
        }};
        new Floor("heizuanFloor") {{
            localizedName = Core.bundle.get("Floor.heizuanFloor");
            variants = 6;
        }};
        new StaticWall("heizuanWall") {{
            localizedName = Core.bundle.get("Floor.heizuanWall");
            variants = 2;
        }};
/*        SeaBush  草2 = new SeaBush("cao2"){{
            lobesMin = 2;
            lobesMax = 3;
            magMax = 8f;
            magMin = 2f;
            origin = 0.3f;
            spread = 40f;
            sclMin = 60f;
            sclMax = 100f;
        }};*/
/*        Seaweed 树 = new Seaweed ("pur-bush2") {{
            variants = 3;
            bluemat.asFloor().decoration = this;
        }};*/


        //不可拆除的环境植被
        //  ？？？

        发光地板1 = new Floor("9关发光地板1") {{
            localizedName = "";
            variants = 1;
            // attributes.set(灵力收集, 2.25f);
            emitLight = true;
            lightRadius = 500 * 8f;
            lightColor = Color.valueOf("000000").a(0.1f);
        }};
        发光地板2 = new Floor("9关发光地板2") {{
            localizedName = "";
            variants = 1;
            // attributes.set(灵力收集, 2.25f);
            emitLight = true;
            lightRadius = 500 * 8f;
            lightColor = Color.valueOf("000000").a(0.2f);
        }};
        发光地板3 = new Floor("9关发光地板3") {{
            localizedName = "";
            variants = 1;
            // attributes.set(灵力收集, 2.25f);
            emitLight = true;
            lightRadius = 500 * 8f;
            lightColor = Color.valueOf("000000").a(0.4f);
        }};
        发光地板4 = new Floor("9关发光地板4") {{
            localizedName = "";
            variants = 1;
            // attributes.set(灵力收集, 2.25f);
            emitLight = true;
            lightRadius = 500 * 8f;
            lightColor = Color.valueOf("000000").a(0.6f);
        }};
        发光地板5 = new Floor("9关发光地板5") {{
            localizedName = "";
            variants = 1;
            // attributes.set(灵力收集, 2.25f);
            emitLight = true;
            lightRadius = 500 * 8f;
            lightColor = Color.valueOf("000000").a(1f);
        }};
        烟冰地板 = new Floor("YanBingFloor") {{
            dragMultiplier = 0.35f;
            speedMultiplier = 0.9f;
            albedo = 0.65f;
            variants = 3;
            attributes.set(CTAttributes.YanBing, 0.0625f);
            emitLight = true;
            lightRadius = 40f;
            lightColor = Color.valueOf("5313ba").a(0.15f);
        }};

        烟冰地板snow = new Floor("YanBingFloor-snow") {{
            dragMultiplier = 0.6f;
            variants = 3;
            attributes.set(CTAttributes.YanBing, 0.0625f + 0.0625f * 0.25f);
            albedo = 0.6f;
            emitLight = true;
            lightRadius = 40f;
            lightColor = Color.valueOf("5313ba").a(0.15f);
        }};


        树 = new Seaweed("pur-bush2") {{
            variants = 3;
            bluemat.asFloor().decoration = this;
        }};
        //不可拆除的环境植被
    }
}
