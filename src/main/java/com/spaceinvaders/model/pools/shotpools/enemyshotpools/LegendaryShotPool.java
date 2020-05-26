package com.spaceinvaders.model.pools.shotpools.enemyshotpools;

import com.spaceinvaders.model.pools.ObjectPool;
import com.spaceinvaders.model.shots.shotvariants.LegendaryShot;

public class LegendaryShotPool extends ObjectPool<LegendaryShot> {

    public LegendaryShotPool() {
        super();
    }

    @Override
    public LegendaryShot create() {
        return new LegendaryShot();
    }
}
