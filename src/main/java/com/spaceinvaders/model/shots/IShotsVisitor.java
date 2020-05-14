package com.spaceinvaders.model.shots;

public interface IShotsVisitor {
    void visit(ShipShot shipShot);
    void visit(EnemyShot enemyShot);
}
