package com.spaceinvaders.model.pools.shotpools.enemyshotpools;

import com.spaceinvaders.model.pools.ObjectPool;
import com.spaceinvaders.model.shots.enemyshotvariants.SlickShot;

public class SlickShotPool extends ObjectPool<SlickShot> {

    public SlickShotPool() {
        super();
    }

    @Override
    public Object getObjectType() {
        return SlickShot.class;
    }
}
