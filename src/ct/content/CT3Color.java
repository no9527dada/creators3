package ct.content;

import arc.graphics.Color;

import static arc.util.serialization.Jval.Jtype.string;

public class CT3Color {
    public static Color
            颜色;

    public static void load() {
        颜色 = Color.valueOf(String.valueOf(string));
    }
}
