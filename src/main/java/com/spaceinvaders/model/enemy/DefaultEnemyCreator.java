package com.spaceinvaders.model.enemy;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;

public class DefaultEnemyCreator implements EnemyCreator {

    @Override
    public Enemy createEnemy(Position position, Size size) {

        Enemy enemy = null;

        try {
            enemy = new Enemy(position, size, new Vector(1, 0));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return enemy;
    }

}
