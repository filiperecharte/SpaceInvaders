package com.spaceinvaders.modeltest;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.behaviors.DamageBehavior;
import com.spaceinvaders.model.behaviors.HealthyBehavior;
import com.spaceinvaders.model.collisions.CollideableVisitor;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.shots.Shot;
import org.junit.Before;
import org.junit.Test;
import com.spaceinvaders.model.wall.DefaultWallCreator;

import static org.junit.Assert.*;

public class CollideableVisitorTest {

    private Arena arena;
    private Enemy enemy;
    private Shot shot;
    private CollideableVisitor collideableVisitor;
    private HealthyBehavior healthyBehavior;

    @Before
    public void setUp() throws IllegalArgumentException {
        arena= new Arena(new Position(0, 0), new Size(10, 15));
        shot = new Shot(new Position(3, 5), new Size(1, 1),"ShipShot","ShipShotImg");
        enemy = new Enemy(new Position(15, 20), new Size(3, 1),"StrongEnemyImg");
        arena.addElement(enemy);
    }

    @Test
    public void visitFragmentTest() {

        arena.addElement((new DefaultWallCreator()).build(new Position(15, 23)));

        collideableVisitor = new CollideableVisitor(arena,new Shot(new Position(3, 5), new Size(1, 1),"WeakShot","WeakShotImg"));
        collideableVisitor.visit(arena.getWalls().get(0).getFragments().get(3));

        assertEquals(23, arena.getWalls().get(0).getFragments().size());

    }

    @Test
    public void visitEnemyTest() throws IllegalArgumentException {
        enemy.setHealthyBehavior(new HealthyBehavior(1));
        shot.setDamageBehavior(new DamageBehavior(1));

        collideableVisitor = new CollideableVisitor(arena,shot);
        collideableVisitor.visit(enemy);

       assertEquals(0,enemy.getHealthyBehavior().getCurrentHealth());
       assertEquals(0,arena.getEnemies().size());

    }

}
