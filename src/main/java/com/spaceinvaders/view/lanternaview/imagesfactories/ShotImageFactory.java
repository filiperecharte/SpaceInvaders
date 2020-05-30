package com.spaceinvaders.view.lanternaview.imagesfactories;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;

public class ShotImageFactory implements ImageFactory {

    public TextImage createTextImage(ImageInfo imageInfo) {
        switch (imageInfo.getImageName()) {
            case "ShipShotImg":
                return ShipShotImage(imageInfo.getBackgroundColor());
            case "WeakShotImg":
                return WeakShotImage(imageInfo.getBackgroundColor());
            case "ImmatureShotImg":
                return ImmatureShotImage(imageInfo.getBackgroundColor());
            case "SlickShotImg":
                return SlickShotImage(imageInfo.getBackgroundColor());
            case "PowerfulShotImg":
                return PowerfulShotImage(imageInfo.getBackgroundColor());
            case "LegendaryShotImg":
                return LegendaryShotImage(imageInfo.getBackgroundColor());
        }

        return null;
    }

    public TextImage ShipShotImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(1, 1);
        image.setCharacterAt(0, 0 , new TextCharacter('.', new TextColor.RGB(0, 0, 0), backgroundColor, SGR.BOLD));
        return image;
    }

    public TextImage WeakShotImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(1, 1);
        image.setCharacterAt(0, 0 , new TextCharacter('.', new TextColor.RGB(0, 0, 0), backgroundColor, SGR.BOLD));
        return image;
    }

    public TextImage ImmatureShotImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(1, 1);
        image.setCharacterAt(0, 0 , new TextCharacter('.', new TextColor.RGB(0, 0, 0), backgroundColor, SGR.BOLD));
        return image;
    }

    public TextImage SlickShotImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(1, 1);
        image.setCharacterAt(0, 0 , new TextCharacter('0', new TextColor.RGB(0, 0, 0), backgroundColor, SGR.BOLD));
        return image;
    }

    public TextImage PowerfulShotImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(1, 1);
        image.setCharacterAt(0, 0 , new TextCharacter('o', new TextColor.RGB(100, 0, 0), backgroundColor, SGR.BOLD));
        return image;
    }

    public TextImage LegendaryShotImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(1, 1);
        image.setCharacterAt(0, 0 , new TextCharacter('*', new TextColor.RGB(0, 0, 0), backgroundColor, SGR.BOLD));
        return image;
    }
}
