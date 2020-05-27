package com.spaceinvaders.model.pools.shotpools.enemyshotpools;

import com.spaceinvaders.model.pools.ObjectPool;
import com.spaceinvaders.model.shots.enemyshotvariants.LegendaryShot;

public class LegendaryShotPool extends ObjectPool<LegendaryShot> {

    public LegendaryShotPool() {
        super();
    }

    @Override
    public Object getObjectType() {
        return LegendaryShot.class;
    }
}
