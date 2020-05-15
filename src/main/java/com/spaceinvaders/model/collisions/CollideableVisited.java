package com.spaceinvaders.model.collisions;

import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.wall.Wall;

public class CollideableVisited implements ICollideableVisited{
    private Arena arena;

    public CollideableVisited(Arena arena) {
        this.arena = arena;
    }

    public void acceptShot(Ship ship) {
        //decrease ship lifes
    }
    public void acceptShot(Wall wall) {
        arena.getWalls().remove(wall);
    }
    public void acceptShot(Enemy enemy) {
        arena.getEnemies().remove(enemy);
        //aqui depois eliminamos conforme a strenght do enemy
    }
}
