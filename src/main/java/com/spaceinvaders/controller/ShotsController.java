package com.spaceinvaders.controller;

import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.geometry.Translaction;
import com.spaceinvaders.model.pools.shotpools.EnemyShotPool;
import com.spaceinvaders.model.pools.shotpools.ShipShotPool;

public class ShotsController {
    private Arena arena;
    private Translaction shotTranslaction;

    private ShipShotPool shipShotPool;
    private EnemyShotPool enemyShotPool;


    public ShotsController(Arena arena) {
        this.arena = arena;
        shotTranslaction = new Translaction();
    }

    /*public void processShots() {
        for (int shotIndex = 0; shotIndex < arena.getShots().size(); shotIndex++) {
            shotTranslaction.setPosition(arena.getShots().get(shotIndex).getPosition());
            shotTranslaction.setVector(arena.getShots().get(shotIndex).getVelocity());
            arena.getShots().get(shotIndex).setPosition(shotTranslaction.apply());

            if (!arena.contain(arena.getShots().get(shotIndex).getPosition())) {

            }
        }
    }*/
}
