package com.spaceinvaders.modeltest;

import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.geometry.Size;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class ArenaTest {
    private Arena arena;
    @Before
    public void setUp() {
        Ship mockShip = Mockito.mock(Ship.class);
        doThrow(NullPointerException.class).when(mockShip).setPosition(new Position(10,20));
        when(mockShip.getPosition()).thenReturn(new Position(10,20));

        arena= new Arena(new Position(0, 0), new Size(10, 15));
        arena.addElement(mockShip);
    }

    @Test
    public void ArenaTestCanMove() {
        assertFalse(arena.canMove(new Position(10, 20)));
        assertTrue(arena.canMove(new Position(4,8)));
        assertFalse(arena.canMove(new Position(-4,8)));
        assertFalse(arena.canMove(new Position(4,-8)));
        assertFalse(arena.canMove(new Position(10,15)));
    }
}
