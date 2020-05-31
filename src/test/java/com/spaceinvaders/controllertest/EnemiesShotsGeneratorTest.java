package com.spaceinvaders.controllertest;

import com.spaceinvaders.controller.states.playstate.playstatecontrollers.EnemiesShotsGenerator;
import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.enemy.enemyvariants.OldEnemy;
import com.spaceinvaders.model.enemy.enemyvariants.SuperiorEnemy;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.pools.ShotPool;
import com.spaceinvaders.model.shots.Shot;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class EnemiesShotsGeneratorTest {
    private Arena arena;
    private EnemiesShotsGenerator enemiesShotsGenerator;

    @Before
    public void setUp() {
        ShotPool shotPoolMock = Mockito.mock(ShotPool.class);
        when(shotPoolMock.extract()).thenReturn(new Shot());

        arena = new Arena(new Position(0, 0), new Size(10, 10), "");
        enemiesShotsGenerator = new EnemiesShotsGenerator(arena, shotPoolMock);
    }

    @Test
    public void generateTest() {
        try {
            Enemy sup = new SuperiorEnemy(new Position(1, 1), new Size(3, 1));
            Enemy old = new OldEnemy(new Position(2, 2), new Size(5, 1));
            arena.addElement(sup);
            arena.addElement(old);
        } catch (IllegalArgumentException e) { e.printStackTrace(); }

        enemiesShotsGenerator.setEnemyIndex(1);
        enemiesShotsGenerator.setWhenToShoot(15);

        assertEquals(0, arena.getShots().size());
        enemiesShotsGenerator.generate();
        assertEquals(1, arena.getShots().size());
        assertEquals(1, arena.getShots().get(0).getDamageBehavior().getDamage());

        enemiesShotsGenerator.setEnemyIndex(0);
        enemiesShotsGenerator.setWhenToShoot(5);

        enemiesShotsGenerator.generate();
        assertEquals(2, arena.getShots().size());
        assertEquals(5, arena.getShots().get(1).getDamageBehavior().getDamage());
    }

    @Test
    public void enemyReadyToShootTest() {
        try {
            Enemy sup = new SuperiorEnemy(new Position(1, 1), new Size(3, 1));
            Enemy old = new OldEnemy(new Position(2, 2), new Size(5, 1));
            arena.addElement(sup);
            arena.addElement(old);
        } catch (IllegalArgumentException e) { e.printStackTrace(); }

        enemiesShotsGenerator.setEnemyIndex(0);
        enemiesShotsGenerator.setWhenToShoot(5);
        assertTrue(enemiesShotsGenerator.enemyReadyToShoot());

        enemiesShotsGenerator.setWhenToShoot(4);
        assertFalse(enemiesShotsGenerator.enemyReadyToShoot());
    }
}
