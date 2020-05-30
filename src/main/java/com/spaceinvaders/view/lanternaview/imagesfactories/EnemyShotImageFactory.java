package com.spaceinvaders.view.lanternaview.imagesfactories;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;
import com.spaceinvaders.model.enemy.enemyvariants.*;
import com.spaceinvaders.model.shots.enemyshotvariants.*;

public class EnemyShotImageFactory {

    public TextImage createTextImage(Object shotType, TextColor backgroundColor){
        if (shotType instanceof ImmatureShot){
            return ImmatureShotImage(backgroundColor);
        }
        else if (shotType instanceof LegendaryShot){
            return LegendaryShotImage(backgroundColor);
        }
        else if (shotType instanceof PowerfulShot){
            return PowerfulShotImage(backgroundColor);
        }
        else if (shotType instanceof SlickShot){
            return SlickShotImage(backgroundColor);
        }
        else if (shotType instanceof WeakShot){
            return WeakShotImage(backgroundColor);
        }
        return null;
    }

    public TextImage ImmatureShotImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(1, 1);
        image.setCharacterAt(0, 0 , new TextCharacter('*', new TextColor.RGB(0, 0, 0), backgroundColor, SGR.BOLD));
        return image;
    }

    public TextImage LegendaryShotImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(1, 1);
        image.setCharacterAt(0, 0 , new TextCharacter('.', new TextColor.RGB(0, 0, 0), backgroundColor, SGR.BOLD));
        return image;
    }

    public TextImage PowerfulShotImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(1, 1);
        image.setCharacterAt(0, 0 , new TextCharacter('o', new TextColor.RGB(100, 0, 0), backgroundColor, SGR.BOLD));
        return image;
    }

    public TextImage SlickShotImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(1, 1);
        image.setCharacterAt(0, 0 , new TextCharacter('0', new TextColor.RGB(0, 0, 0), backgroundColor, SGR.BOLD));
        return image;
    }

    public TextImage WeakShotImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(1, 1);
        image.setCharacterAt(0, 0 , new TextCharacter('.', new TextColor.RGB(0, 0, 0), backgroundColor, SGR.BOLD));
        return image;
    }
}
