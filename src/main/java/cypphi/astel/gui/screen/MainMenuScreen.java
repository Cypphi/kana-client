package cypphi.astel.gui.screen;

import cypphi.astel.AstelClient;
import cypphi.astel.renderer.Render2d;
import cypphi.astel.renderer.font.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

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

        int width = AstelClient.mc.getWindow().getScaledWidth();
        int height = AstelClient.mc.getWindow().getScaledHeight();

        int x = width/2;
        int y = height/2;
        int buttonwidth = 66;
        int buttonheight = FontRenderer.createFromID("/assets/astel/font/abel.ttf",
                24, false, false, false).getFontHeight()+4;

        //buttons.add(new Button("Singleplayer", x-buttonwidth-1 , y-2, buttonwidth, buttonheight+2, new Color(182, 187, 190), new Color(0, 0, 0, 255), () -> {MinecraftClient.getInstance().setScreen(new SelectWorldScreen(this));}));

        super.render(matrices, mouseX, mouseY, delta);
    }
}
