package ct.abe.rebirth.content.others;
/*冶炼台*/
import arc.graphics.Color;
import ct.type.CreatorsMultiCrafter;
import ct.type.CreatorsRecipe;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;

import static ct.abe.rebirth.content.Items.*;
import static mindustry.type.ItemStack.with;
import static ct.abe.rebirth.content.Blocks.*;
public class ItemsSMCyeLian {
    public static Block
    资源冶炼台0,  资源冶炼台1, 资源冶炼台2,资源冶炼台3;

    public static void load(){
        资源冶炼台0 = new CreatorsMultiCrafter("资源冶炼台0",16){{
            requirements(Category.crafting, with());
            size = 3;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;


            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(魂石, 1), 30f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(魂翠, 1)), 1f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥石, 1), 30f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(冥翠, 1)), 1f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥石, 1), 50f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(冥织, 1)), 1.5f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨石, 2), 50f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(怨石块, 1)), 1f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨石, 3), 70f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(怨气集束, 1)), 2f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冤藤, 2), 60f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(粉烟, 1)), 2f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥翠, 5), 150f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(冥翠块, 1)), 3f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(赤焰石, 2), 90f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(赤焰膏块, 1)), 2f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冤藤, 2), 70f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(气光散, 1)), 2f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵石, 2), 110f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵珠, 1)), 2f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(戾气赤焰石, 1), 90f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(赤焰膏精, 2)), 2f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(气光散, 2), 90f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(沉珠, 1)), 2f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨石, 10), 80f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(赤焰石, 1)), 10f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(沉石, 1), 140f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(沉珠, 2)), 1.5f* T0time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵珠, 4, 冥翠块,4), LiquidStack.with(叹酸, 8),180f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(翠灵晶, 4)), 12f* T0time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵魂核心, 2, 灵魂转换因子, 2),120f* p0t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(夜灵, 1)), 6f* T0time
            );
        }};
        资源冶炼台1 = new CreatorsMultiCrafter("资源冶炼台1",16){{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 5;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;


            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(魂石, 1), 30f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(魂翠, 1)), 1f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥石, 1), 30f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(冥翠, 1)), 1f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥石, 1), 50f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(冥织, 1)), 1.5f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨石, 2), 50f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(怨石块, 1)), 1f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨石, 3), 70f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(怨气集束, 1)), 2f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冤藤, 2), 60f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(粉烟, 1)), 2f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥翠, 5), 150f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(冥翠块, 1)), 3f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(赤焰石, 2), 90f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(赤焰膏块, 1)), 2f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冤藤, 2), 70f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(气光散, 1)), 2f* T1time
            );
            addRecipe(
            new CreatorsRecipe.InputContents(ItemStack.with(灵石, 2), 110f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵珠, 1)), 2f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(戾气赤焰石, 1), 90f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(赤焰膏精, 2)), 2f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(气光散, 2), 90f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(沉珠, 1)), 2f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨石, 10), 80f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(赤焰石, 1)), 10f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(沉石, 1), 140f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(沉珠, 2)), 1.5f* T1time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵珠, 4, 冥翠块,4), LiquidStack.with(叹酸, 8),180f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(翠灵晶, 4)), 12f* T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵魂核心, 2, 灵魂转换因子, 2),120f* p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(夜灵, 1)), 6f* T1time
            );
        }};
        资源冶炼台2 = new CreatorsMultiCrafter("资源冶炼台2",16){{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 4;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;


            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(魂石, 1), 30f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(魂翠, 1)), 1f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥石, 1), 30f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(冥翠, 1)), 1f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥石, 1), 50f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(冥织, 1)), 1.5f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨石, 2), 50f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(怨石块, 1)), 1f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨石, 3), 70f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(怨气集束, 1)), 2f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冤藤, 2), 60f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(粉烟, 1)), 2f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥翠, 5), 150f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(冥翠块, 1)), 3f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(赤焰石, 2), 90f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(赤焰膏块, 1)), 2f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冤藤, 2), 70f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(气光散, 1)), 2f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵石, 2), 110f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵珠, 1)), 2f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(戾气赤焰石, 1), 90f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(赤焰膏精, 2)), 2f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(气光散, 2), 90f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(沉珠, 1)), 2f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨石, 10), 80f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(赤焰石, 1)), 10f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(沉石, 1), 140f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(沉珠, 2)), 1.5f* T2time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵珠, 4, 冥翠块,4), LiquidStack.with(叹酸, 8),180f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(翠灵晶, 4)), 12f* T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵魂核心, 2, 灵魂转换因子, 2),120f* p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(夜灵, 1)), 6f* T2time
            );
        }};
        资源冶炼台3 = new CreatorsMultiCrafter("资源冶炼台3",16){{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 3;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;


            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(魂石, 1), 30f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(魂翠, 1)), 1f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥石, 1), 30f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(冥翠, 1)), 1f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥石, 1), 50f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(冥织, 1)), 1.5f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨石, 2), 50f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(怨石块, 1)), 1f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨石, 3), 70f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(怨气集束, 1)), 2f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冤藤, 2), 60f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(粉烟, 1)), 2f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冥翠, 5), 150f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(冥翠块, 1)), 3f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(赤焰石, 2), 90f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(赤焰膏块, 1)), 2f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(冤藤, 2), 70f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(气光散, 1)), 2f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵石, 2), 110f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(灵珠, 1)), 2f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(戾气赤焰石, 1), 90f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(赤焰膏精, 2)), 2f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(气光散, 2), 90f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(沉珠, 1)), 2f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(怨石, 10), 80f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(赤焰石, 1)), 10f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(沉石, 1), 140f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(沉珠, 2)), 1.5f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵珠, 4, 冥翠块,4), LiquidStack.with(叹酸, 8),180f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(翠灵晶, 4)), 12f* T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(灵魂核心, 2, 灵魂转换因子, 2),120f* p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(夜灵, 1)), 6f* T3time
            );
        }};
    }
}
