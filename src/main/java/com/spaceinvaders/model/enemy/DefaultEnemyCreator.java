package com.spaceinvaders.model.enemy;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.image.Pixel;
import com.spaceinvaders.model.image.PixelMatrix;

public class DefaultEnemyCreator implements EnemyCreator {

    @Override
    public Enemy createEnemy(Position position, Size size) {

        Enemy enemy = null;

        try {
            enemy = new Enemy(position, size);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return enemy;
    }

}
