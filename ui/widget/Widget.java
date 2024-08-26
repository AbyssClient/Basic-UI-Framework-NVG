package dev.lofiz.abyss.ui.screen.widget;

import dev.lofiz.abyss.utils.mouse.MouseUtils;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.Minecraft;

@Getter
@Setter
public abstract class Widget implements IWidget {

    public float x, y, width, height, screenWidth, screenHeight;

    public final Minecraft mc = Minecraft.getMinecraft();

    public Widget(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean isWidgetHovered(int mouseX, int mouseY) {
        return MouseUtils.isMouseOver((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), mouseX, mouseY);
    }
}
