package io.github.sapporo1101.advancedaeadjust.neoforge.mixin;

import appeng.api.parts.IPartModel;
import appeng.parts.PartModel;
import net.pedroksl.advanced_ae.AdvancedAE;
import net.pedroksl.advanced_ae.common.parts.AdvPatternProviderPart;
import net.pedroksl.advanced_ae.common.parts.SmallAdvPatternProviderPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;

@Mixin(AdvPatternProviderPart.class)
public class AdvPatternProviderPartMixin {
    @Inject(method = "getStaticModels", at = @At("RETURN"), cancellable = true)
    private void getStaticModels(CallbackInfoReturnable<IPartModel> cir) {
        if (!(((AdvPatternProviderPart) (Object) this) instanceof SmallAdvPatternProviderPart)) return;
        var locations = new ArrayList<>(cir.getReturnValue().getModels());
        var oldModelBase = AdvancedAE.makeId("part/adv_pattern_provider_part");
        var newModelBase = AdvancedAE.makeId("part/small_adv_pattern_provider_part");
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).equals(oldModelBase)) {
                locations.set(i, newModelBase);
            }
        }
        cir.setReturnValue(new PartModel(locations));
    }
}
