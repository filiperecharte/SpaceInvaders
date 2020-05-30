package com.spaceinvaders.model.pools;

import com.spaceinvaders.model.shots.Shot;

public class ShotPool extends ObjectPool<Shot> {

    public ShotPool() {
        super();
    }

    @Override
    public Shot create() {
        return new Shot();
    }
}
