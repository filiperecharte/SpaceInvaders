package com.spaceinvaders.model.collisions;

public interface ICollideableVisited {
    void accept(ICollideableVisitor collideableVisitor);
}
