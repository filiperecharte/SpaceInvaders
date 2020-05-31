package com.spaceinvaders.model.collisions;

import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.shots.Shot;
import com.spaceinvaders.model.wall.Fragment;

public class CollideableVisitor implements ICollideableVisitor {
    private Arena arena;
    private Shot shot;

    public CollideableVisitor(Arena arena, Shot shot) {
        this.arena = arena;
        this.shot=shot;
    }

    public void visit(Ship ship) {
        shot.getDamageBehavior().applyDamage(ship.getHealthyBehavior());
    }

    public void visit(Fragment wallFragment) {
        for (int i=0; i<arena.getWalls().size();i++){
            for (int j=0; j<arena.getWalls().get(i).getFragments().size();j++){
                if (arena.getWalls().get(i).getFragments().get(j).equals(wallFragment))
                    arena.getWalls().get(i).getFragments().remove(wallFragment);
            }
        }
    }

    public void visit(Enemy enemy) {
        shot.getDamageBehavior().applyDamage(enemy.getHealthyBehavior());
        if (enemy.getHealthyBehavior().isDead()) {
            arena.getEnemies().remove(enemy);
            arena.increaseScore();
        }
    }

}
