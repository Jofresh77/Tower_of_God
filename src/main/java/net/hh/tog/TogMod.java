package net.hh.tog;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.hh.tog.event.SheepShearCallback;
import net.hh.tog.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//test
public class TogMod implements ModInitializer {
    public static final String MOD_ID = "tog";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        ModItems.registerModItems();

        SheepShearCallback.EVENT.register(((player, sheep, hand) -> {
            sheep.setSheared(true);

            ItemStack stack = new ItemStack(ModItems.EXPRESS_TICKET);
            ItemEntity itemEntity = new ItemEntity(player.world, sheep.getX(), sheep.getY(), sheep.getZ(), stack);
            player.world.spawnEntity(itemEntity);
            return ActionResult.PASS;
        }));

        AttackBlockCallback.EVENT.register(((player, world, hand, pos, direction) -> {
            BlockState state = world.getBlockState(pos);
            if (state.isToolRequired() && !player.isSpectator() &&
            player.getMainHandStack().isEmpty()) {
                player.damage(DamageSource.GENERIC, 1.0f);
            }
            return ActionResult.PASS;
        }));
    }
}