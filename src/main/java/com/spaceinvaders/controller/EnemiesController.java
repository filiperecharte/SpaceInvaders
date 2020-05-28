package com.spaceinvaders.controller;

import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.geometry.Translation;

import java.util.ArrayList;
import java.util.List;

public class EnemiesController {
    private Arena arena;
    private Translation enemyTranslation;

    public EnemiesController() {
        this.enemyTranslation = new Translation();
    }

    public void processEnemies() {

        boolean enemyChangedVelocity = false;
        List<Object> toChangeVelocityClasses = new ArrayList<>();

        for (Enemy enemy : arena.getEnemies()) {
            if (!arena.contain(enemy)) {
                enemyChangedVelocity = true;
                toChangeVelocityClasses.add(enemy.getClass());
            }
        }

        if (enemyChangedVelocity) {
            for (Enemy enemy : arena.getEnemies()) {
                for (Object enemyClass : toChangeVelocityClasses) {
                    if (enemyClass.equals(enemy.getClass())) {
                        enemy.getMovableBehavior().invertVelocity();
                    }
                }
            }
            enemyChangedVelocity = true;
        }
        updateEnemies();
    }

    public void invertEnemiesVelocity() {
        for (Enemy enemy : arena.getEnemies()) {
            enemy.getMovableBehavior().invertVelocity();
        }
    }


    public boolean enemiesNeedToInvertVelocity() {
        return !arena.getEnemies().isEmpty() && (!arena.contain(arena.getLeftMostEnemy()) || !arena.contain(arena.getRightMostEnemy()));
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

    public void setArena(Arena arena){
        this.arena=arena;
    }
}
