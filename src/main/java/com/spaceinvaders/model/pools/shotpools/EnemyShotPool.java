package com.spaceinvaders.model.pools.shotpools;

import com.spaceinvaders.model.pools.ObjectPool;
import com.spaceinvaders.model.shots.EnemyShot;
import com.spaceinvaders.model.shots.ShipShot;

public class EnemyShotPool extends ObjectPool<EnemyShot> {

    public EnemyShotPool() {
        super();
    }

    @Override
    public EnemyShot create() {
        return new EnemyShot();
    }
}
