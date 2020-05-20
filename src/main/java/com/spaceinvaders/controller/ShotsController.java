package com.spaceinvaders.controller;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Translation;
import com.spaceinvaders.model.shots.IShotVisited;
import com.spaceinvaders.model.shots.ShotsPoolVisitor;
import com.spaceinvaders.model.shots.ShipShot;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.pools.ShotPoolGroup;
import com.spaceinvaders.model.shots.Shot;

import java.util.Random;
import java.util.Iterator;


public class ShotsController {
    private Arena arena;
    private Translation shotTranslation;
    private ShotPoolGroup shotPoolGroup;

    public ShotsController(Arena arena, ShotPoolGroup shotPoolGroup) {
        this.arena = arena;
        this.shotPoolGroup = shotPoolGroup;
        shotTranslation = new Translation();
    }

    public void processShots() {
        Shot shot;
        for (Iterator<Shot> shotIterator = arena.getShots().iterator(); shotIterator.hasNext();) {
            shot = shotIterator.next();
            updateShot(shot);
            checkShotCollision(shot,shotIterator);

            if (!arena.containPos(shot.getPosition())) {
                shotToPoolGroup(shot,shotIterator);
            }
        }
    }

    public void updateShot(Shot shot) {
        shotTranslation.setPosition(shot.getPosition());
        shotTranslation.setVector(shot.getVelocity());
        shot.setPosition(shotTranslation.apply());
    }

    public void generateEnemyShot(){
        int whenToShoot = makeRandom().nextInt(100);
        int whatEnemy = makeRandom().nextInt(arena.getEnemies().size());

        if (!arena.getEnemies().isEmpty() && whenToShoot%15==0) { //diminuindo o divisor são gerados mais tiros
            Position shootEnemyPosition = arena.getEnemies().get(whatEnemy).getShootPosition();
            Shot shot = shotPoolGroup.getEnemyShotPool().extract();
            shot.setPosition(shootEnemyPosition);
            arena.addElement(shot);
        }
    }

    public void checkShotCollision(Shot shot, Iterator<Shot> shotIterator){
        for (int i=0;i<arena.getWalls().size();i++) {
            for (int j=0;j<arena.getWalls().get(i).getFragments().size();j++) {
                if (arena.getWalls().get(i).getFragments().get(j).containPos(shot.getPosition())) {
                    arena.colide(arena.getWalls().get(i).getFragments().get(j), shot);
                    shotToPoolGroup(shot,shotIterator);
                }
            }
        }

        if (shot instanceof ShipShot) {
            for (int i = 0; i < arena.getEnemies().size(); i++) {
                if (arena.getEnemies().get(i).containPos(shot.getPosition())) {
                    arena.colide(arena.getEnemies().get(i), shot);
                    shotToPoolGroup(shot, shotIterator);
                }
            }
        }

        if (arena.getShip().containPos(shot.getPosition())) {
            arena.colide(arena.getShip(), shot);
            shotToPoolGroup(shot, shotIterator);
        }
    }

    public void shotToPoolGroup(Shot shot, Iterator<Shot> shotIterator){
        IShotVisited shotVisited;
        shotVisited = (IShotVisited) shot;
        shotVisited.accept(new ShotsPoolVisitor(shotPoolGroup));
        shotIterator.remove();
    }

    public Random makeRandom() {
        return new Random();
    }

}
