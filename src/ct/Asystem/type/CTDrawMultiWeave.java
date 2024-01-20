//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ct.Asystem.type;

import arc.Core;
import arc.graphics.Blending;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import mindustry.gen.Building;
import mindustry.world.Block;
import mindustry.world.draw.DrawBlock;
//工厂的Draw
public class CTDrawMultiWeave extends DrawBlock {
    public TextureRegion weave;

    public float rotateSpeed = 1.0F;
    public float rotateSpeed2 = -0.9F;
    public boolean fadeWeave = false;
    public Color glowColor = new Color(1.0F, 0.4F, 0.4F, 0.8F);
    public Color weaveColor;
    public float pulse;
    public float pulseScl;

    public CTDrawMultiWeave() {
        this.weaveColor = Color.white.cpy();
        this.pulse = 0.3F;
        this.pulseScl = 10.0F;
    }

    public void draw(Building build) {
        Draw.color(this.weaveColor);
        if (this.fadeWeave) {
            Draw.alpha(build.warmup());
        }

        Draw.rect(this.weave, build.x, build.y, build.totalProgress() * this.rotateSpeed);
       // Draw.rect(this.weave, build.x, build.y, build.totalProgress() * this.rotateSpeed * this.rotateSpeed2);
        Draw.blend(Blending.additive);
        Draw.color(this.glowColor, build.warmup() * this.glowColor.a * (1.0F - this.pulse + Mathf.absin(this.pulseScl, this.pulse)));
      Draw.blend();
        Draw.reset();
    }

    public TextureRegion[] icons(Block block) {
        return this.fadeWeave ? new TextureRegion[0] : new TextureRegion[]{this.weave};
    }

    public void load(Block block) {
        this.weave = Core.atlas.find(block.name + "-weave");
       }
}
