package com.spaceinvaders.view.lanternaview.imagesfactories;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;

public class ShipImageFactory implements ImageFactory {

    @Override
    public TextImage createTextImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(5, 1);

        image.setCharacterAt(0, 0 , new TextCharacter('/', new TextColor.RGB(255, 255, 51), backgroundColor, SGR.BOLD));
        image.setCharacterAt(1, 0 , new TextCharacter('-', new TextColor.RGB(255, 255, 51), backgroundColor, SGR.BOLD));
        image.setCharacterAt(2, 0 , new TextCharacter('^', new TextColor.RGB(255, 255, 51), backgroundColor, SGR.BOLD));
        image.setCharacterAt(3, 0 , new TextCharacter('-', new TextColor.RGB(255, 255, 51), backgroundColor, SGR.BOLD));
        image.setCharacterAt(4, 0 , new TextCharacter('\\', new TextColor.RGB(255, 255, 51), backgroundColor, SGR.BOLD));
        return image;
    }
}
