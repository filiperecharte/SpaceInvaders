package com.spaceinvaders.view.lanternaview.imagesfactories;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;

public class EnemyImageFactory implements ImageFactory {

    public TextImage createTextImage(ImageInfo imageInfo){

        switch (imageInfo.getImageName()) {
            case "OldEnemyImg":
                return oldEnemyImage(imageInfo.getBackgroundColor());
            case "YoungEnemyImg":
                return youngEnemyImage(imageInfo.getBackgroundColor());
            case "WiseEnemyImg":
                return wiseEnemyImage(imageInfo.getBackgroundColor());
            case "StrongEnemyImg":
                return strongEnemyImage(imageInfo.getBackgroundColor());
            case "SuperiorEnemyImg":
                return superiorEnemyImage(imageInfo.getBackgroundColor());
        }

        return null;
    }

    public TextImage oldEnemyImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(5, 1);

        image.setCharacterAt(0, 0, new TextCharacter('_', new TextColor.RGB(0, 100, 0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(1, 0, new TextCharacter('-', new TextColor.RGB(0, 100, 0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(2, 0, new TextCharacter('0', new TextColor.RGB(0, 100, 0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(3, 0, new TextCharacter('-', new TextColor.RGB(0, 100, 0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(4, 0, new TextCharacter('_', new TextColor.RGB(0, 100, 0), backgroundColor, SGR.BOLD));

        return image;
    }

    public TextImage youngEnemyImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(3, 1);

        image.setCharacterAt(0, 0, new TextCharacter('-', new TextColor.RGB(255,140,0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(1, 0, new TextCharacter('o', new TextColor.RGB(255,140,0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(2, 0, new TextCharacter('-', new TextColor.RGB(255,140,0), backgroundColor, SGR.BOLD));

        return image;
    }

    public TextImage wiseEnemyImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(5, 1);

        image.setCharacterAt(0, 0, new TextCharacter('/', new TextColor.RGB(255,140,0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(1, 0, new TextCharacter('_', new TextColor.RGB(255,140,0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(2, 0, new TextCharacter('^', new TextColor.RGB(255,140,0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(3, 0, new TextCharacter('_', new TextColor.RGB(255,140,0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(4, 0, new TextCharacter('/', new TextColor.RGB(255,140,0), backgroundColor, SGR.BOLD));

        return image;
    }

    public TextImage strongEnemyImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(5, 1);

        image.setCharacterAt(0, 0, new TextCharacter('/', new TextColor.RGB(128, 0, 0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(1, 0, new TextCharacter('~', new TextColor.RGB(128, 0, 0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(2, 0, new TextCharacter('^', new TextColor.RGB(128, 0, 0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(3, 0, new TextCharacter('~', new TextColor.RGB(128, 0, 0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(4, 0, new TextCharacter('/', new TextColor.RGB(128, 0, 0), backgroundColor, SGR.BOLD));

        return image;
    }

    public TextImage superiorEnemyImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(3, 1);

        image.setCharacterAt(0, 0, new TextCharacter('/', new TextColor.RGB(0, 0, 128), backgroundColor, SGR.BOLD));
        image.setCharacterAt(1, 0, new TextCharacter('o', new TextColor.RGB(0, 0, 128), backgroundColor, SGR.BOLD));
        image.setCharacterAt(2, 0, new TextCharacter('\\', new TextColor.RGB(0, 0, 128), backgroundColor, SGR.BOLD));

        return image;
    }
}
