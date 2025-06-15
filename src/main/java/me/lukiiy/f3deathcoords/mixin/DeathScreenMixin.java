package me.lukiiy.f3deathcoords.mixin;

import me.lukiiy.f3deathcoords.F3DeathCoords;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.entity.player.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(DeathScreen.class)
public class DeathScreenMixin {
    @Inject(method = "init", at = @At("TAIL"))
    private void f3Death$saveCoords(CallbackInfo ci) {
        ClientPlayerEntity player = ((MinecraftAccessor) this).f3Death$getMinecraft().player;

        F3DeathCoords.set(player.x, player.y, player.z);
    }
}
