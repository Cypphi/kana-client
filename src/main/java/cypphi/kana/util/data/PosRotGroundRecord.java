package cypphi.kana.util.data;

import net.minecraft.entity.Entity;

public record PosRotGroundRecord(double x, double y, double z, float yaw, float pitch, boolean onGround) {
    public static PosRotGroundRecord getFromEntity(Entity entity) {
        return new PosRotGroundRecord(entity.getX(), entity.getY(), entity.getZ(), entity.getYaw(), entity.getPitch(), entity.isOnGround());
    }
}