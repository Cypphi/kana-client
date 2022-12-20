package cypphi.kana.mixin;

import com.mojang.authlib.GameProfile;
import cypphi.kana.Kana;
import cypphi.kana.MinecraftUtils;
import cypphi.kana.event.impl.UpdateEvent;
import cypphi.kana.util.data.PosRotGroundRecord;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.encryption.PlayerPublicKey;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(priority = 1111, value = ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin extends AbstractClientPlayerEntity {
    private boolean cachedGround = false;

    public ClientPlayerEntityMixin(ClientWorld world, GameProfile profile, @Nullable PlayerPublicKey publicKey) {
        super(world, profile);
    }

    @Shadow protected abstract boolean isCamera();

    @Inject(method = "sendMovementPackets", at = @At("HEAD"))
    public void sendMovementPacketsHead(CallbackInfo ci) {
        if (this.isCamera()) {
            MinecraftUtils.REDIRECTING_POS_ROT_GROUND = true;
            cachedGround = this.isOnGround();

            UpdateEvent event = new UpdateEvent.Pre(PosRotGroundRecord.getFromEntity(this));
            Kana.getInstance().getEventBus().post(event);

            MinecraftUtils.POS_ROT_GROUND = event::getAsRecord;
        }
    }

    @Inject(method = "sendMovementPackets", at = @At("RETURN"))
    public void sendMovementPacketsReturn(CallbackInfo ci) {
        if(this.isCamera()) {
            UpdateEvent event = new UpdateEvent.Post(MinecraftUtils.POS_ROT_GROUND.get());
            Kana.getInstance().getEventBus().post(event);

            MinecraftUtils.REDIRECTING_POS_ROT_GROUND = false;
            MinecraftUtils.POS_ROT_GROUND = null;
            this.onGround = cachedGround;
        }
    }
}
