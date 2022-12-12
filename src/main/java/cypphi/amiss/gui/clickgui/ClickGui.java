package cypphi.amiss.gui.clickgui;

import cypphi.amiss.feature.module.ModuleCategory;
import cypphi.amiss.renderer.Render2d;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClickGui extends Screen {

    public static final ClickGui INSTANCE = new ClickGui();
    private List<Frame> frames;

    double animProgress = 0;

    private ClickGui() {
        super(Text.of("ClickGUI"));

        frames = new ArrayList<>();
        int offset = 30;

        Render2d.drawQuad(0,0, MinecraftClient.getInstance().getWindow().getScaledWidth(), MinecraftClient.getInstance().getWindow().getScaledHeight(), new Color(0, 0, 0, 40), new MatrixStack());
        for (ModuleCategory category : ModuleCategory.values()) {
            frames.add(new Frame(offset, 40, 90, category));
            offset+=110;
        }
    }

    @Override
    public void tick() {
        animProgress += 0.3;
        animProgress = MathHelper.clamp(animProgress, 0, 1);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        for (Frame frame : frames) {
            frame.render(matrices, mouseX, mouseY, delta, new Color(238, 238, 238, 255));
        }
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (Frame frame : frames) {
            frame.mouseClicked(mouseX, mouseY, button);
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double amount) {
        for (Frame frame : frames) {
            frame.mouseScrolled(mouseX, mouseY, amount);
        }
        return super.mouseScrolled(mouseX, mouseY, amount);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

}
