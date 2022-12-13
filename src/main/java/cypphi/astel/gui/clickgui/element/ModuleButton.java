package cypphi.astel.gui.clickgui.element;

import cypphi.astel.feature.module.Module;
import cypphi.astel.renderer.Render2d;
import cypphi.astel.renderer.font.FontRenderer;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;

public class ModuleButton {

    public int x, y, width;

    public FontRenderer fontrenderer = FontRenderer.createFromID("/assets/astel/font/abel.ttf",
            13, false, false, false);

    Module module;

    String title;

    public ModuleButton(int x, int y, int width, Module module) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.module = module;
        this.title = module.getName();
    }

    public void render(MatrixStack matrices) {
        if (module.isToggled()) {
            Render2d.drawQuad(x, y, 1, fontrenderer.getFontHeight(), new Color(0, 128, 255, 255), matrices);
        }
        fontrenderer.drawString(matrices, title, x+3,y, new Color(169, 169, 169).getRGB());
    }

    public void toggle() {
        module.toggle();
    }
}
