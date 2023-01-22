package net.hh.tog.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.hh.tog.TogMod;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public interface SheepShearCallback {

    Event<SheepShearCallback> EVENT = EventFactory.createArrayBacked(SheepShearCallback.class,
            (listeners) -> (player, sheep, hand) -> {
                for (SheepShearCallback listener : listeners) {
                    ActionResult result = listener.interact(player, sheep, hand);

                    if (result != ActionResult.PASS)
                        return result;
                }
                return ActionResult.PASS;
            });

    ActionResult interact(PlayerEntity player, SheepEntity sheep, Hand hand);
}
