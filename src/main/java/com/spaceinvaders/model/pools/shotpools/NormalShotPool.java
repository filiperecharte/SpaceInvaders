package com.spaceinvaders.model.pools.shotpools;

import com.spaceinvaders.model.pools.ObjectPool;
import com.spaceinvaders.model.shots.NormalShot;

public class NormalShotPool extends ObjectPool<NormalShot> {

    public NormalShotPool() {
        super();
    }

    @Override
    public NormalShot create() {
        return new NormalShot();
    }
}
