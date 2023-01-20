package net.hh.tog.mixin;

import net.hh.tog.TogMod;
import net.hh.tog.event.SheepShearCallback;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SheepEntity.class)
public class SheepShearMixin {
    @Inject(at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/passive/SheepEntity;dropItem(Lnet/minecraft/item/ItemConvertible;I)Lnet/minecraft/entity/ItemEntity;"),
            method = "sheared",
            cancellable = true)
    private void onShear(SoundCategory shearedSoundCategory, CallbackInfo ci) {
        //ActionResult result = SheepShearCallback.EVENT.invoker().interact(player, (SheepEntity) (Object) this, hand);
        ActionResult result = SheepShearCallback.EVENT.invoker().interact(shearedSoundCategory, ci);

        if (!(result == ActionResult.PASS)) {
            ci.cancel();
        }
    }
}
