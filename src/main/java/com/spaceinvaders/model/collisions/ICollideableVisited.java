package com.spaceinvaders.model.collisions;

import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.wall.Wall;

public interface ICollideableVisited {
    void acceptShot(Ship ship);
    void acceptShot(Wall wall);
    void acceptShot(Enemy enemy);
}
