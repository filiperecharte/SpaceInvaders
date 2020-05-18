package com.spaceinvaders.model.collisions;

public interface ICollideableVisited {
    void acceptShot(ICollideableVisitor collideableVisitor);
}
