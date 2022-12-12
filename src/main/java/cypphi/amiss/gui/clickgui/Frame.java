package cypphi.amiss.gui.clickgui;

import cypphi.amiss.feature.module.ModuleCategory;
import cypphi.amiss.feature.module.ModuleManager;
import cypphi.amiss.renderer.Render2d;
import cypphi.amiss.renderer.font.FontRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.lwjgl.opengl.GL11;

import me.lto.amiss.gui.clickgui.element.ModuleButton;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Frame {

    public int x, y, width;

    public MatrixStack stack;

    public int catheight = 20;

    public int start = catheight + 4;

    private Scroll scroll;

    public int offset = 0; //22

    public int maxelems = 14; // 70

    public ModuleCategory category;

    public boolean dragging, extended = true;


    private MinecraftClient mc = MinecraftClient.getInstance();

    public List<ModuleButton> moduleButtons = new ArrayList<>();

    public Frame(int x, int y, int width, ModuleCategory category) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.category = category;

        this.stack = new MatrixStack();
        for (Module module : ModuleManager.byCategory(category)) {
            ModuleButton mb = new ModuleButton(x, (int) (y+start+offset), width, module);
            moduleButtons.add(mb);
            offset+=mb.fontrenderer.getFontHeight();
        }

        if (!moduleButtons.isEmpty()) this.scroll = new Scroll(y+start+moduleButtons.get(0).fontrenderer.getFontHeight(), moduleButtons.get(moduleButtons.toArray().length-1).y, moduleButtons);
        else this.scroll = new Scroll(y+start, y+start, null);
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta, Color color) {
        int rad = 3;
        int samples = 10;

        if (offset != 0)
            Render2d.roundedQuad(x, y, width, catheight+Math.min(offset, maxelems*moduleButtons.get(0).fontrenderer.getFontHeight()), rad, samples, new Color(0, 0, 0, 255));
        else
            Render2d.roundedQuad(x, y, width, start, rad, samples, new Color(0, 0, 0, 255));


        Identifier TEXTURE = new Identifier("amiss", "icons/" + category.getName().toLowerCase() + ".png");

        FontRenderer fontRenderer = FontRenderer.createFromID("/assets/amiss/font/abel.ttf",
                        14, false, false, false);

        fontRenderer.drawString(matrices, category.name(), x+ 30 ,y+mc.textRenderer.fontHeight-2, color.getRGB());

        new Render2d().drawTexture(matrices, TEXTURE,x + 5, y + mc.textRenderer.fontHeight - 6, 18, 18);

        renderButtons(this.stack);
    }

    public void renderButtons(MatrixStack matrices) {

        int s = (int) MinecraftClient.getInstance().getWindow().getScaleFactor();
        int u = MinecraftClient.getInstance().getWindow().getScaledHeight() - y + catheight+1;

        GL11.glEnable(GL11.GL_SCISSOR_TEST);

        if (!moduleButtons.isEmpty()) {
            int d = maxelems*moduleButtons.get(0).fontrenderer.getFontHeight();
            GL11.glScissor(x * s, u * s + 18, width * s, d * s - 18);
        }
        else
            GL11.glScissor(x * s, u * s + 18, width * s, offset * s - 18);

        matrices.push();
        
        matrices.translate(0, this.scroll.getScroll(), 0);

        for (ModuleButton mb : moduleButtons) {
            mb.render(matrices);
        }

        matrices.pop();

        GL11.glDisable(GL11.GL_SCISSOR_TEST);
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        for (ModuleButton mb : moduleButtons) {
            if (mouseX >= mb.x && mouseX <= mb.x + mb.width && mouseY >= mb.y && mouseY <= mb.y + mb.fontrenderer.getFontHeight()) {
                if (button == 0) {
                    mb.toggle();
                }
                else if (button == 1) {
                    // Settings shit
                }
            }
        }
    }

    public void mouseScrolled(double mouseX, double mouseY, double amount) {
        if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + Math.min(offset, maxelems*moduleButtons.get(0).fontrenderer.getFontHeight()) && offset > maxelems*moduleButtons.get(0).fontrenderer.getFontHeight()) {
            scroll.setScroll(amount*0.5f);
        }
    }
}
