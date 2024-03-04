package ct.Asystem.type;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Font;
import arc.math.Mathf;
import arc.scene.ui.layout.Scl;
import arc.util.Align;
import mindustry.entities.Effect;
import mindustry.entities.abilities.Ability;
import mindustry.gen.Unit;
import mindustry.graphics.Layer;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.ui.Fonts;

public class ShowShowWhatItemsInUnit extends Ability {
    ItemStack[] itemStacks;

    public ShowShowWhatItemsInUnit(ItemStack[] itemStacks) {
        this.itemStacks = itemStacks;
    }

    @Override
    public void death(Unit unit) {

        for (int i = 0; i < itemStacks.length; i++) {
            ItemStack itemStack = itemStacks[i];
            whatItemsInUnit.at(unit.x, unit.y + 8 * (i + 2), itemStack.amount, itemStack.item);
        }
    }

    public Effect whatItemsInUnit = new Effect(120, e -> {
        if (!(e.data instanceof Item item)) return;
        int amount = (int) e.rotation;
        Draw.z(Layer.flyingUnit + 1);

        float alpha;

        if (e.fin() < 0.1f) alpha = e.fin() * 10;
        else alpha = e.fout() * 10 / 9;

        Draw.color(Color.black);
        Draw.alpha(0.5f * alpha);
        Fill.rect(e.x, e.y, (Mathf.digits(amount) + 1) * 8f, 8);
        Draw.reset();

        Draw.alpha(alpha);
        Draw.rect(item.fullIcon, -Mathf.digits(amount) * 4 + e.x, e.y);

        Font font = Fonts.outline;
        font.getData().setScale(1f / 2.5f / Scl.scl(1f));
        font.setColor(1, 1, 1, alpha);
        font.draw(String.valueOf(amount), 4 + e.x, e.y + 3, Align.center);

        Draw.reset();

    });
}
