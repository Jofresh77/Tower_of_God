package net.hh.tog;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.hh.tog.gui.MyScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class TogModClient implements ClientModInitializer {

    private static final KeyBinding DIALOG = new KeyBinding("key.ui.dialog", GLFW.GLFW_KEY_F, "key.categories.misc");

    @Override
    public void onInitializeClient() {
        /*MinecraftClient client = MinecraftClient.getInstance();
        client.setScreen(new MyScreen());*/
        /*KeyBindingHelper.registerKeyBinding(DIALOG);
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (DIALOG.wasPressed()) {

            }
        });*/
    }

    @Override
    public void on
}
