package com.spaceinvaders.view.lanternaview.imagesfactories;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;

public class ShipShotImageFactory implements ImageFactory {
    @Override
    public TextImage createTextImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(1, 1);
        image.setCharacterAt(0, 0 , new TextCharacter('.', new TextColor.RGB(0, 0, 0), backgroundColor));
        return image;
    }
}
