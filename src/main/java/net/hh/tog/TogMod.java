package net.hh.tog;

import net.fabricmc.api.ModInitializer;

import net.hh.tog.event.SheepShearCallback;
import net.hh.tog.item.ModItems;
import net.minecraft.entity.ItemEntity;
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
            ItemStack itemStack = player.getStackInHand(hand);
            if (itemStack.isOf(Items.SHEARS)) {
                sheep.setSheared(true);

                ItemStack stack = new ItemStack(ModItems.EXPRESS_TICKET);
                ItemEntity itemEntity = new ItemEntity(player.world, sheep.getX(), sheep.getY(), sheep.getZ(), stack);
                player.world.spawnEntity(itemEntity);
                return ActionResult.PASS;
            }

            return ActionResult.FAIL;
        }));
    }
}