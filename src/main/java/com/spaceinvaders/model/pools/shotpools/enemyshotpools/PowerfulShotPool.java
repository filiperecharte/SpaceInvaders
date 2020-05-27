package com.spaceinvaders.model.pools.shotpools.enemyshotpools;

import com.spaceinvaders.model.pools.ObjectPool;
import com.spaceinvaders.model.shots.enemyshotvariants.PowerfulShot;

public class PowerfulShotPool extends ObjectPool<PowerfulShot> {

    public PowerfulShotPool() {
        super();
    }

    @Override
    public Object getObjectType() {
        return PowerfulShot.class;
    }
}
