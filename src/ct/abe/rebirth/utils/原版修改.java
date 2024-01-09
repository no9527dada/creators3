package ct.abe.rebirth.utils;

import ct.abe.Evn2;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.Planets;
import mindustry.world.meta.Env;

import static ct.abe.rebirth.content.Items.*;

public class 原版修改 {
    public static void load() {

        Planets.erekir.hiddenItems.addAll(erekir隐藏Items).removeAll(Items.erekirItems);
        Planets.serpulo.hiddenItems.addAll(serpulo隐藏Items).removeAll(Items.serpuloItems);

 /*      Blocks.powerSource.envDisabled = Evn2.标志1 | Env.terrestrial;
        Blocks. powerVoid.envDisabled = Evn2.标志1 | Env.terrestrial;
        Blocks. itemSource.envDisabled = Evn2.标志1 | Env.terrestrial;
        Blocks.  itemVoid.envDisabled = Evn2.标志1 | Env.terrestrial;
        Blocks.  liquidSource.envDisabled = Evn2.标志1 | Env.terrestrial;
        Blocks.    liquidVoid.envDisabled = Evn2.标志1 | Env.terrestrial;*/
    }
}
