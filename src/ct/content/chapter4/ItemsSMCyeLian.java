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
    资源冶炼台0,  资源冶炼台1, 资源冶炼台2,资源冶炼台3;

    public static void load(){
        资源冶炼台0 = new CT3_MultiCrafter("资源冶炼台0", 16) {{
            requirements(Category.crafting, with());
            size = 3;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;


            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.魂石, 1), 30f * CTBlocks.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.魂翠, 1)), 1f * CTBlocks.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥石, 1), 30f * CTBlocks.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.冥翠, 1)), 1f * CTBlocks.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥石, 1), 50f * CTBlocks.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.冥织, 1)), 1.5f * CTBlocks.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨石, 2), 50f * CTBlocks.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.怨石块, 1)), 1f * CTBlocks.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨石, 3), 70f * CTBlocks.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.怨气集束, 1)), 2f * CTBlocks.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冤藤, 2), 60f * CTBlocks.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.粉烟, 1)), 2f * CTBlocks.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥翠, 5), 150f * CTBlocks.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.冥翠块, 1)), 3f * CTBlocks.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.赤焰石, 2), 90f * CTBlocks.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.赤焰膏块, 1)), 2f * CTBlocks.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冤藤, 2), 70f * CTBlocks.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.气光散, 1)), 2f * CTBlocks.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵石, 2), 110f * CTBlocks.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵珠, 1)), 2f * CTBlocks.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.戾气赤焰石, 1), 90f * CTBlocks.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.赤焰膏精, 2)), 2f * CTBlocks.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.气光散, 2), 90f * CTBlocks.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.沉珠, 1)), 2f * CTBlocks.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨石, 10), 80f * CTBlocks.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.赤焰石, 1)), 10f * CTBlocks.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.沉石, 1), 140f * CTBlocks.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.沉珠, 2)), 1.5f * CTBlocks.T0time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵珠, 4, CTItem.冥翠块, 4), LiquidStack.with(CTItem.叹酸, 8), 180f * CTBlocks.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.翠灵晶, 4)), 12f * CTBlocks.T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵魂核心, 2, CTItem.灵魂转换因子, 2), 120f * CTBlocks.p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.夜灵, 1)), 6f * CTBlocks.T0time
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
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.魂石, 1), 30f * CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.魂翠, 1)), 1f * CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥石, 1), 30f * CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.冥翠, 1)), 1f * CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥石, 1), 50f * CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.冥织, 1)), 1.5f * CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨石, 2), 50f * CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.怨石块, 1)), 1f * CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨石, 3), 70f * CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.怨气集束, 1)), 2f * CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冤藤, 2), 60f * CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.粉烟, 1)), 2f * CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥翠, 5), 150f * CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.冥翠块, 1)), 3f * CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.赤焰石, 2), 90f * CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.赤焰膏块, 1)), 2f * CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冤藤, 2), 70f * CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.气光散, 1)), 2f * CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵石, 2), 110f * CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵珠, 1)), 2f * CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.戾气赤焰石, 1), 90f * CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.赤焰膏精, 2)), 2f * CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.气光散, 2), 90f * CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.沉珠, 1)), 2f * CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨石, 10), 80f * CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.赤焰石, 1)), 10f * CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.沉石, 1), 140f * CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.沉珠, 2)), 1.5f * CTBlocks.T1time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵珠, 4, CTItem.冥翠块, 4), LiquidStack.with(CTItem.叹酸, 8), 180f * CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.翠灵晶, 4)), 12f * CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵魂核心, 2, CTItem.灵魂转换因子, 2), 120f * CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.夜灵, 1)), 6f * CTBlocks.T1time
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
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.魂石, 1), 30f * CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.魂翠, 1)), 1f * CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥石, 1), 30f * CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.冥翠, 1)), 1f * CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥石, 1), 50f * CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.冥织, 1)), 1.5f * CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨石, 2), 50f * CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.怨石块, 1)), 1f * CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨石, 3), 70f * CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.怨气集束, 1)), 2f * CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冤藤, 2), 60f * CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.粉烟, 1)), 2f * CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥翠, 5), 150f * CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.冥翠块, 1)), 3f * CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.赤焰石, 2), 90f * CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.赤焰膏块, 1)), 2f * CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冤藤, 2), 70f * CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.气光散, 1)), 2f * CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵石, 2), 110f * CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵珠, 1)), 2f * CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.戾气赤焰石, 1), 90f * CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.赤焰膏精, 2)), 2f * CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.气光散, 2), 90f * CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.沉珠, 1)), 2f * CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨石, 10), 80f * CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.赤焰石, 1)), 10f * CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.沉石, 1), 140f * CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.沉珠, 2)), 1.5f * CTBlocks.T2time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵珠, 4, CTItem.冥翠块, 4), LiquidStack.with(CTItem.叹酸, 8), 180f * CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.翠灵晶, 4)), 12f * CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵魂核心, 2, CTItem.灵魂转换因子, 2), 120f * CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.夜灵, 1)), 6f * CTBlocks.T2time
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
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.魂石, 1), 30f * CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.魂翠, 1)), 1f * CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥石, 1), 30f * CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.冥翠, 1)), 1f * CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥石, 1), 50f * CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.冥织, 1)), 1.5f * CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨石, 2), 50f * CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.怨石块, 1)), 1f * CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨石, 3), 70f * CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.怨气集束, 1)), 2f * CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冤藤, 2), 60f * CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.粉烟, 1)), 2f * CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥翠, 5), 150f * CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.冥翠块, 1)), 3f * CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.赤焰石, 2), 90f * CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.赤焰膏块, 1)), 2f * CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冤藤, 2), 70f * CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.气光散, 1)), 2f * CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵石, 2), 110f * CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵珠, 1)), 2f * CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.戾气赤焰石, 1), 90f * CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.赤焰膏精, 2)), 2f * CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.气光散, 2), 90f * CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.沉珠, 1)), 2f * CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨石, 10), 80f * CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.赤焰石, 1)), 10f * CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.沉石, 1), 140f * CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.沉珠, 2)), 1.5f * CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵珠, 4, CTItem.冥翠块, 4), LiquidStack.with(CTItem.叹酸, 8), 180f * CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.翠灵晶, 4)), 12f * CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵魂核心, 2, CTItem.灵魂转换因子, 2), 120f * CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.夜灵, 1)), 6f * CTBlocks.T3time
            );
        }};
    }
}
