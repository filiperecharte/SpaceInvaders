package com.spaceinvaders.view.lanternaview.imagesrederers;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;
import com.spaceinvaders.model.Box;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.view.lanternaview.imagesfactories.ImageFactory;

public class BoxImageRenderer implements Renderer {
    private Box box;
    private TextImage image;

    public BoxImageRenderer(Box box, TextImage image) {
        this.box = box;
        this.image = image;
    }

    @Override
    public void render(TextGraphics graphics) {
        Position boxPosition = box.getPosition();
        graphics.drawImage(new TerminalPosition(box.getPosition().getX(), box.getPosition().getY()), image);
    }
}
