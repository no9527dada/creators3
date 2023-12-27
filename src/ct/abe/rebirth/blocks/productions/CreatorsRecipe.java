package ct.abe.rebirth.blocks.productions;
//多合成前置 1/2
import arc.graphics.Color;
import arc.scene.ui.ImageButton;
import arc.scene.ui.ScrollPane;
import mindustry.gen.Tex;
import mindustry.type.*;
import mindustry.ui.Styles;

import static mindustry.type.ItemStack.*;
import static mindustry.ui.Styles.flatOver;

public class CreatorsRecipe{
    public final InputContents input;
    public final OutputContents output;
    public final float craftTime;

    public CreatorsRecipe(InputContents input, OutputContents output, float craftTime){
        this.input = input;
        this.output = output;
        this.craftTime = craftTime;
    }

    public static class InputContents{
        public final ItemStack[] items;
        public final LiquidStack[] liquids;
        public final float power;

        public InputContents(ItemStack[] items, LiquidStack[] liquids, float power){
            this.items = items;
            this.liquids = liquids;
            this.power = power;
        }

        public InputContents(ItemStack[] items, float power){
            this(items, new LiquidStack[]{}, power);
        }

        public InputContents(LiquidStack[] liquids, float power){
            this(with(), liquids, power);
        }

        public InputContents(ItemStack[] items, LiquidStack[] liquids){
            this(items, liquids, 0f);
        }

        public InputContents(ItemStack[] items){
            this(items, 0f);
        }

        public InputContents(LiquidStack[] liquids){
            this(liquids, 0f);
        }

        public InputContents(float power){
            this(with(), power);
        }

        public InputContents(){
            this(0f);
        }
    }

    public static class OutputContents{
        public final ItemStack[] items;
        public final LiquidStack[] liquids;
        public final float power;

        public OutputContents(ItemStack[] items, LiquidStack[] liquids, float power){
            this.items = items;
            this.liquids = liquids;
            this.power = power;
        }

        public OutputContents(ItemStack[] items, float power){
            this(items, new LiquidStack[]{}, power);
        }

        public OutputContents(LiquidStack[] liquids, float power){
            this(with(), liquids, power);
        }

        public OutputContents(ItemStack[] items, LiquidStack[] liquids){
            this(items, liquids, 0f);
        }

        public OutputContents(ItemStack[] items){
            this(items, 0f);
        }

        public OutputContents(LiquidStack[] liquids){
            this(liquids, 0f);
        }

        public OutputContents(float power){
            this(with(), power);
        }

        public OutputContents(){
            this(0f);
        }
    }
    public static ImageButton.ImageButtonStyle clearToggleTransi = new ImageButton.ImageButtonStyle(){{
        down = Styles.flatDown;
        checked = Styles.flatDown;
        up = Styles.black6;
        over = flatOver;
    }};

    public static ImageButton.ImageButtonStyle clearTogglei = new ImageButton.ImageButtonStyle(){{
        down = Styles.flatDown;
        checked = Styles.flatDown;
        up = Styles.black;
        over = flatOver;
    }};
    public static ScrollPane.ScrollPaneStyle smallPane = new ScrollPane.ScrollPaneStyle(){{
        vScroll = Tex.clear;
        vScrollKnob = Tex.scrollKnobVerticalThin;
    }};

    public static ImageButton.ImageButtonStyle clearTransi = new ImageButton.ImageButtonStyle(){{
        down = Styles.flatDown;
        up = Styles.black6;
        over = flatOver;
        disabled = Styles.black8;
        imageDisabledColor = Color.lightGray;
        imageUpColor = Color.white;
    }};
}