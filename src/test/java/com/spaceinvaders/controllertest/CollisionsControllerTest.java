package com.spaceinvaders.controllertest;

import com.spaceinvaders.controller.states.playstate.playstatecontrollers.CollisionsController;
import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.behaviors.HealthyBehavior;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.shots.ShipShot;
import com.spaceinvaders.model.shots.Shot;
import com.spaceinvaders.model.wall.Fragment;
import com.spaceinvaders.model.wall.Wall;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class CollisionsControllerTest {
    private CollisionsController collisionsController;
    private Arena mockArena;

    @Before
    public void setUp() {
        collisionsController = new CollisionsController();

        List<Wall> walls = new ArrayList<>();
        Wall wall1 = new Wall(new Position(2, 10));
        Wall wall2 = new Wall(new Position(3, 10));
        Wall wall3 = new Wall(new Position(4, 10));

        try {
            wall1.addFragment(new Fragment(new Position(2, 10), new Size(1, 1)));
            wall2.addFragment(new Fragment(new Position(3, 10), new Size(1, 1)));
            wall3.addFragment(new Fragment(new Position(4, 10), new Size(1, 1)));
        } catch (IllegalArgumentException e) { e.printStackTrace(); }

        walls.add(wall1);
        walls.add(wall2);
        walls.add(wall3);

        List<Enemy> enemies = new ArrayList<>();

        try {
            enemies.add(new Enemy(new Position(3, 5), new Size(3, 1)));
            enemies.add(new Enemy(new Position(6, 5), new Size(3, 1)));
            enemies.add(new Enemy(new Position(9, 5), new Size(3, 1)));
        } catch (IllegalArgumentException e) { e.printStackTrace(); }

        Ship ship = null;

        try {
            ship = new Ship(new Position(10, 10), new Size(5, 3), new HealthyBehavior(10));
        } catch (IllegalArgumentException e) { e.printStackTrace(); }

        mockArena = Mockito.mock(Arena.class);

        when(mockArena.getWalls()).thenReturn(walls);
        when(mockArena.getEnemies()).thenReturn(enemies);
        when(mockArena.getShip()).thenReturn(ship);

        collisionsController = new CollisionsController();
        collisionsController.setArena(mockArena);
    }

    @Test
    public void processWallsCollisionsTest() {
        Shot shot = new Shot(new Position(2, 10), new Size(1, 1));
        collisionsController.setShot(shot);
        assertTrue(collisionsController.processWallsCollisions());

        shot = new Shot(new Position(3, 10), new Size(1, 1));
        collisionsController.setShot(shot);
        assertTrue(collisionsController.processWallsCollisions());

        shot = new Shot(new Position(4, 10), new Size(1, 1));
        collisionsController.setShot(shot);
        assertTrue(collisionsController.processWallsCollisions());

        shot = new Shot(new Position(2, 9), new Size(1, 1));
        collisionsController.setShot(shot);
        assertFalse(collisionsController.processWallsCollisions());

        shot = new Shot(new Position(5, 10), new Size(1, 1));
        collisionsController.setShot(shot);
        assertFalse(collisionsController.processWallsCollisions());
    }

    @Test
    public void processEnemiesCollisionsTest() {
        Shot shot = new ShipShot();
        shot.setPosition(new Position(3, 5));
        collisionsController.setShot(shot);
        assertTrue(collisionsController.processEnemiesCollisions());

        shot.setPosition(new Position(6, 5));
        collisionsController.setShot(shot);
        assertTrue(collisionsController.processEnemiesCollisions());

        shot.setPosition(new Position(11, 5));
        collisionsController.setShot(shot);
        assertTrue(collisionsController.processEnemiesCollisions());

        shot.setPosition(new Position(2, 5));
        collisionsController.setShot(shot);
        assertFalse(collisionsController.processEnemiesCollisions());

        shot.setPosition(new Position(9, 6));
        collisionsController.setShot(shot);
        assertFalse(collisionsController.processEnemiesCollisions());

        Shot shot2 = new Shot(new Position(3, 5), new Size(1, 1));
        collisionsController.setShot(shot2);
        assertFalse(collisionsController.processEnemiesCollisions());
    }

    @Test
    public void processShipCollisionTest() {
        Shot shot = new Shot(new Position(10, 10), new Size(1, 1));
        collisionsController.setShot(shot);
        assertTrue(collisionsController.processShipCollision());

        shot = new Shot(new Position(14, 10), new Size(1, 1));
        collisionsController.setShot(shot);
        assertTrue(collisionsController.processShipCollision());

        shot = new Shot(new Position(16, 10), new Size(1, 1));
        collisionsController.setShot(shot);
        assertFalse(collisionsController.processShipCollision());
    }
}
