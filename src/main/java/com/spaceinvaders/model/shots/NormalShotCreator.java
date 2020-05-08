package com.spaceinvaders.model.shots;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.image.Pixel;

public class NormalShotCreator implements ShotCreator {
    public Shot create(Position position, Size size) {
        Image shotImage = new Image();

        shotImage.addPixel(new Pixel(new Position(0, 0), '.'));

        shotImage.setColor("#000000");
        shotImage.setBold(true);

        return new Shot(position, size, shotImage, 1);
    }
}
