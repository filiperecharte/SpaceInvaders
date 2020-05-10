package com.spaceinvaders.model.enemy;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.image.Pixel;

public class DefaultEnemyCreator implements EnemyCreator {

    @Override
    public Enemy build(Position position, Size size) {

        Image enemyImage = new Image();
        enemyImage.addPixel(new Pixel(new Position(0, 0), '/'));
        enemyImage.addPixel(new Pixel(new Position(1, 0), 'o'));
        enemyImage.addPixel(new Pixel(new Position(2, 0), '\\'));
        enemyImage.setColor("#000080");
        enemyImage.setBold(true);

        return new Enemy(position, size, enemyImage);
    }

}
