package com.spaceinvaders.model.pools.shotpools.enemyshotpools;

import com.spaceinvaders.model.pools.ObjectPool;
import com.spaceinvaders.model.shots.shotvariants.WeakShot;

public class WeakShotPool extends ObjectPool<WeakShot> {

    public WeakShotPool() {
        super();
    }

    @Override
    public WeakShot create() {
        return new WeakShot();
    }
}
