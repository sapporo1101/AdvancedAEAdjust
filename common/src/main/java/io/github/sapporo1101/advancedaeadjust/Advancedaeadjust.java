package io.github.sapporo1101.advancedaeadjust;

import com.google.gson.JsonParser;
import io.github.sapporo1101.advancedaeadjust.resource.ResourceModifier;

import java.util.List;

public final class Advancedaeadjust {
    public static final String MOD_ID = "advancedaeadjust";

    public static void init() {
        // Write common init code here.
    }

    public static void registerModifiers() {
        ResourceModifier.registerQuickModifier("data/advanced_ae/recipe/regeneration_card.json", data -> {
            var json = JsonParser.parseString(new String(data)).getAsJsonObject();
            var jsonKey = json.getAsJsonObject("key");
            for (var entry : List.of("A", "R", "M", "O")) {
                jsonKey.getAsJsonObject(entry).addProperty("item", "minecraft:enchanted_golden_apple");
            }
            return json.toString().getBytes();
        });
    }
}
