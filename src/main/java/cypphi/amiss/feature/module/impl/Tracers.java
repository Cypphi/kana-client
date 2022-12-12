package cypphi.amiss.feature.module.impl;

import cypphi.amiss.feature.module.Setting;
import cypphi.amiss.feature.module.Module;
import cypphi.amiss.feature.module.ModuleCategory;
import cypphi.amiss.renderer.Render2d;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

import java.awt.*;

public class Tracers extends Module {

    public Tracers() {
        super("Tracers", "Displays lines to entities.", KEY_UNBOUND, ModuleCategory.RENDER, new Setting[]{});
    }

    @Override
    public void onTick() {
        Vec3d vec = new Vec3d(0, 0, 75)
                .rotateX(-(float) Math.toRadians(MinecraftClient.getInstance().gameRenderer.getCamera().getPitch()))
                .rotateY(-(float) Math.toRadians(MinecraftClient.getInstance().gameRenderer.getCamera().getYaw()))
                .add(MinecraftClient.getInstance().cameraEntity.getEyePos());
        for (Entity entity : MinecraftClient.getInstance().world.getEntities()) {
            Render2d.drawLine(vec.x, vec.y, vec.z, entity.getX(), entity.getY(), entity.getZ(), Color.white);
        }
    }
}
