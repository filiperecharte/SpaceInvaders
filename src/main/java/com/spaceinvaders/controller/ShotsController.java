package com.spaceinvaders.controller;

import com.spaceinvaders.model.IShotVisited;
import com.spaceinvaders.model.ShotsVisitor;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.geometry.Translaction;
import com.spaceinvaders.model.pools.shotpools.EnemyShotPool;
import com.spaceinvaders.model.pools.shotpools.ShipShotPool;
import com.spaceinvaders.model.pools.shotpools.ShotPoolGroup;
import com.spaceinvaders.model.shots.Shot;

public class ShotsController {
    private Arena arena;
    private Translaction shotTranslaction;

    private ShotPoolGroup shotPoolGroup;


    public ShotsController(Arena arena, ShotPoolGroup shotPoolGroup) {
        this.arena = arena;
        this.shotPoolGroup = shotPoolGroup;
        shotTranslaction = new Translaction();
    }

    public void processShots() {

        Shot shot;
        IShotVisited shotVisited;
        for (int shotIndex = 0; shotIndex < arena.getShots().size(); shotIndex++) {
            shot = arena.getShots().get(shotIndex);
            shotTranslaction.setPosition(shot.getPosition());
            shotTranslaction.setVector(shot.getVelocity());
            shot.setPosition(shotTranslaction.apply());

            if (!arena.contain(shot.getPosition())) {
                shotVisited = (IShotVisited)shot;
                shotVisited.accept(new ShotsVisitor(shotPoolGroup));
            }
        }
    }
}
