package com.spaceinvaders.controllertest;

import com.spaceinvaders.controller.EnemiesController;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.behaviors.MovableBehavior;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Vector;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class EnemiesControllerTest {
    private Arena mockArena;
    private List<Enemy> enemies;
    private List<Enemy> enemyMocks;
    private EnemiesController enemiesController;

    @Before
    public void setUp() {
        enemyMocks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Vector velocityMock = Mockito.mock(Vector.class);
            when(velocityMock.getX()).thenReturn(-i);
            when(velocityMock.getY()).thenReturn(2*i);

            Vector invertVelocityMock = Mockito.mock(Vector.class);
            when(invertVelocityMock.getX()).thenReturn(i);
            when(invertVelocityMock.getY()).thenReturn(-2*i);
            MovableBehavior movableBehavior = new MovableBehavior(invertVelocityMock);

            Enemy enemyMock = Mockito.mock(Enemy.class);
            when(enemyMock.getMovableBehavior()).thenReturn(movableBehavior);
            enemyMocks.add(enemyMock);
        }

        mockArena = Mockito.mock(Arena.class);

        when(mockArena.getEnemies()).thenReturn(enemies);

        when(mockArena.getEnemies()).thenReturn(enemyMocks);

        enemiesController = new EnemiesController();
        enemiesController.setArena(mockArena);
    }

    @Test
    public void invertEnemiesVelocityTest() {

        enemiesController.invertEnemiesVelocity();
        assertEquals(3, mockArena.getEnemies().get(3).getMovableBehavior().getVelocity().getX());
        assertEquals(-6, mockArena.getEnemies().get(3).getMovableBehavior().getVelocity().getY());

    }

    @Test
    public void enemiesNeedToInvertVelocityTest() {


        when(mockArena.getLeftMostEnemy()).thenReturn(enemyMocks.get(0));
        when(mockArena.getRightMostEnemy()).thenReturn(enemyMocks.get(enemyMocks.size() - 1));
        when(mockArena.contain(enemyMocks.get(0))).thenReturn(false);
        when(mockArena.contain(enemyMocks.get(enemyMocks.size() - 1))).thenReturn(true);

        assertTrue(enemiesController.enemiesNeedToInvertVelocity());

        when(mockArena.getLeftMostEnemy()).thenReturn(enemyMocks.get(0));
        when(mockArena.getRightMostEnemy()).thenReturn(enemyMocks.get(enemyMocks.size() - 1));
        when(mockArena.contain(enemyMocks.get(0))).thenReturn(true);
        when(mockArena.contain(enemyMocks.get(enemyMocks.size() - 1))).thenReturn(true);

        assertFalse(enemiesController.enemiesNeedToInvertVelocity());

    }

    @Test
    public void updateEnemyTest() {

        MovableBehavior movableBehaviorMock = Mockito.mock(MovableBehavior.class);
        when(movableBehaviorMock.getVelocity()).thenReturn(new Vector(1, 0));
        Enemy enemyMock = Mockito.mock(Enemy.class);
        when(enemyMock.getMovableBehavior()).thenReturn(movableBehaviorMock);
        when(enemyMock.getPosition()).thenReturn(new Position(15, 20));
        ArgumentCaptor<Position> finalEnemyPositionCapture = ArgumentCaptor.forClass(Position.class);
        doNothing().when(enemyMock).setPosition(finalEnemyPositionCapture.capture());

        enemiesController.updateEnemy(enemyMock);
        assertEquals(new Position(16, 20), finalEnemyPositionCapture.getValue());
    }
}