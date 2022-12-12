package cypphi.astel.renderer;

import com.mojang.blaze3d.systems.RenderSystem;

import cypphi.astel.utils.RenderUtils;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import java.awt.*;


// Made by lto4
public class Render2d {

    public static void drawQuad(int x, int y, int width, int height, Color color, MatrixStack matrices) {
        RenderUtils.setupRender();
        // RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = Tessellator.getInstance().getBuffer();
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        int a = color.getAlpha();
        buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        buffer.vertex(matrices.peek().getPositionMatrix(), x,y + height, 0).color(r, g, b, a).next();
        buffer.vertex(matrices.peek().getPositionMatrix(), x + width, y + height, 0).color(r, g, b, a).next();
        buffer.vertex(matrices.peek().getPositionMatrix(), x + width, y, 0).color(r, g, b, a).next();
        buffer.vertex(matrices.peek().getPositionMatrix(), x, y,0).color(r, g, b, a).next();
        tessellator.draw();
        RenderUtils.endRender();
    }

    public static void roundedQuad(int x, int y, int width, int height, int rad, int samples, Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        int a = color.getAlpha();
        MatrixStack matrix = new MatrixStack();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = Tessellator.getInstance().getBuffer();
        buffer.begin(VertexFormat.DrawMode.TRIANGLE_FAN, VertexFormats.POSITION_COLOR);

        double tx1 = x + width - rad;
        double ty1 = y + height - rad;
        double x1 = x + rad;
        double y1 = y + rad;
        double[][] map = new double[][]{new double[]{tx1, ty1}, new double[]{tx1, y1}, new double[]{x1, y1}, new double[]{x1, ty1}};
        // RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        for (int i = 0; i < 4; i++) {
            double[] current = map[i];
            double max = (360 / 4d + i * 90d);
            for (double ra = i * 90d; ra < max; ra += (90 / samples)) {
                float rad1 = (float) Math.toRadians(ra);
                float sin = (float) (Math.sin(rad1) * rad);
                float cos = (float) (Math.cos(rad1) * rad);
                buffer.vertex(matrix.peek().getPositionMatrix(), (float) current[0] + sin, (float) current[1] + cos, 0.0F).color(r, g, b, a).next();
            }

            float rad1 = (float) Math.toRadians(max);
            float sin = (float) (Math.sin(rad1) * rad);
            float cos = (float) (Math.cos(rad1) * rad);
            buffer.vertex(matrix.peek().getPositionMatrix(), (float) current[0] + sin, (float) current[1] + cos, 0.0F).color(r, g, b, a).next();
        }
        tessellator.draw();
    }

    public static void drawLine(double x1, double y1, double z1, double x2, double y2, double z2, Color color) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = Tessellator.getInstance().getBuffer();
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        int a = color.getAlpha();

        // RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        buffer.begin(VertexFormat.DrawMode.LINES, VertexFormats.POSITION_COLOR);
        buffer.vertex(x1, y1, z1).color(r, g, b, a).next();
        buffer.vertex(x2, y2, z2).color(r, g, b, a).next();
        tessellator.draw();
    }

    public static void drawTexture(MatrixStack matrices, Identifier texture, int x, int y, int width, int height) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderTexture(0, texture);
        RenderSystem.enableBlend();
        RenderSystem.blendEquation(32774);
        RenderSystem.blendFunc(770, 1);
        RenderSystem.setShaderColor(1, 1, 1, 1);
        DrawableHelper.drawTexture(matrices, x, y, 0, 0, width, height, width, height);
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
    }
}
