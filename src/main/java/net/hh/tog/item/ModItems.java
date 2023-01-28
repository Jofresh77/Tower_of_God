package net.hh.tog.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hh.tog.TogMod;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModItems {

    public static final Item EXPRESS_TICKET = registerItem("express_ticket",
            new ExpressTicketItem(new FabricItemSettings().maxCount(1)));

    private static final ItemGroup TOG_GROUP = FabricItemGroup.builder(new Identifier(TogMod.MOD_ID, "tog_group"))
            .icon(() -> new ItemStack(EXPRESS_TICKET))
            .build();

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TogMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TogMod.LOGGER.debug("Registering Mod items for " + TogMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(TOG_GROUP).register(content -> {
            content.add(EXPRESS_TICKET);
        });
    }


}
