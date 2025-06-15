package me.lukiiy.f3deathcoords;

import me.lukiiy.f3mod.F3Mod;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.Vec3d;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

public class F3DeathCoords implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("f3deathcoords");

    public static Vec3d deathCoords = null;

    @Override
    public void onInitializeClient() {
        F3Mod.registerProvider(F3Mod.Section.LEFT, (p, w) -> {
            if (deathCoords == null) return Collections.emptyList();
            return Collections.singletonList("§cDeath XYZ: §f" + String.format("%s %s %s", (int) deathCoords.x, (int) deathCoords.y, (int) deathCoords.z));
        });
    }

    public static void set(double x, double y, double z) {
        deathCoords = Vec3d.create(x, y, z);
    }

    public static void reset() {
        deathCoords = null;
    }
}
