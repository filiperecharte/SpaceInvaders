package com.spaceinvaders.model.pools.shotpools.enemyshotpools;

import com.spaceinvaders.model.pools.ObjectPool;
import com.spaceinvaders.model.shots.EnemyShot;
import com.spaceinvaders.model.shots.shotvariants.SlickShot;

public class SlickShotPool extends ObjectPool<SlickShot> {

    public SlickShotPool() {
        super();
    }

    @Override
    public SlickShot create() {
        return new SlickShot();
    }
}
