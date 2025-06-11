package me.lukiiy.f3deathcoords.mixin;

import me.lukiiy.f3deathcoords.F3DeathCoords;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(TitleScreen.class)
public class TitleMixin {
    @Inject(method = "init", at = @At("HEAD"))
    private void f3Death$resetCoords(CallbackInfo ci) {
        F3DeathCoords.reset();
    }
}
