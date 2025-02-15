package io.github.sapporo1101.advancedaeadjust.fabric;

import io.github.sapporo1101.advancedaeadjust.Advancedaeadjust;
import net.fabricmc.api.ModInitializer;

public final class AdvancedaeadjustFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        Advancedaeadjust.init();
    }
}
