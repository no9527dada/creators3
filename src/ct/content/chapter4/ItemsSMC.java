package ct.content.chapter4;
/*合成台*/

import arc.graphics.Color;
import ct.Asystem.type.MultiCrafter.CT3_MultiCrafter;
import ct.Asystem.type.MultiCrafter.CreatorsRecipe;
import ct.Asystem.type.oldUnitFactory;
import mindustry.content.Items;
import mindustry.content.UnitTypes;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;

import static ct.content.CTAttributes.*;
import static mindustry.type.ItemStack.with;

public class ItemsSMC {
    public static Block
            资源合成台0, 资源合成台1, 资源合成台2, 资源合成台3, 资源采集站;
    public static oldUnitFactory
            unitTypee, 单位工厂测试;

    public static void load() {


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
        //单位工厂测试=new oldUnitFactory("单位工厂测试"){{}};


        资源合成台0 = new CT3_MultiCrafter("初始合成台", 26) {{
            requirements(Category.crafting, with());
            size = 4;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;
            ambientSound = Sounds.electricHum;

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥翠, 1), 30f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.冥丝, 1)), 1f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥织, 2, CT3Item4.魂翠, 1), 60f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.相织物, 2)), 1f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨气集束, 3), 50f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵境, 2)), 2f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥翠, 2, CT3Item4.魂翠, 1), 40f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂丝, 2)), 1f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冤藤, 25), LiquidStack.with(CT3Item4.灵液4, 35), 60f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.硅晶体, 1)), 6f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵珠, 3, CT3Item4.硅晶体, 1), 60f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵晶, 1)), 4f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.相织物, 4, CT3Item4.灵境, 2), 65f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.魂力激发块, 1)), 2.5f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵珠, 2, CT3Item4.珊绒, 10), 25f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.一级燃魂集, 2)), 6f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.翠灵晶, 1, CT3Item4.暗珊绒, 8, CT3Item4.缜相织, 1), 90f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.二级燃魂集, 2)), 12f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.暗物质, 12, CT3Item4.灵魂束缚容器, 1, CT3Item4.翠灵晶, 3, CT3Item4.珊绒, 10), 220f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.三级燃魂集, 2)), 24f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥丝, 2, CT3Item4.冥翠, 1, CT3Item4.相织物, 1), 45f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.微相织, 2)), 2f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.微相织, 2, CT3Item4.相织物, 2), 57f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.衬相织, 2)), 2f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.衬相织, 2, CT3Item4.冥织, 3, CT3Item4.粉烟, 1), 85f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.缜相织, 2)), 3f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨气集束, 2, CT3Item4.灵珠, 2), LiquidStack.with(CT3Item4.灵液4, 5), 65f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.怨灵集束, 2)), 5f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵晶, 1, CT3Item4.气光散, 2, CT3Item4.珊绒, 10), 80f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.微格晶, 1)), 4f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.赤焰膏块, 2), 120f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.赤焰膏精, 1)), 2f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.赤焰膏块, 2, CT3Item4.魂翠, 2), 120f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂集束, 1)), 2f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵魂丝, 3, CT3Item4.灵魂集束, 2), 90f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂核心, 1)), 4f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.微格晶, 1, CT3Item4.怨灵集束, 2, CT3Item4.灵魂集束, 2), 140f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂转换因子, 1)), 12f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.气丝节束, 2, CT3Item4.赤焰膏精, 2, CT3Item4.网束器, 1), 80f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂网束器, 1)), 8f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.沉珠, 4, CT3Item4.夜灵核心, 1), LiquidStack.with(CT3Item4.叹酸, 4), 160f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.夜灵珠, 1)), 6f * CT3Blocks4.T0time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.衬相织, 2, CT3Item4.魂翠, 2, CT3Item4.气光散, 2), 90f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.衬光束, 1)), 6f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.魔能晶, 8, CT3Item4.魂翠, 3), 120f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.衬光束, 1)), 6f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.衬光束, 1, CT3Item4.灵魂核心, 2), 210f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂束缚容器, 1)), 20f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.气丝节束, 4, CT3Item4.翠灵晶, 1, CT3Item4.赤焰膏块, 1), 180f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.混沌晶体, 1)), 6f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨石块, 8, CT3Item4.冥翠块, 3), 80f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.魂冲器, 1)), 15f * CT3Blocks4.T0time
            );


        }};
        资源合成台1 = new CT3_MultiCrafter("资源合成台1", 26) {{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 5;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;
            ambientSound = Sounds.electricHum;

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥翠, 1), 30f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.冥丝, 1)), 1f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥织, 2, CT3Item4.魂翠, 1), 60f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.相织物, 2)), 1f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨气集束, 3), 50f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵境, 2)), 2f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥翠, 2, CT3Item4.魂翠, 1), 40f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂丝, 2)), 1f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冤藤, 25), LiquidStack.with(CT3Item4.灵液4, 35), 60f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.硅晶体, 1)), 6f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵珠, 3, CT3Item4.硅晶体, 1), 60f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵晶, 1)), 4f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.相织物, 4, CT3Item4.灵境, 2), 65f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.魂力激发块, 1)), 2.5f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵珠, 2, CT3Item4.珊绒, 10), 25f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.一级燃魂集, 2)), 6f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.翠灵晶, 1, CT3Item4.暗珊绒, 8, CT3Item4.缜相织, 1), 90f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.二级燃魂集, 2)), 12f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.暗物质, 12, CT3Item4.灵魂束缚容器, 1, CT3Item4.翠灵晶, 3, CT3Item4.珊绒, 10), 220f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.三级燃魂集, 2)), 24f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥丝, 2, CT3Item4.冥翠, 1, CT3Item4.相织物, 1), 45f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.微相织, 2)), 2f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.微相织, 2, CT3Item4.相织物, 2), 57f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.衬相织, 2)), 2f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.衬相织, 2, CT3Item4.冥织, 3, CT3Item4.粉烟, 1), 85f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.缜相织, 2)), 3f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨气集束, 2, CT3Item4.灵珠, 2), LiquidStack.with(CT3Item4.灵液4, 5), 65f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.怨灵集束, 2)), 5f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵晶, 1, CT3Item4.气光散, 2, CT3Item4.珊绒, 10), 80f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.微格晶, 1)), 4f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.赤焰膏块, 2), 120f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.赤焰膏精, 1)), 2f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.赤焰膏块, 2, CT3Item4.魂翠, 2), 120f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂集束, 1)), 2f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵魂丝, 3, CT3Item4.灵魂集束, 2), 90f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂核心, 1)), 4f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.微格晶, 1, CT3Item4.怨灵集束, 2, CT3Item4.灵魂集束, 2), 140f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂转换因子, 1)), 12f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.气丝节束, 2, CT3Item4.赤焰膏精, 2, CT3Item4.网束器, 1), 80f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂网束器, 1)), 8f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.沉珠, 4, CT3Item4.夜灵核心, 1), LiquidStack.with(CT3Item4.叹酸, 4), 160f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.夜灵珠, 1)), 6f * CT3Blocks4.T1time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.衬相织, 2, CT3Item4.魂翠, 2, CT3Item4.气光散, 2), 90f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.衬光束, 1)), 6f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.魔能晶, 8, CT3Item4.魂翠, 3), 120f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.衬光束, 1)), 6f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.衬光束, 1, CT3Item4.灵魂核心, 2), 210f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂束缚容器, 1)), 20f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.气丝节束, 4, CT3Item4.翠灵晶, 1, CT3Item4.赤焰膏块, 1), 180f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.混沌晶体, 1)), 6f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨石块, 8, CT3Item4.冥翠块, 3), 80f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.魂冲器, 1)), 15f * CT3Blocks4.T1time
            );


        }};
        资源合成台2 = new CT3_MultiCrafter("资源合成台2", 26) {{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 4;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;
            ambientSound = Sounds.electricHum;

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥翠, 1), 30f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.冥丝, 1)), 1f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥织, 2, CT3Item4.魂翠, 1), 60f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.相织物, 2)), 1f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨气集束, 3), 50f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵境, 2)), 2f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥翠, 2, CT3Item4.魂翠, 1), 40f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂丝, 2)), 1f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冤藤, 25), LiquidStack.with(CT3Item4.灵液4, 35), 60f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.硅晶体, 1)), 6f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵珠, 3, CT3Item4.硅晶体, 1), 60f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵晶, 1)), 4f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.相织物, 4, CT3Item4.灵境, 2), 65f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.魂力激发块, 1)), 2.5f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵珠, 2, CT3Item4.珊绒, 10), 25f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.一级燃魂集, 2)), 6f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.翠灵晶, 1, CT3Item4.暗珊绒, 8, CT3Item4.缜相织, 1), 90f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.二级燃魂集, 2)), 12f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.暗物质, 12, CT3Item4.灵魂束缚容器, 1, CT3Item4.翠灵晶, 3, CT3Item4.珊绒, 10), 220f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.三级燃魂集, 2)), 24f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥丝, 2, CT3Item4.冥翠, 1, CT3Item4.相织物, 1), 45f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.微相织, 2)), 2f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.微相织, 2, CT3Item4.相织物, 2), 57f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.衬相织, 2)), 2f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.衬相织, 2, CT3Item4.冥织, 3, CT3Item4.粉烟, 1), 85f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.缜相织, 2)), 3f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨气集束, 2, CT3Item4.灵珠, 2), LiquidStack.with(CT3Item4.灵液4, 5), 65f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.怨灵集束, 2)), 5f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵晶, 1, CT3Item4.气光散, 2, CT3Item4.珊绒, 10), 80f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.微格晶, 1)), 4f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.赤焰膏块, 2), 120f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.赤焰膏精, 1)), 2f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.赤焰膏块, 2, CT3Item4.魂翠, 2), 120f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂集束, 1)), 2f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵魂丝, 3, CT3Item4.灵魂集束, 2), 90f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂核心, 1)), 4f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.微格晶, 1, CT3Item4.怨灵集束, 2, CT3Item4.灵魂集束, 2), 140f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂转换因子, 1)), 12f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.气丝节束, 2, CT3Item4.赤焰膏精, 2, CT3Item4.网束器, 1), 80f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂网束器, 1)), 8f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.沉珠, 4, CT3Item4.夜灵核心, 1), LiquidStack.with(CT3Item4.叹酸, 4), 160f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.夜灵珠, 1)), 6f * CT3Blocks4.T2time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.衬相织, 2, CT3Item4.魂翠, 2, CT3Item4.气光散, 2), 90f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.衬光束, 1)), 6f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.魔能晶, 8, CT3Item4.魂翠, 3), 120f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.衬光束, 1)), 6f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.衬光束, 1, CT3Item4.灵魂核心, 2), 210f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂束缚容器, 1)), 20f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.气丝节束, 4, CT3Item4.翠灵晶, 1, CT3Item4.赤焰膏块, 1), 180f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.混沌晶体, 1)), 6f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨石块, 8, CT3Item4.冥翠块, 3), 80f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.魂冲器, 1)), 15f * CT3Blocks4.T2time
            );


        }};
        资源合成台3 = new CT3_MultiCrafter("资源合成台3", 26) {{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 3;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;
            ambientSound = Sounds.electricHum;

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥翠, 1), 30f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.冥丝, 1)), 1f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥织, 2, CT3Item4.魂翠, 1), 60f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.相织物, 2)), 1f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨气集束, 3), 50f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵境, 2)), 2f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥翠, 2, CT3Item4.魂翠, 1), 40f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂丝, 2)), 1f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冤藤, 25), LiquidStack.with(CT3Item4.灵液4, 35), 60f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.硅晶体, 1)), 6f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵珠, 3, CT3Item4.硅晶体, 1), 60f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵晶, 1)), 4f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.相织物, 4, CT3Item4.灵境, 2), 65f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.魂力激发块, 1)), 2.5f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵珠, 2, CT3Item4.珊绒, 10), 25f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.一级燃魂集, 2)), 6f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.翠灵晶, 1, CT3Item4.暗珊绒, 8, CT3Item4.缜相织, 1), 90f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.二级燃魂集, 2)), 12f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.暗物质, 12, CT3Item4.灵魂束缚容器, 1, CT3Item4.翠灵晶, 3, CT3Item4.珊绒, 10), 220f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.三级燃魂集, 2)), 24f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥丝, 2, CT3Item4.冥翠, 1, CT3Item4.相织物, 1), 45f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.微相织, 2)), 2f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.微相织, 2, CT3Item4.相织物, 2), 57f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.衬相织, 2)), 2f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.衬相织, 2, CT3Item4.冥织, 3, CT3Item4.粉烟, 1), 85f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.缜相织, 2)), 3f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨气集束, 2, CT3Item4.灵珠, 2), LiquidStack.with(CT3Item4.灵液4, 5), 65f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.怨灵集束, 2)), 5f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵晶, 1, CT3Item4.气光散, 2, CT3Item4.珊绒, 10), 80f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.微格晶, 1)), 4f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.赤焰膏块, 2), 120f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.赤焰膏精, 1)), 2f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.赤焰膏块, 2, CT3Item4.魂翠, 2), 120f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂集束, 1)), 2f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵魂丝, 3, CT3Item4.灵魂集束, 2), 90f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂核心, 1)), 4f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.微格晶, 1, CT3Item4.怨灵集束, 2, CT3Item4.灵魂集束, 2), 140f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂转换因子, 1)), 12f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.气丝节束, 2, CT3Item4.赤焰膏精, 2, CT3Item4.网束器, 1), 80f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂网束器, 1)), 8f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.沉珠, 4, CT3Item4.夜灵核心, 1), LiquidStack.with(CT3Item4.叹酸, 4), 160f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.夜灵珠, 1)), 6f * CT3Blocks4.T3time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.衬相织, 2, CT3Item4.魂翠, 2, CT3Item4.气光散, 2), 90f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.衬光束, 1)), 6f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.魔能晶, 8, CT3Item4.魂翠, 3), 120f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.衬光束, 1)), 6f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.衬光束, 1, CT3Item4.灵魂核心, 2), 210f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵魂束缚容器, 1)), 20f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.气丝节束, 4, CT3Item4.翠灵晶, 1, CT3Item4.赤焰膏块, 1), 180f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.混沌晶体, 1)), 6f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨石块, 8, CT3Item4.冥翠块, 3), 80f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.魂冲器, 1)), 15f * CT3Blocks4.T3time
            );


            资源采集站 = new CT3_MultiCrafter("资源采集站", 3) {{
                requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
                size = 4;
                hasItems = true;
                hasPower = true;
                TableColor = Color.valueOf("78ffa5");
                allRecShow = false;
                RecipeShowIS = 6;
                attribute = YanBing;//地形限制
                minEfficiency = 0.01f;//地形限制必须-1
                baseEfficiency = 0;//地形限制必须-2

                addRecipe(
                        new CreatorsRecipe.InputContents(ItemStack.with(), 120 / 60f),
                        new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.珊绒, 3)), 1f * CT3Blocks4.T1time
                );
                addRecipe(
                        new CreatorsRecipe.InputContents(ItemStack.with(), 180 / 60f),
                        new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.烟冰, 2)), 1.5f * CT3Blocks4.T1time
                );
                addRecipe(
                        new CreatorsRecipe.InputContents(ItemStack.with(), 320 / 60f),
                        new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.暗珊绒, 2)), 60f * CT3Blocks4.T1time
                );
            }};


        }};
    }
}
