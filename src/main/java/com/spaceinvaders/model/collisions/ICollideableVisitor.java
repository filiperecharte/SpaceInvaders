package com.spaceinvaders.model.collisions;

import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.wall.Fragment;

public interface ICollideableVisitor {
    void visit(Ship ship );
    void visit(Fragment wallFragment);
    void visit(Enemy enemy);
}
