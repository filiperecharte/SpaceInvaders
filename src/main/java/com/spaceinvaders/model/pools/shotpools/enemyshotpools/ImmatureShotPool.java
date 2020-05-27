package com.spaceinvaders.model.pools.shotpools.enemyshotpools;

import com.spaceinvaders.model.pools.ObjectPool;
import com.spaceinvaders.model.shots.enemyshotvariants.ImmatureShot;

public class ImmatureShotPool extends ObjectPool<ImmatureShot> {

    public ImmatureShotPool() {
        super();
    }

    @Override
    public ImmatureShot create() {
        return new ImmatureShot();
    }

    @Override
    public Object getObjectType() {
        return ImmatureShot.class;
    }
}
