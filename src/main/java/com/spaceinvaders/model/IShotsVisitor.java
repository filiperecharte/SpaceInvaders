package com.spaceinvaders.model;

import com.spaceinvaders.model.shots.EnemyShot;
import com.spaceinvaders.model.shots.ShipShot;

public interface IShotsVisitor {
    void visit(ShipShot shipShot);
    void visit(EnemyShot enemyShot);
}
