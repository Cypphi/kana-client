package cypphi.kana;

import cypphi.kana.util.data.PosRotGroundRecord;
import net.minecraft.entity.Entity;

import java.util.function.Supplier;

public class MinecraftUtils {
    public static boolean REDIRECTING_POS_ROT_GROUND = false;
    public static Supplier<PosRotGroundRecord> POS_ROT_GROUND = null;

    public static boolean isSelfPlayer(Entity entity) {
        return Kana.mc.player == entity;
    }
}
