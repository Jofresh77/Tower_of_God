package net.hh.tog.gui;

import io.wispforest.owo.ui.base.BaseUIModelScreen;
import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.container.FlowLayout;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class MyScreen extends BaseUIModelScreen<FlowLayout> {

    public MyScreen() {
        super(FlowLayout.class, DataSource.asset(new Identifier("tog", "dialog")));
    }

    @Override
    protected void build(FlowLayout rootComponent) {
        Objects.requireNonNull(rootComponent.childById(ButtonWidget.class, "the-button")).onPress();
    }
}
