package com.spaceinvaders.controller;

import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Translation;
import com.spaceinvaders.model.pools.ShotPool;
import com.spaceinvaders.model.shots.ShipShot;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.shots.Shot;

import java.util.Random;
import java.util.Iterator;


public class ShotsController {
    private Arena arena;
    private Translation shotTranslation;
    private ShotPool shotPool;

    public ShotsController(Arena arena, ShotPool shotPool) {
        this.arena = arena;
        this.shotPool = shotPool;
        shotTranslation = new Translation();
    }

    public void processShots() {
        Shot shot;
        for (Iterator<Shot> shotIterator = arena.getShots().iterator(); shotIterator.hasNext();) {
            shot = shotIterator.next();
            updateShot(shot);
            checkShotCollision(shot,shotIterator);

            if (!arena.contain(shot.getPosition())) {
                shotToPoolGroup(shot,shotIterator);
            }
        }
    }

    public void updateShot(Shot shot) {
        shotTranslation.setPosition(shot.getPosition());
        shotTranslation.setVector(shot.getMovableBehavior().getVelocity());
        shot.setPosition(shotTranslation.apply());
    }

    public void generateEnemyShot(){
        int whenToShoot = makeRandom().nextInt(100);
        int whatEnemyIndex = makeRandom().nextInt(arena.getEnemies().size());
        Enemy enemy = arena.getEnemies().get(whatEnemyIndex);

        Shot shot;
        if (!arena.getEnemies().isEmpty() && enemy.getAttackBehavior().readyToShoot(whenToShoot)) {
            Position shootEnemyPosition = enemy.getShootPosition();

            shot = shotPool.extract(enemy.getShotType());
            if (shot == null){ shot = enemy.createShot();}
            shot.setPosition(shootEnemyPosition);

            arena.addElement(shot);
        }

    }

    public void checkShotCollision(Shot shot, Iterator<Shot> shotIterator){
        for (int i=0;i<arena.getWalls().size();i++) {
            for (int j=0;j<arena.getWalls().get(i).getFragments().size();j++) {
                if (arena.getWalls().get(i).getFragments().get(j).contain(shot.getPosition())) {
                    arena.colide(arena.getWalls().get(i).getFragments().get(j), shot);
                    shotToPoolGroup(shot,shotIterator);
                }
            }
        }

        if (shot instanceof ShipShot) {
            for (int i = 0; i < arena.getEnemies().size(); i++) {
                if (arena.getEnemies().get(i).contain(shot.getPosition())) {
                    arena.colide(arena.getEnemies().get(i), shot);
                    shotToPoolGroup(shot, shotIterator);
                }
            }
        }

        if (arena.getShip().contain(shot.getPosition())) {
            arena.colide(arena.getShip(), shot);
            shotToPoolGroup(shot, shotIterator);
        }
    }

    public void shotToPoolGroup(Shot shot, Iterator<Shot> shotIterator){
        shotPool.put(shot);
        shotIterator.remove();
    }

    public Random makeRandom() {
        return new Random();
    }

}
