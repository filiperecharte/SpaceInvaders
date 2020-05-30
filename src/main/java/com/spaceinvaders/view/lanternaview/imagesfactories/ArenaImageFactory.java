package com.spaceinvaders.view.lanternaview.imagesfactories;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;

public class ArenaImageFactory implements ImageFactory {

    @Override
    public TextImage createTextImage(ImageInfo imageInfo) {

        TextImage image = new BasicTextImage(100, 100);
        image.setAll(new TextCharacter(' ', new TextColor.RGB(0, 0, 0), imageInfo.getBackgroundColor(), SGR.BOLD));
        return image;
    }
}
