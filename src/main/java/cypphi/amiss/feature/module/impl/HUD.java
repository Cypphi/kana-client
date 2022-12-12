package cypphi.amiss.feature.module.impl;

import com.mojang.blaze3d.systems.RenderSystem;

import cypphi.amiss.feature.module.Setting;
import cypphi.amiss.feature.module.ModuleCategory;
import cypphi.amiss.feature.module.ModuleManager;
import cypphi.amiss.renderer.Render2d;
import cypphi.amiss.renderer.font.FontRenderer;
import cypphi.amiss.feature.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

import java.awt.*;
import java.util.Comparator;

public class HUD extends Module {

    private static MinecraftClient mc = MinecraftClient.getInstance();

    public HUD() {
        super("Hud", "Shows the hud", GLFW.GLFW_KEY_C, ModuleCategory.RENDER, new Setting[]{});
    }

    public static int rainbow(int delay) {
        double state = Math.ceil((System.currentTimeMillis() + delay)/20.0);
        state%=360;
        return Color.getHSBColor((float) (state/360.0f), 0.9f, 0.7f).getRGB();
    }

    @Override
    public void onHudRender(MatrixStack matrices) {
        // Logo
        Identifier TEXTURE = new Identifier("amiss", "icon.png");
        RenderSystem.enableBlend();
        new Render2d().drawTexture(matrices, TEXTURE,5, 5, 64, 64);
        // ArrayList
        drawArrayList(matrices);
        // Coords
        String coords = "XYZ: " + MinecraftClient.getInstance().player.getX() + " " + MinecraftClient.getInstance().player.getY() + " " + MinecraftClient.getInstance().player.getZ();
        int x = MinecraftClient.getInstance().getWindow().getWidth()-1;
        int y = MinecraftClient.getInstance().getWindow().getHeight()-1;
        FontRenderer fontRenderer = FontRenderer.createFromID("/assets/amiss/font/abel.ttf",
                16, false, false, false);
        fontRenderer.drawString(matrices, coords, x-fontRenderer.getStringWidth(coords), y-fontRenderer.getFontHeight(), Color.white.getRGB());
    }

    public void drawArrayList(MatrixStack matrices) {
        int width = MinecraftClient.getInstance().getWindow().getScaledWidth();
        int fheight = MinecraftClient.getInstance().textRenderer.fontHeight;
        int i = 0;
        ModuleManager.modules.sort(Comparator.comparingInt(t -> -mc.textRenderer.getWidth(t.getName())));
        for (Module module : ModuleManager.getModules()) {
            if (module.isToggled()) {
                int fontwidth = mc.textRenderer.getWidth(module.getName());
                int renderoffset = fontwidth+2;
                Render2d.drawQuad(width - fontwidth - 6 + renderoffset, i, fontwidth + 6, fheight+4, new Color(43, 48, 58, 190), matrices);
                FontRenderer.createFromID("/assets/amiss/font/abel.ttf",
                        16, false, false, false).drawStringWithShadow(matrices, module.getName(), width - fontwidth - 3 + renderoffset, i+1, Color.white.getRGB());
                Render2d.drawQuad(width - fontwidth - 7 + renderoffset, i, 1, fheight+4, new Color(70, 94, 243), matrices);
                i += fheight + 4;
            }
        }
    }
}

