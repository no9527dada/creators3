package ct.content.chapter4;
/*魂矩器*/

import arc.graphics.Color;
import ct.Asystem.type.MultiCrafter.CT3_MultiCrafter;
import ct.Asystem.type.MultiCrafter.CreatorsRecipe;
import mindustry.content.Items;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;

import static mindustry.type.ItemStack.with;

public class ItemsSMChunJu {
    public static Block
            魂矩器;

    public static void load() {
        魂矩器 = new CT3_MultiCrafter("魂矩器", 6) {{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 4;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 3;
            ambientSound = Sounds.extractLoop;
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵魂丝, 1, CT3Item4.相织物, 1), 60f / 60f),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.棺炆魂矩, 1)), 3f * 60f
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.珊绒, 2, CT3Item4.气光散, 2), 120f / 60f),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.赤水魂矩, 1)), 6f * 60f
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.沉珠, 1, CT3Item4.灵晶, 1), 240f / 60f),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.止枢魂矩, 1)), 10f * 60f
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.灵魂核心, 2, CT3Item4.灵魂网束器, 1), 480f / 60f),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.绝情魂矩, 1)), 15f * 60f
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.夜灵珠, 1, CT3Item4.夜灵, 1), 960f / 60f),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.混仑魂矩, 1)), 22f * 60f
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CT3Item4.棺炆魂矩, 1, CT3Item4.赤水魂矩, 1, CT3Item4.止枢魂矩, 1, CT3Item4.绝情魂矩, 1, CT3Item4.混仑魂矩, 1, CT3Item4.暗物质, 1), 960f * 2f / 60f),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CT3Item4.灵屈魂矩, 1)), 30f * 60f
            );
        }};

    }
}
