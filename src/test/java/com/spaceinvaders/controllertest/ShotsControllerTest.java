package com.spaceinvaders.controllertest;

import com.spaceinvaders.controller.states.playstate.playstatecontrollers.ShotsController;
import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.enemy.enemyvariants.*;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.wall.Fragment;
import com.spaceinvaders.model.wall.Wall;
import org.junit.Before;

public class ShotsControllerTest {
    ShotsController shotsController;

    @Before
    public void setUp() {
        /*Arena arena = new Arena(new Position(0, 0), new Size(10, 10), "#000000");
        try {
            arena.addElement(new WeakShot());
            arena.addElement(new YoungEnemy(new Position(3, 2), new Size(2, 1)));
            arena.addElement(new WiseEnemy(new Position(5, 2), new Size(2, 1)));
            arena.addElement(new StrongEnemy(new Position(7, 2), new Size(2, 1)));
            arena.addElement(new SuperiorEnemy(new Position(9, 2), new Size(2, 1)));

            Wall wall = new Wall(new Position(5, 5));
            wall.addFragment(new Fragment(new Position(5, 5), new Size(1, 1)));
            arena.addElement(wall);

            //arena.addElement(new Ship(new Position 8, 8));
        } catch (IllegalArgumentException e) { e.printStackTrace(); }

        ShotPool shotPool = new ShotPool();

        shotsController = new ShotsController(arena, shotPool);*/
    }

    /*@Test
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

    }*/

}
