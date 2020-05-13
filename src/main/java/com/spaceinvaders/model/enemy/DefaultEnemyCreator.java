package com.spaceinvaders.model.enemy;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.image.Pixel;
import com.spaceinvaders.model.image.PixelMatrix;

public class DefaultEnemyCreator implements EnemyCreator {

    @Override
    public Enemy build(Position position, Size size) {

        Image enemyImage = new Image();
        PixelMatrix pixelMatrix = enemyImage.getPixelMatrix();
        try {
            pixelMatrix.addPixel(new Pixel(new Position(0, 0), '/'));
            pixelMatrix.addPixel(new Pixel(new Position(1, 0), 'o'));
            pixelMatrix.addPixel(new Pixel(new Position(2, 0), '\\'));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        enemyImage.setColor("#000080");
        enemyImage.setBold(true);

        return new Enemy(position, size, enemyImage);
    }

}
