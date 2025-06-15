package me.lukiiy.f3deathcoords.mixin;

import me.lukiiy.f3deathcoords.F3DeathCoords;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_525;
import net.minecraft.client.gui.widget.ButtonWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(class_525.class)
public class PauseMixin {
    @Inject(method = "buttonClicked", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;setScreen(Lnet/minecraft/client/gui/screen/Screen;)V", ordinal = 1))
    private void f3Death$resetCoords(ButtonWidget par1, CallbackInfo ci) {
        if (par1.id == 1) F3DeathCoords.reset();
    }
}
