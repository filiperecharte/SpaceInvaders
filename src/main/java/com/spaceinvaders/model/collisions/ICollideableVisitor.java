package com.spaceinvaders.model.collisions;

import com.spaceinvaders.model.shots.Shot;

public interface ICollideableVisitor {
    void resolveCollision( Shot shot );
}
