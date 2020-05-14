package com.spaceinvaders.controllertest;

import com.spaceinvaders.controller.commands.shipcommands.ShootShipCommand;
import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.pools.ShotPoolGroup;
import com.spaceinvaders.model.ship.Ship;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShootShipCommandTest {
    private Arena mockArena;
    private Image imageMock;
    @Before
    public void setUp() {
        imageMock = Mockito.mock(Image.class);
        when(imageMock.getSize()).thenReturn(new Size(3, 1));

        mockArena = Mockito.mock(Arena.class);

        Ship ship =null;
        try {
            ship = new Ship(new Position(10, 10), new Size(3, 1), imageMock);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        assert  ship != null;

        when(mockArena.getShip()).thenReturn(ship);
    }

    @Test
    public void ShootTest() {
            ShootShipCommand shootShipCommand = new ShootShipCommand(mockArena, new ShotPoolGroup());
            shootShipCommand.execute();

            assertEquals(1, mockArena.getShots().size());
    }
}
