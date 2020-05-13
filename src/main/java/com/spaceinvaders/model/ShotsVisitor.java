package com.spaceinvaders.model;

import com.spaceinvaders.model.pools.shotpools.EnemyShotPool;
import com.spaceinvaders.model.pools.shotpools.ShipShotPool;
import com.spaceinvaders.model.pools.shotpools.ShotPoolGroup;
import com.spaceinvaders.model.shots.EnemyShot;
import com.spaceinvaders.model.shots.ShipShot;

public class ShotsVisitor implements IShotsVisitor {
    private ShotPoolGroup shotPoolGroup;

    public ShotsVisitor(ShotPoolGroup shotPoolGroup) {
        this.shotPoolGroup = shotPoolGroup;
    }

    public void visit(ShipShot shipShot) {
        shotPoolGroup.getShipShotPool().put(shipShot);
    }
    public void visit(EnemyShot enemyShot) {
    }
}
