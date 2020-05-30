package com.spaceinvaders.controller.states.playstate.playstatecontrollers;

import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.shots.Shot;

public class CollisionsController {
    Arena arena;
    Shot shot;

    public CollisionsController() {}

    public boolean processWallsCollisions() {
        for (int i=0;i<arena.getWalls().size();i++) {
            for (int j=0;j<arena.getWalls().get(i).getFragments().size();j++) {
                if (arena.getWalls().get(i).getFragments().get(j).contain(shot.getPosition())) {
                    arena.colide(arena.getWalls().get(i).getFragments().get(j), shot);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean processEnemiesCollisions() {
        if (shot.getName().equals("ShipShot")) {
            for (int i = 0; i < arena.getEnemies().size(); i++) {
                if (arena.getEnemies().get(i).contain(shot.getPosition())) {
                    arena.colide(arena.getEnemies().get(i), shot);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean processShipCollision() {
        if (arena.getShip().contain(shot.getPosition())) {
            arena.colide(arena.getShip(), shot);
            return true;
        }
        return false;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }
}
