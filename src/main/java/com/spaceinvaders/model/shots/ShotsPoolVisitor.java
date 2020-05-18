package com.spaceinvaders.model.shots;

import com.spaceinvaders.model.pools.ShotPoolGroup;

public class ShotsPoolVisitor implements IShotsVisitor {
    private ShotPoolGroup shotPoolGroup;

    public ShotsPoolVisitor(ShotPoolGroup shotPoolGroup) {
        this.shotPoolGroup = shotPoolGroup;
    }

    public void visit(ShipShot shipShot) {
        shotPoolGroup.getShipShotPool().put(shipShot);
    }
    public void visit(EnemyShot enemyShot) {
        shotPoolGroup.getEnemyShotPool().put(enemyShot);
    }
}
