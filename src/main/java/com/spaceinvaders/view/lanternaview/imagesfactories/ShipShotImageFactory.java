package com.spaceinvaders.view.lanternaview.imagesfactories;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;
import com.spaceinvaders.model.shots.ShipShot;

public class ShipShotImageFactory implements ImageFactory{

    public TextImage createTextImage(Object shotType, TextColor backgroundColor){
        if (shotType instanceof ShipShot){
            return ShipShotImage(backgroundColor);
        }
        return null;
    }

    public TextImage ShipShotImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(1, 1);
        image.setCharacterAt(0, 0 , new TextCharacter('.', new TextColor.RGB(0, 0, 0), backgroundColor, SGR.BOLD));
        return image;
    }
}
