package com.spaceinvaders.controllertest;

import com.spaceinvaders.controller.EnemiesController;
import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class EnemiesControllerTest {
    private Arena mockArena;
    private List<Enemy> enemies;
    private EnemiesController enemiesController;

    @Before
    public void setUp() {
        enemies = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            try {
                enemies.add(new Enemy(new Position(15, i), new Size(3, 1), new Vector(1, 0)));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        mockArena = Mockito.mock(Arena.class);

        when(mockArena.getEnemies()).thenReturn(enemies);

        enemiesController = new EnemiesController(mockArena);
    }

    @Test
    public void invertEnemiesVelocityTest() {

        enemiesController.invertEnemiesVelocity();

        assertEquals(-1, mockArena.getEnemies().get(3).getVelocity().getX());
        assertEquals(0, mockArena.getEnemies().get(3).getVelocity().getY());

    }

    @Test
    public void enemiesNeedToInvertVelocityTest() {

        when(mockArena.getLeftMostEnemy()).thenReturn(enemies.get(0));
        when(mockArena.getRightMostEnemy()).thenReturn(enemies.get(enemies.size() - 1));
        when(mockArena.containBox(enemies.get(0))).thenReturn(false);
        when(mockArena.containBox(enemies.get(enemies.size() - 1))).thenReturn(true);

        assertTrue(enemiesController.enemiesNeedToInvertVelocity());

        when(mockArena.getLeftMostEnemy()).thenReturn(enemies.get(0));
        when(mockArena.getRightMostEnemy()).thenReturn(enemies.get(enemies.size() - 1));
        when(mockArena.containBox(enemies.get(0))).thenReturn(true);
        when(mockArena.containBox(enemies.get(enemies.size() - 1))).thenReturn(true);

        assertFalse(enemiesController.enemiesNeedToInvertVelocity());

    }

    @Test
    public void updateEnemyTest() {
        Enemy testEnemy = null;
        try {
            testEnemy = new Enemy(new Position(15, 20), new Size(3, 1), new Vector(1, 0));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        assert testEnemy != null;

        enemiesController.updateEnemy(testEnemy);

        assertEquals(16, testEnemy.getPosition().getX());
        assertEquals(20, testEnemy.getPosition().getY());

    }
}
