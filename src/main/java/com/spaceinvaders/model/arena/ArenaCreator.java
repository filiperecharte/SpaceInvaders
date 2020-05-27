package com.spaceinvaders.model.arena;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.enemy.enemyvariants.*;
import com.spaceinvaders.model.ship.ShipCreator;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.wall.DefaultWallCreator;

public class ArenaCreator {
    private static final int FIRST_WALL_X = 5;
    private static final int WALLS_Y = 18;
    private static final int NUMBER_WALLS = 5;
    private static final int WALLS_X_DISTANCE = 15;

    private static final int FIRST_ENEMY_X = 5;
    private static final int FIRST_ENEMY_Y = 10;
    private static final int NUMBER_ENEMIES_ROW = 8;
    private static final int ENEMIES_X_DISTANCE = 5;
    private static final int ENEMIES_Y_DISTANCE = 1;

    public Arena createArena(Position position,Size size, String backgroundColor) {
        Arena arena = new Arena(position,size, backgroundColor);
        Ship ship = new ShipCreator().createShip();
        arena.addElement(ship);

        // create walls
        int Wposx = FIRST_WALL_X;
        for(int i = 0; i < NUMBER_WALLS; i++) {
            arena.addElement((new DefaultWallCreator()).build(new Position(Wposx, WALLS_Y)));
            Wposx += WALLS_X_DISTANCE;
        }

        // Old Enemy
        int currentEnemyX = FIRST_ENEMY_X;
        int currentEnemyY = FIRST_ENEMY_Y;
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

        return arena;
    }
}
