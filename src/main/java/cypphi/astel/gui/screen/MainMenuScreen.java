package cypphi.astel.gui.screen;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import cypphi.astel.AstelClient;
import cypphi.astel.gui.screen.element.Button;
import cypphi.astel.renderer.Render2d;
import cypphi.astel.renderer.font.FontRenderer;
import cypphi.astel.gui.screen.element.Button;
import net.minecraft.client.gui.CubeMapRenderer;
import net.minecraft.client.gui.RotatingCubeMapRenderer;
import cypphi.astel.AstelClient;
import cypphi.astel.renderer.Render2d;
import cypphi.astel.renderer.font.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static cypphi.astel.AstelClient.mc;

public class MainMenuScreen extends Screen {

    String t;

    private final Identifier background = new Identifier("amiss", "textures/background.png");

    FontRenderer ANTON = FontRenderer.create("anton", 25, false, false, false);
    public long backgroundFadeStart = 0L;

    public static final CubeMapRenderer PANORAMA_CUBE_MAP = new CubeMapRenderer(new Identifier("textures/gui/title/background/panorama"));

    private static final Identifier PANORAMA_OVERLAY = new Identifier("textures/gui/title/background/panorama_overlay.png");

    private final RotatingCubeMapRenderer backgroundRenderer;

    public List<Button> buttons = new ArrayList<>();
    public MainMenuScreen() {
        super(Text.of("a"));
        this.backgroundRenderer = new RotatingCubeMapRenderer(PANORAMA_CUBE_MAP);
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
        //Render2d.drawTexture(matrices, background, 0, 0, width, height);

        if (this.backgroundFadeStart == 0L) {
            this.backgroundFadeStart = Util.getMeasuringTimeMs();
        }

        float f = (float)(Util.getMeasuringTimeMs() - this.backgroundFadeStart) / 1000.0F;

        this.backgroundRenderer.render(delta, MathHelper.clamp(f, 0.0F, 1.0F));

        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderTexture(0, PANORAMA_OVERLAY);
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, (float)MathHelper.ceil(MathHelper.clamp(f, 0.0F, 1.0F)));
        drawTexture(matrices, 0, 0, this.width, this.height, 0.0F, 0.0F, 16, 128, 16, 128);


        int width = mc.getWindow().getScaledWidth();
        int height = mc.getWindow().getScaledHeight();

        int x = width/2;
        int y = height/2;
        int buttonwidth = 66;
        int buttonheight = FontRenderer.createFromID("/assets/astel/font/abel.ttf",
                24, false, false, false).getFontHeight()+4;

        buttons.add(new Button("Singleplayer", x-buttonwidth-1 , y-2, buttonwidth, buttonheight+2, new Color(182, 187, 190, 255), new Color(0, 0, 0, 255), () -> {mc.setScreen(new SelectWorldScreen(this));}));

        for (Button button : buttons) {
            button.render(matrices);
        }

        super.render(matrices, mouseX, mouseY, delta);
    }
}
