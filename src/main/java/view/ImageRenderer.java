package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.image.Image;
import model.image.Pixel;

public class ImageRenderer implements Renderer {
    private Image image;

    public ImageRenderer(Image image) {
        this.image = image;
    }

    public void renderPixels(TextGraphics graphics) {
        for (Pixel pixel : image.getPixels()) {
            graphics.setCharacter(pixel.getPosition().getX(), pixel.getPosition().getY(), pixel.getCharacter());
        }
    }

    @Override
    public void render(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString(image.getColor()));
        if (image.isBold()) {
            graphics.enableModifiers(SGR.BOLD);
        }
        renderPixels(graphics);
    }
}
