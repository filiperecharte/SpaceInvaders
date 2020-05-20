package com.spaceinvaders.controllertest;

import com.spaceinvaders.controller.ShotsController;
import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;
import com.spaceinvaders.model.pools.ShotPoolGroup;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.shots.EnemyShot;
import com.spaceinvaders.model.shots.Shot;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

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
        mockShotPoolGroup = Mockito.mock(ShotPoolGroup.class);

        when(mockArena.getShots()).thenReturn(shots);

        try{
            when(mockArena.getShip()).thenReturn(new Ship(new Position(15, 20), new Size(3, 1)));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        shotsController = new ShotsController(mockArena,new ShotPoolGroup());
    }

    @Test
    public void processShotsTest() {

      /*  ShotsController shotsControllerSpy = Mockito.spy(shotsController);
        doNothing().when(shotsControllerSpy).updateShot(Mockito.any());
        doNothing().when(shotsControllerSpy).checkShotCollision(Mockito.any(), Mockito.any());
        doNothing().when(shotsControllerSpy).shotToPoolGroup(Mockito.any(),Mockito.any());

        shotsController.processShots();

        verify(mockArena,times(mockArena.getShots().size()-1)).containPos(Mockito.any());
*/
    }

}
