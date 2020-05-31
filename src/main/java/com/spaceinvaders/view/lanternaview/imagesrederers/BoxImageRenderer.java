package com.spaceinvaders.view.lanternaview.imagesrederers;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;
import com.spaceinvaders.model.box.Box;

public class BoxImageRenderer implements Renderer {
    private Box box;
    private TextImage image;

    public BoxImageRenderer() {}

    public void setBox(Box box) {
        this.box = box;
    }

    public void setImage(TextImage image) {
        this.image = image;
    }

    @Override
    public void render(TextGraphics graphics) {
        graphics.drawImage(new TerminalPosition(box.getPosition().getX(), box.getPosition().getY()), image);
    }
}
