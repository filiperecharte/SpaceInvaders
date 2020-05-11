package com.spaceinvaders.model.pools.shotpools;

import com.spaceinvaders.model.pools.ObjectPool;
import com.spaceinvaders.model.shots.ShipShot;

public class ShipShotPool extends ObjectPool<ShipShot> {

    public ShipShotPool() {
        super();
    }

    @Override
    public ShipShot create() {
        return new ShipShot();
    }
}
