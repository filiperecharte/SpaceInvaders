package com.spaceinvaders.model;

import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.shots.Shot;
import com.spaceinvaders.model.wall.Wall;

public interface IElementsVisitor {
    void visit(Ship ship);
    void visit(Wall wall);
    void visit(Enemy enemy);
    void visit(Shot shot);
}
