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

    private CollisionsController collisionsController;
    private EnemyShotGenerator enemyShotGenerator;

    public ShotsController(Arena arena, ShotPool shotPool) {
        this.arena = arena;
        this.shotPool = shotPool;
        shotTranslation = new Translation();
        collisionsController = new CollisionsController();
        enemyShotGenerator = new EnemyShotGenerator();
    }

    public void generateEnemiesShots() {
        enemyShotGenerator.setArena(arena);
        enemyShotGenerator.setShotPool(shotPool);

        int whenToShoot = new Random().nextInt(100);
        int whatEnemyIndex = new Random().nextInt(arena.getEnemies().size());
        Enemy enemy = arena.getEnemies().get(whatEnemyIndex);

        if (enemyShotGenerator.ready(whenToShoot, enemy)) {
            arena.addElement(enemyShotGenerator.generateShot(enemy));
        }
    }

    public void processShots() {
        Iterator<Shot> shotsIterator = arena.getShots().iterator();
        while (shotsIterator.hasNext()) {
            Shot shot = shotsIterator.next();

            boolean collision = processCollisions(shot);

            updateShot(shot);

            if (!arena.contain(shot.getPosition()) || collision) {
                shotPool.put(shot);
                shotsIterator.remove();
            }
        }
    }

    private boolean processCollisions(Shot shot) {
        collisionsController.setArena(arena);
        collisionsController.setShot(shot);
        boolean wallsCollision = collisionsController.processWallsCollisions();
        boolean enemiesCollision = collisionsController.processEnemiesCollisions();
        boolean shipCollision = collisionsController.processShipCollision();

        return wallsCollision || enemiesCollision || shipCollision;
    }

    private void updateShot(Shot shot) {
        shotTranslation.setPosition(shot.getPosition());
        shotTranslation.setVector(shot.getMovableBehavior().getVelocity());
        shot.setPosition(shotTranslation.apply());
    }
}
