package ct.chapter4;
/*魂矩器*/
import arc.graphics.Color;
import ct.type.CreatorsMultiCrafter;
import ct.type.CreatorsRecipe;
import mindustry.content.Items;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;

import static mindustry.type.ItemStack.with;

public class ItemsSMChunJu {
    public static Block
            魂矩器;

    public static void load(){
        魂矩器= new CreatorsMultiCrafter("魂矩器",6){{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 4;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 3;
            ambientSound = Sounds.extractLoop;
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵魂丝, 1, CTItem.相织物,1), 60f/60f),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.棺炆魂矩, 1)), 3f*60f
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.珊绒, 2, CTItem.气光散,2), 120f/60f),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.赤水魂矩, 1)), 6f*60f
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.沉珠, 1, CTItem.灵晶,1), 240f/60f),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.止枢魂矩, 1)), 10f*60f
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵魂核心, 2, CTItem.灵魂网束器,1), 480f/60f),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.绝情魂矩, 1)), 15f*60f
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.夜灵珠, 1, CTItem.夜灵,1), 960f/60f),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.混仑魂矩, 1)), 22f*60f
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.棺炆魂矩, 1, CTItem.赤水魂矩, 1, CTItem.止枢魂矩, 1, CTItem.绝情魂矩, 1, CTItem.混仑魂矩, 1, CTItem.暗物质,1), 960f*2f/60f),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵屈魂矩, 1)), 30f*60f
            );
        }};

    }
}
