package dev.lofiz.abyss.ui.screen.widget;

public interface IWidget {

    void render(int mouseX, int mouseY);

    default void onClick(int mouseX, int mouseY, int mouseButton) {

    }

    default void onMouseRelease(int mouseX, int mouseY) {

    }
}
