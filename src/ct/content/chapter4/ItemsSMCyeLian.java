package ct.content.chapter4;
/*冶炼台*/

import arc.graphics.Color;
import ct.Asystem.type.MultiCrafter.CT3_MultiCrafter;
import ct.Asystem.type.MultiCrafter.CreatorsRecipe;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;

import static mindustry.type.ItemStack.with;

public class ItemsSMCyeLian {
    public static Block
            资源冶炼台0, 资源冶炼台1, 资源冶炼台2, 资源冶炼台3;

    public static void load() {
        资源冶炼台0 = new CT3_MultiCrafter("资源冶炼台0", 16) {{
            requirements(Category.crafting, with());
            size = 3;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;


            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.魂石, 1), 30f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.魂翠, 1)), 1f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥石, 1), 30f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.冥翠, 1)), 1f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥石, 1), 50f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.冥织, 1)), 1.5f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨石, 2), 50f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.怨石块, 1)), 1f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨石, 3), 70f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.怨气集束, 1)), 2f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冤藤, 2), 60f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.粉烟, 1)), 2f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥翠, 5), 150f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.冥翠块, 1)), 3f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.赤焰石, 2), 90f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.赤焰膏块, 1)), 2f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冤藤, 2), 70f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.气光散, 1)), 2f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵石, 2), 110f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵珠, 1)), 2f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.戾气赤焰石, 1), 90f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.赤焰膏精, 2)), 2f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.气光散, 2), 90f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.沉珠, 1)), 2f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨石, 10), 80f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.赤焰石, 1)), 10f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.沉石, 1), 140f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.沉珠, 2)), 1.5f * CT3Blocks4.T0time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵珠, 4, CT3Item4.冥翠块, 4), LiquidStack.with(CT3Item4.叹酸, 8), 180f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.翠灵晶, 4)), 12f * CT3Blocks4.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵魂核心, 2, CT3Item4.灵魂转换因子, 2), 120f * CT3Blocks4.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.夜灵, 1)), 6f * CT3Blocks4.T0time
            );
        }};
        资源冶炼台1 = new CT3_MultiCrafter("资源冶炼台1", 16) {{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 5;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;


            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.魂石, 1), 30f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.魂翠, 1)), 1f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥石, 1), 30f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.冥翠, 1)), 1f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥石, 1), 50f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.冥织, 1)), 1.5f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨石, 2), 50f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.怨石块, 1)), 1f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨石, 3), 70f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.怨气集束, 1)), 2f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冤藤, 2), 60f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.粉烟, 1)), 2f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥翠, 5), 150f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.冥翠块, 1)), 3f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.赤焰石, 2), 90f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.赤焰膏块, 1)), 2f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冤藤, 2), 70f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.气光散, 1)), 2f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵石, 2), 110f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵珠, 1)), 2f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.戾气赤焰石, 1), 90f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.赤焰膏精, 2)), 2f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.气光散, 2), 90f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.沉珠, 1)), 2f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨石, 10), 80f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.赤焰石, 1)), 10f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.沉石, 1), 140f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.沉珠, 2)), 1.5f * CT3Blocks4.T1time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵珠, 4, CT3Item4.冥翠块, 4), LiquidStack.with(CT3Item4.叹酸, 8), 180f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.翠灵晶, 4)), 12f * CT3Blocks4.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵魂核心, 2, CT3Item4.灵魂转换因子, 2), 120f * CT3Blocks4.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.夜灵, 1)), 6f * CT3Blocks4.T1time
            );
        }};
        资源冶炼台2 = new CT3_MultiCrafter("资源冶炼台2", 16) {{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 4;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;


            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.魂石, 1), 30f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.魂翠, 1)), 1f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥石, 1), 30f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.冥翠, 1)), 1f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥石, 1), 50f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.冥织, 1)), 1.5f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨石, 2), 50f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.怨石块, 1)), 1f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨石, 3), 70f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.怨气集束, 1)), 2f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冤藤, 2), 60f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.粉烟, 1)), 2f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥翠, 5), 150f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.冥翠块, 1)), 3f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.赤焰石, 2), 90f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.赤焰膏块, 1)), 2f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冤藤, 2), 70f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.气光散, 1)), 2f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵石, 2), 110f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵珠, 1)), 2f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.戾气赤焰石, 1), 90f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.赤焰膏精, 2)), 2f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.气光散, 2), 90f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.沉珠, 1)), 2f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨石, 10), 80f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.赤焰石, 1)), 10f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.沉石, 1), 140f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.沉珠, 2)), 1.5f * CT3Blocks4.T2time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵珠, 4, CT3Item4.冥翠块, 4), LiquidStack.with(CT3Item4.叹酸, 8), 180f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.翠灵晶, 4)), 12f * CT3Blocks4.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵魂核心, 2, CT3Item4.灵魂转换因子, 2), 120f * CT3Blocks4.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.夜灵, 1)), 6f * CT3Blocks4.T2time
            );
        }};
        资源冶炼台3 = new CT3_MultiCrafter("资源冶炼台3", 16) {{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 3;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;


            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.魂石, 1), 30f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.魂翠, 1)), 1f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥石, 1), 30f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.冥翠, 1)), 1f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥石, 1), 50f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.冥织, 1)), 1.5f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨石, 2), 50f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.怨石块, 1)), 1f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨石, 3), 70f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.怨气集束, 1)), 2f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冤藤, 2), 60f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.粉烟, 1)), 2f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冥翠, 5), 150f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.冥翠块, 1)), 3f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.赤焰石, 2), 90f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.赤焰膏块, 1)), 2f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.冤藤, 2), 70f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.气光散, 1)), 2f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵石, 2), 110f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵珠, 1)), 2f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.戾气赤焰石, 1), 90f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.赤焰膏精, 2)), 2f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.气光散, 2), 90f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.沉珠, 1)), 2f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨石, 10), 80f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.赤焰石, 1)), 10f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.沉石, 1), 140f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.沉珠, 2)), 1.5f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵珠, 4, CT3Item4.冥翠块, 4), LiquidStack.with(CT3Item4.叹酸, 8), 180f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.翠灵晶, 4)), 12f * CT3Blocks4.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵魂核心, 2, CT3Item4.灵魂转换因子, 2), 120f * CT3Blocks4.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.夜灵, 1)), 6f * CT3Blocks4.T3time
            );
        }};
    }
}
