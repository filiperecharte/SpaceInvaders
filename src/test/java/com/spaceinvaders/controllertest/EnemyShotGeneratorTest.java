package com.spaceinvaders.controllertest;

import com.spaceinvaders.controller.EnemyShotGenerator;
import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.enemy.enemyvariants.*;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.pools.ShotPool;
import com.spaceinvaders.model.shots.enemyshotvariants.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class EnemyShotGeneratorTest {
    private Arena mockArena;
    private EnemyShotGenerator enemyShotGenerator;

    @Before
    public void setUp() {

        enemyShotGenerator = new EnemyShotGenerator();

        mockArena = Mockito.mock(Arena.class);
        List<Enemy> enemies = new ArrayList<>();
        try {
            enemies.add(new Enemy(new Position(0, 0), new Size(1, 1)));
        } catch (IllegalArgumentException e) { e.printStackTrace(); }
        when(mockArena.getEnemies()).thenReturn(enemies);

        enemyShotGenerator.setArena(mockArena);
        enemyShotGenerator.setShotPool(new ShotPool());

    }

    @Test
    public void readyTest() {
        try {
            assertTrue(enemyShotGenerator.ready(15, new OldEnemy(new Position(0, 0), new Size(1, 1))));
            assertTrue(enemyShotGenerator.ready(20, new WiseEnemy(new Position(0, 0), new Size(1, 1))));
            assertFalse(enemyShotGenerator.ready(20, new OldEnemy(new Position(0, 0), new Size(1, 1))));
            assertFalse(enemyShotGenerator.ready(9, new WiseEnemy(new Position(0, 0), new Size(1, 1))));
        } catch (IllegalArgumentException e) { e.printStackTrace(); }
    }

    @Test
    public void generateShotTest() {

        try {
            OldEnemy oldEnemy = new OldEnemy(new Position(0, 0), new Size(1, 1));
            YoungEnemy youngEnemy = new YoungEnemy(new Position(0, 0), new Size(1, 1));
            WiseEnemy wiseEnemy = new WiseEnemy(new Position(0, 0), new Size(1, 1));
            StrongEnemy strongEnemy = new StrongEnemy(new Position(0, 0), new Size(1, 1));
            SuperiorEnemy superiorEnemy = new SuperiorEnemy(new Position(0, 0), new Size(1, 1));

            assertEquals(enemyShotGenerator.generateShot(oldEnemy).getClass(), WeakShot.class);
            assertEquals(enemyShotGenerator.generateShot(youngEnemy).getClass(), ImmatureShot.class);
            assertEquals(enemyShotGenerator.generateShot(wiseEnemy).getClass(), SlickShot.class);
            assertEquals(enemyShotGenerator.generateShot(strongEnemy).getClass(), PowerfulShot.class);
            assertEquals(enemyShotGenerator.generateShot(superiorEnemy).getClass(), LegendaryShot.class);
        } catch (IllegalArgumentException e) { e.printStackTrace(); }
    }
}
