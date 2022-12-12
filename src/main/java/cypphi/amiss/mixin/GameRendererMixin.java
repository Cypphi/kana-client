package cypphi.amiss.mixin;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {
    @Inject(at = @At(value = "FIELD", target = "Lnet/minecraft/client/render/GameRenderer;renderHand:Z", opcode = Opcodes.GETFIELD, ordinal = 0), method = "renderWorld")
    void onRender(MatrixStack matrixstack) {
        for (Module module : ModuleManager.getModules()) {
            if (module.isEnabled()) {
                module.onWorldRender(ms);
            }
        }
    }
}
