package com.spaceinvaders.view.lanternaimagesfactories;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;

public class ShipImageFactory {

    public TextImage create(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(5, 1);

        image.setCharacterAt(0, 0 , new TextCharacter('/', new TextColor.RGB(255, 255, 51), backgroundColor));
        image.setCharacterAt(1, 0 , new TextCharacter('-', new TextColor.RGB(255, 255, 51), backgroundColor));
        image.setCharacterAt(2, 0 , new TextCharacter('^', new TextColor.RGB(255, 255, 51), backgroundColor));
        image.setCharacterAt(3, 0 , new TextCharacter('-', new TextColor.RGB(255, 255, 51), backgroundColor));
        image.setCharacterAt(4, 0 , new TextCharacter('\\', new TextColor.RGB(255, 255, 51), backgroundColor));

        return image;
    }
}
