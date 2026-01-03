package me.lukiiy.f3deathcoords;

import me.lukiiy.f3mod.DebugEntry;
import me.lukiiy.f3mod.F3Mod;
import me.lukiiy.f3mod.F3ModAPI;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.entity.player.ClientPlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class F3DeathCoords implements ClientModInitializer, F3ModAPI {
    public static final Logger LOGGER = LoggerFactory.getLogger("f3deathcoords");

    public static Vec3d deathCoords = null;

    @Override
    public void onInitializeClient() {}

    public static void set(double x, double y, double z) {
        deathCoords = Vec3d.create(x, y, z);
    }

    public static void reset() {
        deathCoords = null;
    }

    @Override
    public Collection<DebugEntry> getEntries() {
        return Collections.singleton(new DebugEntry() {
            @Override
            public F3Mod.Section getSection() {
                return F3Mod.Section.LEFT;
            }

            @Override
            public List<String> provide(ClientPlayerEntity clientPlayerEntity, World world) {
                if (deathCoords == null) return Collections.emptyList();
                return Collections.singletonList("§cDeath XYZ: §f" + String.format("%s %s %s", (int) deathCoords.x, (int) deathCoords.y, (int) deathCoords.z));
            }
        });
    }
}
