package cypphi.ammis.gui.screen.element.element;

import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;

import me.lto.amiss.renderer.Render2d;
import me.lto.amiss.renderer.font.FontRenderer;

public class Button {

    public String name;
    public int x, y, width, height;

    public Color color, background;

    public FontRenderer fontrenderer = FontRenderer.createFromID("/assets/amiss/font/abel.ttf",
            24, false, false, false);

    Runnable action;

    public Button(String name, int x, int y, int width, int height, Color color, Color background, Runnable action) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.background = background;
        this.action = action;
    }

    public void render(MatrixStack matrices) {
        Render2d.roundedQuad(x, y, width, height, 5, 17, background);
        fontrenderer.drawCenteredString(matrices, name, x+width-(width/2), y+2, color.getRGB());
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) {
            action.run();
        }
    }
}
