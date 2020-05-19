package com.spaceinvaders.controller;

import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.geometry.Vector;

public class EnemiesController {
    private Arena arena;

    public EnemiesController(Arena arena) {
        this.arena = arena;
    }

    public void processEnemies() {

    }

    public void invertEnemiesVelocity() {
        for (Enemy enemy : arena.getEnemies()) {
            enemy.setVelocity(new Vector(0, 0).sub(enemy.getVelocity()));
        }
    }

    public void updateEnemy(Enemy enemy) {
        
    }
}
