package com.spaceinvaders.controller.states.playstate.playstatecontrollers;

import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.pools.ShotPool;
import com.spaceinvaders.model.shots.Shot;

public class EnemiesShotsGenerator {
    private Arena arena;
    private ShotPool shotPool;
    private int whenToShoot;
    private Enemy enemyToShoot;

    public EnemiesShotsGenerator(Arena arena, ShotPool shotPool) {
        this.arena = arena;
        this.shotPool = shotPool;
    }

    public void generate() {
        Shot shot = shotPool.extract();
        enemyToShoot.recycleShot(shot);
        arena.addElement(shot);
    }

    public boolean enemyReadyToShoot() {
        return !arena.getEnemies().isEmpty() && enemyToShoot.getAttackBehavior().readyToShoot(whenToShoot);
    }

    public void setWhenToShoot(int whenToShoot) {
        this.whenToShoot = whenToShoot;
    }

    public void setEnemyIndex(int enemyIndex) {
        this.enemyToShoot = arena.getEnemies().get(enemyIndex);
    }
}
