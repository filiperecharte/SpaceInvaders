package com.spaceinvaders.model.pools;

import com.spaceinvaders.model.pools.shotpools.EnemyShotPool;
import com.spaceinvaders.model.pools.shotpools.ShipShotPool;

public class ShotPoolGroup {
    private ShipShotPool shipShotPool;
    private EnemyShotPool enemyShotPool;

    public ShotPoolGroup() {
        shipShotPool = new ShipShotPool();
        enemyShotPool = new EnemyShotPool();
    }

    /*public void put(IShotPoolVisited shot) {
        shot.accept(new ShotsVisitor(this));
    }*/

    public ShipShotPool getShipShotPool() {
        return shipShotPool;
    }

    public void setShipShotPool(ShipShotPool shipShotPool) {
        this.shipShotPool = shipShotPool;
    }

    public EnemyShotPool getEnemyShotPool() {
        return enemyShotPool;
    }

    public void setEnemyShotPool(EnemyShotPool enemyShotPool) {
        this.enemyShotPool = enemyShotPool;
    }
}
