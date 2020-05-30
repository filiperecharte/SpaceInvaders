package com.spaceinvaders.controller.states.playState;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.enemy.enemyvariants.*;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Translation;

import java.util.ArrayList;
import java.util.List;

public class EnemiesController {
    private Arena arena;
    private Translation enemyTranslation;

    private static final int FIRST_ENEMY_X = 5;
    private static final int FIRST_ENEMY_Y = 10;
    private static final int NUMBER_ENEMIES_ROW = 8;
    private static final int ENEMIES_X_DISTANCE = 5;
    private static final int ENEMIES_Y_DISTANCE = 1;
    private int new_first_enemy_y = FIRST_ENEMY_Y;

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

    public void addMoreEnemies(){
        new_first_enemy_y++;
        // Old Enemy
        int currentEnemyX = FIRST_ENEMY_X;
        int currentEnemyY = new_first_enemy_y;
        for(int i = 0; i < NUMBER_ENEMIES_ROW; i++) {
            try {
                arena.addElement(new OldEnemy(new Position(currentEnemyX+5, currentEnemyY), new Size(5, 1)));
            } catch (IllegalArgumentException e) { e.printStackTrace(); }
            currentEnemyX += ENEMIES_X_DISTANCE;
        }

        // YoungEnemy
        currentEnemyY -= ENEMIES_Y_DISTANCE;
        currentEnemyX = FIRST_ENEMY_X;
        for(int i = 0; i < NUMBER_ENEMIES_ROW; i++) {
            try {
                arena.addElement(new YoungEnemy(new Position(currentEnemyX, currentEnemyY), new Size(3, 1)));
            } catch (IllegalArgumentException e) { e.printStackTrace(); }
            currentEnemyX += ENEMIES_X_DISTANCE;
        }

        // Wise Enemy
        currentEnemyY -= ENEMIES_Y_DISTANCE;
        currentEnemyX = FIRST_ENEMY_X;
        for(int i = 0; i < NUMBER_ENEMIES_ROW; i++) {
            try {
                arena.addElement(new WiseEnemy(new Position(currentEnemyX+5, currentEnemyY), new Size(5, 1)));
            } catch (IllegalArgumentException e) { e.printStackTrace(); }
            currentEnemyX += ENEMIES_X_DISTANCE;
        }

        // Strong Enemy
        currentEnemyY -= ENEMIES_Y_DISTANCE;
        currentEnemyX = FIRST_ENEMY_X;
        for(int i = 0; i < NUMBER_ENEMIES_ROW; i++) {
            try {
                arena.addElement(new StrongEnemy(new Position(currentEnemyX, currentEnemyY), new Size(3, 1)));
            } catch (IllegalArgumentException e) { e.printStackTrace(); }
            currentEnemyX += ENEMIES_X_DISTANCE;
        }

        // Superior Enemy
        currentEnemyY -= ENEMIES_Y_DISTANCE;
        currentEnemyX = FIRST_ENEMY_X;
        for(int i = 0; i < NUMBER_ENEMIES_ROW; i++) {
            try {
                arena.addElement(new SuperiorEnemy(new Position(currentEnemyX+5, currentEnemyY), new Size(5, 1)));
            } catch (IllegalArgumentException e) { e.printStackTrace(); }
            currentEnemyX += ENEMIES_X_DISTANCE;
        }
    }

    public void updateEnemies() {
        if (arena.getEnemies().isEmpty())
            addMoreEnemies();
        for (Enemy enemy : arena.getEnemies()) {
            updateEnemy(enemy);
        }
    }

    public void setArena(Arena arena){
        this.arena=arena;
    }
}
