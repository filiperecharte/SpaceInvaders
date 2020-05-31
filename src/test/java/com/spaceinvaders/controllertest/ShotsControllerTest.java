package com.spaceinvaders.controllertest;

import com.spaceinvaders.controller.states.playstate.playstatecontrollers.ShotsController;
import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.behaviors.AttackBehavior;
import com.spaceinvaders.model.behaviors.DamageBehavior;
import com.spaceinvaders.model.behaviors.HealthyBehavior;
import com.spaceinvaders.model.behaviors.MovableBehavior;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;
import com.spaceinvaders.model.pools.ShotPool;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.shots.Shot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShotsControllerTest {

    @Test
    public void processShotsTest1() {
        Arena arena = new Arena(new Position(0, 0), new Size(10, 10), "");
        try {
            arena.addElement(new Ship(new Position(0, 0), new Size(5, 1), new HealthyBehavior(1)));

            Shot shot = new Shot(new Position(10, 10), new Size(1, 1));
            shot.setDamageBehavior(new DamageBehavior(1));
            shot.setMovableBehavior(new MovableBehavior(new Vector(0, -1)));
            arena.addElement(shot);

        } catch (IllegalArgumentException e) { e.printStackTrace(); }

        assertEquals(1, arena.getShots().size());
        ShotsController shotsController = new ShotsController(arena, new ShotPool());
        shotsController.processShots();
        assertEquals(0, arena.getShots().size());
    }

    @Test
    public void processShotsTest2() {
        Arena arena = new Arena(new Position(0, 0), new Size(10, 10), "");
        try {
            arena.addElement(new Ship(new Position(0, 0), new Size(5, 1), new HealthyBehavior(1)));

            Shot shot = new Shot(new Position(5, 5), new Size(1, 1));
            shot.setDamageBehavior(new DamageBehavior(1));
            shot.setMovableBehavior(new MovableBehavior(new Vector(0, -1)));
            arena.addElement(shot);

        } catch (IllegalArgumentException e) { e.printStackTrace(); }

        assertEquals(1, arena.getShots().size());
        ShotsController shotsController = new ShotsController(arena, new ShotPool());
        shotsController.processShots();
        assertEquals(1, arena.getShots().size());
    }

    @Test
    public void processShotsTest3() {
        Arena arena = new Arena(new Position(0, 0), new Size(10, 10), "");
        try {
            arena.addElement(new Ship(new Position(0, 0), new Size(5, 1), new HealthyBehavior(1)));

            Enemy enemy = new Enemy(new Position(6, 6), new Size(3, 1));
            enemy.setAttackBehavior(new AttackBehavior(10));
            enemy.setHealthyBehavior(new HealthyBehavior(1));
            enemy.setMovableBehavior(new MovableBehavior(new Vector(1, 0)));
            arena.addElement(enemy);

            Shot shot = new Shot(new Position(6, 6), new Size(1, 1), "ShipShot", "ShipShotImg");
            shot.setDamageBehavior(new DamageBehavior(1));
            shot.setMovableBehavior(new MovableBehavior(new Vector(0, -1)));
            arena.addElement(shot);

        } catch (IllegalArgumentException e) { e.printStackTrace(); }

        assertEquals(1, arena.getShots().size());
        ShotsController shotsController = new ShotsController(arena, new ShotPool());
        shotsController.processShots();
        assertEquals(0, arena.getShots().size());
    }

    @Test
    public void processShotsTest4() {
        Arena arena = new Arena(new Position(0, 0), new Size(10, 10), "");
        try {
            arena.addElement(new Ship(new Position(0, 0), new Size(5, 1), new HealthyBehavior(1)));

            Enemy enemy = new Enemy(new Position(6, 6), new Size(3, 1));
            enemy.setAttackBehavior(new AttackBehavior(10));
            enemy.setHealthyBehavior(new HealthyBehavior(1));
            enemy.setMovableBehavior(new MovableBehavior(new Vector(1, 0)));
            arena.addElement(enemy);

            Shot shot = new Shot(new Position(6, 5), new Size(1, 1), "ShipShot", "ShipShotImg");
            shot.setDamageBehavior(new DamageBehavior(1));
            shot.setMovableBehavior(new MovableBehavior(new Vector(0, -1)));
            arena.addElement(shot);

        } catch (IllegalArgumentException e) { e.printStackTrace(); }

        assertEquals(1, arena.getShots().size());
        ShotsController shotsController = new ShotsController(arena, new ShotPool());
        shotsController.processShots();
        assertEquals(1, arena.getShots().size());
    }
}
