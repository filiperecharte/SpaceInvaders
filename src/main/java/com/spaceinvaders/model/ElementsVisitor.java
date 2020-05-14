package com.spaceinvaders.model;

import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.shots.Shot;
import com.spaceinvaders.model.wall.Wall;

public class ElementsVisitor implements IElementsVisitor {
    private Arena arena;

    public ElementsVisitor(Arena arena) {
        this.arena = arena;
    }

    public void visit(Ship ship) {
        arena.setShip(ship);
    }
    public void visit(Wall wall) {
        arena.getWalls().add(wall);
    }
    public void visit(Enemy enemy) {
        arena.getEnemies().add(enemy);
    }
    public void visit(Shot shot) {
        arena.getShots().add(shot);
    }
}
