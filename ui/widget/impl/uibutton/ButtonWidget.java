package dev.lofiz.abyss.ui.screen.widget.impl.uibutton;

import dev.lofiz.abyss.ui.screen.widget.Widget;
import dev.lofiz.abyss.utils.font.FontUtil;
import dev.lofiz.abyss.utils.gl.ColorUtils;
import dev.lofiz.abyss.utils.render.NVGUtil;
import lombok.Getter;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.*;

@Getter
public class ButtonWidget extends Widget {

    private final String text;
    private final Runnable clicked;
    private final int mouseButton;
    private final boolean dropShadow;

    public ButtonWidget(String text, float x, float y, int mouseButton, boolean dropShadow, Runnable clicked) {
        super(x, y, 110, 20);
        this.text = text;
        this.mouseButton = mouseButton;
        this.dropShadow = dropShadow;
        this.clicked = clicked;
    }

    public ButtonWidget(String text, float x, float y, float width, int mouseButton, boolean dropShadow, Runnable clicked) {
        super(x, y, width, 20);
        this.text = text;
        this.mouseButton = mouseButton;
        this.dropShadow = dropShadow;
        this.clicked = clicked;
    }

    @Override
    public void render(int mouseX, int mouseY) {

        NVGUtil.beginFrame(new ScaledResolution(mc));

        if(dropShadow) NVGUtil.drawDropShadow(x, y, width, height, 6, 5, 4, 0, 70);

        NVGUtil.drawRoundedRect(x, y, width, height, 6, isWidgetHovered(mouseX, mouseY) ? new Color(255, 255, 255, 50) : new Color(0, 0, 0, 50));

        NVGUtil.endFrame();

        ColorUtils.fixFontColor(new Color(190, 190, 190).getRGB());

        FontUtil.size_20_bold.drawString(text, x + width / 2f - FontUtil.size_20_bold.getStringWidth(text) / 2f, y + height / 2f - FontUtil.size_20_bold.getHeight() / 2f + 1, new Color(190, 190, 190).getRGB());

        GlStateManager.disableBlend();
    }

    @Override
    public void onClick(int mouseX, int mouseY, int mouseButton) {

        if(isWidgetHovered(mouseX, mouseY)) {

            if(mouseButton == this.mouseButton) {
                clicked.run();
            }
        }
    }
}
