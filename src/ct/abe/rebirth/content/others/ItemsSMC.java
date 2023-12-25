package ct.abe.rebirth.content.others;
/*合成台*/
import arc.graphics.Color;
import ct.abe.rebirth.content.CTAttributes;
import ct.type.CreatorsMultiCrafter;
import ct.type.CreatorsRecipe;
import ct.type.oldUnitFactory;
import mindustry.content.Items;
import mindustry.content.UnitTypes;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;

import static ct.abe.rebirth.content.Blocks.*;
import static ct.abe.rebirth.content.Items.*;
import static mindustry.type.ItemStack.with;
public class ItemsSMC {
    public static Block
            资源合成台0,  资源合成台1, 资源合成台2,资源合成台3,资源采集站;
    public static oldUnitFactory
            unitTypee,单位工厂测试;

    public static void load(){

         单位工厂测试 = new oldUnitFactory("单位工厂测试") {{
             unitType = new UnitPlan(
                     UnitTypes.dagger, 60f * 5,
                     with(Items.silicon, 10, Items.lead, 10)
             );
             requirements(Category.units, with(Items.silicon, 10, Items.lead, 10));
            maxunit = 4;
            size = 4;
            hasPower = true;
            health = 400;
             consumePower(150f / 60f);

        }};





         //初始合成台
        资源合成台0 = new CreatorsMultiCrafter("初始合成台",26){{
            requirements(Category.crafting, with());
            size = 4;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;
            ambientSound = Sounds.electricHum;

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥翠, 1), 30f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(冥丝, 1)), 1f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥织, 2, 魂翠,1), 60f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(相织物, 2)), 1f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨气集束, 3), 50f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵境, 2)), 2f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥翠, 2, 魂翠,1), 40f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂丝, 2)), 1f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冤藤, 25), LiquidStack.with(灵液, 35), 60f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(硅晶体, 1)), 6f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵珠, 3, 硅晶体,1),  60f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵晶, 1)), 4f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(相织物, 4, 灵境,2),  65f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(魂力激发块, 1)), 2.5f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵珠, 2, 珊绒,10),  25f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(一级燃魂集, 2)), 6f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(翠灵晶, 1, 暗珊绒,8, 缜相织,1),  90f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(二级燃魂集, 2)), 12f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(暗物质, 12, 灵魂束缚容器,1, 翠灵晶, 3, 珊绒,10),  220f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(三级燃魂集, 2)), 24f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥丝, 2, 冥翠,1, 相织物,1),  45f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(微相织, 2)), 2f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(微相织, 2, 相织物,2),  57f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(衬相织, 2)), 2f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(衬相织, 2, 冥织,3, 粉烟,1),  85f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(缜相织, 2)), 3f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨气集束, 2, 灵珠, 2), LiquidStack.with(灵液, 5),  65f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(怨灵集束, 2)), 5f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵晶, 1, 气光散, 2, 珊绒,10),80f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(微格晶, 1)), 4f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(赤焰膏块, 2), 120f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(赤焰膏精, 1)), 2f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(赤焰膏块, 2, 魂翠, 2), 120f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂集束, 1)), 2f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵魂丝, 3, 灵魂集束,2),90f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂核心, 1)), 4f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(微格晶, 1, 怨灵集束, 2, 灵魂集束,2),140f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂转换因子, 1)), 12f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(气丝节束, 2, 赤焰膏精, 2, 网束器, 1),80f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂网束器, 1)), 8f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(沉珠, 4, 夜灵核心, 1),LiquidStack.with(叹酸, 4),160f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(夜灵珠, 1)), 6f* T0time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(衬相织, 2, 魂翠, 2, 气光散,2),90f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(衬光束, 1)), 6f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(魔能晶, 8, 魂翠, 3),120f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(衬光束, 1)), 6f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(衬光束, 1, 灵魂核心, 2),210f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂束缚容器, 1)), 20f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(气丝节束, 4, 翠灵晶,1, 赤焰膏块, 1),180f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(混沌晶体, 1)), 6f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨石块, 8, 冥翠块, 3),80f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(魂冲器, 1)), 15f* T0time
            );























        }};
        资源合成台1 = new CreatorsMultiCrafter("资源合成台1",26){{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 5;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;
            ambientSound = Sounds.electricHum;

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥翠, 1), 30f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(冥丝, 1)), 1f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥织, 2, 魂翠,1), 60f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(相织物, 2)), 1f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨气集束, 3), 50f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵境, 2)), 2f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥翠, 2, 魂翠,1), 40f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂丝, 2)), 1f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冤藤, 25), LiquidStack.with(灵液, 35), 60f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(硅晶体, 1)), 6f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵珠, 3, 硅晶体,1),  60f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵晶, 1)), 4f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(相织物, 4, 灵境,2),  65f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(魂力激发块, 1)), 2.5f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵珠, 2, 珊绒,10),  25f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(一级燃魂集, 2)), 6f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(翠灵晶, 1, 暗珊绒,8, 缜相织,1),  90f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(二级燃魂集, 2)), 12f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(暗物质, 12, 灵魂束缚容器,1, 翠灵晶, 3, 珊绒,10),  220f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(三级燃魂集, 2)), 24f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥丝, 2, 冥翠,1, 相织物,1),  45f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(微相织, 2)), 2f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(微相织, 2, 相织物,2),  57f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(衬相织, 2)), 2f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(衬相织, 2, 冥织,3, 粉烟,1),  85f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(缜相织, 2)), 3f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨气集束, 2, 灵珠, 2), LiquidStack.with(灵液, 5),  65f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(怨灵集束, 2)), 5f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵晶, 1, 气光散, 2, 珊绒,10),80f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(微格晶, 1)), 4f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(赤焰膏块, 2), 120f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(赤焰膏精, 1)), 2f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(赤焰膏块, 2, 魂翠, 2), 120f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂集束, 1)), 2f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵魂丝, 3, 灵魂集束,2),90f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂核心, 1)), 4f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(微格晶, 1, 怨灵集束, 2, 灵魂集束,2),140f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂转换因子, 1)), 12f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(气丝节束, 2, 赤焰膏精, 2, 网束器, 1),80f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂网束器, 1)), 8f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(沉珠, 4, 夜灵核心, 1),LiquidStack.with(叹酸, 4),160f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(夜灵珠, 1)), 6f* T1time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(衬相织, 2, 魂翠, 2, 气光散,2),90f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(衬光束, 1)), 6f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(魔能晶, 8, 魂翠, 3),120f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(衬光束, 1)), 6f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(衬光束, 1, 灵魂核心, 2),210f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂束缚容器, 1)), 20f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(气丝节束, 4, 翠灵晶,1, 赤焰膏块, 1),180f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(混沌晶体, 1)), 6f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨石块, 8, 冥翠块, 3),80f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(魂冲器, 1)), 15f* T1time
            );























        }};
        资源合成台2 = new CreatorsMultiCrafter("资源合成台2",26){{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 4;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;
            ambientSound = Sounds.electricHum;

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥翠, 1), 30f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(冥丝, 1)), 1f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥织, 2, 魂翠,1), 60f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(相织物, 2)), 1f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨气集束, 3), 50f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵境, 2)), 2f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥翠, 2, 魂翠,1), 40f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂丝, 2)), 1f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冤藤, 25), LiquidStack.with(灵液, 35), 60f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(硅晶体, 1)), 6f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵珠, 3, 硅晶体,1),  60f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵晶, 1)), 4f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(相织物, 4, 灵境,2),  65f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(魂力激发块, 1)), 2.5f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵珠, 2, 珊绒,10),  25f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(一级燃魂集, 2)), 6f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(翠灵晶, 1, 暗珊绒,8, 缜相织,1),  90f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(二级燃魂集, 2)), 12f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(暗物质, 12, 灵魂束缚容器,1, 翠灵晶, 3, 珊绒,10),  220f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(三级燃魂集, 2)), 24f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥丝, 2, 冥翠,1, 相织物,1),  45f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(微相织, 2)), 2f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(微相织, 2, 相织物,2),  57f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(衬相织, 2)), 2f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(衬相织, 2, 冥织,3, 粉烟,1),  85f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(缜相织, 2)), 3f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨气集束, 2, 灵珠, 2), LiquidStack.with(灵液, 5),  65f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(怨灵集束, 2)), 5f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵晶, 1, 气光散, 2, 珊绒,10),80f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(微格晶, 1)), 4f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(赤焰膏块, 2), 120f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(赤焰膏精, 1)), 2f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(赤焰膏块, 2, 魂翠, 2), 120f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂集束, 1)), 2f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵魂丝, 3, 灵魂集束,2),90f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂核心, 1)), 4f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(微格晶, 1, 怨灵集束, 2, 灵魂集束,2),140f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂转换因子, 1)), 12f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(气丝节束, 2, 赤焰膏精, 2, 网束器, 1),80f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂网束器, 1)), 8f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(沉珠, 4, 夜灵核心, 1),LiquidStack.with(叹酸, 4),160f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(夜灵珠, 1)), 6f* T2time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(衬相织, 2, 魂翠, 2, 气光散,2),90f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(衬光束, 1)), 6f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(魔能晶, 8, 魂翠, 3),120f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(衬光束, 1)), 6f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(衬光束, 1, 灵魂核心, 2),210f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂束缚容器, 1)), 20f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(气丝节束, 4, 翠灵晶,1, 赤焰膏块, 1),180f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(混沌晶体, 1)), 6f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨石块, 8, 冥翠块, 3),80f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(魂冲器, 1)), 15f* T2time
            );























        }};
        资源合成台3 = new CreatorsMultiCrafter("资源合成台3",26){{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 3;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;
            ambientSound = Sounds.electricHum;

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥翠, 1), 30f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(冥丝, 1)), 1f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥织, 2, 魂翠,1), 60f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(相织物, 2)), 1f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨气集束, 3), 50f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵境, 2)), 2f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥翠, 2, 魂翠,1), 40f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂丝, 2)), 1f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冤藤, 25), LiquidStack.with(灵液, 35), 60f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(硅晶体, 1)), 6f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵珠, 3, 硅晶体,1),  60f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵晶, 1)), 4f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(相织物, 4, 灵境,2),  65f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(魂力激发块, 1)), 2.5f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵珠, 2, 珊绒,10),  25f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(一级燃魂集, 2)), 6f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(翠灵晶, 1, 暗珊绒,8, 缜相织,1),  90f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(二级燃魂集, 2)), 12f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(暗物质, 12, 灵魂束缚容器,1, 翠灵晶, 3, 珊绒,10),  220f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(三级燃魂集, 2)), 24f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥丝, 2, 冥翠,1, 相织物,1),  45f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(微相织, 2)), 2f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(微相织, 2, 相织物,2),  57f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(衬相织, 2)), 2f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(衬相织, 2, 冥织,3, 粉烟,1),  85f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(缜相织, 2)), 3f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨气集束, 2, 灵珠, 2), LiquidStack.with(灵液, 5),  65f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(怨灵集束, 2)), 5f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵晶, 1, 气光散, 2, 珊绒,10),80f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(微格晶, 1)), 4f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(赤焰膏块, 2), 120f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(赤焰膏精, 1)), 2f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(赤焰膏块, 2, 魂翠, 2), 120f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂集束, 1)), 2f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵魂丝, 3, 灵魂集束,2),90f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂核心, 1)), 4f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(微格晶, 1, 怨灵集束, 2, 灵魂集束,2),140f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂转换因子, 1)), 12f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(气丝节束, 2, 赤焰膏精, 2, 网束器, 1),80f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂网束器, 1)), 8f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(沉珠, 4, 夜灵核心, 1),LiquidStack.with(叹酸, 4),160f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(夜灵珠, 1)), 6f* T3time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(衬相织, 2, 魂翠, 2, 气光散,2),90f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(衬光束, 1)), 6f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(魔能晶, 8, 魂翠, 3),120f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(衬光束, 1)), 6f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(衬光束, 1, 灵魂核心, 2),210f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵魂束缚容器, 1)), 20f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(气丝节束, 4, 翠灵晶,1, 赤焰膏块, 1),180f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(混沌晶体, 1)), 6f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨石块, 8, 冥翠块, 3),80f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(魂冲器, 1)), 15f* T3time
            );



            资源采集站 = new CreatorsMultiCrafter("资源采集站",3){{
                requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
                size = 4;
                hasItems = true;
                hasPower = true;
                TableColor = Color.valueOf("78ffa5");
                allRecShow = false;
                RecipeShowIS = 6;
                attribute = CTAttributes.YanBing;//地形限制
                minEfficiency = 0.01f;//地形限制必须-1
                baseEfficiency=0;//地形限制必须-2

                addRecipe(
                        new CreatorsRecipe.InputContents(ItemStack.with(), 120/60f),
                        new CreatorsRecipe.OutputContents(ItemStack.with(珊绒, 3)), 1f* T1time
                );
                addRecipe(
                        new CreatorsRecipe.InputContents(ItemStack.with(), 180/60f),
                        new CreatorsRecipe.OutputContents(ItemStack.with(烟冰, 2)), 1.5f* T1time
                );
                addRecipe(
                        new CreatorsRecipe.InputContents(ItemStack.with(), 320/60f),
                        new CreatorsRecipe.OutputContents(ItemStack.with(暗珊绒, 2)), 60f* T1time
                );
             }};



















        }};
    }
}
