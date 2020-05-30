package com.spaceinvaders.controller.states.playState;

import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.pools.ShotPool;
import com.spaceinvaders.model.shots.Shot;

import java.util.Random;

public class EnemyShotGenerator {
    private Arena arena;
    private ShotPool shotPool;

    public EnemyShotGenerator() {}

    public boolean ready(int whenToShoot, Enemy enemy) {
        return (!arena.getEnemies().isEmpty()) && (enemy.getAttackBehavior().readyToShoot(whenToShoot));
    }

    public Shot generateShot(Enemy enemy) {
        Position shootEnemyPosition = enemy.getShootPosition();

        Shot shot = shotPool.extract(enemy.getShotType());
        if (shot == null){ shot = enemy.createShot();}
        shot.setPosition(shootEnemyPosition);

        return shot;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public void setShotPool(ShotPool shotPool) {
        this.shotPool = shotPool;
    }
}
