package com.spaceinvaders.model.pools.shotpools;

import com.spaceinvaders.model.shots.EnemyShot;
import com.spaceinvaders.model.shots.ShipShot;

public interface IShotPoolVisitor {
    void visit(ShipShot shipShot);
    void visit(EnemyShot enemyShot);
}
