package com.spaceinvaders.controller;

import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.geometry.Translation;
import com.spaceinvaders.model.geometry.Vector;

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
            enemy.setVelocity(new Vector(0, 0).sub(enemy.getVelocity()));
        }
    }

    public boolean enemiesNeedToInvertVelocity() {
        int leftMostEnemyX = arena.getLeftMostEnemy().getPosition().getX();
        int rightMostEnemyX = arena.getRightMostEnemy().getPosition().getX();
        int rightMostEnemyWidth = arena.getRightMostEnemy().getSize().getWidth();
        int arenaX = arena.getPosition().getX();
        int arenaWidth = arena.getSize().getWidth();

        boolean noEnemies = !arena.getEnemies().isEmpty();
        boolean leftMostEnemyOut = leftMostEnemyX <= arenaX;
        boolean rightMostEnemyOut = rightMostEnemyX + rightMostEnemyWidth > arenaX + arenaWidth;

        return noEnemies && (leftMostEnemyOut || rightMostEnemyOut);
    }

    public void updateEnemy(Enemy enemy) {
        enemyTranslation.setPosition(enemy.getPosition());
        enemyTranslation.setVector(enemy.getVelocity());
        enemy.setPosition(enemyTranslation.apply());
    }

    public void updateEnemies() {
        for (Enemy enemy : arena.getEnemies()) {
            updateEnemy(enemy);
        }
    }
}
