package cypphi.amiss.gui.screen;

import cypphi.amiss.AmissClient;
import cypphi.amiss.renderer.Render2d;
import cypphi.amiss.renderer.font.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MainMenuScreen extends Screen {

    String t;

    private final Identifier background = new Identifier("amiss", "textures/background.png");

    FontRenderer ANTON = FontRenderer.create("anton", 25, false, false, false);

//    private static final Identifier PANORAMA_OVERLAY = new Identifier("textures/gui/title/background/panorama_overlay.png");

//    public static final CubeMapRenderer PANORAMA_CUBE_MAP = new CubeMapRenderer(new Identifier("textures/gui/title/background/panorama"));

//    private final RotatingCubeMapRenderer backgroundRenderer = new RotatingCubeMapRenderer(PANORAMA_CUBE_MAP);

//    public List<Button> buttons = new ArrayList<>();

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

        int width = AmissClient.mc.getWindow().getScaledWidth();
        int height = AmissClient.mc.getWindow().getScaledHeight();

        int x = width/2;
        int y = height/2;
        int buttonwidth = 66;
        int buttonheight = FontRenderer.createFromID("/assets/amiss/font/abel.ttf",
                24, false, false, false).getFontHeight()+4;

        //buttons.add(new Button("Singleplayer", x-buttonwidth-1 , y-2, buttonwidth, buttonheight+2, new Color(182, 187, 190), new Color(0, 0, 0, 255), () -> {MinecraftClient.getInstance().setScreen(new SelectWorldScreen(this));}));

        super.render(matrices, mouseX, mouseY, delta);
    }
}
