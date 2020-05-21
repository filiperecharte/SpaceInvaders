package com.spaceinvaders.controller;

import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.geometry.Translation;

public class EnemiesController {
    private Arena arena;
    private Translation enemyTranslation;

    public EnemiesController(Arena arena) {
        this.arena = arena;
        this.enemyTranslation = new Translation();
    }

    public void processEnemies() {
        if (enemiesNeedToInvertVelocity()) {
            invertEnemiesVelocity();
        }
        updateEnemies();
    }

    public void invertEnemiesVelocity() {
        for (Enemy enemy : arena.getEnemies()) {
            enemy.getMovableBehavior().invertVelocity();
        }
    }

    public boolean enemiesNeedToInvertVelocity() {
        return !arena.getEnemies().isEmpty() && (!arena.containBox(arena.getLeftMostEnemy()) || !arena.containBox(arena.getRightMostEnemy()));
    }

    public void updateEnemy(Enemy enemy) {
        enemyTranslation.setPosition(enemy.getPosition());
        enemyTranslation.setVector(enemy.getMovableBehavior().getVelocity());
        enemy.setPosition(enemyTranslation.apply());
    }

    public void updateEnemies() {
        for (Enemy enemy : arena.getEnemies()) {
            updateEnemy(enemy);
        }
    }
}
