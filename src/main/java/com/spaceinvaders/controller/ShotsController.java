package com.spaceinvaders.controller;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.shots.IShotVisited;
import com.spaceinvaders.model.shots.ShotsVisitor;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.geometry.Translaction;
import com.spaceinvaders.model.pools.ShotPoolGroup;
import com.spaceinvaders.model.shots.Shot;

import java.util.Random;
import java.util.Iterator;


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

        for (Iterator<Shot> iterator = arena.getShots().iterator(); iterator.hasNext();) {
            shot = iterator.next();
            shotTranslaction.setPosition(shot.getPosition());
            shotTranslaction.setVector(shot.getVelocity());
            shot.setPosition(shotTranslaction.apply());

            if (!arena.contain(shot.getPosition())) {
                shotVisited = (IShotVisited)shot;
                shotVisited.accept(new ShotsVisitor(shotPoolGroup));
                iterator.remove();
            }
        }
    }

    public void generateEnemyShot(){
        if (rand.nextInt(100)%10==0) { //diminuindo o divisor são gerados mais tiros
            Position shootEnemyPosition = arena.getEnemies().get(rand.nextInt(arena.getEnemies().size())).getShootPosition();
            Shot shot = shotPoolGroup.getEnemyShotPool().extract();
            shot.setPosition(shootEnemyPosition);
            arena.addElement(shot);
        }
    }
}
