package dev.lofiz.abyss.ui.screen;

import dev.lofiz.abyss.ui.screen.widget.Widget;
import lombok.Getter;
import net.minecraft.client.gui.GuiScreen;

import java.util.ArrayList;
import java.util.List;

public abstract class Screen extends GuiScreen {

    @Getter
    public List<Widget> widgets = new ArrayList<>();

    public abstract void render(int mouseX, int mouseY);

    public void renderWidgets(int mouseX, int mouseY) {

        for(Widget widget : getWidgets()) {
            widget.render(mouseX, mouseY);
            widget.setScreenWidth(this.width);
            widget.setScreenHeight(this.height);
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        render(mouseX, mouseY);
        renderWidgets(mouseX, mouseY);
    }

    public void onClick(int mouseX, int mouseY, int mouseButton) {

        for(Widget widget : widgets) {
            widget.onClick(mouseX, mouseY, mouseButton);
        }
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        onClick(mouseX, mouseY, mouseButton);
    }

    public void onInit() {

    }

    @Override
    public void initGui() {
        onInit();
    }

    public void onClose() {

    }

    @Override
    public void onGuiClosed() {
        onClose();
    }
}
