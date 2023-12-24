package ct.abe;

import ct.chapter4.XVXSource;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.meta.BuildVisibility;

public class 通用方块 {
    public static void load(){
        new XVXSource("Automatic-adaptation-source") {
            {
                this.requirements(Category.distribution, BuildVisibility.sandboxOnly, ItemStack.with(new Object[0]));
                this.alwaysUnlocked = true;
                this.localizedName = "沙盒源";
            }
        };



    }
}
