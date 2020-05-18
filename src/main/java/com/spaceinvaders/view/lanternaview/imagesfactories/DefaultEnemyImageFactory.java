package com.spaceinvaders.view.lanternaview.imagesfactories;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;

public class DefaultEnemyImageFactory implements ImageFactory {

    @Override
    public TextImage createTextImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(3, 1);

        image.setCharacterAt(0, 0 , new TextCharacter('/', new TextColor.RGB(0, 0, 128), backgroundColor));
        image.setCharacterAt(1, 0 , new TextCharacter('o', new TextColor.RGB(0, 0, 128), backgroundColor));
        image.setCharacterAt(2, 0 , new TextCharacter('\\', new TextColor.RGB(0, 0, 128), backgroundColor));

        return image;
    }
}
