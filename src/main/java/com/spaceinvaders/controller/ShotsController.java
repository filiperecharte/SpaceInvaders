package com.spaceinvaders.controller;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.shots.IShotVisited;
import com.spaceinvaders.model.shots.ShotsVisitor;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.geometry.Translaction;
import com.spaceinvaders.model.pools.ShotPoolGroup;
import com.spaceinvaders.model.shots.Shot;

import java.util.Random;

public class ShotsController {
    private Arena arena;
    private Translaction shotTranslaction;

    private ShotPoolGroup shotPoolGroup;
    private Random rand;


    public ShotsController(Arena arena, ShotPoolGroup shotPoolGroup) {
        this.arena = arena;
        this.shotPoolGroup = shotPoolGroup;
        shotTranslaction = new Translaction();
        rand = new Random();
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

    public void generateEnemyShot(){
        Position shootEnemyPosition = arena.getEnemies().get(rand.nextInt(arena.getEnemies().size()-1)).getShootPosition();
        Shot shot = shotPoolGroup.getEnemyShotPool().extract();
        shot.setPosition(shootEnemyPosition);
        arena.addElement(shot);
    }
}
