package com.spaceinvaders.controllertest;

import com.spaceinvaders.controller.ShotsController;
import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.behaviors.DamageBehavior;
import com.spaceinvaders.model.behaviors.HealthyBehavior;
import com.spaceinvaders.model.behaviors.MovableBehavior;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;
import com.spaceinvaders.model.pools.ShotPool;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.shots.Shot;
import com.spaceinvaders.model.shots.enemyshotvariants.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ShotsControllerTest {
    private Arena mockArena;
    private Arena arena;
    private List<Shot> shots;
    private ShotsController shotsController;

    @Before
    public void setUp() {
        shots = new ArrayList<>();

        shots.add(new WeakShot());
        shots.add(new ImmatureShot());
        shots.add(new SlickShot());
        shots.add(new PowerfulShot());
        shots.add(new LegendaryShot());

        mockArena = Mockito.mock(Arena.class);
        when(mockArena.getShots()).thenReturn(shots);

        arena = new Arena(new Position(0, 0), new Size(10, 10), "#000000");


        try{
            when(mockArena.getShip()).thenReturn(new Ship(new Position(15, 20), new Size(3, 1),new HealthyBehavior(10)));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        shotsController = new ShotsController(arena, new ShotPool());
    }

    @Test
    public void processShotsTest() {

        ShotsController shotsControllerSpy = Mockito.spy(shotsController);
        doNothing().when(shotsControllerSpy).updateShot(Mockito.any());
        doNothing().when(shotsControllerSpy).checkShotCollision(Mockito.any(), Mockito.any());
        doNothing().when(shotsControllerSpy).shotToPoolGroup(Mockito.any(),Mockito.any());

        shotsControllerSpy.processShots();

        verify(mockArena,times(mockArena.getShots().size())).contain((Position)Mockito.any());



    }

    @Test
    public void updateShotTest() {
        Shot testShot = null;
        try {
            testShot = new Shot(new Position(15, 20), new Size(3, 1), new MovableBehavior(new Vector(1,0)), new DamageBehavior(10));
        } catch(IllegalArgumentException e){
            e.printStackTrace();
        }
        assert testShot != null;

        shotsController.updateShot(testShot);

        assertEquals(16, testShot.getPosition().getX());
        assertEquals(20, testShot.getPosition().getY());

    }

    @Test
    public void generateEnemyShotTest() {
        Random mockRandom = new Random();
        when(mockRandom.nextInt()).thenReturn(15).thenReturn(3);

        ShotsController shotsControllerSpy = Mockito.spy(shotsController);
        when(shotsControllerSpy.makeRandom()).thenReturn(mockRandom).thenReturn(mockRandom);

        assertEquals(16, testShot.getPosition().getX());
        assertEquals(20, testShot.getPosition().getY());

    }

}
