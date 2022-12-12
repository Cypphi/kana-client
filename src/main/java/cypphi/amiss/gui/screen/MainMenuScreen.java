package cypphi.amiss.gui.screen;

import cypphi.amiss.renderer.Render2d;
import cypphi.amiss.renderer.font.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.awt.*;

public class MainMenuScreen extends Screen {
    String t;

    private final Identifier background = new Identifier("amiss", "textures/background.png");

    FontRenderer ANTON = FontRenderer.create("anton", 25, false, false, false);

    public MainMenuScreen() {
        super(Text.of("a"));
    }

    public boolean shouldPause() {
        return false;
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        Render2d.drawTexture(matrices, background, 0, 0, width, height);
        drawButton(matrices, "Singleplayer", 400);
        drawButton(matrices, "Multiplayer", 450);
        drawButton(matrices, "Realms", 500);
        super.render(matrices, mouseX, mouseY, delta);
    }

    public void drawButton(MatrixStack matrices, String s, int height) {
        Render2d.roundedQuad(width / 2 - 75,height / 2, 150, 20, 5, 10, new Color(0, 0, 0, 255));
        ANTON.drawCenteredString(matrices, s, 0, height, 0);
    }
}
