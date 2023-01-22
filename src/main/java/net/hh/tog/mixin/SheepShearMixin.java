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
            target = "Lnet/minecraft/entity/passive/AnimalEntity;interactMob(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/ActionResult;"),
            method = "interactMob",
            cancellable = true)
    private void onShear(final PlayerEntity player,final Hand hand,final CallbackInfoReturnable<Boolean> info) {
        //ActionResult result = SheepShearCallback.EVENT.invoker().interact(player, (SheepEntity) (Object) this, hand);
        ActionResult result = SheepShearCallback.EVENT.invoker().interact( player,  (SheepEntity) (Object) this, hand);

        if (!(result == ActionResult.PASS)) {
            info.cancel();
        }
    }
}
