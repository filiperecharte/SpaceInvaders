package com.spaceinvaders.modeltest;

import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.Ship;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class ArenaTest {
    private Ship mockShip;
    private Arena arena;
    @Before
    public void setUp() {
        mockShip = Mockito.mock(Ship.class);
        doThrow(NullPointerException.class).when(mockShip).setPosition(new Position(10,20));
        when(mockShip.getPosition()).thenReturn(new Position(10,20));
        arena= new Arena(10,15,"FFFFFF",mockShip);
    }

    @Test
    public void ArenaTestGets() {

        assertEquals(10, arena.getWidth());
        assertEquals(15,arena.getHeight());

    }

    @Test
    public void ArenaTestGetBack() {
        assertEquals("FFFFFF", arena.getBackgroundColor());

    }

    @Test
    public void ArenaTestSetBack() {
        arena.setBackgroundColor("#92a8d1");
        assertEquals("#92a8d1", arena.getBackgroundColor());

    }

    @Test
    public void ArenaTestCanMove() {
        assertFalse(arena.canMove(new Position(10, 20)));
        assertTrue(arena.canMove(new Position(4,8)));
        assertFalse(arena.canMove(new Position(-4,8)));
        assertFalse(arena.canMove(new Position(4,-8)));
        assertFalse(arena.canMove(new Position(10,15)));
    }

    @Test
    public void ArenaTestMoveShip() {
        arena.moveShipTo(new Position(10,20));

        assertEquals(10,arena.getShipPosition().getX());
        assertEquals(20,arena.getShipPosition().getY());
    }

}
