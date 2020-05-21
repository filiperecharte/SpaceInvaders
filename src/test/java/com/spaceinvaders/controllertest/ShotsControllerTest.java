package com.spaceinvaders.controllertest;

import com.spaceinvaders.controller.ShotsController;
import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;
import com.spaceinvaders.model.pools.ShotPoolGroup;
import com.spaceinvaders.model.pools.shotpools.EnemyShotPool;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.shots.EnemyShot;
import com.spaceinvaders.model.shots.Shot;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ShotsControllerTest {
    private Arena mockArena;
    private ShotPoolGroup mockShotPoolGroup;
    private List<Shot> shots;
    private ShotsController shotsController;

    @Before
    public void setUp() {
        shots = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            shots.add(new EnemyShot());
        }

        mockArena = Mockito.mock(Arena.class);
        when(mockArena.getShots()).thenReturn(shots);
        try{
            when(mockArena.getShip()).thenReturn(new Ship(new Position(15, 20), new Size(3, 1)));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        mockShotPoolGroup = Mockito.mock(ShotPoolGroup.class);

        shotsController = new ShotsController(mockArena,new ShotPoolGroup());
    }
    
    @Test
    public void processShotsTest() {

        ShotsController shotsControllerSpy = Mockito.spy(shotsController);
        doNothing().when(shotsControllerSpy).updateShot(Mockito.any());
        doNothing().when(shotsControllerSpy).checkShotCollision(Mockito.any(), Mockito.any());
        doNothing().when(shotsControllerSpy).shotToPoolGroup(Mockito.any(),Mockito.any());

        shotsControllerSpy.processShots();

        verify(mockArena,times(mockArena.getShots().size())).containPos(Mockito.any());
    }

    @Test
    public void updateShotTest() {
        Shot testShot = new Shot(new Position(15, 20), new Size(3, 1), new Vector(1, 0),10);

        shotsController.updateShot(testShot);

        assertEquals(16, testShot.getPosition().getX());
        assertEquals(20, testShot.getPosition().getY());

    }

    @Test
    public void generateEnemyShotTest() {
        /*Random mockRandom = new Random();
        when(mockRandom.nextInt()).thenReturn(15).thenReturn(3);

        ShotsController shotsControllerSpy = Mockito.spy(shotsController);
        when(shotsControllerSpy.makeRandom()).thenReturn(mockRandom).thenReturn(mockRandom);

        List<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            try {
                enemies.add(new Enemy(new Position(15, i), new Size(3, 1), new Vector(1, 0)));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        when(mockShotPoolGroup.getEnemyShotPool()).thenReturn(new EnemyShotPool());

        when(mockArena.getEnemies()).thenReturn(enemies);


        assertEquals(16, testShot.getPosition().getX());
        assertEquals(20, testShot.getPosition().getY());*/

    }

}
