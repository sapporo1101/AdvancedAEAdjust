package io.github.sapporo1101.advancedaeadjust;

import io.github.sapporo1101.advancedaeadjust.resource.ResourceModifier;

public final class Advancedaeadjust {
    public static final String MOD_ID = "advancedaeadjust";

    public static void init() {
        // Write common init code here.
    }

    public static void registerModifiers() {
        ResourceModifier.registerQuickModifier("data/advanced_ae/recipe/regeneration_card.json", data -> {
            try (var modifiedData = Advancedaeadjust.class.getClassLoader().getResourceAsStream("dataMixin/advancedaeadjust/recipe/regeneration_card.json")) {
                if (modifiedData == null) return null;
                return modifiedData.readAllBytes();
            }
        });

        ResourceModifier.registerStartsWithModifier("assets/advanced_ae/textures/", (path, data) -> {
            try (var modifiedData = Advancedaeadjust.class.getClassLoader().getResourceAsStream(path.replaceFirst("^assets/advanced_ae/", "assets/advancedaeadjust/"))) {
                if (modifiedData == null) return null;
                return modifiedData.readAllBytes();
            }
        });
    }
}
