package com.spaceinvaders.model.pools.shotpools;

import com.spaceinvaders.model.shots.EnemyShot;
import com.spaceinvaders.model.shots.ShipShot;

public class ShotPoolVisitor implements IShotPoolVisitor {
    private ShotPoolGroup shotPoolGroup;

    public ShotPoolVisitor(ShotPoolGroup shotPoolGroup) {
        this.shotPoolGroup = shotPoolGroup;
    }

    @Override
    public void visit(ShipShot shipShot) {
        shotPoolGroup.getShipShotPool().put(shipShot);
    }

    @Override
    public void visit(EnemyShot enemyShot) {
        shotPoolGroup.getEnemyShotPool().put(enemyShot);
    }
}
