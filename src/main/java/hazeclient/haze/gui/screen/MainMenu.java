package hazeclient.haze.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import hazeclient.haze.HazeClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.realms.gui.screen.RealmsMainScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.io.InputStream;

public class MainMenu extends Screen {
    String t;

    private final Identifier background = new Identifier("haze", "textures/background.png");
    private final Identifier logo = new Identifier("haze", "textures/haze_white.png");
    private final Identifier textlogo = new Identifier("haze", "textures/haze_textlogo.png");

    public MainMenu() {
        super(Text.of("a"));
    }

    @Override
    protected void init() {
        addDrawableChild(createCentered("Singleplayer", height / 2 - 50, button -> HazeClient.mc.setScreen(new SelectWorldScreen(this))));
        addDrawableChild(createCentered("Multiplayer", height / 2 - 25, button -> HazeClient.mc.setScreen(new MultiplayerScreen(this))));
        addDrawableChild(createCentered("Realms", height / 2, button -> HazeClient.mc.setScreen(new RealmsMainScreen(this))));
        addDrawableChild(new ButtonWidget(width / 2 - 100, height / 2 + 25, 90, 20, Text.of("Options"), button -> HazeClient.mc.setScreen(new OptionsScreen(this, HazeClient.mc.options))));
        addDrawableChild(new ButtonWidget(width / 2 + 10, height / 2 + 25, 90, 20, Text.of("Quit"), button -> HazeClient.mc.stop()));
        super.init();
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        RenderSystem.setShaderTexture(0, background);
        drawTexture(matrices, mouseX / 30 - 25, mouseY / 30 - 25, 0, 0, 0, width - mouseX / 30 + 25, height - mouseY / 30 + 25, width + 30, height + 50);
        RenderSystem.setShaderTexture(0, logo);
        drawTexture(matrices, width / 2 - 75, height / 2 + 100, 0, 0, 150, 150, 150,150);
        RenderSystem.setShaderTexture(0, textlogo);
        drawTexture(matrices, width / 2 - 250, 100, 0, 0, 500, 100, 500,100);
        super.render(matrices, mouseX, mouseY, delta);
    }

    ButtonWidget createCentered(String t, int y, ButtonWidget.PressAction action) {
        return new ButtonWidget(width / 2 - (200 / 2), y, 200, 20, Text.of(t), action);
    }
}
