package com.spaceinvaders.model.pools.shotpools.enemyshotpools;

import com.spaceinvaders.model.pools.ObjectPool;
import com.spaceinvaders.model.shots.shotvariants.PowerfulShot;

public class PowerfulShotPool extends ObjectPool<PowerfulShot> {

    public PowerfulShotPool() {
        super();
    }

    @Override
    public PowerfulShot create() {
        return new PowerfulShot();
    }
}
