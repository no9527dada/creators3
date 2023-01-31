package ctrebirth.content;
/*合成台*/
import arc.graphics.Color;
import ctrebirth.type.CreatorsMultiCrafter;
import ctrebirth.type.CreatorsRecipe;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;

import static mindustry.type.ItemStack.with;

public class ItemsSMC {
    public static Block
            资源合成台1, 资源合成台2,资源合成台3,资源采集站;

    public static void load(){
        资源合成台1 = new CreatorsMultiCrafter("资源合成台1",27){{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 5;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;


            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥翠, 1), 30f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.冥丝, 1)), 1f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥织, 2, CTItem.魂翠,1), 60f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.相织物, 2)), 1f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨气集束, 3), 50f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵境, 2)), 2f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥翠, 2, CTItem.魂翠,1), 40f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵魂丝, 2)), 1f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冤藤, 25), LiquidStack.with(CTItem.灵液, 35), 60f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.硅晶体, 1)), 6f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵珠, 3, CTItem.硅晶体,1),  60f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵晶, 1)), 4f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.相织物, 4, CTItem.灵境,2),  65f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.魂力激发块, 1)), 2.5f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵珠, 2, CTItem.珊绒,10),  25f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.一级燃魂集, 2)), 6f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.翠灵晶, 1, CTItem.暗珊绒,8, CTItem.缜相织,1),  90f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.二级燃魂集, 2)), 12f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.暗物质, 12, CTItem.灵魂束缚容器,1, CTItem.翠灵晶, 3, CTItem.珊绒,10),  220f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.三级燃魂集, 2)), 24f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥丝, 2, CTItem.冥翠,1, CTItem.相织物,1),  45f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.微相织, 2)), 2f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.微相织, 2, CTItem.相织物,2),  57f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.衬相织, 2)), 2f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.衬相织, 2, CTItem.冥织,3, CTItem.烟粉,1),  85f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.缜相织, 2)), 3f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨气集束, 2, CTItem.灵珠, 2), LiquidStack.with(CTItem.灵液, 5),  65f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.怨灵集束, 2)), 5f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵晶, 1, CTItem.气光散, 2, CTItem.珊绒,10),80f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.微格晶, 1)), 4f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.赤焰膏块, 2), 120f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.赤焰膏精, 1)), 2f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.赤焰膏块, 2, CTItem.魂翠, 2), 120f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵魂集束, 1)), 2f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵魂丝, 3, CTItem.灵魂集束,2),90f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵魂核心, 1)), 4f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.微格晶, 1, CTItem.怨灵集束, 2, CTItem.灵魂集束,2),140f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵魂转换因子, 1)), 12f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵魂核心, 2, CTItem.灵魂转换因子, 2),120f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.夜灵, 1)), 6f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.气丝节束, 2, CTItem.赤焰膏精, 2, CTItem.网束器, 1),80f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵魂网束器, 1)), 8f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.沉珠, 4, CTItem.夜灵核心, 1),LiquidStack.with(CTItem.叹酸, 4),160f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.夜灵珠, 1)), 6f* CTBlocks.T1time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.衬相织, 2, CTItem.魂翠, 2, CTItem.气光散,2),90f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.衬光束, 1)), 6f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.魔能晶, 8, CTItem.魂翠, 3),120f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.衬光束, 1)), 6f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.衬光束, 1, CTItem.灵魂核心, 2),210f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵魂束缚容器, 1)), 20f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.气丝节束, 4, CTItem.翠灵晶,1, CTItem.赤焰膏块, 1),180f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.混沌晶体, 1)), 6f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨石块, 8, CTItem.冥翠块, 3),80f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.魂冲器, 1)), 15f* CTBlocks.T1time
            );























        }};
        资源合成台2 = new CreatorsMultiCrafter("资源合成台2",27){{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 4;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;


            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥翠, 1), 30f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.冥丝, 1)), 1f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥织, 2, CTItem.魂翠,1), 60f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.相织物, 2)), 1f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨气集束, 3), 50f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵境, 2)), 2f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥翠, 2, CTItem.魂翠,1), 40f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵魂丝, 2)), 1f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冤藤, 25), LiquidStack.with(CTItem.灵液, 35), 60f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.硅晶体, 1)), 6f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵珠, 3, CTItem.硅晶体,1),  60f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵晶, 1)), 4f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.相织物, 4, CTItem.灵境,2),  65f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.魂力激发块, 1)), 2.5f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵珠, 2, CTItem.珊绒,10),  25f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.一级燃魂集, 2)), 6f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.翠灵晶, 1, CTItem.暗珊绒,8, CTItem.缜相织,1),  90f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.二级燃魂集, 2)), 12f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.暗物质, 12, CTItem.灵魂束缚容器,1, CTItem.翠灵晶, 3, CTItem.珊绒,10),  220f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.三级燃魂集, 2)), 24f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥丝, 2, CTItem.冥翠,1, CTItem.相织物,1),  45f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.微相织, 2)), 2f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.微相织, 2, CTItem.相织物,2),  57f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.衬相织, 2)), 2f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.衬相织, 2, CTItem.冥织,3, CTItem.烟粉,1),  85f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.缜相织, 2)), 3f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨气集束, 2, CTItem.灵珠, 2), LiquidStack.with(CTItem.灵液, 5),  65f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.怨灵集束, 2)), 5f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵晶, 1, CTItem.气光散, 2, CTItem.珊绒,10),80f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.微格晶, 1)), 4f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.赤焰膏块, 2), 120f* CTBlocks.p1t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.赤焰膏精, 1)), 2f* CTBlocks.T1time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.赤焰膏块, 2, CTItem.魂翠, 2), 120f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵魂集束, 1)), 2f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵魂丝, 3, CTItem.灵魂集束,2),90f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵魂核心, 1)), 4f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.微格晶, 1, CTItem.怨灵集束, 2, CTItem.灵魂集束,2),140f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵魂转换因子, 1)), 12f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵魂核心, 2, CTItem.灵魂转换因子, 2),120f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.夜灵, 1)), 6f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.气丝节束, 2, CTItem.赤焰膏精, 2, CTItem.网束器, 1),80f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵魂网束器, 1)), 8f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.沉珠, 4, CTItem.夜灵核心, 1),LiquidStack.with(CTItem.叹酸, 4),160f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.夜灵珠, 1)), 6f* CTBlocks.T2time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.衬相织, 2, CTItem.魂翠, 2, CTItem.气光散,2),90f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.衬光束, 1)), 6f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.魔能晶, 8, CTItem.魂翠, 3),120f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.衬光束, 1)), 6f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.衬光束, 1, CTItem.灵魂核心, 2),210f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵魂束缚容器, 1)), 20f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.气丝节束, 4, CTItem.翠灵晶,1, CTItem.赤焰膏块, 1),180f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.混沌晶体, 1)), 6f* CTBlocks.T2time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨石块, 8, CTItem.冥翠块, 3),80f* CTBlocks.p2t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.魂冲器, 1)), 15f* CTBlocks.T2time
            );























        }};
        资源合成台3 = new CreatorsMultiCrafter("资源合成台3",27){{
            requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
            size = 3;
            hasItems = true;
            hasPower = true;
            TableColor = Color.valueOf("78ffa5");
            allRecShow = false;
            RecipeShowIS = 6;


            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥翠, 1), 30f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.冥丝, 1)), 1f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥织, 2, CTItem.魂翠,1), 60f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.相织物, 2)), 1f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨气集束, 3), 50f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵境, 2)), 2f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥翠, 2, CTItem.魂翠,1), 40f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵魂丝, 2)), 1f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冤藤, 25), LiquidStack.with(CTItem.灵液, 35), 60f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.硅晶体, 1)), 6f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵珠, 3, CTItem.硅晶体,1),  60f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵晶, 1)), 4f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.相织物, 4, CTItem.灵境,2),  65f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.魂力激发块, 1)), 2.5f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵珠, 2, CTItem.珊绒,10),  25f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.一级燃魂集, 2)), 6f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.翠灵晶, 1, CTItem.暗珊绒,8, CTItem.缜相织,1),  90f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.二级燃魂集, 2)), 12f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.暗物质, 12, CTItem.灵魂束缚容器,1, CTItem.翠灵晶, 3, CTItem.珊绒,10),  220f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.三级燃魂集, 2)), 24f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.冥丝, 2, CTItem.冥翠,1, CTItem.相织物,1),  45f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.微相织, 2)), 2f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.微相织, 2, CTItem.相织物,2),  57f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.衬相织, 2)), 2f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.衬相织, 2, CTItem.冥织,3, CTItem.烟粉,1),  85f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.缜相织, 2)), 3f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨气集束, 2, CTItem.灵珠, 2), LiquidStack.with(CTItem.灵液, 5),  65f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.怨灵集束, 2)), 5f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵晶, 1, CTItem.气光散, 2, CTItem.珊绒,10),80f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.微格晶, 1)), 4f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.赤焰膏块, 2), 120f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.赤焰膏精, 1)), 2f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.赤焰膏块, 2, CTItem.魂翠, 2), 120f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵魂集束, 1)), 2f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵魂丝, 3, CTItem.灵魂集束,2),90f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵魂核心, 1)), 4f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.微格晶, 1, CTItem.怨灵集束, 2, CTItem.灵魂集束,2),140f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵魂转换因子, 1)), 12f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.灵魂核心, 2, CTItem.灵魂转换因子, 2),120f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.夜灵, 1)), 6f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.气丝节束, 2, CTItem.赤焰膏精, 2, CTItem.网束器, 1),80f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵魂网束器, 1)), 8f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.沉珠, 4, CTItem.夜灵核心, 1),LiquidStack.with(CTItem.叹酸, 4),160f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.夜灵珠, 1)), 6f* CTBlocks.T3time
            );

            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.衬相织, 2, CTItem.魂翠, 2, CTItem.气光散,2),90f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.衬光束, 1)), 6f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.魔能晶, 8, CTItem.魂翠, 3),120f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.衬光束, 1)), 6f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.衬光束, 1, CTItem.灵魂核心, 2),210f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.灵魂束缚容器, 1)), 20f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.气丝节束, 4, CTItem.翠灵晶,1, CTItem.赤焰膏块, 1),180f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.混沌晶体, 1)), 6f* CTBlocks.T3time
            );
            addRecipe(
                    new CreatorsRecipe.InputContents(ItemStack.with(CTItem.怨石块, 8, CTItem.冥翠块, 3),80f* CTBlocks.p3t),
                    new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.魂冲器, 1)), 15f* CTBlocks.T3time
            );



            资源采集站 = new CreatorsMultiCrafter("资源采集站",3){{
                requirements(Category.crafting, with(Items.copper, 50, Items.lead, 25));
                size = 4;
                hasItems = true;
                hasPower = true;
                TableColor = Color.valueOf("78ffa5");
                allRecShow = false;
                RecipeShowIS = 6;
                attribute = CTAttribute.YanBing;//地形限制
                minEfficiency = 0.01f;//地形限制必须-1
                baseEfficiency=0;//地形限制必须-2

                addRecipe(
                        new CreatorsRecipe.InputContents(ItemStack.with(), 120/60f),
                        new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.珊绒, 3)), 1f* CTBlocks.T1time
                );
                addRecipe(
                        new CreatorsRecipe.InputContents(ItemStack.with(), 180/60f),
                        new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.烟冰, 2)), 1.5f* CTBlocks.T1time
                );
                addRecipe(
                        new CreatorsRecipe.InputContents(ItemStack.with(), 320/60f),
                        new CreatorsRecipe.OutputContents(ItemStack.with(CTItem.暗珊绒, 2)), 60f* CTBlocks.T1time
                );
             }};



















        }};
    }
}
