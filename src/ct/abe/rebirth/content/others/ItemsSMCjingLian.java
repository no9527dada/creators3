package ct.abe.rebirth.content.others;
/*精炼台*///废弃方案

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

public class ItemsSMCjingLian {
    public static Block
            资源精炼台;

    public static void load() {
        资源精炼台 = new CreatorsMultiCrafter("资源精炼台", 2) {{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 6;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;
// LiquidStack.with(叹酸, 8),
            addRecipe(
                    new CreatorsRecipe.InputContents(LiquidStack.with(黑油, 4), 150f / 60f),
                    new CreatorsRecipe.OutputContents(ItemStack.with(珊绒, 1), LiquidStack.with(恐油, 2)), 4f * 60f
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(珊绒, 2), LiquidStack.with(恐油, 1), 100f / 60f),
                    new CreatorsRecipe.OutputContents(ItemStack.with(珊绒, 3, 粉烟, 1)), 4f * 60f
            );

        }};
    }
}
