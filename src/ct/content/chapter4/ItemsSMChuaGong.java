package ct.content.chapter4;
/*化工厂*/

import arc.graphics.Color;
import ct.Asystem.type.MultiCrafter.CT3_MultiCrafter;
import ct.Asystem.type.MultiCrafter.CreatorsRecipe;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;

import static mindustry.type.ItemStack.with;

public class ItemsSMChuaGong {

    public static float T1time = 60f;
    public static float T2time = 60f / 1.9f;
    public static float p1t = 1 / 60f;
    public static float p2t = 4 / 60f;
    public static Block
            资源炼化器1, 资源炼化器2;

    public static void load() {
        资源炼化器1 = new CT3_MultiCrafter("一级资源炼化器", 7) {{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 4;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 4;
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨石, 8), LiquidStack.with(CT3Item4.恐油, 6), 40f * p1t),
                    new CreatorsRecipe.OutputContents(LiquidStack.with(CT3Item4.叹酸, 5)), 6f * T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.粉烟, 1), LiquidStack.with(CT3Item4.恐油, 3), 55f * p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.网束器, 1)), 3f * T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.网束器, 2), LiquidStack.with(CT3Item4.恐油, 2, CT3Item4.灵液4, 4), 60f * p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.硅晶体, 1)), 6f * T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.粉烟, 3), LiquidStack.with(CT3Item4.叹酸, 2), 50f * p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.气光散, 2)), 3f * T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.烟冰, 2), 50f * p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.气光散, 2, CT3Item4.珊绒, 1)), 3f * T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.气光散, 3, CT3Item4.灵珠, 1), 70f * p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.气丝节束, 2)), 4f * T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.气丝晶体, 6), 80f * p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.气丝节束, 2)), 4f * T1time
            );
        }};
        资源炼化器2 = new CT3_MultiCrafter("二级资源炼化器", 7) {{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 4;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 4;
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.怨石, 8), LiquidStack.with(CT3Item4.恐油, 6), 40f * p2t),
                    new CreatorsRecipe.OutputContents(LiquidStack.with(CT3Item4.叹酸, 5)), 6f * T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.粉烟, 1), LiquidStack.with(CT3Item4.恐油, 3), 55f * p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.网束器, 1)), 3f * T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.网束器, 2), LiquidStack.with(CT3Item4.恐油, 2, CT3Item4.灵液4, 4), 60f * p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.硅晶体, 1)), 6f * T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.粉烟, 3), LiquidStack.with(CT3Item4.叹酸, 2), 50f * p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.气光散, 2)), 3f * T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.烟冰, 2), 50f * p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.气光散, 2, CT3Item4.珊绒, 1)), 3f * T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.气光散, 3, CT3Item4.灵珠, 1), 70f * p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.气丝节束, 2)), 4f * T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.气丝晶体, 6), 80f * p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.气丝节束, 2)), 4f * T2time
            );
        }};
    }
}
