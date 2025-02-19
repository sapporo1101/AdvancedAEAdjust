package io.github.sapporo1101.advancedaeadjust.neoforge.mixin;

import appeng.items.parts.PartModelsHelper;
import net.minecraft.resources.ResourceLocation;
import net.pedroksl.advanced_ae.AdvancedAE;
import net.pedroksl.advanced_ae.common.parts.SmallAdvPatternProviderPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(PartModelsHelper.class)
public class PartModelsHelperMixin {
    @Inject(method = "createModels", at = @At("RETURN"), cancellable = true)
    private static void createModels(Class<?> clazz, CallbackInfoReturnable<List<ResourceLocation>> cir) {
        if (clazz != SmallAdvPatternProviderPart.class) return;
        var locations = new ArrayList<>(cir.getReturnValue());
        var oldModelBase = AdvancedAE.makeId("part/adv_pattern_provider_part");
        var newModelBase = AdvancedAE.makeId("part/small_adv_pattern_provider_part");
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).equals(oldModelBase)) {
                locations.set(i, newModelBase);
            }
        }
        cir.setReturnValue(locations);
    }
}
